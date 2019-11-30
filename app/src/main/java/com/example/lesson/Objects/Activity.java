package com.example.lesson.Objects;

public class Activity {
    private int number;
    private String type;
    private String title;
    private String ddl;

    public Activity(int number, String type, String title) {
        this.number = number;
        this.type = type;
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }
}
