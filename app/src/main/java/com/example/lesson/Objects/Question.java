package com.example.lesson.Objects;

public class Question {
    private int number;
    //0-未完成 1-对 2-错
    private int finishedState=0;
    //0-未收藏 1-已收藏
    private int starState=0;

    public Question(int number) {
        this.number = number;
    }

    public int getNumber() {
        int p=this.number;
        return p;
    }

    public int getFinishedState() {
        return finishedState;
    }

    public int getStarState() {
        return starState;
    }

    public void setFinishedState(int finishedState) {
        this.finishedState = finishedState;
    }

    public void setStarState(int starState) {
        this.starState = starState;
    }
}
