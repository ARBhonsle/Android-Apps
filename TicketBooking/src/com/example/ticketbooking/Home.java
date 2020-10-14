package com.example.ticketbooking;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings({ "deprecation", "unused" })
public class Home extends TabActivity {
	TabHost t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		t=(TabHost)findViewById(android.R.id.tabhost);
		TabSpec  t1=t.newTabSpec("First");
		TabSpec t2=t.newTabSpec("Second");
		t1.setIndicator("Home");
		t1.setContent(new Intent(this,Url.class));
		t2.setIndicator("Exit");
		t2.setContent(new Intent(this,Alert.class));
		t.addTab(t1);
		t.addTab(t2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
}
