package com.myAgeEducation.cbseClass4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.AdError;
import androidx.annotation.NonNull;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ContestChapters extends Activity {
    private ArrayList<Question> _questionList = new ArrayList<>();
    private InterstitialAd mInterstitialAd;
    ArrayList<Integer> contestChapters = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contest_chapters);

        SetLabel();

        getChaptersForTheContest();

        addInterstitialAd();
        addBannerAd();
    }

    private void getChaptersForTheContest()
    {
        String[] temp = Util.ContestChapters.split(";");
        for(int i = 0; i < temp.length; i += 2)
        {
            contestChapters.add(Integer.parseInt(temp[i]));
        }
    }

    private void SetLabel()
    {
        ((TextView)findViewById(R.id.textViewSubject)).setText("Subject: " + Util.Subject);

        String topics = "";
        String[] temp = Util.ContestChapters.split(";");
        for(int i =1; i < temp.length ; i+=2)
        {
            if(i == temp.length - 1)
            {
                topics = topics + temp[i];
            }
            else
            {
                topics = topics + temp[i] + ", ";
            }
        }

        TextView textView = findViewById(R.id.textViewContestTopics);
        textView.setText(topics);

        String s = "Questions\n" + String.valueOf(Util.QuestionCountForContest);
        SpannableString ss1=  new SpannableString(s);
        ss1.setSpan(new RelativeSizeSpan(5f), 10,12, 0); // set size
        TextView tv= findViewById(R.id.textViewQuestionCount);
        tv.setText(ss1);

        s = "Duration\n" + String.valueOf(Util.TestTimeOut) + "\nminutes";
        ss1=  new SpannableString(s);
        ss1.setSpan(new RelativeSizeSpan(4f), 9,11, 0); // set size
        tv= findViewById(R.id.textViewTestDuration);
        tv.setText(ss1);

        int attemptLeft = 10 - ((PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get(Util.Subject)).getAttempts();
        s = "Attempt Left\n" + String.valueOf(attemptLeft);
        int startPos = 0;
        int endPos = 0;

        if(attemptLeft < 10)
        {
            startPos = 13;
            endPos = 14;
        }
        else
        {
            startPos = 13;
            endPos = 15;
        }

        ss1=  new SpannableString(s);
        ss1.setSpan(new RelativeSizeSpan(5f), startPos,endPos, 0);
        tv = findViewById(R.id.textViewAttempt);
        tv.setText(ss1);

        //int lastScore = Util.testAttemptDetails.getLastAttemptScore();
        int lastScore = ((PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get(Util.Subject)).getLastAttemptScore();
        String lastScoreString;
        if(lastScore == -1)
        {
            lastScoreString = "NA";
            s = "Last Score\nNA";
        }
        else {
            lastScoreString = String.valueOf(lastScore);
            s = "Last Score\n" + String.valueOf(lastScore);
        }

        ss1=  new SpannableString(s);
        if(lastScoreString.length() > 1)
        {
            startPos = 11;
            endPos = 13;
        }
        else
        {
            startPos = 11;
            endPos = 12;
        }
        ss1.setSpan(new RelativeSizeSpan(5f), startPos,endPos, 0); // set size
        tv = findViewById(R.id.textViewLastScore);
        tv.setText(ss1);

        if(Util.IsMockTest)
        {
            TextView textViewMockTest = findViewById(R.id.textViewMockTestNote);
            textViewMockTest.setText(Util.ReasonForMockTest);
            textViewMockTest.setVisibility(View.VISIBLE);

            Button button = findViewById(R.id.buttonStartTest);
            button.setText("Start Mock Test");
        }
    }

    public void onClickStartTest(View view)
    {
        //if(Util.testAttemptDetails.getAttempts() >= 10)
        int totalAttempts = ((PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get(Util.Subject)).getAttempts();
        if(totalAttempts >= 10)
        {
            Util.displayAlert("You have no attempt left", "No attempt Left", this);
            return;
        }

        // lets get the date-month to check if the contest is open
        Firebase.goOnline();
        Log.d("Server_Time", "Getting Server Time");
        DatabaseReference offsetRef = FirebaseDatabase.getInstance().getReference(".info/serverTimeOffset");
        offsetRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot snapshot) {
                Firebase.goOffline();
                double offset = snapshot.getValue(Double.class);
                Util.ServerTime = System.currentTimeMillis() + offset;

                //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                long temp = (new Double(Util.ServerTime)).longValue();
                Date resultDate = new Date(temp);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultDate);
                int date = calendar.get(Calendar.DATE);

                /*if(date >= 10)
                {
                    findViewById(R.id.textViewMockTestNote).setVisibility(View.INVISIBLE);
                }
                else
                {
                    Util.IsContestTest = true;
                    findViewById(R.id.textViewMockTestNote).setVisibility(View.VISIBLE);
                    Button button = findViewById(R.id.buttonStartTest);
                    button.setText(getString(R.string.start_mock_test));
                    //SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
                    //Util.displayAlert("Contest for the month " + sdf.format(resultDate) + " is not yet opened", "Contest not started", ContestChapters.this);
                }*/

                int set = Util.getRandomQuestionSet();
                String questionSet = "set" + String.valueOf(set);
                //downloadQuestions(Util.SubjectRoot + "/" + Util.Subject + "/" + questionSet);
                downloadQuestions(Util.Subject + "/" + questionSet);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //System.err.println("Listener was cancelled");
            }
        });

    }

    public void downloadQuestions(final String downloadLink)
    {
        Firebase.goOnline();
        showProgressDialog();
        Firebase ref = new Firebase(downloadLink);
        Query queryRef = ref.orderByChild("chapter").startAt(contestChapters.get(0)).endAt(contestChapters.get(contestChapters.size()-1));
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Firebase.goOffline();
                try {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        try {
                            Question question = postSnapshot.getValue(Question.class);
                            _questionList.add(question);
                        } catch (Exception e) {
                            Log.d("CBSE_ERROR", e.getMessage());
                        }
                    }

                    Log.d("CBSE_", String.valueOf(_questionList.size()) + " were downloaded");

                    if (_questionList.size() > 0) {
                        Util.allQuestions = (ArrayList<Question>) _questionList.clone();

                    } else {
                        Util.allQuestions.clear();
                        dismissProgressDialog();
                        Util.displayAlert("No questions available for this subject", "Questions not available", ContestChapters.this);
                        return;
                    }

                    dismissProgressDialog();

                    //Random random = new Random();
                    //_randomQuestionSet = random.nextInt(9);
                    //openChapters("set" + String.valueOf(11));
                    openTestActivity();
                }
                catch(Exception e)
                {
                    Util.displayAlert(e.getMessage(), "ERROR_SUB_589", ContestChapters.this);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.d("Exception: ", firebaseError.getMessage());
            }
        });

    }

    private void openTestActivity()
    {
        QuestionPage.QuestionList = Util.filterQuestions(contestChapters);

        Intent testPage = new Intent();
        testPage.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".QuestionPage");
        int questionCount = Util.QuestionCountForContest;
        testPage.putExtra("questionCount", questionCount);
        testPage.putExtra("isRevision", "false");
        testPage.putExtra("isExit", "false");
        testPage.putExtra("recover_mode", false);

        testPage.putStringArrayListExtra("wrongAns_list", null);
        testPage.putIntegerArrayListExtra("used_numbers", null);

        startActivity(testPage);
        finish();

        if(Util.isFreeApp)
        {
            showInterstitialAdAd();
        }
    }

    private void addBannerAd()
    {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    private void addInterstitialAd()
    {
        String adUnitId = Util.isReleaseVersion ? Util.AdMobInterstitialAdUnitId : Util.AdMobInterstitialAdUnitDummyId;

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        InterstitialAd.load(this, adUnitId, adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        Util.isFullPageAdDisplayed = false;
                        mInterstitialAd = null;
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                        Util.isFullPageAdDisplayed = false;
                        mInterstitialAd = null;
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        Util.isFullPageAdDisplayed = true;
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd = null;
            }
        });
    }

    private void showInterstitialAdAd()
    {
        if (mInterstitialAd != null)
        {
            mInterstitialAd.show(this);
        }
    }

    private void showProgressDialog()
    {
        findViewById(R.id.progressBar2).setVisibility(View.VISIBLE);
        findViewById(R.id.textViewWaiting).setVisibility(View.VISIBLE);
    }

    private void dismissProgressDialog()
    {
        findViewById(R.id.progressBar2).setVisibility(View.INVISIBLE);
        findViewById(R.id.textViewWaiting).setVisibility(View.INVISIBLE);
    }
}
