import java.util.Scanner;
import java.math.*;

public class Ecuacion {
	private double a, b, c;

	public Ecuacion(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void resolver() {
		try {
			
			validarEcuacion();
			// RESULT 1
			System.out.printf("x1: %f\r", (-this.b + ( Math.sqrt((this.b * this.b)-(4 * this.a * this.c)))/(2 * this.a)));
			// RESULT 2
			System.out.printf("x2: %f\r", (-this.b - ( Math.sqrt((this.b * this.b)-(4 * this.a * this.c)))/(2 * this.a)));
			
		} catch (ExcepcionesEcuacion e) {
			System.out.println("********************************************");
			System.out.println(e.getMessage());
			System.out.println("********************************************");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a, b, c;
	
		mostrarMenu();
		
		do {
			
			System.out.print("Introducir A: ");
			a = sc.nextLine();
			System.out.print("Introducir B: ");
			b = sc.nextLine();
			System.out.print("Introducir C: ");
			c = sc.nextLine();
			
		} while (!isNumber(a) && !isNumber(b) && !isNumber(c));
		
		Ecuacion ecuacion = new Ecuacion(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(c));
		
		System.out.println("********************************************");
		System.out.printf("            %s\r", ecuacion.toString());
		System.out.println("********************************************");
		
		ecuacion.resolver();

	}

	public static void mostrarMenu() {
		System.out.println("********************************************");
		System.out.println("* Excepciones en ecuación de segundo grado *");
		System.out.println("********************************************");
		System.out.println("            y = Ax ² + Bx + C               ");
		System.out.println("********************************************");
	}
	
	public void validarEcuacion() throws ExcepcionesEcuacion {
		if ( this.a == 0 ) throw new ExcepcionesEcuacion("Atención ¡! No es una ecuación de segundo grado");
		if ( (Math.pow(b, 2) - (4 * this.a * this.c)) == 0 ) throw new ExcepcionesEcuacion("El valor de A no puede ser cero");
		if ( (Math.pow(b, 2) - (4 * this.a * this.c)) < 0 ) throw new ExcepcionesEcuacion("No da un resultado real");
	}
	
	public static boolean isNumber(String number) {
		try {
			Double.parseDouble(number);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "y = " + this.a + "x ² + " + this.b + " x + " + this.c;
	}
	
}
