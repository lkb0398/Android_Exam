
package com.lkb0398nate.androidexam.database.helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lkb0398nate.androidexam.R;

/**
 * Created by kb on 2015-09-18.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private UserDbHelper mUserDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        findViewById(R.id.tv_sign_up).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);

        mUserDbHelper = new UserDbHelper(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sign_up:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case R.id.btn_login:
                // TODO 로그인처리

                // long insertedId = mUserDbHelper.inser("test", "test",
                // "test");

//                int count = mUserDbHelper.update("test", "테스트");

                if (mUserDbHelper.delete("test")) {
                    Toast.makeText(LoginActivity.this, "Delete 성공", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(LoginActivity.this, " Delete 실패", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
