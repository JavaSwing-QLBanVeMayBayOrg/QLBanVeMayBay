/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.VeMayBayDAO;
import DTO.VeMayBayDTO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class VeMayBayBLL {
    VeMayBayDAO vemaybayDAO = new VeMayBayDAO();
     public boolean create(VeMayBayDTO vemaybay) {
         return vemaybayDAO.create(vemaybay);
     }
     public static List<VeMayBayDTO> getListVeByHoaDonId(int maHoaDon) {
    // Gọi phương thức từ DAO để lấy danh sách vé dựa trên mã hóa đơn
    return VeMayBayDAO.getListVeByHoaDonId(maHoaDon);
}
}
