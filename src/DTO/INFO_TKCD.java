/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Le Chuong
 */
public class INFO_TKCD {
    private String maNV;
    private String hoTen;
    private String DC;
    private String CCCD;
    private String SDT;
    private String TrangThai;
    
    public INFO_TKCD(){
        
    }

    public INFO_TKCD(String maNV, String hoTen, int gt, String ngaySinh, String DC, String CCCD, String SDT) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.DC = DC;
        this.CCCD = CCCD;
        this.SDT = SDT;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }


    public void setDC(String DC) {
        this.DC = DC;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDC() {
        return DC;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getSDT() {
        return SDT;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    

}
