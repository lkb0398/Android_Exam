
package com.lkb0398nate.androidexam.mission;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
        Button button = (Button)v;
        intent.putExtra("message", button.getText());

        switch (v.getId()) {
            case R.id.button_guest:
                setResult(1, intent);
                break;
            case R.id.button_pay:
                setResult(2, intent);
                break;
            case R.id.button_product:
                setResult(3, intent);
                break;
        }

        openDialog(button.getText().toString());
    }

    private void openDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Mission03_menuActivity.this);
        builder.setTitle(title);
        builder.setNegativeButton("닫기", null);
        builder.show();
    }

}
