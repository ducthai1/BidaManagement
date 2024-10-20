/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable17 {
    private static DataHolderTable17 instanceTable17;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable17;
    private String inputDataENDTable17;
    private String inputDataNameTable17;
    private String inputDataName17;

    // Lưu trạng thái tên table
    private String inputColorDataNameTable17;
    private String inputColorDataName17;

    // Lưu trạng thái các button
    private boolean startBtnEnabledTable17 = true;
    private boolean stopBtnEnabledTable17;
    private boolean printBtnEnabledTable17;

    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable17, startMinuteTable17, startSecondTable17;
    private int endHourTable17, endMinuteTable17, endSecondTable17;

    private DataHolderTable17() {
        inputDataSTARTTable17 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable17 = "";
        inputDataNameTable17 = "";
        inputColorDataNameTable17 = "";
        inputDataName17 = "";
        inputColorDataName17 = "";
    }

    public static synchronized DataHolderTable17 getInstanceTable17() {
        if (instanceTable17 == null) {
            instanceTable17 = new DataHolderTable17();
        }
        return instanceTable17;
    }

    public String getInputDataSTARTTable17() {
        return inputDataSTARTTable17;
    }

    public void setInputDataSTARTTable17(String inputDataStartTable17) {
        this.inputDataSTARTTable17 = inputDataStartTable17;
    }

    public String getInputDataENDTable17() {
        return inputDataENDTable17;
    }

    public void setInputDataENDTable17(String inputDataEndTable17) {
        this.inputDataENDTable17 = inputDataEndTable17;
    }

    public String getInputDataNameTable17() {
        return inputDataNameTable17;
    }

    public void setInputDataNameTable17(String inputDatanameTable17) {
        this.inputDataNameTable17 = inputDatanameTable17;
    }

    public String getInputColorDataNameTable17() {
        return inputColorDataNameTable17;
    }

    public void setInputColorDataNameTable17(String inputColorDatanameTable17) {
        this.inputColorDataNameTable17 = inputColorDatanameTable17;
    }

    public String getInputDataName17() {
        return inputDataNameTable17;
    }

    public void setInputDataName17(String inputDataname17) {
        this.inputDataNameTable17 = inputDataname17;
    }

    public String getInputColorDataName17() {
        return inputColorDataNameTable17;
    }

    public void setInputColorDataName17(String inputColorDataname17) {
        this.inputColorDataNameTable17 = inputColorDataname17;
    }

    public boolean isStartBtnEnabledTable17() {
        return startBtnEnabledTable17;
    }

    public void setStartBtnEnabledTable17(boolean startBtnEnabledTable17) {
        this.startBtnEnabledTable17 = startBtnEnabledTable17;
    }

    public boolean isStopBtnEnabledTable17() {
        return stopBtnEnabledTable17;
    }

    public void setStopBtnEnabledTable17(boolean stopBtnEnabledTable17) {
        this.stopBtnEnabledTable17 = stopBtnEnabledTable17;
    }

    public boolean isPrintBtnEnabledTable17() {
        return printBtnEnabledTable17;
    }

    public void setPrintBtnEnabledTable17(boolean printBtnEnabledTable17) {
        this.printBtnEnabledTable17 = printBtnEnabledTable17;
    }

    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable17() {
        return startHourTable17;
    }

    public void setStartHourTable17(int startHour) {
        this.startHourTable17 = startHour;
    }

    public int getStartMinuteTable17() {
        return startMinuteTable17;
    }

    public void setStartMinuteTable17(int startMinute) {
        this.startMinuteTable17 = startMinute;
    }

    public int getStartSecondTable17() {
        return startSecondTable17;
    }

    public void setStartSecondTable17(int startSecond) {
        this.startSecondTable17 = startSecond;
    }

    public int getEndHourTable17() {
        return endHourTable17;
    }

    public void setEndHourTable17(int endHourTable17) {
        this.endHourTable17 = endHourTable17;
    }

    public int getEndMinuteTable17() {
        return endMinuteTable17;
    }

    public void setEndMinuteTable17(int endMinuteTable17) {
        this.endMinuteTable17 = endMinuteTable17;
    }

    public int getEndSecondTable17() {
        return endSecondTable17;
    }

    public void setEndSecondTable17(int endSecondTable17) {
        this.endSecondTable17 = endSecondTable17;
    }

    private boolean addBtnEnableTable17 = false;

    public boolean isAddBtnEnabledTable17() {
        return addBtnEnableTable17;
    }

    public void setAddBtnEnabledTable17(boolean AddBtnEnableTable17) {
        this.addBtnEnableTable17 = AddBtnEnableTable17;
    }

}
