/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.HoaDonVeBanDAO;
import DTO.HoaDonVeBanDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class HoaDonVeBanBLL {
    HoaDonVeBanDAO hoadonvebanDAO=new HoaDonVeBanDAO();
    public HoaDonVeBanDTO getHoaDonById(int idHoaDon) {
    // Gọi đến DAO để lấy thông tin của hóa đơn dựa trên idHoaDon
    return hoadonvebanDAO.getHoaDonById(idHoaDon);
}

    public ArrayList<HoaDonVeBanDTO> getAllHoaDon() {
    return hoadonvebanDAO.getAllHoaDon();
}
     public boolean create(HoaDonVeBanDTO hoadon) {
         return hoadonvebanDAO.create(hoadon);
     }
      public int find() {
          return hoadonvebanDAO.find();
      }
}
