package DAO;

import DTO.ChuyenBayDTO;
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

public class ChuyenBayDAO {
    public List<ChuyenBayDTO> findAll() {
        List<ChuyenBayDTO> chuyenBayDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT c.id idCB, c.idMayBay, c.maSanBayDi, c.maSanBayDen, " +
                            "c.ngayDi, c.ngayDen, c.thoiGianBay, c.ghiChu, c.tinhTrang,\n" +
                            "s.maSanBay, s.ten tenSB, s.status statusSB, " +
                            "m.id idMB, m.ten tenMB, m.soGheH1, m.soGheH2, m.status statusMB\n" +
                            "FROM chuyenbay c \n" +
                            "INNER JOIN sanbay s ON c.maSanBayDi = s.maSanBay \n" +
                            "INNER JOIN maybay m ON c.idMayBay = m.id");

            ResultSet resultSet = preparedStatement.executeQuery();
            ChuyenBayDTO chuyenBayDTO;
            SanBayDTO sanBayDTO;
            MayBayDTO mayBayDTO;
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
                chuyenBayDTOList.add(chuyenBayDTO);
            }
            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chuyenBayDTOList;
    }

    public boolean create(ChuyenBayDTO chuyenBayDTO, int idMayBay, String maSanBayDi, String maSanBayDen) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("INSERT INTO chuyenbay (idMayBay, maSanBayDi, maSanBayDen, ngayDi, ngayDen, thoiGianBay, ghiChu, tinhTrang)\n" +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?) ");

            preparedStatement.setInt(1, idMayBay);
            preparedStatement.setString(2, maSanBayDi);
            preparedStatement.setString(3, maSanBayDen);
            preparedStatement.setString(4, String.valueOf(chuyenBayDTO.getNgayDi()));
            preparedStatement.setString(5, String.valueOf(chuyenBayDTO.getNgayDen()));
            preparedStatement.setString(6, String.valueOf(chuyenBayDTO.getThoiGianBay()));
            preparedStatement.setString(7, chuyenBayDTO.getGhiChu());
            preparedStatement.setBoolean(8, chuyenBayDTO.isTinhTrang());
            boolean success = preparedStatement.executeUpdate() > 0;
            BaseDAO.closeConnection();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ChuyenBayDTO findLastChuyenBay() {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT c.id idCB, c.idMayBay, c.maSanBayDi, c.maSanBayDen, c.ngayDi, c.ngayDen, c.thoiGianBay, c.ghiChu, c.tinhTrang, " +
                            "s.maSanBay, s.ten tenSB, s.status statusSB, " +
                            "m.id idMB, m.ten tenMB, m.soGheH1, m.soGheH2, m.status statusMB " +
                            "FROM chuyenbay c " +
                            "INNER JOIN sanbay s ON c.maSanBayDi = s.maSanBay " +
                            "INNER JOIN maybay m ON c.idMayBay = m.id\n" +
                            "ORDER BY idCB DESC LIMIT 1 ");

            ResultSet resultSet = preparedStatement.executeQuery();
            ChuyenBayDTO chuyenBayDTO;
            SanBayDTO sanBayDTO;
            MayBayDTO mayBayDTO;
            if (resultSet.next()) {
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
                return chuyenBayDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
