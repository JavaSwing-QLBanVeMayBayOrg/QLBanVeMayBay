/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.LoaiVeDAO;
import DTO.ChuyenBayDTO;
import DTO.LoaiVeMayBayDTO;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class LoaiVeBLL {
    LoaiVeDAO loaiveDAO = new LoaiVeDAO();
    public Vector<LoaiVeMayBayDTO> DanhSachVeChieuDi(ChuyenBayDTO chuyenbaydi,int soLuong) throws SQLException
    {
        return loaiveDAO.DanhSachVeChieuDi(chuyenbaydi,soLuong);
    }
    public Vector<LoaiVeMayBayDTO> DanhSachVeChieuVe(ChuyenBayDTO chuyenbayve,int soLuong) throws SQLException
    {
        return loaiveDAO.DanhSachVeChieuVe(chuyenbayve,soLuong);
    }
     public void UpdateSoLuongVe(LoaiVeMayBayDTO loaive,int soLuongCon) throws SQLException
     {
         loaiveDAO.UpdateSoLuongVe(loaive, soLuongCon);
     }
}
