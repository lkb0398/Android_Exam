
package com.lkb0398nate.androidexam.mission.extra;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lkb0398nate.androidexam.R;

import java.util.List;
import java.util.Random;

/**
 * Created by kb on 2015-09-10.
 */
public class FunnyAdapter extends BaseAdapter {

    private Context mContext;
    private List<Funny> mList;

    public FunnyAdapter(Context context, List<Funny> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // layout 을 통째로 convertView 변수에 연결
        convertView = 레이아웃통째로빼기(parent);

        Funny funny = mList.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.monkey_image);
        TextView text1 = (TextView) convertView.findViewById(R.id.difficult_text);
        TextView text2 = (TextView) convertView.findViewById(R.id.very_text);

        imageView.setImageResource(funny.getImage());
        text1.setText(funny.getText1());
        text2.setText(funny.getText2());

        랜덤색상을레이아웃에적용하기(convertView);

        return convertView;
    }

    private void 랜덤색상을레이아웃에적용하기(View convertView) {
        Random rand = new Random();
        int color = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));

        convertView.setBackgroundColor(color);
    }

    private View 레이아웃통째로빼기(ViewGroup parent) {
        View convertView;
        convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_list_view_item,
                parent, false);
        return convertView;
    }

}
