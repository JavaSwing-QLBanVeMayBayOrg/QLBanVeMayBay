package DAO;

import DTO.HangThanThietDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangThanThietDAO {

    public List<HangThanThietDTO> findAll()  {
        List<HangThanThietDTO> hangThanThietDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT id, tenHang, diemTichLuy, khuyenMai FROM hangthanthiet");

            ResultSet resultSet = preparedStatement.executeQuery();
            HangThanThietDTO hangThanThietDTO;
            while (resultSet.next()) {
                hangThanThietDTO = new HangThanThietDTO();
                hangThanThietDTO.setId(resultSet.getInt("id"));
                hangThanThietDTO.setTenHang(resultSet.getString("tenHang"));
                hangThanThietDTO.setDiemTichLuy(resultSet.getInt("diemTichLuy"));
                hangThanThietDTO.setKhuyenMai(resultSet.getInt("khuyenMai"));
                hangThanThietDTOList.add(hangThanThietDTO);
            }
            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hangThanThietDTOList;
    }

}
