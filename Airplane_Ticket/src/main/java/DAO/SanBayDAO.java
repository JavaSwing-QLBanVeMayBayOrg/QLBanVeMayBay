/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanBayDTO;
import DAO.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
/**
 *
 * @author ADMIN
 */
public class SanBayDAO {     
    public Vector<SanBayDTO> DanhSachSanBayKhaDung() throws SQLException
    {
   
        Vector<SanBayDTO> arr = new Vector<SanBayDTO>();
        Connection con=BaseDAO.getConnection();
        if (con!=null) {
        try {
        System.out.println("Kết nối thành công");
        String sql = "Select * from sanbay where status=1";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
        {
        SanBayDTO sanbay = new SanBayDTO();
        sanbay.setMaSanBay(rs.getString("maSanBay"));
        sanbay.setTen(rs.getString("ten"));
        sanbay.setStatus(rs.getBoolean("status"));
        arr.add(sanbay);
        }
        System.out.println(arr);
        } catch (SQLException ex) {
        System.out.println(ex);
        } finally {
        BaseDAO.closeConnection();
        } }
        return arr;
        }
    public Vector<SanBayDTO> DanhSachSanBay() throws SQLException{
        Vector<SanBayDTO> list = new Vector<SanBayDTO>();
        Connection con=BaseDAO.getConnection();
        if (con!=null) {
            try {
                System.out.println("Kết nối thành công");
                String sql = "Select * from sanbay";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SanBayDTO sanbay = new SanBayDTO();
                    sanbay.setMaSanBay(rs.getString("maSanBay"));
                    sanbay.setTen(rs.getString("ten"));
                    sanbay.setStatus(rs.getBoolean("status"));
//                    System.out.println("");
                    list.add(sanbay);
                }
//                System.out.println(arr);
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                BaseDAO.closeConnection();
            } 
        }
        return list;
    }
    public boolean addSanBay(SanBayDTO sb) throws SQLException{
        Boolean flag=false;
        Connection con = BaseDAO.getConnection();
        if(con!=null){
            try{
                String sql="Insert into sanbay(maSanBay, ten, status) values (?,?,?)";
                PreparedStatement ptmt=con.prepareStatement(sql);
                ptmt.setString(1, sb.getMaSanBay());
                ptmt.setString(2, sb.getTen());
                ptmt.setBoolean(3, sb.isStatus());
                if(ptmt.executeUpdate()>0){
                    flag=true;
                }
            }catch(SQLIntegrityConstraintViolationException ex){
                flag=false;
            }finally{
                BaseDAO.closeConnection();
            }
        }
        return flag;
    }
    public boolean updateSanBay(SanBayDTO sb) throws SQLException{
        Boolean flag=false;
        Connection con = BaseDAO.getConnection();
        if(con!=null){
            try{
                String sql="Update sanbay set ten=? where maSanBay=?";
                PreparedStatement ptmt=con.prepareStatement(sql);
                ptmt.setString(2, sb.getMaSanBay());
                ptmt.setString(1, sb.getTen());
                if(ptmt.executeUpdate()>0){
                    flag=true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                BaseDAO.closeConnection();
            }
        }
        return flag;
    }
    public boolean deleteSanBay(SanBayDTO sb) throws SQLException{
        Boolean flag=false;
        Connection con= BaseDAO.getConnection();
        if(con!=null){
            try{
                String sql="Update sanbay set status=? where maSanBay=?";
                PreparedStatement ptmt=con.prepareStatement(sql);
                ptmt.setInt(1, 0);
                ptmt.setString(2, sb.getMaSanBay());
                if(ptmt.executeUpdate()>0){
                    flag=true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                BaseDAO.closeConnection();
            }
        }
        return flag;
    }
    public Vector<SanBayDTO> getstatus(boolean status) throws SQLException{
        Vector<SanBayDTO> list=new Vector<SanBayDTO>();
        Connection con=BaseDAO.getConnection();
        String sql;
        if(con!=null){
            try{
                if(status){
                    sql="Select * from sanbay where status=1";
                }else{
                    sql="Select * from sanbay where status=0";
                }
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SanBayDTO dto=new SanBayDTO();
                    dto.setMaSanBay(rs.getString("maSanBay"));
                    dto.setTen(rs.getNString("ten"));
                    if(rs.getInt("status")==1){
                        dto.setStatus(true);
                    }else{
                        dto.setStatus(false);
                    }
                    list.add(dto);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                BaseDAO.closeConnection();
            }
        }
        return list;    
    }
    public Vector<SanBayDTO> getid(String ma, boolean status) throws SQLException{
        Vector<SanBayDTO> list=new Vector<SanBayDTO>();
        Connection con=BaseDAO.getConnection();
        String sql;
        if(con!=null){
            try{
                if(status){
                    sql="Select * from sanbay where status=1";
                }else{
                    sql="Select * from sanbay where status=0";
                }
                if(!ma.isEmpty()){
                    sql=sql+" and maSanBay like N'%" + ma + "%'";
                }
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SanBayDTO dto=new SanBayDTO();
                    dto.setMaSanBay(rs.getString("maSanBay"));
                    dto.setTen(rs.getNString("ten"));
                    if(rs.getInt("status")==1){
                        dto.setStatus(true);
                    }else{
                        dto.setStatus(false);
                    }
                    list.add(dto);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                BaseDAO.closeConnection();
            }
        }
        return list;    
    }
    public Vector<SanBayDTO> getvitri(String vitri, boolean status) throws SQLException{
        Vector<SanBayDTO> list=new Vector<SanBayDTO>();
        Connection con=BaseDAO.getConnection();
        String sql;
        if(con!=null){
            try{
                if(status){
                    sql="Select * from sanbay where status=1";
                }else{
                    sql="Select * from sanbay where status=0";
                }
                if(!vitri.isEmpty()){
                    sql=sql+" and ten like N'%" + vitri + "%'";
                }
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SanBayDTO dto=new SanBayDTO();
                    dto.setMaSanBay(rs.getString("maSanBay"));
                    dto.setTen(rs.getNString("ten"));
                    if(rs.getInt("status")==1){
                        dto.setStatus(true);
                    }else{
                        dto.setStatus(false);
                    }
                    list.add(dto);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                BaseDAO.closeConnection();
            }
        }
        return list;    
    }
    public boolean checkid(String id) throws SQLException{
        boolean flag=true;
        Connection con=BaseDAO.getConnection();
        if(con!=null){
            try{
                String sql ="SELECT * FROM sanbay, chuyenbay WHERE sanbay.maSanBay='"+id+"' AND (sanbay.maSanBay=chuyenbay.maSanBayDi OR sanbay.maSanBay=chuyenbay.maSanBayDen)";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    String temp=rs.getString("maSanBay");
                    if(!temp.isEmpty()){
                        flag=false;
                    }
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                BaseDAO.closeConnection();
            }
        }
        return flag;
    }
    
    
    
}
