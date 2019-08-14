package com.example.listview2top10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] movie_poster = {
            R.drawable.movie1,
            R.drawable.movie2,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5,
            R.drawable.movie6,
            R.drawable.movie7,
            R.drawable.movie8,
            R.drawable.movie9,
            R.drawable.movie10,
            R.drawable.movie11,
            R.drawable.movie12,};

    String[] Movie_title;
    String[] Movie_rating;
    MovieAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        Movie_title = getResources().getStringArray(R.array.movie_title);
        Movie_rating = getResources().getStringArray(R.array.rating);
        adapter = new MovieAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(adapter);
        int i = 0;
        for (String title: Movie_title ) {
            MovieDataProvider dataProvider = new MovieDataProvider(movie_poster[i],Movie_rating[i],title);
            adapter.add(dataProvider);
            i++;
        }
    }
}
