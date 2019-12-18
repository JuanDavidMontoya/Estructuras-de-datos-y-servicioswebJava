/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploservidor;

import java.io.*;
import java.net.*;

/**
 *
 * @author juanmontoya
 */
public class Servidor {
    
    public Servidor (){
        try {
            ServerSocket server = new ServerSocket();
            
            while (true) {
                
                Socket conexion = server.accept();
                
                
                ObjectOutputStream  salida = new ObjectOutputStream(conexion.getOutputStream());
                ObjectInputStream entrada = new ObjectInputStream(conexion.getInputStream());
                 
                salida.writeObject("SERVIDOR>>> Conectado");
                salida.flush();
                
                String mensaje= "";
                do {                    
                    mensaje = (String) entrada.readObject();
                    System.out.println("\\n" + mensaje);
                } while (!mensaje.equals("exit"));
                
                entrada.close();
                salida.close();
                conexion.close();
                
                
            }
            
            
            
        } catch (Exception e) {
            
            System.out.println("Error:" + e.getMessage());
        }
        
    }
    
}
