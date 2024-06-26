/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package GUI;

import BLL.ChuyenBayBLL;
import BLL.MayBayBLL;
import BLL.SanBayBLL;
import DTO.ChuyenBayDTO;
import DTO.MayBayDTO;
import DTO.SanBayDTO;
import Util.DateJcalendarUtil;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author User
 */
public class ChuyenBay_Add_Dialog extends java.awt.Dialog {

    private MayBayBLL mayBayBLL = new MayBayBLL();
    private SanBayBLL sanBayBLL = new SanBayBLL();
    private ChuyenBayBLL chuyenBayBLL = new ChuyenBayBLL();
    private Map<String, String> cbxMaMayBayMap = new HashMap<>();
    private Map<String, String> cbxSanBayDiMap = new HashMap<>();
    private Map<String, String> cbxSanBayDenMap = new HashMap<>();
    private Map<String, String> cbxTinhTrangMap = new HashMap<>();
    private Ticket_Type_Panel ticket_type_panel;

    public ChuyenBay_Add_Dialog(java.awt.Frame parent, boolean modal, Ticket_Type_Panel ticket_type_panel) throws SQLException {
        super(parent, modal);
        initComponents();
        initCbxMaMayBay();
        initCbxSanBayDi();
        initCbxSanBayDen();
        initCbxTinhTrang();
        this.ticket_type_panel = ticket_type_panel;
    }

