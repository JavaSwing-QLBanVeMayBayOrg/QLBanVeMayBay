/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HP
 */
public class NhanVienDAO {

    List<NhanVienDTO> nhanvienList = new ArrayList<>();

    public List<NhanVienDTO> getAll() {
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT cmnd, ho, ten, soDienThoai FROM nhanvien");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVienDTO nhanvien = new NhanVienDTO();
                nhanvien.setCmnd(resultSet.getString("cmnd"));
                nhanvien.setHo(resultSet.getString("ho"));
                nhanvien.setTen(resultSet.getString("ten"));
                nhanvien.setSoDienThoai(resultSet.getString("soDienThoai"));
                nhanvienList.add(nhanvien);
            }
            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanvienList;
    }

    public void insertone(NhanVienDTO nhanvien) {
        try {
            String sql = "INSERT INTO nhanvien (cmnd, soDienThoai, ho, ten, ngaySinh, gioiTinh, tinhTrang) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Connection connection = BaseDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhanvien.getCmnd());
            preparedStatement.setString(2, nhanvien.getSoDienThoai());
            preparedStatement.setString(3, nhanvien.getHo());
            preparedStatement.setString(4, nhanvien.getTen());
            preparedStatement.setDate(5, nhanvien.getNgaySinh());
            preparedStatement.setByte(6, nhanvien.isGioiTinh() ? (byte) 1 : (byte) 0);
            preparedStatement.setBoolean(7, true);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Dữ liệu đã được chèn thành công vào bảng nhanvien!");
                AddTK(nhanvien.getCmnd());

            }
            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertmany(List<NhanVienDTO> Nhanvien) {
        try {
            String sql = "INSERT INTO nhanvien (cmnd, soDienThoai, ho, ten, ngaySinh, gioiTinh, tinhTrang) VALUES ";
            String sql2 = "";
            Connection connection = BaseDAO.getConnection();
            for (int i = 0; i < Nhanvien.size(); i++) {
                NhanVienDTO nv = Nhanvien.get(i);
                sql += "('" + nv.getCmnd() + "', ";
                sql += "'" + nv.getSoDienThoai() + "', ";
                sql += "'" + nv.getHo() + "', ";
                sql += "'" + nv.getTen() + "', ";
                sql += "'" + nv.getNgaySinh() + "', ";
                sql += (nv.isGioiTinh() ? 1 : 0) + ", ";
                sql += (nv.isTinhTrang() ? 1 : 0) + ")";
                if (i < Nhanvien.size() - 1) {
                    sql += ",\n";
                } else {
                    sql += "; ";
                }
            }
            System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Dữ liệu đã được chèn thành công vào bảng nhanvien!");
                BaseDAO.closeConnection();
                for (NhanVienDTO nv : Nhanvien) {
                    AddTK(nv.getCmnd());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddTK(String cmnd) {
        try {
            String sql = "INSERT INTO taikhoan (userName, passWord, ngayCap, tinhTrang, cmndNhanVien) VALUES (?, ?, ?, ?, ?)";
            Connection connection = BaseDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            java.util.Date currentDate = new java.util.Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(currentDate);
            preparedStatement.setString(1, cmnd);
            preparedStatement.setString(2, "1234");
            java.util.Date utilDate = dateFormat.parse(formattedDate);
            preparedStatement.setDate(3, new java.sql.Date(utilDate.getTime()));
            preparedStatement.setByte(4, (byte) 1);
            preparedStatement.setString(5, cmnd);
            int rowsInserted = preparedStatement.executeUpdate();
            BaseDAO.closeConnection();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    public List<NhanVienDTO> getAllDB() {
        try {
            Connection connection = BaseDAO.getConnection();
            PreparedStatement preparedStatement = BaseDAO.getConnection()
                    .prepareStatement("SELECT * FROM nhanvien");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVienDTO nhanvien = new NhanVienDTO();
                nhanvien.setCmnd(resultSet.getString("cmnd"));
                nhanvien.setHo(resultSet.getString("ho"));
                nhanvien.setTen(resultSet.getString("ten"));
                nhanvien.setSoDienThoai(resultSet.getString("soDienThoai"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date sqlDate = resultSet.getDate("ngaySinh");
                java.util.Date parsedDate = new java.util.Date(sqlDate.getTime());
                nhanvien.setNgaySinh(new Date(parsedDate.getTime()));
                nhanvien.setGioiTinh(resultSet.getByte("gioiTinh") != 0);
                nhanvien.setTinhTrang(resultSet.getByte("tinhTrang") != 0);
                nhanvienList.add(nhanvien);
            }
            BaseDAO.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanvienList;
    }

    public void updateTT(String cmnd, String tt) throws SQLException {
        Connection connection = BaseDAO.getConnection();
        String sql = "UPDATE taikhoan SET tinhTrang = ? WHERE cmndNhanVien = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        switch (tt) {
            case "del":
                preparedStatement.setByte(1, (byte) 0);
                System.out.println("0");
                break;
            case "add":
                preparedStatement.setByte(1, (byte) 1);
                System.out.println("1");
                break;
        }
        preparedStatement.setString(2, cmnd);
        System.out.println(sql);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.print("da cap nhat");
        }
        BaseDAO.closeConnection();
    }

    public void update(NhanVienDTO nhanvien, String manv) throws SQLException {
        String sql = "UPDATE nhanvien SET cmnd= ?,soDienThoai=?,ho=?,ten=?,ngaySinh=?,gioiTinh=? WHERE cmnd = ?";
        Connection connection = BaseDAO.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, nhanvien.getCmnd());
        preparedStatement.setString(2, nhanvien.getSoDienThoai());
        preparedStatement.setString(3, nhanvien.getHo());
        preparedStatement.setString(4, nhanvien.getTen());
        preparedStatement.setDate(5, nhanvien.getNgaySinh());
        preparedStatement.setByte(6, nhanvien.isGioiTinh() ? (byte) 1 : (byte) 0);
        preparedStatement.setString(7, manv);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.print("da cap nhat");
        }

        BaseDAO.closeConnection();

    }

    public List<NhanVienDTO> Search(String keyword, String searchType) {
        List<NhanVienDTO> nhanVienList = new ArrayList<>();
        try {
            Connection connection = BaseDAO.getConnection();
            PreparedStatement preparedStatement = null;

            String sql = "SELECT cmnd, ho, ten, soDienThoai FROM nhanvien WHERE ";

            if (searchType.equals("name")) {
                sql += "CONCAT(ho, ' ', ten) LIKE ?";
            } else if (searchType.equals("phone")) {
                sql += "soDienThoai = ?";
            } else if (searchType.equals("id")) {
                sql += "cmnd = ?";
            } else if (searchType.equals("all")) {
                sql += "CONCAT(ho, ' ', ten) LIKE ? OR soDienThoai = ? OR cmnd = ?";
            }

            preparedStatement = connection.prepareStatement(sql);

            if (searchType.equals("all")) {
                preparedStatement.setString(1, "%" + keyword + "%");
                preparedStatement.setString(2, keyword);
                preparedStatement.setString(3, keyword);
            } else {
                preparedStatement.setString(1, "%" + keyword + "%");
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                NhanVienDTO nhanvien = new NhanVienDTO();
                nhanvien.setCmnd(resultSet.getString("cmnd"));
                nhanvien.setHo(resultSet.getString("ho"));
                nhanvien.setTen(resultSet.getString("ten"));
                nhanvien.setSoDienThoai(resultSet.getString("soDienThoai"));
                nhanVienList.add(nhanvien);
            }
            BaseDAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVienList;
    }

    public NhanVienDTO getCMND(String user) throws SQLException {
        Connection connection = BaseDAO.getConnection();

        String sql = "SELECT * FROM taikhoan INNER JOIN nhanvien ON taikhoan.cmndNhanVien = nhanvien.cmnd WHERE taikhoan.userName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user);
        ResultSet resultSet = preparedStatement.executeQuery();
        NhanVienDTO nhanVien = new NhanVienDTO();
        while (resultSet.next()) {

            NhanVienDTO nhanvien = new NhanVienDTO();
            nhanvien.setCmnd(resultSet.getString("cmnd"));
            nhanvien.setHo(resultSet.getString("ho"));
            nhanvien.setTen(resultSet.getString("ten"));
            nhanvien.setSoDienThoai(resultSet.getString("soDienThoai"));
            nhanVien = nhanvien;
        }
        BaseDAO.closeConnection();
        return nhanVien;
    }

    public void exportfile(String path) {
        List<NhanVienDTO> nv = this.getAllDB();
        String filePath = "C:\\Users\\HP\\Desktop\\testexportNV.xlsx";
        if (path.equals("")) {
            filePath = path;
        }

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("NhanVien");

            // Tạo header cho bảng
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("CMND");
            headerRow.createCell(1).setCellValue("Số Điện Thoại");
            headerRow.createCell(2).setCellValue("Họ");
            headerRow.createCell(3).setCellValue("Tên");
            headerRow.createCell(4).setCellValue("Ngày Sinh");
            headerRow.createCell(5).setCellValue("Giới Tính");
            headerRow.createCell(6).setCellValue("Tình Trạng");

            // Đổ dữ liệu từ danh sách vào bảng
            int rowNum = 1;
            for (NhanVienDTO nhanVien : nv) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(nhanVien.getCmnd());
                row.createCell(1).setCellValue(nhanVien.getSoDienThoai());
                row.createCell(2).setCellValue(nhanVien.getHo());
                row.createCell(3).setCellValue(nhanVien.getTen());
                row.createCell(4).setCellValue(nhanVien.getNgaySinh().toString());
                row.createCell(5).setCellValue(nhanVien.isGioiTinh() ? "Nam" : "Nữ");
                row.createCell(6).setCellValue(nhanVien.isTinhTrang() ? "Hoạt động" : "Không hoạt động");
            }

            // Tạo và ghi ra file Excel
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Xuất dữ liệu thành công ra file Excel!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
