import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class adivinaNumero {
    public static void main(String[] args) {
        int numeroMagico = ThreadLocalRandom.current().nextInt(1,100);
        Scanner sc = new Scanner(System.in);
        int numeroDelUsuario;
        do {
            System.out.println("Intenta adivinar el número que he pensado. Ingresa tu propuesta: ");
            numeroDelUsuario = sc.nextInt();
            if (numeroMagico > numeroDelUsuario) {
                System.out.println("El número que he pensado es mayor que el introducido");
            } else if (numeroMagico < numeroDelUsuario) {
                System.out.println("El número que he pensado es menor que el introducido");
            }
        } while (numeroMagico != numeroDelUsuario);
        // Si termina el ciclo while es porque los números son iguales. Felicitamos al usuario
        System.out.println("Has acertado, el número que pensé fue: " + numeroMagico);
    }
}     
