/*Primero, se define un paquete llamado GestionBiblioteca.
 Los paquetes son utilizados para organizar y agrupar clases relacionadas.*/
package GestionBiblioteca;

/*A continuación, se importan las clases y paquetes necesarios para el código, que incluyen: 
java.io.BufferedReader, java.io.BufferedWriter,java.io.FileReader, java.io.FileWriter,
 java.io.IOException, java.util.ArrayList y java.util.Scanner. 
 Estas clases son utilizadas para manejar la entrada/salida de archivos, la lectura de datos,
  el manejo de excepciones y la interacción con el usuario a través de la consola.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/*Se define la clase ControladorLibros, que contiene todos los métodos y lógica para interactuar 
con los libros de una biblioteca. Dentro de la clase ControladorLibros, se declaran algunas constantes 
estáticas como NOMBRE_ARCHIVO,SEPARADOR_CAMPO y SEPARADOR_REGISTRO. Estas constantes se utilizan
para definir el nombre del archivo en el que se guardarán los datos de los libros, 
así como los separadores utilizados para delimitar los campos y registros en el archivo. */
class ControladorLibros {

    private static final String NOMBRE_ARCHIVO = "libros.txt";
    private static final String SEPARADOR_CAMPO = ";";
    private static final String SEPARADOR_REGISTRO = "\n";

    /*El método solicitarDatosParaRegistrar solicita al usuario que ingrese los datos
     de un libro (código, título, autor, disponibilidad, localización y signatura)
 a través de la consola. Luego, crea un nuevo objeto Libro con los datos ingresados y lo registra llamando 
 al método registrar. */

    public static void solicitarDatosParaRegistrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del libro:");
        String codigo = sc.nextLine();
        System.out.println("Ingrese el titulo del libro:");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = sc.nextLine();
        System.out.println("El libro esta disponible? [true/false]");
        boolean disponible = Boolean.valueOf(sc.nextLine());
        System.out.println("Ingrese la localizacion del libro:");
        String localizacion = sc.nextLine();
        System.out.println("Ingrese la signatura del libro:");
        String signatura = sc.nextLine();
        ControladorLibros.registrar(new Libro(codigo, titulo, autor, localizacion, signatura, disponible));
        System.out.println("Libro registrado correctamente");
    }

    public static void registrar(Libro libro) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true));
            bufferedWriter.write(libro.getCodigo()
                    + SEPARADOR_CAMPO + libro.getTitulo()
                    + SEPARADOR_CAMPO + libro.getAutor()
                    + SEPARADOR_CAMPO + String.valueOf(libro.isDisponible())
                    + SEPARADOR_CAMPO + libro.getLocalizacion()
                    + SEPARADOR_CAMPO + libro.getSignatura() + SEPARADOR_REGISTRO);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }

    public static void guardarLibros(ArrayList<Libro> libros) {
        try {
            //se crea un objeto BufferedWriter para escribir en el archivo. 

            /*Se utiliza un FileWriter para especificar el archivo en el que se escribirá 
            (utilizando la constante NOMBRE_ARCHIVO).
            El segundo parámetro del FileWriter (true) indica que se agregará 
            el contenido al final del archivo existente, en lugar de sobrescribirlo.*/ 
        
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, false));
            for (int x = 0; x < libros.size(); x++) {
                Libro libro = libros.get(x);
                bufferedWriter.write(libro.getCodigo()
                        + SEPARADOR_CAMPO + libro.getTitulo()
                        + SEPARADOR_CAMPO + libro.getAutor()
                        + SEPARADOR_CAMPO + String.valueOf(libro.isDisponible())
                        + SEPARADOR_CAMPO + libro.getLocalizacion()
                        + SEPARADOR_CAMPO + libro.getSignatura() + SEPARADOR_REGISTRO);

            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }

    public static ArrayList<Libro> obtener() {
        ArrayList<Libro> libros = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(NOMBRE_ARCHIVO);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] libroComoArreglo = linea.split(SEPARADOR_CAMPO);
                libros.add(new Libro(libroComoArreglo[0], libroComoArreglo[1], libroComoArreglo[2], libroComoArreglo[4],
                        libroComoArreglo[5], Boolean.valueOf(libroComoArreglo[3])));
            }
        } catch (IOException e) {
            System.out.println("Excepción leyendo archivo: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Excepción cerrando: " + e.getMessage());
            }
            return libros;
        }
    }

    public static int buscarPorCodigo(String codigo, ArrayList<Libro> libros) {
        for (int x = 0; x < libros.size(); x++) {
            Libro libroActual = libros.get(x);
            if (libroActual.getCodigo().equals(codigo)) {
                return x;
            }
        }
        return -1;
    }

    public static void marcarComoPrestado(String codigoLibro) {
        ArrayList<Libro> libros = ControladorLibros.obtener();
        int indice = ControladorLibros.buscarPorCodigo(codigoLibro, libros);
        if (indice == -1) {
            return;
        }
        libros.get(indice).setDisponible(false);
        ControladorLibros.guardarLibros(libros);
    }

    public static void cambiarSignatura(String codigoLibro, String nuevaSignatura, String nuevaLocalizacion) {
        ArrayList<Libro> libros = ControladorLibros.obtener();
        int indice = ControladorLibros.buscarPorCodigo(codigoLibro, libros);
        if (indice == -1) {
            return;
        }
        libros.get(indice).setSignatura(nuevaSignatura);
        libros.get(indice).setLocalizacion(nuevaLocalizacion);
        ControladorLibros.guardarLibros(libros);
    }

    public static void solicitarDatosParaCambiarSignatura() {
        Scanner sc = new Scanner(System.in);
        Libro libro = ControladorLibros.imprimirLibrosYPedirSeleccion();
        if (!libro.isDisponible()) {
            System.out.println("No puede cambiar un libro que no esta disponible");
            return;
        }
        System.out.println("Ingrese nueva localizacion: ");
        String nuevaLocalizacion = sc.nextLine();
        System.out.println("Ingrese nueva signatura:");
        String nuevaSignatura = sc.nextLine();
        ControladorLibros.cambiarSignatura(libro.getCodigo(), nuevaSignatura, nuevaLocalizacion);
        System.out.println("Localizacion cambiada correctamente");
    }

    public static void imprimirLibros(ArrayList<Libro> libros) {
        System.out.println(
                "+-----+----------+----------------------------------------+--------------------+----------+------------------------------+------------------------------+");
        System.out.printf("|%-5s|%-10s|%-40s|%-20s|%-10s|%-30s|%-30s|\n", "No", "Codigo", "Titulo", "Autor",
                "Disponible",
                "Localizacion", "Signatura");
        System.out.println(
                "+-----+----------+----------------------------------------+--------------------+----------+------------------------------+------------------------------+");

        for (int x = 0; x < libros.size(); x++) {
            Libro libro = libros.get(x);
            System.out.printf("|%-5d|%-10s|%-40s|%-20s|%-10s|%-30s|%-30s|\n", x + 1, libro.getCodigo(),
                    libro.getTitulo(),
                    libro.getAutor(), libro.isDisponible() ? "Si" : "No", libro.getLocalizacion(),
                    libro.getSignatura());
            System.out.println(
                    "+-----+----------+----------------------------------------+--------------------+----------+------------------------------+------------------------------+");
        }
    }

    public static Libro imprimirLibrosYPedirSeleccion() {
        ArrayList<Libro> libros = ControladorLibros.obtener();
        Scanner sc = new Scanner(System.in);
        while (true) {
            ControladorLibros.imprimirLibros(libros);
            System.out.println("Ingrese el codigo del libro: ");
            String codigo = sc.nextLine();
            int indice = ControladorLibros.buscarPorCodigo(codigo, libros);
            if (indice == -1) {
                System.out.println("No existe libro con ese codigo");
            } else {
                Libro libro = libros.get(indice);
                if (libro.isDisponible()) {
                    return libro;
                } else {
                    System.out.println("El libro esta ocupado");
                }
            }
        }
    }
}
