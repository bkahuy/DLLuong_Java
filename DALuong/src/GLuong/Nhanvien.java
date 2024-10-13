/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

/**
 *
 * @author buikh
 */
public class Nhanvien extends Person{
    private String diachi;
    private long luong;

    public Nhanvien() {
        super();
        this.diachi = "";
        this.luong = 0;
    }

    public Nhanvien(String diachi, long luong, String manv, String hoten) {
        super(manv, hoten);
        this.diachi = diachi;
        this.luong = luong;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public String getDiachi() {
        return diachi;
    }

    public long getLuong() {
        return luong;
    }

    
    
}
