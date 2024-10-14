/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;
import GLuong.XLLuong;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author buikh
 */
public class Gui_UpdateNV extends JFrame implements MouseListener, ActionListener{
    
    private JTextField tfmanv;
    private JTextField tfhoten;
    private JTextField tfdiachi;
    private JTextField tfluong;
    private JTable tb;
    private DefaultTableModel dfmode;
    private JButton btnthem;
    private JButton btnsua;
    private JButton btnxoa;
    private JButton btntimkiem;
    
    public Gui_UpdateNV(){
        setTitle("CHUONG TRINH QUAN LY LUONG");
        setSize(1000,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        BuildGui();
    }
    
    private void BuildGui(){
        // tao panel nhap thong tin
        JPanel pntrai = new JPanel();
        pntrai.setLayout(new BoxLayout(pntrai, BoxLayout.Y_AXIS));
        pntrai.setBorder(new  EmptyBorder(20, 20, 20, 20));
        
        //label thong tin nhan vien
        JLabel lbthongtin = new JLabel("THONG TIN NHAN VIEN", JLabel.CENTER);
        lbthongtin.setAlignmentX(Component.LEFT_ALIGNMENT);
        tfmanv = new JTextField();
        pntrai.add(lbthongtin);
        pntrai.add(lbthongtin);
        tfmanv.setMaximumSize(new Dimension(300, 30));
        
        // ho ten
        JLabel lbhoten = new JLabel("Ho ten:");
        lbhoten.setAlignmentX(Component.LEFT_ALIGNMENT);
        pntrai.add(lbhoten);
        tfhoten = new JTextField();
        tfhoten.setMaximumSize(new Dimension(300,30));
        pntrai.add(tfhoten);
        pntrai.add(Box.createRigidArea(new Dimension(0, 10)));
            
        //dia chi
        JLabel lbdiachi = new JLabel("dia chi");
        lb
        
    }
    
    public static void main(String[] args) {
        XLLuong.getCon();
//        SwingUtilities.invokeLater(() -> {
//            new Gui_UpdateNV().setVisible(true);
//        });
        new Gui_UpdateNV().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}