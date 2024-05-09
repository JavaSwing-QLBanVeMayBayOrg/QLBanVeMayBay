package DTO;

import java.sql.Date;
import java.time.LocalDateTime;

public class TaiKhoanDTO {
    private String username;
    private String password;
    private Date ngayCap;
    private boolean tinhTrang;
    private NhanVienDTO cmndNhanVien;

    public TaiKhoanDTO() {
    }


    public TaiKhoanDTO(String userName, String passWord, Date ngayCap, boolean tinhTrang) {
        this.username = userName;
        this.password = passWord;
        this.ngayCap = ngayCap;
        this.tinhTrang = tinhTrang;
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

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
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
