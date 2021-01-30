
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import java.awt.Toolkit;

public class Ganador extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int puntajeActual;
	/**
	 * Create the application.
	 */

	//Constructor
	public Ganador(int puntaje) {
		this.puntajeActual=puntaje;
		setBackground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ganador.class.getResource("/Imagen/2048.png")));
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//tamaño de la ventana
		setBounds(100, 100, 600, 600);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//Label donde se escribe GANASTE
		JLabel Ganastee = new JLabel("\u00A1GANASTE!");
		Ganastee.setBackground(new Color(173, 255, 47));
		Ganastee.setFont(new Font("Eras Demi ITC", Font.BOLD, 33));
		Ganastee.setBounds(180, 36, 213, 84);
		getContentPane().add(Ganastee);
		
		//Boton para salir del juego
		JButton botonSalir = new JButton("SALIR");
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		botonSalir.setForeground(Color.DARK_GRAY);
		botonSalir.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botonSalir.setBackground(Color.LIGHT_GRAY);
		botonSalir.setBounds(353, 465, 157, 47);
		ImageIcon salir=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/exit.png"));
		botonSalir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(botonSalir.getHeight()-10,botonSalir.getHeight()-10,Image.SCALE_SMOOTH)));
		getContentPane().add(botonSalir);
		
		//Boton para volver a la interfaz Opciones
		JButton botonVolver = new JButton("VOLVER");
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Opciones op= new Opciones();
				op.setLocationRelativeTo(null);
				op.setVisible(true);
				setVisible(false);
			}
		});
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonVolver.setForeground(Color.DARK_GRAY);
		botonVolver.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botonVolver.setBackground(Color.LIGHT_GRAY);
		botonVolver.setBounds(42, 465, 157, 47);
		ImageIcon volver=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/volver.png"));
		botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getHeight()-5,botonVolver.getHeight()-5,Image.SCALE_SMOOTH)));
		getContentPane().add(botonVolver);
		
		//Label donde contiene un gif
		JLabel ImagenGanador = new JLabel("");
		ImagenGanador.setIcon(new ImageIcon(Ganador.class.getResource("/Imagen/triunfo.gif")));
		ImagenGanador.setBounds(128, 117, 312, 272);
		getContentPane().add(ImagenGanador);
		
		//Label donde se imprime el puntaje obtenido hasta el momento de ganar
		JLabel SalidaPuntaje = new JLabel("Puntaje Obtenido:  "+String.valueOf(this.puntajeActual));
		SalidaPuntaje.setBounds(391, 13, 179, 16);
		getContentPane().add(SalidaPuntaje);
	}
}
