package Reloj;

import javax.swing.JLabel;

public class RelojThread implements Runnable {

	private JLabel etiqueta;
	private static int min, seg;
	
	public RelojThread(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public void run() {
		try {
			while(Thread.currentThread().isAlive()) {
				Thread.sleep(1000);
				seg++;
				if ( seg == 60 ) incrementar();
				if (min == 60) reiniciar();
				mostrar();
			}
		} catch (InterruptedException e) {
			System.out.printf("El hilo %s ha terminado\r", Thread.currentThread().getName());
			reiniciar();
		}
	}
	
	public static void reiniciar() {
		min = 0;
		seg = 0;
	}

	private void mostrar() {
		String mins = String.valueOf(min);
		String secs = String.valueOf(seg);
		
		if (mins.length() == 1) mins = "0" + min;
		if (secs.length() == 1) secs = "0" + seg;
		
		this.etiqueta.setText(mins + ":" + secs);
	}
	
	private void incrementar() {
		seg = 0;
		min++;
	}
}
