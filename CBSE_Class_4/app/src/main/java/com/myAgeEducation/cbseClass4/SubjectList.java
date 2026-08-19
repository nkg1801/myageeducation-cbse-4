package com.myAgeEducation.cbseClass4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ShareActionProvider;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.myAgeEducation.cbseClass4.maths.additions.AdditionStoryQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.charts.BarChartQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.circlegraph.CircleGraphQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.divisions.facts.DivisionFactQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.divisions.facts.DivisionPictureQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.divisions.story.DivisionStoryQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.factors.FactorQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.multiples.MultipleQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.multiplication.MultiplicationStoryQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.arrangedigits.ArrangeDigitsQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.arrangenumbers.ArrangeNumbersDataGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.arrangenumbers.ArrangeNumbersQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.greatestsmallest.GreatestSmallestQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.missingvalue.MissingPlaceValueQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison.ComparisonSymbolQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison.NumberComparisonQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.numberorder.NumberOrderQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.numberword.NumberWordsQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.pictograph.PictographQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.digitplace.DigitPlaceValueQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.placevalue.standardform.StandardFormQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.shapes.ShapesQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.subtractions.SubtractionFactQuestionGenerator;
import com.myAgeEducation.cbseClass4.maths.subtractions.SubtractionStoryQuestionGenerator;
import com.myAgeEducation.cbseClass4.questionpaper.PdfQuestion;
import com.myAgeEducation.cbsecommon.AdData;
import com.myAgeEducation.cbsecommon.Question;

public class SubjectList extends Activity
{
    private ShareActionProvider mShareActionProvider;
    private static final int SUBJECT_INDEX = 0;
    private static final int QUESTION_SET_INDEX = 1;
	int _randomQuestionSet;
    DatabaseHelper _databaseHelper;
    int _cloudVersion = 0;
    private ArrayList<String> _downloadLinks = new ArrayList<>();
    private ArrayList<String> _pendingDownloads = new ArrayList<>();
    private ArrayList<Question> _questionList = new ArrayList<>();

	ListView _listView;
    ProgressDialog ringProgressDialog;
    private SharedPreferences _sharedPreferences;
    private boolean isAddToLocalDatabaseCompleted = true;
    private Runnable runnable;
    private Handler handler = new Handler();
    private boolean runnableStarted = false;

	final int SCIENCE = 0;
    final int MATHS = 1;
    final int COMPUTERS = 2;
    final int GK = 3;
    final int SCORE = 4;
    final int SHARE_APP_LINK = 5;
    final int APP_RATING = 6;
    final int GETMORE = 7;
    final int EXIT = 8;

