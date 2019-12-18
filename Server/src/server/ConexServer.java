package server;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

class ConexServer {
  
    static final int PUERTO = 5555;
    LinkedList<Integer> lista = new LinkedList<>();
    //ArbolBinarioOrdenado obo = new ArbolBinarioOrdenado();
    CBSPGOBO obo= new CBSPGOBO();
    public void multiCuenta() {

        Socket servicio = null;

        try {

            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Esperando peticiones por el puerto " + PUERTO);

            
            
            while (true) {
                System.out.println("aca apenas esta entrando al socket");
                //C.conexionsupremamentevergula();
                servicio = servidor.accept();
                System.out.println("aca ya entro entrando al socket");
                DataInputStream flujoDatosEntrada = new DataInputStream(servicio.getInputStream());  // Recibe mensajes del usuario
                System.out.println("y aca esta escribiendo?");
                OutputStream escribir = servicio.getOutputStream(); //Objeto para mandar a escribir en el cliente
                DataOutputStream flujoDatosSalida = new DataOutputStream(escribir);  //Aqui se escriben 
                Servidor cc = new Servidor(servicio, flujoDatosEntrada, flujoDatosSalida, obo);
                cc.start();
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
