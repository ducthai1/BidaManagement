/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bidamanagement;

import com.mycompany.bidamanagement.bill.ReportManager40;
import com.mycompany.bidamanagement.printModel.FieldReportCheckout;
import com.mycompany.bidamanagement.printModel.ParameterReportCheckout;
import com.mycompany.bidamanagement.printModel.ParameterReportCheckoutTable;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Table4AndCheckOut extends javax.swing.JFrame {

    Connection conn;
    static Statement st = null;
    static ResultSet rs = null;
    ArrayList<BillItem> billItems = new ArrayList<>();
    BillItem billItem = new BillItem();
    int i = 0;
    Double Uprice, TotalPrice=0.0, TotalBill=0.0;
    int AvailQty;    
    // Xử dụng lớp Singleton để lưu trữ biến inputData Table 1
    
    private int startHourTable4, startMinuteTable4, startSecondTable4;
    private int endHourTable4, endMinuteTable4, endSecondTable4;
    
    private DataHolderTable1 dataHolderTable1 = DataHolderTable1.getInstanceTable1();
    private DataHolderTable2 dataHolderTable2 = DataHolderTable2.getInstanceTable2();
    private DataHolderTable3 dataHolderTable3 = DataHolderTable3.getInstanceTable3();
    private DataHolderTable4 dataHolderTable4 = DataHolderTable4.getInstanceTable4();
    private DataHolderTable5 dataHolderTable5 = DataHolderTable5.getInstanceTable5();
    private DataHolderTable6 dataHolderTable6 = DataHolderTable6.getInstanceTable6();
    private DataHolderTable7 dataHolderTable7 = DataHolderTable7.getInstanceTable7();
    private DataHolderTable8 dataHolderTable8 = DataHolderTable8.getInstanceTable8();
    private DataHolderTable9 dataHolderTable9 = DataHolderTable9.getInstanceTable9();
    private DataHolderTable10 dataHolderTable10 = DataHolderTable10.getInstanceTable10();

    public Table4AndCheckOut() {
        initComponents();
        restoreInputDataTable1();
        restoreInputDataTable2();
        restoreInputDataTable3();
        restoreInputDataTable4();
        restoreInputDataTable5();
        restoreInputDataTable6();
        restoreInputDataTable7();
        restoreInputDataTable8();
        restoreBillTable4();
        try {
            ReportManager40.getInstance().compileReport();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
        if ("".equals(NameTable4.getText())) {
            NameTable4.setText("BÀN 4");
        }

        if ("".equals(Name1.getText())) {
            Name1.setText("BÀN 1");
        }
        if ("".equals(Name2.getText())) {
            Name2.setText("BÀN 2");
        }
        if ("".equals(Name3.getText())) {
            Name3.setText("BÀN 3");
        }
        if ("".equals(Name4.getText())) {
            Name4.setText("BÀN 4");
        }
        if ("".equals(Name5.getText())) {
            Name5.setText("BÀN 5");
        }
        if ("".equals(Name6.getText())) {
            Name6.setText("BÀN 6");
        }
        if ("".equals(Name7.getText())) {
            Name7.setText("BÀN 7");
        }
        if ("".equals(Name8.getText())) {
            Name8.setText("BÀN 8");
        }
        SelectBill();
        getCategory();
        updateTotalBill();
    }
    
    private void updateTotalBill() {
            try {
                PreparedStatement updateInvoice = conn.prepareStatement("UPDATE invoices AS i SET i.TOTAL_BILL = (SELECT ROUND(SUM(id.TOTAL), 2) FROM invoice_details AS id WHERE id.INVOICEID = i.INVOICEID) WHERE EXISTS ( SELECT 1 FROM invoice_details AS id WHERE id.INVOICEID = i.INVOICEID)");
                int rowsUpdated = updateInvoice.executeUpdate();
                if (rowsUpdated > 0) {
//                    JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thành công!");
                } else {
//                    JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được cập nhật!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật hóa đơn!");
            }
    }
    
    private void restoreInputDataTable1() {
        Name1.setText(dataHolderTable1.getInputDataName1());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable1.getInputColorDataNameTable1();
        String colorAsString2 = dataHolderTable1.getInputColorDataName1();
        String[] colorComponents1 = colorAsString1.split(",");
        if (colorComponents1.length == 3) {
            int red = Integer.parseInt(colorComponents1[0]);
            int green = Integer.parseInt(colorComponents1[1]);
            int blue = Integer.parseInt(colorComponents1[2]);
            Color color1 = new Color(red, green, blue);
            Name1.setForeground(color1);
        }
    }
    

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreInputDataTable2() {
        Name2.setText(dataHolderTable2.getInputDataName2());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable2.getInputColorDataNameTable2();
        String colorAsString2 = dataHolderTable2.getInputColorDataName2();
        String[] colorComponents2 = colorAsString1.split(",");
        if (colorComponents2.length == 3) {
            int red = Integer.parseInt(colorComponents2[0]);
            int green = Integer.parseInt(colorComponents2[1]);
            int blue = Integer.parseInt(colorComponents2[2]);
            Color color2 = new Color(red, green, blue);
            Name2.setForeground(color2);
        }
    }
    
    private void restoreInputDataTable3() {
        Name3.setText(dataHolderTable3.getInputDataName3());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable3.getInputColorDataNameTable3();
        String colorAsString2 = dataHolderTable3.getInputColorDataName3();
        String[] colorComponents3 = colorAsString1.split(",");
        if (colorComponents3.length == 3) {
            int red = Integer.parseInt(colorComponents3[0]);
            int green = Integer.parseInt(colorComponents3[1]);
            int blue = Integer.parseInt(colorComponents3[2]);
            Color color3 = new Color(red, green, blue);
            Name3.setForeground(color3);
        }
    }
    
    private void saveInputDataTable4() {
        dataHolderTable4.setInputDataSTARTTable4(TIMESTART4.getText());
        dataHolderTable4.setInputDataENDTable4(TIMEEND4.getText());
        dataHolderTable4.setInputDataNameTable4(NameTable4.getText());
        dataHolderTable4.setInputDataName4(Name4.getText());
        // Chuyển đổi màu sắc của Table4Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable4.getForeground();
        Color color2 = Name4.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable4.setInputColorDataNameTable4(colorAsString);
        String colorAsString2 = String.format("%d,%d,%d", color2.getRed(), color2.getGreen(), color2.getBlue());
        dataHolderTable4.setInputColorDataName4(colorAsString2);
        dataHolderTable4.setStartBtnEnabledTable4(StartBtnTable4.isEnabled());
        dataHolderTable4.setStopBtnEnabledTable4(StopBtnTable4.isEnabled());
        dataHolderTable4.setPrintBtnEnabledTable4(PrintBtnTable4.isEnabled());

        dataHolderTable4.setStartHourTable4(startHourTable4);
        dataHolderTable4.setStartMinuteTable4(startMinuteTable4);
        dataHolderTable4.setStartSecondTable4(startSecondTable4);
        dataHolderTable4.setEndHourTable4(endHourTable4);
        dataHolderTable4.setEndMinuteTable4(endMinuteTable4);
        dataHolderTable4.setEndSecondTable4(endSecondTable4);
        
        dataHolderTable4.setAddBtnEnabledTable4(AddBtnTable4.isEnabled());

    }

    
    private void restoreInputDataTable4() {
        TIMESTART4.setText(dataHolderTable4.getInputDataSTARTTable4());
        TIMEEND4.setText(dataHolderTable4.getInputDataENDTable4());
        NameTable4.setText(dataHolderTable4.getInputDataNameTable4());
        Name4.setText(dataHolderTable4.getInputDataName4());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable4.getInputColorDataNameTable4();
        String colorAsString2 = dataHolderTable4.getInputColorDataName4();
        String[] colorComponents4 = colorAsString1.split(",");
        if (colorComponents4.length == 3) {
            int red = Integer.parseInt(colorComponents4[0]);
            int green = Integer.parseInt(colorComponents4[1]);
            int blue = Integer.parseInt(colorComponents4[2]);
            Color color1 = new Color(red, green, blue);
            NameTable4.setForeground(color1);
            Name4.setForeground(color1);
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
        
        AddBtnTable4.setEnabled(dataHolderTable4.isAddBtnEnabledTable4());

    }

    private void restoreInputDataTable5() {
        Name5.setText(dataHolderTable5.getInputDataName5());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable5.getInputColorDataNameTable5();
        String colorAsString2 = dataHolderTable5.getInputColorDataName5();
        String[] colorComponents5 = colorAsString1.split(",");
        if (colorComponents5.length == 3) {
            int red = Integer.parseInt(colorComponents5[0]);
            int green = Integer.parseInt(colorComponents5[1]);
            int blue = Integer.parseInt(colorComponents5[2]);
            Color color5 = new Color(red, green, blue);
            Name5.setForeground(color5);
        }
    }

    private void restoreInputDataTable6() {
        Name6.setText(dataHolderTable6.getInputDataName6());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable6.getInputColorDataNameTable6();
        String colorAsString2 = dataHolderTable6.getInputColorDataName6();
        String[] colorComponents6 = colorAsString1.split(",");
        if (colorComponents6.length == 3) {
            int red = Integer.parseInt(colorComponents6[0]);
            int green = Integer.parseInt(colorComponents6[1]);
            int blue = Integer.parseInt(colorComponents6[2]);
            Color color6 = new Color(red, green, blue);
            Name6.setForeground(color6);
        }
    }

    private void restoreInputDataTable7() {
        Name7.setText(dataHolderTable7.getInputDataName7());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable7.getInputColorDataNameTable7();
        String colorAsString2 = dataHolderTable7.getInputColorDataName7();
        String[] colorComponents7 = colorAsString1.split(",");
        if (colorComponents7.length == 3) {
            int red = Integer.parseInt(colorComponents7[0]);
            int green = Integer.parseInt(colorComponents7[1]);
            int blue = Integer.parseInt(colorComponents7[2]);
            Color color7 = new Color(red, green, blue);
            Name7.setForeground(color7);
        }
    }

    private void restoreInputDataTable8() {
        Name8.setText(dataHolderTable8.getInputDataName8());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable8.getInputColorDataNameTable8();
        String colorAsString2 = dataHolderTable8.getInputColorDataName8();
        String[] colorComponents8 = colorAsString1.split(",");
        if (colorComponents8.length == 3) {
            int red = Integer.parseInt(colorComponents8[0]);
            int green = Integer.parseInt(colorComponents8[1]);
            int blue = Integer.parseInt(colorComponents8[2]);
            Color color8 = new Color(red, green, blue);
            Name8.setForeground(color8);
        }
    }
    
    public void SelectBill() {
        try {
            conn = ConnectXamppMySQL.conn();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM products");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("MÃ SP");
            model.addColumn("TÊN SP");
            model.addColumn("SỐ LƯỢNG TRONG KHO");
            model.addColumn("GIÁ");
            model.addColumn("DANH MỤC SP");
            while (rs.next()) {
                Object[] row = {
                    rs.getString("PRODID"),
                    rs.getString("PRODNAME"),
                    rs.getInt("PRODQTY"),
                    CommonFunction.doubleFormattedView(rs.getDouble("PRODPRICE")),
                    rs.getString("PRODCAT")
                };
                model.addRow(row);
            }
            PRODLIST.setModel(model);

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static double roundDecimal(double number, int decimalPlaces) {
        // Định dạng cho số với số lẻ giới hạn
//        String pattern = "#." + new String(new char[decimalPlaces]).replace("\0", "#");
//        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        // Làm tròn và trả về giá trị
//        String formattedNumber = decimalFormat.format(number);
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(number * scale) / scale;
    }
    
    public void getCategory() {
        try {
            conn = ConnectXamppMySQL.conn();
            st = conn.createStatement();
            String Query = "SELECT * FROM category";
            rs = st.executeQuery(Query);
            while(rs.next()){
                String MyCategory = rs.getString("CatName");
                PRODCAT.addItem(MyCategory);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateStock(int PRODUCTSELL) {
        try{
                conn = ConnectXamppMySQL.conn();
                String query = "UPDATE products SET PRODQTY = PRODQTY - " + PRODUCTSELL + " WHERE PRODNAME='" + PRODNAME.getText() + "'";
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
                SelectBill();
            }
            catch(Exception e){
               e.printStackTrace();
               JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public void printBill(int invoiceid) {
        try {
            System.out.println("invoiceId: " + invoiceid);
            Hashtable map = new Hashtable();
            JasperReport reportBill = JasperCompileManager.compileReport("src/main/java/com/mycompany/bidamanagement/bill/reportBill.jrxml");
            map.put("INVOICEID", invoiceid);
            map.put("logo", new FileInputStream("src/main/java/com/mycompany/bidamanagement/Icon/logoBida120.jpg"));
            
            JasperPrint print = JasperFillManager.fillReport(reportBill, map, conn); 
            JasperViewer.viewReport(print, false);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private BillTable4 billTable4 = BillTable4.getInstanceTable4();
    private boolean checkTrueBillDetailTable4 = false;
    private int invoiceIdTable4;
    private int soLanBamAddTable4;
    private double saveBillPriceTable4;

    // Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveBillTable4() {
        billTable4.setBillReviewTable4(BillReview.getText());
        billTable4.setIsBillIdDetailTable4(checkTrueBillDetailTable4);
        billTable4.setInvoiceIdTable4(invoiceIdTable4);
        billTable4.setSoLanBamAddTable4(soLanBamAddTable4);
        billTable4.setSaveBillPriceTable4(saveBillPriceTable4);
    }

    // Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreBillTable4() {
        BillReview.setText(billTable4.getBillReviewTable4());
        checkTrueBillDetailTable4 = billTable4.isBillIdDetailTable4();
        invoiceIdTable4 = billTable4.getInvoiceIdTable4();
        soLanBamAddTable4 = billTable4.getSoLanBamAddTable4();
        TotalBill = billTable4.getSaveBillPriceTable4();
        TotalBillRender.setText("TỔNG CỘNG: " + CommonFunction.doubleFormattedView(TotalBill));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PRODNAME = new javax.swing.JTextField();
        PRODQTY = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AddBtnTable4 = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        table1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        NameTable4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SDTKH4 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TIMESTART4 = new javax.swing.JTextField();
        jPanel67 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        TIMEEND4 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        StartBtnTable4 = new javax.swing.JButton();
        StopBtnTable4 = new javax.swing.JButton();
        PrintBtnTable4 = new javax.swing.JButton();
        ResetBtnTable4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PRODLIST = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillReview = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        TotalBillRender = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PRODCAT = new javax.swing.JComboBox<>();
        filterBtn = new javax.swing.JButton();
        ReloadBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LogoutBtn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PlayTable1Btn = new javax.swing.JPanel();
        Name1 = new javax.swing.JLabel();
        PlayTable2Btn = new javax.swing.JPanel();
        Name2 = new javax.swing.JLabel();
        PlayTable3Btn = new javax.swing.JPanel();
        Name3 = new javax.swing.JLabel();
        PlayTable4Btn = new javax.swing.JPanel();
        Name4 = new javax.swing.JLabel();
        PlayTable5Btn = new javax.swing.JPanel();
        Name5 = new javax.swing.JLabel();
        PlayTable6Btn = new javax.swing.JPanel();
        Name6 = new javax.swing.JLabel();
        PlayTable7Btn = new javax.swing.JPanel();
        Name7 = new javax.swing.JLabel();
        PlayTable8Btn = new javax.swing.JPanel();
        Name8 = new javax.swing.JLabel();
        SwapNormalBtn = new javax.swing.JPanel();
        Normal = new javax.swing.JLabel();
        SwapVipBtn = new javax.swing.JPanel();
        VIP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(110, 178, 246));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(110, 178, 246));
        jLabel10.setText("THANH TOÁN");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(176, 211, 246));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(110, 178, 246));
        jLabel5.setText("TÊN SP");

        PRODNAME.setEditable(false);
        PRODNAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODNAME.setForeground(new java.awt.Color(110, 178, 246));
        PRODNAME.setEnabled(false);
        PRODNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRODNAMEActionPerformed(evt);
            }
        });

        PRODQTY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODQTY.setForeground(new java.awt.Color(110, 178, 246));
        PRODQTY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRODQTYActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(176, 211, 246));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(110, 178, 246));
        jLabel6.setText("SỐ LƯỢNG");

        AddBtnTable4.setBackground(new java.awt.Color(110, 178, 246));
        AddBtnTable4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddBtnTable4.setForeground(new java.awt.Color(255, 255, 255));
        AddBtnTable4.setText("THÊM");
        AddBtnTable4.setBorder(null);
        AddBtnTable4.setBorderPainted(false);
        AddBtnTable4.setEnabled(false);
        AddBtnTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnTable4MouseClicked(evt);
            }
        });
        AddBtnTable4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnTable4ActionPerformed(evt);
            }
        });

        ClearBtn.setBackground(new java.awt.Color(110, 178, 246));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("CLEAR");
        ClearBtn.setBorder(null);
        ClearBtn.setBorderPainted(false);
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        table1.setBackground(new java.awt.Color(102, 204, 0));
        table1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 204)));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));

        NameTable4.setBackground(new java.awt.Color(249, 249, 249));
        NameTable4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable4.setText("BÀN 4");
        NameTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SĐT KH");

        SDTKH4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH4)
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GIỜ CHƠI");

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

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART4)
                .addContainerGap())
        );

        jPanel67.setBackground(new java.awt.Color(102, 204, 0));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("GIỜ NGHỈ");

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

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND4)
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

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(ResetBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(PRODQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(AddBtnTable4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PRODNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(table1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRODNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRODQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtnTable4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addComponent(table1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(127, 127, 127))
        );

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(110, 178, 246));
        jLabel11.setText("DANH SÁCH SẢN PHẨM");

        PRODLIST.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PRODLIST.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ SP", "TÊN SP", "SỐ LƯỢNG", "GIÁ", "LOẠI SP"
            }
        ));
        PRODLIST.setRowHeight(30);
        PRODLIST.setSelectionBackground(new java.awt.Color(219, 229, 238));
        PRODLIST.setSelectionForeground(new java.awt.Color(255, 255, 255));
        PRODLIST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PRODLISTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PRODLIST);

        BillReview.setColumns(20);
        BillReview.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BillReview.setRows(5);
        jScrollPane2.setViewportView(BillReview);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(207, 207, 207)));

        TotalBillRender.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TotalBillRender.setForeground(new java.awt.Color(255, 0, 0));
        TotalBillRender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalBillRender.setText("TỔNG CỘNG: 0.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TotalBillRender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(TotalBillRender, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(176, 211, 246));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(110, 178, 246));
        jLabel2.setText("LỌC THEO DANH MỤC SẢN PHẨM");

        PRODCAT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRODCAT.setForeground(new java.awt.Color(110, 178, 246));
        PRODCAT.setBorder(null);
        PRODCAT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PRODCATItemStateChanged(evt);
            }
        });
        PRODCAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PRODCATMouseClicked(evt);
            }
        });

        filterBtn.setBackground(new java.awt.Color(110, 178, 246));
        filterBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        filterBtn.setForeground(new java.awt.Color(255, 255, 255));
        filterBtn.setText("LỌC");
        filterBtn.setBorder(null);
        filterBtn.setBorderPainted(false);
        filterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterBtnMouseClicked(evt);
            }
        });
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        ReloadBtn.setBackground(new java.awt.Color(110, 178, 246));
        ReloadBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReloadBtn.setForeground(new java.awt.Color(255, 255, 255));
        ReloadBtn.setText("TẢI LẠI");
        ReloadBtn.setBorder(null);
        ReloadBtn.setBorderPainted(false);
        ReloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReloadBtnMouseClicked(evt);
            }
        });
        ReloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReloadBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(PRODCAT, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PRODCAT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(206, 206, 206))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(520, 520, 520)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(110, 178, 246));

        LogoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        PlayTable1Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable1Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable1BtnMouseClicked(evt);
            }
        });

        Name1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name1.setText("BÀN 1");

        javax.swing.GroupLayout PlayTable1BtnLayout = new javax.swing.GroupLayout(PlayTable1Btn);
        PlayTable1Btn.setLayout(PlayTable1BtnLayout);
        PlayTable1BtnLayout.setHorizontalGroup(
            PlayTable1BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable1BtnLayout.setVerticalGroup(
            PlayTable1BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable2Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable2Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable2BtnMouseClicked(evt);
            }
        });

        Name2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name2.setText("BÀN 2");

        javax.swing.GroupLayout PlayTable2BtnLayout = new javax.swing.GroupLayout(PlayTable2Btn);
        PlayTable2Btn.setLayout(PlayTable2BtnLayout);
        PlayTable2BtnLayout.setHorizontalGroup(
            PlayTable2BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable2BtnLayout.setVerticalGroup(
            PlayTable2BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable3Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable3Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable3BtnMouseClicked(evt);
            }
        });

        Name3.setBackground(new java.awt.Color(255, 255, 255));
        Name3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name3.setText("BÀN 3");

        javax.swing.GroupLayout PlayTable3BtnLayout = new javax.swing.GroupLayout(PlayTable3Btn);
        PlayTable3Btn.setLayout(PlayTable3BtnLayout);
        PlayTable3BtnLayout.setHorizontalGroup(
            PlayTable3BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable3BtnLayout.setVerticalGroup(
            PlayTable3BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable4Btn.setBackground(new java.awt.Color(204, 204, 204));
        PlayTable4Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable4BtnMouseClicked(evt);
            }
        });

        Name4.setBackground(new java.awt.Color(255, 255, 255));
        Name4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name4.setText("BÀN 4");

        javax.swing.GroupLayout PlayTable4BtnLayout = new javax.swing.GroupLayout(PlayTable4Btn);
        PlayTable4Btn.setLayout(PlayTable4BtnLayout);
        PlayTable4BtnLayout.setHorizontalGroup(
            PlayTable4BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable4BtnLayout.setVerticalGroup(
            PlayTable4BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable5Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable5Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable5BtnMouseClicked(evt);
            }
        });

        Name5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name5.setText("BÀN 5");

        javax.swing.GroupLayout PlayTable5BtnLayout = new javax.swing.GroupLayout(PlayTable5Btn);
        PlayTable5Btn.setLayout(PlayTable5BtnLayout);
        PlayTable5BtnLayout.setHorizontalGroup(
            PlayTable5BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable5BtnLayout.setVerticalGroup(
            PlayTable5BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable6Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable6Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable6BtnMouseClicked(evt);
            }
        });

        Name6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name6.setText("BÀN 6");

        javax.swing.GroupLayout PlayTable6BtnLayout = new javax.swing.GroupLayout(PlayTable6Btn);
        PlayTable6Btn.setLayout(PlayTable6BtnLayout);
        PlayTable6BtnLayout.setHorizontalGroup(
            PlayTable6BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable6BtnLayout.setVerticalGroup(
            PlayTable6BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable7Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable7Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable7BtnMouseClicked(evt);
            }
        });

        Name7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name7.setText("BÀN 7");

        javax.swing.GroupLayout PlayTable7BtnLayout = new javax.swing.GroupLayout(PlayTable7Btn);
        PlayTable7Btn.setLayout(PlayTable7BtnLayout);
        PlayTable7BtnLayout.setHorizontalGroup(
            PlayTable7BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable7BtnLayout.setVerticalGroup(
            PlayTable7BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable8Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable8Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable8BtnMouseClicked(evt);
            }
        });

        Name8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name8.setText("BÀN 8");

        javax.swing.GroupLayout PlayTable8BtnLayout = new javax.swing.GroupLayout(PlayTable8Btn);
        PlayTable8Btn.setLayout(PlayTable8BtnLayout);
        PlayTable8BtnLayout.setHorizontalGroup(
            PlayTable8BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable8BtnLayout.setVerticalGroup(
            PlayTable8BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        SwapNormalBtn.setBackground(new java.awt.Color(0, 102, 153));
        SwapNormalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SwapNormalBtnMouseClicked(evt);
            }
        });

        Normal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Normal.setForeground(new java.awt.Color(255, 255, 255));
        Normal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Normal.setText("THƯỜNG");

        javax.swing.GroupLayout SwapNormalBtnLayout = new javax.swing.GroupLayout(SwapNormalBtn);
        SwapNormalBtn.setLayout(SwapNormalBtnLayout);
        SwapNormalBtnLayout.setHorizontalGroup(
            SwapNormalBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Normal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SwapNormalBtnLayout.setVerticalGroup(
            SwapNormalBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Normal, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        SwapVipBtn.setBackground(new java.awt.Color(255, 255, 255));
        SwapVipBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SwapVipBtnMouseClicked(evt);
            }
        });

        VIP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        VIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VIP.setText("VIP");

        javax.swing.GroupLayout SwapVipBtnLayout = new javax.swing.GroupLayout(SwapVipBtn);
        SwapVipBtn.setLayout(SwapVipBtnLayout);
        SwapVipBtnLayout.setHorizontalGroup(
            SwapVipBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );
        SwapVipBtnLayout.setVerticalGroup(
            SwapVipBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VIP, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PlayTable2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable3Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable1Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable5Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable6Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable4Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable8Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable7Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SwapNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SwapVipBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SwapNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SwapVipBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(PlayTable1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable3Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable4Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable5Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable6Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable7Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable8Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PRODNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRODNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRODNAMEActionPerformed

    private void PRODQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRODQTYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRODQTYActionPerformed

    private void AddBtnTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnTable4MouseClicked
        if (AddBtnTable4.isEnabled()) {
        Date currentDate = new Date();
        if(PRODQTY.getText().isEmpty() || PRODNAME.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để thêm vào bill!");
        }
        else if (CommonFunction.parseInteger(PRODQTY.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng sản phẩm muốn bán là số lớn hơn 0!");
        }
        else if (AvailQty < CommonFunction.parseInteger(PRODQTY.getText())){
            JOptionPane.showMessageDialog(this, "Trong kho không có đủ số lượng sản phẩm!");
        }
        else{
            soLanBamAddTable4++;
            int QTY = CommonFunction.parseInteger(PRODQTY.getText());
            int PRODUCTSELL = QTY;
            TotalPrice = roundDecimal(Uprice * Double.valueOf(PRODQTY.getText()),2);
            TotalBill = roundDecimal((TotalBill + TotalPrice), 2);
            
            saveBillPriceTable4 = TotalBill;
            // Kiểm tra nếu sản phẩm đã tồn tại trong danh sách mua hàng
            boolean productExists = false;
            for (BillItem item : billItems) {
                if (item.getProductName().equals(PRODNAME.getText())) {
                    // Sản phẩm đã tồn tại, tăng số lượng
                    item.setQuantity(item.getQuantity() + QTY);
                    item.setTotalBill(item.getTotalBill() + TotalPrice);
                    productExists = true;
                    break;
                }
            }

            if (!productExists) {
                // Sản phẩm chưa tồn tại trong danh sách mua hàng, thêm mới
                BillItem newItem = new BillItem();
                newItem.setProductName(PRODNAME.getText());
                newItem.setQuantity(QTY);
                newItem.setTotalPrice(Uprice);
                newItem.setTotalBill(TotalPrice);
                newItem.setOrderDate(currentDate);
                billItems.add(newItem);
            }
            // Hiển thị thông tin trong TextArea
            if (soLanBamAddTable4 == 1) {
                BillReview.setText(BillReview.getText()+"\n"+"            "+PRODNAME.getText()+"             "+CommonFunction.doubleFormattedView(Uprice)+
                    "              "+PRODUCTSELL+"                     "+CommonFunction.doubleFormattedView(TotalPrice)+"\n");

                try {
                    Date currentDateFirst = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                    PreparedStatement addInvoice = conn.prepareStatement("INSERT INTO invoices (DATE, TOTAL_BILL) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
                    addInvoice.setString(1, dateFormat.format(currentDateFirst));
                    addInvoice.setString(2, CommonFunction.doubleFormattedView(0));

                    int affectedRows = addInvoice.executeUpdate();

                    if (affectedRows == 0) {
                        throw new SQLException("Thêm hóa đơn thất bại, không có bản ghi nào được tạo.");
                    }
                    // Lấy ID của hóa đơn vừa thêm vào
                    ResultSet result = addInvoice.executeQuery("SELECT LAST_INSERT_ID() as ID");
                    if (result.next()) {
                        int currentInvoice = result.getInt("ID");
                        invoiceIdTable4 = currentInvoice;
                        System.out.println("currentInvoiceID: " + invoiceIdTable4);
                        PreparedStatement addInvoiceDetail = conn.prepareStatement("INSERT INTO invoice_details (INVOICEID, PRODNAME, QUANTITY, PRICE, TOTAL) VALUES (?, ?, ?, ?, ?)");
                        addInvoiceDetail.setInt(1, invoiceIdTable4);
                        addInvoiceDetail.setString(2, PRODNAME.getText());
                        addInvoiceDetail.setInt(3, Integer.parseInt(PRODQTY.getText()));
                        addInvoiceDetail.setDouble(4, Uprice);
                        addInvoiceDetail.setDouble(5, TotalPrice);
                        addInvoiceDetail.executeUpdate();
                        updateTotalBill();
                    } else {
                        throw new SQLException("Thêm hóa đơn thất bại, không có ID được tạo.");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                BillReview.setText(BillReview.getText()+"\n"+"            "+PRODNAME.getText()+"             "+
                    CommonFunction.doubleFormattedView(Uprice)+"              "+PRODUCTSELL+"                     "+
                    CommonFunction.doubleFormattedView(TotalPrice)+"\n");
                try {
                    // Kiểm tra sản phẩm đã tồn tại trong invoice_details chưa
                    PreparedStatement checkExistingProduct = conn.prepareStatement("SELECT QUANTITY, TOTAL FROM invoice_details WHERE INVOICEID = ? AND PRODNAME = ?");
                    checkExistingProduct.setInt(1, invoiceIdTable4);
                    checkExistingProduct.setString(2, PRODNAME.getText());
                    ResultSet existingProductResult = checkExistingProduct.executeQuery();

                    if (existingProductResult.next()) {
                        // Nếu sản phẩm đã tồn tại, cập nhật số lượng và tổng giá trị
                        int currentQty = existingProductResult.getInt("QUANTITY");
                        double currentTotal = existingProductResult.getDouble("TOTAL");

                        // Cập nhật số lượng và tổng giá trị mới
                        int newQty = currentQty + QTY;
                        double newTotal = roundDecimal(currentTotal + TotalPrice,2);

                        // Cập nhật trong database
                        PreparedStatement updateInvoiceDetail = conn.prepareStatement("UPDATE invoice_details SET QUANTITY = ?, TOTAL = ? WHERE INVOICEID = ? AND PRODNAME = ?");
                        updateInvoiceDetail.setInt(1, newQty);
                        updateInvoiceDetail.setDouble(2, newTotal);
                        updateInvoiceDetail.setInt(3, invoiceIdTable4);
                        updateInvoiceDetail.setString(4, PRODNAME.getText());
                        updateInvoiceDetail.executeUpdate();
                        updateTotalBill();
                    } else {
                        // Nếu sản phẩm chưa tồn tại, thêm mới vào invoice_details
                        PreparedStatement addInvoiceDetail = conn.prepareStatement("INSERT INTO invoice_details (INVOICEID, PRODNAME, QUANTITY, PRICE, TOTAL) VALUES (?, ?, ?, ?, ?)");
                        addInvoiceDetail.setInt(1, invoiceIdTable4);
                        addInvoiceDetail.setString(2, PRODNAME.getText());
                        addInvoiceDetail.setInt(3, QTY);
                        addInvoiceDetail.setDouble(4, Uprice);
                        addInvoiceDetail.setDouble(5, TotalPrice);
                        addInvoiceDetail.executeUpdate();
                        updateTotalBill();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }

            }

            TotalBillRender.setText("TỔNG CỘNG: "+CommonFunction.doubleFormattedView(TotalBill));
            AvailQty -= PRODUCTSELL;

            // Cập nhật kho hàng
            updateStock(PRODUCTSELL);
            checkTrueBillDetailTable4 = true;
            saveBillTable4();
        }
    }

    }//GEN-LAST:event_AddBtnTable4MouseClicked

    private void AddBtnTable4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnTable4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnTable4ActionPerformed

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        PRODNAME.setText("");
        PRODQTY.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void NameTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable4MouseClicked

    }//GEN-LAST:event_NameTable4MouseClicked

    private void TIMESTART4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART4ActionPerformed

    }//GEN-LAST:event_TIMESTART4ActionPerformed

    private void TIMEEND4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND4ActionPerformed

    private void StartBtnTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable4MouseClicked

    private void StartBtnTable4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable4ActionPerformed

        Date currentStartTable1 = new Date();
        SimpleDateFormat startFormatTable1 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable1 = startFormatTable1.format(currentStartTable1);
        TIMESTART4.setText(formatStartTable1);
        NameTable4.setText("BÀN 4 (ĐANG CHƠI)");
        Name4.setText("BÀN 4 (ĐANG CHƠI)");
        NameTable4.setForeground(Color.RED);
        Name4.setForeground(Color.RED);

        StartBtnTable4.setEnabled(false);
        StopBtnTable4.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable1);

        startHourTable4 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable4 = cal.get(Calendar.MINUTE);
        startSecondTable4 = cal.get(Calendar.SECOND);
        
        AddBtnTable4.setEnabled(true);
        
        saveInputDataTable4();
    }//GEN-LAST:event_StartBtnTable4ActionPerformed

    private void StopBtnTable4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable4ActionPerformed

        Date currentStopTable1 = new Date();
        SimpleDateFormat dateStopFormatTable1 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable1 = dateStopFormatTable1.format(currentStopTable1);
        TIMEEND4.setText(formatStopTable1);
        NameTable4.setText("BÀN 4 (ĐANG TÍNH TIỀN)");
        NameTable4.setForeground(Color.YELLOW);
        Name4.setText("BÀN 4 (ĐANG TÍNH TIỀN)");
        Name4.setForeground(Color.YELLOW);
        StopBtnTable4.setEnabled(false);
        PrintBtnTable4.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable1);

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
        String TableFee4 = CommonFunction.calculateTimePlayTablePrice40(startHourTable4, startMinuteTable4, startSecondTable4, endHourTable4, endMinuteTable4, endSecondTable4);
        Double totalFeeBill = Double.parseDouble(TableFee4) + TotalBill;
        String convertTotalFeeToString = CommonFunction.doubleFormattedView(totalFeeBill);
        System.out.println("totalfee: "+TableFee4 + " savePrice: " + TotalBill +" totalBill: "+ convertTotalFeeToString);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH4.getText());
            addTableBill.setString(2, formatPrintTable4);
            addTableBill.setString(3, TIMESTART4.getText());
            addTableBill.setString(4, TIMEEND4.getText());
            addTableBill.setString(5, TableFee4);
            addTableBill.setInt(6, 4);
            addTableBill.executeUpdate();

            if(soLanBamAddTable4 > 0) {
                ParameterReportCheckoutTable dataprint4 = new ParameterReportCheckoutTable(formatPrintTable4, TIMESTART4.getText(), TIMEEND4.getText(), TableFee4, invoiceIdTable4, convertTotalFeeToString);
                ReportManager40.getInstance().printReportPaymentTable(dataprint4);
            }
            else {
                ParameterReportCheckout dataprint4 = new ParameterReportCheckout(formatPrintTable4, TIMESTART4.getText(), TIMEEND4.getText(), TableFee4);
                ReportManager40.getInstance().printReportPayment(dataprint4);
            }


            PrintBtnTable4.setEnabled(false);
            NameTable4.setText("BÀN 4");
            NameTable4.setForeground(Color.BLACK);
            Name4.setText("BÀN 4");
            Name4.setForeground(Color.BLACK);
            StartBtnTable4.setEnabled(true);
            StopBtnTable4.setEnabled(false);
            TIMESTART4.setText("");
            TIMEEND4.setText("");
            SDTKH4.setText("");
            AddBtnTable4.setEnabled(false);
            saveInputDataTable4();
            System.out.println("Start time: " + startHourTable4 + ":" + startMinuteTable4 + ":" + startSecondTable4);
            System.out.println("End time: " + endHourTable4 + ":" + endMinuteTable4 + ":" + endSecondTable4);


            // Xu ly cho ca table va bill
            checkTrueBillDetailTable4 = false;
            PRODNAME.setText("");
            PRODQTY.setText("");
            BillReview.setText("");
            soLanBamAddTable4 = 0;
            saveBillPriceTable4 = 0.0;
            TotalBill = 0.0;
            TotalBillRender.setText("TỔNG CỘNG: 0.00");
            saveBillTable4();

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
            Name4.setText("BÀN 4");
            Name4.setForeground(Color.BLACK);
            StartBtnTable4.setEnabled(true);
            StopBtnTable4.setEnabled(false);
            PrintBtnTable4.setEnabled(false);
            AddBtnTable4.setEnabled(false);
            saveInputDataTable4();
            
            checkTrueBillDetailTable4 = false;
            PRODNAME.setText("");
            PRODQTY.setText("");
            BillReview.setText("");
            soLanBamAddTable4 = 0;

            saveBillPriceTable4 = 0.0;
            TotalBill = 0.0;
            TotalBillRender.setText("TỔNG CỘNG: 0.00");
            saveBillTable4();

        }
    }//GEN-LAST:event_ResetBtnTable4ActionPerformed

    private void PRODLISTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODLISTMouseClicked
        DefaultTableModel model = (DefaultTableModel) PRODLIST.getModel();
        int Myindex = PRODLIST.getSelectedRow();
        //        PRODID.setText(model.getValueAt(Myindex, 0).toString());
        AvailQty = Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        PRODNAME.setText(model.getValueAt(Myindex, 1).toString());
        String priceString = model.getValueAt(Myindex, 3).toString();
        if (!priceString.isEmpty()) {
            Uprice = Double.valueOf(priceString);
        }
        TotalPrice = roundDecimal(Uprice * Double.valueOf(PRODQTY.getText()),2);
        //        PRODQTY.setText(model.getValueAt(Myindex, 2).toString());
        //        PRODPRICE.setText(model.getValueAt(Myindex, 3).toString());
        //        PRODCAT.setSelectedItem(model.getValueAt(Myindex, 4).toString());
    }//GEN-LAST:event_PRODLISTMouseClicked

    private void PRODCATItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PRODCATItemStateChanged

    }//GEN-LAST:event_PRODCATItemStateChanged

    private void PRODCATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODCATMouseClicked

    }//GEN-LAST:event_PRODCATMouseClicked

    private void filterBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterBtnMouseClicked
        try {
            conn = ConnectXamppMySQL.conn();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM products WHERE PRODCAT='"+PRODCAT.getSelectedItem().toString()+"'");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("MÃ SP");
            model.addColumn("TÊN SP");
            model.addColumn("SỐ LƯỢNG TRONG KHO");
            model.addColumn("GIÁ");
            model.addColumn("DANH MỤC SP");
            while (rs.next()) {
                Object[] row = {
                    rs.getString("PRODID"),
                    rs.getString("PRODNAME"),
                    rs.getInt("PRODQTY"),
                    CommonFunction.doubleFormattedView(rs.getDouble("PRODPRICE")),
                    rs.getString("PRODCAT")
                };
                model.addRow(row);
            }
            PRODLIST.setModel(model);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_filterBtnMouseClicked

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterBtnActionPerformed

    private void ReloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReloadBtnMouseClicked
        SelectBill();
    }//GEN-LAST:event_ReloadBtnMouseClicked

    private void ReloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReloadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReloadBtnActionPerformed

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất không?", "Đăng xuất", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LogoutBtnMouseClicked

    private void PlayTable1BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable1BtnMouseClicked
        new Table1AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable1BtnMouseClicked

    private void PlayTable2BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable2BtnMouseClicked
        new Table2AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable2BtnMouseClicked

    private void PlayTable3BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable3BtnMouseClicked
        new Table3AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable3BtnMouseClicked

    private void PlayTable4BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable4BtnMouseClicked
