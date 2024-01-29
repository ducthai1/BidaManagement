/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bidamanagement;

import com.mycompany.bidamanagement.bill.ReportManager;
import com.mycompany.bidamanagement.printModel.ParameterReportCheckout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author duc
 */
public class PlayTable extends javax.swing.JFrame {
    
    Connection conn;
    
    // Xử dụng lớp Singleton để lưu trữ biến inputData Table 1
    private DataHolderTable1 dataHolderTable1 = DataHolderTable1.getInstanceTable1();
    private int startHourTable1, startMinuteTable1, startSecondTable1;
    private int endHourTable1, endMinuteTable1, endSecondTable1;
    
    private DataHolderTable2 dataHolderTable2 = DataHolderTable2.getInstanceTable2();
    private int startHourTable2, startMinuteTable2, startSecondTable2;
    private int endHourTable2, endMinuteTable2, endSecondTable2;
    
    private DataHolderTable3 dataHolderTable3 = DataHolderTable3.getInstanceTable3();
    private int startHourTable3, startMinuteTable3, startSecondTable3;
    private int endHourTable3, endMinuteTable3, endSecondTable3;
    
    private DataHolderTable4 dataHolderTable4 = DataHolderTable4.getInstanceTable4();
    private int startHourTable4, startMinuteTable4, startSecondTable4;
    private int endHourTable4, endMinuteTable4, endSecondTable4;
    
    private DataHolderTable5 dataHolderTable5 = DataHolderTable5.getInstanceTable5();
    private int startHourTable5, startMinuteTable5, startSecondTable5;
    private int endHourTable5, endMinuteTable5, endSecondTable5;
    
    private DataHolderTable6 dataHolderTable6 = DataHolderTable6.getInstanceTable6();
    private int startHourTable6, startMinuteTable6, startSecondTable6;
    private int endHourTable6, endMinuteTable6, endSecondTable6;
    
    private DataHolderTable7 dataHolderTable7 = DataHolderTable7.getInstanceTable7();
    private int startHourTable7, startMinuteTable7, startSecondTable7;
    private int endHourTable7, endMinuteTable7, endSecondTable7;
    
