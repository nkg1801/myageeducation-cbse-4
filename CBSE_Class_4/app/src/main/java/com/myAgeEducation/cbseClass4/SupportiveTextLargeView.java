package com.myAgeEducation.cbseClass4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SupportiveTextLargeView extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supportive_text_large_view);
        setSupportiveTextAndQuestion();
    }

    private void setSupportiveTextAndQuestion()
    {
        Bundle bundle = getIntent().getExtras();
        String supportiveText = bundle.getString("SupportiveText", "");
        String question = bundle.getString("Question", "");
        ((TextView)findViewById(R.id.textViewSupportiveText)).setText(supportiveText);
        ((TextView)findViewById(R.id.textViewQuestion)).setText(question);
    }

    public void onClickBackToQuestion(View view)
    {
        finish();
    }
}
