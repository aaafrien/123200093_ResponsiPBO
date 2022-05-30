/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123200093;

import controller.BarangController;
import model.BarangModel;
import view.*;

/**
 *
 * @author Afrien
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainMenu mainMenu = new MainMenu();
//        InputBarang inputBarang = new InputBarang();
//        EditBarang editBarang = new EditBarang();
//        DetailBarang detailBarang = new DetailBarang();
        BarangModel barangModel = new BarangModel();
        BarangController barangController = new BarangController();
    }
    
}
