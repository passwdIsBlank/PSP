import java.util.ArrayList;

public class Carrera extends Thread {
	
	private static ArrayList<Carrera> podio = new ArrayList<Carrera>();
	private static final int META = 30;
	

	@Override
	public void run() {
	
		for (int i = 0; i <= META; i++) {
			System.out.printf("%s ha recorrido %d metros\r", Thread.currentThread().getName(), i);
		}
		
		asignarPuesto();
		
	}
	
	public synchronized void asignarPuesto() {
		this.podio.add(this);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Carrera animal1 = new Carrera();
		Carrera animal2 = new Carrera();
		Carrera animal3 = new Carrera();
		
		animal1.setName("Animal1");
		animal2.setName("Animal2");
		animal3.setName("Animal3");
		
		animal1.start();
		animal2.start();
		animal3.start();
		
		try {
			animal1.join();
			animal2.join();
			animal3.join();
		} catch (InterruptedException e) {
			
		}
		
		Carrera.podio.forEach( animal -> System.out.printf("%d# %s\r", Carrera.podio.indexOf(animal) + 1, animal.getName()));
		
	}

}
