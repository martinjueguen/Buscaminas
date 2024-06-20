package Intento1;
//Wagner Bruno
//Jueguen Martin Francisco
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class buscaminas {
	private static final int FILAS = 9;
	private static final int COLUMNAS = 9;
	private static final int MINAS = 10;
	private static final char MINA = '*';
	private static final char VACIO = '.';
	private static final char NO_DESCUBIERTO = '?';
	private static final int MINA_OCULTA = -1;
	private static final int VACIO_OCULTO = 0;
	private static final int NUMERO_CARACTER = 48;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tableroOculto[][]=new int [FILAS][COLUMNAS];
		char tableroVisible[][]=new char [FILAS][COLUMNAS];
		boolean juego= true;
		String posicion;
		inicializar(tableroOculto, tableroVisible);
		imprimirTableroVisible(tableroVisible);
		posicion=posicion();
		colocarMinasTablero(tableroOculto, posicion);
		descubrirTablero(tableroOculto, tableroVisible, posicion);
		imprimirTableroVisible(tableroVisible);
		while (juego==true) {
			posicion=posicion();
			if (eleccionPos(posicion,tableroOculto)==true) {
				mostarMinas(tableroOculto, tableroVisible);
				imprimirTableroVisible(tableroVisible);
				System.out.print("Usted perdio");
				juego=false;
			}else {
				descubrirTablero(tableroOculto, tableroVisible, posicion);
				imprimirTableroVisible(tableroVisible);
				juego=comprobarFinal(tableroVisible);
				if (juego==false) {
					System.out.println("Usted gano");
				}
			}
		}
		imprimirTableroOculto(tableroOculto);
	}
	private static void descubrirTablero (int [][]tableroOculto, char [][]tableroVisible, String posicion) {
		char charF, charC;
        charF=posicion.charAt(0);
        charC=posicion.charAt(2);
        int numF= Character.getNumericValue(charF);
        int numC = Character.getNumericValue(charC);
        tableroVisible[numF][numC]=(char) (tableroOculto[numF][numC]+NUMERO_CARACTER);
        if (tableroOculto[numF][numC]==VACIO_OCULTO) {
        	tableroVisible[numF][numC]=VACIO;
        	comprobarCero(tableroOculto, tableroVisible, numF, numC);
        }
	}
	private static void comprobarCero (int [][]tableroOculto, char [][]tableroVisible, int numF, int numC) {
		try {
			if (tableroVisible[numF-1][numC-1]==NO_DESCUBIERTO) {
				tableroVisible[numF-1][numC-1]=(char) (tableroOculto[numF-1][numC-1]+NUMERO_CARACTER);
				 if (tableroOculto[numF-1][numC-1]==VACIO_OCULTO) {
					 	tableroVisible[numF-1][numC-1]=VACIO;
			        	comprobarCero(tableroOculto, tableroVisible, numF-1, numC-1);
			        }
			}	
		}catch(Exception e) {}
		try {
			if (tableroVisible[numF-1][numC]==NO_DESCUBIERTO) {
				tableroVisible[numF-1][numC]=(char) (tableroOculto[numF-1][numC]+NUMERO_CARACTER);
				 if (tableroOculto[numF-1][numC]==VACIO_OCULTO) {
					 	tableroVisible[numF-1][numC]=VACIO;
			        	comprobarCero(tableroOculto, tableroVisible, numF-1, numC);
			        }
			}	
		}catch(Exception e) {}
		try {
			if (tableroVisible[numF-1][numC+1]==NO_DESCUBIERTO) {
				tableroVisible[numF-1][numC+1]=(char) (tableroOculto[numF-1][numC+1]+NUMERO_CARACTER);
				 if (tableroOculto[numF-1][numC+1]==VACIO_OCULTO) {
					 	tableroVisible[numF-1][numC+1]=VACIO;
			        	comprobarCero(tableroOculto, tableroVisible, numF-1, numC+1);
			        }
			}	
		}catch(Exception e) {}
		try {
			if (tableroVisible[numF][numC-1]==NO_DESCUBIERTO) {
				tableroVisible[numF][numC-1]=(char) (tableroOculto[numF][numC-1]+NUMERO_CARACTER);
				 if (tableroOculto[numF][numC-1]==VACIO_OCULTO) {
					 	tableroVisible[numF][numC-1]=VACIO;
			        	comprobarCero(tableroOculto, tableroVisible, numF, numC-1);
			        }
			}	
		}catch(Exception e) {}
		try {
			if (tableroVisible[numF][numC+1]==NO_DESCUBIERTO) {
				tableroVisible[numF][numC+1]=(char) (tableroOculto[numF][numC+1]+NUMERO_CARACTER);
				 if (tableroOculto[numF][numC+1]==VACIO_OCULTO) {
					 	tableroVisible[numF][numC+1]=VACIO;
			        	comprobarCero(tableroOculto, tableroVisible, numF, numC+1);
			        }
			}	
		}catch(Exception e) {}
		try {
			if (tableroVisible[numF+1][numC-1]==NO_DESCUBIERTO) {
				tableroVisible[numF+1][numC-1]=(char) (tableroOculto[numF+1][numC-1]+NUMERO_CARACTER);
				 if (tableroOculto[numF+1][numC-1]==VACIO_OCULTO) {
					 	tableroVisible[numF+1][numC-1]=VACIO;
			        	comprobarCero(tableroOculto, tableroVisible, numF+1, numC-1);
			        }
			}	
		}catch(Exception e) {}
		try {
			if (tableroVisible[numF+1][numC]==NO_DESCUBIERTO) {
				tableroVisible[numF+1][numC]=(char) (tableroOculto[numF+1][numC]+NUMERO_CARACTER);
				 if (tableroOculto[numF+1][numC]==VACIO_OCULTO) {
					 	tableroVisible[numF+1][numC]=VACIO;
			        	comprobarCero(tableroOculto, tableroVisible, numF+1, numC);
			        }
			}	
		}catch(Exception e) {}
		try {
			if (tableroVisible[numF+1][numC+1]==NO_DESCUBIERTO) {
				tableroVisible[numF+1][numC+1]=(char) (tableroOculto[numF+1][numC+1]+NUMERO_CARACTER);
				 if (tableroOculto[numF+1][numC+1]==VACIO_OCULTO) {
					 	tableroVisible[numF+1][numC+1]=VACIO;
			        	comprobarCero(tableroOculto, tableroVisible, numF+1, numC+1);
			        }
			}	
		}catch(Exception e) {}
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
	private static boolean comprobarFinal (char [][] tableroVisible) {
		int contador=0;
		for (int i=0; i<FILAS;i++) {
			for (int j=0; j<COLUMNAS;j++) {
				if (tableroVisible[i][j]==NO_DESCUBIERTO) {
					contador++;
				}
			}
		}
		if (contador==MINAS) {
			return false;
		}else {
			return true;
		}
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
	private static void imprimirTableroVisible(char tableroVisible[][]) {
		System.out.print("   ");
		for (int i=0;i<FILAS;i++) {
			System.out.print(+i+" ");
		}
		System.out.println();
		System.out.println("   _________________");
		for (int i=0; i<FILAS; i++) {
			System.out.print(i+ " |");
			for (int j=0; j<COLUMNAS; j++) {
				System.out.print( tableroVisible[i][j]+" ");
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
						tableroOculto[i][j]=MINA_OCULTA;
					}
				}
			}
		}
	}
	private static void colocarNumeros(int tableroOculto[][]){
		for (int i=0;i<FILAS;i++){
			for (int j=0;j<COLUMNAS;j++){
				if (tableroOculto[i][j]==MINA_OCULTA) {
					try {
						if (tableroOculto[i-1][j-1]!=MINA_OCULTA) {
							tableroOculto[i-1][j-1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i-1][j]!=MINA_OCULTA) {
							tableroOculto[i-1][j]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i-1][j+1]!=MINA_OCULTA) {
							tableroOculto[i-1][j+1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i][j-1]!=MINA_OCULTA) {
							tableroOculto[i][j-1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i][j+1]!=MINA_OCULTA) {
							tableroOculto[i][j+1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i+1][j-1]!=MINA_OCULTA) {
							tableroOculto[i+1][j-1]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i+1][j]!=MINA_OCULTA) {
							tableroOculto[i+1][j]++;
						}
					}catch(Exception e) {}
					try {
						if (tableroOculto[i+1][j+1]!=MINA_OCULTA) {
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
	private static void inicializar(int tableroOculto[][], char tableroVisible[][]) {
		for(int i=0;i<FILAS;i++) {
			for(int j=0;j<COLUMNAS;j++) {
				tableroOculto[i][j]=VACIO_OCULTO;
				tableroVisible[i][j]=NO_DESCUBIERTO;
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
         if (FormatoCorrecto(posicion)) {// verifica que la entrada tenga el formato correcto
           datoValido=true; // sale del bucle si la posición es valida
         } else {
             System.out.println("formato incorrecto. Ingrese dos numeros separados por un espacio.");
         }
     }
	return posicion;
}
	private static boolean FormatoCorrecto(String posicion) {// verifica que la entrada tenga el formato correcto 
		boolean datoValido;
        String[] partes = posicion.split(" "); //funcion encontrada en un foro
        if (partes.length != 2) {
            return datoValido=false;
        }
        try {
            int fila = Integer.parseInt(partes[0]);
            int columna = Integer.parseInt(partes[1]);//funcion buscada en internet.
             return fila >= 0 && columna >= 0 && fila<FILAS && columna<COLUMNAS; // verifica que fila y columna sean números positivos
        } catch (NumberFormatException e) {
            return datoValido=false; 
        }
    }
	private static boolean eleccionPos(String posicion, int[][] tableroOculto) {
		char charF, charC;
	    charF=posicion.charAt(0);
	    charC=posicion.charAt(2);
	    int numF= Character.getNumericValue(charF);
	    int numC = Character.getNumericValue(charC);
	    if (tableroOculto[numF][numC]==MINA_OCULTA) {
			return true;
		}else {
			return false;
		}
	}
	private static void mostarMinas(int tableroOculto[][],char tableroVisible[][]) {
        for(int i=0;i<FILAS;i++) {
            for (int j=0;j<COLUMNAS;j++){
                if (tableroOculto[i][j]==-1) {
                    tableroVisible[i][j]=MINA;
                }
            }
        }
	}
}
