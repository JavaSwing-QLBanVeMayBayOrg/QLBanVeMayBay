package BLL;

import DAO.HangThanThietDAO;
import DTO.HangThanThietDTO;

import java.util.List;

public class HangThanThietBLL {
    private HangThanThietDAO hangThanThietDAO = new HangThanThietDAO();

    public List<HangThanThietDTO> findAll() {
        return hangThanThietDAO.findAll();
    }
}
