/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

/**
 *
 * @author Afrien
 */
public class BarangController {
    BarangModel barangModel;
    MainMenu mainMenu;
    
    public BarangController(BarangModel barangModel, MainMenu mainMenu) {
        this.barangModel = barangModel;
        this.mainMenu = mainMenu;
        
        mainMenu.btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                InputBarang inputBarang = new InputBarang();
                inputBarang.setVisible(true);
            }
        });
        
        mainMenu.btnLihat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LihatBarang lihatBarang = new LihatBarang();
                lihatBarang.setVisible(true);
            }
        });
    }

}
