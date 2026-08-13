package com.myAgeEducation.cbseClass4;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class OfflineVersionActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline_version);
    }

    public void onClickPlayStoreImage(View view)
    {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.greenpixeducation.cbseClass4Paid"));
            startActivity(intent);
        }
        catch(Exception e)
        {
            Util.displayAlert("Cannot open play store. Open play store manually and search for CBSE Class 4", "Error", OfflineVersionActivity.this);
        }
    }
}
