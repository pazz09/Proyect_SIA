import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class VentanaUsuario extends Ventana1{

	private JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JTextField txtEdad;
	private JTextField txtRut;
	private JComboBox<String> comboRegion;
	private JTextField txtProfesion;
	private JTextField txtTitulo ;
	private JLabel lblTitulo;
	private JTextField textNombreT;
	private JTextField textyears;
	private JTextField textSueldo;
	private JButton closeButton;
	
	

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
		lblUsuario.setBounds(76, 10, 119, 14);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(205, 9, 177, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(119, 34, 77, 14);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(205, 33, 177, 20);
		panel.add(txtPassword);
		
		JLabel lblEdades = new JLabel("Edad:");
		lblEdades.setBounds(161, 50, 46, 26);
		lblEdades.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblEdades);
		
		txtEdad= new JTextField();
		txtEdad.setBounds(205, 55, 177, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
			
		JLabel lblRut = new JLabel("Rut:");
		lblRut.setBounds(161, 73, 56, 26);
		lblRut.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblRut);
		
		txtRut = new JTextField();
		txtRut.setBounds(205, 78, 177, 20);
		panel.add(txtRut);
		txtRut.setColumns(10);
		
		JLabel lblRegion = new JLabel("Región:");
		lblRegion.setBounds(150, 101, 77, 31);
		lblRegion.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblRegion);

		
		comboRegion = new JComboBox<String>();
		comboRegion.setBounds(205, 107, 177, 20);
		comboRegion.setModel(new DefaultComboBoxModel<String>(
		        new String[] { "Arica y Parinacota", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso",
		                "Metropolitana de Santiago", "Libertador General Bernardo O'Higgins", "Maule", "Ñuble", "Biobío", "Araucanía", "Los Ríos", "Los Lagos", "Aysén del General Carlos Ibáñez del Campo", "Magallanes y de la Antártica Chilena" }
		));
		panel.add(comboRegion);
		

		lblTitulo = new JLabel("¿Posee un Título Profesional?");
		lblTitulo.setBounds(16, 133, 191, 18);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblTitulo);
		
		JRadioButton rdbtnTitulo = new JRadioButton("SI");
		rdbtnTitulo.setBounds(205, 133, 56, 21);
		panel.add(rdbtnTitulo);
		
		JRadioButton rdbtnTitulo_1 = new JRadioButton("NO");
		rdbtnTitulo_1.setBounds(266, 133, 56, 21);
		panel.add(rdbtnTitulo_1);
		
		JLabel lblNombreT = new JLabel("Nombre de la Profesion:");
		lblNombreT.setBounds(51, 161, 162, 13);
        lblNombreT.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(lblNombreT);
        
        textNombreT = new JTextField();
        textNombreT.setBounds(205, 161, 177, 19);
        panel.add(textNombreT);
        textNombreT.setColumns(10);
        
        JLabel lblyears = new JLabel("Años de experiencia:");
        lblyears.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblyears.setBounds(61, 186, 143, 13);
        panel.add(lblyears);
        
        textyears = new JTextField();
        textyears.setBounds(205, 184, 177, 19);
        panel.add(textyears);
        textyears.setColumns(10);
        
        JLabel lblSueldo = new JLabel("Sueldo mínimo aceptado:");
        lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSueldo.setBounds(35, 208, 161, 13);
        panel.add(lblSueldo);
        
        
        textSueldo = new JTextField();
        textSueldo.setBounds(205, 206, 177, 19);
        panel.add(textSueldo);
        textSueldo.setColumns(10);
        
        JButton btnFinal = new JButton("Finalizar");
        btnFinal.setBounds(176, 232, 85, 21);
        panel.add(btnFinal);
        

        

        btnFinal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    String nombre = txtUsuario.getText();
        	    int edad = txtEdad.getComponentCount();
        	    String clave = txtPassword.getText();
        	    String rut =  txtRut.getText();
        	    String ubicacion = comboRegion.getActionCommand();
        	    String titulo = txtTitulo.getText();
        	    int exp= (int) textyears.getComponentCount();
        	    int sueldo = (int) textSueldo.getComponentCount();
        	    
        	    try {
					bolsaGlobal.registrarse(nombre,edad,clave,rut,ubicacion,titulo,exp,sueldo);
				} catch (UsuarioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	    

        	    
        	    
        	}
        });
        


		// Agrega una etiqueta con la imagen de fondo
        ImageIcon imageIcon = new ImageIcon("src/Archivos/fondoUsuario2.jpg");
        Image image = imageIcon.getImage();
        Image modifiedImage = image.getScaledInstance(440, 272, java.awt.Image.SCALE_SMOOTH);
        ImageIcon modifiedImageIcon = new ImageIcon(modifiedImage);
        panel.setLayout(null);
        JLabel label = new JLabel(modifiedImageIcon);
        label.setBounds(0, -19, 440, 295);
        label.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label);
        

		
	}
	
	public JFrame getFrame() {
	    return frame;
	}
}
