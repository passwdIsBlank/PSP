import java.util.Scanner;

import juegos.interfaces.Jugable;
import juegos.numeros.JuegoAdivinaImpar;
import juegos.numeros.JuegoAdivinaNumero;
import juegos.numeros.JuegoAdivinaPar;

public class Aplicacion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jugable juego = null;
		boolean answer = false;

		do {
			do {
				juego = EligeJuego();
			} while (juego == null);
			
			juego.MuestraNombre();
			juego.MuestraInfo();
			juego.Juega();
			
			System.out.println("\r¿Quieres jugar otra vez?[y/N]\r");

			if (sc.nextLine().equalsIgnoreCase("Y")) answer = true;
			else answer = false;
			
		} while(answer);

	
	}
	
	public static Jugable EligeJuego() {
		Scanner sc = new Scanner(System.in);
		
		JuegoAdivinaNumero adivina = new JuegoAdivinaNumero(3);
		JuegoAdivinaImpar adivinaImpar = new JuegoAdivinaImpar(3);
		JuegoAdivinaPar adivinaPar = new JuegoAdivinaPar(3);
		
		Jugable[] juegos = {adivina, adivinaPar, adivinaImpar};
		
		System.out.println("Elige un juego: \r1. Adivina el número\r2. Adivina el número Par\r3. Adivina el número Impar\r");
		switch (sc.nextInt()) {
		case 1:
			return juegos[0];
		case 2:
			return juegos[1];
		case 3:
			return juegos[2];
		default:
			System.out.println("\rNo existe ese juego!\rElije otro\r\r");
			return null;
		}
	}
}
