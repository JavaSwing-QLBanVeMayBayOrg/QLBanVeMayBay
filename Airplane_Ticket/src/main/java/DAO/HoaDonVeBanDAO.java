/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDonVeBanDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
}
