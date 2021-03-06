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
public class DetailController {
    DetailBarang detailBarang;
    BarangModel barangModel;

    public DetailController(DetailBarang detailBarang, BarangModel barangModel, String id, double hasil) {
        this.detailBarang = detailBarang;
        this.barangModel = barangModel;
        
        String[] data = new String[4];
        data = barangModel.getDetail(id);
        if(!data[0].isEmpty()){           
            detailBarang.lbNamanya.setText(data[1]);
            detailBarang.lbMassanya.setText(data[2]);
            detailBarang.lbHarganya.setText(data[3]);
            detailBarang.lbTotalnya.setText(String.format("%.2f", hasil));
        }
        
        detailBarang.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LihatBarang lihatBarang = new LihatBarang();
                BarangModel barangModel = new BarangModel();
                LihatController lihatController = new LihatController(lihatBarang, barangModel);
                detailBarang.dispose();
            }
        });
    }
}