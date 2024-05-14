package BLL;

import DAO.LoaiVeMayBayDAO;
import DTO.LoaiVeMayBayDTO;
import DTO.LoaiVeMayBaySearchDTO;
import GUI.Customer_Add_Dialog;
import GUI.Ticket_Type_Add_Dialog;
import Util.DateJcalendarUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class LoaiVeMayBayBLL {
    LoaiVeMayBayDAO loaiVeMayBayDAO = new LoaiVeMayBayDAO();

    public List<LoaiVeMayBayDTO> search(LoaiVeMayBaySearchDTO loaiVeMayBaySearchDTO) {
        if (loaiVeMayBaySearchDTO.getHangVe() == null) {
            loaiVeMayBaySearchDTO.setHangVe("");
        }

        if (loaiVeMayBaySearchDTO.getGiaVe() == null) {
            loaiVeMayBaySearchDTO.setGiaVe("");
        }

        if (loaiVeMayBaySearchDTO.getTinhTrang() == null) {
            loaiVeMayBaySearchDTO.setTinhTrang("");
        }

        return loaiVeMayBayDAO.search(loaiVeMayBaySearchDTO);
    }
    public LoaiVeMayBayDTO findById(int id) {
        return loaiVeMayBayDAO.findById(id);
    }

    public boolean create(LoaiVeMayBayDTO loaiVeMayBayDTO, int idChuyenBay) {
        return loaiVeMayBayDAO.create(loaiVeMayBayDTO, idChuyenBay);
    }

    public boolean delete(LoaiVeMayBayDTO loaiVeMayBayDTO) {
        return loaiVeMayBayDAO.delete(loaiVeMayBayDTO);
    }

    public void validate(StringBuilder errorMessage, Ticket_Type_Add_Dialog ticket_type_add_dialog) {
        String hangVeStr = ticket_type_add_dialog.getCbxHangVe().getSelectedItem().toString();
        String tinhTrangStr = ticket_type_add_dialog.getTinhTrang().getSelectedItem().toString();
        String giaVeStr = ticket_type_add_dialog.getGiaVe().getText().trim();

        if (hangVeStr.equalsIgnoreCase("Tất cả")) {
            errorMessage.append("Bắt buộc phải chọn hạng vé\n");
        }

        if (tinhTrangStr.equalsIgnoreCase("Tất cả")) {
            errorMessage.append("Bắt buộc phải chọn tình trạng\n");
        }

        if (giaVeStr.isEmpty()) {
            errorMessage.append("Giá vé không được để trống\n");
        } else if (!giaVeStr.matches("^[0-9]+$")) {
            errorMessage.append("Giá vé không hợp lệ\n");
        } else if (giaVeStr.length() > 20) {
            errorMessage.append("Giá vé đã quá giới hạn cho phép\n");
        } else {
            int giaVe = Integer.parseInt(giaVeStr);
            if (hangVeStr.equalsIgnoreCase("Thương gia")) {
                if (giaVe < 2000000) {
                    errorMessage.append("Giá vé Thương Gia phải từ 2 triệu chở lên\n");
                }
            } else if (hangVeStr.equalsIgnoreCase("Phổ thông")) {
                if (giaVe < 800000 || giaVe >= 2000000) {
                    errorMessage.append("Giá vé Phổ Thông phải từ 800k đến dưới 2 triệu\n");
                }
            }
        }
    }
}
