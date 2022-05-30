/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import model.BarangModel;
import view.*;

/**
 *
 * @author Afrien
 */
public class InputController {
    InputBarang inputBarang;
    BarangModel barangModel;

    public InputController(InputBarang inputBarang, BarangModel barangModel) {
        this.inputBarang = inputBarang;
        this.barangModel = barangModel;
        
        inputBarang.btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String nama = inputBarang.getNama();
                String massa = inputBarang.getMassa();
                String harga = inputBarang.getHarga();
                barangModel.tambahBarang(nama, massa, harga);
            }
        });
        
        inputBarang.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                inputBarang.setNama();
                inputBarang.setMassa();
                inputBarang.setHarga();
            }
        });

        inputBarang.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainMenu mainMenu = new MainMenu();
                BarangModel barangModel = new BarangModel();
                BarangController barangController = new BarangController(barangModel, mainMenu);
                inputBarang.dispose();
            }
        });
    }
}