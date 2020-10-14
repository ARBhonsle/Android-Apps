package com.example.register;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings({ "deprecation", "unused" })
public class Home  extends TabActivity {
	TabHost t;	
	Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		t=(TabHost)findViewById(android.R.id.tabhost);
		TabSpec t1=t.newTabSpec("First");
		TabSpec t2=t.newTabSpec("Second");
		TabSpec t3=t.newTabSpec("Third");
		t1.setIndicator("Home");
		t1.setContent(new Intent(this,Url.class));
		t2.setIndicator("Web");
		t2.setContent(new Intent(this,Web.class));
		t3.setIndicator("Exit");
		t3.setContent(new Intent(this,Alert.class));
		t.addTab(t1);
		t.addTab(t2);
		t.addTab(t3);
		
		/*tab = (TabHost)findViewById(android.R.id.tabhost);
		TabSpec tab1 = tab.newTabSpec("First");
        TabSpec tab2 = tab.newTabSpec("Second"); 
        TabSpec tab3 = tab.newTabSpec("Third");        
        tab1.setIndicator("Home");
        tab1.setContent(new Intent(this,Url.class));
        tab2.setIndicator("Web");
        tab2.setContent(new Intent(this, Web.class));
        tab2.setIndicator("Exit");
        tab2.setContent(new Intent(this, Alert.class));
        tab.addTab(tab1);
        tab.addTab(tab2);
        tab.addTab(tab3);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
