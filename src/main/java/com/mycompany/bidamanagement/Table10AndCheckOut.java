/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bidamanagement;

import com.mycompany.bidamanagement.bill.ReportManager;
import com.mycompany.bidamanagement.printModel.ParameterReportCheckout;
import com.mycompany.bidamanagement.printModel.ParameterReportCheckoutTable;
import java.io.FileInputStream;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Hashtable;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author duc
 */
public class Table10AndCheckOut extends javax.swing.JFrame {

    Connection conn;
    static Statement st = null;
    static ResultSet rs = null;
    ArrayList<BillItem> billItems = new ArrayList<>();
    BillItem billItem = new BillItem();
    int i = 0;
    Double Uprice, TotalPrice=0.0, TotalBill=0.0;
    int AvailQty;    

    // Sử dụng lớp Singleton để lưu trữ biến inputData Table 10
    private int startHourTable10, startMinuteTable10, startSecondTable10;
    private int endHourTable10, endMinuteTable10, endSecondTable10;

    private DataHolderTable9 dataHolderTable9 = DataHolderTable9.getInstanceTable9();
    private DataHolderTable10 dataHolderTable10 = DataHolderTable10.getInstanceTable10();
    private DataHolderTable11 dataHolderTable11 = DataHolderTable11.getInstanceTable11();
    private DataHolderTable12 dataHolderTable12 = DataHolderTable12.getInstanceTable12();
    private DataHolderTable13 dataHolderTable13 = DataHolderTable13.getInstanceTable13();
    private DataHolderTable14 dataHolderTable14 = DataHolderTable14.getInstanceTable14();
    private DataHolderTable15 dataHolderTable15 = DataHolderTable15.getInstanceTable15();
    private DataHolderTable16 dataHolderTable16 = DataHolderTable16.getInstanceTable16();
    private DataHolderTable17 dataHolderTable17 = DataHolderTable17.getInstanceTable17();
    private DataHolderTable18 dataHolderTable18 = DataHolderTable18.getInstanceTable18();

