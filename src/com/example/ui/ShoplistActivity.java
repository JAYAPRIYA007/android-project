package com.example.ui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ShoplistActivity extends Activity {

	ListView list;
	String[] mobile={"samsung","Redmi","Iphone","Honor","Moto"},
			tablet={"lenovo","samsung","Mac Book","Hawai","Gtap"},
			laptop={"Mac","lenovo","Dell","Honor","Moto"},
			access={"headpone","back case","tember glass","Speaker","Flip cover"},
			elect={"Calculater","Speaker","Whatch","TV","Washing Machine"};
	String[] prize={"21000","9000","58000","12000","14000"},
			p1={"21000","9000","58000","12000","14000"},
			p2={"21000","9000","58000","12000","14000"},
			p3={"21000","9000","58000","12000","14000"},
			p4={"21000","9000","58000","12000","14000"};
	int[] image={R.drawable.s2,R.drawable.h1,R.drawable.i3,R.drawable.h1,R.drawable.h1},
			im1={R.drawable.s2,R.drawable.h1,R.drawable.i3,R.drawable.h1,R.drawable.h1},
			im2={R.drawable.s2,R.drawable.h1,R.drawable.i3,R.drawable.h1,R.drawable.h1},
			im3={R.drawable.s2,R.drawable.h1,R.drawable.i3,R.drawable.h1,R.drawable.h1},
			im4={R.drawable.s2,R.drawable.h1,R.drawable.i3,R.drawable.h1,R.drawable.h1};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shoplist);
		
		list=(ListView)findViewById(R.id.itemlist);
		Intent i=getIntent();
		if(i.getStringExtra("model").equals("mobile"))
		{
		    itemlist it=new itemlist(getApplicationContext(),image, mobile,prize);
		    list.setAdapter(it);
		}
		else if(i.getStringExtra("model").equals("tablet"))
		{
			itemlist it=new itemlist(getApplicationContext(),im1, tablet,p1);
			list.setAdapter(it);
		}
		else if(i.getStringExtra("model").equals("laptop"))
		{
			itemlist it=new itemlist(getApplicationContext(),im2, laptop,p2);
		    list.setAdapter(it);
		}
		else if(i.getStringExtra("model").equals("Accesories"))
		{
			itemlist it=new itemlist(getApplicationContext(),im3, access,p3);
		    list.setAdapter(it);
		}
		else if(i.getStringExtra("model").equals("elect"))
		{
			itemlist it=new itemlist(getApplicationContext(),im4, elect,p4);
		    list.setAdapter(it);
		}
		else
		{
			Intent in=new Intent(ShoplistActivity.this,WaletActivity.class);
			startActivity(in);
		}
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adap, View v, int i,
					long arg3) {
				// TODO Auto-generated method stub
				Bundle b=new Bundle();
				b.putString("model", mobile[i]);
				b.putString("cost", prize[i]);
				b.putInt("image", image[i]);
				Intent in=new Intent(ShoplistActivity.this,BuyActivity.class);
				in.putExtras(b);
				startActivity(in);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shoplist, menu);
		return true;
	}

}
