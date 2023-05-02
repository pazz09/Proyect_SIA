import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaUsuario2 {

	private JFrame frame;
	private JTextField txtYears;
	private JTextField txtSueldo;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario2 window = new VentanaUsuario2();
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
	public VentanaUsuario2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblYears = new JLabel("Años de experiencia:");
		lblYears.setBounds(64, 96, 148, 14);
		lblYears.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblYears);
		
		txtYears = new JTextField();
		txtYears.setBounds(205, 95, 177, 20);
		panel.add(txtYears);
		
		JLabel lblSueldo = new JLabel("Sueldo mínimo aceptado:");
		lblSueldo.setBounds(36, 120, 172, 26);
		lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblSueldo);
		
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(205, 125, 177, 20);
		panel.add(txtSueldo);
		
		lblNewLabel = new JLabel("¡ Ingrese los números sin puntos ni comas !");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(90, 57, 292, 13);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("TERMINAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
        btnNewButton.setBounds(149, 207, 116, 21);
        panel.add(btnNewButton);
		
		
        
        
        
        
        
        
        
        
		
		// Agrega una etiqueta con la imagen de fondo
        ImageIcon imageIcon = new ImageIcon("src/Archivos/fondoUsuario2.jpg");
        Image image = imageIcon.getImage();
        Image modifiedImage = image.getScaledInstance(440, 272, java.awt.Image.SCALE_SMOOTH);
        ImageIcon modifiedImageIcon = new ImageIcon(modifiedImage);
        panel.setLayout(null);
        JLabel label = new JLabel(modifiedImageIcon);
        label.setBounds(0, 0, 440, 272);
        panel.add(label);
        
        btnNewButton = new JButton("New button");
        btnNewButton.setBounds(173, 207, 85, 21);
        panel.add(btnNewButton);
		
		
		
		
		
		
		
		
		
	}
	
	public JFrame getFrame() {
	    return frame;
	}

}
