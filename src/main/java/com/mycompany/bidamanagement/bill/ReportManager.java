/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement.bill;

import com.mycompany.bidamanagement.printModel.ParameterReportCheckout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author duc
 */
public class ReportManager {
    private static ReportManager instance;
    
    private JasperReport BillUI;
    
    
    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }
    
    private ReportManager () {
    }
    
    public void compileReport() throws JRException, IOException {
//        BillUI = JasperCompileManager.compileReport(getClass().getResourceAsStream("/bill/BillUI.jrxml"));
//        BillInvoice = JasperCompileManager.compileReport(getClass().getResourceAsStream("/bill/report_invoice.jrxml"));
//        try {
//                    // Use try-with-resources to close the input stream automatically
//                    try (InputStream billUIStream = getClass().getResourceAsStream("/bill/BillUI.jrxml")) {
//                        if (billUIStream != null) {
//                            BillUI = JasperCompileManager.compileReport(billUIStream);
//                        } else {
//                            throw new JRException("Failed to load BillUI.jrxml. Resource not found.");
//                        }
//                    }
//
//                    // Uncomment the following code if you need to compile BillInvoice
//                    // try (InputStream billInvoiceStream = getClass().getResourceAsStream("/bill/report_invoice.jrxml")) {
//                    //     if (billInvoiceStream != null) {
//                    //         BillInvoice = JasperCompileManager.compileReport(billInvoiceStream);
//                    //     } else {
//                    //         throw new JRException("Failed to load report_invoice.jrxml. Resource not found.");
//                    //     }
//                    // }
//                } catch (JRException e) {
//                    e.printStackTrace();
//                    // Handle the exception as needed, log or show an error message
//                }
            try {
            // Sử dụng FileInputStream cho đường dẫn tuyệt đối
//            File billUIFile = new File("D:\\Workspace\\Work_desktop\\desktop\\BidaManagement\\src\\main\\java\\com\\mycompany\\bidamanagement\\bill\\BillUI.jrxml");
            JasperDesign billUI = JRXmlLoader.load("D:\\Workspace\\Work_desktop\\desktop\\BidaManagement\\src\\main\\java\\com\\mycompany\\bidamanagement\\bill\\BillUI.jrxml");
                if (billUI != null) {
                    BillUI = JasperCompileManager.compileReport(billUI);
                } else {
                    throw new JRException("Failed to load BillUI.jrxml. Resource not found.");
            }
            }
             catch (JRException e) {
                e.printStackTrace();
            }
    }

    public void printReportPayment(ParameterReportCheckout data) throws JRException {
        Map para = new HashMap();
        para.put("CURRENT_DATE", data.getCURRENT_DATE());
//        para.put("PRO_NAME", data.getPRO_NAME());
//        para.put("QTY", data.getQTY());
//        para.put("PRICE", data.getPRICE());
//        para.put("TOTAL", data.getTOTAL());
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getFields());
        para.put("TOTALBILL", data.getTOTALBILL());
        JasperPrint print = JasperFillManager.fillReport(BillUI, para, dataSource);
        view(print);
    }
//
//    public void printReportInvoice(ParameterReportInvoice data) throws JRException {
//        Map para = new HashMap();
//        para.put("totalQty", data.getTotalQty());
//        para.put("totalAmount", data.getTotalAmount());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getFields());
//        JasperPrint print = JasperFillManager.fillReport(reportInvoice, para, dataSource);
//        view(print);
//    }
//
    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
//    
}
