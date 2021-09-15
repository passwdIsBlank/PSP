package agenda;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Agenda {
	ArrayList<Contacto> contactos;
	
	public Agenda() {
		this.contactos = new ArrayList<Contacto>();
	}

	public Contacto AddContacto(String nombre, String apellidos, String dni, String telefono) {
		Pattern pNombre = Pattern.compile("^[A-Z ?]{0,20}$", 2);
		Pattern pApellidos = Pattern.compile("^[A-Z ?]{0,30}$", 2);
		Pattern pDni = Pattern.compile("^[0-9]{8}[A-Z]{1}$", 2);
		
		// Empieza con 6 ó 7 + 8 números del 0-9
		Pattern pTelefono = Pattern.compile("^[67][0-9]{8}$");
		
		Contacto contacto = null;
		
		if (pNombre.matcher(nombre).matches() && pApellidos.matcher(apellidos).matches() && pDni.matcher(dni).matches() && pTelefono.matcher(telefono).matches()) contacto = new Contacto(nombre, apellidos, dni, telefono);
		return contacto;
	}
	
	public void mostrarMenu() {
		System.out.println("");
	}
	
	public void mostrarAgenda() {
		System.out.println("*******************************************************************************");
		System.out.println("*                     Contactos de la Agenda                                  *");
		System.out.println("*******************************************************************************");
		System.out.println("* Nº *    Nombre     *    Apellidos    *    D.N.I.      *     Teléfono        *");
		System.out.println("*******************************************************************************");
		this.contactos.forEach( contacto -> {
			System.out.printf("%d * %s * %s * %s * %s *", contactos.indexOf(contacto) + 1, contacto.getNombre(), contacto.getApellidos(), contacto.getDni(), contacto.getTelefono());
			System.out.println("*******************************************************************************");
		});
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		boolean continuar = false;
		
		do {
			// TODO termianr la inserción de contactos
			agenda.AddContacto(null, null, null, null);
			
			if (sc.nextLine().equalsIgnoreCase("S")) continuar = true;
			else continuar = false;
		} while(continuar);
	}
}
