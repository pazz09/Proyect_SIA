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

public class VentanaMenu {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu window = new VentanaMenu();
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
	public VentanaMenu() {
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
        
        JButton btnAgregar = new JButton("Agregar Trabajo");
        btnAgregar.setBounds(121, 94, 190, 21);
        panel.add(btnAgregar);
        
        // Crea los botones y los agrega al panel de botones
        JButton btnBuscar = new JButton("Buscar Trabajo");
        btnBuscar.setBounds(121, 126, 190, 21);
        panel.add(btnBuscar);
        
        
        JButton btnEditar = new JButton("Editar Trabajo");
        btnEditar.setBounds(121, 157, 190, 21);
        panel.add(btnEditar);
        
        JButton btnEliminar = new JButton("Eliminar Trabajo");
        btnEliminar.setBounds(121, 188, 190, 21);
        panel.add(btnEliminar);
        
        JLabel lblNewLabel = new JLabel("MENÚ PRINCIPAL");
        lblNewLabel.setBounds(169, 45, 134, 13);
        panel.add(lblNewLabel);
        btnEliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el botón de eliminar
        	}
        });
        btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el botón de editar
        	}
        });
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el botón de buscar
        	}
        });
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Acciones a realizar cuando se presione el botón de agregar
        	}
        });
        
     // Agrega una etiqueta con la imagen de fondo
        ImageIcon imageIcon = new ImageIcon("src/Archivos/fondo_menu1.jpg");
        Image image = imageIcon.getImage();
        Image modifiedImage = image.getScaledInstance(panel.getWidth(), panel.getHeight(), java.awt.Image.SCALE_SMOOTH);
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