    public Table10AndCheckOut() {
        initComponents();
        restoreInputDataTable();
        restoreDataTable10();
        restoreBillTable10();
        try {
            ReportManager.getInstance().compileReport();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        JLabel[] nameFields = { Name9, Name10, Name11, Name12, Name13, Name14, Name15, Name16, Name17, Name18 };

        for (int i = 0; i < nameFields.length; i++) {
            if ("".equals(nameFields[i].getText())) {
                nameFields[i].setText("BÀN " + (i + 9));
            }
        }
        if ("".equals(NameTable10.getText())) {
            NameTable10.setText("BÀN 10");
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
                // JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thành công!");
            } else {
                // JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được cập nhật!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật hóa đơn!");
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
    
    private void restoreInputDataTable() {
        JLabel[] nameFields = { Name9, Name10, Name11, Name12, Name13, Name14, Name15, Name16, Name17, Name18 };
        String[] dataHolderColor = {
            dataHolderTable9.getInputColorDataNameTable9(),
            dataHolderTable10.getInputColorDataNameTable10(),
            dataHolderTable11.getInputColorDataNameTable11(),
            dataHolderTable12.getInputColorDataNameTable12(),
            dataHolderTable13.getInputColorDataNameTable13(),
            dataHolderTable14.getInputColorDataNameTable14(),
            dataHolderTable15.getInputColorDataNameTable15(),
            dataHolderTable16.getInputColorDataNameTable16(),
            dataHolderTable17.getInputColorDataNameTable17(),
            dataHolderTable18.getInputColorDataNameTable18(),
        };
        String[] dataHolderName = {
            dataHolderTable9.getInputDataName9(),
            dataHolderTable10.getInputDataName10(),
            dataHolderTable11.getInputDataName11(),
            dataHolderTable12.getInputDataName12(),
            dataHolderTable13.getInputDataName13(),
            dataHolderTable14.getInputDataName14(),
            dataHolderTable15.getInputDataName15(),
            dataHolderTable16.getInputDataName16(),
            dataHolderTable17.getInputDataName17(),
            dataHolderTable18.getInputDataName18(),
        };
        Color color9 = null, color10 = null, color11 = null, color12 = null, color13 = null, color14 = null, color15 = null, color16 = null, color17 = null, color18 = null;
        Color[] color = {color9, color10, color11, color12, color13, color14, color15, color16, color17, color18};

        for (int i = 0; i < 10; i++) {
            nameFields[i].setText(dataHolderName[i]);
            // Khôi phục màu sắc của NameTable từ DataHolder
            String colorAsString = dataHolderColor[i];

            String[] colorComponents = colorAsString.split(",");
            if (colorComponents.length == 3) {
                int red = Integer.parseInt(colorComponents[0]);
                int green = Integer.parseInt(colorComponents[1]);
                int blue = Integer.parseInt(colorComponents[2]);
                color[i] = new Color(red, green, blue);
                nameFields[i].setForeground(color[i]);
            }
        }   
    }

    private void restoreDataTable10() {
        TIMESTART10.setText(dataHolderTable10.getInputDataSTARTTable10());
        TIMEEND10.setText(dataHolderTable10.getInputDataENDTable10());
        NameTable10.setText(dataHolderTable10.getInputDataNameTable10());
        Name10.setText(dataHolderTable10.getInputDataName10());
        // Khôi phục màu sắc của NameTable từ DataHolder
        String colorAsString1 = dataHolderTable10.getInputColorDataNameTable10();
        String colorAsString2 = dataHolderTable10.getInputColorDataName10();
        String[] colorComponents10 = colorAsString1.split(",");
        if (colorComponents10.length == 3) {
            int red = Integer.parseInt(colorComponents10[0]);
            int green = Integer.parseInt(colorComponents10[1]);
            int blue = Integer.parseInt(colorComponents10[2]);
            Color color1 = new Color(red, green, blue);
            NameTable10.setForeground(color1);
            Name10.setForeground(color1);
        }
        StartBtnTable10.setEnabled(dataHolderTable10.isStartBtnEnabledTable10());
        StopBtnTable10.setEnabled(dataHolderTable10.isStopBtnEnabledTable10());
        PrintBtnTable10.setEnabled(dataHolderTable10.isPrintBtnEnabledTable10());
        startHourTable10 = dataHolderTable10.getStartHourTable10();
        startMinuteTable10 = dataHolderTable10.getStartMinuteTable10();
        startSecondTable10 = dataHolderTable10.getStartSecondTable10();
        endHourTable10 = dataHolderTable10.getEndHourTable10();
        endMinuteTable10 = dataHolderTable10.getEndMinuteTable10();
        endSecondTable10 = dataHolderTable10.getEndSecondTable10();
        AddBtnTable10.setEnabled(dataHolderTable10.isAddBtnEnabledTable10());
    }
    
    private void saveInputDataTable10() {
        dataHolderTable10.setInputDataSTARTTable10(TIMESTART10.getText());
        dataHolderTable10.setInputDataENDTable10(TIMEEND10.getText());
        dataHolderTable10.setInputDataNameTable10(NameTable10.getText());
        dataHolderTable10.setInputDataName10(Name10.getText());

        // Chuyển đổi màu sắc của Table10Name thành mã màu RGB và lưu vào DataHolder
        Color color = NameTable10.getForeground();
        Color color2 = Name10.getForeground();
        String colorAsString = String.format("%d,%d,%d", color.getRed(), color.getGreen(), color.getBlue());
        dataHolderTable10.setInputColorDataNameTable10(colorAsString);
        String colorAsString2 = String.format("%d,%d,%d", color2.getRed(), color2.getGreen(), color2.getBlue());
        dataHolderTable10.setInputColorDataName10(colorAsString2);
        dataHolderTable10.setStartBtnEnabledTable10(StartBtnTable10.isEnabled());
        dataHolderTable10.setStopBtnEnabledTable10(StopBtnTable10.isEnabled());
        dataHolderTable10.setPrintBtnEnabledTable10(PrintBtnTable10.isEnabled());

        dataHolderTable10.setStartHourTable10(startHourTable10);
        dataHolderTable10.setStartMinuteTable10(startMinuteTable10);
        dataHolderTable10.setStartSecondTable10(startSecondTable10);
        dataHolderTable10.setEndHourTable10(endHourTable10);
        dataHolderTable10.setEndMinuteTable10(endMinuteTable10);
        dataHolderTable10.setEndSecondTable10(endSecondTable10);

        dataHolderTable10.setAddBtnEnabledTable10(AddBtnTable10.isEnabled());
    }

    private BillTable10 billTable10 = BillTable10.getInstanceTable10();
    private boolean checkTrueBillDetailTable10 = false;
    private int invoiceIdTable10;
    private int soLanBamAddTable10;
    private double saveBillPriceTable10;

// Phương thức để lưu trữ dữ liệu khi người dùng nhập vào ô input
    private void saveBillTable10() {
        billTable10.setBillReviewTable10(BillReview.getText());
        billTable10.setIsBillIdDetailTable10(checkTrueBillDetailTable10);
        billTable10.setInvoiceIdTable10(invoiceIdTable10);
        billTable10.setSoLanBamAddTable10(soLanBamAddTable10);
        billTable10.setSaveBillPriceTable10(saveBillPriceTable10);
    }

// Phương thức để khôi phục dữ liệu khi quay lại trang ban đầu
    private void restoreBillTable10() {
        BillReview.setText(billTable10.getBillReviewTable10());
        checkTrueBillDetailTable10 = billTable10.isBillIdDetailTable10();
        invoiceIdTable10 = billTable10.getInvoiceIdTable10();
        soLanBamAddTable10 = billTable10.getSoLanBamAddTable10();
        TotalBill = billTable10.getSaveBillPriceTable10();
        TotalBillRender.setText("TỔNG CỘNG: " + CommonFunction.doubleFormattedView(billTable10.getSaveBillPriceTable10()));
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
        AddBtnTable10 = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        table1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        NameTable10 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SDTKH10 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TIMESTART10 = new javax.swing.JTextField();
        jPanel67 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        TIMEEND10 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        StartBtnTable10 = new javax.swing.JButton();
        StopBtnTable10 = new javax.swing.JButton();
        PrintBtnTable10 = new javax.swing.JButton();
        ResetBtnTable10 = new javax.swing.JButton();
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
        PlayTable9Btn = new javax.swing.JPanel();
        Name9 = new javax.swing.JLabel();
        PlayTable10Btn = new javax.swing.JPanel();
        Name10 = new javax.swing.JLabel();
        PlayTable11Btn = new javax.swing.JPanel();
        Name11 = new javax.swing.JLabel();
        PlayTable12Btn = new javax.swing.JPanel();
        Name12 = new javax.swing.JLabel();
        PlayTable13Btn = new javax.swing.JPanel();
        Name13 = new javax.swing.JLabel();
        PlayTable14Btn = new javax.swing.JPanel();
        Name14 = new javax.swing.JLabel();
        PlayTable15Btn = new javax.swing.JPanel();
        Name15 = new javax.swing.JLabel();
        PlayTable16Btn = new javax.swing.JPanel();
        Name16 = new javax.swing.JLabel();
        PlayTable17Btn = new javax.swing.JPanel();
        Name17 = new javax.swing.JLabel();
        PlayTable18Btn = new javax.swing.JPanel();
        Name18 = new javax.swing.JLabel();
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

        AddBtnTable10.setBackground(new java.awt.Color(110, 178, 246));
        AddBtnTable10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddBtnTable10.setForeground(new java.awt.Color(255, 255, 255));
        AddBtnTable10.setText("THÊM");
        AddBtnTable10.setBorder(null);
        AddBtnTable10.setBorderPainted(false);
        AddBtnTable10.setEnabled(false);
        AddBtnTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnTable10MouseClicked(evt);
            }
        });
        AddBtnTable10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnTable10ActionPerformed(evt);
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

        NameTable10.setBackground(new java.awt.Color(249, 249, 249));
        NameTable10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameTable10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameTable10.setText("BÀN 10");
        NameTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameTable10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameTable10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SĐT KH");

        SDTKH10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SDTKH10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SDTKH10)
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