    @Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subject_list);
        FirebaseApp.initializeApp(this);
        _listView = findViewById(android.R.id.list);
        _sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ringProgressDialog = new ProgressDialog(SubjectList.this);

        try {
            // this is the first time the database is opened.
            openDatabase();
        }
        catch(Exception e)
        {
            Util.displayAlert("Error-SUB-001: " + e.getMessage(), "ERROR-SUB-001", SubjectList.this);
        }

        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case SCIENCE:
                        Util.Subject = "science";
                        break;

                    case MATHS:
                        Util.Subject = "maths";
                        break;

                    case COMPUTERS:
                        Util.Subject = "computers";
                        break;

                    case GK:
                        Util.Subject = "gk";
                        break;

                    case SCORE:
                        Util.Subject = "";
                        Intent subPage = new Intent();
                        subPage.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".ScoreHistory");
                        startActivity(subPage);
                        break;

                    case SHARE_APP_LINK:
                        Util.Subject = "";
                        shareAppLink();
                        //saveIfShareButtonClicked();
                        break;

                    case APP_RATING:
                        Util.Subject = "";
                        openPlayStoreForRating();
                        break;

                    case GETMORE:
                        Util.Subject = "";
                        Intent intentGetMore = new Intent(SubjectList.this, GetMore.class);
                        startActivity(intentGetMore);
                        break;

                    case EXIT:
                        Util.Subject = "";
                        finish();
                        break;

                    default:
                        break;
                }

                if (!Util.Subject.isEmpty())
                {
                    GetDatabaseLocation();
                }
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        List<String> testDeviceIds = Arrays.asList("750a657019b49e621c42ce9a20c2cc30");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);

        populateAdapter();

        addBannerAd();
		findViewById(R.id.adView).setVisibility(View.VISIBLE);
		findViewById(R.id.openPlaystore).setVisibility(View.GONE);

        if(Util.AdDetail == null) {
            FirebaseManager.readAds(new FirebaseCallback() {
                @Override
                public void onCallback(String value) {
                }
            });
        }
	}

    @Override
    public void onStop()
    {
        if(runnableStarted) {
            handler.removeCallbacks(runnable);
        }
        super.onStop();
    }

    private boolean isLastAccessToday()
    {
        String lastAccessDate = _sharedPreferences.getString("LastAccessDate", "");
        String todaysDate = Util.getCurrentDate();

        if(lastAccessDate.compareToIgnoreCase(todaysDate) == 0)
        {
            Log.d("CBSE_", "last access was today");
            return true;
        }
        Log.d("CBSE_", "last access was not today");
        saveLastAccessDate(todaysDate);
        return false;
    }

    private int GetLocallySavedCloudVersion()
    {
        int cloudVersion = _sharedPreferences.getInt("CloudVersion", 0);
        return cloudVersion;
    }

    private void saveLastAccessDate(String todaysDate)
    {
        SharedPreferences.Editor prefEdit = _sharedPreferences.edit();
        prefEdit.putString("LastAccessDate", todaysDate);
        prefEdit.apply();
    }

    private void saveLastCloudVersion(int cloudVersion)
    {
        SharedPreferences.Editor prefEdit = _sharedPreferences.edit();
        prefEdit.putInt("CloudVersion", cloudVersion);
        prefEdit.apply();
    }

	private void addBannerAd()
	{
		/*AdView mAdView = findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder()
				.build();
		mAdView.loadAd(adRequest);*/

        AdView adView = findViewById(R.id.adView);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.d("BANNER_TEST", "Banner loaded");
                Log.d("BANNER_TEST",
                        "Size: " + adView.getWidth() + " x " + adView.getHeight());
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError error) {
                Log.e("BANNER_TEST",
                        "Failed: "
                                + error.getCode()
                                + " "
                                + error.getMessage());
            }

            @Override
            public void onAdImpression() {
                Log.d("BANNER_TEST", "Banner impression");
            }

            @Override
            public void onAdClicked() {
                Log.d("BANNER_TEST", "Banner clicked");
            }
        });

        adView.loadAd(new AdRequest.Builder().build());
	}

	private void openDatabase()
	{
		_databaseHelper = new DatabaseHelper(getApplicationContext());
		try
		{
			_databaseHelper.createDataBase();
		}
		catch(IOException e)
        {
            Log.d("CBSE_ERROR_OPENDATABASE", Objects.requireNonNull(e.getMessage()));
        }

		_databaseHelper.openDataBase();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return true;
	}

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
        int id = item.getItemId();
		if(id == R.id.menu_settings) {
            openSettingsPage();
            return true;
        }

        else {
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void openSettingsPage()
	{
		Intent subPage = new Intent();
		subPage.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".SettingsActivity");
		startActivity(subPage);
	}

	public void openChapters(String questionSet)
	{
        addGeneratedQuestions();
		Intent chapterIntent = new Intent();
		chapterIntent.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".Chapters");
		chapterIntent.putExtra("question_set", questionSet);
		startActivity(chapterIntent);
	}

    private void addGeneratedQuestions()
    {
        addQuestionsForChapterOne();
        addQuestionsForChapterTwo();
        addQuestionsForChapterThree();
        addQuestionsForChapterFour();
        addQuestionsForChapterFive();
        addQuestionsForChapterSix();
        addQuestionsForChapterSeven();;
        addQuestionsForChapterEight();
        addQuestionsForChapterNine();
        addQuestionsForChapterTen();
        addQuestionsForChapterEleven();
        addQuestionsForChapterTwelve();
        addQuestionsForChapterThirteen();
    }

    public void generatePdf()
    {
        //PdfTestData pdfTestData = new PdfTestData("Mathematics", "Class 4", "Unit Test", 20, "60 minutes");
    }

    private void addQuestionsForChapterThirteen()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 13);
        List<PdfQuestion> pdfQuestions = new ArrayList<>();
        final Random RANDOM = new Random();

        for(int i = 0; i < 20; i++)
        {
            int randomNumber = RANDOM.nextInt(100);
            Question question;

            if(randomNumber < 25)
            {
                question = CircleGraphQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 65)
            {
                question = PictographQuestionGenerator.generateQuestion();
            }
            else {
                question = BarChartQuestionGenerator.generateQuestion();
            }

            question.setChapter(13);
            question.setChapterName("Handling Data");
            Util.allQuestions.add(question);

            pdfQuestions.add(copyToPdfQuestion(question));
        }

        /*PdfTestData pdfTestData = new PdfTestData("Mathematics", "Class 4", "Unit Test", 20, "60 minutes", pdfQuestions);

        try {
            QuestionPaperPdfGenerator.generate(this, pdfTestData);
        }
        catch(IOException e)
        {
            Log.e("PDF","Failed to generate question paper", e);
        }*/
    }

    private PdfQuestion copyToPdfQuestion(Question question)
    {
        return new PdfQuestion(
                question.getQuestion(),
                new String[]
                        {
                                question.getOption1(),
                                question.getOption2(),
                                question.getOption3(),
                                question.getOption4()
                        },
                question.getImage(),
                question.getAnswer());
    }

    /*private void addQuestionsForChapterOne()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 1);
        for(int i = 0; i < 20; i++)
        {
            Question question = new Question();
            question.setChapter(1);
            question.setChapterName("Place Value");
            question.setQuestion("this will be auto-generated");
            Util.allQuestions.add(question);
        }
    }*/

    private void addQuestionsForChapterOne()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 1);
        final Random RANDOM = new Random();
        int randomNumber;

        Question question;

        for(int i = 0; i < 20; i++)
        {
            randomNumber = RANDOM.nextInt(10);

            switch(randomNumber)
            {
                case 0:
                    //checked
                    question = ArrangeDigitsQuestionGenerator.generateQuestion();
                    break;

                case 1:
                    //checked
                    question = ArrangeNumbersQuestionGenerator.generateQuestion();
                    break;

                case 2:
                    //checked
                    question = NumberComparisonQuestionGenerator.generateQuestion();
                    break;

                case 3:
                    //checked
                    question = ComparisonSymbolQuestionGenerator.generateQuestion();
                    break;

                case 4:
                    //checked
                    question = DigitPlaceValueQuestionGenerator.generateQuestion();
                    break;

                case 5:
                    //checked
                    question = GreatestSmallestQuestionGenerator.generateQuestion();
                    break;

                /*case 6:
                    question = MissingPlaceValueQuestionGenerator.generateQuestion();
                    break;*/

                case 7:
                    //checked
                    question = NumberOrderQuestionGenerator.generateQuestion();
                    break;

                case 8:
                    //checked
                    question = StandardFormQuestionGenerator.generateQuestion();
                    break;

                default:
                    //checked
                    question = NumberWordsQuestionGenerator.generateQuestion();
            }
            //question = MissingPlaceValueQuestionGenerator.generateQuestion();
            question.setChapter(1);
            question.setChapterName("Place Value");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterTwo()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 2);
        final Random RANDOM = new Random();
        int randomNumber;

        Question question;// = new Question();

        for(int i = 0; i < 20; i++) {
            randomNumber = RANDOM.nextInt(3);

            switch(randomNumber)
            {
                case 0:
                    question = AdditionStoryQuestionGenerator.generateQuestion();
                    break;

                case 1:
                    question = SubtractionFactQuestionGenerator.generateQuestion();
                    break;

                default:
                    question = SubtractionStoryQuestionGenerator.generateQuestion();
            }

            question.setChapter(2);
            question.setChapterName("Addition and Subtraction");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterThree()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 3);
        final Random RANDOM = new Random();
        int randomNumber;

        Question question;// = new Question();

        for(int i = 0; i < 20; i++) {
            randomNumber = RANDOM.nextInt(1);

            switch(randomNumber)
            {
                case 0:
                    question = MultiplicationStoryQuestionGenerator.generateQuestion();
                    break;

                default:
                    question = MultiplicationStoryQuestionGenerator.generateQuestion();
            }

            question.setChapter(3);
            question.setChapterName("Multiplication");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterFour()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 4);
        final Random RANDOM = new Random();
        int randomNumber;

        Question question;// = new Question();

        for(int i = 0; i < 20; i++) {
            randomNumber = RANDOM.nextInt(3);

            switch(randomNumber)
            {
                case 0:
                    question = DivisionFactQuestionGenerator.generateQuestion();
                    break;

                case 1:
                    question = DivisionStoryQuestionGenerator.generateQuestion();
                    break;

                default:
                    question = DivisionPictureQuestionGenerator.generateQuestion();
            }

            question.setChapter(4);
            question.setChapterName("Division");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterFive()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 5);
        Question question;

        for(int i = 0; i < 20; i++) {
            question = FactorQuestionGenerator.generateQuestion();
            question.setChapter(5);
            question.setChapterName("Factors");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterSix()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 6);
        Question question;

        for(int i = 0; i < 20; i++) {
            question = MultipleQuestionGenerator.generateQuestion();
            question.setChapter(6);
            question.setChapterName("Multiples");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterSeven()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 7);
        Question question;

        for(int i = 0; i < 20; i++) {
            question = ShapesQuestionGenerator.generateQuestion();
            question.setChapter(7);
            question.setChapterName("Shapes and Patterns");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterEight()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 8);
        Question question;

        for(int i = 0; i < 20; i++) {
            question = FactorQuestionGenerator.generateQuestion();
            question.setChapter(8);
            question.setChapterName("Fractions");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterNine()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 9);
        Question question;

        for(int i = 0; i < 20; i++) {
            question = FactorQuestionGenerator.generateQuestion();
            question.setChapter(9);
            question.setChapterName("Decimals");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterTen()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 10);
        Question question;

        for(int i = 0; i < 20; i++) {
            question = FactorQuestionGenerator.generateQuestion();
            question.setChapter(10);
            question.setChapterName("Measurement");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterEleven()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 11);
        Question question;

        for(int i = 0; i < 20; i++) {
            question = FactorQuestionGenerator.generateQuestion();
            question.setChapter(11);
            question.setChapterName("Perimeter and Area");
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterTwelve()
    {
        Util.allQuestions.removeIf(question -> question.getChapter() == 12);
        Question question;

        for(int i = 0; i < 20; i++) {
            question = FactorQuestionGenerator.generateQuestion();
            question.setChapter(12);
            question.setChapterName("Time");
            Util.allQuestions.add(question);
        }
    }
	
	private int getRandomQuestionSet()
	{
		Random random = new Random();
		return random.nextInt(9) + 11;
	}

	public void onClickOpenPlayStore(View view)
	{
        openPlayStore();
	}

    private void openPlayStore()
    {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.myAgeEducation.cbseClass4Paid"));
            startActivity(intent);
        } catch (Exception e) {
            Util.displayAlert("Cannot open play store. Open play store manually and search for CBSE Class 5", "Error", SubjectList.this);
        }
    }

    private void openPlayStoreForRating() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.myAgeEducation.cbseClass4"));
            intent.setPackage("com.android.vending");
            startActivity(intent);
        } catch (Exception e) {
            Util.displayAlert("Cannot open play store. Open play store manually and search for CBSE Class 5", "Error", SubjectList.this);
        }
    }

    private void shareAppLink()
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = Util.ShareLinkTitle + System.getProperty("line.separator") + Util.PlayStoreLink;
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, Util.ShareLinkTitle);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    private void DownloadQuestionsOnlyIfAllowed()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("questionDatabaseVersion/cbse/settings/disableDownload");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                int temp = snapshot.getValue(Integer.class);
                int isDownloadDisabled = 0;
                try
                {
                    isDownloadDisabled = temp;
                    Log.d("CBSE_isDownloadDisabled", String.valueOf(isDownloadDisabled));
                }

                catch(Exception e)
                {
                    Log.d("CBSE_Exception", e.getMessage());
                }

                if(isDownloadDisabled == 1) // download is disabled
                {
                    ArrayList<Integer> downloadedSets = _databaseHelper.getDownloadedQuestionSets(Util.Subject);
                    int downloadedSetsSize = downloadedSets.size();

                    // :-( no sets available, must download
                    if(downloadedSetsSize == 0)
                    {
                        downloadQuestions(_downloadLinks.get(0));
                    }
                    else // some downloads are available, will use the downloaded sets
                    {
                        Log.d("CBSE_downloaddisabled", "Download disabled, using local database, size is:" + String.valueOf(downloadedSetsSize));
                        Random random = new Random();
                        _randomQuestionSet = random.nextInt(downloadedSets.size());
                        _randomQuestionSet = downloadedSets.get(_randomQuestionSet);

                        runnable = () -> {
                            runnableStarted = true;
                            readQuestionsFromLocalDatabase();
                            runnableStarted = false;
                        };
                        new Thread(runnable).start();
                    }
                }
                else
                {
                    downloadQuestions(_downloadLinks.get(0));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError firebaseError) {
                Log.d("Exception: ", firebaseError.getMessage());
            }
        });
    }

	private void GetCloudQuestionDatabaseVersion()
	{
        showProgressDialog("Checking database for newer version...");

		FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
		DatabaseReference databaseReference = firebaseDatabase.getReference("questionDatabaseVersion/cbse/" + Util.Subject + "/cbseClass" + Util.GRADE);
		databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				int version = snapshot.getValue(Integer.class);

                dismissProgressDialog();
				Log.d("myVersion", String.valueOf(version));

				try
				{
                    _cloudVersion = version;
                    saveLastCloudVersion(_cloudVersion);
					Log.d("CloudVersion", String.valueOf(_cloudVersion));
				}

				catch(Exception e)
				{
					Log.d("CloudVersionException", Objects.requireNonNull(e.getMessage()));
		    	}

                try {
                    int localVersion = _databaseHelper.getLocalQuestionDatabaseVersion(Util.Subject);
                    Log.d("CBSE_LocalVersion", String.valueOf(localVersion));

                    if (_cloudVersion > localVersion) {
                        Log.d("CBSE_CloudVersion", String.valueOf(_cloudVersion));
                        Log.d("CBSE_CloudVersionInfo", "Cloud Version is greater than local version");
                        _databaseHelper.resetDownloadStatus(Util.Subject);
                    }
                }
                catch(Exception e)
                {
                    Util.displayAlert("ERROR-121: " + e.getMessage(), "ERROR-121", SubjectList.this);
                }

                getQuestions();
			}

			@Override
			public void onCancelled(@NonNull DatabaseError firebaseError) {
                dismissProgressDialog();
				Log.d("CBSE_Exception: ", firebaseError.getMessage());
                Util.displayAlert("Unable to connect to the server. Make sure you are connected to the internet and try again","Unable to connect", SubjectList.this);
            }
		});
	}

    private void getQuestions()
    {
        _randomQuestionSet = getRandomQuestionSet();
        _pendingDownloads = _databaseHelper.pendingDownloads(Util.Subject, _randomQuestionSet);
        Log.d("CBSE_PendingDownloads", String.valueOf(_pendingDownloads.size()));

        if(!_pendingDownloads.isEmpty())
        {
            addDownloadLinksToDownload();
            DownloadQuestionsOnlyIfAllowed();
        }
        else {
            try {
                runnable = () -> {
                    runnableStarted = true;
                    readQuestionsFromLocalDatabase();
                    runnableStarted = false;
                };
                new Thread(runnable).start();
            }

            catch(Exception e)
            {
                Util.displayAlert("reading questions from local database failed. " + e.getMessage(), "Error", SubjectList.this);
            }
        }
    }

	public void readQuestionsFromLocalDatabase()
	{
		String tableName = Util.SCHOOL_NAME + "_" + Util.Subject;
		if(Util.allQuestions != null) {
            Util.allQuestions.clear();
        }
		Util.allQuestions = _databaseHelper.getAllQuestions(tableName.toUpperCase(), _randomQuestionSet);
        if(Util.allQuestions == null)
        {
            //Something went wrong, the database has returned null .. will use the questions from the cloud .. hope it does not rain
            //String downloadLink = Util.SubjectRoot + "/" + Util.Subject + "/set" + String.valueOf(_randomQuestionSet);
            String downloadLink = Util.Subject + "/set" + String.valueOf(_randomQuestionSet);
            downloadQuestions(downloadLink);
            return;
        }
		Log.d("CBSE_QuestionSet", String.valueOf(_randomQuestionSet));
		Log.d("CBSE_QuestionCount", String.valueOf(Util.allQuestions.size()));

		if(Util.allQuestions.size() > 0) {
			{
				openChapters("set" + String.valueOf(_randomQuestionSet));
			}
		}
	}

	private void GetDatabaseLocation()
    {
        //showProgressDialog("Connecting to the online database..., make sure you are connected to the net");
        //Firebase.goOnline();
        GetCloudQuestionDatabaseVersion();
        downloadAdData();
        //AssignFirebaseLocations();


        /*Firebase ref = new Firebase(Util.Firebase_DatabaseLocationSetting);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String database_location = snapshot.getValue(String.class);
                if(database_location.trim().isEmpty())
                {
                    database_location = Util.DefaultDatabaseLocation;
                }

                AssignFirebaseLocations(database_location);

                dismissProgressDialog();

                Log.d("CBSE_DatabaseLocation", Util.DatabaseLocation);

                //if(!isLastAccessToday())
                {
                    GetCloudQuestionDatabaseVersion();
                }
                //else
                {
                    //_cloudVersion = GetLocallySavedCloudVersion();
                    //getQuestions();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                dismissProgressDialog();
                Log.d("CBSE_Exception: ", firebaseError.getMessage());
                Util.displayAlert("Unable to connect to the server. Make sure you are connected to the internet and try again", "Unable to connect", SubjectList.this);
            }
        });*/
    }

    private void addQuestionToLocalDatabase(String downloadLink) {
        isAddToLocalDatabaseCompleted = false;
        String[] tokens = downloadLink.split("/");
        String subject = tokens[SUBJECT_INDEX];
        String set = tokens[QUESTION_SET_INDEX]; // will be of the form SetNN (NN = 11 to NN = 19)
        int setNumber = Integer.parseInt(set.substring(set.length() - 2)); // get the last 2 chars

        ArrayList<Question> questions = (ArrayList<Question>)_questionList.clone();
        _questionList.clear();

        if (_databaseHelper.addQuestions("CBSE_" + subject, questions, setNumber)) {
            _databaseHelper.updateDownloadStatus(subject, setNumber);
            if(_cloudVersion > 0) {
                _databaseHelper.updateLocalQuestionDatabaseVersionInfo(subject, _cloudVersion);
            }
        }

        isAddToLocalDatabaseCompleted = true;
    }

    private void showProgressDialog(final String message)
    {
        runOnUiThread(() -> {
            try {
                ringProgressDialog.setTitle("Please wait ...");
                ringProgressDialog.setMessage(message);
                ringProgressDialog.setCancelable(false);
                ringProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                if (ringProgressDialog != null && (!ringProgressDialog.isShowing())) {
                    ringProgressDialog.show();
                    ringProgressDialog.setCancelable(true);
                }
            }
            catch (Exception ignored)
            {
            }
        });
    }

    private void dismissProgressDialog()
    {
        runOnUiThread(() -> {
            if(ringProgressDialog!=null && ringProgressDialog.isShowing()) {
                ringProgressDialog.dismiss();
            }
        });
    }

    public void downloadQuestions(final String downloadLink)
    {
        showProgressDialog("Connecting to online question database...");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(downloadLink);

        Query queryRef = databaseReference.orderByChild("chapter");
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        try {
                            Question question = postSnapshot.getValue(Question.class);
                            _questionList.add(question);
                        } catch (Exception e) {
                            Log.d("CBSE_ERROR", Objects.requireNonNull(e.getMessage()));
                        }
                    }

                    Log.d("CBSE_", _questionList.size() + " were downloaded");

                    if (!_questionList.isEmpty()) {
                        Util.allQuestions = (ArrayList<Question>) _questionList.clone();
                        if (isAddToLocalDatabaseCompleted)  // if the previous addition is completed, then only we add this, otherwise just ignore adding this set
                        {
                            Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                    addQuestionToLocalDatabase(downloadLink);
                                }
                            };
                            new Thread(runnable).start();
                        }
                        else {
                            _questionList.clear();
                        }
                    } else {
                        Util.allQuestions.clear();
                        dismissProgressDialog();
                        Util.displayAlert("No questions available for this subject", "Questions not available", SubjectList.this);
                        return;
                    }

                    dismissProgressDialog();

                    openChapters("set" + String.valueOf(_randomQuestionSet));
                }
                catch(Exception e)
                {
                    Util.displayAlert(e.getMessage(), "ERROR_SUB_589", SubjectList.this);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError firebaseError) {
                Log.d("Exception: ", firebaseError.getMessage());
            }
        });
    }

    private void addDownloadLinksToDownload()
    {
        _downloadLinks.clear();

        for(int i = 0; i < _pendingDownloads.size(); i++)
        {
            _downloadLinks.add(_pendingDownloads.get(i));
            Log.d("CBSE_PENDING_DOWNLOADS", _pendingDownloads.get(i));
        }
    }

	private void populateAdapter() {
		ArrayList<Integer> subjectImage = new ArrayList<>();
		ArrayList<String> subjectName = new ArrayList<>();
		ArrayList<String> tagLine = new ArrayList<>();

		subjectImage.add(SCIENCE, R.drawable.science);
		subjectImage.add(MATHS, R.drawable.maths);
		subjectImage.add(COMPUTERS, R.drawable.computers);
		subjectImage.add(GK, R.drawable.gk);
		subjectImage.add(SCORE, R.drawable.score);
        subjectImage.add(SHARE_APP_LINK, R.drawable.share);
        subjectImage.add(APP_RATING, R.drawable.rating);
        subjectImage.add(GETMORE, R.drawable.getmore);
        subjectImage.add(EXIT, R.drawable.exit);

		subjectName.add(SCIENCE, "Science");
		subjectName.add(MATHS, "Maths");
		subjectName.add(COMPUTERS, "Computers");
		subjectName.add(GK, "GK");
		subjectName.add(SCORE, "Score");
        subjectName.add(SHARE_APP_LINK, "Share App Link");
        subjectName.add(APP_RATING, "Rate this app");
        subjectName.add(GETMORE, "Get More");
        subjectName.add(EXIT, "Exit");

        tagLine.add(SCIENCE, "");
        tagLine.add(MATHS, "");
        tagLine.add(COMPUTERS, "");
        tagLine.add(GK, "");
        tagLine.add(SCORE, "");
        tagLine.add(SHARE_APP_LINK, "");
        tagLine.add(APP_RATING, "");
        tagLine.add(GETMORE, "");
        tagLine.add(EXIT, "");

        BaseAdapter _listAdapter = new ListViewAdapterForSubjectList(SubjectList.this, subjectImage, subjectName, tagLine);
		_listView.setAdapter(_listAdapter);
	}

    private void downloadAdData()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference;
        //Firebase ref;
        //int versionCode = BuildConfig.VERSION_CODE;

        /*if(versionCode < 16)
        {
            ref = new Firebase(Util.SubjectRoot + "/extras/ads/activeAd"); // contest ad
        }
        else
        {*/
            //ref = new Firebase(Util.SubjectRoot + "/extras/ads/activeAd2"); // normal ad
            //databaseReference = firebaseDatabase.getReference(Util.SubjectRoot + "/extras/ads/activeAd2");
            databaseReference = firebaseDatabase.getReference("extras/ads/activeAd2");
        //}

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                long count = snapshot.getChildrenCount();
                Log.d("ImageDataCount", String.valueOf(count));
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    try {
                        Util.adData = postSnapshot.getValue(AdData.class);
                    }
                    catch (Exception e) {
                        Log.d("CBSE_ERROR", e.getMessage());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                Log.d("Exception: ", firebaseError.getMessage());
            }
        });
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = ((ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
