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
    
    @Override
    public double diskon(double harga, double banyak){
        if(banyak>=12) {
            return 0.95*banyak*harga;
        } if(banyak>=20) {
            return 0.90*banyak*harga;
        } if(banyak>=144) {
            return 0.75*banyak*harga;
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
                JOptionPane.showMessageDialog(null, "Barang Gagal diinput");
            }
        }
    }
    
    public String[][] lihatBarang() {
        try{
            int jmlData = 0;
            String data[][] = new String[getDataBarang()][4];
            
            String query = "SELECT * FROM `barang`";
            
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            while(resultSet.next()) {
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("massa");                
                data[jmlData][3] = resultSet.getString("harga");
                jmlData++;
            }
            stat.close();
            return data;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void editBarang(String harga, String banyak) {
        try{
            double nHarga, nByk, total;
            nHarga = Double.parseDouble(harga);
            nByk = Double.parseDouble(banyak);
            
            total = diskon(nHarga, nByk);
            
            JOptionPane.showMessageDialog(null, "Barang Berhasil diedit");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Barang Gagal diedit");
        }
    }
    
    public String[] getDetail(String id) {
        try {
            String data[] = new String[4];
            
            String query = "SELECT * FROM `barang` WHERE `id`=" + id;
            
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            while(resultSet.next()) {
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("nama");
                data[2] = resultSet.getString("massa");                
                data[3] = resultSet.getString("harga");

            }
            stat.close();
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void hapusBarang(String id) {
        try {
            String query = "DELETE FROM `barang` WHERE `id`=" + id;
        
            stat = conn.createStatement();
            stat.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Barang Berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Barang Gagal dihapus");
        }
    }
    
    public void editDetail(String nama, String massa, String harga, String id) {
        try {
            String query = "UPDATE `barang` SET "
                    + "`nama`='" + nama + "',"
                    + "`massa`=" + massa + ","
                    + "`harga`=" + harga 
                    + " WHERE id=" + id;
            
            stat = conn.createStatement();
            stat.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Barang Berhasil diupdate");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Barang Gagal diupdate");
        }
    }
}