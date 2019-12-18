package client;
import java.io.*;
import java.net.*;
public class MainClient {
    public static void main(String[] args) {     
        String ip = "localhost";
        int PUERTO = 5555;
        try{ 
                Socket conexion = new Socket(ip, PUERTO);
                System.out.println("se ha conectado");
                DataOutputStream flujoDatosSalida = new DataOutputStream(conexion.getOutputStream());//Creamos objeto para enviar
                
                
                
                
                
                flujoDatosSalida.writeUTF("i");  //Mandamos el mensaje al servidor, en este caso que sean numeros y en caso de necesitar ver los recorridos enviar la letra i
        }catch(Exception e){
                System.out.println("No se puedo crear la conexion");
                e.printStackTrace();
        }  
    }
    /*public void conexionsupremamentevergula(){
        String ip = "localhost";
        int PUERTO = 5555;
        try{ 
            Socket conexion = new Socket(ip, PUERTO);
            System.out.println("se ha conectado");
            DataOutputStream flujoDatosSalida = new DataOutputStream(conexion.getOutputStream());//Creamos objeto para enviar
            flujoDatosSalida.writeUTF("3");  //Mandamos el mensaje al servidor
        }catch(Exception e){
                System.out.println("No se puedo crear la conexion");
                e.printStackTrace();
        }
    }*/
    
}
