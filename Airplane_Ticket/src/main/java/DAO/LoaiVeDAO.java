/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChuyenBayDTO;
import DTO.LoaiVeMayBayDTO;
import DTO.SanBayDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class LoaiVeDAO {
     public Vector<LoaiVeMayBayDTO> DanhSachVeChieuDi(ChuyenBayDTO chuyenbaydi) throws SQLException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ngaydi= chuyenbaydi.getNgayDi().format(formatter);
        String ngayve= (chuyenbaydi.getNgayDi().plus(1,ChronoUnit.DAYS)).format(formatter);
        System.out.println(ngayve);
        Vector<LoaiVeMayBayDTO> arr = new Vector<LoaiVeMayBayDTO>();
        Connection con=BaseDAO.getConnection();
        if (con!=null) {
        try {

        String sql = "SELECT * FROM loaivemaybay,chuyenbay where chuyenbay.id = loaivemaybay.idChuyenBay and chuyenbay.maSanBayDi='"+ chuyenbaydi.getMaSanBayDi().getMaSanBay()+"' and chuyenbay.maSanBayDen='"+chuyenbaydi.getMaSanBayDen().getMaSanBay()+"' and chuyenbay.ngayDi BETWEEN '"+ngaydi+"' AND '"+ngayve+"' and loaivemaybay.tinhTrang = 1";
        System.out.println(sql);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
        {
        ChuyenBayDTO chuyenbay= new ChuyenBayDTO();
        LoaiVeMayBayDTO loaive = new LoaiVeMayBayDTO();
        SanBayDTO sanbaydi=new SanBayDTO();
        SanBayDTO sanbayve=new SanBayDTO();
        loaive.setId(rs.getInt(1));
        loaive.setHangVe(rs.getString("hangVe"));
        loaive.setGiaVe(rs.getBigDecimal("giaVe"));
        loaive.setSoLuongVeCon(rs.getInt("soLuongVeCon"));
        loaive.setSoLuongVeTong(rs.getInt("soLuongVeTong"));
        sanbaydi.setMaSanBay(rs.getString("maSanBayDi"));
        sanbayve.setMaSanBay(rs.getString("maSanBayDen"));
        chuyenbay.setId(rs.getInt("idChuyenBay"));
        chuyenbay.setMaSanBayDi(sanbaydi);
        chuyenbay.setMaSanBayDen(sanbayve);
        chuyenbay.setNgayDi(rs.getTimestamp("ngayDi").toLocalDateTime());
        chuyenbay.setNgayDen(rs.getTimestamp("ngayDen").toLocalDateTime());
        chuyenbay.setThoiGianBay(rs.getTime("thoiGianBay").toLocalTime());
        chuyenbay.setGhiChu(rs.getString("ghiChu"));
        loaive.setIdChuyenBay(chuyenbay);
        arr.add(loaive);
        }
        } catch (SQLException ex) {
        System.out.println(ex);
        } finally {
        BaseDAO.closeConnection();
        } }
        return arr;
        }
     public Vector<LoaiVeMayBayDTO> DanhSachVeChieuVe(ChuyenBayDTO chuyenbayve) throws SQLException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ngaydi= chuyenbayve.getNgayDi().format(formatter);
        String ngayve= (chuyenbayve.getNgayDi().plus(15,ChronoUnit.DAYS)).format(formatter);
        System.out.println(ngayve);
        Vector<LoaiVeMayBayDTO> arr = new Vector<LoaiVeMayBayDTO>();
        Connection con=BaseDAO.getConnection();
        if (con!=null) {
        try {

        String sql = "SELECT * FROM loaivemaybay,chuyenbay where chuyenbay.id = loaivemaybay.idChuyenBay and chuyenbay.maSanBayDi='"+ chuyenbayve.getMaSanBayDi().getMaSanBay()+"' and chuyenbay.maSanBayDen='"+chuyenbayve.getMaSanBayDen().getMaSanBay()+"' and chuyenbay.ngayDi BETWEEN '"+ngaydi+"' AND '"+ngayve+"' and loaivemaybay.tinhTrang = 1";
        System.out.println(sql);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
        {
        ChuyenBayDTO chuyenbay= new ChuyenBayDTO();
        LoaiVeMayBayDTO loaive = new LoaiVeMayBayDTO();
        SanBayDTO sanbaydi=new SanBayDTO();
        SanBayDTO sanbayve=new SanBayDTO();
        loaive.setId(rs.getInt(1));
        loaive.setHangVe(rs.getString("hangVe"));
        loaive.setGiaVe(rs.getBigDecimal("giaVe"));
        loaive.setSoLuongVeCon(rs.getInt("soLuongVeCon"));
        loaive.setSoLuongVeTong(rs.getInt("soLuongVeTong"));
        sanbaydi.setMaSanBay(rs.getString("maSanBayDi"));
        sanbayve.setMaSanBay(rs.getString("maSanBayDen"));
        chuyenbay.setId(rs.getInt("idChuyenBay"));
        chuyenbay.setMaSanBayDi(sanbaydi);
        chuyenbay.setMaSanBayDen(sanbayve);
        chuyenbay.setNgayDi(rs.getTimestamp("ngayDi").toLocalDateTime());
        chuyenbay.setNgayDen(rs.getTimestamp("ngayDen").toLocalDateTime());
        chuyenbay.setThoiGianBay(rs.getTime("thoiGianBay").toLocalTime());
        chuyenbay.setGhiChu(rs.getString("ghiChu"));
        loaive.setIdChuyenBay(chuyenbay);
        arr.add(loaive);
        }
        } catch (SQLException ex) {
        System.out.println(ex);
        } finally {
        BaseDAO.closeConnection();
        } }
        return arr;
        }
}
