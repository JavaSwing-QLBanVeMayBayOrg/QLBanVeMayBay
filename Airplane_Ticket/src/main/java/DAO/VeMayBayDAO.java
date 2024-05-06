/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.VeMayBayDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class VeMayBayDAO {
    public boolean create(VeMayBayDTO vemaybay) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("INSERT INTO vemaybay (idHoaDonVeBan, idKhachHang, loaiVeMayBiDi, tinhTrang, loaiVeMayBayVe)\n" +
                            "VALUES (?, ?, ?, ?, ?) ");

            preparedStatement.setInt(1, vemaybay.getIdHoaDonVeBan().getId());
            preparedStatement.setString(2, vemaybay.getIdKhachHang().getCmnd());
            preparedStatement.setInt(3, vemaybay.getIdLoaiVeMayBay().getId());
            preparedStatement.setBoolean(4,vemaybay.isTinhTrang());
            if (vemaybay.getIdLoaiVeMayVe()!=null)
            {
            preparedStatement.setInt(5, vemaybay.getIdLoaiVeMayVe().getId());
            }
            else
                 preparedStatement.setNull(5,java.sql.Types.INTEGER);
            
            

            boolean success = preparedStatement.executeUpdate() > 0;
            BaseDAO.closeConnection();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
