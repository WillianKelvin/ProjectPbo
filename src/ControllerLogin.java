
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
public class ControllerLogin {
    private ModelLogin model;
    
    public void setModel(ModelLogin model) {
        this.model = model;
    }
    public void Daftar() { 
          ViewDaftar daftar = new ViewDaftar();
          daftar.setVisible(true); 
    }
    public void resetForm(ViewLogin viewLogin) {
        String username = viewLogin.getUsername().getText();
        String password = viewLogin.getPassword().getText();

        if (username.equals("") && password.equals("")) {
        } else {
            model.resetForm();
        }
    }
    public void submitForm(ViewLogin viewLogin) {
        String username = viewLogin.getUsername().getText();
        String password = viewLogin.getPassword().getText();

        if (username.trim().equals("")) {
            JOptionPane.showMessageDialog(viewLogin, "Username Masih Kosong !");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(viewLogin, "Password Masih Kosong !");
        } 
        else {
            model.submitForm(viewLogin);
        }
    }
}
