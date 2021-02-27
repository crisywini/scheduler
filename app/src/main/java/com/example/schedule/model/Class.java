package com.example.schedule.model;

public class Class {

    private String name;
    private String description;
    private Teacher teacher;
    private Schedule scheduleOne, scheduleTwo;

    public Class(String name, String description, Teacher teacher, Schedule scheduleOne, Schedule scheduleTwo) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.scheduleOne = scheduleOne;
        this.scheduleTwo = scheduleTwo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Schedule getScheduleOne() {
        return scheduleOne;
    }

    public void setScheduleOne(Schedule scheduleOne) {
        this.scheduleOne = scheduleOne;
    }

    public Schedule getScheduleTwo() {
        return scheduleTwo;
    }

    public void setScheduleTwo(Schedule scheduleTwo) {
        this.scheduleTwo = scheduleTwo;
    }
}
