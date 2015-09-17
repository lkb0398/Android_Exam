
package com.lkb0398nate.androidexam.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lkb0398nate.androidexam.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ColorFragment extends Fragment {

    private ImageView mImageView;

    private List<String> list;

    public ColorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        mImageView = (ImageView) view.findViewById(R.id.iv_image);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = new ArrayList<>();
    }

    public void setColor(int color) {
        mImageView.setBackgroundColor(color);
    }
}
