/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TongXeDTO;
import java.sql.*;

/**
 *
 * @author Lê Quang Hưng
 */
public class TongXeDAO extends KetNoiDAO {

    Connection conn = null;
    PreparedStatement ps = null;

    public int themCTHoaDon(TongXeDTO nx) throws Exception {
        int update=0;
        try {
            String sql = "INSERT INTO CT_HOADON(ID_THE,LoaiVe,BienSoXe,KhuVuc,ThoiGianGui,ThoiGianTra,LoaiXe) VALUES (?,?,?,?,?,?,?)";
            conn = KetNoiDAO.getKetNoiDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nx.getMaVe());
            ps.setString(2, nx.getLoaiXe());
            ps.setString(3, nx.getBienSo());
            ps.setString(4, nx.getKhuVuc());
            String x=nx.getNgayGui()+" "+nx.getGioGui();
            ps.setString(5, x);
            x=nx.getNgayTra()+" "+nx.getGioTra();
            ps.setString(6, x);
            ps.setString(7, nx.getLoaiXe());
            update = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }
    
    public int layMaCTHoaDon(String tgTra) throws Exception {
        int x=0;
        try {
            String sql = "select * from CT_HOADON where ThoiGianTra='"+tgTra+"'";
            conn = KetNoiDAO.getKetNoiDAO();
            ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                x=rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
    public int themHoaDon(String tgTao, int tien,int ctHD, String maNV) throws Exception {
        int update=0;
        try {
            String sql = "INSERT INTO HOADON VALUES ('HD00001',?,?,?,?)";
            conn = KetNoiDAO.getKetNoiDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, tgTao);
            ps.setInt(2, tien);
            ps.setInt(3, ctHD);
            ps.setString(4,maNV);
            update = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }

//    public int xoaXekhoibai(String bienso) throws Exception {
//        String sql = "delete from NHAPXE where BIENSO = '" + bienso + "'";
//        conn = KetNoiDAO.getKetNoiDAO();
//        ps = conn.prepareStatement(sql);
//        int update = ps.executeUpdate();
//        return update;
//    }
}
