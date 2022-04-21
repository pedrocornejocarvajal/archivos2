package Ejemplo1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjemploReales {
    //Crear, con un editor, un archivo de texto de números reales,
    //uno por línea. Abrirlo con un flujo de texto para lectura y leerlo línea a
    //línea. Convertir las cadenas leídas en número de tipo double por medio
    //de Scanner, y mostrar al final la suma de todos ellos.


    static final String FILE_NAME = "Ejemplo1.txt";

    public static void proceso() {
        BufferedReader input = null;
        Scanner sc;
        String dato;
        double sumatorio = 0.0;

        try { //se abre el fichero
            input = new BufferedReader(new FileReader(FILE_NAME));
            dato = input.readLine();

            while (dato != null) {
                sc = new Scanner(dato);
                if (sc.hasNextDouble()) {
                    sumatorio += sc.nextDouble();
                }
                dato = input.readLine();
            }


            //Cuidado si se usa este escaner a posteriori con string(hay que vaciar el escaner)

            //"cactcheamos" todos los errores posibles a la hora de leer el archivo
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("no se encuentra el fichero " + FILE_NAME);
        } catch (IOException ioEx) {
            System.out.println("error de lectura en el fichero " + FILE_NAME);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("los datos del fichero no son números reales");
        } catch (Exception Ex) {
            System.out.println("error 404");
        } finally {
            try {
                if (input != null) {
                    input.close();
                    System.out.println("la suma total de los datos del fichero es: " + sumatorio);
                }
            } catch (IOException exception) { //ponemos "a prueba de balas" las excepciones en el cierre
                System.out.println("error en el cierre del fichero");
            }
        }
    }
}
