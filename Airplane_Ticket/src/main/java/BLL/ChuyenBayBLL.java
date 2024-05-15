package BLL;

import DAO.ChuyenBayDAO;
import DTO.ChuyenBayDTO;
import GUI.ChuyenBay_Add_Dialog;
import GUI.Customer_Add_Dialog;
import Util.DateJcalendarUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public void validate(StringBuilder errorMessage, ChuyenBay_Add_Dialog chuyenBay_add_dialog) {
        String mayBayStr = chuyenBay_add_dialog.getCbxMaMayBay().getSelectedItem().toString();
        String sanBayDiStr= chuyenBay_add_dialog.getCbxMaSanBayDi().getSelectedItem().toString();
        String sanBayDenStr = chuyenBay_add_dialog.getCbxMaSanBayDen().getSelectedItem().toString();
        String ngayDiStr = DateJcalendarUtil.formatDate(chuyenBay_add_dialog.getNgayDi().getDate());
        String ngayDenStr = DateJcalendarUtil.formatDate(chuyenBay_add_dialog.getNgayDen().getDate());
        String thoiGianDiStr = chuyenBay_add_dialog.getThoiGianDi().getText().trim();
        String thoiGianDenStr = chuyenBay_add_dialog.getThoiGianDen().getText().trim();
        String thoiGianBayStr = chuyenBay_add_dialog.getThoiGianBay().getText().trim();
        String tinhTrangStr = chuyenBay_add_dialog.getTinhTrang().getSelectedItem().toString();
        boolean isNull = false;

        if (mayBayStr.equalsIgnoreCase("Tất cả")) {
            errorMessage.append("Bắt buộc phải chọn máy bay\n");
        }

        if (sanBayDiStr.equalsIgnoreCase("Tất cả")) {
            errorMessage.append("Bắt buộc phải chọn sân bay đi\n");
        }

        if (sanBayDenStr.equalsIgnoreCase("Tất cả")) {
            errorMessage.append("Bắt buộc phải chọn sân bay đến\n");
        }

        if (ngayDiStr == null) {
            errorMessage.append("Bắt buộc phải chọn ngày đi\n");
            isNull = true;
        }

        if (ngayDenStr == null) {
            errorMessage.append("Bắt buộc phải chọn ngày đến\n");
            isNull = true;
        }

        if (!isNull) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ngayDi = LocalDate.parse(ngayDiStr, formatter);
            LocalDate ngayDen = LocalDate.parse(ngayDenStr, formatter);

            if (ngayDen.isBefore(ngayDi)) {
                errorMessage.append("Ngày đến không được nhỏ hơn ngày đi\n");
            }

            if (ngayDiStr.equalsIgnoreCase(ngayDenStr)) {
                if (!thoiGianDiStr.isEmpty() && !thoiGianDenStr.isEmpty()) {
                    int getHoursThoiGianDi = Integer.parseInt(thoiGianDiStr.substring(0, 2));
                    int getHoursThoiGianDen = Integer.parseInt(thoiGianDenStr.substring(0, 2));
                    if (getHoursThoiGianDen - getHoursThoiGianDi < 2) {
                        errorMessage.append("Thời gian đến phải lớn hoặc bằng 2 tiếng\n");
                    }
                }
            }
        }

        if (thoiGianDiStr.isEmpty()) {
            errorMessage.append("Bắt buộc phải chọn thời gian đi\n");
        }

        if (thoiGianDenStr.isEmpty()) {
            errorMessage.append("Bắt buộc phải chọn thời gian đến\n");
        }

        if (thoiGianBayStr.isEmpty()) {
            errorMessage.append("Thời gian bay chưa xác định được\n");
        }

        if (tinhTrangStr.equalsIgnoreCase("Tất cả")) {
            errorMessage.append("Bắt buộc phải tình trạng\n");
        }
    }
}
