
public class HiloNumeroLetra implements Runnable {

	public HiloNumeroLetra(String nombre) {
		Thread t = new Thread(this);
		t.setName(nombre);
		t.start();
	}

	@Override
	public void run() {
		
		switch ( Thread.currentThread().getName() ) {
			case "1":
				for (char letra = 'a'; letra <= 'z'; letra++) {
					System.out.println(letra);
				}
			break;
			case "2":
				for (int i = 0; i <= 9; i++) {
					System.out.println(i);
				}
			break;
		}

	}
	
	public static void main(String[] args) {
		new HiloNumeroLetra("1");
		new HiloNumeroLetra("2");
		
		System.out.println("-- MAIN THREAD END --");
	}

}
