import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class CSV {
	private BufferedReader lector;
	private String linea;
	private String partes[]=null;
	
	
	public void leerArchivo(String nombreArchivo,HashMap<String,Trabajo> mapaTrabajos) {
		
		try {
			lector= new BufferedReader(new FileReader(nombreArchivo)); 
			while((linea=lector.readLine())!=null) {
				
				partes=linea.split(";");
				imprimirLinea(mapaTrabajos);
				//se agregan en la lista
				
				
				//System.out.println("Evento agregado");
				
			}
			lector.close();
			linea=null;
			partes=null;
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	

	
	public void imprimirLinea(HashMap<String,Trabajo> mapaTrabajos){
		Trabajo obj = new Trabajo();
		obj.setNombre(partes[0]);
		obj.setRegion(partes[1]);
		obj.setSueldo(Integer.parseInt(partes[2]));
		obj.setHorario(partes[3]);
		obj.setVacantes(Integer.parseInt(partes[4]));
		obj.setExp(Integer.parseInt(partes[5]));
		obj.setTitulo(partes[6]);
		mapaTrabajos.put(obj.getNombre(), obj);
		
		for(int i=0; i<partes.length;i++) {
			System.out.println(partes[i]);
		}
		
		
		
	}
	
}
