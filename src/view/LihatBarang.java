/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Afrien
 */
public class LihatBarang extends JFrame {
    public JButton btnKembali = new JButton("Kembali");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"ID", "Nama Barang", "Massa", "Harga"};
    
    public LihatBarang() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Lihat Barang");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 640, 300);
        
        add(btnKembali);
        btnKembali.setBounds(300, 330, 80, 20);
    }
}
