package juegos.letras;

import java.util.Scanner;

import juegos.Juego;
import juegos.interfaces.Jugable;

public class JuegoAhorcado extends Juego implements Jugable {
	private String strAdivinar;
	
	// Constructor
	public JuegoAhorcado(int numVidasInit, String strAdivinar) {
		super(numVidasInit);
		// TODO Auto-generated constructor stub
	}

	// Métodos sobreescritos
	
	@Override
	public void Juega() {
		Scanner sc = new Scanner(System.in);
		String tempStrAdivinar = "";
		String letra = "";
		boolean fin = false;
		
		ReiniciaPartida();
		
		for (int i = 0; i < this.strAdivinar.length(); i++) {
			tempStrAdivinar += "-";
		}
		
		do {
			System.out.println("\rAdivina la palabra [vidas restantes: " + this.getNumVidas() + "]");
			letra = sc.nextLine();
		} while (getNumVidas() > 0 && !fin);
	}

	@Override
	public void MuestraNombre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MuestraInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReiniciaPartida() {
		// TODO Auto-generated method stub
		
	}
	
	// Getters & Setters
	
	public String getStrAdivinar() {
		return strAdivinar;
	}

	public void setStrAdivinar(String strAdivinar) {
		this.strAdivinar = strAdivinar;
	}
}
