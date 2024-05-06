/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.HoaDonVeBanDAO;
import DTO.HoaDonVeBanDTO;

/**
 *
 * @author ADMIN
 */
public class HoaDonVeBanBLL {
    HoaDonVeBanDAO hoadonvebanDAO=new HoaDonVeBanDAO();
     public boolean create(HoaDonVeBanDTO hoadon) {
         return hoadonvebanDAO.create(hoadon);
     }
      public int find() {
          return hoadonvebanDAO.find();
      }
}
