package com.myAgeEducation.cbseClass4;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends Activity {
    String email;
    String pin;
    SharedPreferences sharedPreferences;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);
        mAuth = FirebaseAuth.getInstance();
        addBannerAd();
    }

    private void addBannerAd()
    {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    public void onClickRegisterUser(View view)
    {
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        email = editTextEmail.getText().toString();
        pin = ((EditText)(findViewById(R.id.editTextPin))).getText().toString();

        TextView textView = findViewById(R.id.textViewErrorText);
        String errorCode = validateFields();
        if(!errorCode.isEmpty())
        {
            textView = findViewById(R.id.textViewErrorText);
            textView.setText(errorCode);
            textView.setVisibility(View.VISIBLE);
            return;
        }
        else
        {
            textView.setVisibility(View.INVISIBLE);
        }
        createUserNew(email.trim(),pin.trim());
    }

    private String validateFields()
    {
        String errorText = "";

        String name = ((EditText)findViewById(R.id.editTextName)).getText().toString().trim();
        String city = ((EditText)findViewById(R.id.editTextCity)).getText().toString().trim();
        String email = ((EditText)findViewById(R.id.editTextEmail)).getText().toString().trim();
        String confirmEmail = ((EditText)findViewById(R.id.editTextConfirmEmail)).getText().toString().trim();
        String pin = ((EditText)(findViewById(R.id.editTextPin))).getText().toString().trim();
        String confirmPin = ((EditText)(findViewById(R.id.editTextConfirmPin))).getText().toString().trim();
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
        else if(!TextUtils.equals(email,confirmEmail))
        {
            errorText = "Email address does not match";
            findViewById(R.id.editTextConfirmEmail).requestFocus();
        }
        else if(pin.length() < 6 || pin.length() > 6)
        {
            errorText = "PIN should be 6 digit";
            findViewById(R.id.editTextPin).requestFocus();
        }
        else if(!TextUtils.equals(pin, confirmPin))
        {
            errorText = "PIN does not match";
            findViewById(R.id.editTextConfirmPin).requestFocus();
        }

        return errorText;
    }

    private void createUserNew(final String email, final String pin)
    {
        mAuth.createUserWithEmailAndPassword(email, pin)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(user != null) {
                                saveUserInfoLocally(user);
                                Util.UserUid = user.getUid();
                                saveUserData(Util.UserUid);

                                user.sendEmailVerification()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Log.d("CBSE", "verification email sent");
                                                }
                                            }
                                        });
                            }

                            Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_LONG).show();
                            openLoginActivity();
                            finish();
                        }
                        else
                        {
                            Log.d("CBSE", "signInWithEmail:failure", task.getException());
                            String error = task.getException().getMessage();
                            TextView textView = findViewById(R.id.textViewErrorText);
                            textView.setText(error);
                            textView.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }

    private void openLoginActivity()
    {
        Intent intentLogin = new Intent(Registration.this, LoginSignupActivity.class);
        startActivity(intentLogin);
    }

    private void saveUserInfoLocally(FirebaseUser user)
    {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefEdit = sharedPreferences.edit();
        prefEdit.putString("email", user.getEmail());
        prefEdit.apply();
    }

    private void saveUserData(String uid)
    {
        Firebase.goOnline();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefEdit = sharedPreferences.edit();
        prefEdit.putString("uuid", uid);
        prefEdit.apply();

        Util.UserUid = uid;

        String name = ((EditText)findViewById(R.id.editTextName)).getText().toString().trim();
        String addressLine1 = ((EditText)findViewById(R.id.editTextAddressLine1)).getText().toString().trim();
        String addressLine2 = ((EditText)findViewById(R.id.editTextAddressLine2)).getText().toString().trim();
        String city = ((EditText)findViewById(R.id.editTextCity)).getText().toString().trim();
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
        String mobileNumber = ((EditText)findViewById(R.id.editTextMobileNumber)).getText().toString().trim();
        String email = ((EditText)findViewById(R.id.editTextEmail)).getText().toString().trim();

        Firebase ref = new Firebase(Util.ContestUserRoot);
        ref.child(uid).child("name").setValue(name);
        ref.child(uid).child("addressLine1").setValue(addressLine1);
        ref.child(uid).child("addressLine2").setValue(addressLine2);
        ref.child(uid).child("city").setValue(city);
        ref.child(uid).child("state").setValue(state);
        ref.child(uid).child("pincode").setValue(pincode);
        ref.child(uid).child("mobile").setValue(mobileNumber);
        ref.child(uid).child("email").setValue(email);
        ref.child(uid).child("dateOfSignUp").setValue(Util.getCurrentDateTime());
        ref.child(uid).child("registeredVia").setValue(Util.SyllabusAndGrade);
    }
}
