package BLL;

import DAO.MayBayDAO;
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
}
