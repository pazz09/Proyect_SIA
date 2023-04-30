import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bolsa {

	private static HashMap<String,Usuario> mapaUsuarios = new HashMap<String, Usuario>();
	private static HashMap<String, Trabajo> mapaTrabajos = new HashMap<String, Trabajo>();
	
	public void IniciaBolsa() {
		CSV archivo = new CSV();
		archivo.leerArchivo(System.getProperty("user.dir") + "\\src\\Archivos\\Trabajos.csv",mapaTrabajos);
		archivo.leerArchivo1(System.getProperty("user.dir") + "\\src\\Archivos\\usuarios.csv",mapaUsuarios);
		
	}
	
	public static boolean existe(String nombre) {
		Usuario a = null;
		a = mapaUsuarios.get(nombre);
		
		if (a == null) {
			return false;
		}else {
			return true;
		}
		
	}
	
	// Crea Trabajo
	public Trabajo crear(Scanner input) {

        Trabajo auxTrabajo = new Trabajo();
        String a;
        String key;
        System.out.println("Indique el nombre del puesto de trabajo a solicitar:");
        key=input.nextLine();
        auxTrabajo.setNombre(key);
        System.out.println("Ingrese la region donde se realizara el trabajo:");
        auxTrabajo.setRegion((input.nextLine()));
        System.out.println("¿Requiere un  título Profesional?: (si/no)");
        a=input.nextLine();
        if (a.contentEquals("si")) {
            System.out.println("Ingrese titulo nesesario:");
            auxTrabajo.setTitulo(input.nextLine());
        }
        else auxTrabajo.setTitulo(null);

        System.out.println("¿Requiere experiencia previa?: (si/no)");
        a=input.nextLine();
        if (a.contentEquals("si")) {
            System.out.println("Cantidad de experiencia requerida en años:");
            auxTrabajo.setExp(Integer.parseInt(input.nextLine()));
        }
        else auxTrabajo.setExp(0);

        System.out.println("Ingrese el horario laboral:");
        auxTrabajo.setHorario(input.nextLine());        
        try {
        System.out.println("Ingrese el sueldo base a ofrecer:");
        auxTrabajo.setSueldo(Integer.parseInt(input.nextLine()));
        }catch(Exception e){
        	System.out.println("responda con numeros ");
        }
        System.out.println("Ingrese el número de vacantes:");
        auxTrabajo.setSueldo(Integer.parseInt(input.nextLine()));
        mapaTrabajos.put(auxTrabajo.getNombre(), auxTrabajo);
        return auxTrabajo;


    }

	
	public Usuario iniciarSesion(Scanner input) throws UsuarioException {
	    String aux;
	    Usuario auxUsuario = new Usuario();
	    System.out.println("Ingrese nombre de usuario: ");
	    aux = input.nextLine();
	    if (!existe(aux)) {
	        System.out.println("---> Cuenta invalida <---");
	        System.out.println("¿Desea Crear una cuenta nueva?  (si|no)");
	        aux = input.nextLine();
	        if (aux.contentEquals("si")) {
	            System.out.println("Ingrese nombre de usuario: ");
	            aux = input.nextLine();
	            auxUsuario.setNombre(aux);
	            System.out.println("Ingrese Contraseña: ");
	            aux = input.nextLine();
	            auxUsuario.setClave(aux);
	            System.out.println("Ingrese edad: ");
	            aux = input.nextLine();
	            auxUsuario.setEdad(Integer.parseInt(aux));
	            System.out.println("Ingrese RUT");
	            aux = input.nextLine();
	            auxUsuario.setRut(aux);
	            System.out.println("Indique la Región donde vive: (Ej: Valparaiso/Metropolitana/Atacama/etc.) Mayuscula la primera letra");
	            aux = input.nextLine();
	            auxUsuario.setUbicacion(aux);

	            System.out.println("¿Posee un Titulo Profesional? (si|no)");
	            aux = input.nextLine();
	            if (aux.contentEquals("si")) {
	                System.out.println("Indique el nombre de su Titulo Profesional");
	                aux = input.nextLine();
	                auxUsuario.setTitulo(aux);
	            } else {
	                auxUsuario.setTitulo("no posee");
	            }

	            System.out.println("Ingrese Años de experiencia");
	            aux = input.nextLine();
	            auxUsuario.setExp(Integer.parseInt(aux));
	            System.out.println("Ingrese sueldo mínimo aceptado");
	            aux = input.nextLine();
	            auxUsuario.setSueldo(Integer.parseInt(aux));

	            mapaUsuarios.put(auxUsuario.getNombre(), auxUsuario);
	            System.out.println("CUENTA CREADA CON ÉXITO!!");
	            System.out.println("");
	            return iniciarSesion(input);
	        } else {
	            return null;
	        }

	    } else {
	        System.out.println("Ingrese contraseña");
	        if (input.nextLine().contentEquals(mapaUsuarios.get(aux).getClave())) {
	            return (mapaUsuarios.get(aux));
	        } else {
	            return iniciarSesion(input);
	        }
	    }
	}
	
	
	public void mostrarTrabajo(Usuario usuario) {
		Trabajo trabajo= new Trabajo();
		int cont = 0;
		for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
		    trabajo = entry.getValue();
		    if (trabajo.getRegion().contentEquals(usuario.getUbicacion())){
		    	if (trabajo.getSueldo()>= usuario.getSueldo()) {
		    		if (trabajo.getTitulo().contentEquals(usuario.getTitulo()) || trabajo.getTitulo().contentEquals("no posee")) {
		    			if (trabajo.getExp()<=usuario.getExp()) {
		    				trabajo.mostrarTrabajo();
		    				cont++;
		    			}
		    		}	
		    	}
		    }
		}
		if (cont == 0) System.out.println("No se ha encontrado ningun trabajo que coincida con tus datos");
	}
	
	public void mostrarTrabajos(Scanner input, Usuario usuario) throws TrabajoException {
		int i = 0;
		for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
            System.out.println("Trabajo n° " + i + ":");
            entry.getValue().mostrarTrabajo();
            i++;
        }
		System.out.println("Le gustaria postular a algun trabajo (si/no)");

        if (input.nextLine().equals("si")) {
        	System.out.println("Ingrese el nombre del trabajo al cual desea postular:");
            String n = input.nextLine();
            mapaTrabajos.get(n).manipularPostulantes(mapaUsuarios.get(usuario.getNombre()));
           
        }
		
	}
	
	public void mostrarTrabajo(String ubicacion) {
		Trabajo trabajo= new Trabajo();
		for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
		    trabajo = entry.getValue();
		    if (trabajo.getRegion().contentEquals(ubicacion)) {
		    	trabajo.mostrarTrabajo();
		    }
		    
		}
	}
	public void Exportar() {
		CSV csv = new CSV();
		csv.exportar(mapaUsuarios);
		csv.exportarT(mapaTrabajos);
	}
	
	public void mostrarTrabajosPustulados(Usuario usuario,Scanner input) {
        System.out.println("ESTOS SON LOS TRABAJOS A LOS QUE HAS POSTULADO");
		for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
            entry.getValue().buscarPostulante(usuario.getNombre());
        }
		System.out.println("¿Desea eliminar alguna postulacion? (si/no)");

        if (input.nextLine().equals("si")) {
            System.out.println("Ingrese el nombre del trabajo del cual quiere remover su postulacion");
            mapaTrabajos.get(input.nextLine()).manipularPostulantes(usuario.getNombre());
        }
	}
	
	public void mostrarPostulantes(Scanner input) {
		String nombreTrabajo = input.nextLine();
		mapaTrabajos.get(nombreTrabajo).mostrarPostulantes();
	}
	public void editarPostulantes(Scanner input, Usuario usuario) throws UsuarioException {
		mostrarTrabajosPustulados(usuario, input);
		System.out.println("Ingrese el nombre del trabajo");
        String auxN= input.nextLine();
        System.out.println("Ingrese el nombre de la variable a modificar");
        String auxV= input.nextLine();
    	mapaTrabajos.get(auxN).editarPostulacion(usuario.getNombre(),auxV );
	}
	
	
	
}
