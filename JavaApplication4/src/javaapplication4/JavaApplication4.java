/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    double div= 0.0;
    double divid=0.0;
    
    
    
    div = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Div"));
    divid = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Dividendo"));
    double resul = div/divid; 
    
    JOptionPane.showMessageDialog(null, "Gabriela tu numero es xD: " +resul );
    
  
        
    }
    
}
