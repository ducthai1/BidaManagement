/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable18 {
    private static DataHolderTable18 instanceTable18;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable18;
    private String inputDataENDTable18;
    private String inputDataNameTable18;
    private String inputDataName18;

    // Lưu trạng thái tên table
    private String inputColorDataNameTable18;
    private String inputColorDataName18;

    // Lưu trạng thái các button
    private boolean startBtnEnabledTable18 = true;
    private boolean stopBtnEnabledTable18;
    private boolean printBtnEnabledTable18;

    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable18, startMinuteTable18, startSecondTable18;
    private int endHourTable18, endMinuteTable18, endSecondTable18;

    private DataHolderTable18() {
        inputDataSTARTTable18 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable18 = "";
        inputDataNameTable18 = "";
        inputColorDataNameTable18 = "";
        inputDataName18 = "";
        inputColorDataName18 = "";
    }

    public static synchronized DataHolderTable18 getInstanceTable18() {
        if (instanceTable18 == null) {
            instanceTable18 = new DataHolderTable18();
        }
        return instanceTable18;
    }

    public String getInputDataSTARTTable18() {
        return inputDataSTARTTable18;
    }

    public void setInputDataSTARTTable18(String inputDataStartTable18) {
        this.inputDataSTARTTable18 = inputDataStartTable18;
    }

    public String getInputDataENDTable18() {
        return inputDataENDTable18;
    }

    public void setInputDataENDTable18(String inputDataEndTable18) {
        this.inputDataENDTable18 = inputDataEndTable18;
    }

    public String getInputDataNameTable18() {
        return inputDataNameTable18;
    }

    public void setInputDataNameTable18(String inputDatanameTable18) {
        this.inputDataNameTable18 = inputDatanameTable18;
    }

    public String getInputColorDataNameTable18() {
        return inputColorDataNameTable18;
    }

    public void setInputColorDataNameTable18(String inputColorDatanameTable18) {
        this.inputColorDataNameTable18 = inputColorDatanameTable18;
    }

    public String getInputDataName18() {
        return inputDataNameTable18;
    }

    public void setInputDataName18(String inputDataname18) {
        this.inputDataNameTable18 = inputDataname18;
    }

    public String getInputColorDataName18() {
        return inputColorDataNameTable18;
    }

    public void setInputColorDataName18(String inputColorDataname18) {
        this.inputColorDataNameTable18 = inputColorDataname18;
    }

    public boolean isStartBtnEnabledTable18() {
        return startBtnEnabledTable18;
    }

    public void setStartBtnEnabledTable18(boolean startBtnEnabledTable18) {
        this.startBtnEnabledTable18 = startBtnEnabledTable18;
    }

    public boolean isStopBtnEnabledTable18() {
        return stopBtnEnabledTable18;
    }

    public void setStopBtnEnabledTable18(boolean stopBtnEnabledTable18) {
        this.stopBtnEnabledTable18 = stopBtnEnabledTable18;
    }

    public boolean isPrintBtnEnabledTable18() {
        return printBtnEnabledTable18;
    }

    public void setPrintBtnEnabledTable18(boolean printBtnEnabledTable18) {
        this.printBtnEnabledTable18 = printBtnEnabledTable18;
    }

    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable18() {
        return startHourTable18;
    }

    public void setStartHourTable18(int startHour) {
        this.startHourTable18 = startHour;
    }

    public int getStartMinuteTable18() {
        return startMinuteTable18;
    }

    public void setStartMinuteTable18(int startMinute) {
        this.startMinuteTable18 = startMinute;
    }

    public int getStartSecondTable18() {
        return startSecondTable18;
    }

    public void setStartSecondTable18(int startSecond) {
        this.startSecondTable18 = startSecond;
    }

    public int getEndHourTable18() {
        return endHourTable18;
    }

    public void setEndHourTable18(int endHourTable18) {
        this.endHourTable18 = endHourTable18;
    }

    public int getEndMinuteTable18() {
        return endMinuteTable18;
    }

    public void setEndMinuteTable18(int endMinuteTable18) {
        this.endMinuteTable18 = endMinuteTable18;
    }

    public int getEndSecondTable18() {
        return endSecondTable18;
    }

    public void setEndSecondTable18(int endSecondTable18) {
        this.endSecondTable18 = endSecondTable18;
    }

    private boolean addBtnEnableTable18 = false;

    public boolean isAddBtnEnabledTable18() {
        return addBtnEnableTable18;
    }

    public void setAddBtnEnabledTable18(boolean AddBtnEnableTable18) {
        this.addBtnEnableTable18 = AddBtnEnableTable18;
    }

}
