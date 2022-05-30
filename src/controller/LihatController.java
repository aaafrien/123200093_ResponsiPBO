/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.BarangModel;
import view.*;

/**
 *
 * @author Afrien
 */
public class LihatController {
    BarangModel barangModel;
    LihatBarang lihatBarang;

    public LihatController(LihatBarang lihatBarang, BarangModel barangModel) {
        this.lihatBarang = lihatBarang;
        this.barangModel = barangModel;
        
        if(barangModel.getDataBarang() !=0){
            String dataBarang[][] = barangModel.lihatBarang();
            lihatBarang.tabel.setModel((new JTable(dataBarang, lihatBarang.namaKolom)).getModel());
        }
        
        lihatBarang.tabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int i = lihatBarang.tabel.getSelectedRow();
                TableModel model = lihatBarang.tabel.getModel();
                String id = model.getValueAt(i, 0).toString();
                
                EditBarang editBarang = new EditBarang();
                editBarang.setId(id);
                lihatBarang.dispose();
                editBarang.tfNama.setText(model.getValueAt(i, 1).toString());
                editBarang.tfMassa.setText(model.getValueAt(i, 2).toString());
                editBarang.tfHarga.setText(model.getValueAt(i, 3).toString());
                
                EditController editController = new EditController(editBarang, barangModel);
            }
        });
        
        lihatBarang.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainMenu mainMenu = new MainMenu();
                BarangController barangController = new BarangController(barangModel, mainMenu);
                lihatBarang.dispose();
            }
        });
    }
}