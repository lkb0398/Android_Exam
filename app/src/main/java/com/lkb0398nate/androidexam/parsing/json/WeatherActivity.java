
package com.lkb0398nate.androidexam.parsing.json;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.lkb0398nate.androidexam.R;
import com.lkb0398nate.androidexam.utils.network.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junsuk on 15. 9. 14.. 날씨 정보 보여주는 앱
 */
public class WeatherActivity extends Activity implements View.OnKeyListener {

    private static final String TAG = WeatherActivity.class.getSimpleName();

    // 날씨 예보 제공 URL
    private static final String URL_FORECAST = "http://api.openweathermap.org/data/2.5/forecast?units=metric&q=";

    private EditText mCityEditText;
    private ListView mWeatherListView;
    private WeatherAdapter mAdapter;

    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weather);

        mCityEditText = (EditText) findViewById(R.id.et_city);
        mWeatherListView = (ListView) findViewById(R.id.lv_weather);

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);

        mCityEditText.setOnKeyListener(this);

        // Android 4.0 부터 네트워킹 제약
        new WeatherInfoLoadTask().execute("suwon");

    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            new WeatherInfoLoadTask().execute(mCityEditText.getText().toString());
            return true;
        }

        return false;
    }

    class WeatherInfoLoadTask extends AsyncTask <String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            mProgressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected Void doInBackground(String... params) {

            String query = params[0];

            try {
                // HTTP 에서 내용을 String 으로 받아 온다
                String jsonString = NetworkUtils.getReturnString(URL_FORECAST + query);

                // 받아온 JSON String 을 JSON Object로 변환한다
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = jsonObject.getJSONArray("list");

                // 날씨 정보 저장할 리스트
                List<Weather> weatherList = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);

                    String time = object.getString("dt_txt");
                    time = time.split(" ")[1].substring(0, 5);
                    String temp = object.getJSONObject("main").getString("temp");
                    String description = object.getJSONArray("weather")
                            .getJSONObject(0).getString("description");

                    weatherList.add(new Weather(time, temp, description));
                }

                mAdapter = new WeatherAdapter(WeatherActivity.this, weatherList);


            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            mWeatherListView.setAdapter(mAdapter);
            mProgressBar.setVisibility(View.GONE);

        }
    }
}
