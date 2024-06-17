package Intento1;
import java.util.Scanner;
public class buscaminas {
	
	private static final int FILAS = 9;
	private static final int COLUMNAS = 9;
	private static final int MINAS = 10;
	private static final char MINA = '*';
	private static final char VACIO = '.';
	private static final char NO_DESCUBIERTO = '?';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tableroOculto[][]=new int [FILAS][COLUMNAS];
		char tableroVisible[][]=new char [FILAS][COLUMNAS];
		String posicion;
		inicializar(tableroOculto, tableroVisible);
		posicion=posicion();
	
	}
	private static void randomizarMinas(int tableroOculto[][], String posicion) {
		
		
	
	
	
	
	}
	private static void inicializar(int tableroi[][], char tableroc[][]) {
		for(int i=0;i<FILAS-1;i++) {
			for(int c=0;c<COLUMNAS-1;c++) {
				tableroi[i][c]=0;
				tableroc[i][c]=NO_DESCUBIERTO;
				}
			}	
		}
	private static String posicion() {
		Scanner sc = new Scanner(System.in);
	String posicion="";
	boolean datoValido=false;
	
	 while (datoValido==false) {
         System.out.print("Ingrese la posición de fila y columna: ");
         posicion = sc.nextLine();

         // verifica que la entrada tenga el formato correcto
         if (FormatoCorrecto(posicion)) {
           datoValido=true; // sale del bucle si la posición es valida
         } else {
             System.out.println("formato incorrecto. Ingrese dos numeros separados por un espacio.");
         }
     }

	return posicion;
}
	
	private static boolean FormatoCorrecto(String posicion) {
		boolean datoValido;
        // verifica que la entrada tenga el formato correcto 
        String[] partes = posicion.split(" "); //funcion encontrada en un foro
        if (partes.length != 2) {
            return datoValido=false;
        }

        try {
            int fila = Integer.parseInt(partes[0]);
            int columna = Integer.parseInt(partes[1]);//funcion buscada en internet.

            // verifica que fila y columna sean números positivos
            return fila > 0 && columna > 0;
        } catch (NumberFormatException e) {
            return datoValido=false; 
        }
    }
	
}
