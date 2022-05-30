/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Afrien
 */
public class BarangModel implements potongan {
    String DBurl = "jdbc:mysql://localhost/barang";
    String DBuname = "root";
    String DBpw = "";
    
    Connection conn;
    Statement stat;
    
    public BarangModel() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl, DBuname, DBpw);
            System.out.println("Connection success!");
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Connection failed!");
        }
    }
    
    public double diskon(double massa, double harga, double banyak){
        if(massa>=12) {
            harga = ((5/100)*(banyak*harga));
        } if(massa>=20) {
            harga = ((10/100)*(banyak*harga));
        } if(massa>=144) {
            harga = ((25/100)*(banyak*harga));
        }
        return(harga);
    }
    
    public int getDataBarang() {
        try{
           int jmlData = 0;
           String query = "SELECT * FROM `barang`";
           stat = conn.createStatement();
           ResultSet resultSet = stat.executeQuery(query);
           
           while(resultSet.next()) {
               jmlData++;
           }
           stat.close();
           return jmlData;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public void tambahBarang(String nama, String massa, String harga) {
        try{
            int jmlData = 0;
            
            String sama = "SELECT * from `barang` WHERE `nama`='" + nama + "'";
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sama);
            while(resultSet.next()) {
                jmlData++;
            }
            
            if(jmlData==0) {
                String query = "INSERT INTO `barang` (`nama`, `massa`, `harga`)" +
                               "VALUES ('" + nama + "', " + massa + "," + harga + ")";
                stat = conn.createStatement();
                stat.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Barang Berhasil diinput");
            } else {
                throw new Exception("duplicate");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("duplicate")) {
                JOptionPane.showMessageDialog(null, "Barang sudah ada");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal ditambahkan");
            }
        }
    }
    
    public String[][] lihatBarang() {
        try{
            int jmlData = 0;
            String data[][] = new String[getDataBarang()][3];
            
            String query = "SELECT * FROM `barang`";
            
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            while(resultSet.next()) {
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = resultSet.getString("massa");                
                data[jmlData][2] = resultSet.getString("harga");
                jmlData++;
            }
            stat.close();
            return data;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void editBarang(String nama, String massa, String harga, String banyak) {
        try{
            double nMassa, nHarga, nByk, total;
            nMassa = Double.parseDouble(massa);
            nHarga = Double.parseDouble(harga);
            nByk = Double.parseDouble(banyak);
            
            total = diskon(nMassa, nHarga, nByk);

            String query = "UPDATE `barang` " + "SET " + "`massa`=" + massa + ","
                           + "`harga`=" + harga + "'";

            stat = conn.createStatement();
            stat.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("exceed")) {
                JOptionPane.showMessageDialog(null, "Rating tidak boleh melebihi 5.0");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal diupdate");
            }
        }
    }
}
