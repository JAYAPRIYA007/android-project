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

public class MainActivity extends Activity {
    EditText uname,pass;
    Button login,sign;
    SharedPreferences sf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		uname=(EditText)findViewById(R.id.user);
		pass=(EditText)findViewById(R.id.pass);
		login=(Button)findViewById(R.id.login);
		sign=(Button)findViewById(R.id.signup);
		
		sf=getSharedPreferences("database", MODE_PRIVATE);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name=sf.getString("name", "");
				String pass1=sf.getString("pass", "");
				if(name.equals(uname.getText().toString()) && pass1.equals(pass.getText().toString()))
				{
					Intent i=new Intent(MainActivity.this,LogActivity.class);
					startActivity(i);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "user or pass incorrect", Toast.LENGTH_SHORT).show();
				}
			}
		});
		sign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,SignupActivity.class);
				startActivity(i);
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
