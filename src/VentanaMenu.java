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
import java.awt.Font;

public class VentanaMenu {

	private JFrame frame;
	private VentanaOpcion1 ventanaMenu;

	
	
	
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
       
        
        // Crea los botones y los agrega al panel de botones
        JButton btnBuscar = new JButton("Buscar Trabajo");
        btnBuscar.setBounds(121, 126, 190, 21);
        panel.add(btnBuscar);
        
        
        JButton btnPublicar = new JButton("Publicar Trabajo");
        btnPublicar.setBounds(121, 157, 190, 21);
        panel.add(btnPublicar);
        

        
        JLabel lblNewLabel = new JLabel("MENÚ PRINCIPAL");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(156, 71, 134, 13);
        panel.add(lblNewLabel);
        
        btnPublicar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		VentanaOpcion2 ventanaOpcion2 = new VentanaOpcion2();

                // Hace que la ventana actual se oculte
                frame.setVisible(false);

                // Muestra la ventana del menú principal
                ventanaOpcion2.getFrame().setVisible(true);
        		

        		
        		
        	}
        });
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		 // Crea una instancia de la ventana del menú principal
                VentanaOpcion1 ventanaOpcion1 = new VentanaOpcion1();

                // Hace que la ventana actual se oculte
                frame.setVisible(false);

                // Muestra la ventana del menú principal
                ventanaOpcion1.getFrame().setVisible(true);
        		
        		
        		
        		
        		
        		
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
