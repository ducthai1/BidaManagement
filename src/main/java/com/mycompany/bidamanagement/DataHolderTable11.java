/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable11 {
    private static DataHolderTable11 instanceTable11;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable11;
    private String inputDataENDTable11;
    private String inputDataNameTable11;
    private String inputDataName11;

    // Lưu trạng thái tên table
    private String inputColorDataNameTable11;
    private String inputColorDataName11;

    // Lưu trạng thái các button
    private boolean startBtnEnabledTable11 = true;
    private boolean stopBtnEnabledTable11;
    private boolean printBtnEnabledTable11;

    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable11, startMinuteTable11, startSecondTable11;
    private int endHourTable11, endMinuteTable11, endSecondTable11;

    private DataHolderTable11() {
        inputDataSTARTTable11 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable11 = "";
        inputDataNameTable11 = "";
        inputColorDataNameTable11 = "";
        inputDataName11 = "";
        inputColorDataName11 = "";
    }

    public static synchronized DataHolderTable11 getInstanceTable11() {
        if (instanceTable11 == null) {
            instanceTable11 = new DataHolderTable11();
        }
        return instanceTable11;
    }

    public String getInputDataSTARTTable11() {
        return inputDataSTARTTable11;
    }

    public void setInputDataSTARTTable11(String inputDataStartTable11) {
        this.inputDataSTARTTable11 = inputDataStartTable11;
    }

    public String getInputDataENDTable11() {
        return inputDataENDTable11;
    }

    public void setInputDataENDTable11(String inputDataEndTable11) {
        this.inputDataENDTable11 = inputDataEndTable11;
    }

    public String getInputDataNameTable11() {
        return inputDataNameTable11;
    }

    public void setInputDataNameTable11(String inputDatanameTable11) {
        this.inputDataNameTable11 = inputDatanameTable11;
    }

    public String getInputColorDataNameTable11() {
        return inputColorDataNameTable11;
    }

    public void setInputColorDataNameTable11(String inputColorDatanameTable11) {
        this.inputColorDataNameTable11 = inputColorDatanameTable11;
    }

    public String getInputDataName11() {
        return inputDataNameTable11;
    }

    public void setInputDataName11(String inputDataname11) {
        this.inputDataNameTable11 = inputDataname11;
    }

    public String getInputColorDataName11() {
        return inputColorDataNameTable11;
    }

    public void setInputColorDataName11(String inputColorDataname11) {
        this.inputColorDataNameTable11 = inputColorDataname11;
    }

    public boolean isStartBtnEnabledTable11() {
        return startBtnEnabledTable11;
    }

    public void setStartBtnEnabledTable11(boolean startBtnEnabledTable11) {
        this.startBtnEnabledTable11 = startBtnEnabledTable11;
    }

    public boolean isStopBtnEnabledTable11() {
        return stopBtnEnabledTable11;
    }

    public void setStopBtnEnabledTable11(boolean stopBtnEnabledTable11) {
        this.stopBtnEnabledTable11 = stopBtnEnabledTable11;
    }

    public boolean isPrintBtnEnabledTable11() {
        return printBtnEnabledTable11;
    }

    public void setPrintBtnEnabledTable11(boolean printBtnEnabledTable11) {
        this.printBtnEnabledTable11 = printBtnEnabledTable11;
    }

    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable11() {
        return startHourTable11;
    }

    public void setStartHourTable11(int startHour) {
        this.startHourTable11 = startHour;
    }

    public int getStartMinuteTable11() {
        return startMinuteTable11;
    }

    public void setStartMinuteTable11(int startMinute) {
        this.startMinuteTable11 = startMinute;
    }

    public int getStartSecondTable11() {
        return startSecondTable11;
    }

    public void setStartSecondTable11(int startSecond) {
        this.startSecondTable11 = startSecond;
    }

    public int getEndHourTable11() {
        return endHourTable11;
    }

    public void setEndHourTable11(int endHourTable11) {
        this.endHourTable11 = endHourTable11;
    }

    public int getEndMinuteTable11() {
        return endMinuteTable11;
    }

    public void setEndMinuteTable11(int endMinuteTable11) {
        this.endMinuteTable11 = endMinuteTable11;
    }

    public int getEndSecondTable11() {
        return endSecondTable11;
    }

    public void setEndSecondTable11(int endSecondTable11) {
        this.endSecondTable11 = endSecondTable11;
    }

    private boolean addBtnEnableTable11 = false;

    public boolean isAddBtnEnabledTable11() {
        return addBtnEnableTable11;
    }

    public void setAddBtnEnabledTable11(boolean AddBtnEnableTable11) {
        this.addBtnEnableTable11 = AddBtnEnableTable11;
    }
}
