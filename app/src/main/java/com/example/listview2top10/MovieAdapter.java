package com.example.listview2top10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends ArrayAdapter {

    List list = new ArrayList();

    static class DataHandeler{
        ImageView poster;
        TextView title;
        TextView rate;

    }

    public MovieAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    public int getCount(){
        return this.list.size();
    }

    public Object getItem(int position){
        return this.list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        DataHandeler handeler = new DataHandeler();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = (View) inflater.inflate(R.layout.row_layout,parent,false);
            handeler.poster = row.findViewById(R.id.Movie_poster);
            handeler.title = row.findViewById(R.id.m1);
            handeler.rate = row.findViewById(R.id.r1);
            row.setTag(handeler);
        }else {
            handeler = (DataHandeler) row.getTag();
        }

        MovieDataProvider dataProvider;
        dataProvider = (MovieDataProvider) this.getItem(position);
        handeler.poster.setImageResource(dataProvider.getMovie_poster());
        handeler.title.setText(dataProvider.getMovie_title());
        handeler.rate.setText(dataProvider.getMovie_ratings());

        return row;
    }

}