    private void initCbxMaMayBay() {
        String[] descriptions = new String[mayBayBLL.findAll().size() + 1];
        String[] values = new String[mayBayBLL.findAll().size() + 1];
        descriptions[0] = "Tất cả";
        values[0] = "";
        byte i = 1;
        for (MayBayDTO mayBayDTO : mayBayBLL.findAll()) {
            if (mayBayDTO.isStatus()) {
                descriptions[i] = mayBayDTO.getTen();
                values[i] = String.valueOf(mayBayDTO.getId());
                i++;
            }
        }

        String[] descriptionsNewLength = Arrays.copyOf(descriptions, i);
        String[] valuesNewLength = Arrays.copyOf(values, i);

        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptionsNewLength);
        for (int j = 0; j < descriptionsNewLength.length; j++) {
            cbxMaMayBayMap.put(descriptionsNewLength[j], valuesNewLength[j]);
        }
        cbxMaMayBay.setModel(cbxModel);
    }

    private void initCbxSanBayDi() throws SQLException {
        String[] descriptions = new String[sanBayBLL.getAll().size() + 1];
        String[] values = new String[sanBayBLL.getAll().size() + 1];
        descriptions[0] = "Tất cả";
        values[0] = "";

        byte i = 1;
        for (SanBayDTO sanBayDTO : sanBayBLL.getAll()) {
            if (sanBayDTO.isStatus()) {
                descriptions[i] = sanBayDTO.getTen();
                values[i] = sanBayDTO.getMaSanBay();
                i++;
            }
        }

        String[] descriptionsNewLength = Arrays.copyOf(descriptions, i);
        String[] valuesNewLength = Arrays.copyOf(values, i);

        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptionsNewLength);

        for (int j = 0; j < descriptionsNewLength.length; j++) {
            cbxSanBayDiMap.put(descriptionsNewLength[j], valuesNewLength[j]);
        }
        cbxMaSanBayDi.setModel(cbxModel);
    }

    private void initCbxSanBayDen() throws SQLException {
        String[] descriptions = new String[sanBayBLL.getAll().size() + 1];
        String[] values = new String[sanBayBLL.getAll().size() + 1];
        descriptions[0] = "Tất cả";
        values[0] = "";

        byte i = 1;
        for (SanBayDTO sanBayDTO : sanBayBLL.getAll()) {
            if (sanBayDTO.isStatus()) {
                descriptions[i] = sanBayDTO.getTen();
                values[i] = sanBayDTO.getMaSanBay();
                i++;
            }
        }

        String[] descriptionsNewLength = Arrays.copyOf(descriptions, i);
        String[] valuesNewLength = Arrays.copyOf(values, i);

        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptionsNewLength);

        for (int j = 0; j < descriptionsNewLength.length; j++) {
            cbxSanBayDenMap.put(descriptionsNewLength[j], valuesNewLength[j]);
        }
        cbxMaSanBayDen.setModel(cbxModel);
    }

    private void initCbxTinhTrang() {
        String[] descriptions = {"Tất cả", "Khả dụng", "Không khả dụng"};
        String[] values = {"", "true", "false"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxTinhTrangMap.put(descriptions[i], values[i]);
        }
        tinhTrang.setModel(cbxModel);
    }

    private void updateComboBoxMaSanBayDen() throws SQLException {
        if (!String.valueOf(cbxMaSanBayDi.getSelectedItem()).equalsIgnoreCase("Tất cả")) {
            cbxMaSanBayDen.removeAllItems();
            cbxSanBayDenMap.clear();
            cbxMaSanBayDen.addItem("Tất cả");
            String selectedValue = String.valueOf(cbxMaSanBayDi.getSelectedItem());
            for (SanBayDTO sanBayDTO : sanBayBLL.getAll()) {
                if (!sanBayDTO.getTen().equalsIgnoreCase(selectedValue)
                        && cbxMaSanBayDi.getSelectedIndex() != 0 && sanBayDTO.isStatus()) {
                    cbxMaSanBayDen.addItem(sanBayDTO.getTen());
                    cbxSanBayDenMap.put(sanBayDTO.getTen(), sanBayDTO.getMaSanBay());
                }
            }
        } else {
            initCbxSanBayDen();
        }
    }

    private String initThoiGianBay() {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String ngayDiStr = DateJcalendarUtil.formatDate(ngayDi.getDate());
        String thoiGianDiStr = dateFormat.format(timePicker1.getSelectedDate());
        String ngayDenStr = DateJcalendarUtil.formatDate(ngayDen.getDate());
        String thoiGianDenStr = dateFormat.format(timePicker2.getSelectedDate());

        if (ngayDiStr == null || thoiGianDi.getText().isEmpty() || ngayDenStr == null || thoiGianDen.getText().isEmpty()) {
            return "";
        }
        // Định dạng thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Biến đổi chuỗi thành LocalDateTime
        LocalDateTime departureDateTime = LocalDateTime.parse(ngayDiStr + " " + thoiGianDiStr, formatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(ngayDenStr + " " + thoiGianDenStr, formatter);

        // Tính toán thời gian bay
        Duration flightDuration = Duration.between(departureDateTime, arrivalDateTime);

        // Định dạng kết quả thành giờ:phút:giây
        long hours = flightDuration.toHours();
        long minutes = flightDuration.toMinutes() % 60;
        long seconds = flightDuration.getSeconds() % 60;


        thoiGianBay.setText((hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds));
        return thoiGianBay.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker2 = new com.raven.swing.TimePicker();
        timePicker3 = new com.raven.swing.TimePicker();
        timePicker1 = new com.raven.swing.TimePicker();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxMaMayBay = new javax.swing.JComboBox<>();
        cbxMaSanBayDi = new javax.swing.JComboBox<>();
        cbxMaSanBayDen = new javax.swing.JComboBox<>();
        ngayDi = new com.toedter.calendar.JDateChooser();
        ngayDen = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ghiChu = new javax.swing.JTextArea();
        btnShowTime1 = new javax.swing.JButton();
        btnShowTime2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tinhTrang = new javax.swing.JComboBox<>();
        btnContinue = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        thoiGianDi = new javax.swing.JTextField();
        thoiGianDen = new javax.swing.JTextField();
        thoiGianBay = new javax.swing.JLabel();

        timePicker2.setDisplayText(thoiGianDen);

        timePicker1.setDisplayText(thoiGianDi);

        setTitle("Thêm chuyến bay");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(443, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thêm chuyến bay");
        jPanel3.add(jLabel1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Máy bay:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Sân bay đi:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Sân bay đến:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Ngày đi:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Ngày đến:");

        cbxMaMayBay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMaSanBayDi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxMaSanBayDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMaSanBayDiActionPerformed(evt);
            }
        });

        cbxMaSanBayDen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));


        ngayDi.setDateFormatString("yyyy-MM-dd");

        ngayDen.setDateFormatString("yyyy-MM-dd");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Ghi chú (nếu có):");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Thời gian bay (dự kiến):");

        ghiChu.setColumns(20);
        ghiChu.setRows(5);
        jScrollPane1.setViewportView(ghiChu);

        btnShowTime1.setBackground(new java.awt.Color(0, 153, 255));
        btnShowTime1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnShowTime1.setForeground(new java.awt.Color(255, 255, 255));
        btnShowTime1.setText("Chọn thời gian đi");
        btnShowTime1.setBorder(null);
        btnShowTime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTime1ActionPerformed(evt);
            }
        });

        btnShowTime2.setBackground(new java.awt.Color(0, 153, 255));
        btnShowTime2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnShowTime2.setForeground(new java.awt.Color(255, 255, 255));
        btnShowTime2.setText("Chọn thời gian đến");
        btnShowTime2.setBorder(null);
        btnShowTime2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTime2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Tình trạng:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Thời gian đi:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Thời gian đến:");

        tinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnContinue.setBackground(new java.awt.Color(0, 153, 255));
        btnContinue.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnContinue.setForeground(new java.awt.Color(255, 255, 255));
        btnContinue.setText("Tiếp tục");
        btnContinue.setBorder(null);
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 153, 255));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Hủy");
        btnCancel.setBorder(null);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 153, 255));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Đặt lại");
        btnRefresh.setBorder(null);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnRefreshActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thoiGianDi.setEditable(false);
        thoiGianDi.setBackground(new java.awt.Color(255, 255, 255));
        thoiGianDi.setBorder(null);
        thoiGianDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoiGianDiActionPerformed(evt);
            }
        });

        thoiGianDen.setEditable(false);
        thoiGianDen.setBackground(new java.awt.Color(255, 255, 255));
        thoiGianDen.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ngayDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMaMayBay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnShowTime1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addComponent(thoiGianDi))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(cbxMaSanBayDi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(ngayDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnShowTime2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jLabel14)
                            .addComponent(thoiGianDen))))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(cbxMaSanBayDen, 0, 193, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(tinhTrang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thoiGianBay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMaMayBay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMaSanBayDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMaSanBayDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ngayDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ngayDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thoiGianBay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(thoiGianDi, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(thoiGianDen)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnShowTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnShowTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    public void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnShowTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTime1ActionPerformed
        timePicker1.showPopup(this, 100, 100);
        timePicker1.setLocation(700, 800);
    }//GEN-LAST:event_btnShowTime1ActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        String thoiGianBayStr = initThoiGianBay();

        StringBuilder errorMessages = new StringBuilder();
        chuyenBayBLL.validate(errorMessages, this);
        if (!errorMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, errorMessages, "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        thoiGianDi.setText(dateFormat.format(timePicker1.getSelectedDate()));
        thoiGianDen.setText(dateFormat.format(timePicker2.getSelectedDate()));
        String thoiGianDiStr = DateJcalendarUtil.formatDate(ngayDi.getDate()) + "T" + thoiGianDi.getText();
        String thoiGianDenStr = DateJcalendarUtil.formatDate(ngayDen.getDate()) + "T" + thoiGianDen.getText();
        ChuyenBayDTO chuyenBayDTO = new ChuyenBayDTO();
        chuyenBayDTO.setNgayDi(LocalDateTime.parse(thoiGianDiStr));
        chuyenBayDTO.setNgayDen(LocalDateTime.parse(thoiGianDenStr));
        chuyenBayDTO.setThoiGianBay(thoiGianBayStr);
        chuyenBayDTO.setGhiChu(ghiChu.getText());
        chuyenBayDTO.setTinhTrang(Boolean.parseBoolean(cbxTinhTrangMap.get(tinhTrang.getSelectedItem().toString())));

        int choice = JOptionPane.showConfirmDialog(this,
                "          Bạn có chắc chắn muốn thêm chuyến bay này\nHành động này sẽ lưu dữ liệu chuyến bay trực tiếp vào hệ thống",
                "Xác nhận thêm chuyến bay", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (choice == JOptionPane.YES_NO_OPTION) {
            boolean isDone = chuyenBayBLL.create(chuyenBayDTO, Integer.parseInt(cbxMaMayBayMap.get(cbxMaMayBay.getSelectedItem().toString())),
                    cbxSanBayDiMap.get(cbxMaSanBayDi.getSelectedItem().toString()), cbxSanBayDenMap.get(cbxMaSanBayDen.getSelectedItem().toString()));
            if (isDone) {
                ticket_type_panel.loadDataTable();
                JOptionPane.showMessageDialog(null, "Thêm mới chuyến bay thành công!\nBây giờ bạn hãy tiếp tục thêm loại vé!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                closeDialog(null);

                Ticket_Type_Add_Dialog dialog = new Ticket_Type_Add_Dialog(new java.awt.Frame(), true, ticket_type_panel);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.closeDialog(null);
                    }
                });

                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnContinueActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        closeDialog(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnShowTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTime2ActionPerformed
        timePicker2.showPopup(this, 100, 100);
        timePicker2.setLocation(700, 800);
    }//GEN-LAST:event_btnShowTime2ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnRefreshActionPerformed
        initCbxSanBayDi();
        initCbxSanBayDen();
        initCbxMaMayBay();
        initCbxTinhTrang();
        cbxMaMayBay.setSelectedIndex(0);
        cbxMaSanBayDi.setSelectedIndex(0);
        cbxMaSanBayDen.setSelectedIndex(0);
        tinhTrang.setSelectedIndex(0);
        ngayDi.setDate(null);
        ngayDen.setDate(null);
        thoiGianDi.setText("");
        thoiGianDen.setText("");
        thoiGianBay.setText("");
        ghiChu.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void thoiGianDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoiGianDiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thoiGianDiActionPerformed

    private void cbxMaSanBayDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMaSanBayDiActionPerformed
        try {
            updateComboBoxMaSanBayDen();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_cbxMaSanBayDiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChuyenBay_Add_Dialog dialog = null;
                try {
                    dialog = new ChuyenBay_Add_Dialog(new java.awt.Frame(), true, null);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JComboBox<String> getCbxMaMayBay() {
        return cbxMaMayBay;
    }

    public JComboBox<String> getCbxMaSanBayDen() {
        return cbxMaSanBayDen;
    }

    public JComboBox<String> getCbxMaSanBayDi() {
        return cbxMaSanBayDi;
    }

    public JDateChooser getNgayDen() {
        return ngayDen;
    }

    public JDateChooser getNgayDi() {
        return ngayDi;
    }


    public JTextField getThoiGianDen() {
        return thoiGianDen;
    }

    public JTextField getThoiGianDi() {
        return thoiGianDi;
    }

    public JComboBox<String> getTinhTrang() {
        return tinhTrang;
    }

    public JLabel getThoiGianBay() {
        return thoiGianBay;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnShowTime1;
    private javax.swing.JButton btnShowTime2;
    private javax.swing.JComboBox<String> cbxMaMayBay;
    private javax.swing.JComboBox<String> cbxMaSanBayDen;
    private javax.swing.JComboBox<String> cbxMaSanBayDi;
    private javax.swing.JTextArea ghiChu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser ngayDen;
    private com.toedter.calendar.JDateChooser ngayDi;
    private javax.swing.JLabel thoiGianBay;
    private javax.swing.JTextField thoiGianDen;
    private javax.swing.JTextField thoiGianDi;
    private com.raven.swing.TimePicker timePicker1;
    private com.raven.swing.TimePicker timePicker2;
    private com.raven.swing.TimePicker timePicker3;
    private javax.swing.JComboBox<String> tinhTrang;
    // End of variables declaration//GEN-END:variables
}
