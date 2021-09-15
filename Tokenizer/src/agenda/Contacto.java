package agenda;

import java.util.regex.Pattern;

public class Contacto {
	
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	
	public Contacto(String nombre, String apellidos, String dni, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
