import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Opciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int tamaño;

	/**
	 * Create the application.
	 */
	//COnstructor
	public Opciones() {
		setBackground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Opciones.class.getResource("/Imagen/2048.png")));
		setTitle("\u00A12048 GAME!");
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
		
		//Label donde se escribe Tamaño de Tablero
		JLabel opciones = new JLabel("Tama\u00F1o de Tablero");
		opciones.setForeground(Color.DARK_GRAY);
		opciones.setFont(new Font("Arial", Font.PLAIN, 26));
		opciones.setBounds(178, 11, 233, 55);
		getContentPane().add(opciones);
		
		//Boton con la opcion del tablero 4x4
		JButton botonExperto = new JButton("   4 x 4");
		botonExperto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tamaño=4;
				setVisible(false);
				Interface2048 int2048= new Interface2048();
				int2048.setVisible(true);
				
			}
		});
		botonExperto.setForeground(Color.DARK_GRAY);
		botonExperto.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botonExperto.setBackground(Color.LIGHT_GRAY);
		botonExperto.setBounds(210, 91, 157, 50);
		ImageIcon oro=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/oro.png"));
		botonExperto.setIcon(new ImageIcon(oro.getImage().getScaledInstance(botonExperto.getHeight()-5,botonExperto.getHeight()-5,Image.SCALE_SMOOTH)));
		getContentPane().add(botonExperto);
		
		//Boton con la opcion del tablero 6x6
		JButton botonIntermedio = new JButton("   6 x 6");
		botonIntermedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tamaño=6;
				setVisible(false);
				
				Interface2048 int2048= new Interface2048();
				int2048.setVisible(true);
			}
		});
		botonIntermedio.setForeground(Color.DARK_GRAY);
		botonIntermedio.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botonIntermedio.setBackground(Color.LIGHT_GRAY);
		botonIntermedio.setBounds(210, 152, 157, 50);
		ImageIcon plata=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/plata.png"));
		botonIntermedio.setIcon(new ImageIcon(plata.getImage().getScaledInstance(botonIntermedio.getHeight()-5,botonIntermedio.getHeight()-5,Image.SCALE_SMOOTH)));
		getContentPane().add(botonIntermedio);
		
		//Boton con la opcion del tablero 8x8
		JButton botonNovato = new JButton("   8 x 8");
		botonNovato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tamaño=8;
				setVisible(false);
				Interface2048 int2048= new Interface2048();
				int2048.setVisible(true);
				
			}
		});
		botonNovato.setForeground(Color.DARK_GRAY);
		botonNovato.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botonNovato.setBackground(Color.LIGHT_GRAY);
		botonNovato.setBounds(210, 213, 157, 50);
		ImageIcon bronce=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/bronce.png"));
		botonNovato.setIcon(new ImageIcon(bronce.getImage().getScaledInstance(botonNovato.getHeight()-5,botonNovato.getHeight()-5,Image.SCALE_SMOOTH)));
		getContentPane().add(botonNovato);

		//Boton con la opcion volver a la interfaz inicial
		JButton btnVolver = new JButton("   Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				InterfaceInicio intf=new InterfaceInicio();
				intf.setLocationRelativeTo(null);
				intf.setVisible(true);
						
			}
		});
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(210, 308, 157, 50);
		ImageIcon volver=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/volver.png"));
		btnVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(btnVolver.getHeight()-5,btnVolver.getHeight()-5,Image.SCALE_SMOOTH)));
		
		getContentPane().add(btnVolver);
	}
	
	public int tamaño() {
		return tamaño;
	}
}
