
package com.lkb0398nate.androidexam.mission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lkb0398nate.androidexam.R;

public class Mission01Activity extends AppCompatActivity {

    private Button mUpBtn;
    private Button mDownBtn;
    private ImageView mImageView1;
    private ImageView mImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission01);

        mUpBtn = (Button) findViewById(R.id.up_button);
        mDownBtn = (Button) findViewById(R.id.down_button);
        mImageView1 = (ImageView) findViewById(R.id.taste_view);
        mImageView2 = (ImageView) findViewById(R.id.null_view);

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downImage();
            }
        });

        mUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upImage();
            }
        });
    }

    public void upImage() {
        if (mImageView2.getVisibility() == View.VISIBLE) {

            mImageView1.setVisibility(View.VISIBLE);

            mImageView2.setVisibility(View.INVISIBLE);

        }

    }

    public void downImage() {

        if (mImageView1.getVisibility() == View.VISIBLE) {

            mImageView1.setVisibility(View.INVISIBLE);

            mImageView2.setVisibility(View.VISIBLE);


        }
    }

}
