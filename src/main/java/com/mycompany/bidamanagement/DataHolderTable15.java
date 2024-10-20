/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable15 {
    private static DataHolderTable15 instanceTable15;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable15;
    private String inputDataENDTable15;
    private String inputDataNameTable15;
    private String inputDataName15;

    // Lưu trạng thái tên table
    private String inputColorDataNameTable15;
    private String inputColorDataName15;

    // Lưu trạng thái các button
    private boolean startBtnEnabledTable15 = true;
    private boolean stopBtnEnabledTable15;
    private boolean printBtnEnabledTable15;

    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable15, startMinuteTable15, startSecondTable15;
    private int endHourTable15, endMinuteTable15, endSecondTable15;

    private DataHolderTable15() {
        inputDataSTARTTable15 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable15 = "";
        inputDataNameTable15 = "";
        inputColorDataNameTable15 = "";
        inputDataName15 = "";
        inputColorDataName15 = "";
    }

    public static synchronized DataHolderTable15 getInstanceTable15() {
        if (instanceTable15 == null) {
            instanceTable15 = new DataHolderTable15();
        }
        return instanceTable15;
    }

    public String getInputDataSTARTTable15() {
        return inputDataSTARTTable15;
    }

    public void setInputDataSTARTTable15(String inputDataStartTable15) {
        this.inputDataSTARTTable15 = inputDataStartTable15;
    }

    public String getInputDataENDTable15() {
        return inputDataENDTable15;
    }

    public void setInputDataENDTable15(String inputDataEndTable15) {
        this.inputDataENDTable15 = inputDataEndTable15;
    }

    public String getInputDataNameTable15() {
        return inputDataNameTable15;
    }

    public void setInputDataNameTable15(String inputDatanameTable15) {
        this.inputDataNameTable15 = inputDatanameTable15;
    }

    public String getInputColorDataNameTable15() {
        return inputColorDataNameTable15;
    }

    public void setInputColorDataNameTable15(String inputColorDatanameTable15) {
        this.inputColorDataNameTable15 = inputColorDatanameTable15;
    }

    public String getInputDataName15() {
        return inputDataNameTable15;
    }

    public void setInputDataName15(String inputDataname15) {
        this.inputDataNameTable15 = inputDataname15;
    }

    public String getInputColorDataName15() {
        return inputColorDataNameTable15;
    }

    public void setInputColorDataName15(String inputColorDataname15) {
        this.inputColorDataNameTable15 = inputColorDataname15;
    }

    public boolean isStartBtnEnabledTable15() {
        return startBtnEnabledTable15;
    }

    public void setStartBtnEnabledTable15(boolean startBtnEnabledTable15) {
        this.startBtnEnabledTable15 = startBtnEnabledTable15;
    }

    public boolean isStopBtnEnabledTable15() {
        return stopBtnEnabledTable15;
    }

    public void setStopBtnEnabledTable15(boolean stopBtnEnabledTable15) {
        this.stopBtnEnabledTable15 = stopBtnEnabledTable15;
    }

    public boolean isPrintBtnEnabledTable15() {
        return printBtnEnabledTable15;
    }

    public void setPrintBtnEnabledTable15(boolean printBtnEnabledTable15) {
        this.printBtnEnabledTable15 = printBtnEnabledTable15;
    }

    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable15() {
        return startHourTable15;
    }

    public void setStartHourTable15(int startHour) {
        this.startHourTable15 = startHour;
    }

    public int getStartMinuteTable15() {
        return startMinuteTable15;
    }

    public void setStartMinuteTable15(int startMinute) {
        this.startMinuteTable15 = startMinute;
    }

    public int getStartSecondTable15() {
        return startSecondTable15;
    }

    public void setStartSecondTable15(int startSecond) {
        this.startSecondTable15 = startSecond;
    }

    public int getEndHourTable15() {
        return endHourTable15;
    }

    public void setEndHourTable15(int endHourTable15) {
        this.endHourTable15 = endHourTable15;
    }

    public int getEndMinuteTable15() {
        return endMinuteTable15;
    }

    public void setEndMinuteTable15(int endMinuteTable15) {
        this.endMinuteTable15 = endMinuteTable15;
    }

    public int getEndSecondTable15() {
        return endSecondTable15;
    }

    public void setEndSecondTable15(int endSecondTable15) {
        this.endSecondTable15 = endSecondTable15;
    }

    private boolean addBtnEnableTable15 = false;

    public boolean isAddBtnEnabledTable15() {
        return addBtnEnableTable15;
    }

    public void setAddBtnEnabledTable15(boolean AddBtnEnableTable15) {
        this.addBtnEnableTable15 = AddBtnEnableTable15;
    }

}
