package com.kareem.frinshexamsapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.kareem.frinshexamsapp.fragments.DocumentFragment;
import com.kareem.frinshexamsapp.fragments.EmailFragment;
import com.kareem.frinshexamsapp.fragments.GrammerFragment;
import com.kareem.frinshexamsapp.fragments.SituationFragment;
import com.kareem.frinshexamsapp.fragments.SubjectFragment;

public class ExamActivity extends AppCompatActivity {

    private TextView timer;
    public static Counter counter;
    private long timeLeftInMilliSecond = 3*60*1000;
    private BottomNavigationView mainBottomNav;
    private Fragment documentFragment;
    private Fragment situationFragment;
    private Fragment grammerFragment;
    private Fragment emailFragment;
    private Fragment subjectFragment;


//    private TextView question;
//    private TextView correction , header;
//    private RadioButton rbChoised;
//    private RadioGroup radioGroup;
//    private RadioButton rb1;
//    private RadioButton rb2;
//    private RadioButton rb3;
//    private RadioButton rb4;
//    private Button next , prev;
//
//    private ArrayList<ChoiseQuestion> choiseQuestions;
//    private ArrayList<Integer> userAnswers;
//    private ArrayList<String> userAnswersString;
//    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        getSupportActionBar().setTitle(getResources().getString(R.string.exam));
        timer = findViewById(R.id.timer);
        counter = new Counter(timeLeftInMilliSecond, 1000);
        counter.updateTimer();
        counter.start();
        //declarations
        documentFragment = new DocumentFragment();
        situationFragment = new SituationFragment();
        subjectFragment = new SubjectFragment();
        emailFragment = new EmailFragment();
        grammerFragment = new GrammerFragment();

        //begin
        replaceFragment(new DocumentFragment(),"DocumentFragment");

        mainBottomNav = findViewById(R.id.bottom_action_document);
        mainBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.bottom_action_document:
                        replaceFragment(documentFragment,"DocumentFragment");
                        return true;
                    case R.id.bottom_action_situation:
                        replaceFragment(situationFragment,"SituationFragment");
                        return true;
                    case R.id.bottom_action_choose:
                        replaceFragment(grammerFragment,"GrammerFragment");
                        return true;
                    case R.id.bottom_action_email:
                        replaceFragment(emailFragment,"EmailFragment");
                        return true;

                    case R.id.bottom_action_subject:
                        replaceFragment(subjectFragment,"SubjectFragment");

                        return true;
                    default:
                        return false;
                }
            }
        });
    }
    public class Counter extends CountDownTimer {

        public Counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            timeLeftInMilliSecond = l;
            updateTimer();
        }

        private void updateTimer() {
            int minutes = (int)timeLeftInMilliSecond / 60000;
            int seconds = (int)timeLeftInMilliSecond % 60000/1000;

            String timeLeft;
            timeLeft = "" + minutes + ":";
            if (seconds < 10)
                timeLeft += "0";
            if (minutes < 10)
                timeLeft = "0"+timeLeft;
            timeLeft += seconds;

            timer.setText(timeLeft);
            if (minutes == 0 && seconds < 10){
                timer.setTextColor(Color.RED);
                MediaPlayer player = MediaPlayer.create(getBaseContext(),R.raw.timer);
                player.start();
            }


        }

        @Override
        public void onFinish()
        {
            //showResultDialog();
        }
    }
    public void replaceFragment(Fragment fragment,String fragmentName) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(fragmentName);
        fragmentTransaction.commit();
    }

//    public void rbClick(View view) {
//        int rbId = radioGroup.getCheckedRadioButtonId();
//        rbChoised = (RadioButton) findViewById(rbId);
//        choiseQuestions.get(GrammerFragment.index).setSolved(true);
//        String answer = rbChoised.getText().toString();
//        //int answerIndex = choiseQuestions.get(index).getAnswers().indexOf(answer);
//        userAnswers.add(index,rbChoised.getId());
//        userAnswersString.add(index,answer);
//
//    }
//


    @Override
    public void onBackPressed() {
//        if(allQuestionsIsSolved()){
//            super.onBackPressed();
//        }else{
        Toast.makeText(this, "vous ne pouvez pas quitter avant la fin de l'examen", Toast.LENGTH_SHORT).show();
//        }
    }

