/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;
import java.sql.*;
/**
 *
 * @author buikh
 */
public class XLLuong {
    private static Connection cn;
    
    public static void getCon(){
        try {
            cn = DriverManager.getConnection("jdbc:sqlserver://BKAHUYYYYY;database=DLLuong;user=sa;password=1;trustServerCertificate=true;");
            System.out.println("pass");
        } catch (SQLException e) {
            System.out.println("failed" + e.getMessage());
        }
    }
    
    public static ResultSet getAllData(){
        try {
            Statement st = cn.createStatement();
            return st.executeQuery("select * from tbNhanvien");
        } catch (SQLException e) {
            System.out.println("Failed: "+ e.getMessage());
            return null;
        }
    }
    
    //lay du lieu theo ma nhan vien
    public static  ResultSet getData(String manv){
        try {
            PreparedStatement pst = cn.prepareStatement("select * from tbNhanvien where manv = '" + manv + "'");
            return pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed: " + e.getMessage());
            return null;
        }
    }
    
    //validate
    public static boolean checkmanv(String manv){
        try {
            PreparedStatement pst = cn.prepareStatement("select * from tbNhanvien where manv = '" + manv + "'");
            ResultSet result = pst.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println("Failed: "+ e.getMessage());
            return false;
        }
    }
    //them nhan vien
    public static boolean themnv(Nhanvien nv){
        try {
            if(!checkmanv(nv.getManv())){
                PreparedStatement pst = cn.prepareStatement("insert into tbNhanvien values (?, ?, ?, ?)");
                pst.setString(1, nv.getManv());
                pst.setString(2, nv.getHoten());
                pst.setString(3, nv.getDiachi());
                pst.setLong(4, nv.getLuong());
                int res = pst.executeUpdate();
                return res>0;
            }
                
        } catch (SQLException e) {
            System.out.println("Failed: "+ e.getMessage());
            return false;
        }
        return false;
    }
    
    //sua thong tin nhan vien
    public static boolean suanv(String manv, Nhanvien nv){
        try {
            PreparedStatement pst = cn.prepareStatement("update tbNhanvien set hoten = N'" + nv.getHoten() + "', diachi = N'" + nv.getDiachi() + "', luong = '" + nv.getLuong() +"' where manv = '" +manv+"'");
            int res = pst.executeUpdate();
            return res>0;
        } catch (SQLException e) {
            System.out.println("Failed: "+ e.getMessage());
            return false;
        }
    }
    //xoa nhan vien
    public static boolean xoanv(String manv){
        try {
            PreparedStatement pst = cn.prepareStatement("delete from tbNhanvien where manv = '" + manv + "'");
            int res = pst.executeUpdate();
            return res>0;
        } catch (SQLException e) {
            System.out.println("Failed: "+ e.getMessage());
            return false;
        }
    }
}
