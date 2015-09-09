
package com.lkb0398nate.androidexam.mission;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.lkb0398nate.androidexam.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Mission05Activity extends AppCompatActivity implements View.OnClickListener {

    int year, month, date;

    private Button mBtnBirth;
    private Button mBtnStart;
    private EditText mName;
    private EditText mOld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission05);

        GregorianCalendar calendar = new GregorianCalendar();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        date = calendar.get(Calendar.DAY_OF_MONTH);

        mBtnBirth = (Button) findViewById(R.id.birthday_btn);
        mBtnStart = (Button) findViewById(R.id.start_btn);
        mName = (EditText) findViewById(R.id.name);
        mOld = (EditText) findViewById(R.id.old);

        mBtnBirth.setOnClickListener(this);
        mBtnStart.setOnClickListener(this);

        mBtnBirth.setText(year + "년" + (month + 1) + "월" + date + "일");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.birthday_btn:
                DatePickerDialog dialog = new DatePickerDialog(this, listener, year, month, date);
                dialog.show();
                break;

            case R.id.start_btn:

                Toast.makeText(Mission05Activity.this,
                        mName.getText() + "," + mOld.getText() + "," + mBtnBirth.getText(),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int date) {
            Toast.makeText(getApplicationContext(), year + "년" + (month + 1) + "월" + date + "일",
                    Toast.LENGTH_SHORT).show();
            mBtnBirth.setText(year + " 년" + (month + 1) + "월" + date + "일 ");

        }
    };

}
