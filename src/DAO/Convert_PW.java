/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Le Chuong
 */
public class Convert_PW {
    public String convert(String pass) {
        try {
            // Tạo đối tượng MessageDigest với thuật toán SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Mã hóa chuỗi đầu vào thành mảng byte
            byte[] encodedhash = digest.digest(pass.getBytes());
            
            // Chuyển đổi mảng byte thành chuỗi hex
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < encodedhash.length; i++) {
                String hex = Integer.toHexString(0xff & encodedhash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString().toUpperCase();
            // In ra kết quả
            //System.out.println("Mã băm SHA-256 của chuỗi \"" + input + "\" là: " + Result);
        } catch (NoSuchAlgorithmException e) {
            // Xử lý nếu thuật toán không được hỗ trợ
            e.printStackTrace();
            return "";
        }
        //return "";
    }
    
    public static void main(String[] args) {
        Date date = new Date();

        // Định dạng ngày và giờ theo định dạng mong muốn (ví dụ: "yyyy-MM-dd HH:mm:ss")
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = formatter.format(date);

        // In ra ngày và giờ đã định dạng
        System.out.println("Ngày và giờ hiện tại: " + formattedDateTime);
    }
}
