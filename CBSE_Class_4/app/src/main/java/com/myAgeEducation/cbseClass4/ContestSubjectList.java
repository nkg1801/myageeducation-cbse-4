package com.myAgeEducation.cbseClass4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.myAgeEducation.cbsecommon.Question;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ContestSubjectList extends Activity {

    private ArrayList<Question> _questionList = new ArrayList<>();
    SharedPreferences _sharedPreferences;
    int _mathScore, _scienceScore, _gkScore, _computersScore;
    boolean _isOnlyGetUserScore = false;
    boolean _scoreRetrievedFromCloud = false;

    final int START_TEST = 1;
    final int GET_ONLY_SCORE = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contest_subject_list);
        addBannerAd();
        setLabel();
        _sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Util.getServerTime();
    }

    private void addBannerAd()
    {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        setLabel(); //after the test is taken, the score for the subject would have changed, so printing the new score
    }

    public void ReadContestChapters()
    {
        Firebase.goOnline();
        Firebase ref = new Firebase(Util.ContestClassRoot + "/" + Util.ServerTimeInMonth + "/contest_details/chapters/" + Util.Subject);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Firebase.goOffline();
                dismissProgressDialog();
                if(snapshot.getValue() == null)
                {
                    Util.displayAlert("Contest for this month is not yet opened", "Contest not yet open", ContestSubjectList.this);
                    return;
                }
                Util.ContestChapters = snapshot.getValue().toString();
                openContestChaptersActivity();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                dismissProgressDialog();
                Log.d("CBSE_Exception: ", firebaseError.getMessage());
            }
        });
    }

    private void setLabel()
    {
        int totalScore = 0;
        String mathsButtonLabel;
        String scienceButtonLabel;
        String computersButtonLabel;
        String gkButtonLabel;

        if(_scoreRetrievedFromCloud)
        {
            int mathScore = ((PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get("maths")).getLastAttemptScore();
            int scienceScore = ((PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get("science")).getLastAttemptScore();
            int computersScore = ((PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get("computers")).getLastAttemptScore();
            int gkScore = ((PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get("gk")).getLastAttemptScore();

            String temp;

            if(mathScore == -1) {
                temp = "<br>Score: NA";
            }
            else
            {
                temp = "<br>Score: " + String.valueOf(mathScore);
                totalScore += mathScore;
            }

            temp = Util.ServerTimeInMonth + "<br>" + temp;

            mathsButtonLabel = "<center><strong>Maths</strong><br>" + temp + "</center>";

            if(scienceScore == -1) {
                temp = "<br>Score: NA";
            }
            else
            {
                temp = "<br>Score: " + String.valueOf(scienceScore);
                totalScore += scienceScore;
            }

            temp = Util.ServerTimeInMonth + "<br>" + temp;
            scienceButtonLabel = "<center><strong>Science</strong><br>" + temp + "</center>";

            if(computersScore == -1)
            {
                temp = "<br>Score: NA";
            }
            else
            {
                temp = "<br>Score: " + String.valueOf(computersScore);
                totalScore += computersScore;
            }

            temp = Util.ServerTimeInMonth + "<br>" + temp;

            computersButtonLabel = "<center><strong>Computers</strong><br>" + temp + "</center>";

            if(gkScore == -1)
            {
                temp = "<br>Score: NA";
            }
            else
            {
                temp = "<br>Score: " + String.valueOf(gkScore);
                totalScore += gkScore;
            }

            temp = Util.ServerTimeInMonth + "<br>" + temp;

            gkButtonLabel = "<center><strong>GK</strong><br>" + temp + "</center>";
        }
        else
        {
            mathsButtonLabel = "<center><h4>Maths</h4></center>";
            scienceButtonLabel = "<center><h4>Science</h4></center>";
            computersButtonLabel = "<center><h4>Computers</h4></center>";
            gkButtonLabel = "<center><h4>GK</h4></center>";
        }

        Button buttonMaths = findViewById(R.id.buttonMaths);
        buttonMaths.setText(Html.fromHtml(mathsButtonLabel));

        Button buttonScience = findViewById(R.id.buttonScience);
        buttonScience.setText(Html.fromHtml(scienceButtonLabel));

        Button buttonComputers = findViewById(R.id.buttonComputers);
        buttonComputers.setText(Html.fromHtml(computersButtonLabel));

        Button buttonGk = findViewById(R.id.buttonGk);
        buttonGk.setText(Html.fromHtml(gkButtonLabel));

        TextView textViewTotalScore = findViewById(R.id.textViewTotalScore);
        textViewTotalScore.setText("Total Score: " + String.valueOf(totalScore) + "/100");
    }

    //private FirebaseAuth auth;
    private void LoginAndGetTestAttemptDetails(String subject)
    {
        //auth = FirebaseAuth.getInstance();
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //if(user == null)
        if(!Util.IsUserSignedIn)
        {
            // Check if already logged in, if not display login form
            Intent intentLogin = new Intent(ContestSubjectList.this, LoginSignupActivity.class);
            startActivityForResult(intentLogin, START_TEST);
        }
        else
        {
            //Util.UserUid = user.getUid();
            getUserScoreForAllSubjects();
        }
    }

    public void onClickButtonScience(View view)
    {
        Util.Subject = "science";
        _isOnlyGetUserScore = false;
        LoginAndGetTestAttemptDetails(Util.Subject);
    }

    public void onClickButtonMaths(View view)
    {
        Util.Subject = "maths";
        _isOnlyGetUserScore = false;
        LoginAndGetTestAttemptDetails(Util.Subject);
    }

    public void onClickButtonComputers(View view)
    {
        Util.Subject = "computers";
        _isOnlyGetUserScore = false;
        LoginAndGetTestAttemptDetails(Util.Subject);
    }

    public void onClickButtonGk(View view)
    {
        Util.Subject = "gk";
        _isOnlyGetUserScore = false;
        LoginAndGetTestAttemptDetails(Util.Subject);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case START_TEST:
                    getUserScoreForAllSubjects();
                    break;
                case GET_ONLY_SCORE:
                    getUserScoreForAllSubjects();
                    break;

                default:
                    break;
            }
        }
    }

    private void openContestChaptersActivity()
    {
        if(!Util.IsMockTest) {
            Util.IsContestTest = true;
        }
        else
        {
            Util.IsContestTest = false;
        }
        Intent contestChapterActivity = new Intent(ContestSubjectList.this, ContestChapters.class);
        startActivity(contestChapterActivity);
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

    public void onClickButtonGetMyScore(View view)
    {
        _isOnlyGetUserScore = true;
        if(!Util.IsUserSignedIn) {
            // Check if already logged in, if not display login form
            Intent intentLogin = new Intent(ContestSubjectList.this, LoginSignupActivity.class);
            startActivityForResult(intentLogin, GET_ONLY_SCORE);
        }
        else
        {
            //user already signed in, get his score
            getUserScoreForAllSubjects();
        }
    }

    public void getUserScoreForAllSubjects()
    {
        ReadTestAttemptDetailsForAllSubjects();
    }

    public void ReadTestAttemptDetailsForAllSubjects()
    {
        showProgressDialog();

        final TextView textView = findViewById(R.id.textViewContestSubjects);

        textView.setText("Checking Server time, please wait...");

        // wait till we get the server time retrieved frm the server, it was started in ContestFirstPage onCreate
        while(TextUtils.isEmpty(Util.ServerTimeInMonth))
        {
            try {
                Thread.sleep(20);
            }
            catch (Exception e)
            {
            }
        }

        // get the contest beging date (10-Dec-2018)

        textView.setText("Checking Contest details, please wait...");

        Firebase.goOnline();

        Firebase ref = new Firebase(Util.ContestRoot + "/misc/start_date");
        ref.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot snapshot) {

                if(snapshot.getValue() == null)
                {
                    Util.IsMockTest = true;
                }
                else
                {
                    String[] temp = snapshot.getValue().toString().split(";");
                    String startDate = temp[0];
                    int beginDay = Integer.parseInt(temp[1]);
                    int endDay = Integer.parseInt(temp[2]);
                    Util.QuestionCountForContest = Integer.parseInt(temp[3]);
                    Util.TestTimeOut = Integer.parseInt(temp[4]);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                    try {
                        Date contestStartDate = dateFormat.parse(startDate);
                        if(Util.ServerDate.getTime() < contestStartDate.getTime())
                        {
                            Util.IsMockTest = true;
                            Util.ReasonForMockTest = "Contest not yet started. Contest starting on " + startDate + ". Mock Test is enabled for you for preparation for the Contest";
                        }
                        else if(Util.CurrentDate < beginDay || Util.CurrentDate > endDay)
                        {
                            Util.IsMockTest = true;
                            Util.ReasonForMockTest = "Contest of the month has ended. Contest started on " + temp[1] + " and ended on " + temp[2] + " day of the month. Mock test is enabled for you for preparation of the next Contest";
                        }
                        Log.d("CBSE_3", String.valueOf(contestStartDate.getTime()));
                        Log.d("CBSE_3", String.valueOf(Util.ServerDate.getTime()));
                    }
                    catch(Exception exception)
                    {
                        textView.setText("Error: " + exception.getMessage() + ". Please try after sometime");
                    }
                }

                textView.setText("Getting your past scores, please wait...");
                String firebasePath = Util.ContestClassRoot + "/" + Util.ServerTimeInMonth + "/contest_details_users/" + Util.UserUid;
                Firebase ref1 = new Firebase(firebasePath);
                ref1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        textView.setText("Choose the subject");
                        dismissProgressDialog();
                        _scoreRetrievedFromCloud = true;

                        Util.SubjectTestAttemptDetailsMaps.clear();
                        for(DataSnapshot data : snapshot.getChildren())
                        {
                            PojoTestAttemptDetails temp = data.getValue(PojoTestAttemptDetails.class);
                            Util.SubjectTestAttemptDetailsMaps.put(data.getKey(), temp);
                        }
                        if(!Util.SubjectTestAttemptDetailsMaps.containsKey("maths"))
                        {
                            Util.SubjectTestAttemptDetailsMaps.put("maths", new PojoTestAttemptDetails());
                        }
                        if(!Util.SubjectTestAttemptDetailsMaps.containsKey("science"))
                        {
                            Util.SubjectTestAttemptDetailsMaps.put("science", new PojoTestAttemptDetails());
                        }
                        if(!Util.SubjectTestAttemptDetailsMaps.containsKey("computers"))
                        {
                            Util.SubjectTestAttemptDetailsMaps.put("computers", new PojoTestAttemptDetails());
                        }
                        if(!Util.SubjectTestAttemptDetailsMaps.containsKey("gk"))
                        {
                            Util.SubjectTestAttemptDetailsMaps.put("gk", new PojoTestAttemptDetails());
                        }

                        setLabel();

                        if(!_isOnlyGetUserScore) {
                            ReadContestChapters();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        dismissProgressDialog();
                        TextView textView = findViewById(R.id.textViewContestSubjects);
                        textView.setText(firebaseError.getMessage());
                        Log.d("CBSE_Exception: ", firebaseError.getMessage());
                    }
                });
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                TextView textView = findViewById(R.id.textViewContestSubjects);
                textView.setText(firebaseError.getMessage());
                Log.d("CBSE_Exception: ", firebaseError.getMessage());
            }
        });
    }
}
