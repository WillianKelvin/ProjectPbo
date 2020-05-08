
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
public class ControllerData {
    private ModelData model;
    
    public void setModel(ModelData model) {
        this.model = model;
    }
    
    public void Data() {
          CetakTiket Lihat = new CetakTiket();
          Lihat.setVisible(true); 
    }
    
    public void resetForm(ViewData viewdata) {
        String namaDepan = viewdata.getNamadepan().getText();
        String namaBelakang = viewdata.getNamabelakang().getText();
        String telepon = viewdata.getTelepon().getText();
        String email = viewdata.getEmail().getText();
        String id = viewdata.getId().getText();
        
        if (namaDepan.equals("") && namaBelakang.equals("") && telepon.equals("")&& email.equals("") &&id.equals("")) {
        } else {
            model.resetForm();
        }
    }
    
    public void submitForm(ViewData viewdata) {
        

        String namaDepan = viewdata.getNamadepan().getText();
        String namaBelakang = viewdata.getNamabelakang().getText();
        String telepon = viewdata.getTelepon().getText();
        String email = viewdata.getEmail().getText();
        String id = viewdata.getId().getText();
        
        if (namaDepan.trim().equals("")) {
            JOptionPane.showMessageDialog(viewdata, "Nama Depan Masih Kosong !");
        } else if (namaBelakang.trim().equals("")) {
            JOptionPane.showMessageDialog(viewdata, "Nama Belakang Masih Kosong !");
        } else if (telepon.trim().equals("")) {
            JOptionPane.showMessageDialog(viewdata, "Telepon Masih Kosong !"); 
        }  else if (email.trim().equals("")) {
            JOptionPane.showMessageDialog(viewdata, "Email Masih Kosong !"); 
        }
         else if (id.trim().equals("")) {
            JOptionPane.showMessageDialog(viewdata, "Nomor ID Masih Kosong !"); 
        }
        else {
            model.submitForm(viewdata);
        }
        
    }
}
