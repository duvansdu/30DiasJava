package GestionBiblioteca;

import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String eleccion = "";
        while (!eleccion.equals("9")) {
            System.out.println(
                    "1. Registrar socio\n2. Registrar libro\n3. Registrar prestamo\n4. Ver socios\n5. Ver libros\n6. Ver prestamos\n7. Ver socios no fiables\n8. Cambiar localizacion de libro\n9. Salir\nElige:");
            eleccion = sc.nextLine();
            if (eleccion.equals("1")) {
                ControladorSocios.solicitarDatosParaRegistrar();
            }
            if (eleccion.equals("2")) {
                ControladorLibros.solicitarDatosParaRegistrar();
            }
            if (eleccion.equals("3")) {
                ControladorPrestamos.solicitarDatosYCrearPrestamo();
            }
            if (eleccion.equals("4")) {
                ControladorSocios.imprimirSocios(ControladorSocios.obtener());
            }
            if (eleccion.equals("5")) {
                ControladorLibros.imprimirLibros(ControladorLibros.obtener());
            }
            if (eleccion.equals("6")) {
                ControladorPrestamos.imprimirPrestamos(ControladorPrestamos.obtener());
            }
            if (eleccion.equals("7")) {
                ControladorSocios.imprimirSociosNoFiables(ControladorSocios.obtener());
            }
            if (eleccion.equals("8")) {
                ControladorLibros.solicitarDatosParaCambiarSignatura();
            }

        }
    }
}
