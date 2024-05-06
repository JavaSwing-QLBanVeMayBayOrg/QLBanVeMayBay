/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

/**
 *
 * @author HP
 */
public class NhanVienBLL {

    private NhanVienDAO NhanVienDAO = new NhanVienDAO();

    public List<NhanVienDTO> findAll() {
        return NhanVienDAO.getAll();
    }

    public void insertone(NhanVienDTO nhanvien) {
        NhanVienDAO.insertone(nhanvien);
    }

    public static NhanVienDTO findByCMND(String cmnd) {
        NhanVienBLL nvBLL = new NhanVienBLL();
        NhanVienDAO nhanvienDAO = new NhanVienDAO();
        List<NhanVienDTO> nhanvienlist = nhanvienDAO.getAllDB();
        for (NhanVienDTO nhanvien : nhanvienlist) {
            if (nhanvien.getCmnd().equals(cmnd)) {
                return nhanvien; // Trả về nhân viên đầu tiên có CMND trùng khớp
            }
        }
        // Nếu không tìm thấy nhân viên nào có CMND trùng khớp, trả về null
        return null;
    }
    
    public static void updateTT(String cmnd) throws SQLException{
        NhanVienDAO nhanvienDAO = new NhanVienDAO();
        nhanvienDAO.updateTT(cmnd);
    } 
    
    public static void update(NhanVienDTO nhanvien, String cmnd) throws SQLException{
        NhanVienDAO nhanvienDAO = new NhanVienDAO();
        nhanvienDAO.update(nhanvien, cmnd); 
    }
    
    public static List<NhanVienDTO> SearchBLL(String keyword, String searchType){
        NhanVienDAO nhanvienDAO = new NhanVienDAO();
        return nhanvienDAO.Search(keyword, searchType);
    }
}
