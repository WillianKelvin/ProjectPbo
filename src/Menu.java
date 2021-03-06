
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

        lGambar = new JLabel (new ImageIcon(getClass().getResource("image/kereta-api.jpg")));
        setLayout(null);
        add(lJudul);
        add(lPesan);
        add(lJadwal);
        add(lRiwayat);
        add(btnPesan);
        add(btnJadwal);
        add(btnRiwayat);
        add(lGambar);

        lJudul.setFont(new java.awt.Font("Couture", 2, 27));
        lJudul.setForeground(Color.orange);
        lPesan.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        lJadwal.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        lRiwayat.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        lPesan.setForeground(Color.white);
        lJadwal.setForeground(Color.white);
        lRiwayat.setForeground(Color.white);
        
        lJudul.setBounds(130, 2, 480, 40);
        lPesan.setBounds(120, 220, 120, 20);
        lJadwal.setBounds(320, 220, 160, 20);
        lRiwayat.setBounds(530, 220, 150, 20);
        btnPesan.setBounds(100, 170, 100, 50);
        btnJadwal.setBounds(330, 170, 100, 50);
        btnRiwayat.setBounds(550, 170, 100, 50);
        lGambar.setBounds(5,5,745,290);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 300);
        setVisible(true);
        
        btnPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                DataPesan data = new DataPesan();
            }
        });
        
        btnJadwal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                LihatJadwal jadwal = new LihatJadwal();
            }
        });

        btnRiwayat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                RiwayatPerjalanan r = new RiwayatPerjalanan();
            }
        });
    }

    public static void main(String[] args) {
        new Menu();
    }
}
