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

    public static double getDoanhthu(String year, String month) {
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        List<TongHopChuyenBayDTO> ds =hoaDonDAO.getAll(year,month);
        double dt = 0;
        for (TongHopChuyenBayDTO cb : ds) {
            dt += cb.getDoanhThu();
        }
        return dt;
    }

    public static int getSoluongve(String year, String month) {
                HoaDonDAO hoaDonDAO = new HoaDonDAO();
        List<TongHopChuyenBayDTO> ds =hoaDonDAO.getAll(year,month);
        int dt = 0;
        for (TongHopChuyenBayDTO cb : ds) {
            dt += cb.getSoluongve();
        }
        return dt;
    }

    public static List<TongHopChuyenBayDTO> getAll(String year, String month) {
        List<TongHopChuyenBayDTO> tongHopChuyenBayList = new ArrayList<>();
        try {
            String sql = "SELECT cb.idMayBay, sbDi.ten AS noiDi, sbDen.ten AS noiDen, COUNT(vm.id) AS soLuongVe, SUM(hd.tongTien) AS doanhThu "
                    + "FROM chuyenbay cb "
                    + "LEFT JOIN vemaybay vm ON cb.id = vm.id "
                    + "LEFT JOIN hoaDonVeBan hd ON vm.idHoaDonVeBan = hd.id "
                    + "LEFT JOIN sanbay sbDi ON cb.maSanBayDi = sbDi.maSanBay "
                    + "LEFT JOIN sanbay sbDen ON cb.maSanBayDen = sbDen.maSanBay "
                    + "WHERE vm.tinhTrang = '1' "
                    + "AND (YEAR(hd.ngayLapHoaDon) = ? OR ? IS NULL) "
                    + "AND (MONTH(hd.ngayLapHoaDon) = ? OR ? IS NULL) "
                    + "GROUP BY cb.idMayBay, sbDi.ten, sbDen.ten;";

            Connection connection = BaseDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, year);
            preparedStatement.setObject(2, year);
            preparedStatement.setObject(3, month);
            preparedStatement.setObject(4, month);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idMayBay = resultSet.getString("idMayBay");
                String noiDi = resultSet.getString("noiDi");
                String noiDen = resultSet.getString("noiDen");
                int soLuongVe = resultSet.getInt("soLuongVe");
                double doanhThu = resultSet.getDouble("doanhThu");

                TongHopChuyenBayDTO tongHopChuyenBay = new TongHopChuyenBayDTO(idMayBay, noiDi, noiDen, soLuongVe, doanhThu);
                tongHopChuyenBayList.add(tongHopChuyenBay);
            }

            resultSet.close();
            preparedStatement.close();
            BaseDAO.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongHopChuyenBayList;
    }

}
