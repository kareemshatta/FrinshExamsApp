package com.kareem.frinshexamsapp;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class LessonExamsActivity extends AppCompatActivity {

    private Button tryExam;
    private Button randExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_exams);
        getSupportActionBar().setTitle(getResources().getString(R.string.lesson_exams_title));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tryExam = findViewById(R.id.try_btn);
        randExam = findViewById(R.id.random_btn);
        tryExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCodeDialog();
            }
        });

        randExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void showCodeDialog() {
        final EditText code_ET;
        Button ok,cancle;

        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.exam_code_layout);
        Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null) {
            dialog.getWindow().getAttributes().width = getResources().getDisplayMetrics().widthPixels;
        }

        code_ET = dialog.findViewById(R.id.exam_code);

       dialog.show();


        ok = dialog.findViewById(R.id.ok_btn);
        cancle = dialog.findViewById(R.id.cancle_btn);

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(code_ET.getText().toString().equals("159753")){
                    Intent intent = new Intent(getBaseContext(),ExamActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    code_ET.setError("entrez le mot de passe correct");
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
