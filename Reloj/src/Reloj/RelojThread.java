package Reloj;

import javax.swing.JLabel;

public class RelojThread implements Runnable {

	private JLabel etiqueta;
	private int min, seg;
	
	public RelojThread(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public void run() {
		while(Thread.currentThread().isAlive()) {
			try {
				Thread.sleep(1000);
				this.seg++;
				if ( this.seg == 60 ) incrementar();
				if (this.min == 60) reiniciar();
				
				mostrar();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
	
	public void reiniciar() {
		this.min = 0;
		this.seg = 0;
	}

	private void mostrar() {
		String mins = String.valueOf(this.min);
		String secs = String.valueOf(this.seg);
		
		if (mins.length() == 1) mins = "0" + this.min;
		if (secs.length() == 1) secs = "0" + this.seg;
		
		this.etiqueta.setText(mins + ":" + secs);
	}
	
	private void incrementar() {
		this.seg = 0;
		this.min++;
	}
}
