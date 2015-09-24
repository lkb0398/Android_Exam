
package com.lkb0398nate.androidexam.database.helper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lkb0398nate.androidexam.R;

/**
 * Created by kb on 2015-09-18.
 */
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mNickname;
    private EditText mPasswordVerify;
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        mNickname = (EditText) findViewById(R.id.edit_nickname);
        mEmail = (EditText) findViewById(R.id.edit_email);
        mPassword = (EditText) findViewById(R.id.edit_password);
        mPasswordVerify = (EditText) findViewById(R.id.edit_password_verify);

        findViewById(R.id.btn_sign_up).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (mPassword.getText().toString().equals(mPasswordVerify.getText().toString()) == false) {
            Toast.makeText(SignUpActivity.this, "패스워드를 확인 해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        // 가입처리
        UserDbHelper helper = new UserDbHelper(this);

        long inserted = helper.insert(mNickname.getText().toString(), mEmail.getText().toString(),
                mPassword.getText().toString());

        if (inserted != -1) {
            Toast.makeText(SignUpActivity.this, "가입 되었습니다. 로그인 해 주세요.", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(SignUpActivity.this, "email 이 중복 되었습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
