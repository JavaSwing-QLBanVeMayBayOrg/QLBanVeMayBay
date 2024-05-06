package DTO;

public class HangThanThietDTO {
    private int id;
    private String tenHang;
    private int diemTichLuy;
    private int khuyenMai;

    public HangThanThietDTO() {
    }

    public HangThanThietDTO(int id, String tenHang) {
        this.id = id;
        this.tenHang = tenHang;
    }

    public HangThanThietDTO(int id, String tenHang, int diemTichLuy, int khuyenMai) {
        this.id = id;
        this.tenHang = tenHang;
        this.diemTichLuy = diemTichLuy;
        this.khuyenMai = khuyenMai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public int getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(int khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
}
