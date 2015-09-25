
package com.lkb0398nate.androidexam.database.helper;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lkb0398nate.androidexam.R;
import com.lkb0398nate.androidexam.database.contract.ScheduleContract;

/**
 * Created by kb on 2015-09-18.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ParseLoginHelper mParseLoginHelper;
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.edit_email);
        mPassword = (EditText) findViewById(R.id.edit_password);

        findViewById(R.id.tv_sign_up).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);

        mParseLoginHelper = new ParseLoginHelper(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sign_up:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case R.id.btn_login:
                // TODO 로그인처리

                ParseLoginHelper helper = new ParseLoginHelper(this);
                Cursor cursor = helper.query();

                if (cursor != null) {
                    while (cursor.moveToFirst()) {
                        String email = cursor
                                .getString(cursor
                                        .getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_MINUTE));

                        String password = cursor
                                .getString(cursor
                                        .getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_CONTENTS));

                        if (email.equals(mEmail.getText().toString()) &&
                                password.equals(mPassword.getText().toString())) {
                            Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                }

                Toast.makeText(LoginActivity.this, "이메일 또는 패스워드가 틀렸습니다.", Toast.LENGTH_SHORT)
                        .show();
                break;

        }
    }
}
