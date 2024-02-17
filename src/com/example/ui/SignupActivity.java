package com.example.ui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends Activity {
    EditText mobnum,pass;
    Button submit;
    SharedPreferences sf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		
		mobnum=(EditText)findViewById(R.id.num);
		pass=(EditText)findViewById(R.id.password);
		submit=(Button)findViewById(R.id.submit);
		
		sf=getSharedPreferences("database", MODE_PRIVATE);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences.Editor ed=sf.edit();
				ed.putString("name", mobnum.getText().toString());
				ed.putString("pass", pass.getText().toString());
				ed.commit();
				Toast.makeText(getApplicationContext(), "submit succesfull", Toast.LENGTH_SHORT).show();
				Intent i=new Intent(SignupActivity.this,MainActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signup, menu);
		return true;
	}

}
