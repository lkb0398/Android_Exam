
package com.lkb0398nate.androidexam.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.lkb0398nate.androidexam.R;

public class AnimationActivty extends Activity implements View.OnClickListener {

    private Animation mScaleAndRotateAnimation;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation);

        mImageView = (ImageView) findViewById(R.id.image_view);
        findViewById(R.id.start_btn).setOnClickListener(this);

        mScaleAndRotateAnimation = AnimationUtils.loadAnimation(AnimationActivty.this,
                R.anim.anim_scale_rotate);
    }

    @Override
    public void onClick(View v) {
        mImageView.startAnimation(mScaleAndRotateAnimation);
    }
}
