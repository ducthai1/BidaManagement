/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable14 {
    private static DataHolderTable14 instanceTable14;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable14;
    private String inputDataENDTable14;
    private String inputDataNameTable14;
    private String inputDataName14;

    // Lưu trạng thái tên table
    private String inputColorDataNameTable14;
    private String inputColorDataName14;

    // Lưu trạng thái các button
    private boolean startBtnEnabledTable14 = true;
    private boolean stopBtnEnabledTable14;
    private boolean printBtnEnabledTable14;

    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable14, startMinuteTable14, startSecondTable14;
    private int endHourTable14, endMinuteTable14, endSecondTable14;

    private DataHolderTable14() {
        inputDataSTARTTable14 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable14 = "";
        inputDataNameTable14 = "";
        inputColorDataNameTable14 = "";
        inputDataName14 = "";
        inputColorDataName14 = "";
    }

    public static synchronized DataHolderTable14 getInstanceTable14() {
        if (instanceTable14 == null) {
            instanceTable14 = new DataHolderTable14();
        }
        return instanceTable14;
    }

    public String getInputDataSTARTTable14() {
        return inputDataSTARTTable14;
    }

    public void setInputDataSTARTTable14(String inputDataStartTable14) {
        this.inputDataSTARTTable14 = inputDataStartTable14;
    }

    public String getInputDataENDTable14() {
        return inputDataENDTable14;
    }

    public void setInputDataENDTable14(String inputDataEndTable14) {
        this.inputDataENDTable14 = inputDataEndTable14;
    }

    public String getInputDataNameTable14() {
        return inputDataNameTable14;
    }

    public void setInputDataNameTable14(String inputDatanameTable14) {
        this.inputDataNameTable14 = inputDatanameTable14;
    }

    public String getInputColorDataNameTable14() {
        return inputColorDataNameTable14;
    }

    public void setInputColorDataNameTable14(String inputColorDatanameTable14) {
        this.inputColorDataNameTable14 = inputColorDatanameTable14;
    }

    public String getInputDataName14() {
        return inputDataNameTable14;
    }

    public void setInputDataName14(String inputDataname14) {
        this.inputDataNameTable14 = inputDataname14;
    }

    public String getInputColorDataName14() {
        return inputColorDataNameTable14;
    }

    public void setInputColorDataName14(String inputColorDataname14) {
        this.inputColorDataNameTable14 = inputColorDataname14;
    }

    public boolean isStartBtnEnabledTable14() {
        return startBtnEnabledTable14;
    }

    public void setStartBtnEnabledTable14(boolean startBtnEnabledTable14) {
        this.startBtnEnabledTable14 = startBtnEnabledTable14;
    }

    public boolean isStopBtnEnabledTable14() {
        return stopBtnEnabledTable14;
    }

    public void setStopBtnEnabledTable14(boolean stopBtnEnabledTable14) {
        this.stopBtnEnabledTable14 = stopBtnEnabledTable14;
    }

    public boolean isPrintBtnEnabledTable14() {
        return printBtnEnabledTable14;
    }

    public void setPrintBtnEnabledTable14(boolean printBtnEnabledTable14) {
        this.printBtnEnabledTable14 = printBtnEnabledTable14;
    }

    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable14() {
        return startHourTable14;
    }

    public void setStartHourTable14(int startHour) {
        this.startHourTable14 = startHour;
    }

    public int getStartMinuteTable14() {
        return startMinuteTable14;
    }

    public void setStartMinuteTable14(int startMinute) {
        this.startMinuteTable14 = startMinute;
    }

    public int getStartSecondTable14() {
        return startSecondTable14;
    }

    public void setStartSecondTable14(int startSecond) {
        this.startSecondTable14 = startSecond;
    }

    public int getEndHourTable14() {
        return endHourTable14;
    }

    public void setEndHourTable14(int endHourTable14) {
        this.endHourTable14 = endHourTable14;
    }

    public int getEndMinuteTable14() {
        return endMinuteTable14;
    }

    public void setEndMinuteTable14(int endMinuteTable14) {
        this.endMinuteTable14 = endMinuteTable14;
    }

    public int getEndSecondTable14() {
        return endSecondTable14;
    }

    public void setEndSecondTable14(int endSecondTable14) {
        this.endSecondTable14 = endSecondTable14;
    }

    private boolean addBtnEnableTable14 = false;

    public boolean isAddBtnEnabledTable14() {
        return addBtnEnableTable14;
    }

    public void setAddBtnEnabledTable14(boolean AddBtnEnableTable14) {
        this.addBtnEnableTable14 = AddBtnEnableTable14;
    }

}
