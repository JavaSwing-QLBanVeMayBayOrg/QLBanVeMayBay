/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.HangThanThietBLL;
import BLL.KhachHangBLL;
import BLL.LoaiVeMayBayBLL;
import BLL.MayBayBLL;
import DTO.HangThanThietDTO;
import DTO.KhachHangDTO;
import DTO.LoaiVeMayBayDTO;
import DTO.MayBayDTO;
import Util.DateJcalendarUtil;
import Util.ParseLocalDateToDateUtil;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ASUS
 */
public class TicketType_Update extends javax.swing.JFrame {
    private LoaiVeMayBayBLL loaiVeMayBayBLL = new LoaiVeMayBayBLL();
    private Ticket_Type_Panel ticket_type_panel;
    private Map<String, String> cbxHangVeMap = new HashMap<>();
    private Map<String, String> cbxTinhTrangMap = new HashMap<>();

    public TicketType_Update(Ticket_Type_Panel ticket_type_panel) {
        initComponents();
        this.setTitle("Chỉnh sửa loại vé");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.ticket_type_panel = ticket_type_panel;
        initCbxHangVe();
        initCbxTinhTrang();
        initLoaiVeMayBayEdit();
    }

    private void initLoaiVeMayBayEdit() {
        int idVeMayBay = Integer.parseInt(ticket_type_panel.getId().getText());
        LoaiVeMayBayDTO loaiVeMayBayDTO = loaiVeMayBayBLL.findById(idVeMayBay);
        maLoaiVe.setText(String.valueOf(loaiVeMayBayDTO.getId()));
        cbxHangVe.setSelectedIndex(Integer.parseInt(cbxHangVeMap.get(loaiVeMayBayDTO.getHangVe())));
        giaVe.setText(String.valueOf(loaiVeMayBayDTO.getGiaVe()));
        soLuongVeTong.setText(String.valueOf(loaiVeMayBayDTO.getSoLuongVeTong()));
        soLuongVeCon.setText(String.valueOf(loaiVeMayBayDTO.getSoLuongVeCon()));
        cbxTinhTrang.setSelectedIndex(Integer.parseInt(String.valueOf(cbxTinhTrangMap.get(String.valueOf(loaiVeMayBayDTO.isTinhTrang())).equalsIgnoreCase("Khả dụng") ? '0' : '1')));
    }

    private void initCbxHangVe() {
        String[] descriptions = {"Thương Gia", "Phổ Thông"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxHangVeMap.put(descriptions[i], String.valueOf(i));
        }
        cbxHangVe.setModel(cbxModel);
    }

    private void initCbxTinhTrang() {
        String[] descriptions = {"Khả dụng", "Không khả dụng"};
        String[] values = {"true", "false"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxTinhTrangMap.put(values[i], descriptions[i]);
        }
        cbxTinhTrang.setModel(cbxModel);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        soLuongVeCon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        giaVe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        soLuongVeTong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxHangVe = new javax.swing.JComboBox<>();
        cbxTinhTrang = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        maLoaiVe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chỉnh sửa loại vé máy bay");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(124, 124, 124))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                .addContainerGap())
        );

        soLuongVeCon.setBorder(null);
        soLuongVeCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soLuongVeConActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Tình trạng:");

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

        btnUpdate.setBackground(new java.awt.Color(0, 153, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Chỉnh sửa");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Mã loại vé:");

        giaVe.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Giá vé:");

        soLuongVeTong.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Số lượng vé còn:");

        cbxHangVe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        cbxTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Số lượng vé tổng:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Hạng vé:");

        maLoaiVe.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(soLuongVeCon, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(giaVe, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(soLuongVeTong, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxHangVe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxTinhTrang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(maLoaiVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(maLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxHangVe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(giaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soLuongVeTong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(soLuongVeCon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void soLuongVeConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soLuongVeConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuongVeConActionPerformed

    private void close() {
        dispose();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        close();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int idVeMayBay = Integer.parseInt(ticket_type_panel.getId().getText());
        LoaiVeMayBayDTO loaiVeMayBayDTO = loaiVeMayBayBLL.findById(idVeMayBay);

        if (loaiVeMayBayDTO == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy vé này trong hệ thống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder errorMessages = new StringBuilder();
        loaiVeMayBayBLL.validate(errorMessages, this);
        if (!errorMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, errorMessages, "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn chỉnh sửa vé máy bay có mã là: " +
                loaiVeMayBayDTO.getId(), "Xác nhận chỉnh sửa vé máy bay", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_NO_OPTION) {
            loaiVeMayBayDTO.setHangVe(String.valueOf(cbxHangVe.getSelectedItem()));
            loaiVeMayBayDTO.setGiaVe(new BigDecimal(giaVe.getText()));
            loaiVeMayBayDTO.setSoLuongVeTong(Integer.parseInt(soLuongVeTong.getText()));
            loaiVeMayBayDTO.setSoLuongVeCon(Integer.parseInt(soLuongVeCon.getText()));

            String targetValue = String.valueOf(cbxTinhTrang.getSelectedItem());
            for (Map.Entry<String, String> entry : cbxTinhTrangMap.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(targetValue)) {
                    loaiVeMayBayDTO.setTinhTrang(Boolean.parseBoolean(entry.getKey()));
                    break;
                }
            }

            if (loaiVeMayBayBLL.update(loaiVeMayBayDTO)) {
                close();
                ticket_type_panel.setCheckSelectedRow(false);
                ticket_type_panel.loadDataTable();
                JOptionPane.showMessageDialog(null, "     Chỉnh sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bai", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    public JComboBox<String> getCbxHangVe() {
        return cbxHangVe;
    }

    public JComboBox<String> getCbxTinhTrang() {
        return cbxTinhTrang;
    }

    public JTextField getGiaVe() {
        return giaVe;
    }

    public JTextField getSoLuongVeCon() {
        return soLuongVeCon;
    }

    public JTextField getSoLuongVeTong() {
        return soLuongVeTong;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxHangVe;
    private javax.swing.JComboBox<String> cbxTinhTrang;
    private javax.swing.JTextField giaVe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel maLoaiVe;
    private javax.swing.JTextField soLuongVeCon;
    private javax.swing.JTextField soLuongVeTong;
    // End of variables declaration//GEN-END:variables
}
