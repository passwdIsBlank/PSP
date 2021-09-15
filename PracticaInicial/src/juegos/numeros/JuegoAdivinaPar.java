package juegos.numeros;

import java.util.Random;

public class JuegoAdivinaPar extends JuegoAdivinaNumero {

	// Constructor
	public JuegoAdivinaPar(int numVidas) {
		super(numVidas);
	}
	
	// M�todos sobreescritos
	@Override
	public boolean ValidaNumero(String num) {
		try {
			if (Integer.parseInt(num) % 2 == 0) return true;
			else {
				System.out.println("El n�mero no es par");
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	@Override
	public void MuestraNombre() {
		System.out.println("Adivina un n�mero par");
	}

	@Override
	public void MuestraInfo() {
		System.out.println("Adivina el n�mero par, para ello mientras te queden vidas deber�s introducir un n�mero par.");
	}
	
	@Override
	public void ReiniciaPartida() {
		Random rand = new Random();
		do {
			this.setNumAdivinar(rand.nextInt(10 + 1));
			
		} while (this.getNumAdivinar() % 2 != 0);
	}
}
