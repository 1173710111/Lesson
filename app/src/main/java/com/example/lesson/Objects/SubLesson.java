package com.example.lesson.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubLesson {
    private int num;
    private String number;
    private String name;
    private String publishDate;
    private List<Question> questionList;

    public SubLesson(int num, String name) {
        this.num = num;
        this.name = name;
        setNumber();
        questionList=new ArrayList<Question>();
    }

    private void setNumber() {
        this.number = "第"+num+"讲";
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void addQuestion(Question question) {
        this.questionList.add(question);
    }

    public int getNum() {
        return num;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public Question getQuestionByNum(int number){
        Question question=questionList.get(number-1);
        return  question;
    }
    public List<Question> getQuestions(){
        List<Question> list= new ArrayList<Question>();
        for(Question question:questionList){
            list.add(question);
        }
        return  list;
    }
    public int getQuestionsSize(){
        return questionList.size();
    }
}
