/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class DataHolderTable1 {
    
    private static DataHolderTable1 instanceTable1;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTARTTable1;
    private String inputDataENDTable1;
    private String inputDataNameTable1;
    private String inputDataName1;
    
    // Luu trang thai ten table
    private String inputColorDataNameTable1;
    private String inputColorDataName1;
    
    // Luu trang thai cac button
    private boolean startBtnEnabledTable1 = true;
    private boolean stopBtnEnabledTable1;
    private boolean printBtnEnabledTable1;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHourTable1, startMinuteTable1, startSecondTable1;
    private int endHourTable1, endMinuteTable1, endSecondTable1;
    
    
    private DataHolderTable1() {
        inputDataSTARTTable1 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable1 = "";
        inputDataNameTable1 = "";
        inputColorDataNameTable1 = "";
        inputDataName1 = "";
        inputColorDataName1 = "";
    }
    
    public static synchronized DataHolderTable1 getInstanceTable1() {
        if (instanceTable1 == null) {
            instanceTable1 = new DataHolderTable1();
        }
        return instanceTable1;
    }

    public String getInputDataSTARTTable1() {
        return inputDataSTARTTable1;
    }

    public void setInputDataSTARTTable1(String inputDataStartTable1) {
        this.inputDataSTARTTable1 = inputDataStartTable1;
    }
    
    public String getInputDataENDTable1() {
        return inputDataENDTable1;
    }

    public void setInputDataENDTable1(String inputDataEndTable1) {
        this.inputDataENDTable1 = inputDataEndTable1;
    }
    
    public String getInputDataNameTable1() {
        return inputDataNameTable1;
    }

    public void setInputDataNameTable1(String inputDatanameTable1) {
        this.inputDataNameTable1 = inputDatanameTable1;
    }
    
    public String getInputColorDataNameTable1() {
        return inputColorDataNameTable1;
    }

    public void setInputColorDataNameTable1(String inputColorDatanameTable1) {
        this.inputColorDataNameTable1 = inputColorDatanameTable1;
    }
    
    public String getInputDataName1() {
        return inputDataNameTable1;
    }

    public void setInputDataName1(String inputDatanameTable1) {
        this.inputDataNameTable1 = inputDatanameTable1;
    }
    
    public String getInputColorDataName1() {
        return inputColorDataNameTable1;
    }

    public void setInputColorDataName1(String inputColorDatanameTable1) {
        this.inputColorDataNameTable1 = inputColorDatanameTable1;
    }
    
    public boolean isStartBtnEnabledTable1() {
        return startBtnEnabledTable1;
    }

    public void setStartBtnEnabledTable1(boolean startBtnEnabledTable1) {
        this.startBtnEnabledTable1 = startBtnEnabledTable1;
    }

    public boolean isStopBtnEnabledTable1() {
        return stopBtnEnabledTable1;
    }

    public void setStopBtnEnabledTable1(boolean stopBtnEnabledTable1) {
        this.stopBtnEnabledTable1 = stopBtnEnabledTable1;
    }

    public boolean isPrintBtnEnabledTable1() {
        return printBtnEnabledTable1;
    }

    public void setPrintBtnEnabledTable1(boolean printBtnEnabledTable1) {
        this.printBtnEnabledTable1 = printBtnEnabledTable1;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable1() {
        return startHourTable1;
    }

    public void setStartHourTable1(int startHour) {
        this.startHourTable1 = startHour;
    }

    public int getStartMinuteTable1() {
        return startMinuteTable1;
    }

    public void setStartMinuteTable1(int startMinute) {
        this.startMinuteTable1 = startMinute;
    }

    public int getStartSecondTable1() {
        return startSecondTable1;
    }

    public void setStartSecondTable1(int startSecond) {
        this.startSecondTable1 = startSecond;
    }

    public int getEndHourTable1() {
        return endHourTable1;
    }

    public void setEndHourTable1(int endHourTable1) {
        this.endHourTable1 = endHourTable1;
    }

    public int getEndMinuteTable1() {
        return endMinuteTable1;
    }

    public void setEndMinuteTable1(int endMinuteTable1) {
        this.endMinuteTable1 = endMinuteTable1;
    }

    public int getEndSecondTable1() {
        return endSecondTable1;
    }

    public void setEndSecondTable1(int endSecondTable1) {
        this.endSecondTable1 = endSecondTable1;
    }
    
    
    private boolean addBtnEnableTable1 = false;
    
    public boolean isAddBtnEnabledTable1() {
        return addBtnEnableTable1;
    }

    public void setAddBtnEnabledTable1(boolean AddBtnEnableTable1) {
        this.addBtnEnableTable1 = AddBtnEnableTable1;
    }
}
