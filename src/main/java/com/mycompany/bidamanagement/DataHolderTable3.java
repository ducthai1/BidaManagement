/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable3 {
    
    private static DataHolderTable3 instanceTable3;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTARTTable3;
    private String inputDataENDTable3;
    private String inputDataNameTable3;
    
    // Luu trang thai ten table
    private String inputColorDataNameTable3;
    
    // Luu trang thai cac button
    private boolean startBtnEnabledTable3 = true;
    private boolean stopBtnEnabledTable3;
    private boolean printBtnEnabledTable3;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHourTable3, startMinuteTable3, startSecondTable3;
    private int endHourTable3, endMinuteTable3, endSecondTable3;

    
    private DataHolderTable3() {
        inputDataSTARTTable3 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable3 = "";
        inputDataNameTable3 = "";
        inputColorDataNameTable3 = "";
    }
    
    public static synchronized DataHolderTable3 getInstanceTable3() {
        if (instanceTable3 == null) {
            instanceTable3 = new DataHolderTable3();
        }
        return instanceTable3;
    }

    public String getInputDataSTARTTable3() {
        return inputDataSTARTTable3;
    }

    public void setInputDataSTARTTable3(String inputDataStartTable3) {
        this.inputDataSTARTTable3 = inputDataStartTable3;
    }
    
    public String getInputDataENDTable3() {
        return inputDataENDTable3;
    }

    public void setInputDataENDTable3(String inputDataEndTable3) {
        this.inputDataENDTable3 = inputDataEndTable3;
    }
    
    public String getInputDataNameTable3() {
        return inputDataNameTable3;
    }

    public void setInputDataNameTable3(String inputDatanameTable3) {
        this.inputDataNameTable3 = inputDatanameTable3;
    }
    
    public String getInputColorDataNameTable3() {
        return inputColorDataNameTable3;
    }

    public void setInputColorDataNameTable3(String inputColorDatanameTable3) {
        this.inputColorDataNameTable3 = inputColorDatanameTable3;
    }
    
    public boolean isStartBtnEnabledTable3() {
        return startBtnEnabledTable3;
    }

    public void setStartBtnEnabledTable3(boolean startBtnEnabledTable3) {
        this.startBtnEnabledTable3 = startBtnEnabledTable3;
    }

    public boolean isStopBtnEnabledTable3() {
        return stopBtnEnabledTable3;
    }

    public void setStopBtnEnabledTable3(boolean stopBtnEnabledTable3) {
        this.stopBtnEnabledTable3 = stopBtnEnabledTable3;
    }

    public boolean isPrintBtnEnabledTable3() {
        return printBtnEnabledTable3;
    }

    public void setPrintBtnEnabledTable3(boolean printBtnEnabledTable3) {
        this.printBtnEnabledTable3 = printBtnEnabledTable3;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable3() {
        return startHourTable3;
    }

    public void setStartHourTable3(int startHour) {
        this.startHourTable3 = startHour;
    }

    public int getStartMinuteTable3() {
        return startMinuteTable3;
    }

    public void setStartMinuteTable3(int startMinute) {
        this.startMinuteTable3 = startMinute;
    }

    public int getStartSecondTable3() {
        return startSecondTable3;
    }

    public void setStartSecondTable3(int startSecond) {
        this.startSecondTable3 = startSecond;
    }

    public int getEndHourTable3() {
        return endHourTable3;
    }

    public void setEndHourTable3(int endHourTable3) {
        this.endHourTable3 = endHourTable3;
    }

    public int getEndMinuteTable3() {
        return endMinuteTable3;
    }

    public void setEndMinuteTable3(int endMinuteTable3) {
        this.endMinuteTable3 = endMinuteTable3;
    }

    public int getEndSecondTable3() {
        return endSecondTable3;
    }

    public void setEndSecondTable3(int endSecondTable3) {
        this.endSecondTable3 = endSecondTable3;
    }
}



