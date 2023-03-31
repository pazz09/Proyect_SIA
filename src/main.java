import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class main {
	
	private static String[][] usuarios = new String[30][10];
	private static HashMap<String,Usuario> mapaUsuarios = new HashMap<String, Usuario>();
	private static int cont = 0;
	private static HashMap<String, Trabajo> mapaTrabajos = new HashMap<String, Trabajo>();
	
	
	public static void main(String[] arg) throws IOException{

		
		
		
		int ingresado; // Variable que se va modificando para la visualizacion del menu
		Scanner input = new Scanner(System.in);
		String nombre=null;
		String clave;
		boolean correcto = false;
		String respuesta;
		Usuario a = null;
		Trabajo trabajo;
		
		// Seccion Lectura CSV
		CSV archivo = new CSV();
		archivo.leerArchivo("C:\\Users\\lukio\\Documents\\GitHub\\Proyect_SIA\\Trabajos.csv",mapaTrabajos);
		//aqui tiene que ir una lectura de csv de los usuarios ya creados
		// Fin Lectura CSV
		
		
		
		
		System.out.println("--> BOLSA DE TRABAJO ONLINE CHILENA <--");
		System.out.println(" ");
		System.out.println("INICIO DE SESIÓN");
		a = iniciarSesion(mapaUsuarios,input);
		/*
		while(! correcto) {
			System.out.println("Usuario: ");
			nombre = input.nextLine();
			System.out.println("Contraseña: ");
			clave = input.nextLine();
			
			if (existe(nombre,mapaUsuarios)) {
				System.out.println("HOLA "+ nombre);
				correcto = true;
			}
			else {
				System.out.println("--> CUENTA INVALIDA <--");
				System.out.println("Quieres crear una cuenta? (si/no)");
				respuesta = input.nextLine();
				
				if (respuesta.equals("si")) {
					crear(nombre, clave, input,mapaUsuarios); //input es algo que lei para que le entre a la función info adicional
					//ControlArchivos.guardar(listUsuarios);
					
					System.out.println("LISTO!, ya tienes una cuenta :)");
					System.out.println(" ");
					System.out.println("Vuelve a iniciar sesión");
					correcto = false;
				}
			}			
		}
		*/
		System.out.println("Bienvenid@ a la BOLSA DE TRABAJO ONLINE\n");
		System.out.println("-----> MENU <-----");
		while (true) {
			System.out.println("1. Buscar Trabajo ------> (Postulante)");
			System.out.println("2. Publicar Trabajo ----> (Empresa)");
			ingresado = Integer.parseInt(input.nextLine());
			
			if (ingresado == 1) {
				
				if (a == null) {
					System.out.println("¡¡Para buscar trabajo necesita iniciar sesion!!\n");
					a = iniciarSesion(mapaUsuarios,input); //para buscar trabajo necesita iniciar sesion
				}
				
				
				System.out.println("Indique la opción que le gustaría mostrar:");
				System.out.println("1. Trabajos disponibles");
				System.out.println("2. Trabajos recomendados");
				System.out.println("3. Trabajos a los que postulaste");
				System.out.println("4. Trabajos cercanos a tu ubicación");
				ingresado = Integer.parseInt(input.nextLine());
				
				if (ingresado == 1) {
					int i = 1;
					for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
						System.out.println("Trabajo n° "+i+":");
					    entry.getValue().mostrarTrabajos();
					    i++;
					}
					System.out.println("le gustaria postular a algun trabajo (si/no)");
					if(input.nextLine().contentEquals("si")) {
							String n=input.nextLine();
							mapaTrabajos.get(n).setPostulante(mapaUsuarios.get(nombre));
							mapaTrabajos.get(n).Mostrar_postulantes();
						
					}
					System.out.println("¿Te gustaría volver al menu principal? (si/no)");
					respuesta = input.nextLine();
					if (respuesta.equals("no")) {
						System.out.println("ADIOS!!");
						break;
					}
					
				}
				if (ingresado == 2) {
					System.out.println("El programa autoseleciono los puestos de trabajos que coinciden con tus estudios y los datos que nos proporcionaste: ");
					System.out.println("OPCIÓN EN DESARROLLO");
					break;
					
				}
				if (ingresado == 3) {
					System.out.println("OESTOS SON LOS TRABAJOS A LOS QUE HAS POSTULADO");
					for (Map.Entry<String, Trabajo> entry : mapaTrabajos.entrySet()) {
					    entry.getValue().buscarPostulante(nombre);
			
					}
					
				}
				if (ingresado == 4) {
					System.out.println("OPCIÓN EN DESARROLLO");
				}
				
				
			}
			if (ingresado == 2) {
				crear(input,mapaTrabajos);
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
	// Crea Usuario
	private static void crear(String nombre, String clave, Scanner input, HashMap<String,Usuario> aux) {

        Usuario auxUsuario = new Usuario();
        String a;
        System.out.println("Ingrese nombre de usuario:");
        auxUsuario.setNombre(input.nextLine());
        System.out.println("Ingrese su edad:");
        auxUsuario.setEdad(Integer.parseInt(input.nextLine()));
        System.out.println("Indique la Región donde vive:");
        auxUsuario.setUbicacion(input.nextLine());
        System.out.println("Ingrese su rut:");
        auxUsuario.setRut(input.nextLine());
        System.out.println("¿Posee un titulo Profesional?: (si/no)");
        a=input.nextLine();
        if (a.contentEquals("si")) {
            System.out.println("Ingrese su profesión:");
            auxUsuario.setTitulo(input.nextLine());
        }
        else auxUsuario.setTitulo(null);
        System.out.println("¿Posee experiencia?: (si/no)");
        a=input.nextLine();
        if (a.contentEquals("si")) {
            System.out.println("Cantidad de experiencia en años:");
            auxUsuario.setExp(Integer.parseInt(input.nextLine()));
        }
        else auxUsuario.setExp(0);
        System.out.println("Ingrese el sueldo esperado:");
         auxUsuario.setSueldo(Integer.parseInt(input.nextLine()));
        System.out.println("Ingrese una contraseña:");

        auxUsuario.setClave(input.nextLine());
        aux.put(auxUsuario.getNombre(),auxUsuario);


    }
// Crea Trabajo
	private static void crear(Scanner input, HashMap<String,Trabajo> aux) {

        Trabajo auxTrabajo = new Trabajo();
        String a;
        String key;
        System.out.println("Indique el nombre del puesto de trabajo a solicitar:");
        key=input.nextLine();
        auxTrabajo.setNombre(key);
        System.out.println("Ingrese la ciudad donde se realizara el trabajo:");
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
        System.out.println("Ingrese el sueldo base a ofrecer:");
        auxTrabajo.setSueldo(Integer.parseInt(input.nextLine()));
        System.out.println("Ingrese el número de vacantes:");
        auxTrabajo.setSueldo(Integer.parseInt(input.nextLine()));
        cont++;
        aux.put(key,auxTrabajo);


    }
	
	private static Usuario buscado(String nombre, HashMap<String,Usuario> mapaUsuarios ) {
		Usuario a = null;
		a = mapaUsuarios.get(nombre);
		return a;
	}
	
	private static Usuario iniciarSesion(HashMap<String,Usuario> mapaUsuarios,Scanner input){
		String aux;
		Usuario auxUsuario = new Usuario();
		System.out.println("ingrese nombre de Usuario: ");
		aux = input.nextLine();
		if (!existe(aux,mapaUsuarios)) {
			System.out.println("Cuenta Inexistente");
			System.out.println("¿Desea Crear una Cuenta nueva?  (si|no)");
			aux = input.nextLine();
			if (aux.contentEquals("si")){
				System.out.println("Ingrese Nombre de Usuario: ");
				aux = input.nextLine();
				auxUsuario.setNombre(aux);
				System.out.println("Ingrese Clave: ");
				aux = input.nextLine();
				auxUsuario.setClave(aux);
				System.out.println("Ingrese edad: ");
				aux = input.nextLine();
				auxUsuario.setEdad(Integer.parseInt(aux));
				System.out.println("Ingrese RUT");
				aux = input.nextLine();
				auxUsuario.setRut(aux);
				System.out.println("Ingrese Region");
				aux = input.nextLine();
				auxUsuario.setUbicacion(aux);
				
				System.out.println("¿Posee un titulo? (si|no)");
				aux = input.nextLine();
				if (aux.contentEquals("si")) {
					System.out.println("Ingrese Titulo");
					aux = input.nextLine();
					auxUsuario.setTitulo(aux);
				}else {
					auxUsuario.setTitulo("no posee");
				}
				
				System.out.println("Ingrese Años de experiencia");
				aux = input.nextLine();
				auxUsuario.setExp(Integer.parseInt(aux));
				System.out.println("Ingrese sueldo minimo aceptado");
				aux = input.nextLine();
				auxUsuario.setSueldo(Integer.parseInt(aux));
				
				mapaUsuarios.put(auxUsuario.getNombre(), auxUsuario);
				System.out.println("CUENTA CREADA CON EXITO!!");
				System.out.println("");
				return iniciarSesion(mapaUsuarios,input);
			}else return null;
			
		}else{
			System.out.println("Ingres contraseña");
			if (input.nextLine().contentEquals(mapaUsuarios.get(aux).getClave())) {
				return(mapaUsuarios.get(aux));
			}else return iniciarSesion(mapaUsuarios,input);
		}
		
		
	}
	
	/*
	private static Usuario buscado1(String n, List<Usuario> listUsuarios ) {
		Usuario a=null;
		for (int i=0;i<listUsuarios.size();i++) {
			if(listUsuarios.get(i).getNombre().contentEquals(n)) {
				a=listUsuarios.get(i);
				break;
			}
		}
		
		return a;
	}
	*/
}
