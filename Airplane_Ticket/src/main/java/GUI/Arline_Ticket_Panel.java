/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.LoaiVeBLL;
import DTO.LoaiVeMayBayDTO;
import DTO.SanBayDTO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Arline_Ticket_Panel extends javax.swing.JPanel {
    HomePage frame;
    LoaiVeMayBayDTO vedichon;
    LoaiVeMayBayDTO vevechon;
    LoaiVeBLL loaiveBLL = new LoaiVeBLL();
    Vector<LoaiVeMayBayDTO> loaiveDS;
    Vector<LoaiVeMayBayDTO> loaiveDSVe;

    public LoaiVeMayBayDTO getVedichon() {
        return vedichon;
    }

    public LoaiVeMayBayDTO getVevechon() {
        return vevechon;
    }
    
    /**
     * Creates new form Arline_Ticket_Panel
     */
    public Arline_Ticket_Panel(HomePage homepage){
        initComponents();
        frame=homepage;
       jRadioButton1.setActionCommand("jRadioButton1");
       jRadioButton2.setActionCommand("jRadioButton2");
        try {
            danhsachloaivedi();
            jScrollPane2.setVisible(false);
            jLabel5.setVisible(false);
        if (frame.getTimchuyenbay().chuyenbayve!=null)
        {
            jScrollPane2.setVisible(true);
            jLabel5.setVisible(true);
            danhsachloaiveve();
        }
         } catch (SQLException ex) {
            Logger.getLogger(Arline_Ticket_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        locDanhSachDiVe();
        
        
    }

    Arline_Ticket_Panel() {
        initComponents();
       
    }
//    private BigDecimal tienVe()
//    {
//        int row =jTable1.getSelectedRow();
//        int soluong=frame.timchuyenbay.getSoLuong();
//        return BigDecimal.valueOf(Double.parseDouble(jTable1.getValueAt(row, 7).toString())).multiply(soluong);
//    }
     private String checkRadioSelected()
    {
        String choose= buttonGroup2.getSelection().getActionCommand();
        if (choose.equals("jRadioButton2"))
        {
            return "Phổ Thông";
        }
        else
        {
           return "Thương Gia";
            
        }
    }
    public void setHomePage(HomePage home)
    {
        frame=home;
    }
    private void danhsachloaivedi() throws SQLException
    { 
        DefaultTableModel model ;
        model= (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        loaiveDS= loaiveBLL.DanhSachVeChieuDi(frame.getTimchuyenbay().getChuyenbaydi());
        for (LoaiVeMayBayDTO a:loaiveDS)
        {
            Object[] row={a.getId(),a.getIdChuyenBay().getMaSanBayDi().getMaSanBay(),a.getIdChuyenBay().getMaSanBayDen().getMaSanBay(),a.getIdChuyenBay().getNgayDi(),a.getIdChuyenBay().getNgayDen(),a.getIdChuyenBay().getThoiGianBay(),a.getHangVe(),a.getGiaVe(),a.getSoLuongVeCon()};
            model.addRow(row);
            
        
        }
    }
    private void danhsachloaiveve() throws SQLException
    { 
        DefaultTableModel model ;
        model= (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        loaiveDSVe= loaiveBLL.DanhSachVeChieuVe(frame.getTimchuyenbay().getChuyenbayve());
        for (LoaiVeMayBayDTO a:loaiveDSVe)
        {  
            Object[] row={a.getId(),a.getIdChuyenBay().getMaSanBayDi().getMaSanBay(),a.getIdChuyenBay().getMaSanBayDen().getMaSanBay(),a.getIdChuyenBay().getNgayDi(),a.getIdChuyenBay().getNgayDen(),a.getIdChuyenBay().getThoiGianBay(),a.getHangVe(),a.getGiaVe(),a.getSoLuongVeCon()};
            model.addRow(row);
        }
    }
    private void locDanhSachDiVe()
    {
        DefaultTableModel model ;
        model= (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (LoaiVeMayBayDTO a:loaiveDS)
        {
            if (checkRadioSelected().equals(a.getHangVe()))
            {
            Object[] row={a.getId(),a.getIdChuyenBay().getMaSanBayDi().getMaSanBay(),a.getIdChuyenBay().getMaSanBayDen().getMaSanBay(),a.getIdChuyenBay().getNgayDi(),a.getIdChuyenBay().getNgayDen(),a.getIdChuyenBay().getThoiGianBay(),a.getHangVe(),a.getGiaVe(),a.getSoLuongVeCon()};
            model.addRow(row);
            }

        }
        if (frame.getTimchuyenbay().chuyenbayve!=null)
        {
        DefaultTableModel model2 ;
        model2= (DefaultTableModel) jTable2.getModel();
        model2.setRowCount(0);
        for (LoaiVeMayBayDTO a:loaiveDSVe)
        {  
             if (checkRadioSelected().equals(a.getHangVe()))
            {
            Object[] row={a.getId(),a.getIdChuyenBay().getMaSanBayDi().getMaSanBay(),a.getIdChuyenBay().getMaSanBayDen().getMaSanBay(),a.getIdChuyenBay().getNgayDi(),a.getIdChuyenBay().getNgayDen(),a.getIdChuyenBay().getThoiGianBay(),a.getHangVe(),a.getGiaVe(),a.getSoLuongVeCon()};
            model2.addRow(row);
            }
        }
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText(" Đặt vé máy bay");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Vé đi khả dụng :");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã vé", "Khởi hành ", "Đến nơi", "Ngày đi", "Ngày đến", "Thời gian bay", "Hạng vé", "Giá vé", "Còn lại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Vé về khả dụng :");

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã vé", "Khởi hành", "Đến nơi", "Ngày đi", "Ngày đến", "Thời gian bay", "Hạng vé", "Giá vé", "Còn lại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
            jTable2.getColumnModel().getColumn(8).setResizable(false);
        }

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm chuyến bay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setText("Thương gia");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Phổ thông");
        jRadioButton2.setToolTipText("");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton2.setText("Xác nhận chọn vé");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame.chonChuyenBay();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (frame.getTimchuyenbay().chuyenbayve!=null)
        {
            if ((vevechon==null)||(vedichon==null))
                JOptionPane.showMessageDialog(frame,"Có vé trống ");
            else
                 frame.lapHoaDon();
        }
        else if (frame.getTimchuyenbay().chuyenbayve==null)
                if (vedichon==null)
                JOptionPane.showMessageDialog(frame,"Có vé trống ");
        else
            frame.lapHoaDon();
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       locDanhSachDiVe();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        locDanhSachDiVe();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered

    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
         int row = jTable1.getSelectedRow();
        if (row>=0)
        {
           vedichon=timVeDaChon(Integer.parseInt(jTable1.getValueAt(row, 0).toString()));
          ThongTinVeMayBay_Dialog thongtin = new ThongTinVeMayBay_Dialog(frame,true,vedichon);
          thongtin.setLocationRelativeTo(null);
          thongtin.setVisible(true);
            
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
         int row = jTable2.getSelectedRow();
        if (row>=0)
        {
           vevechon=timVeVeDaChon(Integer.parseInt(jTable2.getValueAt(row, 0).toString()));
           JOptionPane.showMessageDialog(frame, vevechon.getId());
            ThongTinVeMayBay_Dialog thongtin = new ThongTinVeMayBay_Dialog(frame,true,vevechon);
            thongtin.setLocationRelativeTo(null);
            thongtin.setVisible(true);
           
            
        }
    }//GEN-LAST:event_jTable2MousePressed
    private LoaiVeMayBayDTO timVeDaChon(int id)
    {
        for (LoaiVeMayBayDTO a:loaiveDS)
        {
            if (id==a.getId())
                return a;

        }
        return null;
    }
    private LoaiVeMayBayDTO timVeVeDaChon(int id)
    {
        for (LoaiVeMayBayDTO a:loaiveDSVe)
        {
            if (id==a.getId())
                return a;

        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
