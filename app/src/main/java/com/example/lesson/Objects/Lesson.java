package com.example.lesson.Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lesson implements Serializable {
    private String name;
    private List<SubLesson> subLessonList;
    private List<Activity> activityList;

    public Lesson(String name) {
        this.name = name;
        subLessonList=new ArrayList<SubLesson>();
        activityList=new ArrayList<Activity>();
    }

    public String getName() {
        return name;
    }

    public List<SubLesson> getSubLessonList() {
        List<SubLesson> subLessons=new ArrayList<SubLesson>();
        for (SubLesson subLesson:subLessonList){
            subLessons.add(subLesson);
        }
        return subLessons;
    }
    public void addSubLesson(SubLesson lesson){
        subLessonList.add(lesson);
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void addActivity(Activity activity) {activityList.add(activity); }

}
