package com.example.register;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Sub extends Activity {
	EditText otp,pass;
	Button sub;
	TextToSpeech txt;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		otp = (EditText)findViewById(R.id.editTextotp);
		pass = (EditText)findViewById(R.id.editTextpwd);		
		sub = (Button)findViewById(R.id.buttonotp);
		txt= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int arg0) {
				// TODO Auto-generated method stub
				if(arg0 != TextToSpeech.ERROR){
					txt.setLanguage(Locale.UK);
				}
			}
		});
		
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String stxt = "enter otp to register account";
				txt.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);
				String p = pass.getText().toString();
				String sotp = otp.getText().toString();
				stxt = "Login success";
				txt.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);
				Intent home = new Intent(getApplicationContext(),Home.class);
				startActivity(home);
				txt.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);				
				stxt = "Login success";
				txt.speak(stxt, TextToSpeech.QUEUE_FLUSH, null);
				
			  }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub, menu);
		return true;
	}

}
