/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author duc
 */
public class CommonFunction {
     public static double roundDecimal(double number, int decimalPlaces) {
        String pattern = "#." + new String(new char[decimalPlaces]).replace("\0", "#");
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formattedNumber = decimalFormat.format(number).replace(",", ".");
        return Double.parseDouble(formattedNumber);
    }

    public static double parseDouble(String value) throws NumberFormatException {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Chuỗi không hợp lệ:" + value);
            throw new NumberFormatException("Chuỗi không hợp lệ: " + value);
        }
    }

    public static String doubleFormattedView(double number) {
         DecimalFormat df = new DecimalFormat("#,##0.00");
            String formattedNumber = df.format(number);
            // Loại bỏ dấu phẩy và thay thế bằng chấm
            return formattedNumber.replace(",", ".");
    }
    
    public static int parseInteger(String value) throws NumberFormatException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ (Số nguyên):" + value);
            throw new NumberFormatException("Chuỗi không hợp lệ: " + value);
        }
    }
    
    public static String calculateTimePlayTable(int startHour, int startMinute, int startSecond, int endHour, int endMinute, int endSecond) {
        final int SECONDS_IN_HOUR = 3600;
        final int SECONDS_IN_MINUTE = 60;
        final double PRICE_PER_HOUR = 35.0;
    
        // Kiểm tra tính hợp lệ của thời gian đầu vào
        if (startHour < 0 || startHour > 23 || startMinute < 0 || startMinute > 59 || startSecond < 0 || startSecond > 59 ||
                endHour < 0 || endHour > 23 || endMinute < 0 || endMinute > 59 || endSecond < 0 || endSecond > 59) {
            return "Thời gian đầu vào không hợp lệ";
        }
    
        // Chuyển thời gian thành giây
        long startTimeInSeconds = startHour * SECONDS_IN_HOUR + startMinute * SECONDS_IN_MINUTE + startSecond;
        long endTimeInSeconds = endHour * SECONDS_IN_HOUR + endMinute * SECONDS_IN_MINUTE + endSecond;
    
        // Xử lý trường hợp thời gian kết thúc qua ngày hôm sau
        if (endTimeInSeconds < startTimeInSeconds) {
            endTimeInSeconds += 24 * 3600; // Thêm 24 giờ nếu kết thúc qua ngày hôm sau
        }
    
        // Tính thời gian chơi trong giờ, phút và giây
        long totalPlayedSeconds = endTimeInSeconds - startTimeInSeconds;
        int playedHours = (int)(totalPlayedSeconds / SECONDS_IN_HOUR);
        int remainingSeconds = (int)(totalPlayedSeconds % SECONDS_IN_HOUR);
        int playedMinutes = remainingSeconds / SECONDS_IN_MINUTE;
        int playedSeconds = remainingSeconds % SECONDS_IN_MINUTE;
    
        // Tính tiền
        double totalPlayedHours = playedHours + (double)playedMinutes / 60 + (double)playedSeconds / 3600;
        double tableFee = totalPlayedHours * PRICE_PER_HOUR;
    
        return String.valueOf(roundDecimal(tableFee, 2));
    }
    
    public static String calculateTimePlayTablePrice40(int startHour, int startMinute, int startSecond, int endHour, int endMinute, int endSecond) {
        final int SECONDS_IN_HOUR = 3600;
        final int SECONDS_IN_MINUTE = 60;
        final double PRICE_PER_HOUR = 40.0;
    
        // Kiểm tra tính hợp lệ của thời gian đầu vào
        if (startHour < 0 || startHour > 23 || startMinute < 0 || startMinute > 59 || startSecond < 0 || startSecond > 59 ||
                endHour < 0 || endHour > 23 || endMinute < 0 || endMinute > 59 || endSecond < 0 || endSecond > 59) {
            return "Thời gian đầu vào không hợp lệ";
        }
    
        // Chuyển thời gian thành giây
        long startTimeInSeconds = startHour * SECONDS_IN_HOUR + startMinute * SECONDS_IN_MINUTE + startSecond;
        long endTimeInSeconds = endHour * SECONDS_IN_HOUR + endMinute * SECONDS_IN_MINUTE + endSecond;
    
        // Xử lý trường hợp thời gian kết thúc qua ngày hôm sau
        if (endTimeInSeconds < startTimeInSeconds) {
            endTimeInSeconds += 24 * 3600; // Thêm 24 giờ nếu kết thúc qua ngày hôm sau
        }
    
        // Tính thời gian chơi trong giờ, phút và giây
        long totalPlayedSeconds = endTimeInSeconds - startTimeInSeconds;
        int playedHours = (int)(totalPlayedSeconds / SECONDS_IN_HOUR);
        int remainingSeconds = (int)(totalPlayedSeconds % SECONDS_IN_HOUR);
        int playedMinutes = remainingSeconds / SECONDS_IN_MINUTE;
        int playedSeconds = remainingSeconds % SECONDS_IN_MINUTE;
    
        // Tính tiền
        double totalPlayedHours = playedHours + (double)playedMinutes / 60 + (double)playedSeconds / 3600;
        double tableFee = totalPlayedHours * PRICE_PER_HOUR;
    
        return String.valueOf(roundDecimal(tableFee, 2));
    }
    
    public static String calculateTimePlayTablePrice55(int startHour, int startMinute, int startSecond, int endHour, int endMinute, int endSecond) {
        final int SECONDS_IN_HOUR = 3600;
        final int SECONDS_IN_MINUTE = 60;
        final double PRICE_PER_HOUR = 50.0;
    
        // Kiểm tra tính hợp lệ của thời gian đầu vào
        if (startHour < 0 || startHour > 23 || startMinute < 0 || startMinute > 59 || startSecond < 0 || startSecond > 59 ||
                endHour < 0 || endHour > 23 || endMinute < 0 || endMinute > 59 || endSecond < 0 || endSecond > 59) {
            return "Thời gian đầu vào không hợp lệ";
        }
    
        // Chuyển thời gian thành giây
        long startTimeInSeconds = startHour * SECONDS_IN_HOUR + startMinute * SECONDS_IN_MINUTE + startSecond;
        long endTimeInSeconds = endHour * SECONDS_IN_HOUR + endMinute * SECONDS_IN_MINUTE + endSecond;
    
        // Xử lý trường hợp thời gian kết thúc qua ngày hôm sau
        if (endTimeInSeconds < startTimeInSeconds) {
            endTimeInSeconds += 24 * 3600; // Thêm 24 giờ nếu kết thúc qua ngày hôm sau
        }
    
        // Tính thời gian chơi trong giờ, phút và giây
        long totalPlayedSeconds = endTimeInSeconds - startTimeInSeconds;
        int playedHours = (int)(totalPlayedSeconds / SECONDS_IN_HOUR);
        int remainingSeconds = (int)(totalPlayedSeconds % SECONDS_IN_HOUR);
        int playedMinutes = remainingSeconds / SECONDS_IN_MINUTE;
        int playedSeconds = remainingSeconds % SECONDS_IN_MINUTE;
    
        // Tính tiền
        double totalPlayedHours = playedHours + (double)playedMinutes / 60 + (double)playedSeconds / 3600;
        double tableFee = totalPlayedHours * PRICE_PER_HOUR;
    
        return String.valueOf(roundDecimal(tableFee, 2));
    }

    private void restoreInputData(DataHolderTable10 dataHolder, JLabel nameLabel, String colorData) {
        nameLabel.setText(dataHolder.getInputDataName10());
        String[] colorComponents = colorData.split(",");
        if (colorComponents.length == 3) {
            int red = Integer.parseInt(colorComponents[0]);
            int green = Integer.parseInt(colorComponents[1]);
            int blue = Integer.parseInt(colorComponents[2]);
            Color color = new Color(red, green, blue);
            nameLabel.setForeground(color);
        }
    }

}
