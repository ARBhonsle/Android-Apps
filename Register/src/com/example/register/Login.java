package com.example.register;

import java.util.Locale;

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

public class Login extends Activity {
	EditText uname,pass,email,phno;
	Button otp,ref;
	TextToSpeech txt;
	
	public static double random(){
		double otp = Math.random()*100000;
		return otp;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		uname = (EditText)findViewById(R.id.editText1);
		pass = (EditText)findViewById(R.id.editText2);
		email= (EditText)findViewById(R.id.editText3);
		phno = (EditText)findViewById(R.id.editText4);
		otp = (Button)findViewById(R.id.button1);
		ref = (Button)findViewById(R.id.Button01);
		txt= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int arg0) {
				// TODO Auto-generated method stub
				if(arg0 != TextToSpeech.ERROR){
					txt.setLanguage(Locale.UK);
				}
			}
		});
		
		otp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name=uname.getText().toString();
				String spass=pass.getText().toString();
				String mail=email.getText().toString();
				String sphno=phno.getText().toString();
				
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
					}
			}
		});
		ref.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent inp = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(inp);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
