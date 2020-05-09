
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class DataPesan extends JFrame {
    String DBurl = "jdbc:mysql://localhost/kereta_api";
    String DBusername = "root";
    String DBpassword = "";
    JPanel panelForm, panelTombol;
    Connection koneksi;
    Statement statement;
    
    JLabel ljudul = new JLabel ("PEMESANAN TIKET KERETA API");
    JLabel lasal = new JLabel ("Asal");
    JLabel ltujuan = new JLabel ("Tujuan");
    JLabel ltanggal = new JLabel ("Tanggal");
    JLabel lbulan = new JLabel ("Bulan");
    JLabel ltahun = new JLabel ("Tahun");
    JLabel lkelas = new JLabel ("Kelas");
    JLabel lharga = new JLabel ("Harga");
    JLabel lhargaM;
    String kelas;
    JTextField txharga = new JTextField(10);
    
    String[] tanggal = {"1","2","3","4","5","6","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    JComboBox cmbtanggal = new JComboBox(tanggal);
    String[] bulan = {"Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
    JComboBox cmbbulan = new JComboBox(bulan);
    String[] tahun = {"2020"};
    JComboBox cmbtahun = new JComboBox(tahun);
    
    JRadioButton rbeksekutif = new JRadioButton ("Eksekutif");
    JRadioButton rbbisnis = new JRadioButton ("Bisnis");
    JRadioButton rbekonomi = new JRadioButton ("Ekonomi");
    
    String[] namaasal = {"YOGYAKARTA","LEMPUYANGAN"};
    JComboBox cmbasal = new JComboBox(namaasal);
    String[] namatujuan = {"Bandung","Jakarta","Malang","Surabaya"};
    JComboBox cmbtujuan = new JComboBox(namatujuan);
    
    JButton btnBeli = new JButton ("Beli");
    JButton btnKembali = new JButton ("Kembali");
    JButton btnLogout = new JButton ("Logout");
    JLabel lGambar;
    
    ControllerData controllerData;
    ModelData modelData;
    
    public DataPesan(){
        lhargaM = new JLabel ("");
        cmbasal.getSelectedItem().toString();
        cmbtujuan.getSelectedItem().toString();
        cmbtanggal.getSelectedItem();
        cmbbulan.getSelectedItem();
        cmbtahun.getSelectedItem();
        
        setTitle("Pembelian Tiket Kereta Api");
//        lGambar = new JLabel(new ImageIcon(getClass().getResource("kereta-api-indonesia.jpg")));
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbeksekutif);
        group.add(rbbisnis);
        group.add(rbekonomi);
        
        add(ljudul);
        add(lasal);
        add(ltujuan);
        add(ltanggal);
        add(lkelas);
        add(lbulan);
        add(ltahun);
        add(lharga);
        add(lhargaM);
        add(cmbasal);
        add(cmbtujuan);
        add(cmbtanggal);
        add(cmbbulan);
        add(cmbtahun);
        add(rbeksekutif);
        add(rbbisnis);
        add(rbekonomi);
        add(btnBeli);
        add(btnKembali);
        add(btnLogout);
        
        setLayout(null);
        ljudul.setBounds(170, 5, 450, 50);
        lasal.setBounds(320, 70, 120, 20);
        ltujuan.setBounds(470, 70, 120, 20);
        cmbasal.setBounds(320,100,150,20);
        cmbtujuan.setBounds(490,100,150,20);
        lkelas.setBounds(320,140,120,20);
        rbeksekutif.setBounds(370,170,100,20);
        rbbisnis.setBounds(480,170,80,20);
        rbekonomi.setBounds(580,170,80,20);
        ltanggal.setBounds(320,200,80,20);
        lbulan.setBounds(420,200,80,20);
        ltahun.setBounds(520,200,80,20);
        cmbtanggal.setBounds(320, 230, 80, 20);
        cmbbulan.setBounds(420,230,80,20);
        cmbtahun.setBounds(520,230,80,20);
        lharga.setBounds(320,260,80,20);
        lhargaM.setBounds(420,290,80,20);
        
        btnBeli.setBounds(400,330,80,20);
        btnKembali.setBounds(10,200,80,40);
        btnLogout.setBounds(650,5,80,40);
        
        setSize(750,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        if (rbeksekutif.isSelected())
        {
           kelas=rbeksekutif.getText();
            
        }
        else if (rbbisnis.isSelected())
        {
            kelas=rbbisnis.getText();
        }
        else
        {
            kelas=rbekonomi.getText();
        }
        
        rbeksekutif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(cmbtujuan.getSelectedItem().toString().equals("Jakarta"))
                {
                    lhargaM.setText("Rp. 470.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Bandung"))
                {
                    lhargaM.setText("Rp. 400.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Malang"))
                {
                    lhargaM.setText("Rp. 420.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Surabaya"))
                {
                    lhargaM.setText("Rp. 500.000,-");
                }
            }
        });
        
        rbbisnis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(cmbtujuan.getSelectedItem().toString().equals("Jakarta"))
                {
                    lhargaM.setText("Rp. 320.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Bandung"))
                {
                    lhargaM.setText("Rp. 300.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Malang"))
                {
                    lhargaM.setText("Rp. 330.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Surabaya"))
                {
                    lhargaM.setText("Rp. 350.000,-");
                }
            }
        });
        rbekonomi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(cmbtujuan.getSelectedItem().toString().equals("Jakarta"))
                {
                    lhargaM.setText("Rp. 250.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Bandung"))
                {
                    lhargaM.setText("Rp. 210.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Malang"))
                {
                    lhargaM.setText("Rp. 220.000,-");
                }
                else if(cmbtujuan.getSelectedItem().toString().equals("Surabaya"))
                {
                    lhargaM.setText("Rp. 270.000,-");
                }
            }
        });
        btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                masukkanData();
                ViewData input = new ViewData(); 
            }
        });
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Menu m = new Menu();
            }
        });
    }
    
    public void masukkanData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("INSERT INTO perjalanan VALUES('"+ cmbasal.getSelectedItem().toString() + "','" + cmbtujuan.getSelectedItem().toString() + "','" + kelas + "','" + cmbtanggal.getSelectedItem()+cmbbulan.getSelectedItem()+cmbtahun.getSelectedItem() + "','" + lhargaM.getText() + "')");
            JOptionPane.showMessageDialog(null, "Data BerhasilDisimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

public static void main(String[] args) {
        new DataPesan();
    }

}
