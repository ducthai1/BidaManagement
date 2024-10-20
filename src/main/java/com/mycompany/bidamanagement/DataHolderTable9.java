/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable9 {
    
    private static DataHolderTable9 instanceTable9;
    
    // Lưu trạng thái các ô dữ liệu
    private String inputDataSTARTTable9;
    private String inputDataENDTable9;
    private String inputDataNameTable9;
    private String inputDataName9;
    
    // Lưu trạng thái tên table
    private String inputColorDataNameTable9;
    private String inputColorDataName9;
    
    // Lưu trạng thái các button
    private boolean startBtnEnabledTable9 = true;
    private boolean stopBtnEnabledTable9;
    private boolean printBtnEnabledTable9;
    
    // Lưu thời gian để tính toán cho bàn chơi
    private int startHourTable9, startMinuteTable9, startSecondTable9;
    private int endHourTable9, endMinuteTable9, endSecondTable9;

    
    private DataHolderTable9() {
        inputDataSTARTTable9 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable9 = "";
        inputDataNameTable9 = "";
        inputColorDataNameTable9 = "";
        inputDataName9 = "";
        inputColorDataName9 = "";
    }
    
    public static synchronized DataHolderTable9 getInstanceTable9() {
        if (instanceTable9 == null) {
            instanceTable9 = new DataHolderTable9();
        }
        return instanceTable9;
    }

    public String getInputDataSTARTTable9() {
        return inputDataSTARTTable9;
    }

    public void setInputDataSTARTTable9(String inputDataStartTable9) {
        this.inputDataSTARTTable9 = inputDataStartTable9;
    }
    
    public String getInputDataENDTable9() {
        return inputDataENDTable9;
    }

    public void setInputDataENDTable9(String inputDataEndTable9) {
        this.inputDataENDTable9 = inputDataEndTable9;
    }
    
    public String getInputDataNameTable9() {
        return inputDataNameTable9;
    }

    public void setInputDataNameTable9(String inputDatanameTable9) {
        this.inputDataNameTable9 = inputDatanameTable9;
    }
    
    public String getInputColorDataNameTable9() {
        return inputColorDataNameTable9;
    }

    public void setInputColorDataNameTable9(String inputColorDatanameTable9) {
        this.inputColorDataNameTable9 = inputColorDatanameTable9;
    }
    
    public String getInputDataName9() {
        return inputDataNameTable9;
    }

    public void setInputDataName9(String inputDataname9) {
        this.inputDataNameTable9 = inputDataname9;
    }
    
    public String getInputColorDataName9() {
        return inputColorDataNameTable9;
    }

    public void setInputColorDataName9(String inputColorDataname9) {
        this.inputColorDataNameTable9 = inputColorDataname9;
    }
    
    public boolean isStartBtnEnabledTable9() {
        return startBtnEnabledTable9;
    }

    public void setStartBtnEnabledTable9(boolean startBtnEnabledTable9) {
        this.startBtnEnabledTable9 = startBtnEnabledTable9;
    }

    public boolean isStopBtnEnabledTable9() {
        return stopBtnEnabledTable9;
    }

    public void setStopBtnEnabledTable9(boolean stopBtnEnabledTable9) {
        this.stopBtnEnabledTable9 = stopBtnEnabledTable9;
    }

    public boolean isPrintBtnEnabledTable9() {
        return printBtnEnabledTable9;
    }

    public void setPrintBtnEnabledTable9(boolean printBtnEnabledTable9) {
        this.printBtnEnabledTable9 = printBtnEnabledTable9;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable9() {
        return startHourTable9;
    }

    public void setStartHourTable9(int startHour) {
        this.startHourTable9 = startHour;
    }

    public int getStartMinuteTable9() {
        return startMinuteTable9;
    }

    public void setStartMinuteTable9(int startMinute) {
        this.startMinuteTable9 = startMinute;
    }

    public int getStartSecondTable9() {
        return startSecondTable9;
    }

    public void setStartSecondTable9(int startSecond) {
        this.startSecondTable9 = startSecond;
    }

    public int getEndHourTable9() {
        return endHourTable9;
    }

    public void setEndHourTable9(int endHourTable9) {
        this.endHourTable9 = endHourTable9;
    }

    public int getEndMinuteTable9() {
        return endMinuteTable9;
    }

    public void setEndMinuteTable9(int endMinuteTable9) {
        this.endMinuteTable9 = endMinuteTable9;
    }

    public int getEndSecondTable9() {
        return endSecondTable9;
    }

    public void setEndSecondTable9(int endSecondTable9) {
        this.endSecondTable9 = endSecondTable9;
    }
    
    private boolean addBtnEnableTable9 = false;

    public boolean isAddBtnEnabledTable9() {
        return addBtnEnableTable9;
    }

    public void setAddBtnEnabledTable9(boolean AddBtnEnableTable9) {
        this.addBtnEnableTable9 = AddBtnEnableTable9;
    }

}

