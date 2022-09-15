package com.company;

import java.util.List;

public class Programmer {
    private String name;
    private String city;
    List<Tasks>  tasks;

    public Programmer(String name, String city, List<Tasks> tasks) {
        this.name = name;
        this.city = city;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Programmer: " +System.lineSeparator()+
                "name: " + name + '\'' +
                ", city: " + city + '\'' +
                ", tasks:" + tasks +System.lineSeparator();
    }
}
