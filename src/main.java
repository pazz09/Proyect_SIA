
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
public class main {
	
	
	private static HashMap<String,Usuario> mapaUsuarios = new HashMap<String, Usuario>();
	private static HashMap<String, Trabajo> mapaTrabajos = new HashMap<String, Trabajo>();
	
	
	public static void main(String[] arg) throws IOException{

		int ingresado; // Variable que se va modificando para la visualizacion del menu
		Scanner input = new Scanner(System.in);
		String nombre=null;
		String respuesta;
		Usuario a = null;
		
		// Seccion Lectura CSV
		CSV archivo = new CSV();
		archivo.leerArchivo(System.getProperty("user.dir") + "\\src\\Archivos\\Trabajos.csv",mapaTrabajos);
		archivo.leerArchivo1(System.getProperty("user.dir") + "\\src\\Archivos\\usuarios.csv",mapaUsuarios);
		//aqui tiene que ir una lectura de csv de los usuarios ya creados
		// Fin Lectura CSV
		
		
		
		
		System.out.println("--> BOLSA DE TRABAJO ONLINE CHILENA <--");
		System.out.println(" ");
		System.out.println("INICIO DE SESIÓN");
		a = iniciarSesion(mapaUsuarios,input);

		System.out.println("\n-----> BIENVENID@ A LA BOLSA DE TRABAJO ONLINE <-----\n");
		System.out.println("Se sugiere que todas las respuestas que\ningrese sean en minuscula y sin tilde.\nLa ñ == n \n");
		
		while (true) {
		    System.out.println("-----> MENU <-----");
		    System.out.println("1. Buscar Trabajo ------> (Postulante)");
		    System.out.println("2. Publicar Trabajo ----> (Empresa)");
		    System.out.println("0. Salir");

		    ingresado = Integer.parseInt(input.nextLine());

		    switch (ingresado) {
		        case 1:
		            if (a == null) {
		                System.out.println("¡¡Para buscar trabajo necesita iniciar sesion!!\n");
		                a = iniciarSesion(mapaUsuarios, input);
		            }

		            System.out.println("Indique la opción que le gustaría mostrar:");
		            System.out.println("1. Trabajos disponibles");
		            System.out.println("2. Trabajos recomendados");
		            System.out.println("3. Trabajos a los que postulaste");
		            System.out.println("4. Trabajos cercanos a tu ubicación");

		            ingresado = Integer.parseInt(input.nextLine());

		            switch (ingresado) {
		                case 1:
		                    int i = 1;
		                    for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
		                        System.out.println("Trabajo n° " + i + ":");
		                        entry.getValue().mostrarTrabajo();
		                        i++;
		                    }

		                    System.out.println("Le gustaria postular a algun trabajo (si/no)");

		                    if (input.nextLine().equals("si")) {
		                        String n = input.nextLine();
		                        mapaTrabajos.get(n).manipularPostulantes(mapaUsuarios.get(nombre));
		                        mapaTrabajos.get(n).Mostrar_postulantes();
		                    }

		                    System.out.println("¿Te gustaría volver al menu principal? (si/no)");
		                    respuesta = input.nextLine();

		                    if (respuesta.equals("no")) {
		                        System.out.println("ADIOS!!");
		                        break;
		                    }

		                    break;

		                case 2:
		                    System.out.println("El programa te mostrara los puestos de trabajos que coinciden con tus estudios y datos personales");
		                    mostrarTrabajo(a, mapaTrabajos);
		                    ingresado = -1;
		                    break;

		                case 3:
		                    System.out.println("ESTOS SON LOS TRABAJOS A LOS QUE HAS POSTULADO");

		                    for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
		                        entry.getValue().buscarPostulante(nombre);
		                    }

		                    System.out.println("¿Desea eliminar alguna postulacion? (si/no)");

		                    if (input.nextLine().equals("si")) {
		                        System.out.println("Ingrese el nombre del trabajo del cual quiere remover su postulacion");
		                        mapaTrabajos.get(input.nextLine()).manipularPostulantes(nombre);
		                    }

		                    break;

		                case 4:
		                    System.out.println("Se muestan todos los trabajos cercanos");
		                    mostrarTrabajo(a.getUbicacion(), mapaTrabajos);
		                    break;

		                default:
		                    System.out.println("Opción inválida");
		                    break;
		            }

		            break;

		        case 2:
		            crear(input, mapaTrabajos);
		            break;

		        case 0:
		            archivo.exportar(mapaUsuarios);
		            archivo.exportarT(mapaTrabajos);
		            break;

		        default:
		            System.out.println("Opción inválida");
		            break;
		    }

		    if (ingresado == 0) {
		        break;
		    }
		}
		

	}
	
	private static boolean existe(String nombre, HashMap<String,Usuario> mapaUsuarios) {
		Usuario a = null;
		a = mapaUsuarios.get(nombre);
		
		if (a == null) {
			return false;
		}else {
			return true;
		}
		
	}
	
// Crea Trabajo
	private static void crear(Scanner input, HashMap<String,Trabajo> aux) {

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
        aux.put(key,auxTrabajo);


    }

	
	private static Usuario iniciarSesion(HashMap<String,Usuario> mapaUsuarios,Scanner input){
		String aux;
		Usuario auxUsuario = new Usuario();
		System.out.println("Ingrese nombre de usuario: ");
		aux = input.nextLine();
		if (!existe(aux,mapaUsuarios)) {
			System.out.println("---> Cuenta invalida <---");
			System.out.println("¿Desea Crear una cuenta nueva?  (si|no)");
			aux = input.nextLine();
			if (aux.contentEquals("si")){
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
				}else {
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
				return iniciarSesion(mapaUsuarios,input);
			}else return null;
			
		}else{
			System.out.println("Ingrese contraseña");
			if (input.nextLine().contentEquals(mapaUsuarios.get(aux).getClave())) {
				return(mapaUsuarios.get(aux));
			}else return iniciarSesion(mapaUsuarios,input);
		}
		
		
	}
	
	private static void mostrarTrabajo(Usuario usuario,HashMap<String,Trabajo> mapaTrabajos) {
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
	
	private static void mostrarTrabajo(String ubicacion,HashMap<String,Trabajo> mapaTrabajos) {
		Trabajo trabajo= new Trabajo();
		for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
		    trabajo = entry.getValue();
		    if (trabajo.getRegion().contentEquals(ubicacion)) {
		    	trabajo.mostrarTrabajo();
		    }
		    
		}
	}
	
	
}
