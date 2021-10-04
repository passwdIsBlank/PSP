package Reloj;

import java.awt.Color;
import javax.swing.JLabel;

public class EtiquetaThread implements Runnable {
	private JLabel etiqueta;
	
	
	public EtiquetaThread(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}


	@Override
	public void run() {
		while(Thread.currentThread().isAlive()) {
			try {
				Thread.sleep(2000);
				Color color = new Color( (int) ((Math.random() * 255) + 1), (int) ((Math.random() * 255) + 1), (int) ((Math.random() * 255) + 1));
				this.etiqueta.setForeground(color);
			} catch (InterruptedException e) {
				System.out.printf("El hilo %s ha terminado\r", Thread.currentThread().getName());
			}
		}
	}
	
}
