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
//public class DataHolderTable4 {
//    
//    private static DataHolderTable4 instanceTable4;
//    
//    // Luu trang thai cac o du lieu
//    private String inputDataSTARTTable4;
//    private String inputDataENDTable4;
//    private String inputDataNameTable4;
//    
//    // Luu trang thai ten table
//    private String inputColorDataNameTable4;
//    
//    // Luu trang thai cac button
//    private boolean startBtnEnabledTable4 = true;
//    private boolean stopBtnEnabledTable4;
//    private boolean printBtnEnabledTable4;
//    
//    // Luu thoi gian de tinh toan cho ban choi
//    private int startHourTable4, startMinuteTable4, startSecondTable4;
//    private int endHourTable4, endMinuteTable4, endSecondTable4;
//
//    
//    private DataHolderTable4() {
//        inputDataSTARTTable4 = ""; // Khởi tạo inputData ban đầu
//        inputDataENDTable4 = "";
//        inputDataNameTable4 = "";
//        inputColorDataNameTable4 = "";
//    }
//    
//    public static synchronized DataHolderTable4 getInstanceTable4() {
//        if (instanceTable4 == null) {
//            instanceTable4 = new DataHolderTable4();
//        }
//        return instanceTable4;
//    }
//
//    public String getInputDataSTARTTable4() {
//        return inputDataSTARTTable4;
//    }
//
//    public void setInputDataSTARTTable4(String inputDataStartTable4) {
//        this.inputDataSTARTTable4 = inputDataStartTable4;
//    }
//    
//    public String getInputDataENDTable4() {
//        return inputDataENDTable4;
//    }
//
//    public void setInputDataENDTable4(String inputDataEndTable4) {
//        this.inputDataENDTable4 = inputDataEndTable4;
//    }
//    
//    public String getInputDataNameTable4() {
//        return inputDataNameTable4;
//    }
//
//    public void setInputDataNameTable4(String inputDatanameTable4) {
//        this.inputDataNameTable4 = inputDatanameTable4;
//    }
//    
//    public String getInputColorDataNameTable4() {
//        return inputColorDataNameTable4;
//    }
//
//    public void setInputColorDataNameTable4(String inputColorDatanameTable4) {
//        this.inputColorDataNameTable4 = inputColorDatanameTable4;
//    }
//    
//    public boolean isStartBtnEnabledTable4() {
//        return startBtnEnabledTable4;
//    }
//
//    public void setStartBtnEnabledTable4(boolean startBtnEnabledTable4) {
//        this.startBtnEnabledTable4 = startBtnEnabledTable4;
//    }
//
//    public boolean isStopBtnEnabledTable4() {
//        return stopBtnEnabledTable4;
//    }
//
//    public void setStopBtnEnabledTable4(boolean stopBtnEnabledTable4) {
//        this.stopBtnEnabledTable4 = stopBtnEnabledTable4;
//    }
//
//    public boolean isPrintBtnEnabledTable4() {
//        return printBtnEnabledTable4;
//    }
//
//    public void setPrintBtnEnabledTable4(boolean printBtnEnabledTable4) {
//        this.printBtnEnabledTable4 = printBtnEnabledTable4;
//    }
//    
//    // Các phương thức getter và setter cho các biến thời gian
//
//    public int getStartHourTable4() {
//        return startHourTable4;
//    }
//
//    public void setStartHourTable4(int startHour) {
//        this.startHourTable4 = startHour;
//    }
//
//    public int getStartMinuteTable4() {
//        return startMinuteTable4;
//    }
//
//    public void setStartMinuteTable4(int startMinute) {
//        this.startMinuteTable4 = startMinute;
//    }
//
//    public int getStartSecondTable4() {
//        return startSecondTable4;
//    }
//
//    public void setStartSecondTable4(int startSecond) {
//        this.startSecondTable4 = startSecond;
//    }
//
//    public int getEndHourTable4() {
//        return endHourTable4;
//    }
//
//    public void setEndHourTable4(int endHourTable4) {
//        this.endHourTable4 = endHourTable4;
//    }
//
//    public int getEndMinuteTable4() {
//        return endMinuteTable4;
//    }
//
//    public void setEndMinuteTable4(int endMinuteTable4) {
//        this.endMinuteTable4 = endMinuteTable4;
//    }
//
//    public int getEndSecondTable4() {
//        return endSecondTable4;
//    }
//
//    public void setEndSecondTable4(int endSecondTable4) {
//        this.endSecondTable4 = endSecondTable4;
//    }
//}
//
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
public class DataHolderTable4 {
    
    private static DataHolderTable4 instanceTable4;
    
    // Luu trang thai cac o du lieu
    private String inputDataSTARTTable4;
    private String inputDataENDTable4;
    private String inputDataNameTable4;
    private String inputDataName4;
    
