/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable12 {
    private static DataHolderTable12 instanceTable12;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable12;
    private String inputDataENDTable12;
    private String inputDataNameTable12;
    private String inputDataName12;

    // Lưu trạng thái tên table
    private String inputColorDataNameTable12;
    private String inputColorDataName12;

    // Lưu trạng thái các button
    private boolean startBtnEnabledTable12 = true;
    private boolean stopBtnEnabledTable12;
    private boolean printBtnEnabledTable12;

    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable12, startMinuteTable12, startSecondTable12;
    private int endHourTable12, endMinuteTable12, endSecondTable12;

    private DataHolderTable12() {
        inputDataSTARTTable12 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable12 = "";
        inputDataNameTable12 = "";
        inputColorDataNameTable12 = "";
        inputDataName12 = "";
        inputColorDataName12 = "";
    }

    public static synchronized DataHolderTable12 getInstanceTable12() {
        if (instanceTable12 == null) {
            instanceTable12 = new DataHolderTable12();
        }
        return instanceTable12;
    }

    public String getInputDataSTARTTable12() {
        return inputDataSTARTTable12;
    }

    public void setInputDataSTARTTable12(String inputDataStartTable12) {
        this.inputDataSTARTTable12 = inputDataStartTable12;
    }

    public String getInputDataENDTable12() {
        return inputDataENDTable12;
    }

    public void setInputDataENDTable12(String inputDataEndTable12) {
        this.inputDataENDTable12 = inputDataEndTable12;
    }

    public String getInputDataNameTable12() {
        return inputDataNameTable12;
    }

    public void setInputDataNameTable12(String inputDatanameTable12) {
        this.inputDataNameTable12 = inputDatanameTable12;
    }

    public String getInputColorDataNameTable12() {
        return inputColorDataNameTable12;
    }

    public void setInputColorDataNameTable12(String inputColorDatanameTable12) {
        this.inputColorDataNameTable12 = inputColorDatanameTable12;
    }

    public String getInputDataName12() {
        return inputDataNameTable12;
    }

    public void setInputDataName12(String inputDataname12) {
        this.inputDataNameTable12 = inputDataname12;
    }

    public String getInputColorDataName12() {
        return inputColorDataNameTable12;
    }

    public void setInputColorDataName12(String inputColorDataname12) {
        this.inputColorDataNameTable12 = inputColorDataname12;
    }

    public boolean isStartBtnEnabledTable12() {
        return startBtnEnabledTable12;
    }

    public void setStartBtnEnabledTable12(boolean startBtnEnabledTable12) {
        this.startBtnEnabledTable12 = startBtnEnabledTable12;
    }

    public boolean isStopBtnEnabledTable12() {
        return stopBtnEnabledTable12;
    }

    public void setStopBtnEnabledTable12(boolean stopBtnEnabledTable12) {
        this.stopBtnEnabledTable12 = stopBtnEnabledTable12;
    }

    public boolean isPrintBtnEnabledTable12() {
        return printBtnEnabledTable12;
    }

    public void setPrintBtnEnabledTable12(boolean printBtnEnabledTable12) {
        this.printBtnEnabledTable12 = printBtnEnabledTable12;
    }

    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable12() {
        return startHourTable12;
    }

    public void setStartHourTable12(int startHour) {
        this.startHourTable12 = startHour;
    }

    public int getStartMinuteTable12() {
        return startMinuteTable12;
    }

    public void setStartMinuteTable12(int startMinute) {
        this.startMinuteTable12 = startMinute;
    }

    public int getStartSecondTable12() {
        return startSecondTable12;
    }

    public void setStartSecondTable12(int startSecond) {
        this.startSecondTable12 = startSecond;
    }

    public int getEndHourTable12() {
        return endHourTable12;
    }

    public void setEndHourTable12(int endHourTable12) {
        this.endHourTable12 = endHourTable12;
    }

    public int getEndMinuteTable12() {
        return endMinuteTable12;
    }

    public void setEndMinuteTable12(int endMinuteTable12) {
        this.endMinuteTable12 = endMinuteTable12;
    }

    public int getEndSecondTable12() {
        return endSecondTable12;
    }

    public void setEndSecondTable12(int endSecondTable12) {
        this.endSecondTable12 = endSecondTable12;
    }

    private boolean addBtnEnableTable12 = false;

    public boolean isAddBtnEnabledTable12() {
        return addBtnEnableTable12;
    }

    public void setAddBtnEnabledTable12(boolean AddBtnEnableTable12) {
        this.addBtnEnableTable12 = AddBtnEnableTable12;
    }

}
