/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable13 {
    private static DataHolderTable13 instanceTable13;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable13;
    private String inputDataENDTable13;
    private String inputDataNameTable13;
    private String inputDataName13;

    // Lưu trạng thái tên table
    private String inputColorDataNameTable13;
    private String inputColorDataName13;

    // Lưu trạng thái các button
    private boolean startBtnEnabledTable13 = true;
    private boolean stopBtnEnabledTable13;
    private boolean printBtnEnabledTable13;

    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable13, startMinuteTable13, startSecondTable13;
    private int endHourTable13, endMinuteTable13, endSecondTable13;

    private DataHolderTable13() {
        inputDataSTARTTable13 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable13 = "";
        inputDataNameTable13 = "";
        inputColorDataNameTable13 = "";
        inputDataName13 = "";
        inputColorDataName13 = "";
    }

    public static synchronized DataHolderTable13 getInstanceTable13() {
        if (instanceTable13 == null) {
            instanceTable13 = new DataHolderTable13();
        }
        return instanceTable13;
    }

    public String getInputDataSTARTTable13() {
        return inputDataSTARTTable13;
    }

    public void setInputDataSTARTTable13(String inputDataStartTable13) {
        this.inputDataSTARTTable13 = inputDataStartTable13;
    }

    public String getInputDataENDTable13() {
        return inputDataENDTable13;
    }

    public void setInputDataENDTable13(String inputDataEndTable13) {
        this.inputDataENDTable13 = inputDataEndTable13;
    }

    public String getInputDataNameTable13() {
        return inputDataNameTable13;
    }

    public void setInputDataNameTable13(String inputDatanameTable13) {
        this.inputDataNameTable13 = inputDatanameTable13;
    }

    public String getInputColorDataNameTable13() {
        return inputColorDataNameTable13;
    }

    public void setInputColorDataNameTable13(String inputColorDatanameTable13) {
        this.inputColorDataNameTable13 = inputColorDatanameTable13;
    }

    public String getInputDataName13() {
        return inputDataNameTable13;
    }

    public void setInputDataName13(String inputDataname13) {
        this.inputDataNameTable13 = inputDataname13;
    }

    public String getInputColorDataName13() {
        return inputColorDataNameTable13;
    }

    public void setInputColorDataName13(String inputColorDataname13) {
        this.inputColorDataNameTable13 = inputColorDataname13;
    }

    public boolean isStartBtnEnabledTable13() {
        return startBtnEnabledTable13;
    }

    public void setStartBtnEnabledTable13(boolean startBtnEnabledTable13) {
        this.startBtnEnabledTable13 = startBtnEnabledTable13;
    }

    public boolean isStopBtnEnabledTable13() {
        return stopBtnEnabledTable13;
    }

    public void setStopBtnEnabledTable13(boolean stopBtnEnabledTable13) {
        this.stopBtnEnabledTable13 = stopBtnEnabledTable13;
    }

    public boolean isPrintBtnEnabledTable13() {
        return printBtnEnabledTable13;
    }

    public void setPrintBtnEnabledTable13(boolean printBtnEnabledTable13) {
        this.printBtnEnabledTable13 = printBtnEnabledTable13;
    }

    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable13() {
        return startHourTable13;
    }

    public void setStartHourTable13(int startHour) {
        this.startHourTable13 = startHour;
    }

    public int getStartMinuteTable13() {
        return startMinuteTable13;
    }

    public void setStartMinuteTable13(int startMinute) {
        this.startMinuteTable13 = startMinute;
    }

    public int getStartSecondTable13() {
        return startSecondTable13;
    }

    public void setStartSecondTable13(int startSecond) {
        this.startSecondTable13 = startSecond;
    }

    public int getEndHourTable13() {
        return endHourTable13;
    }

    public void setEndHourTable13(int endHourTable13) {
        this.endHourTable13 = endHourTable13;
    }

    public int getEndMinuteTable13() {
        return endMinuteTable13;
    }

    public void setEndMinuteTable13(int endMinuteTable13) {
        this.endMinuteTable13 = endMinuteTable13;
    }

    public int getEndSecondTable13() {
        return endSecondTable13;
    }

    public void setEndSecondTable13(int endSecondTable13) {
        this.endSecondTable13 = endSecondTable13;
    }

    private boolean addBtnEnableTable13 = false;

    public boolean isAddBtnEnabledTable13() {
        return addBtnEnableTable13;
    }

    public void setAddBtnEnabledTable13(boolean AddBtnEnableTable13) {
        this.addBtnEnableTable13 = AddBtnEnableTable13;
    }

}
