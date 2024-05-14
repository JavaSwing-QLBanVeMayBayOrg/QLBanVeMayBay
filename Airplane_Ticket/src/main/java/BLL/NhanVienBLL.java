/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.lang.String;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
                return nhanvien;
            }
        }
        return null;
    }

    public static NhanVienDTO findByUser(String user) throws SQLException {
        NhanVienDTO nvBLL = new NhanVienDTO();
        NhanVienDAO nhanvienDAO = new NhanVienDAO();
        nvBLL = nhanvienDAO.getCMND(user);
        return nvBLL;
    }

    public static void updateTT(String cmnd, String tt) throws SQLException {
        NhanVienDAO nhanvienDAO = new NhanVienDAO();
        nhanvienDAO.updateTT(cmnd, tt);
    }

    public static void update(NhanVienDTO nhanvien, String cmnd) throws SQLException {
        NhanVienDAO nhanvienDAO = new NhanVienDAO();
        nhanvienDAO.update(nhanvien, cmnd);
    }

    public static List<NhanVienDTO> SearchBLL(String keyword, String searchType) {
        NhanVienDAO nhanvienDAO = new NhanVienDAO();
        return nhanvienDAO.Search(keyword, searchType);
    }

    public static void addFile(String filePath) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            List<NhanVienDTO> nv = new ArrayList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    continue;
                }
                NhanVienDTO nhanvien = new NhanVienDTO();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            System.out.println(columnIndex);
                            nhanvien.setCmnd(cell.getStringCellValue());
                            break;
                        case 1:
                            System.out.println(columnIndex);
                            nhanvien.setSoDienThoai(cell.getStringCellValue());
                            break;
                        case 2:
                            System.out.println(columnIndex);
                            nhanvien.setHo(cell.getStringCellValue());
                            break;
                        case 3:
                            System.out.println(columnIndex);
                            nhanvien.setTen(cell.getStringCellValue());
                            break;
                        case 4:
                            System.out.println(columnIndex);
                            nhanvien.setNgaySinh(new Date(cell.getDateCellValue().getTime()));
                            break;
                        case 5:
                            System.out.println(columnIndex);
                            if (cell.getNumericCellValue() == 1) {
                                nhanvien.setGioiTinh(true);
                            } else {
                                nhanvien.setGioiTinh(false);
                            }
                            break;
                        case 6:
                            System.out.println(columnIndex);
                            if (cell.getNumericCellValue() == 1) {
                                nhanvien.setTinhTrang(true);
                            } else {
                                nhanvien.setTinhTrang(false);
                            }
                            break;
                        default:
                            break;
                    }
                }
                if (NhanVienBLL.findByCMND(nhanvien.getCmnd()) == null) {
                    nv.add(nhanvien);
                } else {
                    System.out.println("CMND " + nhanvien.getCmnd() + " đã tồn tại trong cơ sở dữ liệu. Bỏ qua dòng này.");
                }
            }
            NhanVienDAO nvDAO = new NhanVienDAO();
            nvDAO.insertmany(nv);
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void exportfile(String path){
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.exportfile(path);
    }
}
