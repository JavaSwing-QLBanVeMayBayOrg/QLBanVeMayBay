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

    public static List<TongHopChuyenBayDTO> getAll(String username) {
        List<TongHopChuyenBayDTO> tongHopChuyenBayList = new ArrayList<>();
        try {
            // Tạo câu truy vấn SQL để lấy thông tin tổng hợp chuyến bay
            String sql = "SELECT cb.id AS 'ID Máy Bay', " +
                "sbDi.ten AS 'Nơi Bắt Đầu', " +
                "sbDen.ten AS 'Nơi Đáp', " +
                "COUNT(vmb.id) AS 'Số Vé Bán Ra' " +
                "FROM chuyenbay cb " +
                "INNER JOIN sanbay sbDi ON cb.maSanBayDi = sbDi.maSanBay " +
                "INNER JOIN sanbay sbDen ON cb.maSanBayDen = sbDen.maSanBay " +
                "LEFT JOIN vemaybay vmb ON cb.id = vmb.id " +
                "GROUP BY cb.id, sbDi.ten, sbDen.ten";

            // Lấy kết nối tới cơ sở dữ liệu
            Connection connection = BaseDAO.getConnection();

            // Tạo PreparedStatement với câu lệnh SQL select
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            // Thực thi câu lệnh select
            ResultSet resultSet = preparedStatement.executeQuery();

            // Duyệt qua kết quả và thêm vào danh sách tongHopChuyenBayList
            while (resultSet.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng TongHopChuyenBayDTO
                String idMayBay = resultSet.getString("ID_MayBay");
                String noiDi = resultSet.getString("Noi_Bat_Dau");
                String noiDen = resultSet.getString("Noi_Dap");
                int soLuongVe = resultSet.getInt("So_Ve_Ban_Ra");

                // Tạo đối tượng TongHopChuyenBayDTO và thêm vào danh sách
                TongHopChuyenBayDTO tongHopChuyenBay = new TongHopChuyenBayDTO(idMayBay, noiDi, noiDen, soLuongVe);
                tongHopChuyenBayList.add(tongHopChuyenBay);
            }

            // Đóng kết nối
            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongHopChuyenBayList;
    }

}
