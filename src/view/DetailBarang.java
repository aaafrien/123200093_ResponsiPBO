/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

/**
 *
 * @author Afrien
 */
public class DetailBarang extends JFrame {
    JLabel lbNama = new JLabel("Nama :");
    JLabel lbMassa = new JLabel("Massa (gr) :");
    JLabel lbHarga = new JLabel("Harga Satuan :");
    JLabel lbTotal = new JLabel("Total Harga :");
    
    public JLabel lbNamanya = new JLabel();
    public JLabel lbMassanya = new JLabel();
    public JLabel lbHarganya = new JLabel();
    public JLabel lbTotalnya = new JLabel();
    
    public JButton btnKembali = new JButton("Kembali");
    
    public DetailBarang() {
        setTitle("Detail Barang");
        setSize(700,400);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        add(lbNama);
        lbNama.setBounds(30, 30, 90, 20);
        add(lbMassa);
        lbMassa.setBounds(30, 60, 90, 20);
        add(lbHarga);
        lbHarga.setBounds(30, 90, 90, 20);
        add(lbTotal);
        lbTotal.setBounds(30, 120, 90, 20);
        
        add(lbNamanya);
        lbNamanya.setBounds(150, 30, 120, 20);
        add(lbMassanya);
        lbMassanya.setBounds(150, 60, 120, 20);
        add(lbHarganya);
        lbHarganya.setBounds(150, 90, 120, 20);
        add(lbTotalnya);
        lbTotalnya.setBounds(150, 120, 120, 20);

        add(btnKembali);
        btnKembali.setBounds(30, 150, 90, 20);
    }
}