        TIMESTART10.setBackground(new java.awt.Color(248, 248, 248));
        TIMESTART10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMESTART10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMESTART10.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMESTART10.setEnabled(false);
        TIMESTART10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESTART10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMESTART10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMESTART10)
                .addContainerGap())
        );

        jPanel67.setBackground(new java.awt.Color(102, 204, 0));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("GIỜ NGHỈ");

        TIMEEND10.setBackground(new java.awt.Color(248, 248, 248));
        TIMEEND10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TIMEEND10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIMEEND10.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TIMEEND10.setEnabled(false);
        TIMEEND10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMEEND10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TIMEEND10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TIMEEND10)
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

        StartBtnTable10.setBackground(new java.awt.Color(237, 237, 237));
        StartBtnTable10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StartBtnTable10.setText("BẮT ĐẦU");
        StartBtnTable10.setBorder(null);
        StartBtnTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartBtnTable10MouseClicked(evt);
            }
        });
        StartBtnTable10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnTable10ActionPerformed(evt);
            }
        });

        StopBtnTable10.setBackground(new java.awt.Color(237, 237, 237));
        StopBtnTable10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopBtnTable10.setText("DỪNG LẠI");
        StopBtnTable10.setBorder(null);
        StopBtnTable10.setEnabled(false);
        StopBtnTable10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnTable10ActionPerformed(evt);
            }
        });

        PrintBtnTable10.setBackground(new java.awt.Color(110, 178, 246));
        PrintBtnTable10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PrintBtnTable10.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtnTable10.setText("IN HÓA ĐƠN");
        PrintBtnTable10.setBorder(null);
        PrintBtnTable10.setEnabled(false);
        PrintBtnTable10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnTable10ActionPerformed(evt);
            }
        });

        ResetBtnTable10.setBackground(new java.awt.Color(255, 51, 51));
        ResetBtnTable10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBtnTable10.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtnTable10.setText("RESET");
        ResetBtnTable10.setBorder(null);
        ResetBtnTable10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnTable10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable10, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(ResetBtnTable10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StopBtnTable10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable10, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StartBtnTable10, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(StopBtnTable10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBtnTable10, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(PrintBtnTable10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(AddBtnTable10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(AddBtnTable10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        PlayTable9Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable9Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable9BtnMouseClicked(evt);
            }
        });

        Name9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name9.setText("BÀN 9");

        javax.swing.GroupLayout PlayTable9BtnLayout = new javax.swing.GroupLayout(PlayTable9Btn);
        PlayTable9Btn.setLayout(PlayTable9BtnLayout);
        PlayTable9BtnLayout.setHorizontalGroup(
            PlayTable9BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable9BtnLayout.setVerticalGroup(
            PlayTable9BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable10Btn.setBackground(new java.awt.Color(204, 204, 204));
        PlayTable10Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable10BtnMouseClicked(evt);
            }
        });

        Name10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name10.setText("BÀN 10");

        javax.swing.GroupLayout PlayTable10BtnLayout = new javax.swing.GroupLayout(PlayTable10Btn);
        PlayTable10Btn.setLayout(PlayTable10BtnLayout);
        PlayTable10BtnLayout.setHorizontalGroup(
            PlayTable10BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable10BtnLayout.setVerticalGroup(
            PlayTable10BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name10, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable11Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable11Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable11BtnMouseClicked(evt);
            }
        });

        Name11.setBackground(new java.awt.Color(255, 255, 255));
        Name11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name11.setText("BÀN 11");

        javax.swing.GroupLayout PlayTable11BtnLayout = new javax.swing.GroupLayout(PlayTable11Btn);
        PlayTable11Btn.setLayout(PlayTable11BtnLayout);
        PlayTable11BtnLayout.setHorizontalGroup(
            PlayTable11BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable11BtnLayout.setVerticalGroup(
            PlayTable11BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name11, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable12Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable12Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable12BtnMouseClicked(evt);
            }
        });

        Name12.setBackground(new java.awt.Color(255, 255, 255));
        Name12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name12.setText("BÀN 12");

        javax.swing.GroupLayout PlayTable12BtnLayout = new javax.swing.GroupLayout(PlayTable12Btn);
        PlayTable12Btn.setLayout(PlayTable12BtnLayout);
        PlayTable12BtnLayout.setHorizontalGroup(
            PlayTable12BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable12BtnLayout.setVerticalGroup(
            PlayTable12BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name12, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable13Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable13Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable13BtnMouseClicked(evt);
            }
        });

        Name13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name13.setText("BÀN 13");

        javax.swing.GroupLayout PlayTable13BtnLayout = new javax.swing.GroupLayout(PlayTable13Btn);
        PlayTable13Btn.setLayout(PlayTable13BtnLayout);
        PlayTable13BtnLayout.setHorizontalGroup(
            PlayTable13BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable13BtnLayout.setVerticalGroup(
            PlayTable13BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable14Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable14Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable14BtnMouseClicked(evt);
            }
        });

        Name14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name14.setText("BÀN 14");

        javax.swing.GroupLayout PlayTable14BtnLayout = new javax.swing.GroupLayout(PlayTable14Btn);
        PlayTable14Btn.setLayout(PlayTable14BtnLayout);
        PlayTable14BtnLayout.setHorizontalGroup(
            PlayTable14BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable14BtnLayout.setVerticalGroup(
            PlayTable14BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable15Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable15Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable15BtnMouseClicked(evt);
            }
        });

        Name15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name15.setText("BÀN 15");

        javax.swing.GroupLayout PlayTable15BtnLayout = new javax.swing.GroupLayout(PlayTable15Btn);
        PlayTable15Btn.setLayout(PlayTable15BtnLayout);
        PlayTable15BtnLayout.setHorizontalGroup(
            PlayTable15BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable15BtnLayout.setVerticalGroup(
            PlayTable15BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name15, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable16Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable16Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable16BtnMouseClicked(evt);
            }
        });

        Name16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name16.setText("BÀN 16");

        javax.swing.GroupLayout PlayTable16BtnLayout = new javax.swing.GroupLayout(PlayTable16Btn);
        PlayTable16Btn.setLayout(PlayTable16BtnLayout);
        PlayTable16BtnLayout.setHorizontalGroup(
            PlayTable16BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable16BtnLayout.setVerticalGroup(
            PlayTable16BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name16, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable17Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable17Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable17BtnMouseClicked(evt);
            }
        });

        Name17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name17.setText("BÀN 17");

        javax.swing.GroupLayout PlayTable17BtnLayout = new javax.swing.GroupLayout(PlayTable17Btn);
        PlayTable17Btn.setLayout(PlayTable17BtnLayout);
        PlayTable17BtnLayout.setHorizontalGroup(
            PlayTable17BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable17BtnLayout.setVerticalGroup(
            PlayTable17BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name17, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PlayTable18Btn.setBackground(new java.awt.Color(255, 255, 255));
        PlayTable18Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayTable18BtnMouseClicked(evt);
            }
        });

        Name18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Name18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name18.setText("BÀN 18");

        javax.swing.GroupLayout PlayTable18BtnLayout = new javax.swing.GroupLayout(PlayTable18Btn);
        PlayTable18Btn.setLayout(PlayTable18BtnLayout);
        PlayTable18BtnLayout.setHorizontalGroup(
            PlayTable18BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlayTable18BtnLayout.setVerticalGroup(
            PlayTable18BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Name18, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        SwapNormalBtn.setBackground(new java.awt.Color(255, 255, 255));
        SwapNormalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SwapNormalBtnMouseClicked(evt);
            }
        });

        Normal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
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

        SwapVipBtn.setBackground(new java.awt.Color(0, 102, 153));
        SwapVipBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SwapVipBtnMouseClicked(evt);
            }
        });

        VIP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        VIP.setForeground(new java.awt.Color(255, 255, 255));
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
            .addComponent(PlayTable10Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable11Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable9Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable13Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable14Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable12Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable16Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable15Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable17Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PlayTable18Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(PlayTable9Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable10Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable11Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable12Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable13Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable14Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable15Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable16Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable17Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayTable18Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void AddBtnTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnTable10MouseClicked
        if (AddBtnTable10.isEnabled()) {
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
                soLanBamAddTable10++;
                int QTY = CommonFunction.parseInteger(PRODQTY.getText());
                int PRODUCTSELL = QTY;
                TotalPrice = roundDecimal(Uprice * Double.valueOf(PRODQTY.getText()),2);
                TotalBill = roundDecimal((TotalBill + TotalPrice), 2);

                saveBillPriceTable10 = TotalBill;
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
                if (soLanBamAddTable10 == 1) {
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
                            invoiceIdTable10 = currentInvoice;
                            System.out.println("currentInvoiceID: " + invoiceIdTable10);
                            PreparedStatement addInvoiceDetail = conn.prepareStatement("INSERT INTO invoice_details (INVOICEID, PRODNAME, QUANTITY, PRICE, TOTAL) VALUES (?, ?, ?, ?, ?)");
                            addInvoiceDetail.setInt(1, invoiceIdTable10);
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
                        checkExistingProduct.setInt(1, invoiceIdTable10);
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
                            updateInvoiceDetail.setInt(3, invoiceIdTable10);
                            updateInvoiceDetail.setString(4, PRODNAME.getText());
                            updateInvoiceDetail.executeUpdate();
                            updateTotalBill();
                        } else {
                            // Nếu sản phẩm chưa tồn tại, thêm mới vào invoice_details
                            PreparedStatement addInvoiceDetail = conn.prepareStatement("INSERT INTO invoice_details (INVOICEID, PRODNAME, QUANTITY, PRICE, TOTAL) VALUES (?, ?, ?, ?, ?)");
                            addInvoiceDetail.setInt(1, invoiceIdTable10);
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
                checkTrueBillDetailTable10 = true;
                saveBillTable10();
            }
        }
    }//GEN-LAST:event_AddBtnTable10MouseClicked

    private void AddBtnTable10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnTable10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnTable10ActionPerformed

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        PRODNAME.setText("");
        PRODQTY.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void NameTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameTable10MouseClicked

    }//GEN-LAST:event_NameTable10MouseClicked

    private void TIMESTART10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESTART10ActionPerformed

    }//GEN-LAST:event_TIMESTART10ActionPerformed

    private void TIMEEND10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMEEND10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIMEEND10ActionPerformed

    private void StartBtnTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartBtnTable10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartBtnTable10MouseClicked

    private void StartBtnTable10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnTable10ActionPerformed

        Date currentStartTable1 = new Date();
        SimpleDateFormat startFormatTable1 = new SimpleDateFormat("HH:mm:ss");
        String formatStartTable1 = startFormatTable1.format(currentStartTable1);
        TIMESTART10.setText(formatStartTable1);
        NameTable10.setText("BÀN 10 (ĐANG CHƠI)");
        Name10.setText("BÀN 10 (ĐANG CHƠI)");
        NameTable10.setForeground(Color.RED);
        Name10.setForeground(Color.RED);

        StartBtnTable10.setEnabled(false);
        StopBtnTable10.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStartTable1);

        startHourTable10 = cal.get(Calendar.HOUR_OF_DAY);
        startMinuteTable10 = cal.get(Calendar.MINUTE);
        startSecondTable10 = cal.get(Calendar.SECOND);

        AddBtnTable10.setEnabled(true);

        saveInputDataTable10();
    }//GEN-LAST:event_StartBtnTable10ActionPerformed

    private void StopBtnTable10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnTable10ActionPerformed

        Date currentStopTable1 = new Date();
        SimpleDateFormat dateStopFormatTable1 = new SimpleDateFormat("HH:mm:ss");
        String formatStopTable1 = dateStopFormatTable1.format(currentStopTable1);
        TIMEEND10.setText(formatStopTable1);
        NameTable10.setText("BÀN 10 (ĐANG TÍNH TIỀN)");
        NameTable10.setForeground(Color.YELLOW);
        Name10.setText("BÀN 10 (ĐANG TÍNH TIỀN)");
        Name10.setForeground(Color.YELLOW);
        StopBtnTable10.setEnabled(false);
        PrintBtnTable10.setEnabled(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentStopTable1);

        endHourTable10 = cal.get(Calendar.HOUR_OF_DAY);
        endMinuteTable10 = cal.get(Calendar.MINUTE);
        endSecondTable10 = cal.get(Calendar.SECOND);

        //Luu gia tri sau khi set moi bien
        saveInputDataTable10();
    }//GEN-LAST:event_StopBtnTable10ActionPerformed

    private void PrintBtnTable10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnTable10ActionPerformed
        Date currentPrintTable10 = new Date();
        SimpleDateFormat datePrintTable10 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String formatPrintTable10 = datePrintTable10.format(currentPrintTable10);
        String TableFee10 = CommonFunction.calculateTimePlayTable(startHourTable10, startMinuteTable10, startSecondTable10, endHourTable10, endMinuteTable10, endSecondTable10);
        Double totalFeeBill = Double.parseDouble(TableFee10) + TotalBill;
        String convertTotalFeeToString = CommonFunction.doubleFormattedView(totalFeeBill);
        System.out.println("totalfee: "+TableFee10 + " savePrice: " + TotalBill +" totalBill: "+ convertTotalFeeToString);
        try {
            // Sau khi in hóa đơn, thêm dữ liệu vào bảng tablebills
            conn = ConnectXamppMySQL.conn();
            PreparedStatement addTableBill = conn.prepareStatement("INSERT INTO tablebills (SDT, DATE, STARTTIME, ENDTIME, TABLE_FEE, MABAN) VALUES (?, ?, ?, ?, ?, ?)");
            addTableBill.setString(1, SDTKH10.getText());
            addTableBill.setString(2, formatPrintTable10);
            addTableBill.setString(3, TIMESTART10.getText());
            addTableBill.setString(4, TIMEEND10.getText());
            addTableBill.setString(5, TableFee10);
            addTableBill.setInt(6, 10);
            addTableBill.executeUpdate();

            if(soLanBamAddTable10 > 0) {
                ParameterReportCheckoutTable dataprint10 = new ParameterReportCheckoutTable(formatPrintTable10, TIMESTART10.getText(), TIMEEND10.getText(), TableFee10, invoiceIdTable10, convertTotalFeeToString);
                ReportManager.getInstance().printReportPaymentTable(dataprint10);
            }
            else {
                ParameterReportCheckout dataprint10 = new ParameterReportCheckout(formatPrintTable10, TIMESTART10.getText(), TIMEEND10.getText(), TableFee10);
                ReportManager.getInstance().printReportPayment(dataprint10);
            }

            PrintBtnTable10.setEnabled(false);
            NameTable10.setText("BÀN 10");
            NameTable10.setForeground(Color.BLACK);
            Name10.setText("BÀN 10");
            Name10.setForeground(Color.BLACK);
            StartBtnTable10.setEnabled(true);
            StopBtnTable10.setEnabled(false);
            TIMESTART10.setText("");
            TIMEEND10.setText("");
            SDTKH10.setText("");
            AddBtnTable10.setEnabled(false);
            saveInputDataTable10();
            System.out.println("Start time: " + startHourTable10 + ":" + startMinuteTable10 + ":" + startSecondTable10);
            System.out.println("End time: " + endHourTable10 + ":" + endMinuteTable10 + ":" + endSecondTable10);

            // Xu ly cho ca table va bill
            checkTrueBillDetailTable10 = false;
            PRODNAME.setText("");
            PRODQTY.setText("");
            BillReview.setText("");
            soLanBamAddTable10 = 0;
            saveBillPriceTable10 = 0.0;
            TotalBill = 0.0;
            TotalBillRender.setText("TỔNG CỘNG: 0.00");
            saveBillTable10();

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PrintBtnTable10ActionPerformed

    private void ResetBtnTable10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnTable10ActionPerformed

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset bàn chơi không?", "RESET BÀN CHƠI", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            TIMESTART10.setText("");
            TIMEEND10.setText("");
            NameTable10.setText("BÀN 10");
            NameTable10.setForeground(Color.BLACK);
            Name10.setText("BÀN 10");
            Name10.setForeground(Color.BLACK);
            StartBtnTable10.setEnabled(true);
            StopBtnTable10.setEnabled(false);
            PrintBtnTable10.setEnabled(false);
            AddBtnTable10.setEnabled(false);
            saveInputDataTable10();

            checkTrueBillDetailTable10 = false;
            PRODNAME.setText("");
            PRODQTY.setText("");
            BillReview.setText("");
            soLanBamAddTable10 = 0;

            saveBillPriceTable10 = 0.0;
            TotalBillRender.setText("TỔNG CỘNG: 0.00");
            TotalBill = 0.0;
            saveBillTable10();

        }
    }//GEN-LAST:event_ResetBtnTable10ActionPerformed

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

    private void PlayTable9BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable9BtnMouseClicked
        new Table9AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable9BtnMouseClicked

    private void PlayTable10BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable10BtnMouseClicked
