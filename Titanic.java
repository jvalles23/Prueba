package ExamenParcial_JavierValles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Titanic {
	/**
	 * Pre:--- 
	 * Post:Creamos el metodo leer, que nos leera el fichero que le pasamos
	 * y nos mostrara el numero total de lineas que tiene nuestro fichero.
	 * Ademas nos mostrara el numero total de mujeres, de hombres, el numero total
	 * de hombres muertos y mujeres muertas con su porcentaje.
	 */
	private static void leer(String nombre, String m, String d, String a, String b) {
		// Creamos la clase fichero
		File file = new File(nombre);
		/**
		 * Pre:---
		 * Post:Creamos el contador donde nos almacenara el numero de lineas que
		 * tiene nuestro fichero y lo valorizamos a -1 porque no queremos que la primera
		 * linea sea leida. Creamos las demas variables para almacenar los datos.
		 */
		int contador = -1;
		double contador2 = 0;
		double contador3 = 0;
		double contadorM = 0;
		double contadorM2 = 0;
		double porcentaje = 0;
		double porcentaje2 = 0;
		try {
			Scanner f = new Scanner(file);
			while (f.hasNextLine()) {
				// Creamos la variable linea
				String linea = f.nextLine();
				contador++;
				String[] lineaSeparada = linea.split(",");
				// En este if le indicamos la posicion en la que esta el sexo para que compruebe
				// cuantas mujeres hay
				if (lineaSeparada[5].toLowerCase().equals(m)) {
					contador2++;
					//En este if nos esta comparando los datos de la 1 primera posicion para sacar las mujeres muertas.
					if (lineaSeparada[1].toLowerCase().equals(d)) {
						contadorM++;
						//Aqui hacemos el porcentaje del total de mujeres muertas en el barco.
						porcentaje = Math.floor((contadorM * 100) / contador2);
					}
				}
				// En este if le indicamos la posicion en la que esta el sexo para que compruebe
				// cuantas mujeres hay
				if (lineaSeparada[5].toLowerCase().equals(a)) {
					contador3++;
					//En este if nos esta comparando los datos de la 1 primera posicion para sacar los hombres muertos.
					if (lineaSeparada[1].toLowerCase().equals(b)) {
						contadorM2++;
						//Aqui hacemos el porcentaje del total de hombres muertos en el barco.
						porcentaje2 = Math.floor((contadorM2 * 100) / contador3);
					}
				}
			}
			System.out.println("Número total de pasajeros = " + contador);
			System.out.println("El numero total de mujeres en el barco es: " + contador2);
			System.out.println("El numero total de mujeres muertas en el barco es: " + contadorM
					+ " y su porcentaje es: " + porcentaje + "%");
			System.out.println("El numero total de hombres en el barco es: " + contador3);
			System.out.println("El numero total de hombres muertos  en el barco es: " + contadorM2
					+ " y su porcentaje es: " + porcentaje2 + "%");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Le pasamos la ruta del fichero para que lo lea.
		String nombreFichero = "C:\\Users\\Javier\\Desktop\\titanic.csv";
		String sexoF = "female";
		String muertas = "0";
		String sexoM = "male";
		String muertos = "0";
		leer(nombreFichero, sexoF, muertas, sexoM, muertos);
	}
}
