
package com.lkb0398nate.androidexam.mission.extra;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.lkb0398nate.androidexam.R;

import java.util.ArrayList;
import java.util.List;

public class ListView_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_);

        // Data 초기화
        List<Funny> list = initData();

        // 어댑터 초기화
        FunnyAdapter adapter = new FunnyAdapter(this, list);

        // 리스트뷰에 어댑터 연결
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @NonNull
    private List<Funny> initData() {
        List<Funny> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Funny(R.drawable.monkey, "어려워", "너무"));
        }
        return list;
    }
}
