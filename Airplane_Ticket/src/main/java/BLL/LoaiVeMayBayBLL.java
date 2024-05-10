package BLL;

import DAO.LoaiVeMayBayDAO;
import DTO.LoaiVeMayBayDTO;

import java.util.List;

public class LoaiVeMayBayBLL {
    LoaiVeMayBayDAO loaiVeMayBayDAO = new LoaiVeMayBayDAO();

    public List<LoaiVeMayBayDTO> findAll() {
        return loaiVeMayBayDAO.findAll();
    }
}