//
//        next = findViewById(R.id.next);
//        prev = findViewById(R.id.prev);
//        radioGroup = findViewById(R.id.radioGroup);
//        question = findViewById(R.id.question);
//        correction = findViewById(R.id.correction_TV);
//        header = findViewById(R.id.header);
//        rb1 = findViewById(R.id.radioButton);
//        rb2 = findViewById(R.id.radioButton2);
//        rb3 = findViewById(R.id.radioButton3);
//        rb4 = findViewById(R.id.radioButton4);
//
//        //add more blocks to array when questions inceased
//        userAnswersString = new ArrayList<>(5);
//        userAnswers = new ArrayList<>(5);
//        userAnswers.add(-1);
//        userAnswers.add(-1);
//        userAnswers.add(-1);
//        userAnswers.add(-1);
//        userAnswers.add(-1);
//        userAnswersString.add("-1");
//        userAnswersString.add("-1");
//        userAnswersString.add("-1");
//        userAnswersString.add("-1");
//        userAnswersString.add("-1");
//
//        index = 0;
//
//        fillQuestions();
//        addQuestionToView();
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (next.getText().equals("résultat")) {
//
//                    if(allQuestionsIsSolved()){
//                        counter.cancel();
//                        showResultDialog();
//                    }else{
//                        Toast.makeText(ExamActivity.this, "Toutes les questions doivent être résolues", Toast.LENGTH_SHORT).show();
//                    }
//
//                }else{
//                    header.setVisibility(View.GONE);
//                    correction.setVisibility(View.GONE);
//                    switch (index){
//                        case 0:
//                            index++;
//                            addQuestionToView();
//                            if (userAnswers.get(index) != -1){
//                                radioGroup.check(userAnswers.get(index));
//                            }
//                            if (choiseQuestions.get(index).getAnswer_state() == 2){
//                                header.setVisibility(View.VISIBLE);
//                                correction.setVisibility(View.VISIBLE);
//                                correction.setText(choiseQuestions.get(index).getCorrectAnswer());
//                            }
//                            break;
//                        case 1:
//                            index++;
//                            addQuestionToView();
//                            if (userAnswers.get(index) != -1){
//                                radioGroup.check(userAnswers.get(index));
//                            }
//                            if (choiseQuestions.get(index).getAnswer_state() == 2){
//
//                                header.setVisibility(View.VISIBLE);
//                                correction.setVisibility(View.VISIBLE);
//                                correction.setText(choiseQuestions.get(index).getCorrectAnswer());
//                            }
//                            break;
//                        case 2:
//                            index++;
//                            addQuestionToView();
//                            if (userAnswers.get(index) != -1){
//                                radioGroup.check(userAnswers.get(index));
//                            }
//                            if (choiseQuestions.get(index).getAnswer_state() == 2){
//                                header.setVisibility(View.VISIBLE);
//                                correction.setVisibility(View.VISIBLE);
//                                correction.setText(choiseQuestions.get(index).getCorrectAnswer());
//                            }
//                            break;
//                        case 3:
//                            index++;
//                            addQuestionToView();
//                            if (userAnswers.get(index) != -1){
//                                radioGroup.check(userAnswers.get(index));
//                            }
//                            if (choiseQuestions.get(index).getAnswer_state() == 2){
//                                header.setVisibility(View.VISIBLE);
//                                correction.setVisibility(View.VISIBLE);
//                                correction.setText(choiseQuestions.get(index).getCorrectAnswer());
//                            }
//                            next.setText(getResources().getString(R.string.result));
//                            break;
//
//                    }
//                }
//
//            }
//        });
//
//        prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                header.setVisibility(View.GONE);
//                correction.setVisibility(View.GONE);
//                switch (index){
//                    case 0:
//                        Toast.makeText(ExamActivity.this, "c'est la première question", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 1:
//                        index--;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (choiseQuestions.get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(choiseQuestions.get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 2:
//                        index--;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (choiseQuestions.get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(choiseQuestions.get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 3:
//                        index--;
//                        addQuestionToView();
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (choiseQuestions.get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(choiseQuestions.get(index).getCorrectAnswer());
//                        }
//                        break;
//                    case 4:
//                        index--;
//                        addQuestionToView();
//                        next.setText(getResources().getString(R.string.next));
//                        if (userAnswers.get(index) != -1){
//                            radioGroup.check(userAnswers.get(index));
//                        }
//                        if (choiseQuestions.get(index).getAnswer_state() == 2){
//                            header.setVisibility(View.VISIBLE);
//                            correction.setVisibility(View.VISIBLE);
//                            correction.setText(choiseQuestions.get(index).getCorrectAnswer());
//                        }
//                        break;
//                }
//            }
//        });
//    }
//
//    private boolean getResult() {
//        String s;
//        int mark = 5;
//        for (int i=0 ; i<5 ; i++) {
//            s = userAnswersString.get(i);
//            if(choiseQuestions.get(i).getCorrectAnswer().equals(s)){
//                choiseQuestions.get(i).setAnswer_state(1);
//            }else{
//                choiseQuestions.get(i).setAnswer_state(2);
//                mark--;
//            }
//        }
//        if(mark < 2.5){
//            return false;
//        }else{
//            return true;
//        }
//
//    }
//
//    private boolean allQuestionsIsSolved(){
//        for (ChoiseQuestion c : choiseQuestions) {
//            if(!c.isSolved()){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void addQuestionToView() {
//        question.setText(choiseQuestions.get(index).getQuestion());
//        rb1.setText(choiseQuestions.get(index).getAnswers().get(0));
//        rb2.setText(choiseQuestions.get(index).getAnswers().get(1));
//        rb3.setText(choiseQuestions.get(index).getAnswers().get(2));
//        rb4.setText(choiseQuestions.get(index).getAnswers().get(3));
//        if (!choiseQuestions.get(index).isSolved()){
//            radioGroup.clearCheck();
//        }
//    }
//
//    private void fillQuestions() {
//
//        ChoiseQuestion q1 = new ChoiseQuestion();
//        q1.setQuestion("On voyage…………….le train.");
//        ArrayList<String> a1 = new ArrayList<>();
//        a1.add("en");
//        a1.add("à");
//        a1.add("par");
//        a1.add("au");
//        q1.setAnswers(a1);
//        q1.setCorrectAnswer("par");
//        q1.setSolved(false);
//        q1.setAnswer_state(0);
////////////////////////////////////////////////////////
//
//        ChoiseQuestion q2 = new ChoiseQuestion();
//        q2.setQuestion("J'habite près………….mon lycée.");
//        ArrayList<String> a2 = new ArrayList<>();
//        a2.add("du");
//        a2.add("de");
//        a2.add("de la");
//        a2.add("des");
//        q2.setAnswers(a2);
//        q2.setCorrectAnswer("de");
//        q2.setSolved(false);
//        q2.setAnswer_state(0);
////////////////////////////////////////////////////////
//
//        ChoiseQuestion q3 = new ChoiseQuestion();
//        q3.setQuestion("Le chien est…………le lit.");
//        ArrayList<String> a3 = new ArrayList<>();
//        a3.add("sous");
//        a3.add("à gauche");
//        a3.add("à droite");
//        a3.add("au");
//        q3.setAnswers(a3);
//        q3.setCorrectAnswer("sous");
//        q3.setSolved(false);
//        q3.setAnswer_state(0);
////////////////////////////////////////////////////////
//        ChoiseQuestion q4 = new ChoiseQuestion();
//        q4.setQuestion("……………vous venez?");
//        ArrayList<String> a4 = new ArrayList<>();
//        a4.add("Où");
//        a4.add("Par où");
//        a4.add("Qui");
//        a4.add("D'où");
//        q4.setAnswers(a4);
//        q4.setCorrectAnswer("D'où");
//        q4.setSolved(false);
//        q4.setAnswer_state(0);
////////////////////////////////////////////////////////
//        ChoiseQuestion q5 = new ChoiseQuestion();
//        q5.setQuestion("Noura va à l'école…………scooter.");
//        ArrayList<String> a5 = new ArrayList<>();
//        a5.add("à");
//        a5.add("en");
//        a5.add("dans");
//        a5.add("par");
//        q5.setAnswers(a5);
//        q5.setCorrectAnswer("en");
//        q5.setSolved(false);
//        q5.setAnswer_state(0);
////////////////////////////////////////////////////////
//
//        choiseQuestions = new ArrayList<>();
//        choiseQuestions.add(q1);
//        choiseQuestions.add(q2);
//        choiseQuestions.add(q3);
//        choiseQuestions.add(q4);
//        choiseQuestions.add(q5);
////////////////////////////////////////////////////////
//
//
//
//    }
//





//    public void showResultDialog() {
//        final TextView result_state;
//        ImageView imageView;
//        Button review;
//
//        final Dialog dialog = new Dialog(this);
//
//        dialog.setContentView(R.layout.result_dialog_layout);
//        Window dialogWindow = dialog.getWindow();
//
//        if (dialogWindow != null) {
//            dialog.getWindow().getAttributes().width = getResources().getDisplayMetrics().widthPixels;
//        }
//
//        result_state = dialog.findViewById(R.id.result_TV);
//        imageView = dialog.findViewById(R.id.result_IV);
//        review = dialog.findViewById(R.id.review_result);
//
//        if(getResult()){
//            result_state.setText(getResources().getString(R.string.success));
//            imageView.setImageResource(R.drawable.well);
//            MediaPlayer player = MediaPlayer.create(getBaseContext(),R.raw.well);
//            player.start();
//        }else{
//            result_state.setText(getResources().getString(R.string.failed));
//            imageView.setImageResource(R.drawable.lose);
//            MediaPlayer player = MediaPlayer.create(getBaseContext(),R.raw.lose);
//            player.start();
//        }
//
//        dialog.show();
//
//        review.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (choiseQuestions.get(4).getAnswer_state() == 2){
//                    header.setVisibility(View.VISIBLE);
//                    correction.setVisibility(View.VISIBLE);
//                    correction.setText(choiseQuestions.get(4).getCorrectAnswer());
//                }
//                dialog.dismiss();
//            }
//        });
//
//    }



}
