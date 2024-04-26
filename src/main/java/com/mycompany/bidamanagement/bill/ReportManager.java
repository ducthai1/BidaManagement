/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement.bill;
//
//import com.mycompany.bidamanagement.printModel.ParameterReportCheckout;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;
//
///**
// *
// * @author duc
// */
//public class ReportManager {
//    private static ReportManager instance;
//    
//    private JasperReport tableBill;
//    
//    
//    public static ReportManager getInstance() {
//        if (instance == null) {
//            instance = new ReportManager();
//        }
//        return instance;
//    }
//    
//    private ReportManager () {
//    }
//    
//    public void compileReport(String link) throws JRException {
//            try {
//                if (link != null) {
//                    tableBill = JasperCompileManager.compileReport(getClass().getResourceAsStream(link));
//                }
//                else {
//                    tableBill = JasperCompileManager.compileReport("/Users/duc/NetBeansProjects/BidaManagement/src/main/java/com/mycompany/bidamanagement/bill/tableBill.jrxml");
//                }
//            }
//             catch (JRException e) {
//                e.printStackTrace();
//            }
//    }
//
//    public void printReportPayment(ParameterReportCheckout data) throws JRException {
//        Map para = new HashMap();
//        para.put("DATE", data.getDATE());
//        para.put("STARTTIME", data.getSTARTTIME());
//        para.put("ENDTIME", data.getENDTIME());
//        para.put("TABLE_FEE", data.getTABLE_FEE());
//        JasperPrint print = JasperFillManager.fillReport(tableBill, para);
//        view(print);
//    }
//    private void view(JasperPrint print) throws JRException {
//        JasperViewer.viewReport(print, false);
//    }   
//}

import com.mycompany.bidamanagement.ConnectXamppMySQL;
import com.mycompany.bidamanagement.printModel.ParameterReportCheckout;
import com.mycompany.bidamanagement.printModel.ParameterReportCheckoutTable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.*;

import javax.swing.*;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import net.sf.jasperreports.view.JasperViewer;

public class ReportManager {
    private static ReportManager instance;
    private JasperReport tableBill;
    private JasperReport tableBillOnlyTable;

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    private ReportManager() {}
    
    public void compileReport() throws JRException {
        try {
            // Load the JRXML file as input stream
            String inputStream2 = "src/main/java/com/mycompany/bidamanagement/table/tableBill.jrxml";
            String inputStream = "src/main/java/com/mycompany/bidamanagement/TableAndBill/tableAndBill.jrxml";
            if (inputStream == null) {
                throw new JRException("Cannot load JRXML file from: " + inputStream);
            }
            // Compile the report
            tableBillOnlyTable = JasperCompileManager.compileReport(inputStream2);
            tableBill = JasperCompileManager.compileReport(inputStream);
        } catch (JRException e) {
            throw new JRException("Failed to compile report: " + e.getMessage(), e);
        }
    }
    
    public void printReportPayment(ParameterReportCheckout data) throws JRException, FileNotFoundException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("tablelogo", new FileInputStream("src/main/java/com/mycompany/bidamanagement/Icon/logoBida120.jpg"));
            parameters.put("DATE", data.getDATE());
            parameters.put("STARTTIME", data.getSTARTTIME());
            parameters.put("ENDTIME", data.getENDTIME());
            parameters.put("TABLE_FEE", data.getTABLE_FEE());
            // Fill the report
            JasperPrint print = JasperFillManager.fillReport(tableBillOnlyTable, parameters, new JREmptyDataSource());

            // View the report
            view(print);
        } catch (JRException e) {
            throw new JRException("Failed to print report: " + e.getMessage(), e);
        }
    }
    Connection conn;
    public void printReportPaymentTable(ParameterReportCheckoutTable data) throws JRException, FileNotFoundException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            conn = ConnectXamppMySQL.conn();
            parameters.put("INVOICEID", data.getINVOICE_ID());
            System.out.println("Daylainvoiceidhientai"+ data.getINVOICE_ID());
            parameters.put("tablelogo", new FileInputStream("src/main/java/com/mycompany/bidamanagement/Icon/logoBida120.jpg"));
            parameters.put("DATE", data.getDATE());
            parameters.put("STARTTIME", data.getSTARTTIME());
            parameters.put("ENDTIME", data.getENDTIME());
            parameters.put("TABLE_FEE", data.getTABLE_FEE());
            // Fill the report
//            JasperPrint print = JasperFillManager.fillReport(tableBill, parameters, new JREmptyDataSource());
            JasperPrint print = JasperFillManager.fillReport(tableBill, parameters, conn);
//            JasperViewer.viewReport(print, false);

            // View the report
            view(print);
        } catch (JRException e) {
            throw new JRException("Failed to print report: " + e.getMessage(), e);
        }
    }
    
    private void view(JasperPrint print) throws JRException {
        // Display the report in a JasperViewer
        JasperViewer.viewReport(print, false);
    }
}

