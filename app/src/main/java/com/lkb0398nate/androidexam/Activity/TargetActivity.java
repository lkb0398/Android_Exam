
package com.lkb0398nate.androidexam.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lkb0398nate.androidexam.R;

public class TargetActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");

        Toast.makeText(TargetActivity.this, "name : " + name + "phone" + phone, Toast.LENGTH_LONG).show();

        findViewById(R.id.finish_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Activity 종료
        finish();
    }
}
