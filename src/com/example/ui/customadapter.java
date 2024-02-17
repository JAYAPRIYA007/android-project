package com.example.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customadapter extends BaseAdapter{

	Context con;
	int[] image;
	String[] name;
	LayoutInflater li;
	
	public customadapter(Context c,int[] img,String[] name)
	{
		this.con=c;
		this.image=img;
		this.name=name;
		li=(LayoutInflater.from(c));
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return image.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int i, View v, ViewGroup vg) {
		// TODO Auto-generated method stub
		v=li.inflate(R.layout.myimage, null);
		ImageView im=(ImageView)v.findViewById(R.id.imageg);
		TextView nm=(TextView)v.findViewById(R.id.itemname);
		im.setImageResource(image[i]);
		nm.setText(name[i]);
		return v;
	}

}
