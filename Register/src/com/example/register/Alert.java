package com.example.register;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Alert extends Activity {
	Button close;
	AlertDialog.Builder b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert);
		
		close = (Button)findViewById(R.id.buttonc);
		b= new AlertDialog.Builder(this);
		
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				b.setMessage("Do you wish to close the application?");
				b.setCancelable(false);
				b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Intent i = new Intent(getApplicationContext(),MainActivity.class);
						startActivity(i);
						finish();			
					}
				});
				b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Intent i = new Intent(getApplicationContext(),Home.class);
						startActivity(i);
						finish();
						arg0.cancel();
						Toast.makeText(getApplicationContext(), "No Button is selected", Toast.LENGTH_LONG).show();	
					}
				});
				
				AlertDialog dialog = b.create();
				dialog.setTitle("Warning");
				dialog.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alert, menu);
		return true;
	}

}
