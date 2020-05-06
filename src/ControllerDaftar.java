
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
public class ControllerDaftar {
    private ModelDaftar model;

    public void setModel(ModelDaftar model) {
        this.model = model;
    }
    
    public void Login() { 
          ViewLogin daftar = new ViewLogin();
          daftar.setVisible(true); 
    }
    
    public void resetForm(ViewDaftar viewDaftar) {
        String namaLengkap = viewDaftar.getnamalengkap().getText();
        String email = viewDaftar.getEmail().getText();
        String username = viewDaftar.getUsername().getText();
        String password = viewDaftar.getPassword().getText();
        String password1 = viewDaftar.getPassword1().getText();

        if (namaLengkap.equals("") && email.equals("") && username.equals("") && password.equals("") && password1.equals("")) {
        } else {
            model.resetForm();
        }
    }
    public void submitForm(ViewDaftar viewDaftar) {
        String namaLengkap = viewDaftar.getnamalengkap().getText();
        String email = viewDaftar.getEmail().getText();
        String username = viewDaftar.getUsername().getText();
        String password = viewDaftar.getPassword().getText();
        String password1 = viewDaftar.getPassword1().getText();
        
        if(password.trim().equals(password1.trim()))
        {
        }
        else
        {
           JOptionPane.showMessageDialog(viewDaftar, "Konfirmasi Password Salah !"); 
        }

        if (namaLengkap.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Nama Depan Masih Kosong !");
        } else if (email.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Email Masih Kosong !");
        } else if (username.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Username Masih Kosong !");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Password Masih Kosong !");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Confirm Password Masih Kosong !");
        }
        else {
            model.submitForm(viewDaftar);
        }
    }
}
