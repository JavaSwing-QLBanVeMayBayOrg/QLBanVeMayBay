/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author HP
 */
public class TongHopChuyenBayDTO {
    private String ID;
    private String NoiDi;
    private String NoiDen;
    private int Soluongve;
    private double doanhThu;

    public TongHopChuyenBayDTO(String ID, String NoiDi, String NoiDen, int Soluongve,double doanhThu) {
        this.ID = ID;
        this.NoiDi = NoiDi;
        this.NoiDen = NoiDen;
        this.Soluongve = Soluongve;
        this.doanhThu = doanhThu;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNoiDi() {
        return NoiDi;
    }

    public void setNoiDi(String NoiDi) {
        this.NoiDi = NoiDi;
    }

    public String getNoiDen() {
        return NoiDen;
    }

    public void setNoiDen(String NoiDen) {
        this.NoiDen = NoiDen;
    }

    public int getSoluongve() {
        return Soluongve;
    }

    public void setSoluongve(int Soluongve) {
        this.Soluongve = Soluongve;
    }
    
}
