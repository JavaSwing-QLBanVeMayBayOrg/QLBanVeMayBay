package DTO;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ChuyenBayDTO {
    private int id;
    private MayBayDTO idMayBay;
    private SanBayDTO maSanBayDi;
    private SanBayDTO maSanBayDen;
    private LocalDateTime ngayDi;
    private LocalDateTime ngayDen;
    private LocalTime thoiGianBay;
    private String ghiChu;
    private boolean tinhTrang;

    public ChuyenBayDTO() {
    }

    public ChuyenBayDTO(int id, MayBayDTO idMayBay, SanBayDTO maSanBayDi, SanBayDTO maSanBayDen, LocalDateTime ngayDi, LocalDateTime ngayDen, LocalTime thoiGianBay, String ghiChu, boolean tinhTrang) {
        this.id = id;
        this.idMayBay = idMayBay;
        this.maSanBayDi = maSanBayDi;
        this.maSanBayDen = maSanBayDen;
        this.ngayDi = ngayDi;
        this.ngayDen = ngayDen;
        this.thoiGianBay = thoiGianBay;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MayBayDTO getIdMayBay() {
        return idMayBay;
    }

    public void setIdMayBay(MayBayDTO idMayBay) {
        this.idMayBay = idMayBay;
    }

    public SanBayDTO getMaSanBayDi() {
        return maSanBayDi;
    }

    public void setMaSanBayDi(SanBayDTO maSanBayDi) {
        this.maSanBayDi = maSanBayDi;
    }

    public SanBayDTO getMaSanBayDen() {
        return maSanBayDen;
    }

    public void setMaSanBayDen(SanBayDTO maSanBayDen) {
        this.maSanBayDen = maSanBayDen;
    }

    public LocalDateTime getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(LocalDateTime ngayDi) {
        this.ngayDi = ngayDi;
    }

    public LocalDateTime getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(LocalDateTime ngayDen) {
        this.ngayDen = ngayDen;
    }

    public LocalTime getThoiGianBay() {
        return thoiGianBay;
    }

    public void setThoiGianBay(LocalTime thoiGianBay) {
        this.thoiGianBay = thoiGianBay;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
