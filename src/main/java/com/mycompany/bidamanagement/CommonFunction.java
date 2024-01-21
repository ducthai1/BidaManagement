/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;
import java.text.DecimalFormat;
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
            return Double.parseDouble(value.replace(",", "."));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Chuỗi không hợp lệ:" + value);
            throw new NumberFormatException("Chuỗi không hợp lệ: " + value);
        }
    }

    public static String doubleFormattedView(double number) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(number).replace(",", ".");
    }
    
    public static int parseInteger(String value) throws NumberFormatException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ (Số nguyên):" + value);
            throw new NumberFormatException("Chuỗi không hợp lệ: " + value);
        }
    }
}
