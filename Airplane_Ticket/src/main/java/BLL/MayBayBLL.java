package BLL;

import DAO.MayBayDAO;
import DTO.KhachHangDTO;
import DTO.MayBayDTO;
import DTO.MayBaySearchDTO;
import GUI.Customer_Add_Dialog;
import GUI.MayBay_Update;
import GUI.ThemMayBay_Dialog;
import Util.DateJcalendarUtil;

import java.time.LocalDate;
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

    public void validate(StringBuilder errorMessage, ThemMayBay_Dialog themMayBay_dialog) {
        String nameStr = themMayBay_dialog.getName().trim();
        String statusStr = themMayBay_dialog.getStatus().getSelectedItem().toString();

        if (nameStr.isEmpty()) {
            errorMessage.append("Tên không được để trống\n");
        } else if (!nameStr.matches("^[a-zA-Z0-9\\s]+$")) {
            errorMessage.append("Tên không được chứa kí tự đặc biệt\n");
        }

        if (statusStr.equalsIgnoreCase("Tất cả")) {
            errorMessage.append("Bắt buộc phải chọn tình trạng");
        }
    }

    public void validateNameExists(StringBuilder errorMessage, ThemMayBay_Dialog themMayBay_dialog) {
        String nameStr = themMayBay_dialog.getName().trim();
        if (mayBayDAO.findByName(nameStr) != null) {
            errorMessage.append("Tên máy bay đã tồn tại trong hệ thống\n");
        }
    }
    // =================================
    public void validate(StringBuilder errorMessage, MayBay_Update mayBay_update) {
        String nameStr = mayBay_update.getName().trim();
        String soGheThuongGiaStr = mayBay_update.getSoGheThuongGia().getText().trim();
        String soGhePhoThongStr = mayBay_update.getSoGhePhoThong().getText().trim();

        if (nameStr.isEmpty()) {
            errorMessage.append("Tên không được để trống\n");
        } else if (!nameStr.matches("^[a-zA-Z0-9\\s]+$")) {
            errorMessage.append("Tên không được chứa kí tự đặc biệt\n");
        }

        if (soGheThuongGiaStr.isEmpty()) {
            errorMessage.append("Số ghế thương gia không được để trống\n");
        } else if (!soGheThuongGiaStr.matches("^[0-9]+$")) {
            errorMessage.append("Số ghế thương gia phải là số\n");
        } else if (Integer.parseInt(soGheThuongGiaStr) <= 0) {
            errorMessage.append("Số ghế thương gia không được nhỏ hơn 1\n");
        }

        if (soGhePhoThongStr.isEmpty()) {
            errorMessage.append("Số ghế phổ thông không được để trống\n");
        } else if (!soGhePhoThongStr.matches("^[0-9]+$")) {
            errorMessage.append("Số ghế phổ thông phải là số\n");
        } else if (Integer.parseInt(soGhePhoThongStr) <= 0) {
            errorMessage.append("Số ghế phổ thông không được nhỏ hơn 1\n");
        }

    }

    public void validateNameExists(StringBuilder errorMessage, MayBay_Update mayBay_update) {
        String nameStr = mayBay_update.getName().trim();
        if (mayBayDAO.findByName(nameStr) != null) {
            errorMessage.append("Tên máy bay đã tồn tại trong hệ thống\n");
        }
    }
}
