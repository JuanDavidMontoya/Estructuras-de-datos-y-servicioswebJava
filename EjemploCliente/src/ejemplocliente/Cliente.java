/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author juanmontoya
 */
public class Cliente {
    
    public Cliente (){
        
        try {
            Socket cliente = new Socket("Localhost",1234);
            
            
                ObjectOutputStream  salida = new ObjectOutputStream(cliente.getOutputStream());
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                String mensaje= (String) entrada.readObject();
                System.out.println("\\n" + mensaje);
                
            
           
                do {                    
                    String m = JOptionPane.showInputDialog("Ingrese mensaje");
                    salida.writeObject(m);
                    salida.flush();
                    
                } while (JOptionPane.showConfirmDialog(null,"Enviar Otro mensaje")
                        ==JOptionPane.YES_OPTION);
                
                entrada.close();
                salida.close();
                cliente.close();
                
                
            
            
            
            
        } catch (Exception e) {
            
            System.out.println("Error:" + e.getMessage());
        }
        
    }
        
    }
    
    
    
    
