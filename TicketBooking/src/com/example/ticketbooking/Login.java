package com.example.ticketbooking;

import java.util.Locale;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class Login extends Activity {
	EditText n,p,e,ph;
	Button s,r;
	TextToSpeech t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		n=(EditText)findViewById(R.id.editText1);
		p=(EditText)findViewById(R.id.editText2);
		e=(EditText)findViewById(R.id.editText3);
		ph=(EditText)findViewById(R.id.editText4);
		s=(Button)findViewById(R.id.button1);
		r=(Button)findViewById(R.id.button2);
		t=new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int arg0) {
				// TODO Auto-generated method stub
				if(arg0 != TextToSpeech.ERROR){
					t.setLanguage(Locale.UK);
				}
			}
		});
		
		r.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ref=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(ref);				
			}
		});
		
		s.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s1=n.getText().toString();
				String s2=p.getText().toString();
				String s3=e.getText().toString();
				String s4=ph.getText().toString();
				if(!s1.equals(null) && !s2.equals(null)&& !s3.equals(null)&& !s4.equals(null)){
					SmsManager sms = SmsManager.getDefault();
					sms.sendTextMessage(s4, null, "login success", null, null);
					Toast.makeText(getApplicationContext(), "Accesing your account", Toast.LENGTH_LONG).show();
					String stxt = "Login success";
					t.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);
					Activitytask1 task=new Activitytask1();
					task.execute();
					Intent home = new Intent(getApplicationContext(),Home.class);
					startActivity(home);
				}
				else{
					Toast.makeText(getApplicationContext(), "Some error occured", Toast.LENGTH_LONG).show();
					String stxt = "Login unsuccessful";
					t.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);
					Intent err = new Intent(getApplicationContext(),Er.class);
					startActivity(err);
				}
				/*
					if(!sphno.equals(null) && !name.equals(null) && !mail.equals(null) && !spass.equals(null)){	
						SmsManager sms = SmsManager.getDefault();
						sms.sendTextMessage(sphno, null, "login success", null, null);
						Toast.makeText(getApplicationContext(), "Registering your account", Toast.LENGTH_LONG).show();
						String stxt = "Login success";
						txt.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);						
						Intent home = new Intent(getApplicationContext(),Home.class);
						startActivity(home);						
					}
					else if(spass.length()< 8){
						Toast.makeText(getApplicationContext(), "Password less than 8 characters", Toast.LENGTH_LONG).show();
					}
					else if(sphno.length() != 10){
						Toast.makeText(getApplicationContext(), "Phone number is incorrect", Toast.LENGTH_LONG).show();
					}
					else{
						Toast.makeText(getApplicationContext(), "Some error occured", Toast.LENGTH_LONG).show();
						String stxt = "Login unsuccessful";
						txt.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);
						Intent err = new Intent(getApplicationContext(),Error.class);
						startActivity(err);
					}*/
			}
		});
		}
	
	public class Activitytask1 extends AsyncTask<String,Void,Void>{
		String s1=n.getText().toString();
		String s2=p.getText().toString();
		String s3=e.getText().toString();
		String s4=ph.getText().toString();
		String res=null;
		protected void onPreExecute(){
			Toast.makeText(getApplicationContext(), "Please wait...", Toast.LENGTH_LONG).show();
		}
		@Override
		protected Void doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			res=Callservice.registerService(s1,s2,s3,s4,"Register");
			return null;
		}
		@SuppressWarnings("deprecation")
		protected void onPostExecute(){			
			Intent in = new Intent(getBaseContext(),Home.class);
			startActivity(in);
			try{
				SmsManager sms = SmsManager.getDefault();
				sms.sendTextMessage(s4, null, "login success", null, null);
				Toast.makeText(getApplicationContext(), "Registering your account", Toast.LENGTH_LONG).show();
				String stxt = "Login success";
				t.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);
			}
			catch(Exception e){
				Toast.makeText(getApplicationContext(), "Login not success", Toast.LENGTH_LONG).show();
				String stxt = "Login not success";
				t.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
