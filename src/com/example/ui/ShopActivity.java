package com.example.ui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class ShopActivity extends Activity {
    GridView gr;
    int[] image={R.drawable.mobile,R.drawable.tablets,R.drawable.laptop,R.drawable.accesories,R.drawable.elect,R.drawable.walat};
    String[] name={"mobile","tablets","laptops","accesories","electronics","walet"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		
		gr=(GridView)findViewById(R.id.grid);
		
		customadapter c=new customadapter(getApplicationContext(), image,name);
		gr.setAdapter(c);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		gr.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapt, View v, int i,
					long id) {
				// TODO Auto-generated method stub
				switch(i)
				{
				case 0:
				      Intent in=new Intent(ShopActivity.this,ShoplistActivity.class);
				      in.putExtra("model", "mobile");
				      startActivity(in);
				      break;
				case 1:
					  Intent in1=new Intent(ShopActivity.this,ShoplistActivity.class);
				      in1.putExtra("model", "tablet");
				      startActivity(in1);
				      break;
				case 2:
					  Intent in2=new Intent(ShopActivity.this,ShoplistActivity.class);
				      in2.putExtra("model", "laptop");
				      startActivity(in2);
				      break;
				case 3:
					  Intent in3=new Intent(ShopActivity.this,ShoplistActivity.class);
				      in3.putExtra("model", "Accesories");
				      startActivity(in3);
				      break;
				case 4:
					  Intent in4=new Intent(ShopActivity.this,ShoplistActivity.class);
				      in4.putExtra("model", "elect");
				      startActivity(in4);
				      break;
				case 5:
					  Intent in5=new Intent(ShopActivity.this,ShoplistActivity.class);
				      in5.putExtra("model", "walet");
				      startActivity(in5);
				      break;
				}
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shop, menu);
		return true;
	}

}
