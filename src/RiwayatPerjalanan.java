
import java.awt.*;
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
public class RiwayatPerjalanan extends JFrame {

    String[][] data = new String[500][6];
    String[] kolom = {"Berangkat ", "Tujuan", "Kelas", "Tanggal", "Harga"};
    JTable tabel;
    JScrollPane scrollPane;
    JButton btnBack;
    JPanel panelTombol;

    String DBurl = "jdbc:mysql://localhost/kereta_api";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;

    public RiwayatPerjalanan() {
        setTitle("Riwayat Perjalanan Kereta Api");
        setLayout(null);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                    DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from perjalanan ";
            resultSet = statement.executeQuery(sql);
            int p = 0;
            while (resultSet.next()) {
                data[p][0] = resultSet.getString("asal");
                data[p][1] = resultSet.getString("tujuan");
                data[p][2] = resultSet.getString("kelas");
                data[p][3] = resultSet.getString("tanggal");
                data[p][4] = resultSet.getString("Harga");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);

        setLayout(new FlowLayout());
        add(scrollPane);

        setSize(750, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        setLocationRelativeTo(null);
        btnBack = new JButton("BACK");
        panelTombol = new JPanel(new FlowLayout());
        setLayout(new BorderLayout());

        add(panelTombol, BorderLayout.PAGE_END);
        panelTombol.add(btnBack);
        setVisible(true);

        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().setVisible(true);
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        RiwayatPerjalanan RP = new RiwayatPerjalanan();
    }
}
