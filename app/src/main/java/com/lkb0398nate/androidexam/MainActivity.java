
package com.lkb0398nate.androidexam;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lkb0398nate.androidexam.Activity.ActivityExamActivity;
import com.lkb0398nate.androidexam.Activity.WebActivity;
import com.lkb0398nate.androidexam.Animation.AnimationActivty;
import com.lkb0398nate.androidexam.Calendar.CalendarActivity;
import com.lkb0398nate.androidexam.Calendar2.Calendar2Activity;
import com.lkb0398nate.androidexam.Fragment.FragmentActivity;
import com.lkb0398nate.androidexam.database.helper.LoginActivity;
import com.lkb0398nate.androidexam.graphic.GraphicActivity;
import com.lkb0398nate.androidexam.mission.Mission01Activity;
import com.lkb0398nate.androidexam.mission.Mission02Activity;
import com.lkb0398nate.androidexam.mission.Mission03Activity;
import com.lkb0398nate.androidexam.mission.Mission05Activity;
import com.lkb0398nate.androidexam.mission.extra.ListView_Activity;
import com.lkb0398nate.androidexam.parsing.json.WeatherActivity;
import com.lkb0398nate.androidexam.thread.ThreadActivity;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new SimpleAdapter(this, getData(),
                android.R.layout.simple_list_item_1, new String[] {
                        "title"
                },
                new int[] {
                        android.R.id.text1
                }));
        getListView().setTextFilterEnabled(true);
    }

    protected List<Map<String, Object>> getData() {
        List<Map<String, Object>> myData = new ArrayList<>();

        // 메뉴 추가 부분
        // addItem(myData, "TransitionDrawable",
        // TransitionDrawableExamActivity.class);
        addItem(myData, "FramLayout", FramLayoutActivity.class);
        addItem(myData, "up, down", Mission01Activity.class);
        addItem(myData, "Mission02", Mission02Activity.class);
        addItem(myData, "Mission03", Mission03Activity.class);
        addItem(myData, "화면이동 예쩨", ActivityExamActivity.class);
        addItem(myData, "Web_View 연습", WebActivity.class);
        addItem(myData, "애니메이션 연습", AnimationActivty.class);
        addItem(myData, "Mission05", Mission05Activity.class);
        addItem(myData, "Calendar", CalendarActivity.class);
        addItem(myData, "달력2", Calendar2Activity.class);
        addItem(myData, "리스트뷰", ListView_Activity.class);
        addItem(myData, "Thread", ThreadActivity.class);
        addItem(myData, "json", WeatherActivity.class);
        addItem(myData, "Fragment", FragmentActivity.class);
        addItem(myData, "ShapeView", GraphicActivity.class);
        addItem(myData, "Login", LoginActivity.class);

        // ----- 메뉴 추가 여기까지

        // 이름 순 정렬
        Collections.sort(myData, sDisplayNameComparator);

        return myData;
    }

    private final static Comparator<Map<String, Object>> sDisplayNameComparator =
            new Comparator<Map<String, Object>>() {
                private final Collator collator = Collator.getInstance();

                public int compare(Map<String, Object> map1, Map<String, Object> map2) {
                    return collator.compare(map1.get("title"), map2.get("title"));
                }
            };

    protected void addItem(List<Map<String, Object>> data, String name, Intent intent) {
        Map<String, Object> temp = new HashMap<>();
        temp.put("title", name);
        temp.put("intent", intent);
        data.add(temp);
    }

    protected void addItem(List<Map<String, Object>> data, String name, Class cls) {
        this.addItem(data, name, new Intent(this, cls));
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map<String, Object> map = (Map<String, Object>) l.getItemAtPosition(position);

        Intent intent = (Intent) map.get("intent");
        startActivity(intent);
    }
}
