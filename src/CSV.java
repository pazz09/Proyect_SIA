import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;


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
	public void leerArchivo1(String nombreArchivo,HashMap<String,Usuario> mapaUsuarios) {
		
		try {
			lector= new BufferedReader(new FileReader(nombreArchivo)); 
			while((linea=lector.readLine())!=null) {
				
				partes=linea.split(";");
				imprimirLinea1(mapaUsuarios);
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
	

	public void imprimirLinea1(HashMap<String,Usuario> mapaUsuarios) throws  UsuarioException{
		Usuario obj = new Usuario();
		obj.setNombre(partes[0]);
		obj.setEdad(Integer.parseInt(partes[1]));
		obj.setClave(partes[2]);
		obj.setRut(partes[3]);
		obj.setUbicacion(partes[4]);
		obj.setTitulo(partes[5]);
		obj.setExp(Integer.parseInt(partes[6]));
		obj.setSueldo(Integer.parseInt(partes[7]));
		mapaUsuarios.put(obj.getNombre(), obj);
		
		/*
		for(int i=0; i<partes.length;i++) {
			System.out.println(partes[i]);
		}
		*/
		
		
	}
	public void exportar(HashMap<String,Usuario>mapaUsuarios) {
        try {
            FileWriter csvWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\Archivos\\usuarios.csv");

            for (HashMap.Entry<String, Usuario> entry : mapaUsuarios.entrySet()) {
                String key = entry.getKey();
                csvWriter.append(mapaUsuarios.get(key).getNombre());
                csvWriter.append(";");
                csvWriter.append(mapaUsuarios.get(key).getEdad()+"");
                csvWriter.append(";");
                csvWriter.append(mapaUsuarios.get(key).getClave());
                csvWriter.append(";");
                csvWriter.append(mapaUsuarios.get(key).getRut());
                csvWriter.append(";");
                csvWriter.append(mapaUsuarios.get(key).getUbicacion());
                csvWriter.append(";");
                csvWriter.append(mapaUsuarios.get(key).getTitulo());
                csvWriter.append(";");
                csvWriter.append(mapaUsuarios.get(key).getExp()+"");
                csvWriter.append(";");
                csvWriter.append(mapaUsuarios.get(key).getSueldo()+"");
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }catch (IOException e) {
            System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
        }
    }
	
	public void exportarT(HashMap<String,Trabajo> mapaTrabajos) {
        try {
            FileWriter csvWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\Archivos\\Trabajos.csv");

            for (HashMap.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
                String key = entry.getKey();
                csvWriter.append(mapaTrabajos.get(key).getNombre());
                csvWriter.append(";");
                csvWriter.append(mapaTrabajos.get(key).getRegion());
                csvWriter.append(";");
                csvWriter.append(mapaTrabajos.get(key).getSueldo()+"");
                csvWriter.append(";");
                csvWriter.append(mapaTrabajos.get(key).getHorario());
                csvWriter.append(";");
                csvWriter.append(mapaTrabajos.get(key).getVacantes()+"");
                csvWriter.append(";");
                csvWriter.append(mapaTrabajos.get(key).getExp()+"");
                csvWriter.append(";");
                csvWriter.append(mapaTrabajos.get(key).getTitulo());
                csvWriter.append("\n");


            }
            csvWriter.flush();
            csvWriter.close();
        }catch (IOException e) {
            System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
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
		
		/*
		for(int i=0; i<partes.length;i++) {
			System.out.println(partes[i]);
		}
		*/
		
		
	}
	
	
}
