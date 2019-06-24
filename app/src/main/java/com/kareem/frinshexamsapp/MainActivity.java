package com.kareem.frinshexamsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kareem.frinshexamsapp.adapters.LessonsRVAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lessonsRecyclerView;
    private ArrayList<String> lessonsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(getResources().getString(R.string.home_title));

        lessonsRecyclerView = findViewById(R.id.lessons_RV);
        lessonsList = new ArrayList<>();
        lessonsList.add("Leçon 1");
        lessonsList.add("Leçon 2");
        lessonsList.add("Leçon 3");
        lessonsList.add("Leçon 4");
        lessonsList.add("Leçon 5");
        lessonsList.add("Leçon 6");

        LessonsRVAdapter myAdapter = new LessonsRVAdapter(this,lessonsList);
        lessonsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        lessonsRecyclerView.setAdapter(myAdapter);

    }
}
