import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaOpcion2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcion2 window = new VentanaOpcion2();
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
	public VentanaOpcion2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese los datos del trabajo a solicitar");
		lblNewLabel.setBounds(136, 10, 193, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del puesto a solicitar:");
		lblNewLabel_1.setBounds(53, 41, 155, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(233, 45, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ubicación:");
		lblNewLabel_2.setBounds(53, 84, 109, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 67, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("¿Requiere un título profesional?");
		lblNewLabel_3.setBounds(117, 113, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 90, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ingrese nombre de la profesión:");
		lblNewLabel_4.setBounds(117, 142, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(233, 113, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Experiencia previa en años:");
		lblNewLabel_5.setBounds(117, 174, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(233, 135, 96, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Horario laboral:");
		lblNewLabel_6.setBounds(117, 200, 45, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(233, 183, 96, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Sueldo base");
		lblNewLabel_7.setBounds(117, 223, 45, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(233, 212, 96, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Número de vacantes:");
		btnNewButton.setBounds(195, 242, 61, 21);
		frame.getContentPane().add(btnNewButton);
	}
	
	public JFrame getFrame() {
	    return frame;
	}
}
