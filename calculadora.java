import java.util.Scanner;
class calculadora{
    public static void main(String[] args) {
        char operador;
        Double number1, number2, result;
        
        Scanner input = new Scanner(System.in);

        System.out.println("Seleccione un operador  + - * /");
        operador = input.next().charAt(0);// permite al usuario ingresar una cadena de texto y luego captura el primer carácter de esa cadena y lo asigna a la variable operador.

        System.out.println("Seleccione un numero");
        number1 = input.nextDouble();

        System.out.println("Seleccione otro numero");
        number2 = input.nextDouble();

        switch (operador) {
            case '+':
            result = number1 + number2;
            System.out.println(number1 + "+" + number2 + "=" +result);
            break;


            case '-':
            result = number1 - number2;
            System.out.println(number1 + "-" + number2 + "=" +result);
            break;

            case '*':
            result = number1 * number2;
            System.out.println(number1 + "*" + number2 + "=" +result);
            break;

            case '/':
            result = number1 / number2;
            System.out.println(number1 + "/" + number2 + "=" +result);
            break;

            default:
            System.out.println("Caracter Invalido por Favor digita Otro ");
            break;
        }
        input.close();

    }
}