/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.HangThanThietBLL;
import BLL.KhachHangBLL;
import BLL.MayBayBLL;
import DTO.HangThanThietDTO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import Util.DateJcalendarUtil;
import Util.ParseLocalDateToDateUtil;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ASUS
 */
public class MayBay_Update extends javax.swing.JFrame {
    private MayBayBLL mayBayBLL = new MayBayBLL();
    private MayBay_Panel mayBay_panel;
    private Map<String, String> cbxTinhTrangMap = new HashMap<>();

    public MayBay_Update(MayBay_Panel mayBay_panel) {
        initComponents();
        this.setTitle("Chỉnh sửa máy bay");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.mayBay_panel = mayBay_panel;
        initCbxTinhTrang();
        initmayBayEdit();
    }

    private void initmayBayEdit() {
        int id = Integer.parseInt(mayBay_panel.getIdMayBay().getText());
        MayBayDTO mayBayDTO = mayBayBLL.findByid(id);
        name.setText(mayBayDTO.getTen());
        soGheThuongGia.setText(String.valueOf(mayBayDTO.getSoGheH1()));
        soGhePhoThong.setText(String.valueOf(mayBayDTO.getSoGheH2()));
        status.setSelectedIndex(Integer.parseInt(String.valueOf(cbxTinhTrangMap.get(String.valueOf(mayBayDTO.isStatus())).equalsIgnoreCase("Khả dụng") ? '0' : '1')));
    }

    private void initCbxTinhTrang() {
        String[] descriptions = {"Khả dụng", "Không khả dụng"};
        String[] values = {"true", "false"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxTinhTrangMap.put(values[i], descriptions[i]);
        }
        status.setModel(cbxModel);
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
        soGhePhoThong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        soGheThuongGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chỉnh sửa máy bay");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        soGhePhoThong.setBorder(null);
        soGhePhoThong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soGhePhoThongActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Trạng thái:");

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
        jLabel4.setText("Tên máy bay:");

        name.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Số ghế thương gia:");

        soGheThuongGia.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Số ghế phổ thông:");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(soGhePhoThong, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soGheThuongGia, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soGheThuongGia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(soGhePhoThong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void soGhePhoThongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soGhePhoThongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soGhePhoThongActionPerformed

    private void close() {
        dispose();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        close();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int id = Integer.parseInt(mayBay_panel.getIdMayBay().getText());
        MayBayDTO mayBayDTO = mayBayBLL.findByid(id);

        if (mayBayDTO == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy máy bay trong hệ thống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder errorMessages = new StringBuilder();
        if (!mayBayDTO.getTen().equalsIgnoreCase(name.getText())) {
            mayBayBLL.validateNameExists(errorMessages, this);
        }
        mayBayBLL.validate(errorMessages, this);

        if (!errorMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, errorMessages, "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn chỉnh sửa máy bay "
                + mayBayDTO.getTen(), "Xác nhận chỉnh sửa máy bay", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_NO_OPTION) {

            mayBayDTO.setTen(name.getText());
            mayBayDTO.setSoGheH1(Integer.parseInt(soGheThuongGia.getText()));
            mayBayDTO.setSoGheH2(Integer.parseInt(soGhePhoThong.getText()));

            String targetValue = String.valueOf(status.getSelectedItem());
            for (Map.Entry<String, String> entry : cbxTinhTrangMap.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(targetValue)) {
                    mayBayDTO.setStatus(Boolean.parseBoolean(entry.getKey()));
                    break;
                }
            }

            if (mayBayBLL.update(mayBayDTO)) {
                close();
                mayBay_panel.setCheckSelectedRow(false);
                mayBay_panel.loadDataTable();
                JOptionPane.showMessageDialog(null, "     Chỉnh sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bai", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            mayBay_panel.loadDataTable();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    public MayBayBLL getMayBayBLL() {
        return mayBayBLL;
    }

    @Override
    public String getName() {
        return name.getText();
    }

    public JTextField getSoGhePhoThong() {
        return soGhePhoThong;
    }

    public JTextField getSoGheThuongGia() {
        return soGheThuongGia;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField soGhePhoThong;
    private javax.swing.JTextField soGheThuongGia;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
