import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaUsuario {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JTextField txtEdad;
	private JTextField txtRut;
	private JComboBox<String> comboRegion;
	private JTextField txtProfesion;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario window = new VentanaUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CREAR USUARIO");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Nombre de usuario:");
		lblUsuario.setBounds(87, 24, 119, 14);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(205, 22, 177, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(87, 54, 77, 14);
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(205, 52, 177, 20);
		panel.add(txtPassword);
		
		JLabel lblEdades = new JLabel("Edades:");
		lblEdades.setBounds(87, 84, 46, 14);
		panel.add(lblEdades);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(205, 112, 177, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		
		JLabel lblRut = new JLabel("Rut:");
		lblRut.setBounds(87, 114, 46, 14);
		panel.add(lblRut);
		
		txtRut = new JTextField();
		txtRut.setBounds(205, 142, 177, 20);
		panel.add(txtRut);
		txtRut.setColumns(10);
		
		JLabel lblRegion = new JLabel("Región:");
		lblRegion.setBounds(87, 178, 46, 14);
		panel.add(lblRegion);

		
		comboRegion = new JComboBox<String>();
		comboRegion.setBounds(205, 175, 177, 20);
		comboRegion.setModel(new DefaultComboBoxModel<String>(
		        new String[] { "Arica y Parinacota", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso",
		                "Metropolitana de Santiago", "Libertador General Bernardo O'Higgins", "Maule", "Ñuble", "Biobío", "Araucanía", "Los Ríos", "Los Lagos", "Aysén del General Carlos Ibáñez del Campo", "Magallanes y de la Antártica Chilena" }
		));
		panel.add(comboRegion);
		
		textField = new JTextField();
		textField.setBounds(205, 82, 177, 20);
		panel.add(textField);
		textField.setColumns(10);
	}
}
