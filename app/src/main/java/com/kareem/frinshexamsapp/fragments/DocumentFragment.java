package com.kareem.frinshexamsapp.fragments;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
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
import com.kareem.frinshexamsapp.classes.DocumentQuestion;

import java.util.ArrayList;


public class DocumentFragment extends Fragment {

    private ArrayList<DocumentQuestion> documentQuestions;
    private ArrayList<Integer> userAnswers;
    private ArrayList<String> userAnswersString;

    private TextView document;
    private TextView question;
    private TextView correction,header;
    private RadioButton rbChoised;
    private RadioGroup radioGroup;
    private RadioButton rb1,rb2,rb3,rb4;
    private Button next , prev;
    private int documentIndex = 0;
    private int index = 0;

    private View view;


    public DocumentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_document, container, false);

        document = view.findViewById(R.id.documentA);
        radioGroup = view.findViewById(R.id.RG1A);
        question = view.findViewById(R.id.q1A);
        correction = view.findViewById(R.id.c1);
        header = view.findViewById(R.id.h1);
        rb1 = view.findViewById(R.id.RB1Q1A);
        rb2 = view.findViewById(R.id.RB2Q1A);
        rb3 = view.findViewById(R.id.RB3Q1A);
        rb4 = view.findViewById(R.id.RB4Q1A);
        next = view.findViewById(R.id.nextD);
        prev = view.findViewById(R.id.prevD);

        //add more blocks to array when questions inceased
        userAnswersString = new ArrayList<>(8);
        userAnswers = new ArrayList<>(8);
        userAnswers.add(-1);
        userAnswers.add(-1);
        userAnswers.add(-1);
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
        userAnswersString.add("-1");
        userAnswersString.add("-1");
        userAnswersString.add("-1");

        index = 0;
        documentIndex = 0;

        fillQuestions();
        addQuestionToView();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (next.getText().equals("résultat")) {

                    if(allQuestionsIsSolved()){
                        showResultDialog();
                    }else{
                        Toast.makeText(getContext(), "Toutes les questions doivent être résolues", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    header.setVisibility(View.GONE);
                    correction.setVisibility(View.GONE);



                    switch (index){
                        case 0:
                            index = 1;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 1:
                            index = 2;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){

                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 2:
                            index = 3;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 3:
                            index = 0;
                            documentIndex = 1;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 4:
                            index = 1;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 5:
                            index = 2;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;

                        case 6:
                            index = 3;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
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

                if (documentIndex == 0){
                    switch (index) {
                        case 0:
                            Toast.makeText(getContext(), "c'est la première question", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            index = 0;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1) {
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2) {
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 2:
                            index = 1;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1) {
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2) {
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 3:
                            index = 2;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1) {
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2) {
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                    }
                }else {
                    switch (index){
                        case 4:
                            index = 3;
                            documentIndex = 0;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 5:
                            index = 0;
                            addQuestionToView();
                            next.setText(getResources().getString(R.string.next));
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 6:
                            index = 1;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        case 7:
                            index = 2;
                            addQuestionToView();
                            if (userAnswers.get(index) != -1){
                                radioGroup.check(userAnswers.get(index));
                            }
                            if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
                                header.setVisibility(View.VISIBLE);
                                correction.setVisibility(View.VISIBLE);
                                correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
                            }
                            break;
                        }


                    }
                }
//                switch (index){
//                    case 0:
//                        Toast.makeText(getContext(), "c'est la première question", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 1:
//                        index = 0;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 2:
//                        index = 1;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 3:
//                        index = 2;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 4:
//                        index = 3;
//                        documentIndex = 0;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 5:
//                        index = 2;
//                        addQuestionToView();
//                        next.setText(getResources().getString(R.string.next));
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 6:
//                        index = 1;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 7:
//                        index = 0;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getCorrectAnswer());
//                        }
//                        break;
//                }
//            }
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
        documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).setSolved(true);
        String answer = rbChoised.getText().toString();
        //int answerIndex = choiseQuestions.get(index).getAnswers().indexOf(answer);
        userAnswers.add(index,rbChoised.getId());
        userAnswersString.add(index,answer);

    }

    private boolean getResult() {
        String s;
        int mark = 8;
        for (int i=0 ; i<8 ; i++) {
            s = userAnswersString.get(i);
            if (i == 4) {
                documentIndex = 1;
            }
            if(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(i).getCorrectAnswer().equals(s)){
                documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(i).setAnswer_state(1);
            }else{
                documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(i).setAnswer_state(2);
                mark--;
            }
        }
        if(mark < 4){
            return false;
        }else{
            return true;
        }

    }

    private boolean allQuestionsIsSolved(){
        for (ChoiseQuestion c : documentQuestions.get(0).getChoiseQuestionArrayList()) {
            if(!c.isSolved()){
                return false;
            }
        }

        for (ChoiseQuestion c : documentQuestions.get(1).getChoiseQuestionArrayList()) {
            if(!c.isSolved()){
                return false;
            }
        }
        return true;
    }

    private void addQuestionToView() {
        document.setText(documentQuestions.get(documentIndex).getDocumentQuestion());
        question.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getQuestion());
        rb1.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswers().get(0));
        rb2.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswers().get(1));
        rb3.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswers().get(2));
        rb4.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).getAnswers().get(3));
        if (!documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(index).isSolved()){
            radioGroup.clearCheck();
        }
    }

    private void fillQuestions() {

        DocumentQuestion d1 = new DocumentQuestion();
        d1.setDocumentQuestion("I- A) Lis le document puis réponds aux questions:\n" +
                "En classe\n" +
                "Nathalie: Bonjour, comment ça va?\n" +
                "Marion: Bonjour, ça va bien.\n" +
                "Nathalie: Comment t'appelles-tu?\n" +
                "Marion: Je m'appelle Marion et toi?\n" +
                "Nathalie: Moi, je m'appelle Nathalie.\n" +
                "Marion: Enchantée!\n" +
                "Nathalie: Enchantée! \n");

        ChoiseQuestion q1 = new ChoiseQuestion();
        q1.setQuestion("1-Nathalie et Marion sont………………");
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("au lycée");
        a1.add("en classe");
        a1.add("a l'école");
        a1.add("au clube");
        q1.setAnswers(a1);
        q1.setCorrectAnswer("en classe");
        q1.setSolved(false);
        q1.setAnswer_state(0);
//////////////////////////////////////////////////////

        ChoiseQuestion q2 = new ChoiseQuestion();
        q2.setQuestion("2-Nathalie et Marion sont………………");
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("le matin");
        a2.add("le soir");
        a2.add("le midi");
        a2.add("la nuit");
        q2.setAnswers(a2);
        q2.setCorrectAnswer("le matin");
        q2.setSolved(false);
        q2.setAnswer_state(0);
//////////////////////////////////////////////////////

        ChoiseQuestion q3 = new ChoiseQuestion();
        q3.setQuestion("3-Marion…………");
        ArrayList<String> a3 = new ArrayList<>();
        a3.add("va mal");
        a3.add("pas très bien");
        a3.add("va bien");
        a3.add("pas bien");
        q3.setAnswers(a3);
        q3.setCorrectAnswer("va bien");
        q3.setSolved(false);
        q3.setAnswer_state(0);
//////////////////////////////////////////////////////
        ChoiseQuestion q4 = new ChoiseQuestion();
        q4.setQuestion("4-En classe est………………élèves.");
        ArrayList<String> a4 = new ArrayList<>();
        a4.add("un");
        a4.add("deux");
        a4.add("trois");
        a4.add("quatre");
        q4.setAnswers(a4);
        q4.setCorrectAnswer("deux");
        q4.setSolved(false);
        q4.setAnswer_state(0);
//////////////////////////////////////////////////////
        ArrayList<ChoiseQuestion> choiseQuestions = new ArrayList<>();
        choiseQuestions.add(q1);
        choiseQuestions.add(q2);
        choiseQuestions.add(q3);
        choiseQuestions.add(q4);
        d1.setChoiseQuestionArrayList(choiseQuestions);
//////////////////////////////////////////////////////
        DocumentQuestion d2 = new DocumentQuestion();
        d2.setDocumentQuestion("  B)Lis le document puis réponds aux questions:\n" +
                "Salut! Je m'appelle Alex, j'ai 14 ans, je vais à l'école, j'habite à Paris, j'ai un" +
                "copain du judo, il s'appelle Paul, j'ai une copine du judo, elle s'appelle Zoe," +
                "elle habite à Marseille.\n");

        q1 = new ChoiseQuestion();
        q1.setQuestion("5-Alex a……….ans.");
        a1 = new ArrayList<>();
        a1.add("seize");
        a1.add("quinze");
        a1.add("quatorze");
        a1.add("dix");
        q1.setAnswers(a1);
        q1.setCorrectAnswer("quatorze");
        q1.setSolved(false);
        q1.setAnswer_state(0);
//////////////////////////////////////////////////////
        q2 = new ChoiseQuestion();
        q2.setQuestion("6-Zoe habite à ……………");
        a2 = new ArrayList<>();
        a2.add("Paris");
        a2.add("Marseille");
        a2.add("Rome");
        a2.add("Madrid");
        q2.setAnswers(a2);
        q2.setCorrectAnswer("Marseille");
        q2.setSolved(false);
        q2.setAnswer_state(0);
//////////////////////////////////////////////////////
        q3 = new ChoiseQuestion();
        q3.setQuestion("7-Alex a ………….");
        a3 = new ArrayList<>();
        a3.add("un copain");
        a3.add("une copine");
        a3.add("deux copines");
        a3.add("un copain et une copine");
        q3.setAnswers(a3);
        q3.setCorrectAnswer("un copain et une copine");
        q3.setSolved(false);
        q3.setAnswer_state(0);
//////////////////////////////////////////////////////
        q4 = new ChoiseQuestion();
        q4.setQuestion("8-Le copain du judo s'appelle…………….");
        a4 = new ArrayList<>();
        a4.add("Alex");
        a4.add("Zoe");
        a4.add("Paul");
        a4.add("Noha");
        q4.setAnswers(a4);
        q4.setCorrectAnswer("Paul");
        q4.setSolved(false);
        q4.setAnswer_state(0);
//////////////////////////////////////////////////////
        choiseQuestions = new ArrayList<>();
        choiseQuestions.add(q1);
        choiseQuestions.add(q2);
        choiseQuestions.add(q3);
        choiseQuestions.add(q4);
        d2.setChoiseQuestionArrayList(choiseQuestions);
//////////////////////////////////////////////////////

//////////////////////////////////////////////////////
        documentQuestions = new ArrayList<>();
        documentQuestions.add(d1);
        documentQuestions.add(d2);
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
                if (documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(3).getAnswer_state() == 2){
                    header.setVisibility(View.VISIBLE);
                    correction.setVisibility(View.VISIBLE);
                    correction.setText(documentQuestions.get(documentIndex).getChoiseQuestionArrayList().get(3).getCorrectAnswer());
                }
                dialog.dismiss();
            }
        });

    }


}
