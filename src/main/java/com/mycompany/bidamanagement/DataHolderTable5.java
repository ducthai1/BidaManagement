/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */

public class DataHolderTable5 {
    
    private static DataHolderTable5 instanceTable5;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTARTTable5;
    private String inputDataENDTable5;
    private String inputDataNameTable5;
    
    // Luu trang thai ten table
    private String inputColorDataNameTable5;
    
    // Luu trang thai cac button
    private boolean startBtnEnabledTable5 = true;
    private boolean stopBtnEnabledTable5;
    private boolean printBtnEnabledTable5;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHourTable5, startMinuteTable5, startSecondTable5;
    private int endHourTable5, endMinuteTable5, endSecondTable5;

    
    private DataHolderTable5() {
        inputDataSTARTTable5 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable5 = "";
        inputDataNameTable5 = "";
        inputColorDataNameTable5 = "";
    }
    
    public static synchronized DataHolderTable5 getInstanceTable5() {
        if (instanceTable5 == null) {
            instanceTable5 = new DataHolderTable5();
        }
        return instanceTable5;
    }

    public String getInputDataSTARTTable5() {
        return inputDataSTARTTable5;
    }

    public void setInputDataSTARTTable5(String inputDataStartTable5) {
        this.inputDataSTARTTable5 = inputDataStartTable5;
    }
    
    public String getInputDataENDTable5() {
        return inputDataENDTable5;
    }

    public void setInputDataENDTable5(String inputDataEndTable5) {
        this.inputDataENDTable5 = inputDataEndTable5;
    }
    
    public String getInputDataNameTable5() {
        return inputDataNameTable5;
    }

    public void setInputDataNameTable5(String inputDatanameTable5) {
        this.inputDataNameTable5 = inputDatanameTable5;
    }
    
    public String getInputColorDataNameTable5() {
        return inputColorDataNameTable5;
    }

    public void setInputColorDataNameTable5(String inputColorDatanameTable5) {
        this.inputColorDataNameTable5 = inputColorDatanameTable5;
    }
    
    public boolean isStartBtnEnabledTable5() {
        return startBtnEnabledTable5;
    }

    public void setStartBtnEnabledTable5(boolean startBtnEnabledTable5) {
        this.startBtnEnabledTable5 = startBtnEnabledTable5;
    }

    public boolean isStopBtnEnabledTable5() {
        return stopBtnEnabledTable5;
    }

    public void setStopBtnEnabledTable5(boolean stopBtnEnabledTable5) {
        this.stopBtnEnabledTable5 = stopBtnEnabledTable5;
    }

    public boolean isPrintBtnEnabledTable5() {
        return printBtnEnabledTable5;
    }

    public void setPrintBtnEnabledTable5(boolean printBtnEnabledTable5) {
        this.printBtnEnabledTable5 = printBtnEnabledTable5;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable5() {
        return startHourTable5;
    }

    public void setStartHourTable5(int startHour) {
        this.startHourTable5 = startHour;
    }

    public int getStartMinuteTable5() {
        return startMinuteTable5;
    }

    public void setStartMinuteTable5(int startMinute) {
        this.startMinuteTable5 = startMinute;
    }

    public int getStartSecondTable5() {
        return startSecondTable5;
    }

    public void setStartSecondTable5(int startSecond) {
        this.startSecondTable5 = startSecond;
    }

    public int getEndHourTable5() {
        return endHourTable5;
    }

    public void setEndHourTable5(int endHourTable5) {
        this.endHourTable5 = endHourTable5;
    }

    public int getEndMinuteTable5() {
        return endMinuteTable5;
    }

    public void setEndMinuteTable5(int endMinuteTable5) {
        this.endMinuteTable5 = endMinuteTable5;
    }

    public int getEndSecondTable5() {
        return endSecondTable5;
    }

    public void setEndSecondTable5(int endSecondTable5) {
        this.endSecondTable5 = endSecondTable5;
    }
}

