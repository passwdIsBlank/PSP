package gestionMensajes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aplicacion extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7651264026862691712L;
	private JPanel MainWindow;
	private ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion frame = new Aplicacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aplicacion() {
		setResizable(false);
		setTitle("Gesti\u00F3n de Mensajes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MainWindow = new JPanel();
		MainWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainWindow);
		MainWindow.setLayout(null);

		JButton btnLoad = new JButton("Cargar Mensajes");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMensajes("files/Mensajes.txt");
			}
		});
		
		btnLoad.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnLoad.setBounds(10, 25, 161, 36);
		MainWindow.add(btnLoad);

		JButton btnAdd = new JButton("Añadir Mensaje");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaIntroducirMensaje();
			}
		});
		btnAdd.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnAdd.setBounds(10, 95, 161, 36);
		MainWindow.add(btnAdd);

		//BOTÓN IMPRIMIR
		JButton btnPrint = new JButton("Imprimir Mensajes");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaMostrarMensajes();
			}
		});
		btnPrint.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnPrint.setBounds(263, 95, 161, 36);
		MainWindow.add(btnPrint);

		//BOTÓN GUARDAR
		JButton btnSave = new JButton("Guardar Mensajes");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarMensajes("files/Mensajes.txt");
			}
		});
		btnSave.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnSave.setBounds(263, 25, 161, 36);
		MainWindow.add(btnSave);

		// BOTÓN SALIR
		JButton btnExit = new JButton("Salir");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnExit.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnExit.setBounds(10, 214, 414, 36);
		MainWindow.add(btnExit);
	}

	public void loadMensajes(String ruta) {
		this.mensajes.removeAll(this.mensajes);
		
		try {
			File fic = new File(ruta);// declara fichero
			BufferedReader fichero = new BufferedReader(new FileReader(fic));
			
			String linea;
			
			while ((linea = fichero.readLine()) != null) {
				
				if (!linea.matches("\\**")) {

					String fecha = linea.split(":")[1];

					String hora = fichero.readLine().split(":")[1];
					
					String from = fichero.readLine().split(":")[1];

					String to = fichero.readLine().split(":")[1];

					String subject = fichero.readLine().split(":")[1];

					String body = fichero.readLine().split(":")[1];
					
					this.mensajes.add(new Mensaje(fecha, hora, from, to, subject, body));
				}
				
			}
			
			fichero.close();
			
			JOptionPane.showMessageDialog(null, "Se han cargado " + this.mensajes.size() +  " Mensajes");
			
		} catch (FileNotFoundException fn) {
			
			System.out.println("No se encuentra el fichero de mensajes");
			
		} catch (IOException io) {
			
			System.out.println("Error de E/S ");
			
		}

	}
	
	public void guardarMensajes(String ruta) {
		try {
			
			File file = new File(ruta);
			BufferedWriter fichero = new BufferedWriter(new FileWriter(file));

			//Iterar y guardar mensajes en fichero
			this.mensajes.forEach( msg -> 
				{
					try {
						fichero.write("Fecha:" + msg.getFecha() + "\rHora:" + msg.getHora() + "\rDe:" + msg.getFrom() + "\rA:" + msg.getTo() + "\rAsunto:" + msg.getSubject() + "\rMensaje:" + msg.getBody());
						fichero.newLine();
						fichero.write("******************");
						fichero.newLine();
					} catch (IOException e) {
						System.out.println("Error de E/S ");
					}
				}
			);
				
			fichero.close();
			
			JOptionPane.showMessageDialog(null, "Se han guardado " + this.mensajes.size() +  " Mensajes");
		
		} catch (FileNotFoundException fn) {
			
			System.out.println("No se encuentra el fichero de mensajes");
			
		} catch (IOException io) {
			
			System.out.println("Error de E/S ");
			
		}
	}
	
	public void ventanaMostrarMensajes() {
		JFrame vImprimir = new JFrame();
		vImprimir.setResizable(true);
		vImprimir.setTitle("Ver Mensajes");
		vImprimir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vImprimir.setSize(450, 300);
		vImprimir.setBounds(100, 100, 450, 300);
		
		// MAIN PANEL
		JPanel pPrincipal = new JPanel(new BorderLayout());
		pPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		vImprimir.setContentPane(pPrincipal);
		
		// TABLA
		String[] cols = {"Fecha", "Hora", "De", "A", "Asunto", "Mensaje"};
		
		DefaultTableModel model = new DefaultTableModel(cols, 0);
		
		JTable tabla = new JTable(model);
		
		this.mensajes.forEach( msg -> model.addRow( msg.toArray() ) );
		
		tabla.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		tabla.setRowHeight(30);
		
		JScrollPane sPane = new JScrollPane(tabla);
		
		pPrincipal.add(sPane);
		
		// BOTÓN SALIR
		JButton btnExit = new JButton("Cerrar");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vImprimir.dispose();
			}
		});
		btnExit.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		
		pPrincipal.add(btnExit, BorderLayout.SOUTH);
		
		vImprimir.setVisible(true);
		
	}

	public void ventanaIntroducirMensaje() {
		JFrame vIntroducirMensaje = new JFrame();
		JPanel contentPane;
		JTextField inputFecha, inputHora, inputDe, inputA, inputAsunto;
		JLabel lblFecha, lblDe, lblA, lblAsunto, lblMensaje;
		JTextArea tAreaMensaje;
		JButton btnCerrar, btnSaveMsg;
		
		vIntroducirMensaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vIntroducirMensaje.setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		vIntroducirMensaje.setContentPane(contentPane);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(11, 14, 40, 14);
		
		inputFecha = new JTextField(LocalDate.now().toString());
		inputFecha.setBounds(48, 11, 72, 20);
		inputFecha.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(130, 14, 40, 14);
		
		inputHora = new JTextField(String.valueOf(LocalTime.now().getHour()));
		inputHora.setBounds(164, 11, 25, 20);
		inputHora.setColumns(10);
		
		lblDe = new JLabel("De");
		lblDe.setBounds(11, 52, 34, 14);
		
		lblA = new JLabel("A");
		lblA.setBounds(179, 52, 25, 14);
		
		lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(11, 87, 53, 14);
		
		lblMensaje = new JLabel("Mensaje");
		lblMensaje.setBounds(11, 138, 53, 14);
		
		inputDe = new JTextField();
		inputDe.setBounds(34, 49, 136, 20);
		inputDe.setColumns(10);
		
		inputA = new JTextField();
		inputA.setBounds(199, 49, 136, 20);
		inputA.setColumns(10);
		
		inputAsunto = new JTextField();
		inputAsunto.setBounds(11, 107, 408, 20);
		inputAsunto.setColumns(10);
		
		tAreaMensaje = new JTextArea();
		tAreaMensaje.setBounds(11, 158, 408, 95);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(347, 263, 72, 23);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vIntroducirMensaje.dispose();
			}
		});
		
		btnSaveMsg = new JButton("Guardar Mensaje");
		btnSaveMsg.setBounds(143, 263, 137, 23);
		btnSaveMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMensaje(inputFecha.getText(), inputHora.getText(), inputDe.getText(), inputA.getText(), inputAsunto.getText(), tAreaMensaje.getText());
				btnCerrar.doClick();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblMensaje);
		contentPane.add(inputAsunto);
		contentPane.add(lblAsunto);
		contentPane.add(lblFecha);
		contentPane.add(inputFecha);
		contentPane.add(lblHora);
		contentPane.add(inputHora);
		contentPane.add(lblDe);
		contentPane.add(inputDe);
		contentPane.add(lblA);
		contentPane.add(inputA);
		contentPane.add(tAreaMensaje);
		contentPane.add(btnSaveMsg);
		contentPane.add(btnCerrar);
		
		vIntroducirMensaje.setVisible(true);
	}
	
	public void addMensaje(String fecha, String hora, String from, String to, String subject, String body) {
		this.mensajes.add(new Mensaje(fecha, hora, from, to, subject, body));
		JOptionPane.showMessageDialog(null, "Se ha añadido el mensaje");
	}
}
