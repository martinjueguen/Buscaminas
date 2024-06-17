package Intento1;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class buscaminas {
	
	private static final int FILAS = 9;
	private static final int COLUMNAS = 9;
	private static final int MINAS = 10;
	private static final char MINA = '*';
	private static final char VACIO = '.';
	private static final char NO_DESCUBIERTO = '?';
	private static final int MINAOCULTA = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tableroOculto[][]=new int [FILAS][COLUMNAS];
		char tableroVisible[][]=new char [FILAS][COLUMNAS];
		String posicion;
		inicializar(tableroOculto, tableroVisible);
		posicion=posicion();
		inicializar(tableroOculto, tableroVisible);
		colocarMinasTablero(tableroOculto, posicion);
		imprimirTableroOculto(tableroOculto);
	
	}
	private static int numeroDePosicion(String posicion) {
		char charF, charC;
		charF=posicion.charAt(0);
		charC=posicion.charAt(2);
		int numF= Character.getNumericValue(charF);
		int numC = Character.getNumericValue(charC);
		int contador=0;
		int posicionEnNumero=0;
		for (int i=0;i<FILAS;i++){
			for (int j=0;j<COLUMNAS;j++){
				contador++;
				if (numF==i&&numC==j) {
					posicionEnNumero=contador;
				}
			}
		}
		return posicionEnNumero;
	}
	private static void randomizarNumeroMinas(int posicionMinas[], int posicionEnNumero) {
		boolean igual;
		for (int i=0; i<MINAS;i++) {
			igual=true;
			while(igual==true) {
				igual=false;
				posicionMinas[i] = ThreadLocalRandom.current().nextInt(1, 81);
				for (int j=0; j<i;j++) {
					if (posicionMinas[i]==posicionMinas[j]) {
						igual=true;
					}
					if (posicionMinas[i]==posicionEnNumero) {
						igual=true;
					}
				}
			}
			
		}
	}
	private static void imprimirTableroOculto(int tableroOculto[][]) {
		System.out.print("  ");
		for (int i=0;i<FILAS;i++) {
			System.out.print(+i+" ");
		}
		System.out.println();
		for (int i=0; i<FILAS; i++) {
			System.out.print(i+ " ");
			for (int j=0; j<COLUMNAS; j++) {
				System.out.print( tableroOculto[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void anotarMinas(int tableroOculto[][], int posicionMinas[]) {
		int contador=0;
		for (int i=0; i<FILAS; i++) {
			for (int j=0; j<COLUMNAS; j++) {
				contador++;
				for (int z=0;z<MINAS;z++) {
					if (contador==posicionMinas[z]) {
						
						tableroOculto[i][j]=MINAOCULTA;
					}
				}
				
			}
		}
	}
	private static void colocarNumeros(int tableroOculto[][]){
		for (int i=0;i<FILAS;i++){
			for (int j=0;j<COLUMNAS;j++){
				if (tableroOculto[i][j]==MINAOCULTA) {
					try {
						if (tableroOculto[i-1][j-1]!=MINAOCULTA) {
							tableroOculto[i-1][j-1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i-1][j]!=MINAOCULTA) {
							tableroOculto[i-1][j]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i-1][j+1]!=MINAOCULTA) {
							tableroOculto[i-1][j+1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i][j-1]!=MINAOCULTA) {
							tableroOculto[i][j-1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i][j+1]!=MINAOCULTA) {
							tableroOculto[i][j+1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i+1][j-1]!=MINAOCULTA) {
							tableroOculto[i+1][j-1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i+1][j]!=MINAOCULTA) {
							tableroOculto[i+1][j]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i+1][j+1]!=MINAOCULTA) {
							tableroOculto[i+1][j+1]++;
						}
					}catch(Exception e) {}
					
				}
			}
		}
	}
	private static void colocarMinasTablero(int tableroOculto[][], String posicion) {
		
		int posicionEnNumero=numeroDePosicion(posicion);
		int posicionMinas [] = new int [MINAS];
		randomizarNumeroMinas(posicionMinas, posicionEnNumero);
		anotarMinas(tableroOculto, posicionMinas);
		colocarNumeros(tableroOculto);
		
		
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
