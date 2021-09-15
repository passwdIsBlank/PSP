package juegos.numeros;
import java.util.Scanner;

import juegos.Juego;
import juegos.interfaces.Jugable;

import java.util.Random;

public class JuegoAdivinaNumero extends Juego implements Jugable{
	private int numAdivinar;

	// Constructor
	public JuegoAdivinaNumero(int numVidas) {
		super(numVidas);
		
		Random rand = new Random();	
		this.numAdivinar = rand.nextInt(10 + 1);
	}

	// Implementados de Jugable
	@Override
	public void MuestraNombre() {
		System.out.println("Adivina un número");
	}

	@Override
	public void MuestraInfo() {
		System.out.println("Adivina el número, para ello mientras te queden vidas deberás introducir un número.");
	}
	
	@Override
	public void Juega() {
		Scanner sc = new Scanner(System.in);
		String num = null;
		boolean fin = false;
		
		ReiniciaPartida();	
		
		// TODO mirar lo de la validación
		do {
			do {
				System.out.println("\rAdivina el número entre el 0 y el 10 [vidas restantes: " + this.getNumVidas() + "]");
				num = sc.nextLine();
			} while(!ValidaNumero(num));
			
			if (this.numAdivinar == Integer.parseInt(num)) {
				System.out.println("Acertaste!!");
				ActualizaRecord();
				fin = true;
			}
			else if (QuitaVida()) {
				if (this.numAdivinar > Integer.parseInt(num))	System.out.println("El número es mayor");
				else System.out.println("El número es menor");
			} else System.out.println("Has muerto");
		} while (getNumVidas() > 0 && !fin);
	}
	
	@Override
	public void ReiniciaPartida() {
		Random rand = new Random();
		this.setNumAdivinar(rand.nextInt(10 + 1));
	}
	
	// Métodos
	public boolean ValidaNumero(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// Getters & Setters
	public int getNumAdivinar() {
		return numAdivinar;
	}

	public void setNumAdivinar(int numAdivinar) {
		this.numAdivinar = numAdivinar;
	}

}
