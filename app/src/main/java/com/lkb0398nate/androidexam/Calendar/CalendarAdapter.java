
package com.lkb0398nate.androidexam.Calendar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lkb0398nate.androidexam.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CalendarAdapter extends BaseAdapter {

    private List<Calendar> mList;
    private Context mContext;
    private Calendar mCalendar;

    private int mSelectedPosition = -1;

    public int getSelectedPosition() {
        return mSelectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.mSelectedPosition = selectedPosition;
    }


    public CalendarAdapter(Context context) {

        mContext = context;

        mCalendar = GregorianCalendar.getInstance();
        createCalendar(mCalendar);
    }

    private void createCalendar(Calendar calendar) {
        mList = new ArrayList<>();

        // 오늘 날짜

        int lastDay = calendar.getActualMaximum(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        // 이번 달 첫 번째 날.
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDate = calendar.get(Calendar.DAY_OF_WEEK);

        // 공백
        for (int i = 1; i < firstDate; i++) {
            mList.add(null);
        }

        // 이번 달 달력 데이터
        for (int i = 1; i <= lastDay; i++) {
            mList.add(new GregorianCalendar(year, month, i));
        }
    }

    public void prevMonth() {

        changeMonth(-1);
    }

    public void nextMonth() {
        // 다음 달로 설정
        changeMonth(1);
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

    private void changeMonth(int month) {
        mCalendar.add(Calendar.MONTH, month);
        createCalendar(mCalendar);
        mSelectedPosition = -1;

        // 어뎁터에 바뀐 데이터를 반영하도록 알려 줌
        notifyDataSetChanged();
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

    // 아이템이 화면에 보일때 호출 됨.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        // Layout 을 완성하고 ViewHolder와 연결
        // 이유 : findViewById를 한번만 하려고.
        if (convertView == null) {
            holder = new ViewHolder();
            // 처음 로드
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_calendar, parent,
                    false);

            holder.dateTextView = (TextView) convertView.findViewById(R.id.tv_date);

            convertView.setTag(holder);
        } else {
            // 재사용
            holder = (ViewHolder) convertView.getTag();
        }

        // Data 를 Layout 에 설정

        Calendar calendar = mList.get(position);
        if (calendar != null) {
            holder.dateTextView.setText("" + calendar.get(Calendar.DATE));

            if (position % 7 == 0) {
                holder.dateTextView.setTextColor(Color.RED);

            } else if ((position + 1) % 7 == 0) {
                holder.dateTextView.setTextColor(Color.BLUE);

            } else {
                holder.dateTextView.setTextColor(Color.BLACK);
            }
        } else {

            holder.dateTextView.setText("");
        }

        // 선택 된 셀의 색상변경 부분.
        if (position == mSelectedPosition) {
            convertView.setBackgroundColor(Color.YELLOW);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
        }

        return convertView;

    }

    static class ViewHolder {

        TextView dateTextView;
    }
}
