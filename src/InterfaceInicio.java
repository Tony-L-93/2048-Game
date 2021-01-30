import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class InterfaceInicio extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	//Constructor
	public InterfaceInicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceInicio.class.getResource("/Imagen/2048.png")));
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Tamaño vetana
		setBackground(Color.ORANGE);
		setTitle("\u00A12048 GAME!");
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Label donde se escribe Bienvenidos a 2048
		JLabel lblBienvenidosA = new JLabel("   \u00A1Bienvenidos a 2048!");
		lblBienvenidosA.setFont(new Font("Arial", Font.PLAIN, 26));
		lblBienvenidosA.setForeground(Color.DARK_GRAY);
		lblBienvenidosA.setBounds(135, 11, 263, 60);
		getContentPane().add(lblBienvenidosA);
		
		//Boton con la opcion jugar donde se abre la interfaz Opciones
		JButton btnJugar = new JButton("   JUGAR");
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Opciones op= new Opciones();
				op.setLocationRelativeTo(null);
				op.setVisible(true);
				setVisible(false);
			}
		});
		btnJugar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnJugar.setBackground(Color.LIGHT_GRAY);
		btnJugar.setForeground(Color.DARK_GRAY);
		btnJugar.setBounds(35, 475, 157, 50);
		ImageIcon jugar=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/play.png"));
		btnJugar.setIcon(new ImageIcon(jugar.getImage().getScaledInstance(btnJugar.getHeight()-10,btnJugar.getHeight()-10,Image.SCALE_SMOOTH)));
		getContentPane().add(btnJugar);
		
		//Boton con la opcion salir
		JButton btnSalir = new JButton("    SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnSalir.setBounds(371, 475, 157, 50);
		ImageIcon salir=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/exit.png"));
		btnSalir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(btnSalir.getHeight()-10,btnSalir.getHeight()-10,Image.SCALE_SMOOTH)));
		btnSalir.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnSalir);
	 
		//Label que contiene una imagen
		 JLabel lblNewLabel = new JLabel("");
		 ImageIcon fondo=new ImageIcon(InterfaceInicio.class.getResource("/Imagen/2048.png"));
		 lblNewLabel.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(400,400, Image.SCALE_SMOOTH)));
		 lblNewLabel.setBounds(81, 62, 400, 400);
		 getContentPane().add(lblNewLabel);
	}
}
