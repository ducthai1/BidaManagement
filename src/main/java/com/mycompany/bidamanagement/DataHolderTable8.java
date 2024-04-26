///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.bidamanagement;
//
///**
// *
// * @author duc
// */
//public class DataHolderTable8 {
//    
//    private static DataHolderTable8 instanceTable8;
//    
//    // Luu trang thai cac o du lieu
//    private String inputDataSTARTTable8;
//    private String inputDataENDTable8;
//    private String inputDataNameTable8;
//    
//    // Luu trang thai ten table
//    private String inputColorDataNameTable8;
//    
//    // Luu trang thai cac button
//    private boolean startBtnEnabledTable8 = true;
//    private boolean stopBtnEnabledTable8;
//    private boolean printBtnEnabledTable8;
//    
//    // Luu thoi gian de tinh toan cho ban choi
//    private int startHourTable8, startMinuteTable8, startSecondTable8;
//    private int endHourTable8, endMinuteTable8, endSecondTable8;
//
//    
//    private DataHolderTable8() {
//        inputDataSTARTTable8 = ""; // Khởi tạo inputData ban đầu
//        inputDataENDTable8 = "";
//        inputDataNameTable8 = "";
//        inputColorDataNameTable8 = "";
//    }
//    
//    public static synchronized DataHolderTable8 getInstanceTable8() {
//        if (instanceTable8 == null) {
//            instanceTable8 = new DataHolderTable8();
//        }
//        return instanceTable8;
//    }
//
//    public String getInputDataSTARTTable8() {
//        return inputDataSTARTTable8;
//    }
//
//    public void setInputDataSTARTTable8(String inputDataStartTable8) {
//        this.inputDataSTARTTable8 = inputDataStartTable8;
//    }
//    
//    public String getInputDataENDTable8() {
//        return inputDataENDTable8;
//    }
//
//    public void setInputDataENDTable8(String inputDataEndTable8) {
//        this.inputDataENDTable8 = inputDataEndTable8;
//    }
//    
//    public String getInputDataNameTable8() {
//        return inputDataNameTable8;
//    }
//
//    public void setInputDataNameTable8(String inputDatanameTable8) {
//        this.inputDataNameTable8 = inputDatanameTable8;
//    }
//    
//    public String getInputColorDataNameTable8() {
//        return inputColorDataNameTable8;
//    }
//
//    public void setInputColorDataNameTable8(String inputColorDatanameTable8) {
//        this.inputColorDataNameTable8 = inputColorDatanameTable8;
//    }
//    
//    public boolean isStartBtnEnabledTable8() {
//        return startBtnEnabledTable8;
//    }
//
//    public void setStartBtnEnabledTable8(boolean startBtnEnabledTable8) {
//        this.startBtnEnabledTable8 = startBtnEnabledTable8;
//    }
//
//    public boolean isStopBtnEnabledTable8() {
//        return stopBtnEnabledTable8;
//    }
//
//    public void setStopBtnEnabledTable8(boolean stopBtnEnabledTable8) {
//        this.stopBtnEnabledTable8 = stopBtnEnabledTable8;
//    }
//
//    public boolean isPrintBtnEnabledTable8() {
//        return printBtnEnabledTable8;
//    }
//
//    public void setPrintBtnEnabledTable8(boolean printBtnEnabledTable8) {
//        this.printBtnEnabledTable8 = printBtnEnabledTable8;
//    }
//    
//    // Các phương thức getter và setter cho các biến thời gian
//
//    public int getStartHourTable8() {
//        return startHourTable8;
//    }
//
//    public void setStartHourTable8(int startHour) {
//        this.startHourTable8 = startHour;
//    }
//
//    public int getStartMinuteTable8() {
//        return startMinuteTable8;
//    }
//
//    public void setStartMinuteTable8(int startMinute) {
//        this.startMinuteTable8 = startMinute;
//    }
//
//    public int getStartSecondTable8() {
//        return startSecondTable8;
//    }
//
//    public void setStartSecondTable8(int startSecond) {
//        this.startSecondTable8 = startSecond;
//    }
//
//    public int getEndHourTable8() {
//        return endHourTable8;
//    }
//
//    public void setEndHourTable8(int endHourTable8) {
//        this.endHourTable8 = endHourTable8;
//    }
//
//    public int getEndMinuteTable8() {
//        return endMinuteTable8;
//    }
//
//    public void setEndMinuteTable8(int endMinuteTable8) {
//        this.endMinuteTable8 = endMinuteTable8;
//    }
//
//    public int getEndSecondTable8() {
//        return endSecondTable8;
//    }
//
//    public void setEndSecondTable8(int endSecondTable8) {
//        this.endSecondTable8 = endSecondTable8;
//    }
//}
//
//

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

