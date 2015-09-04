package com.lkb0398nate.androidexam.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lkb0398nate.androidexam.R;

public class ActivityExamActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private EditText mNameText;
    private EditText mPhoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_exam);

        mButton = (Button)findViewById(R.id.activity_button);
        mNameText = (EditText)findViewById(R.id.name_edit_text);
        mPhoneText = (EditText)findViewById(R.id.phone_edit_text);

        mButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TargetActivity.class);

        intent.putExtra("name", mNameText.getText().toString());
        intent.putExtra("phone", mPhoneText.getText().toString());

        startActivity(intent);

    }
}
