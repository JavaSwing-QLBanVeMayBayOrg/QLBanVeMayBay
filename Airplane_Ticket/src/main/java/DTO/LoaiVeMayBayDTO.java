package DTO;

import java.math.BigDecimal;

public class LoaiVeMayBayDTO {
    private int id;
    private ChuyenBayDTO idChuyenBay;
    private String hangVe;
    private BigDecimal giaVe;
    private int soLuongVeTong;
    private int soLuongVeCon;
    private boolean tinhTrang;

    public LoaiVeMayBayDTO() {
    }

    public LoaiVeMayBayDTO(int id, ChuyenBayDTO idChuyenBay, String hangVe, BigDecimal giaVe, int soLuongVeTong, int soLuongVeCon, boolean tinhTrang) {
        this.id = id;
        this.idChuyenBay = idChuyenBay;
        this.hangVe = hangVe;
        this.giaVe = giaVe;
        this.soLuongVeTong = soLuongVeTong;
        this.soLuongVeCon = soLuongVeCon;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChuyenBayDTO getIdChuyenBay() {
        return idChuyenBay;
    }

    public void setIdChuyenBay(ChuyenBayDTO idChuyenBay) {
        this.idChuyenBay = idChuyenBay;
    }

    public String getHangVe() {
        return hangVe;
    }

    public void setHangVe(String hangVe) {
        this.hangVe = hangVe;
    }

    public BigDecimal getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }

    public int getSoLuongVeTong() {
        return soLuongVeTong;
    }

    public void setSoLuongVeTong(int soLuongVeTong) {
        this.soLuongVeTong = soLuongVeTong;
    }

    public int getSoLuongVeCon() {
        return soLuongVeCon;
    }

    public void setSoLuongVeCon(int soLuongVeCon) {
        this.soLuongVeCon = soLuongVeCon;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
