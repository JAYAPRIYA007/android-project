package com.example.ui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyitemActivity extends Activity {

	EditText number,address;
	Button confrom;
	String amount;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buyitem);
		
		number=(EditText)findViewById(R.id.phnob);
		address=(EditText)findViewById(R.id.adress);
		confrom=(Button)findViewById(R.id.conform);
		
		Intent i=getIntent();
		amount=i.getStringExtra("ramount");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		confrom.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences sf=getSharedPreferences("walet", MODE_PRIVATE);
				SharedPreferences.Editor ed=sf.edit();
				ed.putString("k1", amount);
				ed.commit();
				String numb=number.getText().toString();
				String message="hai congrats successfull order your mobile resive with in 6 days"+"\n your adress "+address.getText().toString()+"\nremaining amount :"+amount;
				SmsManager sm=SmsManager.getDefault();
				sm.sendTextMessage(numb, null, message, null, null);
				Toast.makeText(getApplicationContext(), "succesfull buy", Toast.LENGTH_SHORT).show();
				Intent i=new Intent(BuyitemActivity.this,ShopActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buyitem, menu);
		return true;
	}

}
