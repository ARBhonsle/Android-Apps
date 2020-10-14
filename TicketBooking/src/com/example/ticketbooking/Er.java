package com.example.ticketbooking;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Er extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_er);
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent log=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(log);
				finish();
			}        	
        }, 4500);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.er, menu);
		return true;
	}

}
