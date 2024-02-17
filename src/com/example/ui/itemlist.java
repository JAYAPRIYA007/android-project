package com.example.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class itemlist extends BaseAdapter {

	Context con;
	String[] name;
	String[] cost;
	int[] image;
	LayoutInflater lin;
	
	public itemlist(Context cn,int[] img,String[] title,String[] subtit)
	{
		this.con=cn;
		this.image=img;
		this.name=title;
		this.cost=subtit;
		lin=(LayoutInflater.from(cn));
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.length;
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
		v=lin.inflate(R.layout.mylist, null);
		ImageView imgs=(ImageView)v.findViewById(R.id.image1);
		TextView name1=(TextView)v.findViewById(R.id.iname);
		TextView name2=(TextView)v.findViewById(R.id.icost);
		name1.setText(name[i]);
		name2.setText("Cost :"+cost[i]);
		imgs.setImageResource(image[i]);
		return v;
	}

}
