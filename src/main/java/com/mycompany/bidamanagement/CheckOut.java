/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bidamanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duc
 */
public class CheckOut extends javax.swing.JFrame {

    Connection conn;
    static Statement st = null;
    static ResultSet rs = null;
    
    public CheckOut() {
        initComponents();
        SelectBill();
        getCategory();
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
                    doubleFormattedView(rs.getDouble("PRODPRICE")),
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
    
//    public static double roundDecimal(double number, int decimalPlaces) {
//        // Định dạng cho số với số lẻ giới hạn
//        String pattern = "#." + new String(new char[decimalPlaces]).replace("\0", "#");
//        DecimalFormat decimalFormat = new DecimalFormat(pattern);
//
//        // Làm tròn và trả về giá trị
//        String formattedNumber = decimalFormat.format(number);
//        return Double.parseDouble(formattedNumber);
//    }
    
    public static double roundDecimal(double number, int decimalPlaces) {
        // Định dạng cho số với số lẻ giới hạn
//        String pattern = "#." + new String(new char[decimalPlaces]).replace("\0", "#");
//        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        // Làm tròn và trả về giá trị
//        String formattedNumber = decimalFormat.format(number);
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(number * scale) / scale;
    }
    
    public String doubleFormattedView(double number){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(number);
    }
    
    private double parseDouble(String value) throws NumberFormatException {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Chuỗi không hợp lệ:" + value);
            throw new NumberFormatException("Chuỗi không hợp lệ: " + value);
        }
    }
    
    private int parseInteger(String value) throws NumberFormatException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ (Số nguyên):" + value);
            throw new NumberFormatException("Chuỗi không hợp lệ: " + value);
        }
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PRODNAME = new javax.swing.JTextField();
        PRODQTY = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PRODLIST = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillReview = new javax.swing.JTextArea();
        printBtn = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(110, 178, 246));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(110, 178, 246));
        exitBtn.setText("X");
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });

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

        AddBtn.setBackground(new java.awt.Color(110, 178, 246));
        AddBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("THÊM");
        AddBtn.setBorder(null);
        AddBtn.setBorderPainted(false);
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
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
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PRODNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
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
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
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

        printBtn.setBackground(new java.awt.Color(110, 178, 246));
        printBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setText("IN HÓA ĐƠN");
        printBtn.setBorder(null);
        printBtn.setBorderPainted(false);
        printBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printBtnMouseClicked(evt);
            }
        });
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });

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
            .addComponent(TotalBillRender, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PRODCAT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(206, 206, 206))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitBtn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(117, 117, 117))))
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exitBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn tắt ứng dụng?", "Tắt ứng dụng", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnMouseClicked

    private void PRODNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRODNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRODNAMEActionPerformed

    private void PRODQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRODQTYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRODQTYActionPerformed
    int i = 0;
    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        if(PRODQTY.getText().isEmpty() || PRODNAME.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để thêm vào bill!");
        }
        else if (parseInteger(PRODQTY.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng sản phẩm muốn bán là số lớn hơn 0!");
        }
        else if (AvailQty < parseInteger(PRODQTY.getText())){
            JOptionPane.showMessageDialog(this, "Trong kho không có đủ số lượng sản phẩm!");
        }
        else{
            i++;
            int QTY = parseInteger(PRODQTY.getText());
            int PRODUCTSELL = QTY;
            TotalPrice = roundDecimal(Uprice * Double.valueOf(PRODQTY.getText()),2);
            TotalBill = roundDecimal((TotalBill + TotalPrice), 2);
            
                if(i == 1){
                    BillReview.setText(BillReview.getText()+"                 ==========BIDA LUONG XUYEN==========\n\n"+"  STT    TÊN SẢN PHẨM           GIÁ            SỐ LƯỢNG                  TỔNG\n\n    "+i+"            "+PRODNAME.getText()+"             "+doubleFormattedView(Uprice)+"              "+PRODUCTSELL+"                     "+doubleFormattedView(TotalPrice)+"\n\n");
                }
                else{
                    BillReview.setText(BillReview.getText()+"    "+i+"            "+PRODNAME.getText()+"             "+doubleFormattedView(Uprice)+"              "+PRODUCTSELL+"                     "+doubleFormattedView(TotalPrice)+"\n\n");

                }
                TotalBillRender.setText("TỔNG CỘNG: "+doubleFormattedView(TotalBill));
                AvailQty -= PRODUCTSELL;
                updateStock(PRODUCTSELL);
            }
        
    }//GEN-LAST:event_AddBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    private void printBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseClicked
        try {
            BillReview.print();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printBtnMouseClicked

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printBtnActionPerformed
    Double Uprice, TotalPrice=0.0, TotalBill=0.0;
    int AvailQty;
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

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        PRODNAME.setText("");
        PRODQTY.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất không?", "Đăng xuất", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LogoutBtnMouseClicked

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterBtnActionPerformed

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
                    doubleFormattedView(rs.getDouble("PRODPRICE")),
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
    }//GEN-LAST:event_filterBtnMouseClicked

    private void PRODCATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRODCATMouseClicked

    }//GEN-LAST:event_PRODCATMouseClicked

    private void PRODCATItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PRODCATItemStateChanged
        
    }//GEN-LAST:event_PRODCATItemStateChanged

    private void ReloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReloadBtnMouseClicked
        SelectBill();
    }//GEN-LAST:event_ReloadBtnMouseClicked

    private void ReloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReloadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReloadBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextArea BillReview;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JPanel LogoutBtn;
    private javax.swing.JComboBox<String> PRODCAT;
    private javax.swing.JTable PRODLIST;
    private javax.swing.JTextField PRODNAME;
    private javax.swing.JTextField PRODQTY;
    private javax.swing.JButton ReloadBtn;
    private javax.swing.JLabel TotalBillRender;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JButton filterBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printBtn;
    // End of variables declaration//GEN-END:variables
}