    private DataHolderTable8 dataHolderTable8 = DataHolderTable8.getInstanceTable8();
    private int startHourTable8, startMinuteTable8, startSecondTable8;
    private int endHourTable8, endMinuteTable8, endSecondTable8;

    
    public PlayTable() {
        initComponents();
        

        restoreInputDataTable1();
        restoreInputDataTable2();
        restoreInputDataTable3();
        restoreInputDataTable4();
        restoreInputDataTable5();
        restoreInputDataTable6();
        restoreInputDataTable7();
        restoreInputDataTable8();
        try {
            ReportManager.getInstance().compileReport();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        if ("".equals(NameTable1.getText())) {
            NameTable1.setText("BÀN 1");
        }
        
        if ("".equals(NameTable1.getText())) {
            NameTable1.setText("BÀN 1");
        }

        if ("".equals(NameTable2.getText())) {
            NameTable2.setText("BÀN 2");
        }

        if ("".equals(NameTable3.getText())) {
            NameTable3.setText("BÀN 3");
        }

        if ("".equals(NameTable4.getText())) {
            NameTable4.setText("BÀN 4");
        }

        if ("".equals(NameTable5.getText())) {
            NameTable5.setText("BÀN 5");
        }

        if ("".equals(NameTable6.getText())) {
            NameTable6.setText("BÀN 6");
        }

        if ("".equals(NameTable7.getText())) {
            NameTable7.setText("BÀN 7");
        }

        if ("".equals(NameTable8.getText())) {
            NameTable8.setText("BÀN 8");
        }

        
    }
    
    private String calculateTimePlayTable(int startHour, int startMinute, int startSecond, int endHour, int endMinute, int endSecond) {
        double totalStartSeconds = startHour * 3600 + startMinute * 60 + startSecond;
        double totalEndSeconds = endHour * 3600 + endMinute * 60 + endSecond;

        double totalPlayedSeconds = totalEndSeconds - totalStartSeconds;

        double hourPlay = totalPlayedSeconds / 3600;
        double remainingSeconds = totalPlayedSeconds % 3600;
        double minutePlay = remainingSeconds / 60;
        double secondPlay = remainingSeconds % 60;

        // 1 ban 40k/h tinh theo giay
        double priceInSecond = 40.0 / 3600;
        
        // In ra màn hình kết quả
        System.out.println("Hour Play: " + hourPlay);
        System.out.println("Minute Play: " + minutePlay);
        System.out.println("Second Play: " + secondPlay);
        System.out.println("Total Second Play: " + totalPlayedSeconds);
        
        if(minutePlay < 30) {
            totalPlayedSeconds += 1800;
        }
        
        double tableFee = (double)totalPlayedSeconds * priceInSecond;
        System.out.println("Table Fee: " + CommonFunction.roundDecimal(tableFee, 2));
        return String.valueOf(CommonFunction.roundDecimal(tableFee, 2));
    }
    
    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveInputDataTable1() {
        dataHolderTable1.setInputDataSTARTTable1(TIMESTART1.getText());
        dataHolderTable1.setInputDataENDTable1(TIMEEND1.getText());
        dataHolderTable1.setInputDataNameTable1(NameTable1.getText());
        // Chuyển đổi màu sắc của Table1Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable1.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable1.setInputColorDataNameTable1(colorAsString);
        dataHolderTable1.setStartBtnEnabledTable1(StartBtnTable1.isEnabled());
        dataHolderTable1.setStopBtnEnabledTable1(StopBtnTable1.isEnabled());
        dataHolderTable1.setPrintBtnEnabledTable1(PrintBtnTable1.isEnabled());
        
        dataHolderTable1.setStartHourTable1(startHourTable1);
        dataHolderTable1.setStartMinuteTable1(startMinuteTable1);
        dataHolderTable1.setStartSecondTable1(startSecondTable1);
        dataHolderTable1.setEndHourTable1(endHourTable1);
        dataHolderTable1.setEndMinuteTable1(endMinuteTable1);
        dataHolderTable1.setEndSecondTable1(endSecondTable1);
        
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable1() {
        TIMESTART1.setText(dataHolderTable1.getInputDataSTARTTable1());
        TIMEEND1.setText(dataHolderTable1.getInputDataENDTable1());
        NameTable1.setText(dataHolderTable1.getInputDataNameTable1());
        
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable1.getInputColorDataNameTable1();
        String[] colorComponents1 = colorAsString1.split(",");
        if (colorComponents1.length == 3) {
            int red = Integer.parseInt(colorComponents1[0]);
            int green = Integer.parseInt(colorComponents1[1]);
            int blue = Integer.parseInt(colorComponents1[2]);
            Color color1 = new Color(red, green, blue);
            NameTable1.setForeground(color1);
        }
        StartBtnTable1.setEnabled(dataHolderTable1.isStartBtnEnabledTable1());
        StopBtnTable1.setEnabled(dataHolderTable1.isStopBtnEnabledTable1());
        PrintBtnTable1.setEnabled(dataHolderTable1.isPrintBtnEnabledTable1());
        
        startHourTable1 = dataHolderTable1.getStartHourTable1();
        startMinuteTable1 = dataHolderTable1.getStartMinuteTable1();
        startSecondTable1 = dataHolderTable1.getStartSecondTable1();
        endHourTable1 = dataHolderTable1.getEndHourTable1();
        endMinuteTable1 = dataHolderTable1.getEndMinuteTable1();
        endSecondTable1 = dataHolderTable1.getEndSecondTable1();
        
    }
    
    
    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveInputDataTable2() {
        dataHolderTable2.setInputDataSTARTTable2(TIMESTART2.getText());
        dataHolderTable2.setInputDataENDTable2(TIMEEND2.getText());
        dataHolderTable2.setInputDataNameTable2(NameTable2.getText());
        // Chuyển đổi màu sắc của Table2Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable2.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable2.setInputColorDataNameTable2(colorAsString);
        dataHolderTable2.setStartBtnEnabledTable2(StartBtnTable2.isEnabled());
        dataHolderTable2.setStopBtnEnabledTable2(StopBtnTable2.isEnabled());
        dataHolderTable2.setPrintBtnEnabledTable2(PrintBtnTable2.isEnabled());

        dataHolderTable2.setStartHourTable2(startHourTable2);
        dataHolderTable2.setStartMinuteTable2(startMinuteTable2);
        dataHolderTable2.setStartSecondTable2(startSecondTable2);
        dataHolderTable2.setEndHourTable2(endHourTable2);
        dataHolderTable2.setEndMinuteTable2(endMinuteTable2);
        dataHolderTable2.setEndSecondTable2(endSecondTable2);
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable2() {
        TIMESTART2.setText(dataHolderTable2.getInputDataSTARTTable2());
        TIMEEND2.setText(dataHolderTable2.getInputDataENDTable2());
        NameTable2.setText(dataHolderTable2.getInputDataNameTable2());

        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString = dataHolderTable2.getInputColorDataNameTable2();
        String[] colorComponents = colorAsString.split(",");
        if (colorComponents.length == 3) {
            int red = Integer.parseInt(colorComponents[0]);
            int green = Integer.parseInt(colorComponents[1]);
            int blue = Integer.parseInt(colorComponents[2]);
            Color color = new Color(red, green, blue);
            NameTable2.setForeground(color);
        }
        StartBtnTable2.setEnabled(dataHolderTable2.isStartBtnEnabledTable2());
        StopBtnTable2.setEnabled(dataHolderTable2.isStopBtnEnabledTable2());
        PrintBtnTable2.setEnabled(dataHolderTable2.isPrintBtnEnabledTable2());

        startHourTable2 = dataHolderTable2.getStartHourTable2();
        startMinuteTable2 = dataHolderTable2.getStartMinuteTable2();
        startSecondTable2 = dataHolderTable2.getStartSecondTable2();
        endHourTable2 = dataHolderTable2.getEndHourTable2();
        endMinuteTable2 = dataHolderTable2.getEndMinuteTable2();
        endSecondTable2 = dataHolderTable2.getEndSecondTable2();
    }

    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveInputDataTable3() {
        dataHolderTable3.setInputDataSTARTTable3(TIMESTART3.getText());
        dataHolderTable3.setInputDataENDTable3(TIMEEND3.getText());
        dataHolderTable3.setInputDataNameTable3(NameTable3.getText());
        // Chuyển đổi màu sắc của Table3Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable3.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable3.setInputColorDataNameTable3(colorAsString);
        dataHolderTable3.setStartBtnEnabledTable3(StartBtnTable3.isEnabled());
        dataHolderTable3.setStopBtnEnabledTable3(StopBtnTable3.isEnabled());
        dataHolderTable3.setPrintBtnEnabledTable3(PrintBtnTable3.isEnabled());

        dataHolderTable3.setStartHourTable3(startHourTable3);
        dataHolderTable3.setStartMinuteTable3(startMinuteTable3);
        dataHolderTable3.setStartSecondTable3(startSecondTable3);
        dataHolderTable3.setEndHourTable3(endHourTable3);
        dataHolderTable3.setEndMinuteTable3(endMinuteTable3);
        dataHolderTable3.setEndSecondTable3(endSecondTable3);
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable3() {
        TIMESTART3.setText(dataHolderTable3.getInputDataSTARTTable3());
        TIMEEND3.setText(dataHolderTable3.getInputDataENDTable3());
        NameTable3.setText(dataHolderTable3.getInputDataNameTable3());

        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString = dataHolderTable3.getInputColorDataNameTable3();
        String[] colorComponents = colorAsString.split(",");
        if (colorComponents.length == 3) {
            int red = Integer.parseInt(colorComponents[0]);
            int green = Integer.parseInt(colorComponents[1]);
            int blue = Integer.parseInt(colorComponents[2]);
            Color color = new Color(red, green, blue);
            NameTable3.setForeground(color);
        }
        StartBtnTable3.setEnabled(dataHolderTable3.isStartBtnEnabledTable3());
        StopBtnTable3.setEnabled(dataHolderTable3.isStopBtnEnabledTable3());
        PrintBtnTable3.setEnabled(dataHolderTable3.isPrintBtnEnabledTable3());

        startHourTable3 = dataHolderTable3.getStartHourTable3();
        startMinuteTable3 = dataHolderTable3.getStartMinuteTable3();
        startSecondTable3 = dataHolderTable3.getStartSecondTable3();
        endHourTable3 = dataHolderTable3.getEndHourTable3();
        endMinuteTable3 = dataHolderTable3.getEndMinuteTable3();
        endSecondTable3 = dataHolderTable3.getEndSecondTable3();
    }


    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveInputDataTable4() {
        dataHolderTable4.setInputDataSTARTTable4(TIMESTART4.getText());
        dataHolderTable4.setInputDataENDTable4(TIMEEND4.getText());
        dataHolderTable4.setInputDataNameTable4(NameTable4.getText());
        // Chuyển đổi màu sắc của Table4Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable4.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable4.setInputColorDataNameTable4(colorAsString);
        dataHolderTable4.setStartBtnEnabledTable4(StartBtnTable4.isEnabled());
        dataHolderTable4.setStopBtnEnabledTable4(StopBtnTable4.isEnabled());
        dataHolderTable4.setPrintBtnEnabledTable4(PrintBtnTable4.isEnabled());

        dataHolderTable4.setStartHourTable4(startHourTable4);
        dataHolderTable4.setStartMinuteTable4(startMinuteTable4);
        dataHolderTable4.setStartSecondTable4(startSecondTable4);
        dataHolderTable4.setEndHourTable4(endHourTable4);
        dataHolderTable4.setEndMinuteTable4(endMinuteTable4);
        dataHolderTable4.setEndSecondTable4(endSecondTable4);
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable4() {
        TIMESTART4.setText(dataHolderTable4.getInputDataSTARTTable4());
        TIMEEND4.setText(dataHolderTable4.getInputDataENDTable4());
        NameTable4.setText(dataHolderTable4.getInputDataNameTable4());

        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString = dataHolderTable4.getInputColorDataNameTable4();
        String[] colorComponents = colorAsString.split(",");
        if (colorComponents.length == 3) {
            int red = Integer.parseInt(colorComponents[0]);
            int green = Integer.parseInt(colorComponents[1]);
            int blue = Integer.parseInt(colorComponents[2]);
            Color color = new Color(red, green, blue);
            NameTable4.setForeground(color);
        }
        StartBtnTable4.setEnabled(dataHolderTable4.isStartBtnEnabledTable4());
        StopBtnTable4.setEnabled(dataHolderTable4.isStopBtnEnabledTable4());
        PrintBtnTable4.setEnabled(dataHolderTable4.isPrintBtnEnabledTable4());

        startHourTable4 = dataHolderTable4.getStartHourTable4();
        startMinuteTable4 = dataHolderTable4.getStartMinuteTable4();
        startSecondTable4 = dataHolderTable4.getStartSecondTable4();
        endHourTable4 = dataHolderTable4.getEndHourTable4();
        endMinuteTable4 = dataHolderTable4.getEndMinuteTable4();
        endSecondTable4 = dataHolderTable4.getEndSecondTable4();
    }


    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveInputDataTable5() {
        dataHolderTable5.setInputDataSTARTTable5(TIMESTART5.getText());
        dataHolderTable5.setInputDataENDTable5(TIMEEND5.getText());
        dataHolderTable5.setInputDataNameTable5(NameTable5.getText());
        // Chuyển đổi màu sắc của Table5Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable5.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable5.setInputColorDataNameTable5(colorAsString);
        dataHolderTable5.setStartBtnEnabledTable5(StartBtnTable5.isEnabled());
        dataHolderTable5.setStopBtnEnabledTable5(StopBtnTable5.isEnabled());
        dataHolderTable5.setPrintBtnEnabledTable5(PrintBtnTable5.isEnabled());

        dataHolderTable5.setStartHourTable5(startHourTable5);
        dataHolderTable5.setStartMinuteTable5(startMinuteTable5);
        dataHolderTable5.setStartSecondTable5(startSecondTable5);
        dataHolderTable5.setEndHourTable5(endHourTable5);
        dataHolderTable5.setEndMinuteTable5(endMinuteTable5);
        dataHolderTable5.setEndSecondTable5(endSecondTable5);
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable5() {
        TIMESTART5.setText(dataHolderTable5.getInputDataSTARTTable5());
        TIMEEND5.setText(dataHolderTable5.getInputDataENDTable5());
        NameTable5.setText(dataHolderTable5.getInputDataNameTable5());

        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString = dataHolderTable5.getInputColorDataNameTable5();
        String[] colorComponents = colorAsString.split(",");
        if (colorComponents.length == 3) {
            int red = Integer.parseInt(colorComponents[0]);
            int green = Integer.parseInt(colorComponents[1]);
            int blue = Integer.parseInt(colorComponents[2]);
            Color color = new Color(red, green, blue);
            NameTable5.setForeground(color);
        }
        StartBtnTable5.setEnabled(dataHolderTable5.isStartBtnEnabledTable5());
        StopBtnTable5.setEnabled(dataHolderTable5.isStopBtnEnabledTable5());
        PrintBtnTable5.setEnabled(dataHolderTable5.isPrintBtnEnabledTable5());

        startHourTable5 = dataHolderTable5.getStartHourTable5();
        startMinuteTable5 = dataHolderTable5.getStartMinuteTable5();
        startSecondTable5 = dataHolderTable5.getStartSecondTable5();
        endHourTable5 = dataHolderTable5.getEndHourTable5();
        endMinuteTable5 = dataHolderTable5.getEndMinuteTable5();
        endSecondTable5 = dataHolderTable5.getEndSecondTable5();
    }


    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveInputDataTable6() {
        dataHolderTable6.setInputDataSTARTTable6(TIMESTART6.getText());
        dataHolderTable6.setInputDataENDTable6(TIMEEND6.getText());
        dataHolderTable6.setInputDataNameTable6(NameTable6.getText());
        // Chuyển đổi màu sắc của Table6Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable6.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable6.setInputColorDataNameTable6(colorAsString);
        dataHolderTable6.setStartBtnEnabledTable6(StartBtnTable6.isEnabled());
        dataHolderTable6.setStopBtnEnabledTable6(StopBtnTable6.isEnabled());
        dataHolderTable6.setPrintBtnEnabledTable6(PrintBtnTable6.isEnabled());

        dataHolderTable6.setStartHourTable6(startHourTable6);
        dataHolderTable6.setStartMinuteTable6(startMinuteTable6);
        dataHolderTable6.setStartSecondTable6(startSecondTable6);
        dataHolderTable6.setEndHourTable6(endHourTable6);
        dataHolderTable6.setEndMinuteTable6(endMinuteTable6);
        dataHolderTable6.setEndSecondTable6(endSecondTable6);
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable6() {
        TIMESTART6.setText(dataHolderTable6.getInputDataSTARTTable6());
        TIMEEND6.setText(dataHolderTable6.getInputDataENDTable6());
        NameTable6.setText(dataHolderTable6.getInputDataNameTable6());

        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString = dataHolderTable6.getInputColorDataNameTable6();
        String[] colorComponents = colorAsString.split(",");
        if (colorComponents.length == 3) {
            int red = Integer.parseInt(colorComponents[0]);
            int green = Integer.parseInt(colorComponents[1]);
            int blue = Integer.parseInt(colorComponents[2]);
            Color color = new Color(red, green, blue);
            NameTable6.setForeground(color);
        }
        StartBtnTable6.setEnabled(dataHolderTable6.isStartBtnEnabledTable6());
        StopBtnTable6.setEnabled(dataHolderTable6.isStopBtnEnabledTable6());
        PrintBtnTable6.setEnabled(dataHolderTable6.isPrintBtnEnabledTable6());

        startHourTable6 = dataHolderTable6.getStartHourTable6();
        startMinuteTable6 = dataHolderTable6.getStartMinuteTable6();
        startSecondTable6 = dataHolderTable6.getStartSecondTable6();
        endHourTable6 = dataHolderTable6.getEndHourTable6();
        endMinuteTable6 = dataHolderTable6.getEndMinuteTable6();
        endSecondTable6 = dataHolderTable6.getEndSecondTable6();
    }


    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveInputDataTable7() {
        dataHolderTable7.setInputDataSTARTTable7(TIMESTART7.getText());
        dataHolderTable7.setInputDataENDTable7(TIMEEND7.getText());
        dataHolderTable7.setInputDataNameTable7(NameTable7.getText());
        // Chuyển đổi màu sắc của Table7Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable7.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable7.setInputColorDataNameTable7(colorAsString);
        dataHolderTable7.setStartBtnEnabledTable7(StartBtnTable7.isEnabled());
        dataHolderTable7.setStopBtnEnabledTable7(StopBtnTable7.isEnabled());
        dataHolderTable7.setPrintBtnEnabledTable7(PrintBtnTable7.isEnabled());

        dataHolderTable7.setStartHourTable7(startHourTable7);
        dataHolderTable7.setStartMinuteTable7(startMinuteTable7);
        dataHolderTable7.setStartSecondTable7(startSecondTable7);
        dataHolderTable7.setEndHourTable7(endHourTable7);
        dataHolderTable7.setEndMinuteTable7(endMinuteTable7);
        dataHolderTable7.setEndSecondTable7(endSecondTable7);
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable7() {
        TIMESTART7.setText(dataHolderTable7.getInputDataSTARTTable7());
        TIMEEND7.setText(dataHolderTable7.getInputDataENDTable7());
        NameTable7.setText(dataHolderTable7.getInputDataNameTable7());

        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString = dataHolderTable7.getInputColorDataNameTable7();
        String[] colorComponents = colorAsString.split(",");
        if (colorComponents.length == 3) {
            int red = Integer.parseInt(colorComponents[0]);
            int green = Integer.parseInt(colorComponents[1]);
            int blue = Integer.parseInt(colorComponents[2]);
            Color color = new Color(red, green, blue);
            NameTable7.setForeground(color);
        }
        StartBtnTable7.setEnabled(dataHolderTable7.isStartBtnEnabledTable7());
        StopBtnTable7.setEnabled(dataHolderTable7.isStopBtnEnabledTable7());
        PrintBtnTable7.setEnabled(dataHolderTable7.isPrintBtnEnabledTable7());

        startHourTable7 = dataHolderTable7.getStartHourTable7();
        startMinuteTable7 = dataHolderTable7.getStartMinuteTable7();
        startSecondTable7 = dataHolderTable7.getStartSecondTable7();
        endHourTable7 = dataHolderTable7.getEndHourTable7();
        endMinuteTable7 = dataHolderTable7.getEndMinuteTable7();
        endSecondTable7 = dataHolderTable7.getEndSecondTable7();
    }


    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveInputDataTable8() {
        dataHolderTable8.setInputDataSTARTTable8(TIMESTART8.getText());
        dataHolderTable8.setInputDataENDTable8(TIMEEND8.getText());
        dataHolderTable8.setInputDataNameTable8(NameTable8.getText());
        // Chuyển đổi màu sắc của Table8Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable8.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable8.setInputColorDataNameTable8(colorAsString);
        dataHolderTable8.setStartBtnEnabledTable8(StartBtnTable8.isEnabled());
        dataHolderTable8.setStopBtnEnabledTable8(StopBtnTable8.isEnabled());
        dataHolderTable8.setPrintBtnEnabledTable8(PrintBtnTable8.isEnabled());

        dataHolderTable8.setStartHourTable8(startHourTable8);
        dataHolderTable8.setStartMinuteTable8(startMinuteTable8);
        dataHolderTable8.setStartSecondTable8(startSecondTable8);
        dataHolderTable8.setEndHourTable8(endHourTable8);
        dataHolderTable8.setEndMinuteTable8(endMinuteTable8);
        dataHolderTable8.setEndSecondTable8(endSecondTable8);
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable8() {
        TIMESTART8.setText(dataHolderTable8.getInputDataSTARTTable8());
        TIMEEND8.setText(dataHolderTable8.getInputDataENDTable8());
        NameTable8.setText(dataHolderTable8.getInputDataNameTable8());

        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString = dataHolderTable8.getInputColorDataNameTable8();
        String[] colorComponents = colorAsString.split(",");
        if (colorComponents.length == 3) {
            int red = Integer.parseInt(colorComponents[0]);
            int green = Integer.parseInt(colorComponents[1]);
            int blue = Integer.parseInt(colorComponents[2]);
            Color color = new Color(red, green, blue);
            NameTable8.setForeground(color);
        }
        StartBtnTable8.setEnabled(dataHolderTable8.isStartBtnEnabledTable8());
        StopBtnTable8.setEnabled(dataHolderTable8.isStopBtnEnabledTable8());
        PrintBtnTable8.setEnabled(dataHolderTable8.isPrintBtnEnabledTable8());

        startHourTable8 = dataHolderTable8.getStartHourTable8();
        startMinuteTable8 = dataHolderTable8.getStartMinuteTable8();
        startSecondTable8 = dataHolderTable8.getStartSecondTable8();
        endHourTable8 = dataHolderTable8.getEndHourTable8();
        endMinuteTable8 = dataHolderTable8.getEndMinuteTable8();
        endSecondTable8 = dataHolderTable8.getEndSecondTable8();
    }


    public void printBill(String current, String timestart, String timeend, String tableFee) {
        try {     
//            Hashtable map = new Hashtable();
//            JasperReport playTableBill = JasperCompileManager.compileReport("src/main/java/com/mycompany/bidamanagement/bill/tableBill.jrxml");
//            map.put("logo", new FileInputStream("src/main/java/com/mycompany/bidamanagement/Icon/logoBida120.jpg"));
//            map.put("DATE", current);
//            map.put("STARTTIME", timestart);
//            map.put("ENDTIME", timeend);
//            map.put("TABLE_FEE", tableFee);
//            
//            System.out.println( "start" +timestart + "end" + timeend +"Fee"+ tableFee);
//            
//            JasperPrint print = JasperFillManager.fillReport(playTableBill, map); 
//            JasperViewer.viewReport(print, false);
            
//          if (print.getPages().isEmpty()) {
//            System.out.println("Báo cáo không có trang nào được tạo.");
//        } else {
//            JasperViewer.viewReport(print, false);
//        }
//    } catch (JRException e) {
//        System.out.println("Lỗi khi tạo hoặc hiển thị báo cáo: " + e.getMessage());
//    } catch (FileNotFoundException e) {
//        System.out.println("Không tìm thấy file logo: " + e.getMessage());
//    } finally {
//        // Đóng InputStream sau khi sử dụng
//        if (logoInputStream != null) {
//            try {
//                logoInputStream.close();
//            } catch (IOException e) {
//                System.out.println("Lỗi khi đóng InputStream: " + e.getMessage());
//            }
//        }
    }
        
    catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        table1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        NameTable1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SDTKH1 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TIMESTART1 = new javax.swing.JTextField();
        jPanel67 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        TIMEEND1 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        StartBtnTable1 = new javax.swing.JButton();
        StopBtnTable1 = new javax.swing.JButton();
        PrintBtnTable1 = new javax.swing.JButton();
        ResetBtnTable1 = new javax.swing.JButton();
        table6 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        NameTable6 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jPanel96 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        SDTKH6 = new javax.swing.JTextField();
        jPanel97 = new javax.swing.JPanel();
        jPanel98 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        TIMESTART6 = new javax.swing.JTextField();
        jPanel99 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        TIMEEND6 = new javax.swing.JTextField();
        jPanel100 = new javax.swing.JPanel();
        StartBtnTable6 = new javax.swing.JButton();
        StopBtnTable6 = new javax.swing.JButton();
        PrintBtnTable6 = new javax.swing.JButton();
        ResetBtnTable6 = new javax.swing.JButton();
        table5 = new javax.swing.JPanel();
        jPanel87 = new javax.swing.JPanel();
        NameTable5 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        SDTKH5 = new javax.swing.JTextField();
        jPanel90 = new javax.swing.JPanel();
        jPanel91 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        TIMESTART5 = new javax.swing.JTextField();
        jPanel92 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        TIMEEND5 = new javax.swing.JTextField();
        jPanel93 = new javax.swing.JPanel();
        StartBtnTable5 = new javax.swing.JButton();
        StopBtnTable5 = new javax.swing.JButton();
        PrintBtnTable5 = new javax.swing.JButton();
        ResetBtnTable5 = new javax.swing.JButton();
        table3 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        NameTable3 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        SDTKH3 = new javax.swing.JTextField();
        jPanel76 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        TIMESTART3 = new javax.swing.JTextField();
        jPanel78 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        TIMEEND3 = new javax.swing.JTextField();
        jPanel79 = new javax.swing.JPanel();
        StartBtnTable3 = new javax.swing.JButton();
        StopBtnTable3 = new javax.swing.JButton();
        PrintBtnTable3 = new javax.swing.JButton();
        ResetBtnTable3 = new javax.swing.JButton();
        table2 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        NameTable2 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        SDTKH2 = new javax.swing.JTextField();
        jPanel69 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        TIMESTART2 = new javax.swing.JTextField();
        jPanel71 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        TIMEEND2 = new javax.swing.JTextField();
        jPanel72 = new javax.swing.JPanel();
        StartBtnTable2 = new javax.swing.JButton();
        StopBtnTable2 = new javax.swing.JButton();
        PrintBtnTable2 = new javax.swing.JButton();
        ResetBtnTable2 = new javax.swing.JButton();
        table7 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        NameTable7 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jPanel103 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        SDTKH7 = new javax.swing.JTextField();
        jPanel104 = new javax.swing.JPanel();
        jPanel105 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        TIMESTART7 = new javax.swing.JTextField();
        jPanel106 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        TIMEEND7 = new javax.swing.JTextField();
        jPanel107 = new javax.swing.JPanel();
        StartBtnTable7 = new javax.swing.JButton();
        StopBtnTable7 = new javax.swing.JButton();
        PrintBtnTable7 = new javax.swing.JButton();
        ResetBtnTable7 = new javax.swing.JButton();
        table4 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        NameTable4 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        SDTKH4 = new javax.swing.JTextField();
        jPanel83 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        TIMESTART4 = new javax.swing.JTextField();
        jPanel85 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        TIMEEND4 = new javax.swing.JTextField();
        jPanel86 = new javax.swing.JPanel();
        StartBtnTable4 = new javax.swing.JButton();
        StopBtnTable4 = new javax.swing.JButton();
        PrintBtnTable4 = new javax.swing.JButton();
        ResetBtnTable4 = new javax.swing.JButton();
        table8 = new javax.swing.JPanel();
        jPanel108 = new javax.swing.JPanel();
        NameTable8 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        SDTKH8 = new javax.swing.JTextField();
        jPanel111 = new javax.swing.JPanel();
        jPanel112 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        TIMESTART8 = new javax.swing.JTextField();
        jPanel113 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        TIMEEND8 = new javax.swing.JTextField();
        jPanel114 = new javax.swing.JPanel();
        StartBtnTable8 = new javax.swing.JButton();
        StopBtnTable8 = new javax.swing.JButton();
        PrintBtnTable8 = new javax.swing.JButton();
        ResetBtnTable8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LogoutBtn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PlayTableBtn = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        CheckOutBtn = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(true);
        setSize(new java.awt.Dimension(1405, 738));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(110, 178, 246));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(110, 178, 246));
        jLabel10.setText("QUẢN LÝ BÀN CHƠI");

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(110, 178, 246));
        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBtn.setText("X");
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(jLabel10)
                .addGap(429, 429, 429)
                .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        table1.setBackground(new java.awt.Color(102, 204, 0));
        table1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));

        NameTable1.setBackground(new java.awt.Color(249, 249, 249));
        NameTable1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable1.setText("BÀN 1");
        NameTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SĐT KH");

        SDTKH1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel15.setBackground(new java.awt.Color(102, 204, 0));

        jPanel19.setBackground(new java.awt.Color(102, 204, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GIỜ CHƠI");

        TIMESTART1.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART1.setEnabled(false);
        TIMESTART1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART1)
                .addContainerGap())
        );

        jPanel67.setBackground(new java.awt.Color(102, 204, 0));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("GIỜ NGHỈ");

        TIMEEND1.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND1.setEnabled(false);
        TIMEEND1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        StartBtnTable1.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable1.setText("BẮT ĐẦU");
        StartBtnTable1.setBorder(null);
        StartBtnTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable1MouseClicked(evt);
            }
        });
        StartBtnTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable1ActionPerformed(evt);
            }
        });

        StopBtnTable1.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable1.setText("DỪNG LẠI");
        StopBtnTable1.setBorder(null);
        StopBtnTable1.setEnabled(false);
        StopBtnTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable1ActionPerformed(evt);
            }
        });

        PrintBtnTable1.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable1.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable1.setText("IN HÓA ĐƠN");
        PrintBtnTable1.setBorder(null);
        PrintBtnTable1.setEnabled(false);
        PrintBtnTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable1ActionPerformed(evt);
            }
        });

        ResetBtnTable1.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable1.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable1.setText("RESET");
        ResetBtnTable1.setBorder(null);
        ResetBtnTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartBtnTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtnTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table1Layout = new javax.swing.GroupLayout(table1);
        table1.setLayout(table1Layout);
        table1Layout.setHorizontalGroup(
            table1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table1Layout.setVerticalGroup(
            table1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table6.setBackground(new java.awt.Color(102, 204, 0));
        table6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel94.setBackground(new java.awt.Color(204, 204, 204));

        NameTable6.setBackground(new java.awt.Color(249, 249, 249));
        NameTable6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable6.setText("BÀN 6");
        NameTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel96.setBackground(new java.awt.Color(255, 255, 255));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("SĐT KH");

        SDTKH6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel95Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel97.setBackground(new java.awt.Color(102, 204, 0));

        jPanel98.setBackground(new java.awt.Color(102, 204, 0));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("GIỜ CHƠI");

        TIMESTART6.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART6.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART6.setEnabled(false);
        TIMESTART6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART6)
                .addContainerGap())
        );

        jPanel99.setBackground(new java.awt.Color(102, 204, 0));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("GIỜ NGHỈ");

        TIMEEND6.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND6.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND6.setEnabled(false);
        TIMEEND6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addComponent(jPanel98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel100.setBackground(new java.awt.Color(255, 255, 255));

        StartBtnTable6.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable6.setText("BẮT ĐẦU");
        StartBtnTable6.setBorder(null);
        StartBtnTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable6MouseClicked(evt);
            }
        });
        StartBtnTable6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable6ActionPerformed(evt);
            }
        });

        StopBtnTable6.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable6.setText("DỪNG LẠI");
        StopBtnTable6.setBorder(null);
        StopBtnTable6.setEnabled(false);
        StopBtnTable6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable6ActionPerformed(evt);
            }
        });

        PrintBtnTable6.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable6.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable6.setText("IN HÓA ĐƠN");
        PrintBtnTable6.setBorder(null);
        PrintBtnTable6.setEnabled(false);
        PrintBtnTable6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable6ActionPerformed(evt);
            }
        });

        ResetBtnTable6.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable6.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable6.setText("RESET");
        ResetBtnTable6.setBorder(null);
        ResetBtnTable6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartBtnTable6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtnTable6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable6, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable6, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table6Layout = new javax.swing.GroupLayout(table6);
        table6.setLayout(table6Layout);
        table6Layout.setHorizontalGroup(
            table6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel95, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table6Layout.setVerticalGroup(
            table6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table6Layout.createSequentialGroup()
                .addComponent(jPanel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table5.setBackground(new java.awt.Color(102, 204, 0));
        table5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel87.setBackground(new java.awt.Color(204, 204, 204));

        NameTable5.setBackground(new java.awt.Color(249, 249, 249));
        NameTable5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable5.setText("BÀN 5");
        NameTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("SĐT KH");

        SDTKH5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel88Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel90.setBackground(new java.awt.Color(102, 204, 0));

        jPanel91.setBackground(new java.awt.Color(102, 204, 0));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("GIỜ CHƠI");

        TIMESTART5.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART5.setEnabled(false);
        TIMESTART5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART5)
                .addContainerGap())
        );

        jPanel92.setBackground(new java.awt.Color(102, 204, 0));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("GIỜ NGHỈ");

        TIMEEND5.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND5.setEnabled(false);
        TIMEEND5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addComponent(jPanel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));

        StartBtnTable5.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable5.setText("BẮT ĐẦU");
        StartBtnTable5.setBorder(null);
        StartBtnTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable5MouseClicked(evt);
            }
        });
        StartBtnTable5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable5ActionPerformed(evt);
            }
        });

        StopBtnTable5.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable5.setText("DỪNG LẠI");
        StopBtnTable5.setBorder(null);
        StopBtnTable5.setEnabled(false);
        StopBtnTable5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable5ActionPerformed(evt);
            }
        });

        PrintBtnTable5.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable5.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable5.setText("IN HÓA ĐƠN");
        PrintBtnTable5.setBorder(null);
        PrintBtnTable5.setEnabled(false);
        PrintBtnTable5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable5ActionPerformed(evt);
            }
        });

        ResetBtnTable5.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable5.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable5.setText("RESET");
        ResetBtnTable5.setBorder(null);
        ResetBtnTable5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartBtnTable5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtnTable5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table5Layout = new javax.swing.GroupLayout(table5);
        table5.setLayout(table5Layout);
        table5Layout.setHorizontalGroup(
            table5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table5Layout.setVerticalGroup(
            table5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table5Layout.createSequentialGroup()
                .addComponent(jPanel87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table3.setBackground(new java.awt.Color(102, 204, 0));
        table3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel73.setBackground(new java.awt.Color(204, 204, 204));

        NameTable3.setBackground(new java.awt.Color(249, 249, 249));
        NameTable3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable3.setText("BÀN 3");
        NameTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("SĐT KH");

        SDTKH3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel76.setBackground(new java.awt.Color(102, 204, 0));

        jPanel77.setBackground(new java.awt.Color(102, 204, 0));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("GIỜ CHƠI");

        TIMESTART3.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART3.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART3.setEnabled(false);
        TIMESTART3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART3)
                .addContainerGap())
        );

        jPanel78.setBackground(new java.awt.Color(102, 204, 0));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("GIỜ NGHỈ");

        TIMEEND3.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND3.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND3.setEnabled(false);
        TIMEEND3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));

        StartBtnTable3.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable3.setText("BẮT ĐẦU");
        StartBtnTable3.setBorder(null);
        StartBtnTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable3MouseClicked(evt);
            }
        });
        StartBtnTable3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable3ActionPerformed(evt);
            }
        });

        StopBtnTable3.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable3.setText("DỪNG LẠI");
        StopBtnTable3.setBorder(null);
        StopBtnTable3.setEnabled(false);
        StopBtnTable3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable3ActionPerformed(evt);
            }
        });

        PrintBtnTable3.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable3.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable3.setText("IN HÓA ĐƠN");
        PrintBtnTable3.setBorder(null);
        PrintBtnTable3.setEnabled(false);
        PrintBtnTable3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable3ActionPerformed(evt);
            }
        });

        ResetBtnTable3.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable3.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable3.setText("RESET");
        ResetBtnTable3.setBorder(null);
        ResetBtnTable3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartBtnTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtnTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table3Layout = new javax.swing.GroupLayout(table3);
        table3.setLayout(table3Layout);
        table3Layout.setHorizontalGroup(
            table3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel74, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table3Layout.setVerticalGroup(
            table3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table3Layout.createSequentialGroup()
                .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table2.setBackground(new java.awt.Color(102, 204, 0));
        table2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel63.setBackground(new java.awt.Color(204, 204, 204));

        NameTable2.setBackground(new java.awt.Color(249, 249, 249));
        NameTable2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable2.setText("BÀN 2");
        NameTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("SĐT KH");

        SDTKH2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel69.setBackground(new java.awt.Color(102, 204, 0));

        jPanel70.setBackground(new java.awt.Color(102, 204, 0));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("GIỜ CHƠI");

        TIMESTART2.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART2.setEnabled(false);
        TIMESTART2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART2)
                .addContainerGap())
        );

        jPanel71.setBackground(new java.awt.Color(102, 204, 0));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("GIỜ NGHỈ");

        TIMEEND2.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND2.setEnabled(false);
        TIMEEND2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));

        StartBtnTable2.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable2.setText("BẮT ĐẦU");
        StartBtnTable2.setBorder(null);
        StartBtnTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable2MouseClicked(evt);
            }
        });
        StartBtnTable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable2ActionPerformed(evt);
            }
        });

        StopBtnTable2.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable2.setText("DỪNG LẠI");
        StopBtnTable2.setBorder(null);
        StopBtnTable2.setEnabled(false);
        StopBtnTable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable2ActionPerformed(evt);
            }
        });

        PrintBtnTable2.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable2.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable2.setText("IN HÓA ĐƠN");
        PrintBtnTable2.setBorder(null);
        PrintBtnTable2.setEnabled(false);
        PrintBtnTable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable2ActionPerformed(evt);
            }
        });

        ResetBtnTable2.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable2.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable2.setText("RESET");
        ResetBtnTable2.setBorder(null);
        ResetBtnTable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartBtnTable2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtnTable2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table2Layout = new javax.swing.GroupLayout(table2);
        table2.setLayout(table2Layout);
        table2Layout.setHorizontalGroup(
            table2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table2Layout.setVerticalGroup(
            table2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table2Layout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table7.setBackground(new java.awt.Color(102, 204, 0));
        table7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel101.setBackground(new java.awt.Color(204, 204, 204));

        NameTable7.setBackground(new java.awt.Color(249, 249, 249));
        NameTable7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable7.setText("BÀN 7");
        NameTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel103.setBackground(new java.awt.Color(255, 255, 255));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("SĐT KH");

        SDTKH7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel102Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel104.setBackground(new java.awt.Color(102, 204, 0));

        jPanel105.setBackground(new java.awt.Color(102, 204, 0));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("GIỜ CHƠI");

        TIMESTART7.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART7.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART7.setEnabled(false);
        TIMESTART7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART7)
                .addContainerGap())
        );

        jPanel106.setBackground(new java.awt.Color(102, 204, 0));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("GIỜ NGHỈ");

        TIMEEND7.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND7.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND7.setEnabled(false);
        TIMEEND7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addComponent(jPanel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel107.setBackground(new java.awt.Color(255, 255, 255));

        StartBtnTable7.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable7.setText("BẮT ĐẦU");
        StartBtnTable7.setBorder(null);
        StartBtnTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable7MouseClicked(evt);
            }
        });
        StartBtnTable7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable7ActionPerformed(evt);
            }
        });

        StopBtnTable7.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable7.setText("DỪNG LẠI");
        StopBtnTable7.setBorder(null);
        StopBtnTable7.setEnabled(false);
        StopBtnTable7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable7ActionPerformed(evt);
            }
        });

        PrintBtnTable7.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable7.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable7.setText("IN HÓA ĐƠN");
        PrintBtnTable7.setBorder(null);
        PrintBtnTable7.setEnabled(false);
        PrintBtnTable7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable7ActionPerformed(evt);
            }
        });

        ResetBtnTable7.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable7.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable7.setText("RESET");
        ResetBtnTable7.setBorder(null);
        ResetBtnTable7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartBtnTable7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtnTable7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable7, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable7, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table7Layout = new javax.swing.GroupLayout(table7);
        table7.setLayout(table7Layout);
        table7Layout.setHorizontalGroup(
            table7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel102, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table7Layout.setVerticalGroup(
            table7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table7Layout.createSequentialGroup()
                .addComponent(jPanel101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table4.setBackground(new java.awt.Color(102, 204, 0));
        table4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel80.setBackground(new java.awt.Color(204, 204, 204));

        NameTable4.setBackground(new java.awt.Color(249, 249, 249));
        NameTable4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable4.setText("BÀN 4");
        NameTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("SĐT KH");

        SDTKH4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel81Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel83.setBackground(new java.awt.Color(102, 204, 0));

        jPanel84.setBackground(new java.awt.Color(102, 204, 0));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("GIỜ CHƠI");

        TIMESTART4.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART4.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART4.setEnabled(false);
        TIMESTART4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART4)
                .addContainerGap())
        );

        jPanel85.setBackground(new java.awt.Color(102, 204, 0));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("GIỜ NGHỈ");

        TIMEEND4.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND4.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND4.setEnabled(false);
        TIMEEND4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addComponent(jPanel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));

        StartBtnTable4.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable4.setText("BẮT ĐẦU");
        StartBtnTable4.setBorder(null);
        StartBtnTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable4MouseClicked(evt);
            }
        });
        StartBtnTable4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable4ActionPerformed(evt);
            }
        });

        StopBtnTable4.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable4.setText("DỪNG LẠI");
        StopBtnTable4.setBorder(null);
        StopBtnTable4.setEnabled(false);
        StopBtnTable4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable4ActionPerformed(evt);
            }
        });

        PrintBtnTable4.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable4.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable4.setText("IN HÓA ĐƠN");
        PrintBtnTable4.setBorder(null);
        PrintBtnTable4.setEnabled(false);
        PrintBtnTable4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable4ActionPerformed(evt);
            }
        });

        ResetBtnTable4.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable4.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable4.setText("RESET");
        ResetBtnTable4.setBorder(null);
        ResetBtnTable4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartBtnTable4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtnTable4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table4Layout = new javax.swing.GroupLayout(table4);
        table4.setLayout(table4Layout);
        table4Layout.setHorizontalGroup(
            table4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table4Layout.setVerticalGroup(
            table4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table4Layout.createSequentialGroup()
                .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table8.setBackground(new java.awt.Color(102, 204, 0));
        table8.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel108.setBackground(new java.awt.Color(204, 204, 204));

        NameTable8.setBackground(new java.awt.Color(249, 249, 249));
        NameTable8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable8.setText("BÀN 8");
        NameTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel110.setBackground(new java.awt.Color(255, 255, 255));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("SĐT KH");

        SDTKH8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH8)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel109Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel111.setBackground(new java.awt.Color(102, 204, 0));

        jPanel112.setBackground(new java.awt.Color(102, 204, 0));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("GIỜ CHƠI");

        TIMESTART8.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART8.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART8.setEnabled(false);
        TIMESTART8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART8)
                .addContainerGap())
        );

        jPanel113.setBackground(new java.awt.Color(102, 204, 0));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("GIỜ NGHỈ");

        TIMEEND8.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND8.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND8.setEnabled(false);
        TIMEEND8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND8)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addComponent(jPanel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel114.setBackground(new java.awt.Color(255, 255, 255));

        StartBtnTable8.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable8.setText("BẮT ĐẦU");
        StartBtnTable8.setBorder(null);
        StartBtnTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable8MouseClicked(evt);
            }
        });
        StartBtnTable8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable8ActionPerformed(evt);
            }
        });

        StopBtnTable8.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable8.setText("DỪNG LẠI");
        StopBtnTable8.setBorder(null);
        StopBtnTable8.setEnabled(false);
        StopBtnTable8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable8ActionPerformed(evt);
            }
        });

        PrintBtnTable8.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable8.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable8.setText("IN HÓA ĐƠN");
        PrintBtnTable8.setBorder(null);
        PrintBtnTable8.setEnabled(false);
        PrintBtnTable8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable8ActionPerformed(evt);
            }
        });

        ResetBtnTable8.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable8.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable8.setText("RESET");
        ResetBtnTable8.setBorder(null);
        ResetBtnTable8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartBtnTable8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtnTable8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable8, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable8, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table8Layout = new javax.swing.GroupLayout(table8);
        table8.setLayout(table8Layout);
        table8Layout.setHorizontalGroup(
            table8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel109, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        table8Layout.setVerticalGroup(
            table8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table8Layout.createSequentialGroup()
                .addComponent(jPanel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(table6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(table7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(table2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(table3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(table2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(110, 178, 246));

        LogoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/duc/NetBeansProjects/BidaManagement/src/main/java/com/mycompany/bidamanagement/Icon/logout25x25.png")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout LogoutBtnLayout = new javax.swing.GroupLayout(LogoutBtn);
        LogoutBtn.setLayout(LogoutBtnLayout);
        LogoutBtnLayout.setHorizontalGroup(
            LogoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutBtnLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LogoutBtnLayout.setVerticalGroup(
            LogoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PlayTableBtn.setBackground(new java.awt.Color(253, 169, 127));
        PlayTableBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTableBtnMouseClicked(evt);
            }
        });

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon("/Users/duc/NetBeansProjects/BidaManagement/src/main/java/com/mycompany/bidamanagement/Icon/cus25x25.png")); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("BÀN CHƠI");

        javax.swing.GroupLayout PlayTableBtnLayout = new javax.swing.GroupLayout(PlayTableBtn);
        PlayTableBtn.setLayout(PlayTableBtnLayout);
        PlayTableBtnLayout.setHorizontalGroup(
            PlayTableBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayTableBtnLayout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        );
        PlayTableBtnLayout.setVerticalGroup(
            PlayTableBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CheckOutBtn.setBackground(new java.awt.Color(255, 255, 255));
        CheckOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckOutBtnMouseClicked(evt);
            }
        });

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon("/Users/duc/NetBeansProjects/BidaManagement/src/main/java/com/mycompany/bidamanagement/Icon/checkout25x25.png")); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 153, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("THANH TOÁN");

        javax.swing.GroupLayout CheckOutBtnLayout = new javax.swing.GroupLayout(CheckOutBtn);
        CheckOutBtn.setLayout(CheckOutBtnLayout);
        CheckOutBtnLayout.setHorizontalGroup(
            CheckOutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckOutBtnLayout.createSequentialGroup()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        );
        CheckOutBtnLayout.setVerticalGroup(
            CheckOutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PlayTableBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(310, 310, 310)
                    .addComponent(PlayTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(CheckOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(310, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn tắt ứng dụng?", "Tắt ứng dụng", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnMouseClicked

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất không?", "Đăng xuất", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LogoutBtnMouseClicked

    private void TIMESTART1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART1ActionPerformed
        
    }//GEN-LAST:event_TIMESTART1ActionPerformed

    private void StopBtnTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable1ActionPerformed

        Date currentStopTable1 = new Date();
        SimpleDateFormat dateStopFormatTable1 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable1 = dateStopFormatTable1.format(currentStopTable1);
        TIMEEND1.setText(formatStopTable1);
        NameTable1.setText("BÀN 1 (ĐANG TÍNH TIỀN)");
        NameTable1.setForeground(Color.YELLOW);
        StopBtnTable1.setEnabled(false);
        PrintBtnTable1.setEnabled(true);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable1);

        endHourTable1 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable1 = cal.get(Calendar.MINUTE);
        endSecondTable1 = cal.get(Calendar.SECOND);
        
        //Luu gia tri sau khi set moi bien
        saveInputDataTable1();
    }//GEN-LAST:event_StopBtnTable1ActionPerformed

    private void PrintBtnTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable1ActionPerformed
        Date currentPrintTable1 = new Date();
        SimpleDateFormat datePrintTable1 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable1 = datePrintTable1.format(currentPrintTable1);
        String totalFee1 = calculateTimePlayTable(startHourTable1, startMinuteTable1, startSecondTable1, endHourTable1, endMinuteTable1, endSecondTable1);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH1.getText());
            addTableBill.setString(2, formatPrintTable1);
            addTableBill.setString(3, TIMESTART1.getText());
            addTableBill.setString(4, TIMEEND1.getText());
            addTableBill.setString(5, totalFee1);
            addTableBill.setInt(6, 1);
            addTableBill.executeUpdate();
            
            ParameterReportCheckout dataprint1 = new ParameterReportCheckout(formatPrintTable1, TIMESTART1.getText(), TIMEEND1.getText(), totalFee1);
            ReportManager.getInstance().printReportPayment(dataprint1);
            
            printBill(formatPrintTable1, TIMESTART1.getText(), TIMEEND1.getText(), totalFee1);
            PrintBtnTable1.setEnabled(false);
            NameTable1.setText("BÀN 1");
            NameTable1.setForeground(Color.BLACK);
            StartBtnTable1.setEnabled(true);
            StopBtnTable1.setEnabled(false);
            TIMESTART1.setText("");
            TIMEEND1.setText("");
            SDTKH1.setText("");
            saveInputDataTable1();
            System.out.println("Start time: " + startHourTable1 + ":" + startMinuteTable1 + ":" + startSecondTable1);
            System.out.println("End time: " + endHourTable1 + ":" + endMinuteTable1 + ":" + endSecondTable1);
            
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_PrintBtnTable1ActionPerformed
    
    private void StartBtnTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable1ActionPerformed
        
        Date currentStartTable1 = new Date();
        SimpleDateFormat startFormatTable1 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable1 = startFormatTable1.format(currentStartTable1);
        TIMESTART1.setText(formatStartTable1);
        NameTable1.setText("BÀN 1 (ĐANG CHƠI)");
        NameTable1.setForeground(Color.RED);
        StartBtnTable1.setEnabled(false);
        StopBtnTable1.setEnabled(true);
        
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable1);

        startHourTable1 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable1 = cal.get(Calendar.MINUTE);
        startSecondTable1 = cal.get(Calendar.SECOND);
        
        saveInputDataTable1();
    }//GEN-LAST:event_StartBtnTable1ActionPerformed

    private void ResetBtnTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable1ActionPerformed
          
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART1.setText("");
            TIMEEND1.setText("");
            NameTable1.setText("BÀN 1");
            NameTable1.setForeground(Color.BLACK);
            StartBtnTable1.setEnabled(true);
            StopBtnTable1.setEnabled(false);
            PrintBtnTable1.setEnabled(false);
            saveInputDataTable1();
        }
          
    }//GEN-LAST:event_ResetBtnTable1ActionPerformed

    private void StartBtnTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void PlayTableBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTableBtnMouseClicked
        
    }//GEN-LAST:event_PlayTableBtnMouseClicked

    private void CheckOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckOutBtnMouseClicked
        new CheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CheckOutBtnMouseClicked

    private void TIMEEND1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND1ActionPerformed

    private void NameTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable1MouseClicked

    }//GEN-LAST:event_NameTable1MouseClicked

    private void NameTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTable2MouseClicked

    private void TIMESTART2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMESTART2ActionPerformed

    private void TIMEEND2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND2ActionPerformed

    private void StartBtnTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable2MouseClicked
        
    }//GEN-LAST:event_StartBtnTable2MouseClicked
