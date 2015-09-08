
package com.lkb0398nate.androidexam.mission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lkb0398nate.androidexam.R;

import java.util.Calendar;

public class Mission05Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnBirth;
    private Button mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission05);

        mBtnBirth = (Button) findViewById(R.id.birthday_btn);
        mBtnStart = (Button) findViewById(R.id.start_btn);

        mBtnBirth.setOnClickListener(this);
        mBtnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.birthday_btn:
                break;

            case R.id.start_btn:
                break;
        }
    }

    // 현재 날짜 & 시간 표시
    public void onBtnDateTime() {
        String strResult = "";
        // 현재 날짜 구하기
        Calendar calendar = Calendar.getInstance();

        mBtnBirth.setText(strResult);
    }

}
