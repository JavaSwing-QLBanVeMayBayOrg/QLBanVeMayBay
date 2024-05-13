package DAO;

import DTO.ChuyenBayDTO;
import DTO.LoaiVeMayBayDTO;
import DTO.MayBayDTO;
import DTO.SanBayDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LoaiVeMayBayDAO {
    public List<LoaiVeMayBayDTO> findAll() {
        List<LoaiVeMayBayDTO> loaiVeMayBayDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT c.id idCB, c.idMayBay, c.maSanBayDi, c.maSanBayDen, " +
                            "c.ngayDi, c.ngayDen, c.thoiGianBay, c.ghiChu, c.tinhTrang, " +
                            "s.maSanBay, s.ten tenSB, s.status statusSB, " +
                            "m.id idMB, m.ten tenMB, m.soGheH1, m.soGheH2, m.status statusMB, " +
                            "l.id idLV, l.idChuyenBay, l.hangVe, l.giaVe, l.soLuongVeTong, l.soLuongVeCon, l.tinhTrang statusLV " +
                            "FROM chuyenbay c " +
                            "INNER JOIN sanbay s ON c.maSanBayDi = s.maSanBay " +
                            "INNER JOIN maybay m ON c.idMayBay = m.id " +
                            "INNER JOIN loaivemaybay l on c.id = l.idChuyenBay ");

            ResultSet resultSet = preparedStatement.executeQuery();
            ChuyenBayDTO chuyenBayDTO;
            SanBayDTO sanBayDTO;
            MayBayDTO mayBayDTO;
            LoaiVeMayBayDTO loaiVeMayBayDTO;
            while (resultSet.next()) {
                sanBayDTO = new SanBayDTO();
                sanBayDTO.setMaSanBay(resultSet.getString("maSanBay"));
                sanBayDTO.setTen(resultSet.getString("tenSB"));
                sanBayDTO.setStatus(resultSet.getBoolean("statusSB"));
                mayBayDTO = new MayBayDTO();
                mayBayDTO.setId(resultSet.getInt("idMB"));
                mayBayDTO.setTen(resultSet.getString("tenMB"));
                mayBayDTO.setSoGheH1(resultSet.getInt("soGheH1"));
                mayBayDTO.setSoGheH2(resultSet.getInt("soGheH2"));
                mayBayDTO.setStatus(resultSet.getBoolean("statusMB"));
                chuyenBayDTO = new ChuyenBayDTO();
                chuyenBayDTO.setId(resultSet.getInt("idCB"));
                chuyenBayDTO.setIdMayBay(mayBayDTO);
                chuyenBayDTO.setMaSanBayDi(sanBayDTO);
                chuyenBayDTO.setMaSanBayDen(sanBayDTO);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                chuyenBayDTO.setNgayDi(LocalDateTime.parse(resultSet.getString("ngayDi"), dateFormatter));
                chuyenBayDTO.setNgayDen(LocalDateTime.parse(resultSet.getString("ngayDen"), dateFormatter));
                chuyenBayDTO.setThoiGianBay(LocalTime.parse(resultSet.getString("thoiGianBay"), DateTimeFormatter.ofPattern("HH:mm:ss")));
                chuyenBayDTO.setGhiChu(resultSet.getString("ghiChu"));
                chuyenBayDTO.setTinhTrang(resultSet.getBoolean("tinhTrang"));
                loaiVeMayBayDTO = new LoaiVeMayBayDTO();
                loaiVeMayBayDTO.setId(resultSet.getInt("idLV"));
                loaiVeMayBayDTO.setIdChuyenBay(chuyenBayDTO);
                loaiVeMayBayDTO.setHangVe(resultSet.getString("hangVe"));
                loaiVeMayBayDTO.setGiaVe(resultSet.getBigDecimal("giaVe"));
                loaiVeMayBayDTO.setSoLuongVeTong(resultSet.getInt("soLuongVeTong"));
                loaiVeMayBayDTO.setSoLuongVeCon(resultSet.getInt("soLuongVeCon"));
                loaiVeMayBayDTO.setTinhTrang(resultSet.getBoolean("statusLV"));
                loaiVeMayBayDTOList.add(loaiVeMayBayDTO);
            }
            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiVeMayBayDTOList;
    }

    public boolean create(LoaiVeMayBayDTO loaiVeMayBayDTO, int idChuyenBay) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("INSERT INTO loaivemaybay(idChuyenBay, hangVe, giaVe, soLuongVeTong, soLuongVeCon, tinhTrang) " +
                            "VALUES (?, ?, ?, ?, ?, ?) ");

            preparedStatement.setInt(1, idChuyenBay);
            preparedStatement.setString(2, loaiVeMayBayDTO.getHangVe());
            preparedStatement.setBigDecimal(3, loaiVeMayBayDTO.getGiaVe());
            preparedStatement.setInt(4, loaiVeMayBayDTO.getSoLuongVeTong());
            preparedStatement.setInt(5, loaiVeMayBayDTO.getSoLuongVeCon());
            preparedStatement.setBoolean(6, loaiVeMayBayDTO.isTinhTrang());
            boolean success = preparedStatement.executeUpdate() > 0;
            BaseDAO.closeConnection();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
