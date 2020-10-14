package com.example.ticketbooking;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class Url extends Activity {
	EditText url;
	Button s,r;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_url);
		url = (EditText)findViewById(R.id.editTexturl);
		s = (Button)findViewById(R.id.buttonurl);
		r = (Button)findViewById(R.id.buttonr);
		s.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String surl = url.getText().toString();
				Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(surl));
				startActivity(i);
			}
		});
		r.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Layout.class);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.url, menu);
		return true;
	}

}
