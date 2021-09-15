package juegos.numeros;

import java.util.Random;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

	// Constructor
	public JuegoAdivinaImpar(int numVidas) {
		super(numVidas);
	}
	
	// Métodos sobreescritos
	@Override
	public boolean ValidaNumero(String num) {
		try {
			if (Integer.parseInt(num) % 2 != 0) return true;
			else {
				System.out.println("El número no es impar");
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	@Override
	public void MuestraNombre() {
		System.out.println("Adivina un número impar");
	}

	@Override
	public void MuestraInfo() {
		System.out.println("Adivina el número impar, para ello mientras te queden vidas deberás introducir un número impar.");
	}
	
	@Override
	public void ReiniciaPartida() {
		Random rand = new Random();
		do {
			this.setNumAdivinar(rand.nextInt(10 + 1));
			
		} while (this.getNumAdivinar() % 2 == 0);
	}
}
