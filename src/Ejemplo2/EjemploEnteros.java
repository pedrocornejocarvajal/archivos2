package Ejemplo2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjemploEnteros {
    //Crear, con un editor, un archivo de texto de números enteros
    //con la siguiente información (dos registros con secuencias de números
    //enteros separados por espacios y tabuladores):
    //3 45 6 77 89
    //123 45 67 777
    //Abrirlo con un flujo de texto para lectura y leerlo línea a línea y datos a
    //dato. Devolver la suma de todos los números y la cantidad de números
    //leídos.


    static final String FILE_NAME="Ejemplo2.txt";
    public static void proceso() {

        BufferedReader input = null;
        Scanner scanner;
        String dato;
        int sumatorio = 0;
        int contador = 0;


        try{ //se abre el fichero
            input=new BufferedReader(new FileReader(FILE_NAME));
            dato=input.readLine();
            while (dato!=null){
                scanner=new Scanner(dato);
                while (scanner.hasNextInt()){
                    sumatorio+=scanner.nextInt();
                    contador++;
                }
                dato=input.readLine();
            }

        }

        //Es practicamente igual pero con un contador

        //Cuidado si se usa este escaner a posteriori con string(hay que vaciar el escaner)

        //"cactcheamos" todos los errores posibles a la hora de leer el archivo

     catch (FileNotFoundException fileNotFoundException) {
        System.out.println("no se encuentra el fichero " + FILE_NAME);
    } catch (IOException ioEx) {
        System.out.println("error de lectura en el fichero " + FILE_NAME);
    } catch (NumberFormatException numberFormatException) {
        System.out.println("los datos del fichero no son números reales");
    } catch (Exception Ex) {
        System.out.println("error 404");
        } finally {
            try {
                if (input != null) {//el fichero de entrada no está cerrado
                    input.close();
                    System.out.println("la suma es " + sumatorio);
                    System.out.println("la cantidad de números leídos es " + contador);
                }
            } catch (IOException exception) { //ponemos a prueba de balas el cierre
                System.out.println("error en el cierre del fichero");
            }
        }

    }
}
