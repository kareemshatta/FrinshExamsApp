package com.kareem.frinshexamsapp.classes;

import java.util.ArrayList;

public class DocumentQuestion {

    private String DocumentQuestion;
    private ArrayList<ChoiseQuestion> choiseQuestionArrayList;

    public String getDocumentQuestion() {
        return DocumentQuestion;
    }

    public void setDocumentQuestion(String documentQuestion) {
        DocumentQuestion = documentQuestion;
    }

    public ArrayList<ChoiseQuestion> getChoiseQuestionArrayList() {
        return choiseQuestionArrayList;
    }

    public void setChoiseQuestionArrayList(ArrayList<ChoiseQuestion> choiseQuestionArrayList) {
        this.choiseQuestionArrayList = choiseQuestionArrayList;
    }

}
