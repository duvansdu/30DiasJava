import java.io.*;
import java.util.Scanner;

public class conversorUnidades {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int km;
        int cm;
        int y;
        int op;
        double res;

        System.out.println("Ingrese la operacion");
        System.out.println("1. Centimetros a pulgadas");
        System.out.println("2. Yardas a metros");
        System.out.println("3. Kilometros a millas");
        System.out.println("\n");
        op = leer.nextInt();

        switch (op) {
            case 1:
            System.out.println("Ingrese los centimetros a convertir a pulgadas");
            cm = leer.nextInt();
            res = cm * 2.3;
            System.out.println("El resultado de es " +res+ " a convertir a pulgadas");
            break;

            case 2:
            System.out.println("Yardas a Metros");
            y = leer.nextInt();
            res =  y * 0.914401829;
            System.out.println("El resultado " + res+ " metros");
            break;

            case 3:
            System.out.println("Ingrese los Km para convertir a Millas");
            km = leer.nextInt();
            res = km * 0.621;
            System.out.println("El resultado" + res + " para millas");
            break;
        
            default:
            System.out.println("Opcion Invalida Sonso es del 1 al 3");
                break;
        }
        leer.close();
    }
    
}