//        new Table4AndCheckOut().setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_PlayTable4BtnMouseClicked

    private void PlayTable5BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable5BtnMouseClicked
        new Table5AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable5BtnMouseClicked

    private void PlayTable6BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable6BtnMouseClicked
        new Table6AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable6BtnMouseClicked

    private void PlayTable7BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable7BtnMouseClicked
        new Table7AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable7BtnMouseClicked

    private void PlayTable8BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable8BtnMouseClicked
        new Table8AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable8BtnMouseClicked

    private void SwapNormalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SwapNormalBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SwapNormalBtnMouseClicked

    private void SwapVipBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SwapVipBtnMouseClicked
        new Table9AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SwapVipBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Table4AndCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table4AndCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table4AndCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table4AndCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table4AndCheckOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtnTable4;
    private javax.swing.JTextArea BillReview;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JPanel LogoutBtn;
    private javax.swing.JLabel Name1;
    private javax.swing.JLabel Name2;
    private javax.swing.JLabel Name3;
    private javax.swing.JLabel Name4;
    private javax.swing.JLabel Name5;
    private javax.swing.JLabel Name6;
    private javax.swing.JLabel Name7;
    private javax.swing.JLabel Name8;
    private javax.swing.JLabel NameTable4;
    private javax.swing.JLabel Normal;
    private javax.swing.JComboBox<String> PRODCAT;
    private javax.swing.JTable PRODLIST;
    private javax.swing.JTextField PRODNAME;
    private javax.swing.JTextField PRODQTY;
    private javax.swing.JPanel PlayTable1Btn;
    private javax.swing.JPanel PlayTable2Btn;
    private javax.swing.JPanel PlayTable3Btn;
    private javax.swing.JPanel PlayTable4Btn;
    private javax.swing.JPanel PlayTable5Btn;
    private javax.swing.JPanel PlayTable6Btn;
    private javax.swing.JPanel PlayTable7Btn;
    private javax.swing.JPanel PlayTable8Btn;
    private javax.swing.JButton PrintBtnTable4;
    private javax.swing.JButton ReloadBtn;
    private javax.swing.JButton ResetBtnTable4;
    private javax.swing.JTextField SDTKH4;
    private javax.swing.JButton StartBtnTable4;
    private javax.swing.JButton StopBtnTable4;
    private javax.swing.JPanel SwapNormalBtn;
    private javax.swing.JPanel SwapVipBtn;
    private javax.swing.JTextField TIMEEND4;
    private javax.swing.JTextField TIMESTART4;
    private javax.swing.JLabel TotalBillRender;
    private javax.swing.JLabel VIP;
    private javax.swing.JButton filterBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel table1;
    // End of variables declaration//GEN-END:variables
}
