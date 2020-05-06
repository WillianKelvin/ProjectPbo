
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
public class ViewDaftar extends JFrame implements ActionListener , ListenerDaftar{
    JTextField txnamalengkap = new JTextField(10);
    JTextField txemail = new JTextField(10);
    JTextField txusername = new JTextField(10);
    
    JPasswordField ppassword = new JPasswordField(10);
    JPasswordField ppassword1 = new JPasswordField(10);
    
    JLabel lJudul = new JLabel("DAFTAR AKUN ");
    JLabel lJudul1 = new JLabel("SILAHKAN =D ");
    JLabel lnamalengkap = new JLabel("Nama Lengkap");
    JLabel lemail = new JLabel("Alamat Email");
    JLabel lusername = new JLabel("Username");
    JLabel lpassword = new JLabel("Password");
    JLabel lpassword1 = new JLabel("Confirm Password");
    
    JButton btndaftar = new JButton("Daftar");
    JButton btnlogin = new JButton("Login");
    
    ControllerDaftar controllerDaftar;
    ModelDaftar modelDaftar;
    
    public ViewDaftar(){
        setTitle("DAFTAR");
        
        setLayout(null);
        add(lJudul);
        add(lJudul1);
        add(lnamalengkap);
        add(txnamalengkap);
        add(lemail);
        add(txemail);
        add(lusername);
        add(txusername);
        add(lpassword);
        add(ppassword);
        add(lpassword1);
        add(ppassword1);
        add(btnlogin);
        add(btndaftar);
        
        lJudul.setFont(new java.awt.Font("Couture", 2, 24));
        lJudul.setForeground(Color.orange);
        lJudul.setBounds(10, 10, 360, 40);
        lJudul1.setFont(new java.awt.Font("Century Gothic", 2, 10));
        lJudul1.setForeground(Color.black);
        lJudul1.setBounds(10, 28, 360, 40);
        lnamalengkap.setBounds(50, 90, 120, 20);
        lnamalengkap.setForeground(Color.white);
        txnamalengkap.setBounds(170, 90, 170, 20);
        lemail.setBounds(50, 115, 120, 20);
        lemail.setForeground(Color.white);
        txemail.setBounds(170, 115, 170, 20);
        lusername.setBounds(50, 140, 120, 20);
        lusername.setForeground(Color.white);
        txusername.setBounds(170, 140, 170, 20);
        lpassword.setBounds(50, 165, 120, 20);
        lpassword.setForeground(Color.white);
        ppassword.setBounds(170, 165, 170, 20);
        lpassword1.setBounds(50, 190, 120, 20);
        lpassword1.setForeground(Color.white);
        ppassword1.setBounds(170, 190, 170, 20);
        btnlogin.setBounds(50, 240, 80, 20);
        btndaftar.setBounds(250, 240, 80, 20);
       
        btnlogin.addActionListener(this);
        btndaftar.addActionListener(this);
        
        setDefaultCloseOperation(3);
        setSize(400, 350);
        setVisible(true);

        controllerDaftar = new ControllerDaftar();
        modelDaftar = new ModelDaftar();
        modelDaftar.setDaftarListener(this);
        controllerDaftar.setModel(modelDaftar);
    }
    public JTextField getnamalengkap() {
        return txnamalengkap;
    }

    public JTextField getEmail() {
        return txemail;
    }
    
    public JTextField getUsername() {
        return txusername;
    }
    
    public JTextField getPassword() {
        return ppassword;
    }
    
    public JTextField getPassword1() {
        return ppassword1;
    }

    public static void main(String[] args) {
        new ViewDaftar();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btndaftar) {
            controllerDaftar.submitForm(this);
        }
        if (e.getSource() == btnlogin) {
            controllerDaftar.Login();
            setVisible(false);
        }
    }

    public void onChange(ModelDaftar modelDaftar) {
        txnamalengkap.setText(modelDaftar.getNamaLengkap());
        txemail.setText(modelDaftar.getEmail());
        txusername.setText(modelDaftar.getUsername());
        ppassword.setText(modelDaftar.getPassword());
        ppassword1.setText(modelDaftar.getPassword1());
    }
}
