package com.example.ui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BuyActivity extends Activity {
    Button buybtn;
	ImageView im;
	TextView name,cost;
	String model,priz;
	int img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
		
		im=(ImageView)findViewById(R.id.bimg);
		name=(TextView)findViewById(R.id.bname);
		cost=(TextView)findViewById(R.id.bcost);
		buybtn=(Button)findViewById(R.id.buy);
		
		Intent in=getIntent();
		Bundle b=in.getExtras();
		img=b.getInt("image");
		model=b.getString("model");
		priz=b.getString("cost");
		
		im.setImageResource(img);
		name.setText(model);
		cost.setText("Cost : "+priz);
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		buybtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences sf=getSharedPreferences("walet", MODE_PRIVATE);
				int new1=Integer.parseInt(priz);
				int old=Integer.parseInt(sf.getString("k1", "0.0"));
				int total=old-new1;
				if(total>=0)
				{
					Intent in=new Intent(BuyActivity.this,BuyitemActivity.class);
					in.putExtra("ramount", String.valueOf(total));
					startActivity(in);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "not enough money please check your wallet", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buy, menu);
		return true;
	}

}
