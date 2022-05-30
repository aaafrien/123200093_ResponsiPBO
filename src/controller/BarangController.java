/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import model.*;
import view.*;

/**
 *
 * @author Afrien
 */
public class BarangController {
    BarangModel barangModel;
    MainMenu mainMenu;
    public Object title[] = {"ID", "Nama Barang", "Massa", "Harga"};
    
    public BarangController(BarangModel barangModel, MainMenu mainMenu) {
        this.barangModel = barangModel;
        this.mainMenu = mainMenu;
        
        mainMenu.btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mainMenu.dispose();
                InputBarang inputBarang = new InputBarang();
                InputController inputController = new InputController(inputBarang, barangModel);  
            }
        });
        
        mainMenu.btnLihat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LihatBarang lihatBarang = new LihatBarang();
                BarangModel barangModel = new BarangModel();
                mainMenu.dispose();
                
                LihatController lihatController = new LihatController(lihatBarang, barangModel);
               
            }
        });
    }
}
