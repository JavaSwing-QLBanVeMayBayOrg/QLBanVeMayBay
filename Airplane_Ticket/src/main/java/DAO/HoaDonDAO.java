/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDonVeBanDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.TongHopChuyenBayDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class HoaDonDAO {

    public static String getDoanhthu() {
        try {
            String sql = "SELECT SUM(hdvb.tongTien) AS TongTienBanVe "
                    + "FROM hoaDonVeBan hdvb "
                    + "JOIN vemaybay vmb ON hdvb.id = vmb.idHoaDonVeBan;";
            // Lấy kết nối tới cơ sở dữ liệu
            Connection connection = BaseDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            String doanhthu = null;

            if (resultSet.next()) {
                doanhthu = resultSet.getString("TongTienBanVe");
            }

            resultSet.close();
            preparedStatement.close();
            BaseDAO.closeConnection();

            return doanhthu;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getSoluongve() {
        try {
            String sql = "SELECT SUM(T1.So_Ve_Ban_Ra) AS 'Tong_So_Ve_Ban_Ra'\n"
                    + "FROM (\n"
                    + "    SELECT cb.id AS 'ID_MayBay', sbDi.ten AS 'Noi_Bat_Dau', sbDen.ten AS 'Noi_Dap', COUNT(vmb.id) AS 'So_Ve_Ban_Ra'\n"
                    + "    FROM chuyenbay cb\n"
                    + "    INNER JOIN sanbay sbDi ON cb.maSanBayDi = sbDi.maSanBay\n"
                    + "    INNER JOIN sanbay sbDen ON cb.maSanBayDen = sbDen.maSanBay\n"
                    + "    LEFT JOIN vemaybay vmb ON cb.id = vmb.id\n"
                    + "    GROUP BY cb.id, sbDi.ten, sbDen.ten\n"
                    + ") AS T1;";
            Connection connection = BaseDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            int soluongve = 0;
            if (resultSet.next()) {
                soluongve = resultSet.getInt("Tong_So_Ve_Ban_Ra");
            }
            resultSet.close();
            preparedStatement.close();
            BaseDAO.closeConnection();

            return soluongve;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<TongHopChuyenBayDTO> getAll(String username) {
        List<TongHopChuyenBayDTO> tongHopChuyenBayList = new ArrayList<>();
        try {
            String sql = "SELECT cb.id AS 'ID_MayBay',sbDi.ten AS 'Noi_Bat_Dau',sbDen.ten AS 'Noi_Dap', COUNT(vmb.id) AS 'So_Ve_Ban_Ra' FROM chuyenbay cb INNER JOIN sanbay sbDi ON cb.maSanBayDi = sbDi.maSanBay INNER JOIN sanbay sbDen ON cb.maSanBayDen = sbDen.maSanBay LEFT JOIN vemaybay vmb ON cb.id = vmb.id GROUP BY cb.id, sbDi.ten, sbDen.ten";
            Connection connection = BaseDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idMayBay = resultSet.getString("ID_MayBay");
                String noiDi = resultSet.getString("Noi_Bat_Dau");
                String noiDen = resultSet.getString("Noi_Dap");
                int soLuongVe = resultSet.getInt("So_Ve_Ban_Ra");

                TongHopChuyenBayDTO tongHopChuyenBay = new TongHopChuyenBayDTO(idMayBay, noiDi, noiDen, soLuongVe);
                tongHopChuyenBayList.add(tongHopChuyenBay);
            }

            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongHopChuyenBayList;
    }

}
