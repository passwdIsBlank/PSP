package juegos;

public abstract class Juego {

	private int numVidas;
	private int numVidasInit;
	private static int record;
	
	//Constructor
	public Juego(int numVidasInit) {
		this.numVidas = numVidasInit;
		this.numVidasInit = numVidasInit;
	}

	//Métodos
	
	public void ReiniciaPartida() {
		this.numVidas = this.numVidasInit;
	}
	
	public void MuestraVidasRestantes () {
		System.out.println(this.numVidas);
	}
	
	public boolean QuitaVida() {
		if (this.numVidas > 1) {
			this.numVidas--;
			return true;
		}
		else {
			this.numVidas--;
			return false;
		}
	}
	
	// En base al número de vidas restantes actualizará nuestro record o no y nos mostrará un mensaje
	public void ActualizaRecord() {
		if (Juego.record == this.numVidas) System.out.println("Has alcanzado el record!\r");
		else if (Juego.record < this.numVidas) {
			Juego.record = this.numVidas;
			System.out.println("Has superado el record!\rTu nuevo record es " + Juego.record + "\r");
		}
	}
	
	//Getters & Setters
	
	public void setNumVidas(int vidas) {
		this.numVidas = vidas;
	}
	
	public int getNumVidas() {
		return this.numVidas;
	}
	
	
}
