
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Menu extends JFrame {

    JLabel lGambar;
    JLabel lJudul = new JLabel("PEMESANAN TIKET KERETA API");
    JLabel lPesan = new JLabel("Pesan Tiket");
    JLabel lJadwal = new JLabel("Jadwal Kereta Api");
    JLabel lRiwayat = new JLabel("Riwayat Perjalanan");

    JButton btnPesan = new JButton("Pesan");
    JButton btnJadwal = new JButton("Jadwal");
    JButton btnRiwayat = new JButton("Riwayat");

    public Menu() {
        setTitle("Pembelian Tiket Kereta Api");

        setLayout(null);
        add(lJudul);
        add(lPesan);
        add(lJadwal);
        add(lRiwayat);
        add(btnPesan);
        add(btnJadwal);
        add(btnRiwayat);

        lJudul.setFont(new java.awt.Font("Couture", 2, 27));
        lJudul.setForeground(Color.orange);
        lPesan.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        lJadwal.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        lRiwayat.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        
        lJudul.setBounds(130, 2, 480, 40);
        lPesan.setBounds(90, 220, 120, 20);
        lJadwal.setBounds(290, 220, 160, 20);
        lRiwayat.setBounds(500, 220, 150, 20);
        btnPesan.setBounds(100, 170, 100, 50);
        btnJadwal.setBounds(330, 170, 100, 50);
        btnRiwayat.setBounds(550, 170, 100, 50);

        setDefaultCloseOperation(3);
        setSize(750, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }
}
