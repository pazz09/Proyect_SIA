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
        
        
        JButton btnIniciarSesion = new JButton("INICIAR");
        
        btnIniciarSesion.setBounds(299, 153, 95, 25);
        frmBolsaDeTrabajo.getContentPane().add(btnIniciarSesion);
        
        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crea una instancia de la ventana del menú principal
                VentanaMenu ventanaMenu = new VentanaMenu();

                // Hace que la ventana actual se oculte
                frmBolsaDeTrabajo.setVisible(false);

                // Muestra la ventana del menú principal
                ventanaMenu.getFrame().setVisible(true);
            }
        });

        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(0, 0, 450, 300);
        frmBolsaDeTrabajo.getContentPane().add(panel);

        // Agrega una etiqueta con la imagen de fondo
        ImageIcon imageIcon = new ImageIcon("src/Archivos/fondoInicio1.jpg");
        Image image = imageIcon.getImage();
        Image modifiedImage = image.getScaledInstance(panel.getWidth(), panel.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon modifiedImageIcon = new ImageIcon(modifiedImage);
        JLabel label = new JLabel(modifiedImageIcon);
        panel.add(label, BorderLayout.CENTER);
		
	}

	// Getter público para frame
	public JFrame getFrame() {
		return frmBolsaDeTrabajo;
	}
}