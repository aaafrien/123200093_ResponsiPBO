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
public class InputBarang extends JFrame {
    JLabel lbInput = new JLabel("Input Barang");;
    JLabel lbNama = new JLabel("Nama");
    JLabel lbMassa = new JLabel("Massa {gr}");
    JLabel lbHarga = new JLabel("Harga Satuan");
    
    public JTextField tfNama = new JTextField();
    public JTextField tfMassa = new JTextField();
    public JTextField tfHarga = new JTextField();
    
    public JButton btnSubmit = new JButton("Submit");
    public JButton btnReset = new JButton("Reset");
    public JButton btnKembali = new JButton("Kembali");
    
    public InputBarang() {
        setTitle("Input Barang");
        setSize(700,400);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        add(lbInput);
        lbInput.setBounds(30, 30, 90, 20);
        add(lbNama);
        lbNama.setBounds(30, 60, 90, 20);
        add(lbMassa);
        lbMassa.setBounds(30, 80, 90, 20);
        add(lbHarga);
        lbHarga.setBounds(30, 100, 90, 20);
        
        add(tfNama);
        tfNama.setBounds(150, 60, 120, 20);
        add(tfMassa);
        tfMassa.setBounds(150, 80, 120, 20);
        add(tfHarga);
        tfHarga.setBounds(150, 100, 120, 20);
        
        add(btnSubmit);;
        btnSubmit.setBounds(30, 120, 160, 20);
        add(btnReset);;
        btnReset.setBounds(200, 120, 160, 20);
        add(btnKembali);;
        btnKembali.setBounds(30, 130, 340, 20);
    }
}