    // Luu trang thai ten table
    private String inputColorDataNameTable4;
    private String inputColorDataName4;
    
    // Luu trang thai cac button
    private boolean startBtnEnabledTable4 = true;
    private boolean stopBtnEnabledTable4;
    private boolean printBtnEnabledTable4;
    
    // Luu thoi gian de tinh toan cho ban choi
    private int startHourTable4, startMinuteTable4, startSecondTable4;
    private int endHourTable4, endMinuteTable4, endSecondTable4;

    
    private DataHolderTable4() {
        inputDataSTARTTable4 = ""; // Khởi tạo inputData ban đầu
        inputDataENDTable4 = "";
        inputDataNameTable4 = "";
        inputColorDataNameTable4 = "";
        inputDataName4 = "";
        inputColorDataName4 = "";
    }
    
    public static synchronized DataHolderTable4 getInstanceTable4() {
        if (instanceTable4 == null) {
            instanceTable4 = new DataHolderTable4();
        }
        return instanceTable4;
    }

    public String getInputDataSTARTTable4() {
        return inputDataSTARTTable4;
    }

    public void setInputDataSTARTTable4(String inputDataStartTable4) {
        this.inputDataSTARTTable4 = inputDataStartTable4;
    }
    
    public String getInputDataENDTable4() {
        return inputDataENDTable4;
    }

    public void setInputDataENDTable4(String inputDataEndTable4) {
        this.inputDataENDTable4 = inputDataEndTable4;
    }
    
    public String getInputDataNameTable4() {
        return inputDataNameTable4;
    }

    public void setInputDataNameTable4(String inputDatanameTable4) {
        this.inputDataNameTable4 = inputDatanameTable4;
    }
    
    public String getInputColorDataNameTable4() {
        return inputColorDataNameTable4;
    }

    public void setInputColorDataNameTable4(String inputColorDatanameTable4) {
        this.inputColorDataNameTable4 = inputColorDatanameTable4;
    }
    
    public String getInputDataName4() {
        return inputDataNameTable4;
    }

    public void setInputDataName4(String inputDataname4) {
        this.inputDataNameTable4 = inputDataname4;
    }
    
    public String getInputColorDataName4() {
        return inputColorDataNameTable4;
    }

    public void setInputColorDataName4(String inputColorDataname4) {
        this.inputColorDataNameTable4 = inputColorDataname4;
    }
    
    public boolean isStartBtnEnabledTable4() {
        return startBtnEnabledTable4;
    }

    public void setStartBtnEnabledTable4(boolean startBtnEnabledTable4) {
        this.startBtnEnabledTable4 = startBtnEnabledTable4;
    }

    public boolean isStopBtnEnabledTable4() {
        return stopBtnEnabledTable4;
    }

    public void setStopBtnEnabledTable4(boolean stopBtnEnabledTable4) {
        this.stopBtnEnabledTable4 = stopBtnEnabledTable4;
    }

    public boolean isPrintBtnEnabledTable4() {
        return printBtnEnabledTable4;
    }

    public void setPrintBtnEnabledTable4(boolean printBtnEnabledTable4) {
        this.printBtnEnabledTable4 = printBtnEnabledTable4;
    }
    
    // Các phương thức getter và setter cho các biến thời gian

    public int getStartHourTable4() {
        return startHourTable4;
    }

    public void setStartHourTable4(int startHour) {
        this.startHourTable4 = startHour;
    }

    public int getStartMinuteTable4() {
        return startMinuteTable4;
    }

    public void setStartMinuteTable4(int startMinute) {
        this.startMinuteTable4 = startMinute;
    }

    public int getStartSecondTable4() {
        return startSecondTable4;
    }

    public void setStartSecondTable4(int startSecond) {
        this.startSecondTable4 = startSecond;
    }

    public int getEndHourTable4() {
        return endHourTable4;
    }

    public void setEndHourTable4(int endHourTable4) {
        this.endHourTable4 = endHourTable4;
    }

    public int getEndMinuteTable4() {
        return endMinuteTable4;
    }

    public void setEndMinuteTable4(int endMinuteTable4) {
        this.endMinuteTable4 = endMinuteTable4;
    }

    public int getEndSecondTable4() {
        return endSecondTable4;
    }

    public void setEndSecondTable4(int endSecondTable4) {
        this.endSecondTable4 = endSecondTable4;
    }
    
    private boolean addBtnEnableTable4 = false;

    public boolean isAddBtnEnabledTable4() {
        return addBtnEnableTable4;
    }

    public void setAddBtnEnabledTable4(boolean AddBtnEnableTable4) {
        this.addBtnEnableTable4 = AddBtnEnableTable4;
    }

}

