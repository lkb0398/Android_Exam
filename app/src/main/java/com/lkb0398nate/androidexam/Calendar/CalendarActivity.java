
package com.lkb0398nate.androidexam.Calendar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.lkb0398nate.androidexam.Calendar.adapter.CalendarAdapter;
import com.lkb0398nate.androidexam.Calendar.adapter.TodoAdapter;
import com.lkb0398nate.androidexam.Calendar.model.Schedule;
import com.lkb0398nate.androidexam.Calendar.view.CalendarView;
import com.lkb0398nate.androidexam.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    private CalendarAdapter mCalendarAdapter;
    private CalendarView mCalendarView;
    private TextView mTitleText;
    private ListView mTodoListView;
    private TodoAdapter mTodoAdapter;

    private Map<Calendar, List<Schedule>> mScheduleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mScheduleMap = new HashMap<>();

        mTitleText = (TextView) findViewById(R.id.tv_title);

        // 버튼 이벤트 연결
        findViewById(R.id.btn_prev_month).setOnClickListener(this);
        findViewById(R.id.btn_next_month).setOnClickListener(this);

        mCalendarView = (CalendarView) findViewById(R.id.calendar);
        mTodoListView = (ListView) findViewById(R.id.lv_todo);

        // 어댑터 준비
        // View 에 어댑터를 설정
        mCalendarAdapter = new CalendarAdapter(this);
        mCalendarView.setAdapter(mCalendarAdapter);

        // List<Schedule> test = new ArrayList<>();
        // test.add(new Schedule(5, 30, "땡땡이"));
        // test.add(new Schedule(6, 30, "밥 먹기"));
        // test.add(new Schedule(7, 30, "잠자기"));

        // mTodoAdapter = new TodoAdapter(this, test);
        // mTodoListView.setAdapter(mTodoAdapter);

        // 아이템 클릭 이벤트 연결
        mCalendarView.setOnItemLongClickListener(this);
        mCalendarView.setOnItemClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_prev_month:
                mCalendarAdapter.prevMonth();
                upDateTitle();
                break;

            case R.id.btn_next_month:
                mCalendarAdapter.nextMonth();
                upDateTitle();
                break;

            default:
                break;
        }

    }

    private void upDateTitle() {
        int month = mCalendarAdapter.getCalendar().get(Calendar.MONTH) + 1;
        int year = mCalendarAdapter.getCalendar().get(Calendar.YEAR);
        mTitleText.setText(year + "년" + month + "월");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        View layout = getLayoutInflater().inflate(R.layout.dialog_schedule, null);
        final TimePicker timePicker = (TimePicker) layout.findViewById(R.id.picker_time);
        final EditText editText = (EditText) layout.findViewById(R.id.et_schedule);

        final Calendar calendar = (Calendar) mCalendarAdapter.getItem(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setNegativeButton("닫기", null);
        builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 뭔가 합니다.

                // 6.0버전부터 변경.
                // getCurrentHour() -> getHour()
                // getCurrentMinute() -> getMinute()
                Schedule schedule = new Schedule(timePicker.getCurrentHour(),
                        timePicker.getCurrentMinute(),
                        editText.getText().toString());

                // 현재 날짜에 연결 된 일정 릴스트를 얻음.
                List<Schedule> list = mScheduleMap.get(calendar);

                if (list == null) {
                    list = new ArrayList<>();
                }
                // 지금 추가 할 스케줄 추가.
                list.add(schedule);

                // 전채 일정에 오늘 날짜와 스케줄을 연결하여 추가.
                mScheduleMap.put(calendar, list);

                // 어댑터에 표시할 스케줄 리스트를 전달.
                mTodoAdapter = new TodoAdapter(CalendarActivity.this, list);

                // 리스트뷰에 어댑터를 열결
                mTodoListView.setAdapter(mTodoAdapter);
            }
        });
        builder.setView(layout);
        builder.show();

        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        mCalendarAdapter.setSelectedPosition(position);
        mCalendarAdapter.notifyDataSetChanged();

        // 현재 날짜에 연결 된 일정 리스트 얻음.
        Calendar calendar = (Calendar) mCalendarAdapter.getItem(position);
        List<Schedule> list = mScheduleMap.get(calendar);

        if (list == null) {
            list = Collections.emptyList();
        }

        // 어댑터에 표시할 스케줄 리스트를 전달.
        mTodoAdapter = new TodoAdapter(CalendarActivity.this, list);

        // 리스트뷰에 어댑터를 열결
        mTodoListView.setAdapter(mTodoAdapter);
    }

}
