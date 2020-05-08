
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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
public class CetakTiket extends JFrame{
   ModelData modelData = new ModelData();
   JLabel lid = new JLabel("ID ");
   JLabel lnama_kereta1;
   JLabel ltanggal1;
   JLabel lno_kereta1;
   JLabel lberangkat1;
   JLabel lAsal1;
   JLabel lTiba1;
   JLabel ltiba1;
   JLabel lid1;
   JLabel lnama1;
   JLabel lalamat1;
   JLabel ltelepon1;
   JLabel lemail1;
   JLabel lharga1;
   JLabel lNama = new JLabel("Nama ");
   JLabel lAlamat = new JLabel("Alamat ");
   JLabel lTelepon = new JLabel("Telepon ");
   JLabel lEmail = new JLabel("Email ");
   JLabel lTanggal = new JLabel("TANGGAL");
   JLabel lNo_Kereta = new JLabel("NO KERETA");
   JLabel lNama_Kereta = new JLabel("NAMA KERETA");
   JLabel lBerangkat = new JLabel("BERANGKAT KA");
   JLabel lTiba = new JLabel("TIBA KA");
   JLabel lJudul = new JLabel("BUKTI PEMBAYARAN TIKET KERETA API ");
   JLabel lJudul1 = new JLabel("Detil Pemesanan ");
   JLabel lJudul2 = new JLabel("Detil Perjalanan ");
   JLabel lAsal = new JLabel("Berangkat ");
   JLabel lTujuan = new JLabel("Tujuan ");
   JLabel lHarga = new JLabel("Tarif ");
   JLabel lGambar;
   JLabel lJarak;
   JButton btnKembali = new JButton("Kembali");
   
   String DBurl = "jdbc:mysql://localhost/kereta_api";
  String DBusername = "root";
  String DBpassword = "";  
  Connection connection;
  Statement statement;
  ResultSet resultset;
  String sql;
  String ID;
    
  public CetakTiket(){
      KoneksiDB DB = new KoneksiDB();
    DB.config();
    connection = DB.koneksi;
    statement = DB.statement;
    
    setTitle("Pembelian Tiket Kereta Api");
        lid1 = new JLabel ("");
        lnama1 = new JLabel ("");
        lalamat1 = new JLabel ("Yogyakarta");
        ltelepon1 = new JLabel ("");
        lemail1 = new JLabel ("");
        ltanggal1 = new JLabel ("");
        lnama_kereta1 = new JLabel ("");
        lno_kereta1 = new JLabel ("");
        lberangkat1 = new JLabel ("");
        ltiba1 = new JLabel ("");
        lTiba1 = new JLabel ("");
        lAsal1 = new JLabel ("");
        lharga1 = new JLabel ("");
        
        try
        {
            sql = "select * from tiket";
            resultset = statement.executeQuery(sql);
            while(resultset.next()){
               lnama1.setText(resultset.getString("Nama"));
               lid1.setText(resultset.getString("ID"));
               ltelepon1.setText(resultset.getString("Telepon"));
               lemail1.setText(resultset.getString("Email"));
            }
            sql = "select * from perjalanan";
            resultset = statement.executeQuery(sql);
            while(resultset.next()){
                lTiba1.setText(resultset.getString("tujuan"));
                lAsal1.setText(resultset.getString("asal"));
               ltanggal1.setText(resultset.getString("tanggal"));
               lharga1.setText(resultset.getString("Harga"));
            }
            sql = "select * from jadwal";
            resultset = statement.executeQuery(sql);
            while(resultset.next()){
               lno_kereta1.setText(resultset.getString("no_ka"));
               lnama_kereta1.setText(resultset.getString("Nama_Kereta"));
               lberangkat1.setText(resultset.getString("Berangkat"));
               ltiba1.setText(resultset.getString("Tiba"));
            }
            
        }
        catch(SQLException s)
        {
            
        }
        
        setLayout(null);
        add(lJudul);
        add(lJudul1);
        add(lJudul2);
	add(lNama);
	add(lnama1);
        add(lAlamat);
	add(lalamat1);
        add(lTelepon);
	add(ltelepon1);
        add(lEmail);
	add(lemail1);
        add(lTanggal);
	add(ltanggal1);
        add(lid);
	add(lid1);
        add(lNo_Kereta);
	add(lno_kereta1);
        add(lNama_Kereta);
	add(lnama_kereta1);
        add(lBerangkat);
	add(lberangkat1);
        add(lTiba);
	add(ltiba1);
        add(lAsal);
	add(lAsal1);
        add(lTujuan);
	add(lTiba1);
        add(btnKembali);
        add(lHarga);
        add(lharga1);

        
        lJudul.setBounds(70,0,600,40);
        lJudul1.setBounds(70,20,500,40);
        lid.setBounds(310,50,100,20);
        lid1.setBounds(380,50,200,20);
        lNama.setBounds(310,70,100,20);
        lnama1.setBounds(380,70,200,20);
        lAlamat.setBounds(310,90,100,20);
        lalamat1.setBounds(380,90,200,20);
        lTelepon.setBounds(310,110,100,20);
        ltelepon1.setBounds(380,130,200,20);
        lEmail.setBounds(310,130,100,20);
	lemail1.setBounds(380,110,200,20);
        
        lJudul2.setBounds(70,170,500,20);
        lTanggal.setBounds(70,190,100,20);
	ltanggal1.setBounds(70,210,100,20);
        lNo_Kereta.setBounds(180,190,100,20);
	lno_kereta1.setBounds(180,210,100,20);
        lNama_Kereta.setBounds(290,190,100,20);
	lnama_kereta1.setBounds(290,210,100,20);
        lBerangkat.setBounds(400,190,100,20);
	lberangkat1.setBounds(400,210,100,20);
        lTiba.setBounds(510,190,100,20);
        lHarga.setBounds(580,190,100,20);
        lharga1.setBounds(580,210,100,20);
	ltiba1.setBounds(510,210,100,20);
        lAsal.setBounds(140,55,100,20);
	lAsal1.setBounds(140,70,100,20);
        lTujuan.setBounds(140,130,100,20);
	lTiba1.setBounds(140,145,80,20);
        btnKembali.setBounds(630,5,70,40);
        
        setSize(750,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Menu m = new Menu(); 
            }
        });
   }
  
public static void main(String[] args) {
        new CetakTiket();
    }
  }

