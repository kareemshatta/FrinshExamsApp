package com.kareem.frinshexamsapp.fragments;


import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kareem.frinshexamsapp.ExamActivity;
import com.kareem.frinshexamsapp.R;
import com.kareem.frinshexamsapp.classes.ChoiseQuestion;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrammerFragment extends Fragment {

    private TextView question;
    private TextView correction , header;
    private RadioButton rbChoised;
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button next , prev;

    private ArrayList<ChoiseQuestion> choiseQuestions;
    private ArrayList<Integer> userAnswers;
    private ArrayList<String> userAnswersString;
    private int index = 0;

    private View view;


    public GrammerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_grammer, container, false);


        next = view.findViewById(R.id.next);
        prev = view.findViewById(R.id.prev);
        radioGroup = view.findViewById(R.id.radioGroup);
        question = view.findViewById(R.id.question);
        correction = view.findViewById(R.id.correction_TV);
        header = view.findViewById(R.id.header);
        rb1 = view.findViewById(R.id.radioButton);
        rb2 = view.findViewById(R.id.radioButton2);
        rb3 = view.findViewById(R.id.radioButton3);
        rb4 = view.findViewById(R.id.radioButton4);

        //add more blocks to array when questions inceased
        userAnswersString = new ArrayList<>(5);
        userAnswers = new ArrayList<>(5);
        userAnswers.add(-1);
        userAnswers.add(-1);
        userAnswers.add(-1);
        userAnswers.add(-1);
        userAnswers.add(-1);
        userAnswersString.add("-1");
        userAnswersString.add("-1");
        userAnswersString.add("-1");
        userAnswersString.add("-1");
        userAnswersString.add("-1");

        index = 0;

        fillQuestions();
        addQuestionToView();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (next.getText().equals("résultat")) {

                    if(allQuestionsIsSolved()){
                        ExamActivity.counter.cancel();
                        showResultDialog();
                    }else{
                        Toast.makeText(getContext(), "Toutes les questions doivent être résolues", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    header.setVisibility(View.GONE);
                    correction.setVisibility(View.GONE);
                    switch (index){
                        case 0:
                            index++;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (choiseQuestions.get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(choiseQuestions.get(index).getCorrectAnswer());
                            }
                            break;
                        case 1:
                            index++;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (choiseQuestions.get(index).getAnswer_state() == 2){

                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(choiseQuestions.get(index).getCorrectAnswer());
                            }
                            break;
                        case 2:
                            index++;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (choiseQuestions.get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(choiseQuestions.get(index).getCorrectAnswer());
                            }
                            break;
                        case 3:
                            index++;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (choiseQuestions.get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(choiseQuestions.get(index).getCorrectAnswer());
                            }
                            next.setText(getResources().getString(R.string.result));
                            break;

                    }
                }

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                header.setVisibility(View.GONE);
                correction.setVisibility(View.GONE);
                switch (index){
                    case 0:
                        Toast.makeText(getContext(), "c'est la première question", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        index--;
                        addQuestionToView();
                        if (userAnswers.get(index) != -1){
                            radioGroup.check(userAnswers.get(index));
                        }
                        if (choiseQuestions.get(index).getAnswer_state() == 2){
                            header.setVisibility(View.VISIBLE);
                            correction.setVisibility(View.VISIBLE);
                            correction.setText(choiseQuestions.get(index).getCorrectAnswer());
                        }
                        break;
                    case 2:
                        index--;
                        addQuestionToView();
                        if (userAnswers.get(index) != -1){
                            radioGroup.check(userAnswers.get(index));
                        }
                        if (choiseQuestions.get(index).getAnswer_state() == 2){
                            header.setVisibility(View.VISIBLE);
                            correction.setVisibility(View.VISIBLE);
                            correction.setText(choiseQuestions.get(index).getCorrectAnswer());
                        }
                        break;
                    case 3:
                        index--;
                        addQuestionToView();
                        if (userAnswers.get(index) != -1){
                            radioGroup.check(userAnswers.get(index));
                        }
                        if (choiseQuestions.get(index).getAnswer_state() == 2){
                            header.setVisibility(View.VISIBLE);
                            correction.setVisibility(View.VISIBLE);
                            correction.setText(choiseQuestions.get(index).getCorrectAnswer());
                        }
                        break;
                    case 4:
                        index--;
                        addQuestionToView();
                        next.setText(getResources().getString(R.string.next));
                        if (userAnswers.get(index) != -1){
                            radioGroup.check(userAnswers.get(index));
                        }
                        if (choiseQuestions.get(index).getAnswer_state() == 2){
                            header.setVisibility(View.VISIBLE);
                            correction.setVisibility(View.VISIBLE);
                            correction.setText(choiseQuestions.get(index).getCorrectAnswer());
                        }
                        break;
                }
            }
        });
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbClick();
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbClick();
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbClick();
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbClick();
            }
        });

        return view;
    }


    public void rbClick() {
        int rbId = radioGroup.getCheckedRadioButtonId();
        rbChoised = (RadioButton) view.findViewById(rbId);
        choiseQuestions.get(index).setSolved(true);
        String answer = rbChoised.getText().toString();
        //int answerIndex = choiseQuestions.get(index).getAnswers().indexOf(answer);
        userAnswers.add(index,rbChoised.getId());
        userAnswersString.add(index,answer);

    }

    private boolean getResult() {
        String s;
        int mark = 5;
        for (int i=0 ; i<5 ; i++) {
            s = userAnswersString.get(i);
            if(choiseQuestions.get(i).getCorrectAnswer().equals(s)){
                choiseQuestions.get(i).setAnswer_state(1);
            }else{
                choiseQuestions.get(i).setAnswer_state(2);
                mark--;
            }
        }
        if(mark < 2.5){
            return false;
        }else{
            return true;
        }

    }

    private boolean allQuestionsIsSolved(){
        for (ChoiseQuestion c : choiseQuestions) {
            if(!c.isSolved()){
                return false;
            }
        }
        return true;
    }

    private void addQuestionToView() {
        question.setText(choiseQuestions.get(index).getQuestion());
        rb1.setText(choiseQuestions.get(index).getAnswers().get(0));
        rb2.setText(choiseQuestions.get(index).getAnswers().get(1));
        rb3.setText(choiseQuestions.get(index).getAnswers().get(2));
        rb4.setText(choiseQuestions.get(index).getAnswers().get(3));
        if (!choiseQuestions.get(index).isSolved()){
            radioGroup.clearCheck();
        }
    }

    private void fillQuestions() {

        ChoiseQuestion q1 = new ChoiseQuestion();
        q1.setQuestion("On voyage…………….le train.");
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("en");
        a1.add("à");
        a1.add("par");
        a1.add("au");
        q1.setAnswers(a1);
        q1.setCorrectAnswer("par");
        q1.setSolved(false);
        q1.setAnswer_state(0);
//////////////////////////////////////////////////////

        ChoiseQuestion q2 = new ChoiseQuestion();
        q2.setQuestion("J'habite près………….mon lycée.");
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("du");
        a2.add("de");
        a2.add("de la");
        a2.add("des");
        q2.setAnswers(a2);
        q2.setCorrectAnswer("de");
        q2.setSolved(false);
        q2.setAnswer_state(0);
//////////////////////////////////////////////////////

        ChoiseQuestion q3 = new ChoiseQuestion();
        q3.setQuestion("Le chien est…………le lit.");
        ArrayList<String> a3 = new ArrayList<>();
        a3.add("sous");
        a3.add("à gauche");
        a3.add("à droite");
        a3.add("au");
        q3.setAnswers(a3);
        q3.setCorrectAnswer("sous");
        q3.setSolved(false);
        q3.setAnswer_state(0);
//////////////////////////////////////////////////////
        ChoiseQuestion q4 = new ChoiseQuestion();
        q4.setQuestion("……………vous venez?");
        ArrayList<String> a4 = new ArrayList<>();
        a4.add("Où");
        a4.add("Par où");
        a4.add("Qui");
        a4.add("D'où");
        q4.setAnswers(a4);
        q4.setCorrectAnswer("D'où");
        q4.setSolved(false);
        q4.setAnswer_state(0);
//////////////////////////////////////////////////////
        ChoiseQuestion q5 = new ChoiseQuestion();
        q5.setQuestion("Noura va à l'école…………scooter.");
        ArrayList<String> a5 = new ArrayList<>();
        a5.add("à");
        a5.add("en");
        a5.add("dans");
        a5.add("par");
        q5.setAnswers(a5);
        q5.setCorrectAnswer("en");
        q5.setSolved(false);
        q5.setAnswer_state(0);
//////////////////////////////////////////////////////

        choiseQuestions = new ArrayList<>();
        choiseQuestions.add(q1);
        choiseQuestions.add(q2);
        choiseQuestions.add(q3);
        choiseQuestions.add(q4);
        choiseQuestions.add(q5);
//////////////////////////////////////////////////////



    }


    public void showResultDialog() {
        final TextView result_state;
        ImageView imageView;
        Button review;

        final Dialog dialog = new Dialog(getContext());

        dialog.setContentView(R.layout.result_dialog_layout);
        Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null) {
            dialog.getWindow().getAttributes().width = getResources().getDisplayMetrics().widthPixels;
        }

        result_state = dialog.findViewById(R.id.result_TV);
        imageView = dialog.findViewById(R.id.result_IV);
        review = dialog.findViewById(R.id.review_result);

        if(getResult()){
            result_state.setText(getResources().getString(R.string.success));
            imageView.setImageResource(R.drawable.well);
            MediaPlayer player = MediaPlayer.create(getContext(),R.raw.well);
            player.start();
        }else{
            result_state.setText(getResources().getString(R.string.failed));
            imageView.setImageResource(R.drawable.lose);
            MediaPlayer player = MediaPlayer.create(getContext(),R.raw.lose);
            player.start();
        }

        dialog.show();

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choiseQuestions.get(4).getAnswer_state() == 2){
                    header.setVisibility(View.VISIBLE);
                    correction.setVisibility(View.VISIBLE);
                    correction.setText(choiseQuestions.get(4).getCorrectAnswer());
                }
                dialog.dismiss();
            }
        });

    }

}
