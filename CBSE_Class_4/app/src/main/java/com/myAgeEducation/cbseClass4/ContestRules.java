package com.myAgeEducation.cbseClass4;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Timer;
import java.util.TimerTask;

public class ContestRules extends Activity {
    ObjectAnimator animation;
    Timer timer = new Timer();
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contest_rules);
        progressBar = findViewById(R.id.progressBar);

        if(TextUtils.isEmpty(Util.ContestRules)) {
            GetContestRules();
        }
        else
        {
            TextView textView = findViewById(R.id.textViewContestRules);
            textView.setText(Html.fromHtml(Util.ContestRules));
            progressBar.setVisibility(View.GONE);
            findViewById(R.id.textViewWaiting).setVisibility(View.GONE);
        }
        animateProgressBar();
        addTimer();
        addBannerAd();
    }

    private void addBannerAd()
    {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    private void animateProgressBar() {

        animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 500); // see this max value coming back here, we animate towards that value
        animation.setDuration(2000); // in milliseconds
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }

    public void onClickButtonOk(View view)
    {
        finish();
    }

    public void addTimer()
    {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        progressBar.clearAnimation();
                        animateProgressBar();
                    }
                });
            }
        }, 0, 2000);
    }

    public void GetContestRules()
    {
        Util.ContestRules = "";
        Firebase.goOnline();
        Firebase ref = new Firebase(Util.ContestRoot + "/misc/contest_rules");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                timer.cancel();
                progressBar.setVisibility(View.GONE);

                Firebase.goOffline();
                if(snapshot.getValue() == null)
                {
                    TextView textView = findViewById(R.id.textViewWaiting);
                    textView.setText("Rules could not be retrieved from the server");
                    textView.setVisibility(View.VISIBLE);
                    return;
                }
                else
                {
                    findViewById(R.id.textViewWaiting).setVisibility(View.GONE);
                    Util.ContestRules = snapshot.getValue().toString();
                    TextView textView = findViewById(R.id.textViewContestRules);
                    textView.setText(Html.fromHtml(Util.ContestRules));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Firebase.goOffline();
                Log.d("CBSE_Exception: ", firebaseError.getMessage());
            }
        });
    }
}
