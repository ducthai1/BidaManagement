/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable7 {
    
    private static DataHolderTable7 instanceTable7;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTARTTable7;
    private String inputDataENDTable7;
    private String inputDataNameTable7;
    
    // Luu trang thai ten table
    private String inputColorDataNameTable7;
    
    // Luu trang thai cac button
    private boolean startBtnEnabledTable7 = true;
    private boolean stopBtnEnabledTable7;
    private boolean printBtnEnabledTable7;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHourTable7, startMinuteTable7, startSecondTable7;
    private int endHourTable7, endMinuteTable7, endSecondTable7;

    
    private DataHolderTable7() {
        inputDataSTARTTable7 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable7 = "";
        inputDataNameTable7 = "";
        inputColorDataNameTable7 = "";
    }
    
    public static synchronized DataHolderTable7 getInstanceTable7() {
        if (instanceTable7 == null) {
            instanceTable7 = new DataHolderTable7();
        }
        return instanceTable7;
    }

    public String getInputDataSTARTTable7() {
        return inputDataSTARTTable7;
    }

    public void setInputDataSTARTTable7(String inputDataStartTable7) {
        this.inputDataSTARTTable7 = inputDataStartTable7;
    }
    
    public String getInputDataENDTable7() {
        return inputDataENDTable7;
    }

    public void setInputDataENDTable7(String inputDataEndTable7) {
        this.inputDataENDTable7 = inputDataEndTable7;
    }
    
    public String getInputDataNameTable7() {
        return inputDataNameTable7;
    }

    public void setInputDataNameTable7(String inputDatanameTable7) {
        this.inputDataNameTable7 = inputDatanameTable7;
    }
    
    public String getInputColorDataNameTable7() {
        return inputColorDataNameTable7;
    }

    public void setInputColorDataNameTable7(String inputColorDatanameTable7) {
        this.inputColorDataNameTable7 = inputColorDatanameTable7;
    }
    
    public boolean isStartBtnEnabledTable7() {
        return startBtnEnabledTable7;
    }

    public void setStartBtnEnabledTable7(boolean startBtnEnabledTable7) {
        this.startBtnEnabledTable7 = startBtnEnabledTable7;
    }

    public boolean isStopBtnEnabledTable7() {
        return stopBtnEnabledTable7;
    }

    public void setStopBtnEnabledTable7(boolean stopBtnEnabledTable7) {
        this.stopBtnEnabledTable7 = stopBtnEnabledTable7;
    }

    public boolean isPrintBtnEnabledTable7() {
        return printBtnEnabledTable7;
    }

    public void setPrintBtnEnabledTable7(boolean printBtnEnabledTable7) {
        this.printBtnEnabledTable7 = printBtnEnabledTable7;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable7() {
        return startHourTable7;
    }

    public void setStartHourTable7(int startHour) {
        this.startHourTable7 = startHour;
    }

    public int getStartMinuteTable7() {
        return startMinuteTable7;
    }

    public void setStartMinuteTable7(int startMinute) {
        this.startMinuteTable7 = startMinute;
    }

    public int getStartSecondTable7() {
        return startSecondTable7;
    }

    public void setStartSecondTable7(int startSecond) {
        this.startSecondTable7 = startSecond;
    }

    public int getEndHourTable7() {
        return endHourTable7;
    }

    public void setEndHourTable7(int endHourTable7) {
        this.endHourTable7 = endHourTable7;
    }

    public int getEndMinuteTable7() {
        return endMinuteTable7;
    }

    public void setEndMinuteTable7(int endMinuteTable7) {
        this.endMinuteTable7 = endMinuteTable7;
    }

    public int getEndSecondTable7() {
        return endSecondTable7;
    }

    public void setEndSecondTable7(int endSecondTable7) {
        this.endSecondTable7 = endSecondTable7;
    }
}



