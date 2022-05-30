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
public class MainMenu extends JFrame {
    JLabel lbMainmenu = new JLabel("Main Menu");
    
    public JButton btnTambah = new JButton("Tambah Barang");
    public JButton btnLihat = new JButton("Lihat Barang");
    
    public MainMenu() {
        setTitle("Main Menu");
        setSize(200,200);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        add(lbMainmenu);
        lbMainmenu.setBounds(60, 30, 80, 20);
        
        add(btnTambah);
        btnTambah.setBounds(20, 70, 150, 20);
        
        add(btnLihat);
        btnLihat.setBounds(20, 100, 150, 20);
    }
}
