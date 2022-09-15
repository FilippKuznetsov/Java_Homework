package com.company;

public class Tasks {
    private   int Number;
    private String description;
    private String status;
    private int daysInProcessing;

    public Tasks(int number, String description, String status, int daysInProcessing) {
        Number = number;
        this.description = description;
        this.status = status;
        this.daysInProcessing = daysInProcessing;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDaysInProcessing() {
        return daysInProcessing;
    }

    public void setDaysInProcessing(int daysInProcessing) {
        this.daysInProcessing = daysInProcessing;
    }

    @Override
    public String toString() {
        return "Tasks: "+System.lineSeparator() + "Number: " + Number + ", description: " + description + ' ' + ", status='" + status + ' ' + ", daysInProcessing: " + daysInProcessing;

    }
}
