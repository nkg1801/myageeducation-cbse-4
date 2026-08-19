package com.myAgeEducation.cbseClass4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.graphics.Color;

import com.firebase.client.Firebase;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.AdError;
import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myAgeEducation.cbseClass4.maths.charts.BarChartImageGenerator;
import com.myAgeEducation.cbseClass4.maths.circlegraph.CircleGraphImageGenerator;
import com.myAgeEducation.cbseClass4.maths.datetimecalendar.ClockImageGenerator;
import com.myAgeEducation.cbseClass4.maths.fractions.FractionImageGenerator;
import com.myAgeEducation.cbseClass4.maths.fractions.NumericFractionImageGenerator;
import com.myAgeEducation.cbseClass4.maths.pictograph.PictographImageGenerator;
import com.myAgeEducation.cbseClass4.maths.utils.ImageCodeParser;
import com.myAgeEducation.cbseClass4.maths.utils.ImageCodeType;
import com.myAgeEducation.cbsecommon.Question;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class QuestionPage extends Activity {
	private RadioButton radioSelectedButton;
	private Button buttonNext;
	private TableLayout tableLayout1;
	private int _currentQuestionNumber;
	private Question _question;
	public static ArrayList<Question> QuestionList;
	private ArrayList<Question> revisionQuestions;
	private String answer;
	private int correctAnswerCount;
	private int questionCount;
	public int seconds = 0;
	private String isRevision;
	private ArrayList<Integer> _usedNumbers = new ArrayList<Integer>();
	public ArrayList _questionNumbers = new ArrayList();
	private SharedPreferences sharedPrefs;
	private String reward = "";
	private boolean _automaticallyMoveToNextQuestion = false;
	private boolean _isRandomQuestions = false;
	private String rewardPoints = "";
	private InterstitialAd mInterstitialAd;
	private boolean _isRecoverMode;
	private String isExit;
	private Bundle _bundle;
	private String _questionSet;
	private int _questionIndex;
	private String _linkText;
	private TextView textViewCounter;
	private int counter;
	boolean _serverTimeRetrieved = false;
	String _lastAttemptTime;
	String _monthYear;
	int _scoreSavedIntermediately = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questionpage);
		_bundle = getIntent().getExtras();
		readBundle();

		if (!storeQuestionNumbers()) {
			finish();
			return;
		}

		addInterstitialAd();
		addBannerAd();

		setTextViewProperties();

		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

		_currentQuestionNumber = 1;
		correctAnswerCount = 0;
		counter = 61;

		revisionQuestions = new ArrayList<>();

		displayInitialScore();

		if (isExit.equalsIgnoreCase("true")) {
			finish();
		}

		displayScore();

		buttonNext = findViewById(R.id.buttonNext);
		tableLayout1 = findViewById(R.id.tableLayout1);
		textViewCounter = findViewById(R.id.textViewCounter);

		setQuestionTextColor();

		buttonNext.setEnabled(false);
		HideButtonNext();

		if (sharedPrefs.getBoolean("random_questions", true)) {
			_isRandomQuestions = true;
		}

		if (isRevision.equals("true")) {
			_isRandomQuestions = false;
			QuestionList = (ArrayList<Question>) Util.revisionQuestions.clone();
		}

		if (_isRandomQuestions) {
			try {
				_questionIndex = getRandomQuestionNumber();
				_usedNumbers.add(_questionIndex);
			} catch (Exception e) {
				Util.displayAlert("Questions could not be retrieved, please try again", "Error", QuestionPage.this);
				finish();
			}
		} else {
			_questionIndex = 0;
		}

		_question = QuestionList.get(_questionIndex); // getting the first question
		setControlTexts(_question);

		if (questionCount == 1) {
			buttonNext.setText("Submit");
		}

		addTimer();

		if (sharedPrefs.getBoolean("move_to_next_question", false)) {
			_automaticallyMoveToNextQuestion = true;
			tableLayout1.setVisibility(View.INVISIBLE);
		}

		setActivityTitle();
		addButtonListener();
		addRadioButtonListener();
		setRandomBackgroundForOptions();
	}

	private boolean storeQuestionNumbers() {
		Util.forLogD = "";
		_questionNumbers.clear();
		if (QuestionList == null) {
			return false;
		}
		for (int i = 0; i < QuestionList.size(); i++) {
			_questionNumbers.add(i);
		}
		return true;
	}

	private void displayScore() {
		TextView tvScore = findViewById(R.id.textViewScore);
		if (!sharedPrefs.getBoolean("score_with_every_question", true)) {
			tvScore.setVisibility(View.GONE);
		}
	}

	private void setTextViewProperties() {
		TextView tv = findViewById(R.id.textViewQuestionNumber);
		tv.setTextColor(Color.WHITE);
		tv.setBackgroundColor(Color.DKGRAY);

		tv = findViewById(R.id.textViewTimer);
		tv.setTextColor(Color.WHITE);
		tv.setBackgroundColor(Color.DKGRAY);

		TextView tvScore = findViewById(R.id.textViewScore);
		tvScore.setTextColor(Color.WHITE);
		tvScore.setBackgroundColor(Color.DKGRAY);

		tv = findViewById(R.id.textViewSubject);
		tv.setTextColor(Color.WHITE);
		tv.setBackgroundColor(Color.DKGRAY);
	}

	private void setQuestionTextColor() {
		TextView textView = findViewById(R.id.textViewQuestion);

		if (isRevision.equals("true")) {
			textView.setTextColor(Color.RED);
		} else {
			textView.setTextColor(Color.BLUE);
		}
	}

	private void setActivityTitle() {
		String title = getTitle().toString();
		setTitle(title + " - " + Util.Subject);

		if (isRevision.equals("true")) {
			title = getTitle().toString();
			setTitle(title + " (Revision)");
		}

		String subject;
		if (Util.Subject.equalsIgnoreCase("cs")) {
			subject = "Computers";
		} else if (Util.Subject.equalsIgnoreCase("evs")) {
			subject = "Science";
		} else {
			subject = Util.Subject;
		}


		if (Util.Android_id.equalsIgnoreCase("6d692d322d2df2fb") || Util.Android_id.equalsIgnoreCase("e64b49e28d3e849c")) {
			displayQuestionSetAndQuestionNumber();
		} else {
			((TextView) findViewById(R.id.textViewSubject)).setText("Subject: " + subject);
		}
	}

	private void displayInitialScore() {
		TextView tvScore = findViewById(R.id.textViewScore);
		if (_isRecoverMode) {
			int lastScore = _bundle.getInt("last_score");
			tvScore.setText("Score: " + String.valueOf(lastScore) + "/" + String.valueOf(questionCount));
		} else {
			tvScore.setText("Score: 0/" + questionCount);
		}
	}

	private void readBundle() {
		Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        questionCount = bundle.getInt("questionCount");
		isRevision = bundle.getString("isRevision");
		isExit = bundle.getString("isExit");
		reward = bundle.getString("reward");
		rewardPoints = bundle.getString("points");
		_isRecoverMode = bundle.getBoolean("recover_mode");
		_questionSet = bundle.getString("question_set");
	}

	private void addBannerAd() {
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

	private void addInterstitialAd() {
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

	private void showInterstitialAdAd() {
		if (mInterstitialAd != null) {
			mInterstitialAd.show(this);
		}
	}

	public void displayAlertBox(String message) {
		if (!QuestionPage.this.isFinishing()) {
			Util.displayAlert(message, "Test Report", QuestionPage.this);
		}
	}

	public void displayAlertWithOkCancel(String message, String title, Context context) {
		AlertDialog.Builder alert = new AlertDialog.Builder(context);
		alert.setMessage(message);
		alert.setTitle(title);
		alert.setPositiveButton("Yes", null);
		alert.setCancelable(true);

		alert.setPositiveButton("Yes", (dialog, which) -> {
            if (Util.IsContestTest) {
                SaveLastAttemptScore();
            } else {
                clearState(); // Test is completed.. so remove the saved state
                openTestReportActivity();
                finish();
            }
            showInterstitialAdAd();
        });

		alert.setNegativeButton("No", null);
		alert.create().show();
	}

	private void DisplayTime(int seconds) {
		int minutes = seconds / 60;
		int second = seconds % 60;
		int hours = minutes / 60;
		minutes = minutes % 60;

		String elapsedTime;
		TextView textView = findViewById(R.id.textViewTimer);
		elapsedTime = String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", second) + " ";
		textView.setText(elapsedTime);
	}

	public void addTimer() {
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(() -> {
                    DisplayTime(seconds);

                    if (!Util.isFullPageAdDisplayed) {
                        seconds += 1;
                    }

                    if (Util.IsContestTest) {
                        if (Util.TestTimeOut * 60 - seconds <= 60) {
                            if (counter > 0) {
                                counter = counter - 1;
                            }
                            textViewCounter.setVisibility(View.VISIBLE);
                            textViewCounter.setText(String.valueOf(counter));
                        }
                        //time is up, display timeout message and auto submit
                        if (seconds >= Util.TestTimeOut * 60) {
                            //time out has happened for the test
                            timer.cancel();
                            EnableAnswers(false);
                            textViewCounter.setVisibility(View.GONE);

                            showTimeOutMessage();
                            findViewById(R.id.imageView1).setVisibility(View.INVISIBLE);
                            ShowSubmitButton();
                            submitTest(); //auto submit test
                        }
                    }
                });
			}
		}, 0, 1000);
	}

	private void showTimeOutMessage() {
		findViewById(R.id.textViewTimeOut).setVisibility(View.VISIBLE);
	}

	private Bitmap loadBitmapFromBase64Encoding(String imageData) {
		imageData = imageData.replace("data:image/png;base64,", ""); // introduced in Release 1.6
		byte[] decodedString = Base64.decode(imageData, Base64.DEFAULT);
		return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
	}

	private void showAllOptions() {
		findViewById(R.id.radio_option1).setVisibility(View.VISIBLE);
		findViewById(R.id.radio_option2).setVisibility(View.VISIBLE);
		findViewById(R.id.radio_option3).setVisibility(View.VISIBLE);
		findViewById(R.id.radio_option4).setVisibility(View.VISIBLE);
	}

	/*private Question setQuestionForChapterOne()
	{
		final Random RANDOM = new Random();
		int randomNumber;
		randomNumber = RANDOM.nextInt(100);
		Question newQuestion;

		if(randomNumber < 100)
		{
			newQuestion = DigitPlaceValueQuestionGenerator.generateQuestion();
		}
		else if(randomNumber < 67)
		{
			newQuestion = PictographQuestionGenerator.generateQuestion();
		}
		else {
			newQuestion = BarChartQuestionGenerator.generateQuestion();
		}

		newQuestion.setChapter(1);
		newQuestion.setChapterName("Place Value");
		return newQuestion;
	}*/

	/*private Question setQuestionForChapterThirteen()
	{
		final Random RANDOM = new Random();
		int randomNumber;
		randomNumber = RANDOM.nextInt(100);
		Question newQuestion;

		if(randomNumber < 34)
		{
			newQuestion = CircleGraphQuestionGenerator.generateQuestion();
		}
		else if(randomNumber < 67)
		{
			newQuestion = PictographQuestionGenerator.generateQuestion();
		}
		else {
			newQuestion = BarChartQuestionGenerator.generateQuestion();
		}

		newQuestion.setChapter(13);
		newQuestion.setChapterName("Handling Data");
		return newQuestion;
	}*/

	private void setRandomBackgroundForOptions()
	{
		int[] backgrounds = {
				R.drawable.bg_gradient_blue_purple_pill,
				R.drawable.bg_gradient_gold_orange_pill,
				R.drawable.bg_gradient_red_pill,
				R.drawable.bg_gradient_teal_pill,
		};

		int index = new Random().nextInt(backgrounds.length);
		findViewById(R.id.radio_option1).setBackgroundResource(backgrounds[index]);
		findViewById(R.id.radio_option2).setBackgroundResource(backgrounds[index]);
		findViewById(R.id.radio_option3).setBackgroundResource(backgrounds[index]);
		findViewById(R.id.radio_option4).setBackgroundResource(backgrounds[index]);
	}

	private void setImageForQuestion(String imageData) {
		ImageView img = findViewById(R.id.imageView1);
		img.setVisibility(View.INVISIBLE);

		if (imageData == null) {
			imageData = "";
		}

		Map<String, String> values = ImageCodeParser.parse(imageData);

		//if(!Objects.requireNonNull(values.get("TYPE")).isEmpty())
		if (values.containsKey("TYPE") && values.get("TYPE") != null && !Objects.requireNonNull(values.get("TYPE")).isEmpty())
		{
			Bitmap bitmap = getQuestionImage(imageData);
			if(bitmap != null) {
				img.setImageBitmap(bitmap);
				img.setVisibility(View.VISIBLE);
				setImageViewWidth(img, bitmap.getWidth());
			}
			else
			{
				if (imageData.length() < 50) {
					int resourceIdentifier = getResources().getIdentifier(imageData, "drawable", getPackageName());
					if (resourceIdentifier != 0) {
						img.setImageResource(resourceIdentifier);
						img.setVisibility(View.VISIBLE);
					}
				} else {
					img.setImageBitmap(loadBitmapFromBase64Encoding(imageData));
					img.setVisibility(View.VISIBLE);
				}
			}
		}
		else {
			if (imageData.length() < 50) {
				int resourceIdentifier = getResources().getIdentifier(imageData, "drawable", getPackageName());
				if (resourceIdentifier != 0) {
					img.setImageResource(resourceIdentifier);
					img.setVisibility(View.VISIBLE);
				}
			} else {
				img.setImageBitmap(loadBitmapFromBase64Encoding(imageData));
				img.setVisibility(View.VISIBLE);
			}
		}


		/*switch (Objects.requireNonNull(values.get("TYPE")))
		{
			case ImageCodeType.CIRCLEGRAPH:
				bitmap = CircleGraphImageGenerator.generate(imageData);
				img.setImageBitmap(bitmap);
				img.setVisibility(View.VISIBLE);
				setImageViewWidth(img, bitmap.getWidth());
				break;

			case ImageCodeType.PICTOGRAPH:
				bitmap = PictographImageGenerator.generate(this, imageData);
				img.setImageBitmap(bitmap);
				img.setVisibility(View.VISIBLE);
				setImageViewWidth(img,bitmap.getWidth());
				break;

			case ImageCodeType.BARCHART:
				bitmap = BarChartImageGenerator.generate(imageData);
				img.setImageBitmap(bitmap);
				img.setVisibility(View.VISIBLE);
				setImageViewWidth(img,bitmap.getWidth());
				break;

			default:
				if (imageData.length() < 50) {
					int resourceIdentifier = getResources().getIdentifier(imageData, "drawable", getPackageName());
					if (resourceIdentifier != 0) {
						img.setImageResource(resourceIdentifier);
						img.setVisibility(View.VISIBLE);
					}
				} else {
					img.setImageBitmap(loadBitmapFromBase64Encoding(imageData));
					img.setVisibility(View.VISIBLE);
				}
		}*/

		/*if (Objects.equals(values.get("TYPE"), ImageCodeType.CIRCLEGRAPH)) {
			Bitmap bitmap = CircleGraphImageGenerator.generate(imageData);
			img.setImageBitmap(bitmap);
			img.setVisibility(View.VISIBLE);
			setImageViewWidth(img, bitmap.getWidth());
		}*/

		/*else if(imageData.contains("PICTOGRAPH_"))
		{
			Bitmap bitmap = PictographImageGenerator.generate(this, imageData);
			img.setImageBitmap(bitmap);
			img.setVisibility(View.VISIBLE);
			setImageViewWidth(img,bitmap.getWidth());
		}*/

		/*else if (imageData.length() < 50) {
			int resourceIdentifier = getResources().getIdentifier(imageData, "drawable", getPackageName());
			if (resourceIdentifier != 0) {
				img.setImageResource(resourceIdentifier);
				img.setVisibility(View.VISIBLE);
			}
		} else {
			img.setImageBitmap(loadBitmapFromBase64Encoding(imageData));
			img.setVisibility(View.VISIBLE);
		}*/
	}

	private Bitmap getQuestionImage(String imageData)
	{
		Map<String, String> values = ImageCodeParser.parse(imageData);

		switch (Objects.requireNonNull(values.get("TYPE")))
		{
			case ImageCodeType.CIRCLEGRAPH:
				return CircleGraphImageGenerator.generate(imageData);

			case ImageCodeType.PICTOGRAPH:
				return PictographImageGenerator.generate(this, imageData);

			case ImageCodeType.BARCHART:
				return BarChartImageGenerator.generate(imageData);

			case ImageCodeType.NUMERICFRACTION:
				return NumericFractionImageGenerator.generate(imageData);

			case ImageCodeType.SHAPE_PART_FRACTION:
				return FractionImageGenerator.generateFractionImage(imageData);

			case ImageCodeType.CLOCK:
				return ClockImageGenerator.generateClockImage(imageData);

			default:
				return null;
		}
	}

	private void setImageViewWidth(ImageView img, int bitmapWidth)
	{
		int availableWidth =
				getResources().getDisplayMetrics().widthPixels
						- (int)(16 * getResources().getDisplayMetrics().density);
		ViewGroup.LayoutParams params = img.getLayoutParams();
		params.width = Math.min(bitmapWidth, availableWidth);
		params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
		img.setLayoutParams(params);
	}

	private void setSupportiveText(String supportiveText)
	{
		findViewById(R.id.textViewSupportiveText).setVisibility(View.INVISIBLE);

		if(supportiveText == null)
		{
			return;
		}
		((TextView)findViewById(R.id.textViewSupportiveText)).setText(supportiveText);
		findViewById(R.id.textViewSupportiveText).setVisibility(View.VISIBLE);
	}

	private void setOptions(Question question)
	{
		String option1 = question.getOption1();
		String option2 = question.getOption2();
		String option3 = question.getOption3();
		String option4 = question.getOption4();

		// if 3rd and 4th option is empty, we do not shuffle the options, so setting the first option as first
		if(option3 == null && option4 == null)
		{
			((RadioButton)findViewById(R.id.radio_option1)).setText(option1);
			((RadioButton)findViewById(R.id.radio_option2)).setText(option2);

			findViewById(R.id.radio_option3).setVisibility(View.GONE);
			findViewById(R.id.radio_option4).setVisibility(View.GONE);
		}
		else if(option4 == null)
		{
			((RadioButton)findViewById(R.id.radio_option1)).setText(option1);
			((RadioButton)findViewById(R.id.radio_option2)).setText(option2);
			((RadioButton)findViewById(R.id.radio_option3)).setText(option3);
			findViewById(R.id.radio_option4).setVisibility(View.GONE);
		}
		else
		{
			Random r = new Random();
			int random = r.nextInt(4) + 1; //Generate a random no. from 1 to 4 to shuffle the options

			switch(random)
			{
				case 1:
					((RadioButton)findViewById(R.id.radio_option1)).setText(option1);
					((RadioButton)findViewById(R.id.radio_option2)).setText(option2);
					((RadioButton)findViewById(R.id.radio_option3)).setText(option3);
					((RadioButton)findViewById(R.id.radio_option4)).setText(option4);
					break;

				case 2:
					((RadioButton)findViewById(R.id.radio_option1)).setText(option2);
					((RadioButton)findViewById(R.id.radio_option2)).setText(option3);
					((RadioButton)findViewById(R.id.radio_option3)).setText(option4);
					((RadioButton)findViewById(R.id.radio_option4)).setText(option1);
					break;

				case 3:
					((RadioButton)findViewById(R.id.radio_option1)).setText(option3);
					((RadioButton)findViewById(R.id.radio_option2)).setText(option4);
					((RadioButton)findViewById(R.id.radio_option3)).setText(option1);
					((RadioButton)findViewById(R.id.radio_option4)).setText(option2);
					break;

				case 4:
					((RadioButton)findViewById(R.id.radio_option1)).setText(option4);
					((RadioButton)findViewById(R.id.radio_option2)).setText(option1);
					((RadioButton)findViewById(R.id.radio_option3)).setText(option2);
					((RadioButton)findViewById(R.id.radio_option4)).setText(option3);
					break;

				default:
					break;
			}
		}
	}
  
  public void setControlTexts(Question question)
  {
	  showAllOptions();
	  _linkText = "";

	  /*if(question.getChapter() == 13)
	  {
		  question = setQuestionForChapterThirteen();
	  }*/

	  /*switch (question.getChapter())
	  {
		  case 1:
			  question = setQuestionForChapterOne();
			  break;

		  case 13:
			  question = setQuestionForChapterThirteen();
			  break;
	  }*/

	  String questionImage = question.getImage();
	  String supportiveText = question.getSupportiveText();

	  setImageForQuestion(questionImage);
	  setSupportiveText(supportiveText);

	  if(TextUtils.isEmpty(questionImage) && TextUtils.isEmpty(supportiveText))
	  {
		  if(_currentQuestionNumber < 5)
		  {
			  displayAdImage();
		  }
	  }

	  TextView textViewQNum;

	  textViewQNum = findViewById(R.id.textViewQuestionNumber);
	  String myString = " Question " + _currentQuestionNumber + " of " + questionCount;
	  textViewQNum.setText(myString);
	    
	    // Set the Question
	  TextView textView;
	  textView = findViewById(R.id.textViewQuestion);
	  String questionText = question.getQuestion();

	  textView.setText(questionText);
	  setOptions(question);
	    
	    answer = question.getAnswer();
  }

	private void displayAdImage()
	{
		if(Util.adData == null)
		{
			return;
		}

		if(Util.adData.getImage() == null)
		{
			return;
		}

		ImageView img = findViewById(R.id.imageView1);
		if (!Util.adData.getImage().isEmpty()) {
			img.setImageBitmap(loadBitmapFromBase64Encoding(Util.adData.getImage()));
			img.setVisibility(View.VISIBLE);
			_linkText = Util.adData.getLinkText();
		}
	}

  public void SetAnswerFeedback()
  {
	  boolean isAnsCorrect = radioSelectedButton.getText().equals(answer);
	  
	  if(isAnsCorrect)
	  {
		  correctAnswerCount++;
		  if(Util.IsContestTest)
		  {
		  		// save only if the correctAnswerCount has increased since the last save
			    // to avoid unnecessary trip to the database
		  		if(_scoreSavedIntermediately < correctAnswerCount) {
					_scoreSavedIntermediately = correctAnswerCount;
		  			intermediateSave();
				}
		  }
		  findViewById(R.id.imageViewRight).setVisibility(View.VISIBLE);
	  }
	  else
	  {
		  revisionQuestions.add(_question);
		  findViewById(R.id.imageViewWrong).setVisibility(View.VISIBLE);
	  }

      TextView tv = findViewById(R.id.textViewScore);
	  tv.setText("Score: " + String.valueOf(correctAnswerCount) + "/" + String.valueOf(questionCount));
  }
  
  public void EnableAnswers(boolean val)
  {
	  RadioButton button = findViewById(R.id.radio_option1);
      button.setEnabled(val);

      button = findViewById(R.id.radio_option2);
      button.setEnabled(val);

      button = findViewById(R.id.radio_option3);
      button.setEnabled(val);

      button = findViewById(R.id.radio_option4);
      button.setEnabled(val);

	  findViewById(R.id.imageViewRight).setVisibility(View.INVISIBLE);
	  findViewById(R.id.imageViewWrong).setVisibility(View.INVISIBLE);
  }

    private void ShowSubmitButton()
    {
		tableLayout1.setVisibility(View.VISIBLE);
		Button buttonSubmit = findViewById(R.id.buttonNext);
		buttonSubmit.setText("Submit");

		Button exitButton = findViewById(R.id.buttonExitTest);
		exitButton.setEnabled(false);
		exitButton.setBackgroundColor(Color.DKGRAY);
    }

  private void WhenAnswerSelected()
  {
      //try {
          EnableAnswers(false);
          SetAnswerFeedback();
          buttonNext.setEnabled(true);
		  buttonNext.setVisibility(View.VISIBLE);
		  tableLayout1.setVisibility(View.VISIBLE);

          if (_currentQuestionNumber == questionCount)
		  {
              ShowSubmitButton();
          }
		  else
		  {
              if (_automaticallyMoveToNextQuestion)
			  {
                  moveToNextQuestion();
                  EnableAnswers(true);
              }
          }
      //}
      /*catch(Exception e)
      {
          displayAlertBox(e.getMessage());
      }*/
  }

  public void addRadioButtonListener(){
	  RadioButton b = findViewById(R.id.radio_option1);
	  b.setOnClickListener(new OnClickListener(){
		  @Override
			public void onClick(View v) {
			  RadioButton b1 = findViewById(R.id.radio_option1);
			  if(b1.isChecked())
			  {
                  radioSelectedButton = findViewById(R.id.radio_option1);
                  WhenAnswerSelected();
			  }
		  }
	  });
	  
	  b = findViewById(R.id.radio_option2);
	  b.setOnClickListener(new OnClickListener(){
		  @Override
			public void onClick(View v) {
			  
			  RadioButton b2 = findViewById(R.id.radio_option2);
			  if(b2.isChecked())
			  {
				  radioSelectedButton = findViewById(R.id.radio_option2);
				  WhenAnswerSelected();
			  }
		  }
	 });
	  
	  b = findViewById(R.id.radio_option3);
	  b.setOnClickListener(new OnClickListener(){
		  @Override
			public void onClick(View v) {
			  RadioButton b3 = findViewById(R.id.radio_option3);
			  if(b3.isChecked())
			  {
				  radioSelectedButton = findViewById(R.id.radio_option3);
                  WhenAnswerSelected();
			  }
		  }
	  });
	  
	  b = findViewById(R.id.radio_option4);
	  b.setOnClickListener(new OnClickListener() {
		  @Override
		  public void onClick(View v) {
			  RadioButton b4 = findViewById(R.id.radio_option4);
			  if (b4.isChecked()) {
				  radioSelectedButton = findViewById(R.id.radio_option4);
				  WhenAnswerSelected();
			  }
		  }
	  });
  }

    private void HideButtonNext()
	{
        tableLayout1.setVisibility(View.GONE);
	}

  public void moveToNextQuestion()
  {
	  HideButtonNext();

	  //try
	  //{
          if (_currentQuestionNumber <= questionCount)
		  {
              if (_isRandomQuestions)
			  {
				  try {
					  _questionIndex = getRandomQuestionNumber();
					  _usedNumbers.add(_questionIndex);
				  }
				  catch(Exception e)
				  {
                      Util.displayAlert("Questions could not be retrieved, please try again","Error", QuestionPage.this);
					  finish();
				  }
              }
			  else
			  {
				  _questionIndex = _currentQuestionNumber;
              }

			  if(Util.Android_id.equalsIgnoreCase("6d692d322d2df2fb") || Util.Android_id.equalsIgnoreCase("e64b49e28d3e849c")) {
				  displayQuestionSetAndQuestionNumber();
			  }

			  _question = QuestionList.get(_questionIndex);
              _currentQuestionNumber++;
			  setControlTexts(_question);
              EnableAnswers(true);

              RadioButton b = findViewById(R.id.radio_option1);
              b.setChecked(false);

              b = findViewById(R.id.radio_option2);
              b.setChecked(false);

              b = findViewById(R.id.radio_option3);
              b.setChecked(false);

              b = findViewById(R.id.radio_option4);
              b.setChecked(false);
              buttonNext.setEnabled(false);
		  }
      //}
      /*catch (Exception e)
      {
          displayAlertBox(e.getMessage());
      }*/
  }

	private void displayQuestionSetAndQuestionNumber()
	{
		((TextView) findViewById(R.id.textViewSubject)).setText("Subject: " + Util.Subject + "/" + _questionSet + "/" + _questionIndex);
	}

	private void submitTest()
	{
		if(Util.IsContestTest)
		{
			//writeLastAttemptScoreToCloud();
			SaveLastAttemptScore();
		}
		else {
			clearState(); // Test is completed.. so remove the saved state
			openTestReportActivity();
			finish();
			showInterstitialAdAd();
		}
	}

	private void writeSingleStringValueToCloud(String nodePath, String nodeChild, String nodeValue)
	{
		Firebase.goOnline();
		Firebase ref = new Firebase(nodePath);
		Firebase childRef = ref.child(nodeChild);
		childRef.setValue(nodeValue);
	}

	private void writeSingleIntegerValueToCloud(String nodePath, String nodeChild, int nodeValue)
	{
		Firebase.goOnline();
		Firebase ref = new Firebase(nodePath);
		Firebase childRef = ref.child(nodeChild);
		childRef.setValue(nodeValue);
		//Firebase.goOffline();
	}

	private void writeLastAttemptScoreToCloud()
	{
		/*FirebaseAuth mAuth = FirebaseAuth.getInstance();
		FirebaseUser user = mAuth.getCurrentUser();
		String userUuid = user.getUid();*/
		String nodePath = Util.ContestClassRoot + "/Jan-2018/" + Util.UserUid + "/" + Util.Subject;
		writeSingleIntegerValueToCloud(nodePath,"lastAttemptScore", correctAnswerCount);
	}

	private void intermediateSave()
	{
		Firebase.goOnline();

		if(_serverTimeRetrieved)
		{
			String nodePath = Util.ContestClassRoot + "/" + _monthYear + "/contest_details_users/" + Util.UserUid + "/" + Util.Subject;
			//String nodePath = Util.ContestUserRoot + "/" + monthYear.format(resultdate) + "/" + Util.UserUid + "/" + Util.Subject;
			writeSingleIntegerValueToCloud(nodePath, "lastAttemptScore", correctAnswerCount);
			writeSingleStringValueToCloud(nodePath, "lastAttemptTime", _lastAttemptTime);
			//int attemptNumber = Util.testAttemptDetails.getAttempts() + 1;
			int attemptNumber = ((PojoTestAttemptDetails) Util.SubjectTestAttemptDetailsMaps.get(Util.Subject)).getAttempts() + 1;
			writeSingleIntegerValueToCloud(nodePath, "attempts", attemptNumber);
			String attemptCountScore = "attempt" + String.valueOf(attemptNumber) + "Score";
			writeSingleIntegerValueToCloud(nodePath, attemptCountScore, correctAnswerCount);
		}
		else {

			Log.d("Server_Time", "Getting Server Time");
			DatabaseReference offsetRef = FirebaseDatabase.getInstance().getReference(".info/serverTimeOffset");
			offsetRef.addValueEventListener(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot snapshot) {
					Firebase.goOffline();
					_serverTimeRetrieved = true;
					double offset = snapshot.getValue(Double.class);
					Util.ServerTime = System.currentTimeMillis() + offset;

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
					SimpleDateFormat monthYear = new SimpleDateFormat("MMM-yyyy");
					long temp = (new Double(Util.ServerTime)).longValue();
					Date resultdate = new Date(temp);
					Log.d("Server_Time", sdf.format(resultdate));
					_lastAttemptTime = sdf.format(resultdate);
					_monthYear = monthYear.format(resultdate);
					String nodePath = Util.ContestClassRoot + "/" + _monthYear + "/contest_details_users/" + Util.UserUid + "/" + Util.Subject;
					//String nodePath = Util.ContestUserRoot + "/" + monthYear.format(resultdate) + "/" + Util.UserUid + "/" + Util.Subject;
					writeSingleIntegerValueToCloud(nodePath, "lastAttemptScore", correctAnswerCount);
					writeSingleStringValueToCloud(nodePath, "lastAttemptTime", _lastAttemptTime);
					//int attemptNumber = Util.testAttemptDetails.getAttempts() + 1;
					int attemptNumber = ((PojoTestAttemptDetails) Util.SubjectTestAttemptDetailsMaps.get(Util.Subject)).getAttempts() + 1;
					writeSingleIntegerValueToCloud(nodePath, "attempts", attemptNumber);
					String attemptCountScore = "attempt" + String.valueOf(attemptNumber) + "Score";
					writeSingleIntegerValueToCloud(nodePath, attemptCountScore, correctAnswerCount);

					PojoTestAttemptDetails pojoTestAttemptDetails = (PojoTestAttemptDetails) Util.SubjectTestAttemptDetailsMaps.get(Util.Subject);

					if (pojoTestAttemptDetails != null) {
						pojoTestAttemptDetails.setLastAttemptScore(correctAnswerCount);
					}
				}

				@Override
				public void onCancelled(DatabaseError error) {
					Firebase.goOffline();
					//System.err.println("Listener was cancelled");
				}
			});
		}
	}

	private void SaveLastAttemptScore()
	{
		Firebase.goOnline();
		Log.d("Server_Time", "Getting Server Time");
		DatabaseReference offsetRef = FirebaseDatabase.getInstance().getReference(".info/serverTimeOffset");
		offsetRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				Firebase.goOffline();
				double offset = snapshot.getValue(Double.class);
				Util.ServerTime = System.currentTimeMillis() + offset;

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
				SimpleDateFormat monthYear = new SimpleDateFormat("MMM-yyyy");
				long temp = (new Double(Util.ServerTime)).longValue();
				Date resultDate = new Date(temp);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(resultDate);
				int date = calendar.get(Calendar.DATE);

				// Contest was started probably during midnight and was completed on the 1st of the month
				if(date < 10)
				{
					TextView textView = findViewById(R.id.textViewTimeOut);
					textView.setText(getString(R.string.contest_closed));
					Button button = findViewById(R.id.buttonNext);
					button.setText(getString(R.string.close));
					return;
				}

				Log.d("Server_Time", sdf.format(resultDate));
				String nodePath = Util.ContestClassRoot + "/" + monthYear.format(resultDate) + "/contest_details_users/" + Util.UserUid + "/" + Util.Subject;
				//String nodePath = Util.ContestUserRoot + "/" + monthYear.format(resultdate) + "/" + Util.UserUid + "/" + Util.Subject;
				writeSingleIntegerValueToCloud(nodePath,"lastAttemptScore", correctAnswerCount);
				writeSingleStringValueToCloud(nodePath, "lastAttemptTime", sdf.format(resultDate));
				//int attemptNumber = Util.testAttemptDetails.getAttempts() + 1;
				int attemptNumber = ((PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get(Util.Subject)).getAttempts() + 1;
				writeSingleIntegerValueToCloud(nodePath,"attempts", attemptNumber);
				String attemptCountScore = "attempt" + String.valueOf(attemptNumber) + "Score";
				writeSingleIntegerValueToCloud(nodePath, attemptCountScore, correctAnswerCount);

				PojoTestAttemptDetails pojoTestAttemptDetails = (PojoTestAttemptDetails)Util.SubjectTestAttemptDetailsMaps.get(Util.Subject);

				if(pojoTestAttemptDetails != null) {
					pojoTestAttemptDetails.setLastAttemptScore(correctAnswerCount);
				}

				openTestReportActivity();
				finish();
			}

			@Override
			public void onCancelled(DatabaseError error) {
				Firebase.goOffline();
				//System.err.println("Listener was cancelled");
			}
		});
	}

  public void addButtonListener() {

	  buttonNext.setOnClickListener(new OnClickListener() {

		  @Override
		  public void onClick(View v) {
			  //saveStateOfTest();
			  if(buttonNext.getText().toString().compareToIgnoreCase("submit") == 0)
              {
                  submitTest();
			  }
			  if(buttonNext.getText().toString().compareToIgnoreCase(getString(R.string.close)) == 0)
			  {
			  	   finish();
			  }
			  else
			  {
                  moveToNextQuestion();
			  }
		  }
	  });

      Button buttonExitTest = findViewById(R.id.buttonExitTest);
      buttonExitTest.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
              if(!QuestionPage.this.isFinishing()) {
                  displayAlertWithOkCancel("Are you sure to exit the test", "Exit?", QuestionPage.this);
              }
          }
      });
  }

	private void openTestReportActivity()
	{
		Intent testReport = new Intent();
		testReport.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".TestReport");
		testReport.putExtra("correct_ans_count", String.valueOf(correctAnswerCount));
		testReport.putExtra("questionCount", String.valueOf(questionCount));
		testReport.putExtra("isRevision", isRevision);
		testReport.putExtra("reward", reward);
		testReport.putExtra("points", rewardPoints);
		Util.revisionQuestions = (ArrayList<Question>)revisionQuestions.clone();
		startActivity(testReport);
	}
  
  public void clearState()
  {
	  String fileName = Util.SCHOOL_NAME + "_" + Util.GRADE + "_" + Util.Subject + "_state.txt";

	  try
	  {
		  FileOutputStream fileOutputStream = getApplicationContext().openFileOutput(fileName, Context.MODE_PRIVATE);
			
		  OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		  BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

          bufferedWriter.write("");

          bufferedWriter.close();
		  outputStreamWriter.close();
		  fileOutputStream.close();
	  }
	  catch(IOException e)
	  {
		  displayAlertBox("ERROR-404:" + e.getMessage());
	  }
  }

	/*
  public void saveStateOfTest()
  {
	  /*EVS;11;13;100;5 (Left);4(Score)
	  4,9,6,90 (Attempted questions)
	  Wrong Q list
	  10;sdfkkd;a;b;c;d;c
	  10;adsfkk;a;b;c;d;a
	  ------
	  ------
	  */
	  
	  /*try
      {
		  	String fileName = Util.SCHOOL_NAME + "_" + Util.GRADE + "_" + Util.Subject + "_state.txt";
		  	FileOutputStream fos = getApplicationContext().openFileOutput(fileName,Context.MODE_PRIVATE);
			OutputStreamWriter out = new OutputStreamWriter(fos);
			BufferedWriter bufferedWriter = new BufferedWriter(out);
			String currentState = String.valueOf(_currentQuestionNumber) + ";" + String.valueOf(correctAnswerCount);

		  	bufferedWriter.write(currentState);
          	bufferedWriter.newLine();
			
			//used Numbers
			String numbersUsed = "";
			
			for(int i = 0; i < _usedNumbers.size() - 1; i++)
			{
				if(i == 0)
				{
					numbersUsed = String.valueOf(_usedNumbers.get(i));
				}
				else
				{
					numbersUsed = numbersUsed +";" + String.valueOf(_usedNumbers.get(i));
				}
			}

          	bufferedWriter.write(numbersUsed);
          	bufferedWriter.newLine();
			
			for(int startPos = 0; startPos < revisionQuestions.size(); startPos++)
			{
                bufferedWriter.write(revisionQuestions.get(startPos));
                bufferedWriter.newLine();
			}

          	bufferedWriter.close();
			out.close();
			fos.close();
      }
		
		catch(IOException io)
		{
			displayAlertBox("ERROR-401:" + io.getMessage());
		}
		catch(IndexOutOfBoundsException e)
		{
			displayAlertBox("ERROR-402:" + e.getMessage());
		}
	  catch(Exception e)
	  {
		  displayAlertBox("ERROR-403:" + e.getMessage());
	  }
  }*/

	public void onClickAdImage(View view)
	{
	    if(_linkText == null)
		{
			return;
		}

		if(_linkText.isEmpty())
		{
			return;
		}

		try {
			saveIfAdClicked();
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse(_linkText));
			startActivity(intent);
		}
		catch(Exception e)
		{
			Log.d("ADIMAGEERROR", e.getMessage());
		}
	}

	private void saveIfAdClicked() {
		Firebase.goOnline();
		String AdClickedReportRoot = "https://schooltests.firebaseio.com/adimageclicked";
		Firebase ref = new Firebase(AdClickedReportRoot);
		Firebase childRef = ref.child("000_lastAdClicked");
		childRef.setValue(Util.getCurrentDateTime() + "/" + Util.UserUid);
		childRef = ref.child(UUID.randomUUID().toString());
		childRef.setValue(Util.getCurrentDateTime() + "/" + Util.UserUid);
	}

	public void onClickSupportiveText(View view)
	{
		Intent intent = new Intent();
		intent.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".SupportiveTextLargeView");
		intent.putExtra("SupportiveText", ((TextView) findViewById(R.id.textViewSupportiveText)).getText());
		intent.putExtra("Question", ((TextView)findViewById(R.id.textViewQuestion)).getText());
		startActivity(intent);
	}

	public int getRandomQuestionNumber()
	{
		Random random = new Random();
		int generatedRandomNumber;
		generatedRandomNumber = random.nextInt(_questionNumbers.size());
		Log.d("QuestionNumbersSize", String.valueOf(_questionNumbers.size()));
		int questionNumber = ((Integer)(_questionNumbers.get(generatedRandomNumber))).intValue();
		_questionNumbers.remove(generatedRandomNumber);
		return questionNumber;
	}
}
