
package com.lkb0398nate.androidexam.mission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lkb0398nate.androidexam.R;

public class Mission02Activity extends AppCompatActivity {

    private Button mBtn1;
    private Button mBtn2;
    private EditText mEdit;
    private TextView mByteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission02);

        mBtn1 = (Button) findViewById(R.id.button1);
        mBtn2 = (Button) findViewById(R.id.button2);
        mEdit = (EditText) findViewById(R.id.edit_text);
        mByteText = ((TextView) findViewById(R.id.byte_text));

        mEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                mByteText.setText(s.toString().getBytes().length + "");
            }
        });

        mBtn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String message = mEdit.getText().toString();

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }

}
