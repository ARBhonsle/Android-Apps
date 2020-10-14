package com.example.smsapp;

import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	EditText phno,txt;
	Button send;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        phno = (EditText)findViewById(R.id.editText1);
        txt = (EditText)findViewById(R.id.editText2);
        send = (Button)findViewById(R.id.button1);
        
        send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String aphno = phno.getText().toString();
				String smsg = txt.getText().toString();
				
				try{
					SmsManager sms = SmsManager.getDefault();
					sms.sendTextMessage(aphno, null, "SMS sent", null, null);
					Toast.makeText(getApplicationContext(), "SMS sent successfully", Toast.LENGTH_LONG).show();
				}
				catch(Exception e){
					Toast.makeText(getApplicationContext(), "failed to send SMS", Toast.LENGTH_LONG).show();
				}
				
			}
		});
                   	
    }	


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
