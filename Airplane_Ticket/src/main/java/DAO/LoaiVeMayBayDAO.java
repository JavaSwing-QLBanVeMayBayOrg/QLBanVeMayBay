package DAO;

import DTO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LoaiVeMayBayDAO {
    public List<LoaiVeMayBayDTO> search(LoaiVeMayBaySearchDTO loaiVeMayBaySearchDTO) {
        List<LoaiVeMayBayDTO> loaiVeMayBayDTOList = new ArrayList<>();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT c.id idCB, c.idMayBay, c.maSanBayDi, c.maSanBayDen, " +
                    "c.ngayDi, c.ngayDen, c.thoiGianBay, c.ghiChu, c.tinhTrang, " +
                    "s.maSanBay, s.ten tenSB, s.status statusSB, " +
                    "m.id idMB, m.ten tenMB, m.soGheH1, m.soGheH2, m.status statusMB, " +
                    "l.id idLV, l.idChuyenBay, l.hangVe, l.giaVe, l.soLuongVeTong, l.soLuongVeCon, l.tinhTrang statusLV " +
                    "FROM chuyenbay c " +
                    "INNER JOIN sanbay s ON c.maSanBayDi = s.maSanBay " +
                    "INNER JOIN maybay m ON c.idMayBay = m.id " +
                    "INNER JOIN loaivemaybay l on c.id = l.idChuyenBay ");

            // Tìm kiếm theo mã loại vé
            if (!loaiVeMayBaySearchDTO.getMaLoaiVe().isEmpty()) {
                stringBuilder.append("WHERE l.id = ? ");
            }

            // Tìm kiếm theo mã chuyến bay
            if (!loaiVeMayBaySearchDTO.getMaChuyenBay().isEmpty()) {
                stringBuilder.append("AND c.id = ? ");
            }

            // Tìm kiếm theo hạng vé
            if (!loaiVeMayBaySearchDTO.getHangVe().equalsIgnoreCase("Tất cả")) {
                stringBuilder.append("AND l.hangVe = ? ");
            }

            // Tìm kiếm theo giá vé
            if ("lt1".equals(loaiVeMayBaySearchDTO.getGiaVe())) {
                stringBuilder.append("AND l.giaVe < 1000000 ");
            } else if ("1-2".equals(loaiVeMayBaySearchDTO.getGiaVe())) {
                stringBuilder.append("AND l.giaVe BETWEEN 1000000 AND 2000000 ");
            } else if ("2-3".equals(loaiVeMayBaySearchDTO.getGiaVe())) {
                stringBuilder.append("AND l.giaVe BETWEEN 2000000 AND 3000000 ");
            } else if ("3-5".equals(loaiVeMayBaySearchDTO.getGiaVe())) {
                stringBuilder.append("AND l.giaVe BETWEEN 3000000 AND 5000000 ");
            } else if ("gt5".equals(loaiVeMayBaySearchDTO.getGiaVe())) {
                stringBuilder.append("AND l.giaVe > 5000000 ");
            }

            // Tìm kiếm theo số lượng vé tổng
            if (!loaiVeMayBaySearchDTO.getSoLuongVeTongTu().isEmpty()
                    || !loaiVeMayBaySearchDTO.getSoLuongVeTongDen().isEmpty()) {
                if (loaiVeMayBaySearchDTO.getSoLuongVeTongTu().isEmpty()) {
                    stringBuilder.append("AND l.soLuongVeTong <= ? ");
                } else if (loaiVeMayBaySearchDTO.getSoLuongVeTongDen().isEmpty()) {
                    stringBuilder.append("AND l.soLuongVeTong >= ? ");
                } else {
                    stringBuilder.append("AND l.soLuongVeTong BETWEEN ? AND ? ");
                }
            }

            // Tìm kiếm theo số lượng vé còn
            if (!loaiVeMayBaySearchDTO.getSoLuongVeConTu().isEmpty()
                    || !loaiVeMayBaySearchDTO.getSoLuongVeConDen().isEmpty()) {
                if (loaiVeMayBaySearchDTO.getSoLuongVeConTu().isEmpty()) {
                    stringBuilder.append("AND l.soLuongVeCon <= ? ");
                } else if (loaiVeMayBaySearchDTO.getSoLuongVeConDen().isEmpty()) {
                    stringBuilder.append("AND l.soLuongVeCon >= ? ");
                } else {
                    stringBuilder.append("AND l.soLuongVeCon BETWEEN ? AND ? ");
                }
            }

            // Tìm kiếm theo tình trạng
            if (!loaiVeMayBaySearchDTO.getTinhTrang().isEmpty()) {
                stringBuilder.append("AND l.tinhTrang = ? ");
            }

            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement(stringBuilder.toString());

            byte preparedStatementIndex = 1;
            if (!loaiVeMayBaySearchDTO.getMaLoaiVe().isEmpty()) {
                preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getMaLoaiVe()));
            }

            if (!loaiVeMayBaySearchDTO.getMaChuyenBay().isEmpty()) {
                preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getMaChuyenBay()));
            }

            if (!loaiVeMayBaySearchDTO.getHangVe().equalsIgnoreCase("Tất cả")) {
                preparedStatement.setString(preparedStatementIndex++, loaiVeMayBaySearchDTO.getHangVe());
            }

            if (!loaiVeMayBaySearchDTO.getSoLuongVeTongTu().isEmpty()
                    || !loaiVeMayBaySearchDTO.getSoLuongVeTongDen().isEmpty()) {
                if (loaiVeMayBaySearchDTO.getSoLuongVeTongTu().isEmpty()) {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getSoLuongVeTongDen()));
                } else if (loaiVeMayBaySearchDTO.getSoLuongVeTongDen().isEmpty()) {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getSoLuongVeTongTu()));
                } else {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getSoLuongVeTongTu()));
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getSoLuongVeTongDen()));
                }
            }

            if (!loaiVeMayBaySearchDTO.getSoLuongVeConTu().isEmpty()
                    || !loaiVeMayBaySearchDTO.getSoLuongVeConDen().isEmpty()) {
                if (loaiVeMayBaySearchDTO.getSoLuongVeConTu().isEmpty()) {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getSoLuongVeConDen()));
                } else if (loaiVeMayBaySearchDTO.getSoLuongVeConDen().isEmpty()) {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getSoLuongVeConTu()));
                } else {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getSoLuongVeConTu()));
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(loaiVeMayBaySearchDTO.getSoLuongVeConDen()));
                }
            }

            if (!loaiVeMayBaySearchDTO.getTinhTrang().isEmpty()) {
                preparedStatement.setBoolean(preparedStatementIndex, Boolean.parseBoolean(loaiVeMayBaySearchDTO.getTinhTrang()));
            }

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

    public LoaiVeMayBayDTO findById(int id) {
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
                            "INNER JOIN loaivemaybay l on c.id = l.idChuyenBay " +
                            "WHERE l.id = ? ");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            ChuyenBayDTO chuyenBayDTO;
            SanBayDTO sanBayDTO;
            MayBayDTO mayBayDTO;
            LoaiVeMayBayDTO loaiVeMayBayDTO;

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
                loaiVeMayBayDTO = new LoaiVeMayBayDTO();
                loaiVeMayBayDTO.setId(resultSet.getInt("idLV"));
                loaiVeMayBayDTO.setIdChuyenBay(chuyenBayDTO);
                loaiVeMayBayDTO.setHangVe(resultSet.getString("hangVe"));
                loaiVeMayBayDTO.setGiaVe(resultSet.getBigDecimal("giaVe"));
                loaiVeMayBayDTO.setSoLuongVeTong(resultSet.getInt("soLuongVeTong"));
                loaiVeMayBayDTO.setSoLuongVeCon(resultSet.getInt("soLuongVeCon"));
                loaiVeMayBayDTO.setTinhTrang(resultSet.getBoolean("statusLV"));

                return loaiVeMayBayDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(LoaiVeMayBayDTO loaiVeMayBayDTO) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("DELETE FROM loaivemaybay WHERE id = ? ");

            preparedStatement.setInt(1, loaiVeMayBayDTO.getId());

            boolean success = preparedStatement.executeUpdate() > 0;
            BaseDAO.closeConnection();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
