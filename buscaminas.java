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
	
}
