
package com.lkb0398nate.androidexam.Calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by kb on 2015-09-08.
 */
public class CalendarView extends GridView {

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
    }
}
