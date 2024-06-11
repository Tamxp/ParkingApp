/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DKVeThangDTO;
import DTO.TongVeDTO;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lê Quang Hưng
 */
public class DangKyVeThangDAO extends KetNoiDAO {

    Connection conn = null;
    PreparedStatement ps = null;


    public int addVethang(DKVeThangDTO dkvt) throws Exception {
        int update=0;
        try {
            
            String sql = "INSERT INTO THETHANG VALUES (?,?,?,?,?,?)";
            conn = KetNoiDAO.getKetNoiDAO();
            ps = conn.prepareStatement(sql);
            String x1= dkvt.getNgayDk()+" 00:00:00";
            String x2= dkvt.getNgayHetHan()+" 00:00:00";
            ps.setString(1, "TT00001");
            ps.setString(2, x1);
            ps.setString(3, x2);
            ps.setString(4, dkvt.getBienSo());
            ps.setInt(5, dkvt.getSoTien());
            ps.setString(6, dkvt.getStatus());
            update = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }
    
    public static long layPhiThang (int ID) {
        double phiBD=0;
        long phi=0;
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select * from PHIGUIXE where ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                phiBD=rs.getDouble(6);
                phi=Math.round(phiBD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phi;
    }
    
    public static int layIDPhi (String Ma) {
        int IDphi=0;
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select * from THETHANG where ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                IDphi=rs.getInt(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDphi;
    }

    public static int updateVethang(String mave) {
        int update=0;
        try{
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "UPDATE THETHANG SET Status='Khong su dung' where ID='" + mave + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            update = ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }

    public String layTenCD(String macd) {
        String ten = "";
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select * from CUDAN where MACD='" + macd + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ten=rs.getString(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ten;
    }
//
//    private static LocalDate LocalDate(Date date) {
//        return LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//    }
//    
    public static String get_LoaiXe(String bienSo){
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select * from XE where BSX='" + bienSo + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public static ArrayList<String> loadBS(String maCD) {
        ArrayList<String> bsx = new ArrayList<>();
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select *from XE where MACD=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,maCD);
            ResultSet rs = st.executeQuery();
            bsx.removeAll(bsx);
            while (rs.next()) {
                bsx.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bsx;
    }
    
    public static ArrayList<String> loadMaThe(String maCD) {
        ArrayList<String> maThe = new ArrayList<>();
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "SELECT THETHANG.ID " +
                         "FROM THETHANG " +
                         "INNER JOIN XE ON THETHANG.BSX = XE.BSX " +
                         "WHERE XE.MACD = ? and THETHANG.Status='Dang su dung'";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,maCD);
            ResultSet rs = st.executeQuery();
            maThe.removeAll(maThe);
            while (rs.next()) {
                maThe.add(rs.getString("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maThe;
    }
    public static boolean checkBien(String bienso){
        boolean b = true;
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select BSX from THETHANG where BSX=? and Status='Dang su dung'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bienso);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public String layMaVe(String BSX){
        String b = "";
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select * from THETHANG where BSX=? and Status='Dang su dung'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, BSX);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b=rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public static DKVeThangDTO veXe2(String maThe) {
        DKVeThangDTO veXe = null;
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select *from THETHANG where ID=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,maThe);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                veXe = new DKVeThangDTO();
                veXe.setMaVethang(rs.getString(1));
                veXe.setBienSo(rs.getString(4));
                veXe.setSoTien(rs.getInt(5));
                veXe.setStatus(rs.getString(6));
                Timestamp timestamp = rs.getTimestamp(2);
                if (timestamp!=null){
                    LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
                    veXe.setNgayDk(localDate);
                }
                Timestamp timestamp1 = rs.getTimestamp(3);
                if (timestamp1!=null){
                    LocalDate localDate1 = timestamp1.toLocalDateTime().toLocalDate();
                    veXe.setNgayHetHan(localDate1);
                }
                String sql1 = "select *from XE where BSX='"+veXe.getBienSo()+"'";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                if (rs1.next()){
                    veXe.setLoaiXe(rs1.getString(2));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veXe;
    }
    
     public static ArrayList<DKVeThangDTO> traLichSu(String bsx) {
        ArrayList<DKVeThangDTO> thongTin = new ArrayList<>();
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select *from CT_HOADON where BienSoXe=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, bsx);
            ResultSet rs = st.executeQuery();
            DKVeThangDTO nx=null;
            thongTin.removeAll(thongTin);
            while (rs.next()) {
                nx = new DKVeThangDTO();
                nx.setMaVethang(rs.getString(2));
                nx.setBienSo(rs.getString(4));
                Timestamp timestamp = rs.getTimestamp(6);
                if (timestamp!=null){
                    LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
                    nx.setNgayDk(localDate);
                }
                Timestamp timestamp1 = rs.getTimestamp(7);
                if (timestamp1!=null){
                    LocalDate localDate1 = timestamp1.toLocalDateTime().toLocalDate();
                    nx.setNgayHetHan(localDate1);
                }
                nx.setSoTien(rs.getInt(1));
                nx.setStatus(layStatus(nx.getMaVethang()));
                String sql1 = "select *from HOADON where ID_CT_HOADON='"+nx.getSoTien()+"'";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                if (rs1.next()){
                    nx.setMaCD(rs1.getString(3).toString());
                }
                thongTin.add(nx);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thongTin;
    }
    
    public static String layStatus(String maThe){
        String b = "";
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "select * from THETHANG where ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maThe);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b=rs.getString(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    
        public static int thanhToan(String maThe) {
            int update = 0;
            try {
                Connection conn = KetNoiDAO.getKetNoiDAO();
                String sql = "UPDATE THETHANG " +
                     "SET NGAYTAO = DATEADD(DAY, DATEDIFF(DAY, 0, GETDATE()), 0), " +
                     "    NGAYHETHAN = DATEADD(DAY, DATEDIFF(DAY, 0, GETDATE()) + 30, 0), " +
                     "    Status = 'Dang su dung' " +
                     "WHERE ID = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, maThe);
                update = ps.executeUpdate();
                conn.close(); // Đóng kết nối sau khi sử dụng
            } catch (Exception e) {
                e.printStackTrace();
            }
            return update;
        }
    
    public static ArrayList<String> loadMaThe2(String maCD) {
        ArrayList<String> maThe = new ArrayList<>();
        try {
            Connection conn = KetNoiDAO.getKetNoiDAO();
            String sql = "SELECT THETHANG.ID " +
                         "FROM THETHANG " +
                         "INNER JOIN XE ON THETHANG.BSX = XE.BSX " +
                         "WHERE XE.MACD = ? and (THETHANG.Status='Het han' or THETHANG.Status='Khong su dung')";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,maCD);
            ResultSet rs = st.executeQuery();
            maThe.removeAll(maThe);
            while (rs.next()) {
                maThe.add(rs.getString("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maThe;
    }
    
}
