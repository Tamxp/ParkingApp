/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhiDTO;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lê Quang Hưng
 */
public class PhiGuiXeDAO extends KetNoiDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    List<PhiDTO> list = new ArrayList<>();


    public static ArrayList<PhiDTO>loadPhi() {
        ArrayList<PhiDTO> dsphi = new ArrayList<>();
        try {
            PhiDTO phi  = null;
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select * from PHIGUIXE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                phi = new PhiDTO();
                phi.setLoaiXe(rs.getString(2));
                phi.setPhiBanNgay(rs.getInt(3));
                phi.setPhiBanDem(rs.getInt(4));
                phi.setPhiThang(rs.getInt(6));
                Date x=rs.getDate(5);
                phi.setNgayTao(x.toLocalDate());
                phi.setMaNV(rs.getString(7));
                dsphi.add(phi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsphi;
    }
  
    public int capNhatPhi(PhiDTO x) {
        int update=0;
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "update PHIGUIXE set PhiBanNgay=?, PhiBanDem=?,PhiThang=?,NgayTaoPhi=?,MANV=? where LoaiXe=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,x.getPhiBanNgay());
            ps.setInt(2, x.getPhiBanDem());
            ps.setInt(3, x.getPhiThang());
            ps.setDate(4,Date.valueOf(x.getNgayTao()));
            ps.setString(5, x.getMaNV());
            ps.setString(6, x.getLoaiXe());
            update = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }
}
