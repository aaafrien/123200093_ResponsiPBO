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
    JLabel lbMassa = new JLabel("Massa {gr} :");
    JLabel lbHarga = new JLabel("Harga Satuan :");
    JLabel lbTotal = new JLabel("Total Harga");
    
    public JTextField tfNama = new JTextField();
    public JTextField tfMassa = new JTextField();
    public JTextField tfHarga = new JTextField();
    public JTextField tfTotal = new JTextField();
    
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
        lbHarga.setBounds(30, 80, 90, 20);
        add(lbTotal);
        lbTotal.setBounds(30, 100, 90, 20);
        
        add(tfNama);
        tfNama.setBounds(150, 30, 120, 20);
        add(tfMassa);
        tfMassa.setBounds(150, 60, 120, 20);
        add(tfHarga);
        tfHarga.setBounds(150, 80, 120, 20);
        add(tfTotal);
        tfHarga.setBounds(150, 100, 120, 20);

        add(btnKembali);;
        btnKembali.setBounds(30, 150, 90, 20);
    }
}
