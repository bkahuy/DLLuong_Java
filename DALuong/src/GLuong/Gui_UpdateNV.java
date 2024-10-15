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
import java.sql.*;
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
    private JButton btnRefresh;
    
    public Gui_UpdateNV(){
        setTitle("CHUONG TRINH QUAN LY LUONG");
        setSize(1000,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        BuildGui();
        loadData(dfmode);
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
        
        //ma nhan vien
        JLabel lbmanv = new JLabel("Ma nhan vien");
        lbmanv.setAlignmentX(Component.LEFT_ALIGNMENT);
        pntrai.add(lbmanv);
        tfmanv = new JTextField();
        tfmanv.setMaximumSize(new Dimension(300,30));
        pntrai.add(tfmanv);
        pntrai.add(Box.createRigidArea(new Dimension(0, 10)));
        
        // ho ten
        JLabel lbhoten = new JLabel("Ho ten:");
        lbhoten.setAlignmentX(Component.LEFT_ALIGNMENT);
        pntrai.add(lbhoten);
        tfhoten = new JTextField();
        tfhoten.setMaximumSize(new Dimension(300,30));
        pntrai.add(tfhoten);
        pntrai.add(Box.createRigidArea(new Dimension(0, 10)));
            
        //dia chi
        JLabel lbdiachi = new JLabel("Dia chi");
        lbdiachi.setAlignmentX(Component.LEFT_ALIGNMENT);
        pntrai.add(lbdiachi);
        tfdiachi = new JTextField();
        tfdiachi.setMaximumSize(new Dimension(300,30));
        pntrai.add(tfdiachi);
        pntrai.add(Box.createRigidArea(new Dimension(0, 10)));
        
        //luong
        JLabel lbluong = new JLabel("Luong");
        lbluong.setAlignmentX(Component.LEFT_ALIGNMENT);
        pntrai.add(lbluong);
        tfluong = new JTextField();
        tfluong.setMaximumSize(new Dimension(300,30));
        pntrai.add(tfluong);
        pntrai.add(Box.createRigidArea(new Dimension(0,10)));
        
        // Buttons
        JPanel pnLeftBottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnthem = new JButton("Thêm");
        btnsua = new JButton("Sửa");
        btnxoa = new JButton("Xóa");
        btntimkiem = new JButton("Tìm kiếm");
        btnRefresh = new JButton("refresh");
        pnLeftBottom.add(btnthem);
        pnLeftBottom.add(btnsua);
        pnLeftBottom.add(btnxoa);
        pnLeftBottom.add(btntimkiem);
        pnLeftBottom.add(btnRefresh);
        pntrai.add(pnLeftBottom);
        
        //table
        JPanel pnphai = new JPanel(new GridLayout(1,1));
        String[] headers = {"Ma nhan vien", "Ho ten", "Dia chi", "Luong"};
        dfmode = new DefaultTableModel(headers, 0);
        tb = new JTable(dfmode);
        pnphai.add(new JScrollPane(tb));
        this.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pntrai, pnphai));
        
        
        
        
        //bat su kien chon trong bang
        tb.getSelectionModel().addListSelectionListener((e) -> {
            try {
                int selectRow = tb.getSelectedRow();
                if(selectRow != -1){
                    tfmanv.setText(tb.getValueAt(selectRow, 0).toString());
                    tfhoten.setText(tb.getValueAt(selectRow, 1).toString());
                    tfdiachi.setText(tb.getValueAt(selectRow, 2).toString());
                    tfluong.setText(tb.getValueAt(selectRow, 3).toString());
                    
                }
            } catch (Exception ex) {
            }
        });
        
        
        //bat su kien them
        btnthem.addActionListener((e) -> {
            String manv = tfmanv.getText().trim();
            String hoten = tfhoten.getText().trim();
            String diachi = tfdiachi.getText().trim();
            int luong = 0;
            
            boolean isValid = true;
            try {
                luong = Integer.parseInt(tfluong.getText().trim());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "nhap luong khong hop le" + ex.getMessage());
                isValid = false;
            }
            if(manv.isEmpty() || hoten.isEmpty() || !isValid){
                JOptionPane.showMessageDialog(null, "vui long nhap thong tin nhan vien!");
            }
            else if (XLLuong.checkmanv(manv)){
                JOptionPane.showMessageDialog(null, "ma nhan vien da ton tai");
            }
            else {
                boolean res = XLLuong.themnv(new Nhanvien(manv, hoten, diachi, luong));
                if (res){
                    loadData(dfmode);
                    JOptionPane.showMessageDialog(null, "them can bo thanh cong");
                    tfmanv.setText("");
                    tfhoten.setText("");
                    tfdiachi.setText("");
                    tfluong.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "them nhan vien that bai!");
                }
            }
        });
        
        // bat su kien sua nhan vien
        btnsua.addActionListener((e) -> {
            String manv = tfmanv.getText().trim();
            String hoten = tfhoten.getText().trim();
            String diachi = tfdiachi.getText().trim();
            int luong = 0;
            boolean isValid = true;
            
            ResultSet resmanv = XLLuong.getData(manv);
            
            try {
                if(manv != null){
                    try {
                        luong = Integer.parseInt(tfluong.getText().trim());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "nhap luong khong hop le");
                        isValid = false;
                    }
                    if (manv.isEmpty() || hoten.isEmpty() || !isValid){
                        JOptionPane.showMessageDialog(null, "vui long nhap lai thong tin nhan vien");
                    }
                    else {
                        boolean res = XLLuong.suanv(manv, new Nhanvien(manv, hoten, diachi, luong));
                        if (res) {
                            loadData(dfmode);
                            JOptionPane.showMessageDialog(null, "Sua thành công!");
                            tfmanv.setText("");
                            tfhoten.setText("");
                            tfdiachi.setText("");
                            tfluong.setText("");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "cap nhat khong thanh cong");
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "kh0ng ton tai ma nhan vien");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        
        // bat su kien xoa
        btnxoa.addActionListener((e) -> {
            String manv = tfmanv.getText().trim();
            if(manv.isEmpty()){
                JOptionPane.showMessageDialog(null, "chon mot nhan vien de xoa");
            }
            else {
                boolean res = XLLuong.xoanv(manv);
                if (res) {
                    loadData(dfmode);
                    JOptionPane.showMessageDialog(null, "xoa thành công!");
                    tfmanv.setText("");
                    tfhoten.setText("");
                    tfdiachi.setText("");
                    tfluong.setText("");

                }
                
            }
        });
        
        // bat su kien tim kiem
        btntimkiem.addActionListener((e) -> {
            String manv = tfmanv.getText().trim(); 
            if(manv.isEmpty()){
                JOptionPane.showMessageDialog(null, "vui long nhap ma nhan vien!");
            }
            else {
                try {
                    ResultSet res = XLLuong.getData(manv);
                    if(res != null && res.next()){
                        //xoa du lieu trong bang
                        dfmode.setRowCount(0);
                        //them ket qua tim kiem vao bang
                        dfmode.addRow(new String[]{
                            res.getString("manv"),
                            res.getString("hoten"),
                            res.getString("diachi"),
                            res.getString("luong")
                        });
                        
                        //hien thi du lieu len cac o
                        tfhoten.setText(res.getString("hoten"));
                        tfdiachi.setText(res.getString("diachi"));
                        tfluong.setText(res.getString("luong"));
                    }
                } catch (SQLException ex) {
                    loadData(dfmode);
                    JOptionPane.showMessageDialog(null, "khong tim thay nhan vvien");
                }
            }
        });
        
        //bat su kien refresh
        btnRefresh.addActionListener((e) -> {
            loadData(dfmode);
            tfmanv.setText("");
            tfhoten.setText("");
            tfdiachi.setText("");
            tfluong.setText(""); 
        });
        
    }
    
    private void loadData(DefaultTableModel dfmode){
        try {
            ResultSet res = XLLuong.getAllData();
            dfmode.setRowCount(0);
            dfmode.fireTableDataChanged();
            if(res != null){
                while (res.next()){
                    dfmode.addRow(new String[]{
                        res.getString("manv"),
                        res.getString("hoten"),
                        res.getString("diachi"),
                        res.getString("luong")
                    });
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        XLLuong.getCon();
        SwingUtilities.invokeLater(() -> {
            new Gui_UpdateNV().setVisible(true);
        });
//        new Gui_UpdateNV().setVisible(true);
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