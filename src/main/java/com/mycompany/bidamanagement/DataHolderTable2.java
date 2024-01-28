/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable2 {
    
    private static DataHolderTable2 instanceTable2;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTARTTable2;
    private String inputDataENDTable2;
    private String inputDataNameTable2;
    
    // Luu trang thai ten table
    private String inputColorDataNameTable2;
    
    // Luu trang thai cac button
    private boolean startBtnEnabledTable2 = true;
    private boolean stopBtnEnabledTable2;
    private boolean printBtnEnabledTable2;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHourTable2, startMinuteTable2, startSecondTable2;
    private int endHourTable2, endMinuteTable2, endSecondTable2;

    
    private DataHolderTable2() {
        inputDataSTARTTable2 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable2 = "";
        inputDataNameTable2 = "";
        inputColorDataNameTable2 = "";
    }
    
    public static synchronized DataHolderTable2 getInstanceTable2() {
        if (instanceTable2 == null) {
            instanceTable2 = new DataHolderTable2();
        }
        return instanceTable2;
    }

    public String getInputDataSTARTTable2() {
        return inputDataSTARTTable2;
    }

    public void setInputDataSTARTTable2(String inputDataStartTable2) {
        this.inputDataSTARTTable2 = inputDataStartTable2;
    }
    
    public String getInputDataENDTable2() {
        return inputDataENDTable2;
    }

    public void setInputDataENDTable2(String inputDataEndTable2) {
        this.inputDataENDTable2 = inputDataEndTable2;
    }
    
    public String getInputDataNameTable2() {
        return inputDataNameTable2;
    }

    public void setInputDataNameTable2(String inputDatanameTable2) {
        this.inputDataNameTable2 = inputDatanameTable2;
    }
    
    public String getInputColorDataNameTable2() {
        return inputColorDataNameTable2;
    }

    public void setInputColorDataNameTable2(String inputColorDatanameTable2) {
        this.inputColorDataNameTable2 = inputColorDatanameTable2;
    }
    
    public boolean isStartBtnEnabledTable2() {
        return startBtnEnabledTable2;
    }

    public void setStartBtnEnabledTable2(boolean startBtnEnabledTable2) {
        this.startBtnEnabledTable2 = startBtnEnabledTable2;
    }

    public boolean isStopBtnEnabledTable2() {
        return stopBtnEnabledTable2;
    }

    public void setStopBtnEnabledTable2(boolean stopBtnEnabledTable2) {
        this.stopBtnEnabledTable2 = stopBtnEnabledTable2;
    }

    public boolean isPrintBtnEnabledTable2() {
        return printBtnEnabledTable2;
    }

    public void setPrintBtnEnabledTable2(boolean printBtnEnabledTable2) {
        this.printBtnEnabledTable2 = printBtnEnabledTable2;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable2() {
        return startHourTable2;
    }

    public void setStartHourTable2(int startHour) {
        this.startHourTable2 = startHour;
    }

    public int getStartMinuteTable2() {
        return startMinuteTable2;
    }

    public void setStartMinuteTable2(int startMinute) {
        this.startMinuteTable2 = startMinute;
    }

    public int getStartSecondTable2() {
        return startSecondTable2;
    }

    public void setStartSecondTable2(int startSecond) {
        this.startSecondTable2 = startSecond;
    }

    public int getEndHourTable2() {
        return endHourTable2;
    }

    public void setEndHourTable2(int endHourTable2) {
        this.endHourTable2 = endHourTable2;
    }

    public int getEndMinuteTable2() {
        return endMinuteTable2;
    }

    public void setEndMinuteTable2(int endMinuteTable2) {
        this.endMinuteTable2 = endMinuteTable2;
    }

    public int getEndSecondTable2() {
        return endSecondTable2;
    }

    public void setEndSecondTable2(int endSecondTable2) {
        this.endSecondTable2 = endSecondTable2;
    }
}



