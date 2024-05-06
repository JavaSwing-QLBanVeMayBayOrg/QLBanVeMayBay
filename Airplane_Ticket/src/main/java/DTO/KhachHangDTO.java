package DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class KhachHangDTO {
    private String cmnd;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private LocalDate ngaySinh;
    private int diemTichLuy;
    private HangThanThietDTO idHangThanThiet;
    private boolean tinhTrang;
    private boolean gioiTinh;

    public KhachHangDTO() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public HangThanThietDTO getIdHangThanThiet() {
        return idHangThanThiet;
    }

    public void setIdHangThanThiet(HangThanThietDTO idHangThanThiet) {
        this.idHangThanThiet = idHangThanThiet;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
