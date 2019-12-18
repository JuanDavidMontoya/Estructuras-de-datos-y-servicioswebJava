package server;
import java.io.*;
import java.net.*;
public class Servidor extends Thread {

    Socket servicio = null;
    DataInputStream flujoDatosEntrada = null;
    DataOutputStream flujoDatosSalida = null;
    CBSPGOBO obo;

    public Servidor(Socket servicio, DataInputStream x, DataOutputStream y, CBSPGOBO obo) {  //Constructor

        this.servicio = servicio;
        flujoDatosEntrada = x;
        flujoDatosSalida = y;
        this.obo=obo;
    }

    //Valida las entradas si son numeros o texto
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    //Termina metodo de validacion numerica
    @Override
    public void run() {  //Esto es un metodo, que es lo que correra cada hilo de nustro servidor
        System.out.println("Se acepto una nueva conexion");
        try {
            String mensaje = flujoDatosEntrada.readUTF();  //Recibimos un mensaje
            int numero;

            if (isNumeric(mensaje) == true) {
                numero = Integer.parseInt(mensaje);
                System.out.println("insertando jiji");
                obo.insertarEnElOBO(numero);
                //abo.insertar(numero);
            } else {
                System.out.println("No es un numero");
                if(mensaje.equals("i")){
                    System.out.println("pero si te wa imprimir cosas");
                    obo.imprimirElOBO();
                }
            }
        } catch (Exception e) {
            
        }
    }
}