/**
 *
 * @author duc
 */
public class DataHolderTable8 {
    
    private static DataHolderTable8 instanceTable8;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTARTTable8;
    private String inputDataENDTable8;
    private String inputDataNameTable8;
    private String inputDataName8;
    
    // Luu trang thai ten table
    private String inputColorDataNameTable8;
    private String inputColorDataName8;
    
    // Luu trang thai cac button
    private boolean startBtnEnabledTable8 = true;
    private boolean stopBtnEnabledTable8;
    private boolean printBtnEnabledTable8;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHourTable8, startMinuteTable8, startSecondTable8;
    private int endHourTable8, endMinuteTable8, endSecondTable8;

    
    private DataHolderTable8() {
        inputDataSTARTTable8 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable8 = "";
        inputDataNameTable8 = "";
        inputColorDataNameTable8 = "";
        inputDataName8 = "";
        inputColorDataName8 = "";
    }
    
    public static synchronized DataHolderTable8 getInstanceTable8() {
        if (instanceTable8 == null) {
            instanceTable8 = new DataHolderTable8();
        }
        return instanceTable8;
    }

    public String getInputDataSTARTTable8() {
        return inputDataSTARTTable8;
    }

    public void setInputDataSTARTTable8(String inputDataStartTable8) {
        this.inputDataSTARTTable8 = inputDataStartTable8;
    }
    
    public String getInputDataENDTable8() {
        return inputDataENDTable8;
    }

    public void setInputDataENDTable8(String inputDataEndTable8) {
        this.inputDataENDTable8 = inputDataEndTable8;
    }
    
    public String getInputDataNameTable8() {
        return inputDataNameTable8;
    }

    public void setInputDataNameTable8(String inputDatanameTable8) {
        this.inputDataNameTable8 = inputDatanameTable8;
    }
    
    public String getInputColorDataNameTable8() {
        return inputColorDataNameTable8;
    }

    public void setInputColorDataNameTable8(String inputColorDatanameTable8) {
        this.inputColorDataNameTable8 = inputColorDatanameTable8;
    }
    
    public String getInputDataName8() {
        return inputDataNameTable8;
    }

    public void setInputDataName8(String inputDataname8) {
        this.inputDataNameTable8 = inputDataname8;
    }
    
    public String getInputColorDataName8() {
        return inputColorDataNameTable8;
    }

    public void setInputColorDataName8(String inputColorDataname8) {
        this.inputColorDataNameTable8 = inputColorDataname8;
    }
    
    public boolean isStartBtnEnabledTable8() {
        return startBtnEnabledTable8;
    }

    public void setStartBtnEnabledTable8(boolean startBtnEnabledTable8) {
        this.startBtnEnabledTable8 = startBtnEnabledTable8;
    }

    public boolean isStopBtnEnabledTable8() {
        return stopBtnEnabledTable8;
    }

    public void setStopBtnEnabledTable8(boolean stopBtnEnabledTable8) {
        this.stopBtnEnabledTable8 = stopBtnEnabledTable8;
    }

    public boolean isPrintBtnEnabledTable8() {
        return printBtnEnabledTable8;
    }

    public void setPrintBtnEnabledTable8(boolean printBtnEnabledTable8) {
        this.printBtnEnabledTable8 = printBtnEnabledTable8;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable8() {
        return startHourTable8;
    }

    public void setStartHourTable8(int startHour) {
        this.startHourTable8 = startHour;
    }

    public int getStartMinuteTable8() {
        return startMinuteTable8;
    }

    public void setStartMinuteTable8(int startMinute) {
        this.startMinuteTable8 = startMinute;
    }

    public int getStartSecondTable8() {
        return startSecondTable8;
    }

    public void setStartSecondTable8(int startSecond) {
        this.startSecondTable8 = startSecond;
    }

    public int getEndHourTable8() {
        return endHourTable8;
    }

    public void setEndHourTable8(int endHourTable8) {
        this.endHourTable8 = endHourTable8;
    }

    public int getEndMinuteTable8() {
        return endMinuteTable8;
    }

    public void setEndMinuteTable8(int endMinuteTable8) {
        this.endMinuteTable8 = endMinuteTable8;
    }

    public int getEndSecondTable8() {
        return endSecondTable8;
    }

    public void setEndSecondTable8(int endSecondTable8) {
        this.endSecondTable8 = endSecondTable8;
    }
    
    private boolean addBtnEnableTable8 = false;

    public boolean isAddBtnEnabledTable8() {
        return addBtnEnableTable8;
    }

    public void setAddBtnEnabledTable8(boolean AddBtnEnableTable8) {
        this.addBtnEnableTable8 = AddBtnEnableTable8;
    }

}
