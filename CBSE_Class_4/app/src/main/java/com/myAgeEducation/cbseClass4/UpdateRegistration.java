package com.myAgeEducation.cbseClass4;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class UpdateRegistration extends Activity {
    private FirebaseAuth mAuth;
    ObjectAnimator animation;
    Timer timer = new Timer();
    ProgressBar progressBar;
    ScrollView scrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_registration_form);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        scrollView = findViewById(R.id.scrollView1);
        scrollView.setVisibility(View.INVISIBLE);
        addBannerAd();
        animateProgressBar();
        addTimer();
        getUserDetails();
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

    private void getUserDetails()
    {
        Firebase.goOnline();
        Firebase ref = new Firebase(Util.ContestUserRoot + "/" + Util.UserUid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Firebase.goOffline();
                timer.cancel();
                progressBar.setVisibility(View.GONE);
                findViewById(R.id.textViewWaiting).setVisibility(View.GONE);
                PojoUserDetails userDetails = snapshot.getValue(PojoUserDetails.class);
                populateFields(userDetails);
                scrollView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Firebase.goOffline();
                Log.d("CBSE_Exception: ", firebaseError.getMessage());
            }
        });
    }

    private void populateFields(PojoUserDetails userDetails)
    {
        ((EditText)findViewById(R.id.editTextName)).setText(userDetails.getName());
        ((EditText)findViewById(R.id.editTextAddressLine1)).setText(userDetails.getAddressLine1());
        ((EditText)findViewById(R.id.editTextAddressLine2)).setText(userDetails.getAddressLine2());
        ((EditText)findViewById(R.id.editTextCity)).setText(userDetails.getCity());

        String[] states;
        ArrayAdapter<String> adapter;
        states = getResources().getStringArray(R.array.indian_states);

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                states);

        Spinner spinner = findViewById(R.id.spinnerState);

        for (int position = 0; position < adapter.getCount(); position++) {
            if(TextUtils.equals(adapter.getItem(position), userDetails.getState())) {
                spinner.setSelection(position);
            }
        }

        ((EditText)findViewById(R.id.editTextPincode)).setText(userDetails.getPincode());
        ((EditText)findViewById(R.id.editTextMobileNumber)).setText(userDetails.getMobile());
        ((EditText)findViewById(R.id.editTextEmail)).setText(userDetails.getEmail());
    }

    public void onClickButtonUpdate(View view)
    {
        TextView textView = findViewById(R.id.textViewErrorText);
        textView.setVisibility(View.INVISIBLE);

        String errorText = validateFields();
        if(TextUtils.isEmpty(errorText)) {
            textView.setVisibility(View.INVISIBLE);
            saveUserData(Util.UserUid);
        }
        else
        {
            textView.setText(errorText);
            textView.setVisibility(View.VISIBLE);
        }
    }

    public void onClickButtonOk(View view)
    {
        finish();
    }

    private String validateFields()
    {
        String errorText = "";

        String name = ((EditText)findViewById(R.id.editTextName)).getText().toString().trim();
        String city = ((EditText)findViewById(R.id.editTextCity)).getText().toString().trim();
        String email = ((EditText)findViewById(R.id.editTextEmail)).getText().toString().trim();
        String addressLine1 = ((EditText)findViewById(R.id.editTextAddressLine1)).getText().toString().trim();
        //String state = ((EditText)findViewById(R.id.editTextState)).getText().toString().trim();

        Spinner spinner = findViewById(R.id.spinnerState);
        String state;
        if(spinner.getSelectedItemPosition() > 0) {
            state = spinner.getSelectedItem().toString();
        }
        else
        {
            state = "";
        }

        String pincode = ((EditText)findViewById(R.id.editTextPincode)).getText().toString().trim();
//        String confirmEmail = ((EditText)findViewById(R.id.editTextConfirmEmail)).getText().toString().trim();
        //String pin = ((EditText)(findViewById(R.id.editTextPin))).getText().toString().trim();
        //String confirmPin = ((EditText)(findViewById(R.id.editTextConfirmPin))).getText().toString().trim();
        // are there more than one '@' in the email address

        String[] moreThanOneAtTheRate = email.split("@");
        int lastIndexOfAtTheRate = email.lastIndexOf("@");
        int lastIndexOfDot = email.lastIndexOf(".");

        if(TextUtils.isEmpty(name))
        {
            errorText = "Name is empty";
            findViewById(R.id.editTextName).requestFocus();
        }
        else if(TextUtils.isEmpty(city))
        {
            errorText = "City name is empty";
            findViewById(R.id.editTextCity).requestFocus();
        }
        else if(TextUtils.isEmpty(email))
        {
            errorText = "Email address is empty";
            findViewById(R.id.editTextEmail).requestFocus();
        }
        else if(email.length() < 5)
        {
            errorText = "Email format not correct";
            findViewById(R.id.editTextEmail).requestFocus();
        }
        else if(!email.contains("@") || !email.contains("."))
        {
            errorText = "Email format not correct";
            findViewById(R.id.editTextEmail).requestFocus();
        }
        else if(TextUtils.isDigitsOnly(email))
        {
            errorText = "Email format not correct";
            findViewById(R.id.editTextEmail).requestFocus();
        }
        else if (moreThanOneAtTheRate.length > 2)
        {
            // if there are more than one '@' then its not a valid email address;
            errorText = "Email address not valid";
            findViewById(R.id.editTextEmail).requestFocus();
        }
        else if(lastIndexOfAtTheRate >= email.length() - 1)
        {
            // '@' should not be the last character
            errorText = "Email address not valid";
            findViewById(R.id.editTextEmail).requestFocus();
        }
        else if(lastIndexOfDot >= email.length() - 1)
        {
            // '.' should not be the last character
            errorText = "Email address not valid";
            findViewById(R.id.editTextEmail).requestFocus();
        }
        else if(lastIndexOfDot < lastIndexOfAtTheRate)
        {
            // The last "." should come after '@'
            errorText = "Email address not valid";
            findViewById(R.id.editTextEmail).requestFocus();
        }
        else if(TextUtils.isEmpty(addressLine1))
        {
            errorText = "Please provide a valid address";
            findViewById(R.id.editTextAddressLine1).requestFocus();
        }
        else if(TextUtils.isEmpty(pincode))
        {
            errorText = "Please provide a valid PINCODE";
            findViewById(R.id.editTextPincode).requestFocus();
        }
        else if(pincode.length() < 6)
        {
            errorText = "Please provide a valid PINCODE";
            findViewById(R.id.editTextPincode).requestFocus();
        }
        else if(TextUtils.equals(pincode, "000000"))
        {
            errorText = "Please provide a valid PINCODE";
            findViewById(R.id.editTextPincode).requestFocus();
        }
        else if(TextUtils.isEmpty(state))
        {
            errorText = "Please provide a valid State name";
            findViewById(R.id.editTextPincode).requestFocus();
        }

        else if(TextUtils.isEmpty(state))
        {
            errorText = "Please select a State name";
            findViewById(R.id.editTextPincode).requestFocus();
        }
        return errorText;
    }

    private void saveUserData(String uid)
    {
        String name = ((EditText)findViewById(R.id.editTextName)).getText().toString().trim();
        String addressLine1 = ((EditText)findViewById(R.id.editTextAddressLine1)).getText().toString().trim();
        String addressLine2 = ((EditText)findViewById(R.id.editTextAddressLine2)).getText().toString().trim();
        String city = ((EditText)findViewById(R.id.editTextCity)).getText().toString().trim();
        //String state = ((EditText)findViewById(R.id.editTextState)).getText().toString().trim();
        String state = ((Spinner)findViewById(R.id.spinnerState)).getSelectedItem().toString();
        String pincode = ((EditText)findViewById(R.id.editTextPincode)).getText().toString().trim();
        String mobileNumber = ((EditText)findViewById(R.id.editTextMobileNumber)).getText().toString().trim();

        Firebase.goOnline();
        Firebase ref = new Firebase(Util.ContestUserRoot);
        ref.child(uid).child("name").setValue(name);
        ref.child(uid).child("addressLine1").setValue(addressLine1); /*, new Firebase.CompletionListener(){
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase)
            {
                if(firebaseError != null)
                {
                    Log.d("CBSE_ERROR", "data could not be saved");
                }
                else
                {
                    Log.d("CBSE_ERROR", "data saved successfully");
                }
            }
        });*/
        ref.child(uid).child("addressLine2").setValue(addressLine2);
        ref.child(uid).child("city").setValue(city);
        ref.child(uid).child("state").setValue(state);
        ref.child(uid).child("pincode").setValue(pincode);
        ref.child(uid).child("mobile").setValue(mobileNumber);
        displaySuccessMessage();
    }

    private void displaySuccessMessage()
    {
        findViewById(R.id.scrollView1).setVisibility(View.INVISIBLE);
        TextView textView = findViewById(R.id.textViewErrorText);
        textView.setVisibility(View.VISIBLE);
        textView.setText(getString(R.string.your_details_will_be_updated));
        textView.setTextColor(Color.BLUE);
        findViewById(R.id.buttonOk).setVisibility(View.VISIBLE);
    }
}
