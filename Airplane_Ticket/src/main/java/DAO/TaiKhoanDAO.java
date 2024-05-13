/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanDAO {

    public TaiKhoanDTO CheckTaiKhoan(String usr, String password) throws SQLException {
        TaiKhoanDTO taikhoan = new TaiKhoanDTO();
        Connection con = BaseDAO.getConnection();
        if (con != null) {
            try {

                String sql = "Select * from taikhoan,nhanvien where taikhoan.cmndNhanVien=nhanvien.cmnd and username='" + usr + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next() == false) {
                    return null;
                } else {
                    NhanVienDTO nhanvien = new NhanVienDTO();
                    taikhoan.setUsername(rs.getString("userName"));
                    String passwordDB = rs.getString("password");
                    if (password.equals(passwordDB)) {
                        taikhoan.setPassword(password);
                        taikhoan.setTinhTrang(rs.getBoolean(4));
                        nhanvien.setCmnd(rs.getString("cmnd"));
                        nhanvien.setSoDienThoai(rs.getString("soDienThoai"));
                        nhanvien.setHo(rs.getString("ho"));
                        nhanvien.setTen(rs.getString("ten"));
                        nhanvien.setGioiTinh(rs.getBoolean("gioiTinh"));
                        nhanvien.setTinhTrang(rs.getBoolean(12));
                        taikhoan.setCmndNhanVien(nhanvien);
                    }
                }
                return taikhoan;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                BaseDAO.closeConnection();
            }
        }
        return null;
    }

    public TaiKhoanDTO getbyID(String cmnd) {
        TaiKhoanDTO taiKhoan = null;
        String sql = "SELECT userName, passWord, ngayCap, tinhTrang FROM taikhoan WHERE cmndNhanVien = ?";

        try (Connection connection = BaseDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cmnd);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String userName = resultSet.getString("userName");
                    String passWord = resultSet.getString("passWord");
                    Date ngayCap = resultSet.getDate("ngayCap");
                    boolean tinhTrang = resultSet.getBoolean("tinhTrang");
                    
                    taiKhoan = new TaiKhoanDTO(userName, passWord, ngayCap, tinhTrang);
                    System.out.println(userName + " " +passWord);
                    System.out.println(taiKhoan.getUsername() + " " +taiKhoan.getPassword());
                }
            }
            BaseDAO.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return taiKhoan;
    }

}
