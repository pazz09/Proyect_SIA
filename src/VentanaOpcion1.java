import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaOpcion1 {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcion1 window = new VentanaOpcion1();
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
	public VentanaOpcion1() {
		
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
		frame.setTitle("MENÚ");
        

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 450, 300);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton btnDisponible = new JButton("Trabajos disponibles");
        btnDisponible.setBounds(101, 43, 233, 21);
        panel.add(btnDisponible);
        
        JButton btnRecom = new JButton("Trabajos recomendados");
        btnRecom.setBounds(101, 74, 233, 21);
        panel.add(btnRecom);
        
        JButton btnPostula = new JButton("Trabajos a los que postulaste");
        btnPostula.setBounds(101, 105, 233, 21);
        panel.add(btnPostula);
        
        JButton btnCercano = new JButton("Trabajos cercanos a tu ubicación");
        btnCercano.setBounds(101, 136, 233, 21);
        panel.add(btnCercano);
        
        JButton btnPosTrabajo = new JButton("Mostrar postulantes de un trabajo");
        btnPosTrabajo.setBounds(101, 167, 233, 21);
        panel.add(btnPosTrabajo);
        
        JButton btnDatos = new JButton("Editar datos de postulantes");
        btnDatos.setBounds(101, 198, 233, 21);
        panel.add(btnDatos);
        
        JButton btnFlecha = new JButton("<-");
        btnFlecha.setBounds(10, 238, 50, 21);
        panel.add(btnFlecha);
        
        
        JLabel lblNewLabel = new JLabel("MENÚ OPCIÓN 1");
        lblNewLabel.setBounds(178, 10, 134, 13);
        panel.add(lblNewLabel);
        
        
        btnCercano.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el 4to boton
        	}
        });
        btnPostula.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el 3er boton
        	}
        });
        btnRecom.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el 2do boton
        	}
        });
        btnDisponible.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el 1er boton
        	}
        });
        btnPosTrabajo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el botón de eliminar
        	}
        });
        btnDatos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el botón de editar
        	}
        });
        btnFlecha.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 VentanaMenu ventanaMenu = new VentanaMenu();

                 // Hace que la ventana actual se oculte
                 frame.setVisible(false);

                 // Muestra la ventana del menú principal
                 ventanaMenu.getFrame().setVisible(true);
        		
        		
        	}
        });
        
        
        
        
        
        

     // Agrega una etiqueta con la imagen de fondo
        ImageIcon imageIcon = new ImageIcon("src/Archivos/fondo_menu1.jpg");
        Image image = imageIcon.getImage();
        Image modifiedImage = image.getScaledInstance(panel.getWidth(), panel.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon modifiedImageIcon = new ImageIcon(modifiedImage);
        JLabel label = new JLabel(modifiedImageIcon);
        label.setBounds(0, 0, 440, 272);
        panel.add(label);
        

        
        
        
        
	}	
	
	public JFrame getFrame() {
	    return frame;
	}
}
