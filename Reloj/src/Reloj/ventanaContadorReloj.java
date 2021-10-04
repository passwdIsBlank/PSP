package Reloj;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class ventanaContadorReloj extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2245637179359978959L;
	private JPanel contentPane;
	private JLabel labelReloj, label1, label2;
	private JButton btnIniciar, btnPausar, btnParar, btnReiniciar, btnSalir;
	private Thread t1 = new Thread();
	private Thread t2;
	private Thread t3;

	/**
	 * Create the frame.
	 */
	public ventanaContadorReloj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1 = new JLabel("<<");
		label1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label1.setBounds(131, 11, 40, 37);
		contentPane.add(label1);
		
		label2 = new JLabel(">>");
		label2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label2.setBounds(248, 11, 40, 37);
		contentPane.add(label2);
		
		labelReloj = new JLabel("00:00");
		labelReloj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReloj.setBounds(181, 13, 57, 37);
		contentPane.add(labelReloj);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(10, 80, 71, 23);
		btnIniciar.addActionListener(this);
		contentPane.add(btnIniciar);
		
		btnPausar = new JButton("Pausar");
		btnPausar.setEnabled(false);
		btnPausar.setBounds(91, 80, 71, 23);
		btnPausar.addActionListener(this);
		contentPane.add(btnPausar);
		
		btnParar = new JButton("Parar");
		btnParar.setEnabled(false);
		btnParar.setBounds(172, 80, 71, 23);
		btnParar.addActionListener(this);
		contentPane.add(btnParar);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setEnabled(false);
		btnReiniciar.setBounds(253, 80, 90, 23);
		btnReiniciar.addActionListener(this);
		contentPane.add(btnReiniciar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(353, 80, 71, 23);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
		
		//Iniciar Threads
		this.t2 = new Thread(new EtiquetaThread(this.label1));
		this.t3 = new Thread(new EtiquetaThread(this.label2));
		
		this.t2.setPriority(1);
		this.t3.setPriority(1);
		
		this.t2.setName("T-label1");
		this.t3.setName("T-label2");
		
		this.t2.start();
		this.t3.start();
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaContadorReloj frame = new ventanaContadorReloj();
					frame.setVisible(true);
					
					// Cositas
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		//TODO implementar funcionalidad
		if (e.getSource() == this.btnIniciar) {
			
			try {
				if(this.t1.isAlive()) this.t1.resume();
				else {
					this.t1 = new Thread(new RelojThread(this.labelReloj));
					this.t1.setName("T-Reloj");
					this.t1.start();
				}
				
			} catch(Exception ex) {
				System.out.println(this.t1.getClass());
			}
			
			this.btnPausar.setEnabled(true);
			this.btnParar.setEnabled(true);
			this.btnReiniciar.setEnabled(true);
			
		} else if (e.getSource() == this.btnPausar) {
			
			this.t1.suspend();
		
		} else if (e.getSource() == this.btnParar) {
			
			this.btnPausar.setEnabled(false);
			this.btnParar.setEnabled(false);
			this.btnReiniciar.setEnabled(false);
			
			this.t1.interrupt();
		
		} else if (e.getSource() == this.btnReiniciar) {
			
			RelojThread.reiniciar();
			
		} else if (e.getSource() == this.btnSalir) {
			
			salir();
			
		}
	}
	
	private void salir() {
		this.t2.interrupt();
		this.t3.interrupt();
		System.exit(EXIT_ON_CLOSE);
	}
}
