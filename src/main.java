import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class main {
	
	private static String[][] usuarios = new String[30][10];
	private static List<Usuario> listUsuarios = new ArrayList();
	private static int cont = 0;
	private static List<Trabajo> listTrabajos = new ArrayList();
	
	public static void main(String[] arg) throws IOException{
		
		int ingresado; // Variable que se va modificando para la visualizacion del menu
		Scanner input = new Scanner(System.in);
		String nombre;
		String clave;
		boolean correcto = false;
		String respuesta;
		Usuario a;
		Trabajo trabajo;
		System.out.println("--> BOLSA DE TRABAJO ONLINE CHILENA <--");
		System.out.println(" ");
		System.out.println("INICIO DE SESIÓN");
		
		while(! correcto) {
			System.out.println("Usuario: ");
			nombre = input.nextLine();
			System.out.println("Contraseña: ");
			clave = input.nextLine();
			
			if (existe(nombre, clave)) {
				System.out.println("¡Bienvenido! "+ nombre);
				correcto = true;
			}
			else {
				System.out.println("--> CUENTA INVALIDA <--");
				System.out.println("Quieres crear una cuenta? (si/no)");
				respuesta = input.nextLine();
				
				if (respuesta.equals("si")) {
					crear(nombre, clave, input,listUsuarios); //input es algo que lei para que le entre a la función info adicional
					ControlArchivos.guardar(listUsuarios);
					
					System.out.println("LISTO!, ya tienes una cuenta :)");
					System.out.println(" ");
					System.out.println("Vuelve a iniciar sesión");
					correcto = false;
				}
			}			
		}
		
		System.out.println("Bienvenido a la BOLSA DE TRABAJO ONLINE\n");
		System.out.println("Este programa te AUTOSELECCIONARA los trabajos que coincidan con tus descripciones y estudios");
		while (true) {
			System.out.println("1. Buscar Trabajo");
			System.out.println("2. Publicar Trabajo");
			ingresado = Integer.parseInt(input.nextLine());
			
			if (ingresado == 1) {
				System.out.println("1. Mostrar todos los trabajos");
				System.out.println("2. Mostrar trabajos recomendados");
				System.out.println("3. Mostrar trabajos a los que postulaste");
				System.out.println("4. Mostrar trabajos cercanos");
				
				if (ingresado == 1) {
					
				}
				
			}
			
			if (ingresado == 2) {
				crear(input,listTrabajos);
			}
		}
		

	}
	
	private static boolean existe(String nombre, String clave) {
		for(int i = 0; i < cont; i++) {
			if(listUsuarios.get(i).getNombre().equals(nombre)&& listUsuarios.get(i).getClave().equals(clave)) {
				return true;
			}
		}
		return false;
	}
	// Crea Usuario
	private static void crear(String nombre, String clave, Scanner input, List aux) {
		
		Usuario auxUsuario = new Usuario();
		String a;
		System.out.println("Ingrese nombre de usuario:");
		auxUsuario.setNombre(input.nextLine());
		System.out.println("Ingrese su edad:");
		auxUsuario.setEdad(Integer.parseInt(input.nextLine()));
		System.out.println("Indique la Región donde vive: (seleccione el número correspondiente)");
		
		for(String region : Ubicacion.getListaRegiones()) {
			System.out.println(region);
		}
		auxUsuario.setUbicacion(Integer.parseInt(input.nextLine()));
		System.out.println("¿Posee un titulo Profesional?: (si/no)");
		a=input.nextLine();
		if (a.contentEquals("si")) {
			auxUsuario.setposee(true);
		}
		else auxUsuario.setposee(false);
		if(auxUsuario.getposee()==true) {
			System.out.println("Ingrese su profesión:");
			auxUsuario.setProfesion(input.nextLine());
		}
		else {
			System.out.println("¿En que area posee experiencia laboral?:");
			auxUsuario.setProfesion(input.nextLine());
		}
        
        System.out.println("Ingrese una contraseña:");
        auxUsuario.setClave(input.nextLine());
		
        
        cont++;
		aux.add(auxUsuario);
		
		
	}
// Crea Trabajo
	private static void crear(Scanner input, List aux) {
			
		Trabajo auxUsuario = new Trabajo();
		String a;
		System.out.println("Ingrese nombre de Trabajo:");
		auxUsuario.setNombre(input.nextLine());
		System.out.println("Ingrese el area de rubro:");
		auxUsuario.setArea((input.nextLine()));
		System.out.println("Indique la Región donde vive: (seleccione el número correspondiente)");
		
		for(String region : Ubicacion.getListaRegiones()) {
			System.out.println(region);
		}
		//auxUsuario.setUbicacion(Integer.parseInt(input.nextLine()));
		System.out.println("¿Requiere un  titulo Profesional?: (si/no)");
		a=input.nextLine();
		if (a.contentEquals("si")) {
			auxUsuario.setTitulo(true);
		}
		else auxUsuario.setTitulo(false);
		if(auxUsuario.getTitulo()==true) {
			System.out.println("Ingrese titulo nesesario:");
			auxUsuario.setT_nesesario(input.nextLine());
		}
		else {
			auxUsuario.setT_nesesario(null);
		}
		System.out.println("¿Requiere experiencia previa?: (si/no)");
		a=input.nextLine();
		if (a.contentEquals("si")) {
			auxUsuario.setExp(true);
		}
		else auxUsuario.setExp(false);
		
        System.out.println("Ingrese el horario laboral:");
        auxUsuario.setHorario(input.nextLine());
		
        
        cont++;
		aux.add(auxUsuario);
			
		
	}
	
	
	
	
}
