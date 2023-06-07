package dia7Ahorcado;
import java.util.Scanner;

public class ahorcado {
    public static void main(String[] args) {
        String secreto = "hola";
        String  letras;
        char letra;
        boolean[] aciertos;
        int num_fallos;

        aciertos = new boolean[20];
        letras = "";
        num_fallos = 0;

        LeerSecreto(secreto, aciertos);

        do {
            BorrarPantalla();
            EscribirSecreto(secreto, aciertos);
            MostrarAhorcado(num_fallos);
            System.out.println("Letras introducidas: " + letras);

            letra = LeerLetra(letras);

            if (!ComprobarSecreto(letra, secreto, aciertos)) {
                num_fallos++;
            }
        } while (NumeroAciertos(aciertos) != secreto.length() && num_fallos != 8);

        if (num_fallos == 8) {
            BorrarPantalla();
            EscribirSecreto(secreto, aciertos);
            MostrarAhorcado(num_fallos);
            System.out.println("Has perdido!!!");
        } else {
            System.out.println("Has ganado!!!");
        }
    }
    public static void LeerSecreto(String secreto, boolean[] aciertos) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Introduce la palabra a adivinar:");
            secreto = scanner.nextLine();

            if (secreto.length() > 20) {
                System.out.println("No puede tener más de 20 caracteres");
            }
        } while (secreto.length() > 20);

        for (int i = 0; i < 20; i++) {
            aciertos[i] = false;
        }

        BorrarPantalla();
    }

    

    public static void EscribirSecreto(String secreto, boolean[] aciertos) {
        for (int i = 0; i < secreto.length(); i++) {
            if (aciertos[i]) {
                System.out.print(secreto.charAt(i));
            } else {
                System.out.print("*");
            }
        }
        System.out.println();
    }

    public static boolean ComprobarSecreto(char letra, String secreto, boolean[] aciertos) {
        boolean acierto = false;
        for (int i = 0; i < secreto.length(); i++) {
            if (secreto.charAt(i) == letra) {
                aciertos[i] = true;
                acierto = true;
            }
        }
        return acierto;
    }

    public static char LeerLetra(String letras) {
        Scanner scanner = new Scanner(System.in);
        String input;
        char letra;

        do {
            System.out.print("Introduce una letra:");
            input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Una sola letra!!!");
            }
        } while (input.length() != 1);

        letra = input.charAt(0);
        letras += letra + " ";

        return letra;
    }

    public static void MostrarAhorcado(int fallos) {
        System.out.println();
        System.out.println("La horca!!!");
        System.out.println();

        switch (fallos) {
            case 0:
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 1:
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("_________");
                break;
            case 2:
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("_________");
                break;
            case 3:
                System.out.println("------");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("_________");
                break;
            case 4:
                System.out.println("------");
                System.out.println("|   |");
                System.out.println("|   o");
                System.out.println("|  ");
                System.out.println("|  ");
                System.out.println("_________");
                break;
            case 5:
                System.out.println("------");
                System.out.println("|   |");
                System.out.println("|   o");
                System.out.println("|  /|");
                System.out.println("|");
                System.out.println("_________");
                break;
            case 6:
                System.out.println("------");
                System.out.println("|   |");
                System.out.println("|   o");
                System.out.println("|  /|\\");
                System.out.println("|");
                System.out.println("_________");
                break;
            case 7:
                System.out.println("------");
                System.out.println("|   |");
                System.out.println("|   o");
                System.out.println("|  /|\\");
                System.out.println("|  /");
                System.out.println("_________");
                break;
            case 8:
                System.out.println("------");
                System.out.println("|   |");
                System.out.println("|   o");
                System.out.println("|  /|\\");
                System.out.println("|  / \\");
                System.out.println("_________");
                break;
        }

        System.out.println();
    }

    public static int NumeroAciertos(boolean[] aciertos) {
        int num = 0;
        for (int i = 0; i < 20; i++) {
            if (aciertos[i]) {
                num++;
            }
        }
        return num;
    }

    public static void BorrarPantalla() {
        // Implementa la lógica para borrar la pantalla (depende del sistema operativo)
    }
}
