package DAO;

import DTO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MayBayDAO {
    public List<MayBayDTO> search(MayBaySearchDTO mayBaySearchDTO) {
        List<MayBayDTO> mayBayDTOList = new ArrayList<>();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT id, ten, soGheH1, soGheH2, status FROM maybay ");

            // Tìm kiếm theo tên
            stringBuilder.append("WHERE ten LIKE CONCAT('%', ?, '%') ");  // 1

            // Tìm kiếm theo số ghế thương gia
            if (!mayBaySearchDTO.getSoGheThuongGiaTu().isEmpty()
                    || !mayBaySearchDTO.getSoGheThuongGiaDen().isEmpty()) {  // có sự hiện diện của số ghế thương gia
                if (mayBaySearchDTO.getSoGheThuongGiaTu().isEmpty()) {  // Lấy tất cả những số ghế <=
                    stringBuilder.append("AND soGheH1 <= ? ");
                } else if (mayBaySearchDTO.getSoGheThuongGiaDen().isEmpty()) {
                    stringBuilder.append("AND soGheH1 >= ? ");
                } else {
                    stringBuilder.append("AND soGheH1 BETWEEN ? AND ? ");
                }
            }

            // Tìm kiếm theo số ghế phổ thông
            if (!mayBaySearchDTO.getSoGhePhoThongTu().isEmpty()
                    || !mayBaySearchDTO.getSoGhePhoThongDen().isEmpty()) {  // có sự hiện diện của số ghế thương gia
                if (mayBaySearchDTO.getSoGhePhoThongTu().isEmpty()) {  // Lấy tất cả những số ghế <=
                    stringBuilder.append("AND soGheH2 <= ? ");
                } else if (mayBaySearchDTO.getSoGhePhoThongDen().isEmpty()) {
                    stringBuilder.append("AND soGheH2 >= ? ");
                } else {
                    stringBuilder.append("AND soGheH2 BETWEEN ? AND ? ");
                }
            }

            // Tìm kiếm theo tình trạng
            if (!mayBaySearchDTO.getTrangThai().isEmpty()) {
                stringBuilder.append("AND status = ? ");
            }

            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement(stringBuilder.toString());

            byte preparedStatementIndex = 1;
            preparedStatement.setString(preparedStatementIndex++, mayBaySearchDTO.getTenMaybay());

            if (!mayBaySearchDTO.getSoGheThuongGiaTu().isEmpty()
                    || !mayBaySearchDTO.getSoGheThuongGiaDen().isEmpty()) {  // có sự hiện diện của số ghế thương gia
                if (mayBaySearchDTO.getSoGheThuongGiaTu().isEmpty()) {  // Lấy tất cả những số ghế <=
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(mayBaySearchDTO.getSoGheThuongGiaDen()));
                } else if (mayBaySearchDTO.getSoGheThuongGiaDen().isEmpty()) {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(mayBaySearchDTO.getSoGheThuongGiaTu()));
                } else {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(mayBaySearchDTO.getSoGheThuongGiaTu()));
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(mayBaySearchDTO.getSoGheThuongGiaDen()));
                }
            }

            if (!mayBaySearchDTO.getSoGhePhoThongTu().isEmpty()
                    || !mayBaySearchDTO.getSoGhePhoThongDen().isEmpty()) {  // có sự hiện diện của số ghế thương gia
                if (mayBaySearchDTO.getSoGhePhoThongTu().isEmpty()) {  // Lấy tất cả những số ghế <=
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(mayBaySearchDTO.getSoGhePhoThongDen()));
                } else if (mayBaySearchDTO.getSoGhePhoThongDen().isEmpty()) {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(mayBaySearchDTO.getSoGhePhoThongTu()));
                } else {
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(mayBaySearchDTO.getSoGhePhoThongTu()));
                    preparedStatement.setInt(preparedStatementIndex++, Integer.parseInt(mayBaySearchDTO.getSoGhePhoThongDen()));
                }
            }

            if (!mayBaySearchDTO.getTrangThai().isEmpty()) {
                preparedStatement.setBoolean(preparedStatementIndex, Boolean.parseBoolean(mayBaySearchDTO.getTrangThai()));
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            MayBayDTO mayBayDTO;
            while (resultSet.next()) {
                mayBayDTO = new MayBayDTO();
                mayBayDTO.setId(resultSet.getInt("id"));
                mayBayDTO.setTen(resultSet.getString("ten"));
                mayBayDTO.setSoGheH1(resultSet.getInt("soGheH1"));
                mayBayDTO.setSoGheH2(resultSet.getInt("soGheH2"));
                mayBayDTO.setStatus(resultSet.getBoolean("status"));
                mayBayDTOList.add(mayBayDTO);
            }
            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mayBayDTOList;
    }

    public MayBayDTO findByid(int id) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT id, ten, soGheH1, soGheH2, status FROM maybay WHERE id = ? ");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                MayBayDTO mayBayDTO = new MayBayDTO();
                mayBayDTO.setId(resultSet.getInt("id"));
                mayBayDTO.setTen(resultSet.getString("ten"));
                mayBayDTO.setSoGheH1(resultSet.getInt("soGheH1"));
                mayBayDTO.setSoGheH2(resultSet.getInt("soGheH2"));
                mayBayDTO.setStatus(resultSet.getBoolean("status"));
                BaseDAO.closeConnection();
                return mayBayDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MayBayDTO findByName(String name) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT id, ten, soGheH1, soGheH2, status\n" +
                            "FROM maybay\n" +
                            "WHERE LOWER(ten) = LOWER(?) ");

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                MayBayDTO mayBayDTO = new MayBayDTO();
                mayBayDTO.setId(resultSet.getInt("id"));
                mayBayDTO.setTen(resultSet.getString("ten"));
                mayBayDTO.setSoGheH1(resultSet.getInt("soGheH1"));
                mayBayDTO.setSoGheH2(resultSet.getInt("soGheH2"));
                mayBayDTO.setStatus(resultSet.getBoolean("status"));
                BaseDAO.closeConnection();
                return mayBayDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(MayBayDTO mayBayDTO) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("INSERT INTO maybay (ten, soGheH1, soGheH2, status) \n" +
                            "VALUES (?, ?, ?, ?) ");

            preparedStatement.setString(1, mayBayDTO.getTen());
            preparedStatement.setInt(2, 54);
            preparedStatement.setInt(3, 228);
            preparedStatement.setBoolean(4, mayBayDTO.isStatus());
            boolean success = preparedStatement.executeUpdate() > 0;
            BaseDAO.closeConnection();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(MayBayDTO mayBayDTO) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("UPDATE maybay SET ten = ?, " +
                            "soGheH1 = ?, soGheH2 = ?, status = ? WHERE id = ? ");

            preparedStatement.setString(1, mayBayDTO.getTen());
            preparedStatement.setInt(2, mayBayDTO.getSoGheH1());
            preparedStatement.setInt(3, mayBayDTO.getSoGheH2());
            preparedStatement.setBoolean(4, mayBayDTO.isStatus());
            preparedStatement.setInt(5, mayBayDTO.getId());
            boolean success = preparedStatement.executeUpdate() > 0;
            BaseDAO.closeConnection();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(MayBayDTO mayBayDTO) {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("DELETE FROM maybay WHERE id = ? " +
                            "AND NOT EXISTS (" +
                            "SELECT 1 FROM chuyenbay " +
                            "WHERE idMayBay = ?)");

            preparedStatement.setInt(1, mayBayDTO.getId());
            preparedStatement.setInt(2, mayBayDTO.getId());

            boolean success = preparedStatement.executeUpdate() > 0;
            BaseDAO.closeConnection();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
