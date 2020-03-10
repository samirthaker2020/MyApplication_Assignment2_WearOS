package com.example.myapplication_test2.Modal;

public class ProgressList {
    String DialogHeader;
    int dno;

    public String getDialogHeader() {
        return DialogHeader;
    }

    public ProgressList(String dialogHeader, int dno) {
        DialogHeader = dialogHeader;
        this.dno = dno;
    }

    @Override
    public String toString() {
        return "ProgressList{" +
                "DialogHeader='" + DialogHeader + '\'' +
                ", dno=" + dno +
                '}';
    }

    public void setDialogHeader(String dialogHeader) {
        DialogHeader = dialogHeader;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }
}
