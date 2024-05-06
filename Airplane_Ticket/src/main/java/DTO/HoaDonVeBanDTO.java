package DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoaDonVeBanDTO {
    private int id;
    private NhanVienDTO idNhanVien;
    private KhachHangDTO idKhachHangLapHoaDon;
    private LocalDateTime ngayLapHoaDon;
    private BigDecimal tongTien;
    private boolean tinhTrang;

    public HoaDonVeBanDTO() {
    }

    public HoaDonVeBanDTO(int id, NhanVienDTO idNhanVien, KhachHangDTO idKhachHangLapHoaDon, LocalDateTime ngayLapHoaDon, BigDecimal tongTien, boolean tinhTrang) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idKhachHangLapHoaDon = idKhachHangLapHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NhanVienDTO getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(NhanVienDTO idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public KhachHangDTO getIdKhachHangLapHoaDon() {
        return idKhachHangLapHoaDon;
    }

    public void setIdKhachHangLapHoaDon(KhachHangDTO idKhachHangLapHoaDon) {
        this.idKhachHangLapHoaDon = idKhachHangLapHoaDon;
    }

    public LocalDateTime getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(LocalDateTime ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
