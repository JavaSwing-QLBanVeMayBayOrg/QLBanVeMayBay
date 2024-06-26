/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.HoaDonDAO;
import DTO.HoaDonVeBanDTO;
import DTO.TongHopChuyenBayDTO;
import java.util.List;

/**
 *
 * @author HP
 */
public class HoaDonBLL {
    
    private HoaDonVeBanDTO DAO = new HoaDonVeBanDTO();

    public List<TongHopChuyenBayDTO> findAll(String year, String month) {
        return HoaDonDAO.getAll(year,month);
    }
    
    public String getSoluongve(String year, String month){
        return String.valueOf(HoaDonDAO.getSoluongve(year,month)) ;
    }
    public String getDoanhthu(String year, String month){
        return  String.valueOf(HoaDonDAO.getDoanhthu(year,month)) ;
    }
    
}
