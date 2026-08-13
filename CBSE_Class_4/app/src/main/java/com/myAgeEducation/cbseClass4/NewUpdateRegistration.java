package com.myAgeEducation.cbseClass4;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class NewUpdateRegistration extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_update_registration);
        addBannerAd();
    }

    private void addBannerAd()
    {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    public void onClickNewRegistration(View view)
    {
        Intent intentRegistration = new Intent(NewUpdateRegistration.this, Registration.class);
        startActivity(intentRegistration);
        finish();
    }

    public void onClickUpdateRegistration(View view)
    {
        Intent intentLogin = new Intent(NewUpdateRegistration.this, LoginSignupActivity.class);
        startActivityForResult(intentLogin, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case 1:
                    Intent intentRegistration = new Intent(NewUpdateRegistration.this, UpdateRegistration.class);
                    startActivity(intentRegistration);
                    finish();
                    break;

                default:
                    break;
            }
        }
    }

    private void getUserDetails()
    {
        Firebase ref = new Firebase(Util.ContestUserRoot + "/" + Util.UserUid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                PojoUserDetails userDetails = snapshot.getValue(PojoUserDetails.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                //dismissProgressDialog();
                Log.d("CBSE_Exception: ", firebaseError.getMessage());
            }
        });
    }
}
