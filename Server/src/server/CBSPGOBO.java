package server;

public class CBSPGOBO {
    private ArbolBinarioOrdenado obo = new ArbolBinarioOrdenado();
    public void insertarEnElOBO(int OBOIDE){
        obo.insertar(OBOIDE);
    }
    public void imprimirElOBO(){
        System.out.println("Impresion preorden: ");
        obo.imprimirPre();
        System.out.println("Impresion entreorden: ");
        obo.imprimirEntre();
        System.out.println("Impresion postorden: ");
        obo.imprimirPost();
    }
}
