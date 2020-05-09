
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
public class ViewData extends JFrame implements ActionListener, ListenerData{
    final JTextField txnamadepan = new JTextField(10);
    final JTextField txnamabelakang = new JTextField(10);
    final JTextField txemail = new JTextField(10);
    final JTextField txtelepon = new JTextField(10);
    final JTextField txid = new JTextField(10);
    JLabel lnamadepan = new JLabel("Nama Depan");
    JLabel lnamabelakang = new JLabel("Nama Belakang");
    JLabel lemail = new JLabel("Alamat Email");
    JLabel ltelepon = new JLabel("No. Telepon");
    JLabel lid = new JLabel("No. KTP/SIM");
    JButton btnSave = new JButton("Submit");
    JButton btnReset = new JButton("Reset");
    JButton btnData = new JButton("Cetak");
    JLabel lJudul = new JLabel(" ISI DATA TIKET KERETA API ");
    
    ControllerData controllerData;
    ModelData modelData;
    
    public ViewData() {
        setTitle("INPUT DATA DIRI");
                
        setLayout(null);
        add(lnamadepan);
        add(lJudul);
        add(txnamadepan);
        add(lnamabelakang);
        add(txnamabelakang);
        add(lemail);
        add(txemail);
        add(ltelepon);
        add(txtelepon);
        add(lid);
        add(txid);
        add(btnSave);
        add(btnReset);
        add(btnData);
        
        lJudul.setFont(new java.awt.Font("Couture", 2, 18));
        lJudul.setForeground(Color.orange);
        lJudul.setBounds(250, 2, 360, 40);
        lnamadepan.setBounds(350, 70, 120, 20);
        txnamadepan.setBounds(470, 70, 170, 20);
        lnamabelakang.setBounds(350, 95, 120, 20);
        txnamabelakang.setBounds(470, 95, 170, 20);
        lemail.setBounds(350, 120, 120, 20);
        txemail.setBounds(470, 120, 170, 20);
        ltelepon.setBounds(350, 145, 120, 20);
        txtelepon.setBounds(470, 145, 170, 20);
        lid.setBounds(350, 170, 120, 20);
        txid.setBounds(470, 170, 170, 20);
        btnReset.setBounds(470, 220, 80, 20);
        btnSave.setBounds(560, 220, 80, 20);
        btnData.setBounds(370, 220, 80, 20);

        btnSave.addActionListener(this);
        btnReset.addActionListener(this);
        btnData.addActionListener(this);
        
        setSize(750, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        controllerData = new ControllerData();
        modelData = new ModelData();
        modelData.setDataListener(this);
        controllerData.setModel(modelData);
        
    }

    public JTextField getNamabelakang() {
        return txnamabelakang;
    }

    public JTextField getNamadepan() {
        return txnamadepan;
    }
    
    public JTextField getTelepon() {
        return txtelepon;
    }
    
    public JTextField getEmail() {
        return txemail;
    }

    public JTextField getId() {
        return txid;
    }

    public static void main(String[] args) {
        new ViewData();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            controllerData.submitForm(this);
        }
        if (e.getSource() == btnReset) {
            controllerData.resetForm(this);
        }
        if (e.getSource() == btnData) {
            controllerData.Data();
            setVisible(false);
        }
    }

    public void onChange(ModelData modelData) {
        txnamadepan.setText(modelData.getNamaDepan());
        txnamabelakang.setText(modelData.getNamaBelakang());
        txtelepon.setText(modelData.getTelepon());
        txemail.setText(modelData.getEmail());
        txid.setText(modelData.getID());
    }
}
