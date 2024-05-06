package DTO;

public class VeMayBayDTO {
    private int id;
    private HoaDonVeBanDTO idHoaDonVeBan;
    private KhachHangDTO idKhachHang;
    private LoaiVeMayBayDTO idLoaiVeMayBay;
    private LoaiVeMayBayDTO idLoaiVeMayVe;
    private boolean tinhTrang;

    public VeMayBayDTO() {
    }

    public VeMayBayDTO(int id, HoaDonVeBanDTO idHoaDonVeBan, KhachHangDTO idKhachHang, LoaiVeMayBayDTO idLoaiVeMayBay, LoaiVeMayBayDTO idLoaiVeMayVe, boolean tinhTrang) {
        this.id = id;
        this.idHoaDonVeBan = idHoaDonVeBan;
        this.idKhachHang = idKhachHang;
        this.idLoaiVeMayBay = idLoaiVeMayBay;
        this.idLoaiVeMayVe = idLoaiVeMayVe;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HoaDonVeBanDTO getIdHoaDonVeBan() {
        return idHoaDonVeBan;
    }

    public void setIdHoaDonVeBan(HoaDonVeBanDTO idHoaDonVeBan) {
        this.idHoaDonVeBan = idHoaDonVeBan;
    }

    public KhachHangDTO getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(KhachHangDTO idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public LoaiVeMayBayDTO getIdLoaiVeMayBay() {
        return idLoaiVeMayBay;
    }

    public void setIdLoaiVeMayBay(LoaiVeMayBayDTO idLoaiVeMayBay) {
        this.idLoaiVeMayBay = idLoaiVeMayBay;
    }

    public LoaiVeMayBayDTO getIdLoaiVeMayVe() {
        return idLoaiVeMayVe;
    }

    public void setIdLoaiVeMayVe(LoaiVeMayBayDTO idLoaiVeMayVe) {
        this.idLoaiVeMayVe = idLoaiVeMayVe;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
