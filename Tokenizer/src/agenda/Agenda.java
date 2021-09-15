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
		Pattern pNombre = Pattern.compile("^[A-Z ?]{0,20}$", 2);
		Pattern pApellidos = Pattern.compile("^[A-Z ?]{0,30}$", 2);
		Pattern pDni = Pattern.compile("^[0-9]{8}[A-Z]{1}$", 2);
		
		// Empieza con 6 ó 7 + 8 números del 0-9
		Pattern pTelefono = Pattern.compile("^[67][0-9]{8}$");
		
		boolean valido = false;
		
		if (pNombre.matcher(nombre).matches() && pApellidos.matcher(apellidos).matches() && pDni.matcher(dni).matches() && pTelefono.matcher(telefono).matches()) {
			valido = true;
			this.contactos.add(new Contacto(nombre, apellidos, dni, telefono));
			
		}
		return valido;
	}
	
	public void mostrarAgenda() {
		System.out.println("\r*******************************************************************************");
		System.out.println("*                     Contactos de la Agenda                                  *");
		System.out.println("*******************************************************************************");
		System.out.println("* Nº *    Nombre     *    Apellidos    *     D.N.I.     *       Teléfono      *");
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
					
					System.out.print("\rIntroduce el nombre: ");
					nombre = sc.nextLine();
					System.out.print("Introduce los apellidos: ");
					apellidos = sc.nextLine();
					System.out.print("Introduce el dni: ");
					dni = sc.nextLine();
					System.out.print("Introduce el telefono: ");
					telefono = sc.nextLine();
					
					
					if (agenda.AddContacto(nombre, apellidos, dni, telefono)) System.out.flush();
					else System.out.println("Datos inválidos");
					
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
		System.out.println("2. Añadir contacto/s\r");
	}
}
