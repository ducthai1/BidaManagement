/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable6 {
    
    private static DataHolderTable6 instanceTable6;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTARTTable6;
    private String inputDataENDTable6;
    private String inputDataNameTable6;
    
    // Luu trang thai ten table
    private String inputColorDataNameTable6;
    
    // Luu trang thai cac button
    private boolean startBtnEnabledTable6 = true;
    private boolean stopBtnEnabledTable6;
    private boolean printBtnEnabledTable6;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHourTable6, startMinuteTable6, startSecondTable6;
    private int endHourTable6, endMinuteTable6, endSecondTable6;

    
    private DataHolderTable6() {
        inputDataSTARTTable6 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable6 = "";
        inputDataNameTable6 = "";
        inputColorDataNameTable6 = "";
    }
    
    public static synchronized DataHolderTable6 getInstanceTable6() {
        if (instanceTable6 == null) {
            instanceTable6 = new DataHolderTable6();
        }
        return instanceTable6;
    }

    public String getInputDataSTARTTable6() {
        return inputDataSTARTTable6;
    }

    public void setInputDataSTARTTable6(String inputDataStartTable6) {
        this.inputDataSTARTTable6 = inputDataStartTable6;
    }
    
    public String getInputDataENDTable6() {
        return inputDataENDTable6;
    }

    public void setInputDataENDTable6(String inputDataEndTable6) {
        this.inputDataENDTable6 = inputDataEndTable6;
    }
    
    public String getInputDataNameTable6() {
        return inputDataNameTable6;
    }

    public void setInputDataNameTable6(String inputDatanameTable6) {
        this.inputDataNameTable6 = inputDatanameTable6;
    }
    
    public String getInputColorDataNameTable6() {
        return inputColorDataNameTable6;
    }

    public void setInputColorDataNameTable6(String inputColorDatanameTable6) {
        this.inputColorDataNameTable6 = inputColorDatanameTable6;
    }
    
    public boolean isStartBtnEnabledTable6() {
        return startBtnEnabledTable6;
    }

    public void setStartBtnEnabledTable6(boolean startBtnEnabledTable6) {
        this.startBtnEnabledTable6 = startBtnEnabledTable6;
    }

    public boolean isStopBtnEnabledTable6() {
        return stopBtnEnabledTable6;
    }

    public void setStopBtnEnabledTable6(boolean stopBtnEnabledTable6) {
        this.stopBtnEnabledTable6 = stopBtnEnabledTable6;
    }

    public boolean isPrintBtnEnabledTable6() {
        return printBtnEnabledTable6;
    }

    public void setPrintBtnEnabledTable6(boolean printBtnEnabledTable6) {
        this.printBtnEnabledTable6 = printBtnEnabledTable6;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable6() {
        return startHourTable6;
    }

    public void setStartHourTable6(int startHour) {
        this.startHourTable6 = startHour;
    }

    public int getStartMinuteTable6() {
        return startMinuteTable6;
    }

    public void setStartMinuteTable6(int startMinute) {
        this.startMinuteTable6 = startMinute;
    }

    public int getStartSecondTable6() {
        return startSecondTable6;
    }

    public void setStartSecondTable6(int startSecond) {
        this.startSecondTable6 = startSecond;
    }

    public int getEndHourTable6() {
        return endHourTable6;
    }

    public void setEndHourTable6(int endHourTable6) {
        this.endHourTable6 = endHourTable6;
    }

    public int getEndMinuteTable6() {
        return endMinuteTable6;
    }

    public void setEndMinuteTable6(int endMinuteTable6) {
        this.endMinuteTable6 = endMinuteTable6;
    }

    public int getEndSecondTable6() {
        return endSecondTable6;
    }

    public void setEndSecondTable6(int endSecondTable6) {
        this.endSecondTable6 = endSecondTable6;
    }
}