////////
    private void StartBtnTable2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable2ActionPerformed
        Date currentStartTable2 = new Date();
        SimpleDateFormat startFormatTable2 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable2 = startFormatTable2.format(currentStartTable2);
        TIMESTART2.setText(formatStartTable2);
        NameTable2.setText("BÀN 2 (ĐANG CHƠI)");
        NameTable2.setForeground(Color.RED);
        StartBtnTable2.setEnabled(false);
        StopBtnTable2.setEnabled(true);


        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable2);

        startHourTable2 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable2 = cal.get(Calendar.MINUTE);
        startSecondTable2 = cal.get(Calendar.SECOND);

        saveInputDataTable2();

    }//GEN-LAST:event_StartBtnTable2ActionPerformed

    private void StopBtnTable2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable2ActionPerformed
        Date currentStopTable2 = new Date();
        SimpleDateFormat dateStopFormatTable2 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable2 = dateStopFormatTable2.format(currentStopTable2);
        TIMEEND2.setText(formatStopTable2);
        NameTable2.setText("BÀN 2 (ĐANG TÍNH TIỀN)");
        NameTable2.setForeground(Color.YELLOW);
        StopBtnTable2.setEnabled(false);
        PrintBtnTable2.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable2);

        endHourTable2 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable2 = cal.get(Calendar.MINUTE);
        endSecondTable2 = cal.get(Calendar.SECOND);

        //Luu gia tri sau khi set moi bien
        saveInputDataTable2();

    }//GEN-LAST:event_StopBtnTable2ActionPerformed

    private void PrintBtnTable2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable2ActionPerformed
        Date currentPrintTable2 = new Date();
        SimpleDateFormat datePrintTable2 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable2 = datePrintTable2.format(currentPrintTable2);
        String totalFee2 = calculateTimePlayTable(startHourTable2, startMinuteTable2, startSecondTable2, endHourTable2, endMinuteTable2, endSecondTable2);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH2.getText());
            addTableBill.setString(2, formatPrintTable2);
            addTableBill.setString(3, TIMESTART2.getText());
            addTableBill.setString(4, TIMEEND2.getText());
            addTableBill.setString(5, totalFee2);
            addTableBill.setInt(6, 2);
            addTableBill.executeUpdate();

            ParameterReportCheckout dataprint2 = new ParameterReportCheckout(formatPrintTable2, TIMESTART2.getText(), TIMEEND2.getText(), totalFee2);
            ReportManager.getInstance().printReportPayment(dataprint2);

            printBill(formatPrintTable2, TIMESTART2.getText(), TIMEEND2.getText(), totalFee2);
            PrintBtnTable2.setEnabled(false);
            NameTable2.setText("BÀN 2");
            NameTable2.setForeground(Color.BLACK);
            StartBtnTable2.setEnabled(true);
            StopBtnTable2.setEnabled(false);
            TIMESTART2.setText("");
            TIMEEND2.setText("");
            SDTKH2.setText("");
            saveInputDataTable2();
            System.out.println("Start time: " + startHourTable2 + ":" + startMinuteTable2 + ":" + startSecondTable2);
            System.out.println("End time: " + endHourTable2 + ":" + endMinuteTable2 + ":" + endSecondTable2);

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_PrintBtnTable2ActionPerformed

    private void ResetBtnTable2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable2ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART2.setText("");
            TIMEEND2.setText("");
            NameTable2.setText("BÀN 2");
            NameTable2.setForeground(Color.BLACK);
            StartBtnTable2.setEnabled(true);
            StopBtnTable2.setEnabled(false);
            PrintBtnTable2.setEnabled(false);
            saveInputDataTable2();
        }

    }//GEN-LAST:event_ResetBtnTable2ActionPerformed

    private void NameTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTable3MouseClicked

    private void TIMESTART3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMESTART3ActionPerformed

    private void TIMEEND3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND3ActionPerformed

    private void StartBtnTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable3MouseClicked

    private void StartBtnTable3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable3ActionPerformed
        Date currentStartTable3 = new Date();
        SimpleDateFormat startFormatTable3 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable3 = startFormatTable3.format(currentStartTable3);
        TIMESTART3.setText(formatStartTable3);
        NameTable3.setText("BÀN 3 (ĐANG CHƠI)");
        NameTable3.setForeground(Color.RED);
        StartBtnTable3.setEnabled(false);
        StopBtnTable3.setEnabled(true);


        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable3);

        startHourTable3 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable3 = cal.get(Calendar.MINUTE);
        startSecondTable3 = cal.get(Calendar.SECOND);

        saveInputDataTable3();

    }//GEN-LAST:event_StartBtnTable3ActionPerformed

    private void StopBtnTable3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable3ActionPerformed
        Date currentStopTable3 = new Date();
        SimpleDateFormat dateStopFormatTable3 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable3 = dateStopFormatTable3.format(currentStopTable3);
        TIMEEND3.setText(formatStopTable3);
        NameTable3.setText("BÀN 3 (ĐANG TÍNH TIỀN)");
        NameTable3.setForeground(Color.YELLOW);
        StopBtnTable3.setEnabled(false);
        PrintBtnTable3.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable3);

        endHourTable3 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable3 = cal.get(Calendar.MINUTE);
        endSecondTable3 = cal.get(Calendar.SECOND);

        //Luu gia tri sau khi set moi bien
        saveInputDataTable3();

    }//GEN-LAST:event_StopBtnTable3ActionPerformed

    private void PrintBtnTable3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable3ActionPerformed
        Date currentPrintTable3 = new Date();
        SimpleDateFormat datePrintTable3 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable3 = datePrintTable3.format(currentPrintTable3);
        String totalFee3 = calculateTimePlayTable(startHourTable3, startMinuteTable3, startSecondTable3, endHourTable3, endMinuteTable3, endSecondTable3);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH3.getText());
            addTableBill.setString(2, formatPrintTable3);
            addTableBill.setString(3, TIMESTART3.getText());
            addTableBill.setString(4, TIMEEND3.getText());
            addTableBill.setString(5, totalFee3);
            addTableBill.setInt(6, 3);
            addTableBill.executeUpdate();

            ParameterReportCheckout dataprint3 = new ParameterReportCheckout(formatPrintTable3, TIMESTART3.getText(), TIMEEND3.getText(), totalFee3);
            ReportManager.getInstance().printReportPayment(dataprint3);

            printBill(formatPrintTable3, TIMESTART3.getText(), TIMEEND3.getText(), totalFee3);
            PrintBtnTable3.setEnabled(false);
            NameTable3.setText("BÀN 3");
            NameTable3.setForeground(Color.BLACK);
            StartBtnTable3.setEnabled(true);
            StopBtnTable3.setEnabled(false);
            TIMESTART3.setText("");
            TIMEEND3.setText("");
            SDTKH3.setText("");
            saveInputDataTable3();
            System.out.println("Start time: " + startHourTable3 + ":" + startMinuteTable3 + ":" + startSecondTable3);
            System.out.println("End time: " + endHourTable3 + ":" + endMinuteTable3 + ":" + endSecondTable3);

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_PrintBtnTable3ActionPerformed

    private void ResetBtnTable3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable3ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART3.setText("");
            TIMEEND3.setText("");
            NameTable3.setText("BÀN 3");
            NameTable3.setForeground(Color.BLACK);
            StartBtnTable3.setEnabled(true);
            StopBtnTable3.setEnabled(false);
            PrintBtnTable3.setEnabled(false);
            saveInputDataTable3();
        }

    }//GEN-LAST:event_ResetBtnTable3ActionPerformed

    private void NameTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTable4MouseClicked

    private void TIMESTART4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMESTART4ActionPerformed

    private void TIMEEND4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND4ActionPerformed

    private void StartBtnTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable4MouseClicked

    private void StartBtnTable4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable4ActionPerformed
        Date currentStartTable4 = new Date();
        SimpleDateFormat startFormatTable4 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable4 = startFormatTable4.format(currentStartTable4);
        TIMESTART4.setText(formatStartTable4);
        NameTable4.setText("BÀN 4 (ĐANG CHƠI)");
        NameTable4.setForeground(Color.RED);
        StartBtnTable4.setEnabled(false);
        StopBtnTable4.setEnabled(true);


        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable4);

        startHourTable4 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable4 = cal.get(Calendar.MINUTE);
        startSecondTable4 = cal.get(Calendar.SECOND);

        saveInputDataTable4();

    }//GEN-LAST:event_StartBtnTable4ActionPerformed

    private void StopBtnTable4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable4ActionPerformed
        Date currentStopTable4 = new Date();
        SimpleDateFormat dateStopFormatTable4 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable4 = dateStopFormatTable4.format(currentStopTable4);
        TIMEEND4.setText(formatStopTable4);
        NameTable4.setText("BÀN 4 (ĐANG TÍNH TIỀN)");
        NameTable4.setForeground(Color.YELLOW);
        StopBtnTable4.setEnabled(false);
        PrintBtnTable4.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable4);

        endHourTable4 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable4 = cal.get(Calendar.MINUTE);
        endSecondTable4 = cal.get(Calendar.SECOND);

        //Luu gia tri sau khi set moi bien
        saveInputDataTable4();

    }//GEN-LAST:event_StopBtnTable4ActionPerformed

    private void PrintBtnTable4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable4ActionPerformed
        Date currentPrintTable4 = new Date();
        SimpleDateFormat datePrintTable4 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable4 = datePrintTable4.format(currentPrintTable4);
        String totalFee4 = calculateTimePlayTable(startHourTable4, startMinuteTable4, startSecondTable4, endHourTable4, endMinuteTable4, endSecondTable4);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH4.getText());
            addTableBill.setString(2, formatPrintTable4);
            addTableBill.setString(3, TIMESTART4.getText());
            addTableBill.setString(4, TIMEEND4.getText());
            addTableBill.setString(5, totalFee4);
            addTableBill.setInt(6, 4);
            addTableBill.executeUpdate();

            ParameterReportCheckout dataprint4 = new ParameterReportCheckout(formatPrintTable4, TIMESTART4.getText(), TIMEEND4.getText(), totalFee4);
            ReportManager.getInstance().printReportPayment(dataprint4);

            printBill(formatPrintTable4, TIMESTART4.getText(), TIMEEND4.getText(), totalFee4);
            PrintBtnTable4.setEnabled(false);
            NameTable4.setText("BÀN 4");
            NameTable4.setForeground(Color.BLACK);
            StartBtnTable4.setEnabled(true);
            StopBtnTable4.setEnabled(false);
            TIMESTART4.setText("");
            TIMEEND4.setText("");
            SDTKH4.setText("");
            saveInputDataTable4();
            System.out.println("Start time: " + startHourTable4 + ":" + startMinuteTable4 + ":" + startSecondTable4);
            System.out.println("End time: " + endHourTable4 + ":" + endMinuteTable4 + ":" + endSecondTable4);

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_PrintBtnTable4ActionPerformed

    private void ResetBtnTable4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable4ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART4.setText("");
            TIMEEND4.setText("");
            NameTable4.setText("BÀN 4");
            NameTable4.setForeground(Color.BLACK);
            StartBtnTable4.setEnabled(true);
            StopBtnTable4.setEnabled(false);
            PrintBtnTable4.setEnabled(false);
            saveInputDataTable4();
        }

    }//GEN-LAST:event_ResetBtnTable4ActionPerformed

    private void NameTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTable5MouseClicked

    private void TIMESTART5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMESTART5ActionPerformed

    private void TIMEEND5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND5ActionPerformed

    private void StartBtnTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable5MouseClicked

    private void StartBtnTable5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable5ActionPerformed
        Date currentStartTable5 = new Date();
        SimpleDateFormat startFormatTable5 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable5 = startFormatTable5.format(currentStartTable5);
        TIMESTART5.setText(formatStartTable5);
        NameTable5.setText("BÀN 5 (ĐANG CHƠI)");
        NameTable5.setForeground(Color.RED);
        StartBtnTable5.setEnabled(false);
        StopBtnTable5.setEnabled(true);


        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable5);

        startHourTable5 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable5 = cal.get(Calendar.MINUTE);
        startSecondTable5 = cal.get(Calendar.SECOND);

        saveInputDataTable5();

    }//GEN-LAST:event_StartBtnTable5ActionPerformed

    private void StopBtnTable5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable5ActionPerformed
        Date currentStopTable5 = new Date();
        SimpleDateFormat dateStopFormatTable5 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable5 = dateStopFormatTable5.format(currentStopTable5);
        TIMEEND5.setText(formatStopTable5);
        NameTable5.setText("BÀN 5 (ĐANG TÍNH TIỀN)");
        NameTable5.setForeground(Color.YELLOW);
        StopBtnTable5.setEnabled(false);
        PrintBtnTable5.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable5);

        endHourTable5 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable5 = cal.get(Calendar.MINUTE);
        endSecondTable5 = cal.get(Calendar.SECOND);

        //Luu gia tri sau khi set moi bien
        saveInputDataTable5();

    }//GEN-LAST:event_StopBtnTable5ActionPerformed

    private void PrintBtnTable5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable5ActionPerformed
        Date currentPrintTable5 = new Date();
        SimpleDateFormat datePrintTable5 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable5 = datePrintTable5.format(currentPrintTable5);
        String totalFee5 = calculateTimePlayTable(startHourTable5, startMinuteTable5, startSecondTable5, endHourTable5, endMinuteTable5, endSecondTable5);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH5.getText());
            addTableBill.setString(2, formatPrintTable5);
            addTableBill.setString(3, TIMESTART5.getText());
            addTableBill.setString(4, TIMEEND5.getText());
            addTableBill.setString(5, totalFee5);
            addTableBill.setInt(6, 5);
            addTableBill.executeUpdate();

            ParameterReportCheckout dataprint5 = new ParameterReportCheckout(formatPrintTable5, TIMESTART5.getText(), TIMEEND5.getText(), totalFee5);
            ReportManager.getInstance().printReportPayment(dataprint5);

            printBill(formatPrintTable5, TIMESTART5.getText(), TIMEEND5.getText(), totalFee5);
            PrintBtnTable5.setEnabled(false);
            NameTable5.setText("BÀN 5");
            NameTable5.setForeground(Color.BLACK);
            StartBtnTable5.setEnabled(true);
            StopBtnTable5.setEnabled(false);
            TIMESTART5.setText("");
            TIMEEND5.setText("");
            SDTKH5.setText("");
            saveInputDataTable5();
            System.out.println("Start time: " + startHourTable5 + ":" + startMinuteTable5 + ":" + startSecondTable5);
            System.out.println("End time: " + endHourTable5 + ":" + endMinuteTable5 + ":" + endSecondTable5);

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PrintBtnTable5ActionPerformed

    private void ResetBtnTable5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable5ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART5.setText("");
            TIMEEND5.setText("");
            NameTable5.setText("BÀN 5");
            NameTable5.setForeground(Color.BLACK);
            StartBtnTable5.setEnabled(true);
            StopBtnTable5.setEnabled(false);
            PrintBtnTable5.setEnabled(false);
            saveInputDataTable5();
        }

    }//GEN-LAST:event_ResetBtnTable5ActionPerformed

    private void NameTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTable6MouseClicked

    private void TIMESTART6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMESTART6ActionPerformed

    private void TIMEEND6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND6ActionPerformed

    private void StartBtnTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable6MouseClicked

    private void StartBtnTable6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable6ActionPerformed
        Date currentStartTable6 = new Date();
        SimpleDateFormat startFormatTable6 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable6 = startFormatTable6.format(currentStartTable6);
        TIMESTART6.setText(formatStartTable6);
        NameTable6.setText("BÀN 6 (ĐANG CHƠI)");
        NameTable6.setForeground(Color.RED);
        StartBtnTable6.setEnabled(false);
        StopBtnTable6.setEnabled(true);


        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable6);

        startHourTable6 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable6 = cal.get(Calendar.MINUTE);
        startSecondTable6 = cal.get(Calendar.SECOND);

        saveInputDataTable6();

    }//GEN-LAST:event_StartBtnTable6ActionPerformed

    private void StopBtnTable6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable6ActionPerformed
        Date currentStopTable6 = new Date();
        SimpleDateFormat dateStopFormatTable6 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable6 = dateStopFormatTable6.format(currentStopTable6);
        TIMEEND6.setText(formatStopTable6);
        NameTable6.setText("BÀN 6 (ĐANG TÍNH TIỀN)");
        NameTable6.setForeground(Color.YELLOW);
        StopBtnTable6.setEnabled(false);
        PrintBtnTable6.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable6);

        endHourTable6 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable6 = cal.get(Calendar.MINUTE);
        endSecondTable6 = cal.get(Calendar.SECOND);

        //Luu gia tri sau khi set moi bien
        saveInputDataTable6();

    }//GEN-LAST:event_StopBtnTable6ActionPerformed

    private void PrintBtnTable6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable6ActionPerformed
        Date currentPrintTable6 = new Date();
        SimpleDateFormat datePrintTable6 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable6 = datePrintTable6.format(currentPrintTable6);
        String totalFee6 = calculateTimePlayTable(startHourTable6, startMinuteTable6, startSecondTable6, endHourTable6, endMinuteTable6, endSecondTable6);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH6.getText());
            addTableBill.setString(2, formatPrintTable6);
            addTableBill.setString(3, TIMESTART6.getText());
            addTableBill.setString(4, TIMEEND6.getText());
            addTableBill.setString(5, totalFee6);
            addTableBill.setInt(6, 6);
            addTableBill.executeUpdate();

            ParameterReportCheckout dataprint6 = new ParameterReportCheckout(formatPrintTable6, TIMESTART6.getText(), TIMEEND6.getText(), totalFee6);
            ReportManager.getInstance().printReportPayment(dataprint6);

            printBill(formatPrintTable6, TIMESTART6.getText(), TIMEEND6.getText(), totalFee6);
            PrintBtnTable6.setEnabled(false);
            NameTable6.setText("BÀN 6");
            NameTable6.setForeground(Color.BLACK);
            StartBtnTable6.setEnabled(true);
            StopBtnTable6.setEnabled(false);
            TIMESTART6.setText("");
            TIMEEND6.setText("");
            SDTKH6.setText("");
            saveInputDataTable6();
            System.out.println("Start time: " + startHourTable6 + ":" + startMinuteTable6 + ":" + startSecondTable6);
            System.out.println("End time: " + endHourTable6 + ":" + endMinuteTable6 + ":" + endSecondTable6);

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PrintBtnTable6ActionPerformed

    private void ResetBtnTable6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable6ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART6.setText("");
            TIMEEND6.setText("");
            NameTable6.setText("BÀN 6");
            NameTable6.setForeground(Color.BLACK);
            StartBtnTable6.setEnabled(true);
            StopBtnTable6.setEnabled(false);
            PrintBtnTable6.setEnabled(false);
            saveInputDataTable6();
        }

    }//GEN-LAST:event_ResetBtnTable6ActionPerformed

    private void NameTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTable7MouseClicked

    private void TIMESTART7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMESTART7ActionPerformed

    private void TIMEEND7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND7ActionPerformed

    private void StartBtnTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable7MouseClicked

    private void StartBtnTable7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable7ActionPerformed
        Date currentStartTable7 = new Date();
        SimpleDateFormat startFormatTable7 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable7 = startFormatTable7.format(currentStartTable7);
        TIMESTART7.setText(formatStartTable7);
        NameTable7.setText("BÀN 7 (ĐANG CHƠI)");
        NameTable7.setForeground(Color.RED);
        StartBtnTable7.setEnabled(false);
        StopBtnTable7.setEnabled(true);


        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable7);

        startHourTable7 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable7 = cal.get(Calendar.MINUTE);
        startSecondTable7 = cal.get(Calendar.SECOND);

        saveInputDataTable7();

    }//GEN-LAST:event_StartBtnTable7ActionPerformed

    private void StopBtnTable7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable7ActionPerformed
        Date currentStopTable7 = new Date();
        SimpleDateFormat dateStopFormatTable7 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable7 = dateStopFormatTable7.format(currentStopTable7);
        TIMEEND7.setText(formatStopTable7);
        NameTable7.setText("BÀN 7 (ĐANG TÍNH TIỀN)");
        NameTable7.setForeground(Color.YELLOW);
        StopBtnTable7.setEnabled(false);
        PrintBtnTable7.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable7);

        endHourTable7 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable7 = cal.get(Calendar.MINUTE);
        endSecondTable7 = cal.get(Calendar.SECOND);

        //Luu gia tri sau khi set moi bien
        saveInputDataTable7();

    }//GEN-LAST:event_StopBtnTable7ActionPerformed

    private void PrintBtnTable7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable7ActionPerformed
        Date currentPrintTable7 = new Date();
        SimpleDateFormat datePrintTable7 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable7 = datePrintTable7.format(currentPrintTable7);
        String totalFee7 = calculateTimePlayTable(startHourTable7, startMinuteTable7, startSecondTable7, endHourTable7, endMinuteTable7, endSecondTable7);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH7.getText());
            addTableBill.setString(2, formatPrintTable7);
            addTableBill.setString(3, TIMESTART7.getText());
            addTableBill.setString(4, TIMEEND7.getText());
            addTableBill.setString(5, totalFee7);
            addTableBill.setInt(6, 7);
            addTableBill.executeUpdate();

            ParameterReportCheckout dataprint7 = new ParameterReportCheckout(formatPrintTable7, TIMESTART7.getText(), TIMEEND7.getText(), totalFee7);
            ReportManager.getInstance().printReportPayment(dataprint7);

            printBill(formatPrintTable7, TIMESTART7.getText(), TIMEEND7.getText(), totalFee7);
            PrintBtnTable7.setEnabled(false);
            NameTable7.setText("BÀN 7");
            NameTable7.setForeground(Color.BLACK);
            StartBtnTable7.setEnabled(true);
            StopBtnTable7.setEnabled(false);
            TIMESTART7.setText("");
            TIMEEND7.setText("");
            SDTKH7.setText("");
            saveInputDataTable7();
            System.out.println("Start time: " + startHourTable7 + ":" + startMinuteTable7 + ":" + startSecondTable7);
            System.out.println("End time: " + endHourTable7 + ":" + endMinuteTable7 + ":" + endSecondTable7);

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PrintBtnTable7ActionPerformed

    private void ResetBtnTable7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable7ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART7.setText("");
            TIMEEND7.setText("");
            NameTable7.setText("BÀN 7");
            NameTable7.setForeground(Color.BLACK);
            StartBtnTable7.setEnabled(true);
            StopBtnTable7.setEnabled(false);
            PrintBtnTable7.setEnabled(false);
            saveInputDataTable7();
        }

    }//GEN-LAST:event_ResetBtnTable7ActionPerformed

    private void NameTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTable8MouseClicked

    private void TIMESTART8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMESTART8ActionPerformed

    private void TIMEEND8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND8ActionPerformed

    private void StartBtnTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable8MouseClicked

    private void StartBtnTable8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable8ActionPerformed
        Date currentStartTable8 = new Date();
        SimpleDateFormat startFormatTable8 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable8 = startFormatTable8.format(currentStartTable8);
        TIMESTART8.setText(formatStartTable8);
        NameTable8.setText("BÀN 8 (ĐANG CHƠI)");
        NameTable8.setForeground(Color.RED);
        StartBtnTable8.setEnabled(false);
        StopBtnTable8.setEnabled(true);


        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable8);

        startHourTable8 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable8 = cal.get(Calendar.MINUTE);
        startSecondTable8 = cal.get(Calendar.SECOND);

        saveInputDataTable8();

    }//GEN-LAST:event_StartBtnTable8ActionPerformed

    private void StopBtnTable8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable8ActionPerformed
        Date currentStopTable8 = new Date();
        SimpleDateFormat dateStopFormatTable8 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable8 = dateStopFormatTable8.format(currentStopTable8);
        TIMEEND8.setText(formatStopTable8);
        NameTable8.setText("BÀN 8 (ĐANG TÍNH TIỀN)");
        NameTable8.setForeground(Color.YELLOW);
        StopBtnTable8.setEnabled(false);
        PrintBtnTable8.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable8);

        endHourTable8 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable8 = cal.get(Calendar.MINUTE);
        endSecondTable8 = cal.get(Calendar.SECOND);

        //Luu gia tri sau khi set moi bien
        saveInputDataTable8();

    }//GEN-LAST:event_StopBtnTable8ActionPerformed

    private void PrintBtnTable8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable8ActionPerformed
        Date currentPrintTable8 = new Date();
        SimpleDateFormat datePrintTable8 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable8 = datePrintTable8.format(currentPrintTable8);
        String totalFee8 = calculateTimePlayTable(startHourTable8, startMinuteTable8, startSecondTable8, endHourTable8, endMinuteTable8, endSecondTable8);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH8.getText());
            addTableBill.setString(2, formatPrintTable8);
            addTableBill.setString(3, TIMESTART8.getText());
            addTableBill.setString(4, TIMEEND8.getText());
            addTableBill.setString(5, totalFee8);
            addTableBill.setInt(6, 8);
            addTableBill.executeUpdate();

            ParameterReportCheckout dataprint8 = new ParameterReportCheckout(formatPrintTable8, TIMESTART8.getText(), TIMEEND8.getText(), totalFee8);
            ReportManager.getInstance().printReportPayment(dataprint8);

            printBill(formatPrintTable8, TIMESTART8.getText(), TIMEEND8.getText(), totalFee8);
            PrintBtnTable8.setEnabled(false);
            NameTable8.setText("BÀN 8");
            NameTable8.setForeground(Color.BLACK);
            StartBtnTable8.setEnabled(true);
            StopBtnTable8.setEnabled(false);
            TIMESTART8.setText("");
            TIMEEND8.setText("");
            SDTKH8.setText("");
            saveInputDataTable8();
            System.out.println("Start time: " + startHourTable8 + ":" + startMinuteTable8 + ":" + startSecondTable8);
            System.out.println("End time: " + endHourTable8 + ":" + endMinuteTable8 + ":" + endSecondTable8);

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PrintBtnTable8ActionPerformed

    private void ResetBtnTable8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable8ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART8.setText("");
            TIMEEND8.setText("");
            NameTable8.setText("BÀN 8");
            NameTable8.setForeground(Color.BLACK);
            StartBtnTable8.setEnabled(true);
            StopBtnTable8.setEnabled(false);
            PrintBtnTable8.setEnabled(false);
            saveInputDataTable8();
        }

    }//GEN-LAST:event_ResetBtnTable8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CheckOutBtn;
    private javax.swing.JPanel LogoutBtn;
    private javax.swing.JLabel NameTable1;
    private javax.swing.JLabel NameTable2;
    private javax.swing.JLabel NameTable3;
    private javax.swing.JLabel NameTable4;
    private javax.swing.JLabel NameTable5;
    private javax.swing.JLabel NameTable6;
    private javax.swing.JLabel NameTable7;
    private javax.swing.JLabel NameTable8;
    private javax.swing.JPanel PlayTableBtn;
    private javax.swing.JButton PrintBtnTable1;
    private javax.swing.JButton PrintBtnTable2;
    private javax.swing.JButton PrintBtnTable3;
    private javax.swing.JButton PrintBtnTable4;
    private javax.swing.JButton PrintBtnTable5;
    private javax.swing.JButton PrintBtnTable6;
    private javax.swing.JButton PrintBtnTable7;
    private javax.swing.JButton PrintBtnTable8;
    private javax.swing.JButton ResetBtnTable1;
    private javax.swing.JButton ResetBtnTable2;
    private javax.swing.JButton ResetBtnTable3;
    private javax.swing.JButton ResetBtnTable4;
    private javax.swing.JButton ResetBtnTable5;
    private javax.swing.JButton ResetBtnTable6;
    private javax.swing.JButton ResetBtnTable7;
    private javax.swing.JButton ResetBtnTable8;
    private javax.swing.JTextField SDTKH1;
    private javax.swing.JTextField SDTKH2;
    private javax.swing.JTextField SDTKH3;
    private javax.swing.JTextField SDTKH4;
    private javax.swing.JTextField SDTKH5;
    private javax.swing.JTextField SDTKH6;
    private javax.swing.JTextField SDTKH7;
    private javax.swing.JTextField SDTKH8;
    private javax.swing.JButton StartBtnTable1;
    private javax.swing.JButton StartBtnTable2;
    private javax.swing.JButton StartBtnTable3;
    private javax.swing.JButton StartBtnTable4;
    private javax.swing.JButton StartBtnTable5;
    private javax.swing.JButton StartBtnTable6;
    private javax.swing.JButton StartBtnTable7;
    private javax.swing.JButton StartBtnTable8;
    private javax.swing.JButton StopBtnTable1;
    private javax.swing.JButton StopBtnTable2;
    private javax.swing.JButton StopBtnTable3;
    private javax.swing.JButton StopBtnTable4;
    private javax.swing.JButton StopBtnTable5;
    private javax.swing.JButton StopBtnTable6;
    private javax.swing.JButton StopBtnTable7;
    private javax.swing.JButton StopBtnTable8;
    private javax.swing.JTextField TIMEEND1;
    private javax.swing.JTextField TIMEEND2;
    private javax.swing.JTextField TIMEEND3;
    private javax.swing.JTextField TIMEEND4;
    private javax.swing.JTextField TIMEEND5;
    private javax.swing.JTextField TIMEEND6;
    private javax.swing.JTextField TIMEEND7;
    private javax.swing.JTextField TIMEEND8;
    private javax.swing.JTextField TIMESTART1;
    private javax.swing.JTextField TIMESTART2;
    private javax.swing.JTextField TIMESTART3;
    private javax.swing.JTextField TIMESTART4;
    private javax.swing.JTextField TIMESTART5;
    private javax.swing.JTextField TIMESTART6;
    private javax.swing.JTextField TIMESTART7;
    private javax.swing.JTextField TIMESTART8;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JPanel table1;
    private javax.swing.JPanel table2;
    private javax.swing.JPanel table3;
    private javax.swing.JPanel table4;
    private javax.swing.JPanel table5;
    private javax.swing.JPanel table6;
    private javax.swing.JPanel table7;
    private javax.swing.JPanel table8;
    // End of variables declaration//GEN-END:variables
}
