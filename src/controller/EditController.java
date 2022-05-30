/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BarangModel;
import view.*;

/**
 *
 * @author Afrien
 */
public class EditController {
    EditBarang editBarang;
    BarangModel barangModel;

    public EditController(EditBarang editBarang, BarangModel barangModel) {
        this.editBarang = editBarang;
        this.barangModel = barangModel;
        
        editBarang.btnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = editBarang.getId();
                double harga = Double.parseDouble(editBarang.getHarga());
                double banyak = Double.parseDouble(editBarang.getBanyak());
                
                double hasil = barangModel.diskon(harga, banyak);
                
                DetailBarang detailBarang = new DetailBarang();
                DetailController detailController = new DetailController(detailBarang, barangModel, id, hasil);
                
                editBarang.dispose();
            }
        });
        
        editBarang.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LihatBarang lihatBarang = new LihatBarang();
                BarangModel barangModel = new BarangModel();
                LihatController lihatController = new LihatController(lihatBarang, barangModel );
                editBarang.dispose();
            }
        });
        
        editBarang.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               String id = editBarang.getId();
               barangModel.hapusBarang(id);
            }
        });
        
        editBarang.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = editBarang.getId();
                String nama = editBarang.getNama();
                String massa = editBarang.getMassa();
                String harga = editBarang.getHarga();
                barangModel.editDetail(nama, massa, harga, id);
            }
        });
    }
}