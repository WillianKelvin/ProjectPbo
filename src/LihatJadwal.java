
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class LihatJadwal extends JFrame {

    String[][] data = new String[500][6];
    String[] kolom = {"No KA", "Nama Kereta", "Kelas", "Tujuan", "Berangkat", "Tiba"};
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

    public LihatJadwal() {
        setTitle("Jadwal Kereta Api");

        setLayout(null);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                    DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from jadwal ";
            resultSet = statement.executeQuery(sql);
            int p = 0;
            while (resultSet.next()) {
                data[p][0] = resultSet.getString("no_ka");
                data[p][1] = resultSet.getString("Nama_Kereta");
                data[p][2] = resultSet.getString("Kelas");
                data[p][3] = resultSet.getString("Tujuan");
                data[p][4] = resultSet.getString("Berangkat");
                data[p][5] = resultSet.getString("Tiba");
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        btnBack = new JButton("BACK");

        panelTombol = new JPanel(new FlowLayout());
        setLayout(new BorderLayout());
        add(panelTombol, BorderLayout.EAST);
        panelTombol.add(btnBack);

        setSize(750, 300);
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
        LihatJadwal lihatJadwal = new LihatJadwal();
    }
}
