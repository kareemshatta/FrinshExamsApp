package com.kareem.frinshexamsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kareem.frinshexamsapp.LessonExamsActivity;
import com.kareem.frinshexamsapp.R;

import java.util.ArrayList;


public class LessonsRVAdapter extends RecyclerView.Adapter<LessonsRVAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> lessonsList;

    public LessonsRVAdapter(Context context, ArrayList<String> lessonsList) {
        this.context = context;
        this.lessonsList = lessonsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.lesson_card_view_layout,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.lessonNameTV.setText(lessonsList.get(i));
        myViewHolder.lessonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, LessonExamsActivity.class);
                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return lessonsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView lessonNameTV;
        CardView lessonCardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonNameTV = itemView.findViewById(R.id.lesson_name_TV);
            lessonCardView = itemView.findViewById(R.id.lesson_CV);


        }



    }
    public static class HeaderHolder extends RecyclerView.ViewHolder{

        TextView headerTV;

        public HeaderHolder(@NonNull View itemView) {

            super(itemView);
//            lessonNameTV = itemView.findViewById(R.id.lesson_name_TV);


        }



    }
}
