package agenda;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Agenda {
	ArrayList<Contacto> contactos;
	
	public Agenda() {
		this.contactos = new ArrayList<Contacto>();
	}

	public boolean AddContacto(String nombre, String apellidos, String dni, String telefono) {
		
		// Letras y espacios MAX 20 car�cteres
		Pattern pNombre = Pattern.compile("^[A-Z ?]{0,20}$", 2);
		// Letras y espacios MAX 30 car�cteres
		Pattern pApellidos = Pattern.compile("^[A-Z ?]{0,30}$", 2);
		// 8 n�meros y 1 letra
		Pattern pDni = Pattern.compile("^[0-9]{8}[A-Z]{1}$", 2);
		// Empieza con 6 � 7 seguido de 8 n�meros del 0-9
		Pattern pTelefono = Pattern.compile("^[67][0-9]{8}$");
		
		final char [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		
		boolean valido = false;
		
		// Comprobar si cumplen los filtros
		if (pNombre.matcher(nombre).matches() && pApellidos.matcher(apellidos).matches() && pDni.matcher(dni).matches() && pTelefono.matcher(telefono).matches()) {
			
			// Comprobar letra, DNI n�mero % 23 = indice del 0-22 el cual corresponde a la letra del array de letras
			int indiceDni = Integer.parseInt(dni.substring(0, 8)) % 23;
			
			if ( Character.compare(letras[indiceDni], dni.charAt(8)) == 0 ) {
				valido = true;
				this.contactos.add(new Contacto(nombre, apellidos, dni, telefono));
			}
			else System.out.println("Letra del DNI inv�lida");
		}
		return valido;
		
	}
	
	public void mostrarAgenda() {
		System.out.println("\r*******************************************************************************");
		System.out.println("*                     Contactos de la Agenda                                  *");
		System.out.println("*******************************************************************************");
		System.out.println("* N� *    Nombre     *    Apellidos    *     D.N.I.     *       Tel�fono      *");
		System.out.println("*******************************************************************************");
		this.contactos.forEach( contacto -> {
			String linea = "*   " + (contactos.indexOf(contacto) + 1) + "   *   ";
			linea += contacto.getNombre() + "   *   ";
			linea += contacto.getApellidos() + "   *   ";
			linea += contacto.getDni() + "   *   ";
			linea += contacto.getTelefono() + "   *";
			
			System.out.println(linea);
			System.out.println("*******************************************************************************");
		});
	}
	
	public static void main(String[] args) {
		final int SALIR = 0;
		final int VER_AGENDA = 1;
		final int ADD_CONTACTOS = 2;
		
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		
		boolean continuar = false;
		int opt = 0;
		
		do {
			// Pedir entrada
			mostrarMenu();
			opt = Integer.parseInt(sc.nextLine());
			
			switch (opt) {
			case SALIR:
				System.out.println("-- FIN --");
				break;
			case VER_AGENDA:
				agenda.mostrarAgenda();
				break;
			case ADD_CONTACTOS:
				
				do {
					String nombre, apellidos, dni, telefono;
					
					System.out.print("\rIntroduce el nombre (MAX length [20]): ");
					nombre = sc.nextLine();
					System.out.print("Introduce los apellidos (MAX length [20]): ");
					apellidos = sc.nextLine();
					System.out.print("Introduce el dni: ");
					dni = sc.nextLine();
					System.out.print("Introduce el telefono (MAX length [9], 1er n�mero 6 � 7): ");
					telefono = sc.nextLine();
					
					
					if (!agenda.AddContacto(nombre, apellidos, dni, telefono)) System.out.println("Datos inv�lidos");
					
					System.out.println("\r\rQuieres introducir otro? [s/N]");
					if (sc.nextLine().equalsIgnoreCase("S")) continuar = true;
					else continuar = false;
				} while(continuar);
				
				break;
			}
		} while (opt != 0);
	}
	
	public static void mostrarMenu() {
		System.out.println("\r0. Salir");
		System.out.println("1. Ver Agenda");
		System.out.println("2. A�adir contacto/s\r");
	}
}
