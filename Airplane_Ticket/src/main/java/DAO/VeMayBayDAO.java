/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDonVeBanDTO;
import DTO.KhachHangDTO;
import DTO.LoaiVeMayBayDTO;
import DTO.VeMayBayDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    // Trong class DAO VeMayBayDAO

public static List<VeMayBayDTO> getListVeByHoaDonId(int idHoaDon) {
    try {
        // Khởi tạo danh sách vé
        List<VeMayBayDTO> danhSachVe = new ArrayList<>();

        // Thực hiện truy vấn SQL để lấy danh sách vé dựa trên mã hóa đơn và JOIN 3 bảng
        String sql = "select vemaybay.*,hoadonveban.* " +
                     "from hoadonveban,vemaybay " +
                     "where hoadonveban.id=vemaybay.id and hoadonveban.id=?";
        PreparedStatement preparedStatement = BaseDAO.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, idHoaDon);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Duyệt qua các dòng kết quả và thêm vé vào danh sách
        while (resultSet.next()) {
            // Tạo đối tượng vé từ dữ liệu trong ResultSet
            VeMayBayDTO ve = new VeMayBayDTO();
            // Thiết lập thông tin cho đối tượng vé từ ResultSet
            ve.setId(resultSet.getInt("mã vé"));
            
            LoaiVeMayBayDTO loaivemaybay = new LoaiVeMayBayDTO();
            loaivemaybay.setId(resultSet.getInt("mã loại vé")); 
            loaivemaybay.setHangVe(resultSet.getString("hạng vé"));
            
            KhachHangDTO khachhang = new KhachHangDTO();
            khachhang.setCmnd(resultSet.getString("Khách Hàng")); 
            khachhang.setHoTen(resultSet.getString("Khách Hàng"));
            
            // Thêm vé vào danh sách
            danhSachVe.add(ve);
        }

        // Đóng kết nối và trả về danh sách vé
        BaseDAO.closeConnection();
        return danhSachVe;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

}
