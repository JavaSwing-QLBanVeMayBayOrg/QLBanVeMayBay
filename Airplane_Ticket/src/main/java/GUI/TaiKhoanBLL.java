/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.List;

/**
 *
 * @author HP
 */
class TaiKhoanBLL {
    public static TaiKhoanDTO findByCMND(String cmnd) {
        TaiKhoanBLL nvBLL = new TaiKhoanBLL();
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        return tkDAO.getbyID(cmnd);
    }
}
