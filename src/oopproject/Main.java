/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

/**
 *
 * @author uyurucar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Screen sc = new Screen("sc1");
        sc.start();
        Operate op = new Operate(sc);
        op.Button();
    }
    
}
