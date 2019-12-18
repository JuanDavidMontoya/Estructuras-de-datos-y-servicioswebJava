/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuacionesd;

import static java.lang.Math.log;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class EcuacionesD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        double Temperaturainicial=  Double.parseDouble(JOptionPane.showInputDialog("Ingrese Temperatura inicial")) ;
        double TemperaturaFinal=  Double.parseDouble(JOptionPane.showInputDialog("Ingrese Temperatura FInal / Normalmente 28 C")) ;
        double TemperaturaAEvaluar=  Double.parseDouble(JOptionPane.showInputDialog("Ingrese Temperatura A Evaluar")) ;
        double TemperaturaAmbiente=  Double.parseDouble(JOptionPane.showInputDialog("Ingrese Temperatura Ambiente")) ;

        
        double c = Temperaturainicial- TemperaturaAmbiente;
        double calc1 = (TemperaturaFinal-TemperaturaAmbiente)/2;
        double k = log(calc1)/4;
        
        double tiempo;
        
        double calc2 = (TemperaturaAEvaluar - TemperaturaAmbiente)/2;
        
        tiempo = log (calc2) / k;
        
        JOptionPane.showInternalMessageDialog(null, "Su tiempo es: " +tiempo);
        System.out.println(tiempo);
        
    }
    
}
