
package com.lkb0398nate.androidexam.mission;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lkb0398nate.androidexam.R;

public class Mission03_menuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton1, mButton2, mButton3;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission03_menu);

        mButton1 = (Button) findViewById(R.id.button_guest);
        mButton2 = (Button) findViewById(R.id.button_pay);
        mButton3 = (Button) findViewById(R.id.button_product);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);

        intent = new Intent();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_guest:
                intent.putExtra("message", mButton1.getText());
                setResult(1, intent);
                finish();
                break;
            case R.id.button_pay:
                intent.putExtra("message", mButton2.getText());
                setResult(2, intent);
                finish();
                break;
            case R.id.button_product:
                intent.putExtra("message", mButton3.getText());
                setResult(3, intent);
                finish();
                break;
        }
    }

}
