package com.example.listview2top10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    RelativeLayout relativeLayout;

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
            R.drawable.movie12
    };
    String[] Movie_title;
    String[] Movie_rating;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.Ol);
        listView = (ListView)findViewById(R.id.list_view);
        Movie_title = getResources().getStringArray(R.array.movie_title);
        Movie_rating = getResources().getStringArray(R.array.rating);
        adapter = new MovieAdapter(getApplicationContext(),R.layout.row_layout);

        registerForContextMenu(listView);

        listView.setAdapter(adapter);

        int i = 0;
        for (String title: Movie_title ) {
            MovieDataProvider dataProvider = new MovieDataProvider(movie_poster[i],Movie_rating[i],title);
            adapter.add(dataProvider);
            i++;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Watch:
                Toast.makeText(getBaseContext(),"Wait a moment",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Add:
                Toast.makeText(getBaseContext(),"added to play list",Toast.LENGTH_LONG).show();
                return true;
            case R.id.See:
                Toast.makeText(getBaseContext(),"added to see later",Toast.LENGTH_LONG).show();
                return true;
            case R.id.delete:
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);

        return true;
    }
}
