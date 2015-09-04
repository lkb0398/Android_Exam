
package com.lkb0398nate.androidexam.mission;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lkb0398nate.androidexam.R;

public class Mission03Activity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission03);

        mButton = (Button) findViewById(R.id.button_log);

        mButton.setOnClickListener(this);

        intent = new Intent(getApplicationContext(), Mission03_menuActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_log:
                startActivityForResult(intent, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case 1:
                Toast.makeText(getApplicationContext(), data.getStringExtra("message"),
                        Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), data.getStringExtra("message"),
                        Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), data.getStringExtra("message"),
                        Toast.LENGTH_LONG).show();
                break;
        }
    }
}
