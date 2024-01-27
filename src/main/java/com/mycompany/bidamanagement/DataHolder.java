/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class DataHolder {
    
    private static DataHolder instance;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTART;
    private String inputDataEND;
    private String inputDataTable1Name;
    
    // Luu trang thai ten table
    private String inputColorDataTable1Name;
    
    // Luu trang thai cac button
    private boolean startBtnEnabled = true;
    private boolean stopBtnEnabled;
    private boolean printBtnEnabled;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHour, startMinute, startSecond;
    private int endHour, endMinute, endSecond;

    
    private DataHolder() {
        inputDataSTART = ""; // Khởi tạo inputData ban đầu
        inputDataEND = "";
        inputDataTable1Name = "";
        inputColorDataTable1Name = "";
    }
    
    public static synchronized DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    public String getInputDataSTART() {
        return inputDataSTART;
    }

    public void setInputDataSTART(String inputDataStart) {
        this.inputDataSTART = inputDataStart;
    }
    
    public String getInputDataEND() {
        return inputDataEND;
    }

    public void setInputDataEND(String inputDataEnd) {
        this.inputDataEND = inputDataEnd;
    }
    
    public String getInputDataTable1Name() {
        return inputDataTable1Name;
    }

    public void setInputDataTable1Name(String inputDataTable1name) {
        this.inputDataTable1Name = inputDataTable1name;
    }
    
    public String getInputColorDataTable1Name() {
        return inputColorDataTable1Name;
    }

    public void setInputColorDataTable1Name(String inputColorDataTable1name) {
        this.inputColorDataTable1Name = inputColorDataTable1name;
    }
    
    public boolean isStartBtnEnabled() {
        return startBtnEnabled;
    }

    public void setStartBtnEnabled(boolean startBtnEnabled) {
        this.startBtnEnabled = startBtnEnabled;
    }

    public boolean isStopBtnEnabled() {
        return stopBtnEnabled;
    }

    public void setStopBtnEnabled(boolean stopBtnEnabled) {
        this.stopBtnEnabled = stopBtnEnabled;
    }

    public boolean isPrintBtnEnabled() {
        return printBtnEnabled;
    }

    public void setPrintBtnEnabled(boolean printBtnEnabled) {
        this.printBtnEnabled = printBtnEnabled;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getStartSecond() {
        return startSecond;
    }

    public void setStartSecond(int startSecond) {
        this.startSecond = startSecond;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public int getEndSecond() {
        return endSecond;
    }

    public void setEndSecond(int endSecond) {
        this.endSecond = endSecond;
    }
}
