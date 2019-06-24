package com.kareem.frinshexamsapp.classes;

import java.util.ArrayList;

public class ChoiseQuestion {

    private String question;
    private ArrayList<String> answers;
    private boolean solved;
    private String correctAnswer;
    //0 not_yet   1 true   2 false
    private int Answer_state;



    public int getAnswer_state() {
        return Answer_state;
    }

    public void setAnswer_state(int answer_state) {
        Answer_state = answer_state;
    }



    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


//    public ChoiseQuestion(String question, ArrayList<String> answers, boolean solved) {
//        this.question = question;
//        this.answers = answers;
//        this.solved = solved;
//    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }


}
