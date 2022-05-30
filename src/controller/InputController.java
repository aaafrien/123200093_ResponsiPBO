/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import model.BarangModel;
import view.*;

/**
 *
 * @author Afrien
 */
public class InputController {
    BarangModel barangModel;
    InputBarang inputBarang;
    LihatBarang lihatBarang;
    public Object title[] = {"ID", "Nama Barang", "Massa", "Harga"};
    
    public InputController(BarangModel barangModel, InputBarang inputBarang, LihatBarang lihatBarang) {
        this.inputBarang = inputBarang;
        this.barangModel = barangModel;
        this.lihatBarang = lihatBarang;
        
        inputBarang.btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("test");
                String nama = inputBarang.getNama();
                String massa = inputBarang.getMassa();
                String harga = inputBarang.getHarga();
                barangModel.tambahBarang(nama, massa, harga);
                String dataBarang[][] = barangModel.lihatBarang();
                lihatBarang.tabel.setModel((new JTable(dataBarang, title)).getModel());
            }
        });
        
        inputBarang.btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                inputBarang.setNama();
                inputBarang.setMassa();
                inputBarang.setHarga();
            }
        });
        
        inputBarang.btnKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                inputBarang.setVisible(false);
            }
        });
    } 
}