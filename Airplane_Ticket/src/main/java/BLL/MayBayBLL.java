package BLL;

import DAO.MayBayDAO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import DTO.MayBaySearchDTO;

import java.util.List;

public class MayBayBLL {
    private MayBayDAO mayBayDAO = new MayBayDAO();

    public List<MayBayDTO> search(MayBaySearchDTO mayBaySearchDTO) {
        if (mayBaySearchDTO.getTrangThai() == null) {
            mayBaySearchDTO.setTrangThai("");
        }
        return mayBayDAO.search(mayBaySearchDTO);
    }

    public MayBayDTO findByid(int id) {
        return mayBayDAO.findByid(id);
    }

    public boolean create(MayBayDTO mayBayDTO) {
        return mayBayDAO.create(mayBayDTO);
    }

    public boolean update(MayBayDTO mayBayDTO) {
        return mayBayDAO.update(mayBayDTO);
    }

    public boolean delete(MayBayDTO mayBayDTO) {
        return mayBayDAO.delete(mayBayDTO);
    }
}
