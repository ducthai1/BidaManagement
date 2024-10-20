/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable10 {
    
    private static DataHolderTable10 instanceTable10;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable10;
    private String inputDataENDTable10;
    private String inputDataNameTable10;
    private String inputDataName10;
    
    // Lưu trạng thái tên table
    private String inputColorDataNameTable10;
    private String inputColorDataName10;
    
    // Lưu trạng thái các button
    private boolean startBtnEnabledTable10 = true;
    private boolean stopBtnEnabledTable10;
    private boolean printBtnEnabledTable10;
    
    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable10, startMinuteTable10, startSecondTable10;
    private int endHourTable10, endMinuteTable10, endSecondTable10;

    
    private DataHolderTable10() {
        inputDataSTARTTable10 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable10 = "";
        inputDataNameTable10 = "";
        inputColorDataNameTable10 = "";
        inputDataName10 = "";
        inputColorDataName10 = "";
    }
    
    public static synchronized DataHolderTable10 getInstanceTable10() {
        if (instanceTable10 == null) {
            instanceTable10 = new DataHolderTable10();
        }
        return instanceTable10;
    }

    public String getInputDataSTARTTable10() {
        return inputDataSTARTTable10;
    }

    public void setInputDataSTARTTable10(String inputDataStartTable10) {
        this.inputDataSTARTTable10 = inputDataStartTable10;
    }
    
    public String getInputDataENDTable10() {
        return inputDataENDTable10;
    }

    public void setInputDataENDTable10(String inputDataEndTable10) {
        this.inputDataENDTable10 = inputDataEndTable10;
    }
    
    public String getInputDataNameTable10() {
        return inputDataNameTable10;
    }

    public void setInputDataNameTable10(String inputDatanameTable10) {
        this.inputDataNameTable10 = inputDatanameTable10;
    }
    
    public String getInputColorDataNameTable10() {
        return inputColorDataNameTable10;
    }

    public void setInputColorDataNameTable10(String inputColorDatanameTable10) {
        this.inputColorDataNameTable10 = inputColorDatanameTable10;
    }
    
    public String getInputDataName10() {
        return inputDataNameTable10;
    }

    public void setInputDataName10(String inputDataname10) {
        this.inputDataNameTable10 = inputDataname10;
    }
    
    public String getInputColorDataName10() {
        return inputColorDataNameTable10;
    }

    public void setInputColorDataName10(String inputColorDataname10) {
        this.inputColorDataNameTable10 = inputColorDataname10;
    }
    
    public boolean isStartBtnEnabledTable10() {
        return startBtnEnabledTable10;
    }

    public void setStartBtnEnabledTable10(boolean startBtnEnabledTable10) {
        this.startBtnEnabledTable10 = startBtnEnabledTable10;
    }

    public boolean isStopBtnEnabledTable10() {
        return stopBtnEnabledTable10;
    }

    public void setStopBtnEnabledTable10(boolean stopBtnEnabledTable10) {
        this.stopBtnEnabledTable10 = stopBtnEnabledTable10;
    }

    public boolean isPrintBtnEnabledTable10() {
        return printBtnEnabledTable10;
    }

    public void setPrintBtnEnabledTable10(boolean printBtnEnabledTable10) {
        this.printBtnEnabledTable10 = printBtnEnabledTable10;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable10() {
        return startHourTable10;
    }

    public void setStartHourTable10(int startHour) {
        this.startHourTable10 = startHour;
    }

    public int getStartMinuteTable10() {
        return startMinuteTable10;
    }

    public void setStartMinuteTable10(int startMinute) {
        this.startMinuteTable10 = startMinute;
    }

    public int getStartSecondTable10() {
        return startSecondTable10;
    }

    public void setStartSecondTable10(int startSecond) {
        this.startSecondTable10 = startSecond;
    }

    public int getEndHourTable10() {
        return endHourTable10;
    }

    public void setEndHourTable10(int endHourTable10) {
        this.endHourTable10 = endHourTable10;
    }

    public int getEndMinuteTable10() {
        return endMinuteTable10;
    }

    public void setEndMinuteTable10(int endMinuteTable10) {
        this.endMinuteTable10 = endMinuteTable10;
    }

    public int getEndSecondTable10() {
        return endSecondTable10;
    }

    public void setEndSecondTable10(int endSecondTable10) {
        this.endSecondTable10 = endSecondTable10;
    }
    
    private boolean addBtnEnableTable10 = false;

    public boolean isAddBtnEnabledTable10() {
        return addBtnEnableTable10;
    }

    public void setAddBtnEnabledTable10(boolean AddBtnEnableTable10) {
        this.addBtnEnableTable10 = AddBtnEnableTable10;
    }

}

