/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanBLL {
    private TaiKhoanDAO taikhoanDAO = new TaiKhoanDAO();
    
    public TaiKhoanDTO CheckTaiKhoan(String usr) throws SQLException
    {
        return taikhoanDAO.CheckTaiKhoan(usr);
       
    }
    
    public TaiKhoanDTO findByCMND(String cmnd) throws SQLException
    {
        return taikhoanDAO.getbyID(cmnd);
       
    }
}
