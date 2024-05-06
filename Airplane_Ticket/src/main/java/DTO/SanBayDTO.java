package DTO;

public class SanBayDTO {
    private String maSanBay;
    private String ten;
    private boolean status;

    public SanBayDTO() {
    }

    public SanBayDTO(String maSanBay, String ten, boolean status) {
        this.maSanBay = maSanBay;
        this.ten = ten;
        this.status = status;
    }

    public String getMaSanBay() {
        return maSanBay;
    }

    public void setMaSanBay(String maSanBay) {
        this.maSanBay = maSanBay;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SanBayDTO{" +
                "maSanBay='" + maSanBay + '\'' +
                ", ten='" + ten + '\'' +
                ", status=" + status +
                '}';
    }
}
