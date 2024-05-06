/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.HangThanThietBLL;
import BLL.KhachHangBLL;
import DTO.HangThanThietDTO;
import DTO.KhachHangDTO;
import DTO.KhachHangSearchDTO;
import Util.DateJcalendarUtil;
import Util.DateUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

/**
 * @author User
 */
public class Customer extends javax.swing.JPanel {

    private KhachHangBLL khachHangBLL = new KhachHangBLL();
    private HangThanThietBLL hangThanThietBLL = new HangThanThietBLL();
    private DefaultTableModel tblModel = new DefaultTableModel();
    private Map<String, String> cbxDiemTichLuyMap = new HashMap<>();
    private Map<String, String> cbxHangThanThietMap = new HashMap<>();
    private Map<String, String> cbxTinhTrangMap = new HashMap<>();
    private Map<String, String> cbxGioiTinhMap = new HashMap<>();

    private boolean checkSelectedRow;

    public Customer() {
        initComponents();
        initCbxDiemTichLuy();
        initCbxHangThanThiet();
        initCbxTinhTrang();
        initCbxGioiTinh();
        noChangeDataTable();
        initTable();
        fillTable();
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
    private void initCbxTinhTrang() {
        String[] descriptions = {"Tất cả", "Khả dụng", "Không khả dụng"};
        String[] values = {"", "true", "false"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxTinhTrangMap.put(descriptions[i], values[i]);
        }
        status.setModel(cbxModel);
    }

    private void initCbxHangThanThiet() {
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>();
        cbxModel.addElement("Tất cả");
        cbxHangThanThietMap.put("Tất cả", "");
        for (HangThanThietDTO hangThanThietDTO : hangThanThietBLL.findAll()) {
            cbxModel.addElement(hangThanThietDTO.getTenHang());
            cbxHangThanThietMap.put(hangThanThietDTO.getTenHang(), String.valueOf(hangThanThietDTO.getId()));
        }
        hangThanThiet.setModel(cbxModel);
    }

    private void initCbxDiemTichLuy() {
        String[] descriptions = {"Tất cả", "Dưới 100 điểm", "Từ 100 đến 200 điểm", "Từ 200 đến 300 điểm"
                , "Từ 300 đến 500 điểm", "Trên 500 điểm"};
        String[] values = {"", "lt100", "100-200", "200-300", "300-500", "gt500"};
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(descriptions);
        for (int i = 0; i < descriptions.length; i++) {
            cbxDiemTichLuyMap.put(descriptions[i], values[i]);
        }
        diemTichLuy.setModel(cbxModel);
    }

    private void fillTable() {
        tblModel.setRowCount(0);

        KhachHangSearchDTO khachHangSearchDTO = initKhachHangSearchDTO();

        for (KhachHangDTO khachHangDTO : khachHangBLL.search(khachHangSearchDTO)) {
            tblModel.addRow(new Object[]{khachHangDTO.getCmnd(), khachHangDTO.getHoTen(),
                    DateUtil.formatDate(String.valueOf(khachHangDTO.getNgaySinh())),
                    khachHangDTO.isGioiTinh() ? "Nam" : "Nữ",
                    khachHangDTO.getSoDienThoai(), khachHangDTO.getDiaChi(), khachHangDTO.getDiemTichLuy(),
                    khachHangDTO.getIdHangThanThiet().getTenHang(),
                    khachHangDTO.isTinhTrang() ? "Khả dụng" : "Không khả dụng"});
        }
        tblModel.fireTableDataChanged();
    }

    private void initTable() {
        String[] colums = new String[]{"CMND", "Họ và tên", "Ngày sinh", "Giới tính",
                "Số điện thoại", "Địa chỉ", "Điểm tích lũy",
                "Tên hạng", "Tình trạng"};
        tblModel.setColumnIdentifiers(colums);
        tableCustomer.setModel(tblModel);
    }

    public void loadDataTable() {
        fillTable();
    }

    private KhachHangSearchDTO initKhachHangSearchDTO() {
        KhachHangSearchDTO khachHangSearchDTO = new KhachHangSearchDTO();
        khachHangSearchDTO.setHoTen(name.getText());
        khachHangSearchDTO.setNgaySinhTu(DateJcalendarUtil.formatDate(fromBirthDate.getDate()));
        khachHangSearchDTO.setNgaySinhDen(DateJcalendarUtil.formatDate(toBirthDate.getDate()));
        khachHangSearchDTO.setSoDienThoai(phoneNumber.getText());
        khachHangSearchDTO.setDiaChi(address.getText());
        khachHangSearchDTO.setDiemTichLuy(cbxDiemTichLuyMap.get(diemTichLuy.getSelectedItem()));
        khachHangSearchDTO.setIdHangThanThiet(cbxHangThanThietMap.get(hangThanThiet.getSelectedItem()));
        khachHangSearchDTO.setTinhTrang(cbxTinhTrangMap.get(status.getSelectedItem()));
        khachHangSearchDTO.setGioiTinh(cbxGioiTinhMap.get(gender.getSelectedItem()));
        return khachHangSearchDTO;
    }

    private void refreshInputSearch() {
        name.setText("");
        fromBirthDate.setDate(null);
        toBirthDate.setDate(null);
        phoneNumber.setText("");
        address.setText("");
        diemTichLuy.setSelectedIndex(0);
        hangThanThiet.setSelectedIndex(0);
        status.setSelectedIndex(0);
        gender.setSelectedIndex(0);
    }

    private void noChangeDataTable() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        tableCustomer.setModel(tblModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fromBirthDate = new com.toedter.calendar.JDateChooser();
        toBirthDate = new com.toedter.calendar.JDateChooser();
        address = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        diemTichLuy = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        hangThanThiet = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        cmnd = new javax.swing.JTextField();
        btnView = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        setForeground(new java.awt.Color(51, 102, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(732, 497));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Danh sách khách hàng");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("Tên");

        name.setBorder(null);
        name.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("Số điện thoại");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setText("Ngày sinh từ");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel7.setText("Ngày sinh đến");

        phoneNumber.setBorder(null);
        phoneNumber.setMinimumSize(new java.awt.Dimension(64, 25));
        phoneNumber.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setText("Địa chỉ");

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gender.setMinimumSize(new java.awt.Dimension(72, 25));
        gender.setPreferredSize(new java.awt.Dimension(72, 25));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel8.setText("Giới tính");

        btnSearch.setBackground(new java.awt.Color(0, 153, 255));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 153, 255));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Đặt lại");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("Tìm kiếm khách hàng");

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setText("jButton1");

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setForeground(new java.awt.Color(0, 153, 255));
        jButton2.setText("jButton2");

        fromBirthDate.setDateFormatString("yyyy-MM-dd");
        fromBirthDate.setMinimumSize(new java.awt.Dimension(82, 25));
        fromBirthDate.setPreferredSize(new java.awt.Dimension(88, 25));

        toBirthDate.setDateFormatString("yyyy-MM-dd");
        toBirthDate.setMinimumSize(new java.awt.Dimension(82, 25));
        toBirthDate.setPreferredSize(new java.awt.Dimension(88, 25));

        address.setBorder(null);
        address.setMinimumSize(new java.awt.Dimension(64, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("Điểm tích lũy");

        diemTichLuy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        diemTichLuy.setMinimumSize(new java.awt.Dimension(72, 24));
        diemTichLuy.setPreferredSize(new java.awt.Dimension(72, 25));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel10.setText("Tên hạng");

        hangThanThiet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        hangThanThiet.setMinimumSize(new java.awt.Dimension(72, 24));
        hangThanThiet.setPreferredSize(new java.awt.Dimension(72, 25));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel11.setText("Tình trạng");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        status.setMinimumSize(new java.awt.Dimension(72, 24));
        status.setPreferredSize(new java.awt.Dimension(72, 25));

        btnCreate.setBackground(new java.awt.Color(0, 153, 255));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Thêm mới");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 153, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 153, 255));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Chỉnh sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        tableCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // chỉ được chọn 1 dòng
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(tableCustomer);

        cmnd.setEditable(false);
        cmnd.setVisible(false);
        cmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmndActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(0, 153, 255));
        btnView.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setText("Xem chi tiết");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(phoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(diemTichLuy, 0, 268, Short.MAX_VALUE))
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel6)
                                                                                        .addComponent(fromBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(hangThanThiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(toBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                                                        .addComponent(gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 535, Short.MAX_VALUE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(31, 31, 31)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(153, 153, 153)
                                                                                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(33, 33, 33)
                                                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(31, 31, 31)
                                                                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(11, 11, 11))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(toBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fromBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel8))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel10)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(hangThanThiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(diemTichLuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hangThanThietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hangThanThietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hangThanThietActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        KhachHangSearchDTO khachHangSearchDTO = initKhachHangSearchDTO();
        if (khachHangBLL.search(khachHangSearchDTO).isEmpty()) {
            checkSelectedRow = false;
            tblModel.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            checkSelectedRow = false;
            fillTable();
        }
    }

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
        refreshInputSearch();
        Customer_Add_Dialog dialog = new Customer_Add_Dialog(new java.awt.Frame(), true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.closeDialog();
            }
        });
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        refreshInputSearch();
        if (!checkSelectedRow) {
            JOptionPane.showMessageDialog(null, "Vui lòng click vào dòng khách hàng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String cmndCustomer = cmnd.getText();
        KhachHangDTO khachHangDTO = khachHangBLL.findByCMND(cmndCustomer);
        if (khachHangDTO == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng trong hệ thống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            fillTable();
            checkSelectedRow = false;
            return;
        }

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng "
                + khachHangDTO.getHoTen() + "\n          Có căn cước công dân " + khachHangDTO.getCmnd(), "Xác nhận xóa khách hàng", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_NO_OPTION) {
            if (khachHangBLL.delete(khachHangDTO)) {
                fillTable();
                JOptionPane.showMessageDialog(null, "         Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại do khách hàng vẫn còn nằm bên hóa đơn vé bán", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            checkSelectedRow = false;
            fillTable();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        refreshInputSearch();
        if (!checkSelectedRow) {
            JOptionPane.showMessageDialog(null, "Vui lòng click vào dòng khách hàng muốn chỉnh sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String cmndCustomer = cmnd.getText();
        KhachHangDTO khachHangDTO = khachHangBLL.findByCMND(cmndCustomer);
        if (khachHangDTO == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng trong hệ thống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            fillTable();
            checkSelectedRow = false;
            return;
        }
        checkSelectedRow = false;
        new Customer_Update(this);
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshInputSearch();
        checkSelectedRow = false;
        fillTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    private void cmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmndActionPerformed

    }//GEN-LAST:event_cmndActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        refreshInputSearch();
        String cmndCustomer = cmnd.getText();
        KhachHangDTO khachHangDTO = khachHangBLL.findByCMND(cmndCustomer);
        if (khachHangDTO == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng trong hệ thống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            fillTable();
            checkSelectedRow = false;
            return;
        }
        checkSelectedRow = false;

        Customer_Detail_Dialog dialog = new Customer_Detail_Dialog(new java.awt.Frame(), true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.closeDialog(null);
            }
        });
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnViewActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {
        int selectRow = tableCustomer.getSelectedRow();
        if (selectRow >= 0) {
            String id = String.valueOf(tableCustomer.getValueAt(selectRow, 0));
            cmnd.setText(id);
            checkSelectedRow = true;
        }
    }

    public JTextField getCmnd() {
        return cmnd;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.JTextField cmnd;
    private javax.swing.JComboBox<String> diemTichLuy;
    private com.toedter.calendar.JDateChooser fromBirthDate;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JComboBox<String> hangThanThiet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
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
    private javax.swing.JTextField name;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable tableCustomer;
    private com.toedter.calendar.JDateChooser toBirthDate;
    // End of variables declaration//GEN-END:variables
}