package com.example.schedule.model;

import java.util.ArrayList;

public class Teacher {
    private int id;
    private String name;
    private ArrayList<Class> classes;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
        classes = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }
}
