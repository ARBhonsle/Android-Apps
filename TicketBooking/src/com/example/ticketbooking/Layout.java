package com.example.ticketbooking;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Layout extends Activity {
	String a;
	Button l,w,h,i,r;
	RatingBar rate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout);
		
		l=(Button)findViewById(R.id.buttonlay1);
		w=(Button)findViewById(R.id.buttonw);
		h=(Button)findViewById(R.id.buttonh);
		i=(Button)findViewById(R.id.items);
		r=(Button)findViewById(R.id.buttonrate);
		rate=(RatingBar)findViewById(R.id.ratingBar1);
		a=getString(R.id.buttonlay1);
		
		l.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();
			}
		});
		w.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Web.class);
				startActivity(i);
			}
		});
		h.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Home.class);
				startActivity(i);
			}
		});
		i.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String i=getString(R.id.items);
				Toast.makeText(getApplicationContext(), i, Toast.LENGTH_LONG).show();
			}
		});
		r.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String srate = String.valueOf(rate.getRating());
				Toast.makeText(getApplicationContext(),srate,Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout, menu);
		return true;
	}

}
