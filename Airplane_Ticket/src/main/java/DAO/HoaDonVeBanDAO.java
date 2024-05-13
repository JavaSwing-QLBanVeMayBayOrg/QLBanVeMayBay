/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDonVeBanDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class HoaDonVeBanDAO {
    public boolean create(HoaDonVeBanDTO hoadon) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("INSERT INTO hoadonveban(idNhanVien,idKhachHangLapHoaDOn,ngayLapHoaDon, tongTien, tinhTrang)\n" +
                            "VALUES (?, ?, ?, ?, ?) ");

            preparedStatement.setString(1, hoadon.getIdNhanVien().getCmnd());
            preparedStatement.setString(2, hoadon.getIdKhachHangLapHoaDon().getCmnd());
            preparedStatement.setTimestamp(3,Timestamp.valueOf(hoadon.getNgayLapHoaDon()));
            preparedStatement.setBigDecimal(4,hoadon.getTongTien());
            preparedStatement.setBoolean(5,true);
            boolean success = preparedStatement.executeUpdate() > 0;
            BaseDAO.closeConnection();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public int find() {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT * FROM hoadonveban ORDER BY id DESC LIMIT 1");

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
     public ArrayList<HoaDonVeBanDTO> getAllHoaDon() {
    ArrayList<HoaDonVeBanDTO> danhSachHoaDon = new ArrayList<>();
    try {
        Connection connection = BaseDAO.getConnection();
        String query = "SELECT h.*, n.*, k.* FROM hoadonveban h " +
                       "INNER JOIN nhanvien n ON h.idNhanVien = n.cmnd " +
                       "INNER JOIN khachhang k ON h.idKhachHangLapHoaDon = k.cmnd";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("h.id");

            NhanVienDTO idNhanVien = new NhanVienDTO();
            idNhanVien.setCmnd(resultSet.getString("n.cmnd")); // Lấy id nhân viên từ bảng nhanvien
            idNhanVien.setHo(resultSet.getString("n.ho")); // Lấy tên nhân viên từ bảng nhanvien
            idNhanVien.setTen(resultSet.getString("n.Ten"));

            KhachHangDTO idKhachHangLapHoaDon = new KhachHangDTO();
            idKhachHangLapHoaDon.setCmnd(resultSet.getString("k.cmnd")); // Lấy id khách hàng từ bảng khachhang
            idKhachHangLapHoaDon.setHoTen(resultSet.getString("k.hoTen")); // Lấy tên khách hàng từ bảng khachhang

            LocalDateTime ngayLapHoaDon = resultSet.getTimestamp("h.ngayLapHoaDon").toLocalDateTime();
            BigDecimal tongTien = resultSet.getBigDecimal("h.tongTien");
            boolean tinhTrang = resultSet.getBoolean("h.tinhTrang");
            HoaDonVeBanDTO hoaDon = new HoaDonVeBanDTO(id, idNhanVien, idKhachHangLapHoaDon, ngayLapHoaDon, tongTien, tinhTrang);
            danhSachHoaDon.add(hoaDon);
        }
        BaseDAO.closeConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return danhSachHoaDon;
}
    public HoaDonVeBanDTO getHoaDonById(int idHoaDon) {
    HoaDonVeBanDTO hoadon = null;
    try {
        Connection connection = BaseDAO.getConnection();
        String query = "SELECT h.*, n.*, k.* FROM hoadonveban h " +
                       "INNER JOIN nhanvien n ON h.idNhanVien = n.cmnd " +
                       "INNER JOIN khachhang k ON h.idKhachHangLapHoaDon = k.cmnd " +
                       "WHERE h.id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idHoaDon);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("h.id");

            NhanVienDTO idNhanVien = new NhanVienDTO();
            idNhanVien.setCmnd(resultSet.getString("n.cmnd")); // Lấy id nhân viên từ bảng nhanvien
            idNhanVien.setHo(resultSet.getString("n.ho")); // Lấy tên nhân viên từ bảng nhanvien
            idNhanVien.setTen(resultSet.getString("n.Ten"));

            KhachHangDTO idKhachHangLapHoaDon = new KhachHangDTO();
            idKhachHangLapHoaDon.setCmnd(resultSet.getString("k.cmnd")); // Lấy id khách hàng từ bảng khachhang
            idKhachHangLapHoaDon.setHoTen(resultSet.getString("k.hoTen")); // Lấy tên khách hàng từ bảng khachhang

            LocalDateTime ngayLapHoaDon = resultSet.getTimestamp("h.ngayLapHoaDon").toLocalDateTime();
            BigDecimal tongTien = resultSet.getBigDecimal("h.tongTien");
            boolean tinhTrang = resultSet.getBoolean("h.tinhTrang");

            hoadon = new HoaDonVeBanDTO(id, idNhanVien, idKhachHangLapHoaDon, ngayLapHoaDon, tongTien, tinhTrang);
        }
        BaseDAO.closeConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return hoadon;
}
}
