import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import java.awt.Toolkit;

public class Perdedor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int puntajeActual;
	/**
	 * Create the application.
	 */
	//Constructor de la interfaz
	public Perdedor(int puntaje) {
		this.puntajeActual=puntaje;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Perdedor.class.getResource("/Imagen/2048.png")));
		setBackground(Color.ORANGE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Tamaño de la ventana
		setBounds(100, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//Label donde se escribe PERDISTE
		JLabel perdiste = new JLabel("\u00A1PERDISTE!");
		perdiste.setFont(new Font("Eras Demi ITC", Font.BOLD, 33));
		perdiste.setBackground(new Color(173, 255, 47));
		perdiste.setBounds(176, 58, 198, 62);
		getContentPane().add(perdiste);
		
		//Boton para volver a la interfaz Opciones
		JButton botonVolver = new JButton("VOLVER");
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Opciones op= new Opciones();
				op.setLocationRelativeTo(null);
				op.setVisible(true);
				setVisible(false);
			}
		});
		botonVolver.setForeground(Color.DARK_GRAY);
		botonVolver.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botonVolver.setBackground(Color.LIGHT_GRAY);
		botonVolver.setBounds(193, 393, 157, 50);
		ImageIcon volver=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/volver.png"));
		botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getHeight()-5,botonVolver.getHeight()-5,Image.SCALE_SMOOTH)));
		getContentPane().add(botonVolver);
		
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
		botonSalir.setBounds(193, 472, 157, 50);
		ImageIcon salir=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/exit.png"));
		botonSalir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(botonSalir.getHeight()-10,botonSalir.getHeight()-10,Image.SCALE_SMOOTH)));
		getContentPane().add(botonSalir);
		
		//Label donde contiene un gif
		JLabel imagenPerder = new JLabel("");
		imagenPerder.setIcon(new ImageIcon(Perdedor.class.getResource("/Imagen/llora1.gif")));
		imagenPerder.setBounds(176, 112, 260, 260);
		getContentPane().add(imagenPerder);
		
		//Label donde se imprime el puntaje obtenido hasta el momento de perder
		JLabel SalidaPuntaje = new JLabel("Puntaje Obtenido:  "+String.valueOf(this.puntajeActual));
		SalidaPuntaje.setBounds(391, 13, 179, 16);
		getContentPane().add(SalidaPuntaje);
		
	}
}
