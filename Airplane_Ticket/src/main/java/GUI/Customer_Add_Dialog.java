/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package GUI;

import BLL.KhachHangBLL;
import DTO.HangThanThietDTO;
import DTO.KhachHangDTO;
import Util.DateJcalendarUtil;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author User
 */
public class Customer_Add_Dialog extends java.awt.Dialog {
    private KhachHangBLL khachHangBLL = new KhachHangBLL();
    private Map<String, String> cbxGioiTinhMap = new HashMap<>();
    private Customer customer;
    private KhachHangDTO khachhang; 

    public Customer_Add_Dialog(java.awt.Frame parent, boolean modal, Customer customer) {
        super(parent, modal);
        initComponents();
        initCbxGioiTinh();
        this.customer = customer;
    }
    public Customer_Add_Dialog(java.awt.Frame parent, boolean modal,String str) {
        super(parent, modal);
        initComponentsMuaVe();
        initCbxGioiTinh();
        this.customer = customer;
    }

    private void initCbxGioiTinh() {
        String[] descriptions = {"Tất cả", "Nam", "Nữ"};
        String[] values = {"", "true", "false"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxGioiTinhMap.put(descriptions[i], values[i]);
        }
        gender.setModel(cbxModel);
    }
    private void initComponentsMuaVe() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmnd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        birthDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog();
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("CMND:");

        cmnd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmnd.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Họ và tên:");

        name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        name.setBorder(null);
        name.setMinimumSize(new java.awt.Dimension(64, 28));
        name.setPreferredSize(new java.awt.Dimension(78, 28));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Giới tính :");

        gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nam", "Nữ", "Khác"}));
        gender.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Ngày sinh:");

        phoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneNumber.setBorder(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Số điện thoại :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Địa chỉ :");

        btnCancel.setBackground(new java.awt.Color(0, 153, 255));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 153, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm khách hàng");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMuaVeActionPerformed(evt);
            }
        });

        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        birthDate.setDateFormatString("yyyy-MM-dd");

        setTitle("Thêm mới khách hàng");
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmnd, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel12)
                                                                .addComponent(phoneNumber)
                                                                .addComponent(jLabel13)
                                                                .addComponent(birthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                                                .addComponent(jLabel9)
                                                                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(birthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(443, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thêm khách hàng");
        jPanel3.add(jLabel1);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmnd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        birthDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog();
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("CMND:");

        cmnd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmnd.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Họ và tên:");

        name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        name.setBorder(null);
        name.setMinimumSize(new java.awt.Dimension(64, 28));
        name.setPreferredSize(new java.awt.Dimension(78, 28));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Giới tính :");

        gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nam", "Nữ", "Khác"}));
        gender.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Ngày sinh:");

        phoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneNumber.setBorder(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Số điện thoại :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Địa chỉ :");

        btnCancel.setBackground(new java.awt.Color(0, 153, 255));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 153, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm khách hàng");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        birthDate.setDateFormatString("yyyy-MM-dd");

        setTitle("Thêm mới khách hàng");
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmnd, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel12)
                                                                .addComponent(phoneNumber)
                                                                .addComponent(jLabel13)
                                                                .addComponent(birthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                                                .addComponent(jLabel9)
                                                                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(birthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(443, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thêm khách hàng");
        jPanel3.add(jLabel1);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * Closes the dialog
     */
    public void closeDialog() {
        setVisible(false);
        dispose();
    }

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        closeDialog();
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        StringBuilder errorMessages = new StringBuilder();
        khachHangBLL.validateCmndExists(errorMessages, this);
        khachHangBLL.validatePhoneNumberExists(errorMessages, this);
        khachHangBLL.validate(errorMessages, this);
        if (!errorMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, errorMessages, "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        KhachHangDTO khachHangDTO = new KhachHangDTO();
        khachHangDTO.setCmnd(cmnd.getText().trim());
        khachHangDTO.setHoTen(name.getText().trim());
        khachHangDTO.setNgaySinh(LocalDate.parse(DateJcalendarUtil.formatDate(birthDate.getDate())));
        khachHangDTO.setGioiTinh(Boolean.parseBoolean(cbxGioiTinhMap.get(gender.getSelectedItem())));
        khachHangDTO.setSoDienThoai(phoneNumber.getText());
        khachHangDTO.setDiaChi(address.getText());
        closeDialog();
        if (khachHangBLL.create(khachHangDTO)) {
            customer.loadDataTable();
            JOptionPane.showMessageDialog(null, "      Thêm mới thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        customer.loadDataTable();
    }
    
    private void  btnAddMuaVeActionPerformed(java.awt.event.ActionEvent evt) {
        StringBuilder errorMessages = new StringBuilder();
        if (khachHangBLL.KhachHangThanThiet(this)==null)         //chua ton tai
        { 
        khachHangBLL.validatePhoneNumberExists(errorMessages, this);
        khachHangBLL.validate(errorMessages, this);
        if (!errorMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, errorMessages, "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        khachhang = new KhachHangDTO();
        khachhang.setCmnd(cmnd.getText().trim());
        khachhang.setHoTen(name.getText().trim());
        khachhang.setNgaySinh(LocalDate.parse(DateJcalendarUtil.formatDate(birthDate.getDate())));
        khachhang.setGioiTinh(Boolean.parseBoolean(cbxGioiTinhMap.get(gender.getSelectedItem())));
        khachhang.setSoDienThoai(phoneNumber.getText());
        khachhang.setDiaChi(address.getText());
        khachhang.setDiemTichLuy(0);
        HangThanThietDTO hangthanthiet=new HangThanThietDTO();
        hangthanthiet.setId(1);
        hangthanthiet.setTenHang("Sắt");
        hangthanthiet.setKhuyenMai(0);
        khachhang.setIdHangThanThiet(hangthanthiet);
        JOptionPane.showMessageDialog(null, "Nhập thông tin thành công !");
        dispose();
//        if (khachHangBLL.create(khachHangDTO)) {
//            customer.loadDataTable();
//            JOptionPane.showMessageDialog(null, "      Thêm mới thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "Thêm mới thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
//        customer.loadDataTable();
        }
        else 
        {
            khachhang = new KhachHangDTO();
            khachhang=khachHangBLL.KhachHangThanThiet(this);
            JOptionPane.showMessageDialog(null, "Thông tin của bạn đã có trong cơ sở dữ liệu !");
            dispose();
        }
        
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Customer_Add_Dialog dialog = new Customer_Add_Dialog(new java.awt.Frame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    public KhachHangDTO getKhachhang() {
        return khachhang;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private com.toedter.calendar.JDateChooser birthDate;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JTextField cmnd;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;

    public JTextArea getAddress() {
        return address;
    }

    public JDateChooser getBirthDate() {
        return birthDate;
    }

    public JTextField getCmnd() {
        return cmnd;
    }

    public JComboBox<String> getGender() {
        return gender;
    }

    public String getTextFieldName() {
        return name.getText();
    }

    public JTextField getPhoneNumber() {
        return phoneNumber;
    }

    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phoneNumber;
    // End of variables declaration//GEN-END:variables
}
