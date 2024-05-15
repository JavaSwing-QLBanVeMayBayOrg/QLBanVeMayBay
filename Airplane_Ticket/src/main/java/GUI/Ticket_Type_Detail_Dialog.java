/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package GUI;

import BLL.LoaiVeMayBayBLL;
import DTO.KhachHangDTO;
import DTO.LoaiVeMayBayDTO;
import Util.DateUtil;
import Util.ParseMoneyUtil;
import Util.TimeUtil;

/**
 *
 * @author User
 */
public class Ticket_Type_Detail_Dialog extends java.awt.Dialog {
    private LoaiVeMayBayBLL loaiVeMayBayBLL = new LoaiVeMayBayBLL();
    private Ticket_Type_Panel ticket_type_panel;
    public Ticket_Type_Detail_Dialog(java.awt.Frame parent, boolean modal, Ticket_Type_Panel ticket_type_panel) {
        super(parent, modal);
        initComponents();
        this.ticket_type_panel = ticket_type_panel;
        initTicketTypeDetail();
    }

    private void initTicketTypeDetail() {
        int idLoaiVe = Integer.parseInt(ticket_type_panel.getId().getText());
        LoaiVeMayBayDTO loaiVeMayBayDTO = loaiVeMayBayBLL.findById(idLoaiVe);
        maLoaiVe.setText(String.valueOf(loaiVeMayBayDTO.getId()));
        maChuyenBay.setText(String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getId()));

        String ngayKhoiHanhStr = String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getNgayDi()).substring(0, 10);
        String thoiGianKhoiHanhStr = String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getNgayDi()).substring(11).length() < 6 ?
                String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getNgayDi()).substring(11) + ":00" : String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getNgayDi()).substring(11);
        ngayKhoiHanh.setText(DateUtil.formatDate(ngayKhoiHanhStr));
        thoiGianKhoiHanh.setText(TimeUtil.convertToFullTime(thoiGianKhoiHanhStr));

        String ngayDenNoiStr = String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getNgayDen()).substring(0, 10);
        String thoiGianDenStr = String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getNgayDen()).substring(11).length() < 6 ?
                String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getNgayDen()).substring(11) + ":00" : String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getNgayDen()).substring(11);
        ngayDenNoi.setText(DateUtil.formatDate(ngayDenNoiStr));
        thoiGianDenNoi.setText(TimeUtil.convertToFullTime(thoiGianDenStr));

        thoiGianBay.setText(TimeUtil.convertToFullTime(String.valueOf(loaiVeMayBayDTO.getIdChuyenBay().getThoiGianBay())));
        soLuongVe.setText(String.valueOf(loaiVeMayBayDTO.getSoLuongVeCon()));
        giaVe.setText(ParseMoneyUtil.formatCurrency(loaiVeMayBayDTO.getGiaVe()));
        hangVe.setText(loaiVeMayBayDTO.getHangVe());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmnd7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        maLoaiVe = new javax.swing.JLabel();
        ngayKhoiHanh = new javax.swing.JLabel();
        ngayDenNoi = new javax.swing.JLabel();
        thoiGianBay = new javax.swing.JLabel();
        giaVe = new javax.swing.JLabel();
        maChuyenBay = new javax.swing.JLabel();
        thoiGianKhoiHanh = new javax.swing.JLabel();
        thoiGianDenNoi = new javax.swing.JLabel();
        soLuongVe = new javax.swing.JLabel();
        hangVe = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        cmnd7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmnd7.setText("jLabel1");

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(435, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thông tin chi tiết");
        jPanel3.add(jLabel2);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Ngày đến nơi:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Mã loại vé:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Mã chuyến bay:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Ngày khởi hành:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Thời gian đến nơi:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Số lượng vé:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setText("Thời gian khởi hành:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setText("Hạng vé:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setText("Thời gian bay:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setText("Giá vé:");

        maLoaiVe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        maLoaiVe.setText("jLabel1");

        ngayKhoiHanh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ngayKhoiHanh.setText("jLabel1");

        ngayDenNoi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ngayDenNoi.setText("jLabel1");

        thoiGianBay.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        thoiGianBay.setText("jLabel1");

        giaVe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        giaVe.setText("jLabel1");

        maChuyenBay.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        maChuyenBay.setText("jLabel1");

        thoiGianKhoiHanh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        thoiGianKhoiHanh.setText("jLabel1");

        thoiGianDenNoi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        thoiGianDenNoi.setText("jLabel1");

        soLuongVe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        soLuongVe.setText("jLabel1");

        hangVe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        hangVe.setText("jLabel1");

        btnCancel.setBackground(new java.awt.Color(0, 153, 255));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Trở về");
        btnCancel.setBorder(null);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thoiGianBay, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(giaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngayDenNoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ngayKhoiHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thoiGianKhoiHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maChuyenBay, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 13, Short.MAX_VALUE))
                            .addComponent(thoiGianDenNoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soLuongVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hangVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maLoaiVe)
                    .addComponent(maChuyenBay))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngayKhoiHanh)
                    .addComponent(thoiGianKhoiHanh))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngayDenNoi)
                    .addComponent(thoiGianDenNoi))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thoiGianBay)
                    .addComponent(soLuongVe))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giaVe)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hangVe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        closeDialog(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ticket_Type_Detail_Dialog dialog = new Ticket_Type_Detail_Dialog(new java.awt.Frame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel cmnd7;
    private javax.swing.JLabel giaVe;
    private javax.swing.JLabel hangVe;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel maChuyenBay;
    private javax.swing.JLabel maLoaiVe;
    private javax.swing.JLabel ngayDenNoi;
    private javax.swing.JLabel ngayKhoiHanh;
    private javax.swing.JLabel soLuongVe;
    private javax.swing.JLabel thoiGianBay;
    private javax.swing.JLabel thoiGianDenNoi;
    private javax.swing.JLabel thoiGianKhoiHanh;
    // End of variables declaration//GEN-END:variables
}
