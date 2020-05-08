
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class InputData {
    String DBurl = "jdbc:mysql://localhost/data1";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
     public void MasukkanData(ViewData view)
    {
        String namaDepan = view.getNamadepan().getText();
        String namaBelakang = view.getNamabelakang().getText();
        String telepon = view.getTelepon().getText();
        String email = view.getEmail().getText();
        String id = view.getId().getText();
         try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("insert into tiket values('" + namaDepan+" "+namaBelakang + "','" + telepon+ "','" + email + "','" + id + "')");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
}
