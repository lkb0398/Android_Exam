
package com.lkb0398nate.androidexam.Calendar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.lkb0398nate.androidexam.Calendar.adapter.CalendarAdapter;

public class CalendarView extends GridView implements AdapterView.OnItemClickListener {

    // 코드상에서 생성될 댸 호출 하는 생성자
    public CalendarView(Context context) {
        this(context, null);
    }

    // xml 에 정의 되었을 때 호출 되는 생성자
    public CalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    // Widget 에서 호출 했을 때
    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setNumColumns(7); // 7열로 설정
        setBackgroundResource(android.R.color.darker_gray); // 배경 회색
        setHorizontalSpacing(1);
        setVerticalSpacing(1);

        setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (getAdapter() != null) {

            CalendarAdapter adapter = (CalendarAdapter) getAdapter();
            adapter.setSelectedPosition(position);
            adapter.notifyDataSetChanged();
        } else {
            throw new IllegalStateException("CalendarAdapter 를 셋팅 해야 합니다.");
        }
    }
}
