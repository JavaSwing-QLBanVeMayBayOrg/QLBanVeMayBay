/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.LoaiVeMayBayBLL;
import DTO.*;
import Util.DateUtil;
import Util.ParseMoneyUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class Ticket_Type_Panel extends javax.swing.JPanel {
    private LoaiVeMayBayBLL loaiVeMayBayBLL = new LoaiVeMayBayBLL();
    private DefaultTableModel tblModel = new DefaultTableModel();
    private Map<String, String> cbxGiaVeMap = new HashMap<>();
    private Map<String, String> cbxTinhTrangMap = new HashMap<>();
    private boolean checkSelectedRow;
    public Ticket_Type_Panel() {
        initComponents();
        intCbxHangVe();
        initCbxGiaVe();
        initCbxTinhTrang();
        noChangeDataTable();
        initTable();
        fillTable();
    }

    private void initTable() {
        String[] colums = new String[]{"Mã loại vé", "Mã chuyến bay", "Hạng vé", "Giá vé",
                "Số lượng vé tổng", "Số lượng vé còn", "Tình trạng"};
        tblModel.setColumnIdentifiers(colums);
        tableLoaiVe.setModel(tblModel);
    }

    private void fillTable() {
        tblModel.setRowCount(0);
        LoaiVeMayBaySearchDTO loaiVeMayBaySearchDTO = initLoaiVeMayBaySearchDTO();
        for (LoaiVeMayBayDTO loaiVeMayBayDTO : loaiVeMayBayBLL.search(loaiVeMayBaySearchDTO)) {
            tblModel.addRow(new Object[]{loaiVeMayBayDTO.getId(), loaiVeMayBayDTO.getIdChuyenBay().getId(),
                    loaiVeMayBayDTO.getHangVe(), ParseMoneyUtil.formatCurrency(loaiVeMayBayDTO.getGiaVe()), loaiVeMayBayDTO.getSoLuongVeTong(),
                    loaiVeMayBayDTO.getSoLuongVeCon(), loaiVeMayBayDTO.isTinhTrang() ? "Khả dụng" : "Không khả dụng"});
        }
        tblModel.fireTableDataChanged();
    }

    private void intCbxHangVe() {
        String[] descriptions = {"Tất cả", "Thương Gia", "Phổ Thông"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        cbxHangVe.setModel(cbxModel);
    }

    private void initCbxGiaVe() {
        String[] descriptions = {"Tất cả", "Dưới 1 triệu", "Từ 1 triệu đến 2 triệu", "Từ 2 triệu đến 3 triệu"
                , "Từ 3 triệu đến 5 triệu", "Trên 5 triệu"};
        String[] values = {"", "lt1", "1-2", "2-3", "3-5", "gt5"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxGiaVeMap.put(descriptions[i], values[i]);
        }
        cbxGiaVe.setModel(cbxModel);
    }

    private void initCbxTinhTrang() {
        String[] descriptions = {"Tất cả", "Khả dụng", "Không khả dụng"};
        String[] values = {"", "true", "false"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxTinhTrangMap.put(descriptions[i], values[i]);
        }
        cbxTinhTrang.setModel(cbxModel);
    }

    private LoaiVeMayBaySearchDTO initLoaiVeMayBaySearchDTO() {
        LoaiVeMayBaySearchDTO loaiVeMayBaySearchDTO = new LoaiVeMayBaySearchDTO();
        loaiVeMayBaySearchDTO.setMaLoaiVe(idLoaiVe.getText());
        loaiVeMayBaySearchDTO.setMaChuyenBay(idChuyenBay.getText());
        loaiVeMayBaySearchDTO.setHangVe(String.valueOf(cbxHangVe.getSelectedItem()));
        loaiVeMayBaySearchDTO.setGiaVe(cbxGiaVeMap.get(cbxGiaVe.getSelectedItem()));
        loaiVeMayBaySearchDTO.setSoLuongVeTongTu(soLuongVeTongTu.getText());
        loaiVeMayBaySearchDTO.setSoLuongVeTongDen(soLuongVeTongDen.getText());
        loaiVeMayBaySearchDTO.setSoLuongVeConTu(soLuongVeConTu.getText());
        loaiVeMayBaySearchDTO.setSoLuongVeConDen(soLuongVeConDen.getText());
        loaiVeMayBaySearchDTO.setTinhTrang(cbxTinhTrangMap.get(cbxTinhTrang.getSelectedItem()));
        return loaiVeMayBaySearchDTO;
    }

    public void loadDataTable() {
        fillTable();
    }

    private void refreshInputSearch() {
        idLoaiVe.setText("");
        idChuyenBay.setText("");
        cbxHangVe.setSelectedIndex(0);
        cbxGiaVe.setSelectedIndex(0);
        soLuongVeTongTu.setText("");
        soLuongVeTongDen.setText("");
        soLuongVeConTu.setText("");
        soLuongVeConDen.setText("");
        cbxTinhTrang.setSelectedIndex(0);
    }

    private void noChangeDataTable() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        tableLoaiVe.setModel(tblModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        idLoaiVe = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLoaiVe = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idChuyenBay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxGiaVe = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxHangVe = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        soLuongVeTongTu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        soLuongVeTongDen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        soLuongVeConDen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        soLuongVeConTu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxTinhTrang = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        id = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText(" Tìm kiếm loại vé");

        idLoaiVe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLoaiVe.setBorder(null);
        id.setVisible(false);
        id.setEditable(false);
        tableLoaiVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Chọn", "Mã loại vé", "Mã chuyến bay", "Số lượng còn lại", "Số lượng", "Hạng vé", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLoaiVe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableLoaiVe.getTableHeader().setReorderingAllowed(false);
        tableLoaiVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLoaiVeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLoaiVe);
        if (tableLoaiVe.getColumnModel().getColumnCount() > 0) {
            tableLoaiVe.getColumnModel().getColumn(0).setResizable(false);
            tableLoaiVe.getColumnModel().getColumn(1).setResizable(false);
            tableLoaiVe.getColumnModel().getColumn(2).setResizable(false);
            tableLoaiVe.getColumnModel().getColumn(3).setResizable(false);
            tableLoaiVe.getColumnModel().getColumn(4).setResizable(false);
            tableLoaiVe.getColumnModel().getColumn(5).setResizable(false);
            tableLoaiVe.getColumnModel().getColumn(6).setResizable(false);
        }

        btnCreate.setBackground(new java.awt.Color(0, 153, 255));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Thêm loại vé");
        btnCreate.setBorder(null);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnCreateActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText(" Danh sách loại vé");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("Hạng vé");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("Mã loại vé");

        idChuyenBay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idChuyenBay.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setText("Mã chuyến bay");

        cbxGiaVe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setText("Giá vé");

        cbxHangVe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel7.setText("Số lượng vé tổng từ");

        soLuongVeTongTu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        soLuongVeTongTu.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel8.setText("Số lượng vé tổng đến");

        soLuongVeTongDen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        soLuongVeTongDen.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel9.setText("Số lượng vé còn đến");

        soLuongVeConDen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        soLuongVeConDen.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel10.setText("Số lượng vé còn từ");

        soLuongVeConTu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        soLuongVeConTu.setBorder(null);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel11.setText("Tình trạng");

        cbxTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRefresh.setBackground(new java.awt.Color(0, 153, 255));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Đặt lại");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 153, 255));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm kiếm");
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 135, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.setBorder(null);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idChuyenBay, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxHangVe, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(soLuongVeConTu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(soLuongVeTongTu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(soLuongVeConDen, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(soLuongVeTongDen, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cbxTinhTrang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idChuyenBay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxHangVe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soLuongVeTongTu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soLuongVeTongDen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(soLuongVeConDen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soLuongVeConTu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnCreateActionPerformed
        ChuyenBay_Add_Dialog dialog = new ChuyenBay_Add_Dialog(new java.awt.Frame(), true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.closeDialog(e);
            }
        });
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        LoaiVeMayBaySearchDTO loaiVeMayBaySearchDTO = initLoaiVeMayBaySearchDTO();
        if (loaiVeMayBayBLL.search(loaiVeMayBaySearchDTO).isEmpty()) {
            tblModel.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            fillTable();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshInputSearch();
        fillTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tableLoaiVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLoaiVeMouseClicked
        int selectRow = tableLoaiVe.getSelectedRow();
        if (selectRow >= 0) {
            String idLoaiVe = String.valueOf(tableLoaiVe.getValueAt(selectRow, 0));
            id.setText(idLoaiVe);
            checkSelectedRow = true;
        }
    }//GEN-LAST:event_tableLoaiVeMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        refreshInputSearch();
        if (!checkSelectedRow) {
            JOptionPane.showMessageDialog(null, "Vui lòng click vào dòng vé muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int idLoaiVe = Integer.parseInt(id.getText());

        LoaiVeMayBayDTO loaiVeMayBayDTO = loaiVeMayBayBLL.findById(idLoaiVe);
        if (loaiVeMayBayDTO == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy vé máy bay trong hệ thống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            fillTable();
            checkSelectedRow = false;
            return;
        }

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa vé này ", "Xác nhận xóa vé", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_NO_OPTION) {
            if (loaiVeMayBayBLL.delete(loaiVeMayBayDTO)) {
                fillTable();
                JOptionPane.showMessageDialog(null, "         Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "         Xóa thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            checkSelectedRow = false;
            fillTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxGiaVe;
    private javax.swing.JComboBox<String> cbxHangVe;
    private javax.swing.JComboBox<String> cbxTinhTrang;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idChuyenBay;
    private javax.swing.JTextField idLoaiVe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField soLuongVeConDen;
    private javax.swing.JTextField soLuongVeConTu;
    private javax.swing.JTextField soLuongVeTongDen;
    private javax.swing.JTextField soLuongVeTongTu;
    private javax.swing.JTable tableLoaiVe;
    // End of variables declaration//GEN-END:variables
}
