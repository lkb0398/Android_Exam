
package com.lkb0398nate.androidexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FramLayoutActivity extends AppCompatActivity {

    private Button mChangeBtn;
    private ImageView mImageView1;
    private ImageView mImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fram_layout);

        mChangeBtn = (Button) findViewById(R.id.change_btn);
        mImageView1 = (ImageView) findViewById(R.id.mao_view);
        mImageView2 = (ImageView) findViewById(R.id.mic_view);

        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changImage();
            }
        });

    }

    public void changImage() {

        if (mImageView1.getVisibility() == View.VISIBLE) {

            mImageView1.setVisibility(View.INVISIBLE);

            mImageView2.setVisibility(View.VISIBLE);

        } else if (mImageView2.getVisibility() == View.VISIBLE) {

            mImageView2.setVisibility(View.INVISIBLE);

            mImageView1.setVisibility(View.VISIBLE);
        }

    }
}
