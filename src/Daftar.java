
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
public class Daftar {

    String DBurl = "jdbc:mysql://localhost/kereta_api";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public void Data(ViewDaftar viewdaftar) {
        String nama = viewdaftar.getnamalengkap().getText();
        String email = viewdaftar.getEmail().getText();
        String username = viewdaftar.getUsername().getText();
        String password = viewdaftar.getPassword().getText();
        String password1 = viewdaftar.getPassword1().getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("INSERT INTO login VALUES('" + nama + "','" + email + "','" + username + "','" + password + "')");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

}
