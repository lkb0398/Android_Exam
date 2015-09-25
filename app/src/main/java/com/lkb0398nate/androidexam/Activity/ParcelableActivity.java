
package com.lkb0398nate.androidexam.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lkb0398nate.androidexam.Calendar.model.Schedule;

/**
 * Created by kb on 2015-09-24.
 */
public class ParcelableActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setText("Parcelable 데이터 전송");

        setContentView(button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, TargetActivity.class);

        Schedule schedule = new Schedule(10, 10, "바쁘다");

        startActivity(intent);

    }

}
