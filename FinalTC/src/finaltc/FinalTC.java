/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltc;

/**
 *
 * @author Juan
 */
public class FinalTC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] valores = {0, 0, 1, 2, 1, 3, 4, 6, -20, -1};
        int numeromayor = 0;
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] > numeromayor) {
                numeromayor = valores[i];
            }
        }
        int[] sumTriangulo = new int[numeromayor + 1];
        for (int i = 0; i <= numeromayor; i++) {
            sumTriangulo[i] = (int) Math.pow(2, i);
        }
        int resultado = 0;
        for (int i = 0; i < valores.length; i = i + 2) {
            int aux1 = valores[i];
            int aux2 = valores[i + 1];
            for (int j = aux1; j < aux2 + 1; j++) {
                if (aux1 < 0 || aux2 < 0) {
                    break;
                } else {
                    resultado += sumTriangulo[j];
                }
            }
            if (aux1 < 0 || aux2 < 0) {
                System.out.println("["+aux1 + "," + aux2 +"]"+ "-> ");
            } else {
                System.out.println("["+aux1 + "," + aux2 +"]"+ "-> " + resultado);
            }

            resultado = 0;
        }
    }
}
