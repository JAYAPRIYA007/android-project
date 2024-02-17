package com.example.ui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WaletActivity extends Activity {

	TextView im;
	Button add,back;
	EditText mony;
	SharedPreferences sf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_walet);
		
		add=(Button)findViewById(R.id.addm);
		back=(Button)findViewById(R.id.wback);
		mony=(EditText)findViewById(R.id.mony);
		im=(TextView)findViewById(R.id.iam);
		
		sf=getSharedPreferences("walet", MODE_PRIVATE);
		im.setText("Initial Walet"+"\nRs : "+sf.getString("k1", "0.0"));
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences.Editor ed=sf.edit();
				ed.putString("k1", mony.getText().toString());
				ed.commit();
				Toast.makeText(getApplicationContext(), "add succesfull", Toast.LENGTH_SHORT).show();
				Intent i=new Intent(WaletActivity.this,ShopActivity.class);
				startActivity(i);
			}
		});
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(WaletActivity.this,ShopActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.walet, menu);
		return true;
	}

}
