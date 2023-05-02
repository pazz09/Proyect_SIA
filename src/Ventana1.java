import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Ventana1 {

	private JFrame frmBolsaDeTrabajo;
	public JTextField textFieldUsuario;
    public JTextField textFieldContraseña;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 window = new Ventana1();
					window.getFrame().setVisible(true); // Accede a la variable frame a través del getter
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBolsaDeTrabajo = new JFrame();
		frmBolsaDeTrabajo.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		frmBolsaDeTrabajo.setBounds(100, 100, 450, 300);
		frmBolsaDeTrabajo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBolsaDeTrabajo.getContentPane().setLayout(null);
		frmBolsaDeTrabajo.setTitle("BOLSA DE TRABAJO ONLINE");
			
		JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(200, 50, 59, 15);
        frmBolsaDeTrabajo.getContentPane().add(lblUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(284, 48, 129, 19);
        frmBolsaDeTrabajo.getContentPane().add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(200, 100, 76, 15);
        frmBolsaDeTrabajo.getContentPane().add(lblPassword);

        textFieldContraseña = new JTextField();
        textFieldContraseña.setBounds(284, 98, 129, 19);
        frmBolsaDeTrabajo.getContentPane().add(textFieldContraseña);
        textFieldContraseña.setColumns(10);
     
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 450, 300);
        frmBolsaDeTrabajo.getContentPane().add(panel);
        
        
        JButton btnRegistro = new JButton("REGISTRARTE");
        btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 9));
        btnRegistro.setBounds(201, 153, 108, 25);
        panel.add(btnRegistro);
        
        
        JButton btnIniciarSesion = new JButton("INICIAR");
        btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 9));
        btnIniciarSesion.setBounds(319, 153, 109, 25);
        panel.add(btnIniciarSesion);
        
        JLabel lblNewLabel = new JLabel("!BIENVENIDO!");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(251, 10, 101, 19);
        panel.add(lblNewLabel);
        
        
        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Bolsa bolsa = new Bolsa();
            	bolsa.IniciaBolsa();
            	
            	if(bolsa.iniciarSesion(textFieldUsuario.getText(), textFieldContraseña.getText())) {
                    // Crea una instancia de la ventana del menú principal
                    VentanaMenu ventanaMenu = new VentanaMenu();
                    ventanaMenu.getFrame().setVisible(true);
                }
            	
            	
            	
            	
                // Crea una instancia de la ventana del menú principal
                //VentanaMenu ventanaMenu = new VentanaMenu();

                // Hace que la ventana actual se oculte
                //frmBolsaDeTrabajo.setVisible(false);

                // Muestra la ventana del menú principal
                //ventanaMenu.getFrame().setVisible(true);
            }
        });
        
        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	VentanaUsuario ventanaUsuario = new VentanaUsuario();

                // Hace que la ventana actual se oculte
                frmBolsaDeTrabajo.setVisible(false);

                // Muestra la ventana del menú principal
                ventanaUsuario.getFrame().setVisible(true);
            	
            	
            	
            }
        });
        	

        // Agrega una etiqueta con la imagen de fondo
        ImageIcon imageIcon = new ImageIcon("src/Archivos/fondoInicio1.jpg");
        Image image = imageIcon.getImage();
        Image modifiedImage = image.getScaledInstance(panel.getWidth(), panel.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon modifiedImageIcon = new ImageIcon(modifiedImage);
        panel.setLayout(null);
        
        JLabel label = new JLabel(modifiedImageIcon);
        label.setBounds(0, 0, 450, 300);
        panel.add(label);
        
        
        
      
		
	}

	// Getter público para frame
	public JFrame getFrame() {
		return frmBolsaDeTrabajo;
	}
}