package BLL;

import DAO.ChuyenBayDAO;
import DTO.ChuyenBayDTO;

import java.util.List;

public class ChuyenBayBLL {
    private ChuyenBayDAO chuyenBayDAO = new ChuyenBayDAO();

    public List<ChuyenBayDTO> findAll() {
        return chuyenBayDAO.findAll();
    }

    public ChuyenBayDTO findLastChuyenBay() {
        return chuyenBayDAO.findLastChuyenBay();
    }

    public boolean create(ChuyenBayDTO chuyenBayDTO, int idMayBay, String maSanBayDi, String maSanBayDen) {
        return chuyenBayDAO.create(chuyenBayDTO, idMayBay, maSanBayDi, maSanBayDen);
    }
}