//        new Table10AndCheckOut().setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_PlayTable10BtnMouseClicked

    private void PlayTable11BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable11BtnMouseClicked
        new Table11AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable11BtnMouseClicked

    private void PlayTable12BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable12BtnMouseClicked
        new Table12AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable12BtnMouseClicked

    private void PlayTable13BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable13BtnMouseClicked
        new Table13AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable13BtnMouseClicked

    private void PlayTable14BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable14BtnMouseClicked
        new Table14AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable14BtnMouseClicked

    private void PlayTable15BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable15BtnMouseClicked
        new Table15AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable15BtnMouseClicked

    private void PlayTable16BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable16BtnMouseClicked
        new Table16AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable16BtnMouseClicked

    private void PlayTable17BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable17BtnMouseClicked
        new Table17AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayTable17BtnMouseClicked

    private void PlayTable18BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayTable18BtnMouseClicked
        new Table18AndCheckOut().setVisible(true);
        this.dispose();                 
    }//GEN-LAST:event_PlayTable18BtnMouseClicked

    private void SwapNormalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SwapNormalBtnMouseClicked
        new Table1AndCheckOut().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SwapNormalBtnMouseClicked

    private void SwapVipBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SwapVipBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Table10AndCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table10AndCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table10AndCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table10AndCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table10AndCheckOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtnTable10;
    private javax.swing.JTextArea BillReview;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JPanel LogoutBtn;
    private javax.swing.JLabel Name10;
    private javax.swing.JLabel Name11;
    private javax.swing.JLabel Name12;
    private javax.swing.JLabel Name13;
    private javax.swing.JLabel Name14;
    private javax.swing.JLabel Name15;
    private javax.swing.JLabel Name16;
    private javax.swing.JLabel Name17;
    private javax.swing.JLabel Name18;
    private javax.swing.JLabel Name9;
    private javax.swing.JLabel NameTable10;
    private javax.swing.JLabel Normal;
    private javax.swing.JComboBox<String> PRODCAT;
    private javax.swing.JTable PRODLIST;
    private javax.swing.JTextField PRODNAME;
    private javax.swing.JTextField PRODQTY;
    private javax.swing.JPanel PlayTable10Btn;
    private javax.swing.JPanel PlayTable11Btn;
    private javax.swing.JPanel PlayTable12Btn;
    private javax.swing.JPanel PlayTable13Btn;
    private javax.swing.JPanel PlayTable14Btn;
    private javax.swing.JPanel PlayTable15Btn;
    private javax.swing.JPanel PlayTable16Btn;
    private javax.swing.JPanel PlayTable17Btn;
    private javax.swing.JPanel PlayTable18Btn;
    private javax.swing.JPanel PlayTable9Btn;
    private javax.swing.JButton PrintBtnTable10;
    private javax.swing.JButton ReloadBtn;
    private javax.swing.JButton ResetBtnTable10;
    private javax.swing.JTextField SDTKH10;
    private javax.swing.JButton StartBtnTable10;
    private javax.swing.JButton StopBtnTable10;
    private javax.swing.JPanel SwapNormalBtn;
    private javax.swing.JPanel SwapVipBtn;
    private javax.swing.JTextField TIMEEND10;
    private javax.swing.JTextField TIMESTART10;
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
