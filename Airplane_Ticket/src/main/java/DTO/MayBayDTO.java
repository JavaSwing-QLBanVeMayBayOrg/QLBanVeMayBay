package DTO;

public class MayBayDTO {
    private int id;
    private String ten;
    private int soGheH1;
    private int soGheH2;
    private boolean status;

    public MayBayDTO() {
    }

    public MayBayDTO(int id, String ten, int soGheH1, int soGheH2, boolean status) {
        this.id = id;
        this.ten = ten;
        this.soGheH1 = soGheH1;
        this.soGheH2 = soGheH2;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoGheH1() {
        return soGheH1;
    }

    public void setSoGheH1(int soGheH1) {
        this.soGheH1 = soGheH1;
    }

    public int getSoGheH2() {
        return soGheH2;
    }

    public void setSoGheH2(int soGheH2) {
        this.soGheH2 = soGheH2;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
