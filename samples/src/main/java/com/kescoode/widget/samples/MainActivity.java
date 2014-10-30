package com.kescoode.widget.samples;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kescoode.android.widget.SwipeRefreshLayout;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

	private SwipeRefreshLayout mSwipeLayout;
	private ListView mListView;
	private ArrayList<String> list = new ArrayList<String>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mListView = (ListView) findViewById(R.id.listview);
		mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				getData()));

		mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
		mSwipeLayout.setOnRefreshListener(this);
		mSwipeLayout.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_green_light, android.R.color.holo_orange_light,
				android.R.color.holo_red_light);
	}

	private ArrayList<String> getData() {
        list.add("Welcome");
        list.add("你好");
        list.add("もしもし");
        list.add("Bonjour");
        return list;
    }

	public void onRefresh() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				mSwipeLayout.setRefreshing(false);
			}
		}, 5000);
	}
}
