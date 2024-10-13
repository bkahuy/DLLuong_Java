/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GLuong;

/**
 *
 * @author buikh
 */
public class Person {

    private String manv;
    private String hoten;

    public Person() {
        this.hoten = "";
        this.manv = "";
    }

    public Person(String manv, String hoten) {
        this.manv = manv;
        this.hoten = hoten;
    }

    public String getManv() {
        return manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
