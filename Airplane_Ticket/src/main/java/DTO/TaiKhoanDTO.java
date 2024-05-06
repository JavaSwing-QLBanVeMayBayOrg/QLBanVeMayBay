package DTO;

import java.time.LocalDateTime;

public class TaiKhoanDTO {
    private String username;
    private String password;
    private LocalDateTime ngayCap;
    private boolean tinhTrang;
    private NhanVienDTO cmndNhanVien;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String username, String password, LocalDateTime ngayCap, boolean tinhTrang, NhanVienDTO cmndNhanVien) {
        this.username = username;
        this.password = password;
        this.ngayCap = ngayCap;
        this.tinhTrang = tinhTrang;
        this.cmndNhanVien = cmndNhanVien;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDateTime ngayCap) {
        this.ngayCap = ngayCap;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public NhanVienDTO getCmndNhanVien() {
        return cmndNhanVien;
    }

    public void setCmndNhanVien(NhanVienDTO cmndNhanVien) {
        this.cmndNhanVien = cmndNhanVien;
    }
}
