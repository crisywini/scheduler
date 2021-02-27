package com.example.schedule.model;
public class Schedule {

    private int id;
    private String day;
    private int startTime, endTime;
    private Class class_;


    public Schedule(String day, int startTime, int endTime, Class class_) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.class_ = class_;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Class getClass_() {
        return class_;
    }

    public void setClass_(Class class_) {
        this.class_ = class_;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
