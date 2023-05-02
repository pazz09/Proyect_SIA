import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class VentanaUsuario {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JTextField txtEdad;
	private JTextField txtRut;
	private JComboBox<String> comboRegion;
	private JTextField txtProfesion;
	private JTextField txtTitulo ;
	private JLabel lblTitulo;
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
		lblUsuario.setBounds(76, 23, 119, 14);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(205, 22, 177, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(120, 53, 77, 14);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(205, 52, 177, 20);
		panel.add(txtPassword);
		
		JLabel lblEdades = new JLabel("Edad:");
		lblEdades.setBounds(161, 77, 46, 26);
		lblEdades.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblEdades);
		
		txtEdad= new JTextField();
		txtEdad.setBounds(205, 82, 177, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
			
		JLabel lblRut = new JLabel("Rut:");
		lblRut.setBounds(161, 107, 56, 26);
		lblRut.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblRut);
		
		txtRut = new JTextField();
		txtRut.setBounds(205, 112, 177, 20);
		panel.add(txtRut);
		txtRut.setColumns(10);
		
		JLabel lblRegion = new JLabel("Región:");
		lblRegion.setBounds(148, 136, 77, 31);
		lblRegion.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblRegion);

		
		comboRegion = new JComboBox<String>();
		comboRegion.setBounds(205, 142, 177, 20);
		comboRegion.setModel(new DefaultComboBoxModel<String>(
		        new String[] { "Arica y Parinacota", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso",
		                "Metropolitana de Santiago", "Libertador General Bernardo O'Higgins", "Maule", "Ñuble", "Biobío", "Araucanía", "Los Ríos", "Los Lagos", "Aysén del General Carlos Ibáñez del Campo", "Magallanes y de la Antártica Chilena" }
		));
		panel.add(comboRegion);
		

		lblTitulo = new JLabel("¿Posee un Título Profesional?");
		lblTitulo.setBounds(16, 176, 191, 18);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblTitulo);
		
		JRadioButton rdbtnTitulo = new JRadioButton("SI");
		rdbtnTitulo.setBounds(205, 176, 56, 21);
		panel.add(rdbtnTitulo);
		
		JRadioButton rdbtnTitulo_1 = new JRadioButton("NO");
		rdbtnTitulo_1.setBounds(277, 176, 56, 21);
		panel.add(rdbtnTitulo_1);
		
		JLabel lblNombreT = new JLabel("Nombre de la Profesion:");
		lblNombreT.setBounds(47, 215, 162, 13);
        lblNombreT.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(lblNombreT);
        
        textField = new JTextField();
        textField.setBounds(205, 213, 177, 19);
        panel.add(textField);
        textField.setColumns(10);
        
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 9));
        btnSiguiente.setBounds(234, 242, 100, 15);
        panel.add(btnSiguiente);
		
        btnSiguiente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		VentanaUsuario2 ventanaUsuario2 = new VentanaUsuario2();

                // Hace que la ventana actual se oculte
                frame.setVisible(false);

                // Muestra la ventana del menú principal
                ventanaUsuario2.getFrame().setVisible(true);
        	}
        });
        
        
        
        
        
        
        
        
        
        
        

		// Agrega una etiqueta con la imagen de fondo
        ImageIcon imageIcon = new ImageIcon("src/Archivos/fondoUsuario2.jpg");
        Image image = imageIcon.getImage();
        Image modifiedImage = image.getScaledInstance(440, 272, java.awt.Image.SCALE_SMOOTH);
        ImageIcon modifiedImageIcon = new ImageIcon(modifiedImage);
        panel.setLayout(null);
        JLabel label = new JLabel(modifiedImageIcon);
        label.setBounds(0, 0, 440, 272);
        panel.add(label);
        
        
       
		

		
	}
	
	public JFrame getFrame() {
	    return frame;
	}
}
