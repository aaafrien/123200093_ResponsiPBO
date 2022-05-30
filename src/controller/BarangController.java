/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.*;
import view.*;

/**
 *
 * @author Afrien
 */
public class BarangController {
    BarangModel barangModel;
    MainMenu mainMenu;
    InputBarang inputBarang;
    LihatBarang lihatBarang;
    public Object title[] = {"ID", "Nama Barang", "Massa", "Harga"};
    
    public BarangController(BarangModel barangModel, MainMenu mainMenu) {
        this.barangModel = barangModel;
        this.mainMenu = mainMenu;
        this.inputBarang = inputBarang;
        this.lihatBarang = lihatBarang;
        
        mainMenu.btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mainMenu.dispose();
                InputBarang inputBarang = new InputBarang();
                InputController inputController = new InputController(inputBarang, barangModel);  
                System.out.println("tesst");
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
