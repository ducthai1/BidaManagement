/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable16 {
    private static DataHolderTable16 instanceTable16;

    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable16;
    private String inputDataENDTable16;
    private String inputDataNameTable16;
    private String inputDataName16;

    // Lưu trạng thái tên table
    private String inputColorDataNameTable16;
    private String inputColorDataName16;

    // Lưu trạng thái các button
    private boolean startBtnEnabledTable16 = true;
    private boolean stopBtnEnabledTable16;
    private boolean printBtnEnabledTable16;

    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable16, startMinuteTable16, startSecondTable16;
    private int endHourTable16, endMinuteTable16, endSecondTable16;

    private DataHolderTable16() {
        inputDataSTARTTable16 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable16 = "";
        inputDataNameTable16 = "";
        inputColorDataNameTable16 = "";
        inputDataName16 = "";
        inputColorDataName16 = "";
    }

    public static synchronized DataHolderTable16 getInstanceTable16() {
        if (instanceTable16 == null) {
            instanceTable16 = new DataHolderTable16();
        }
        return instanceTable16;
    }

    public String getInputDataSTARTTable16() {
        return inputDataSTARTTable16;
    }

    public void setInputDataSTARTTable16(String inputDataStartTable16) {
        this.inputDataSTARTTable16 = inputDataStartTable16;
    }

    public String getInputDataENDTable16() {
        return inputDataENDTable16;
    }

    public void setInputDataENDTable16(String inputDataEndTable16) {
        this.inputDataENDTable16 = inputDataEndTable16;
    }

    public String getInputDataNameTable16() {
        return inputDataNameTable16;
    }

    public void setInputDataNameTable16(String inputDatanameTable16) {
        this.inputDataNameTable16 = inputDatanameTable16;
    }

    public String getInputColorDataNameTable16() {
        return inputColorDataNameTable16;
    }

    public void setInputColorDataNameTable16(String inputColorDatanameTable16) {
        this.inputColorDataNameTable16 = inputColorDatanameTable16;
    }

    public String getInputDataName16() {
        return inputDataNameTable16;
    }

    public void setInputDataName16(String inputDataname16) {
        this.inputDataNameTable16 = inputDataname16;
    }

    public String getInputColorDataName16() {
        return inputColorDataNameTable16;
    }

    public void setInputColorDataName16(String inputColorDataname16) {
        this.inputColorDataNameTable16 = inputColorDataname16;
    }

    public boolean isStartBtnEnabledTable16() {
        return startBtnEnabledTable16;
    }

    public void setStartBtnEnabledTable16(boolean startBtnEnabledTable16) {
        this.startBtnEnabledTable16 = startBtnEnabledTable16;
    }

    public boolean isStopBtnEnabledTable16() {
        return stopBtnEnabledTable16;
    }

    public void setStopBtnEnabledTable16(boolean stopBtnEnabledTable16) {
        this.stopBtnEnabledTable16 = stopBtnEnabledTable16;
    }

    public boolean isPrintBtnEnabledTable16() {
        return printBtnEnabledTable16;
    }

    public void setPrintBtnEnabledTable16(boolean printBtnEnabledTable16) {
        this.printBtnEnabledTable16 = printBtnEnabledTable16;
    }

    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable16() {
        return startHourTable16;
    }

    public void setStartHourTable16(int startHour) {
        this.startHourTable16 = startHour;
    }

    public int getStartMinuteTable16() {
        return startMinuteTable16;
    }

    public void setStartMinuteTable16(int startMinute) {
        this.startMinuteTable16 = startMinute;
    }

    public int getStartSecondTable16() {
        return startSecondTable16;
    }

    public void setStartSecondTable16(int startSecond) {
        this.startSecondTable16 = startSecond;
    }

    public int getEndHourTable16() {
        return endHourTable16;
    }

    public void setEndHourTable16(int endHourTable16) {
        this.endHourTable16 = endHourTable16;
    }

    public int getEndMinuteTable16() {
        return endMinuteTable16;
    }

    public void setEndMinuteTable16(int endMinuteTable16) {
        this.endMinuteTable16 = endMinuteTable16;
    }

    public int getEndSecondTable16() {
        return endSecondTable16;
    }

    public void setEndSecondTable16(int endSecondTable16) {
        this.endSecondTable16 = endSecondTable16;
    }

    private boolean addBtnEnableTable16 = false;

    public boolean isAddBtnEnabledTable16() {
        return addBtnEnableTable16;
    }

    public void setAddBtnEnabledTable16(boolean AddBtnEnableTable16) {
        this.addBtnEnableTable16 = AddBtnEnableTable16;
    }

}
