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
	
	
	public static void main(String[] arg) {
		
		
		ControlArchivos.guardar(listUsuarios);
		
		
		
		Scanner input = new Scanner(System.in);
		String nombre;
		String clave;
		boolean correcto = false;
		String respuesta;
		
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
					crear(nombre, clave, input); //input es algo que lei para que le entre a la función info adicional
					System.out.println("LISTO!, ya tienes una cuenta :)");
					System.out.println(" ");
					System.out.println("Vuelve a iniciar sesión");
					correcto = false;
				}
			}			
		}
		
		ControlArchivos.guardar(listaUsuarios);
		
		
		
	}
	
	private static boolean existe(String nombre, String clave) {
		for(int i = 0; i < cont; i++) {
			if(listUsuarios.get(i).getNombre().equals(nombre)&& listUsuarios.get(i).getClave().equals(clave)) {
				return true;
			}
		}
		return false;
	}
	
	private static void crear(String nombre, String clave, Scanner input) {
		
		Usuario auxUsuario = new Usuario();
		String profesion = "";
		
		System.out.println("Ingrese nombre de usuario:");
		auxUsuario.setNombre(input.nextLine());
		System.out.println("Ingrese su edad:");
		auxUsuario.setEdad(Integer.parseInt(input.nextLine()));
		System.out.println("Indique la Región donde vive: (seleccione el número correspondiente)");
		
		for(String region : Ubicacion.getListaRegiones()) {
			System.out.println(region);
		}
		
		
		
		
		
		
		
		usuarios[cont][4] = input.nextLine();
		
		System.out.println("Ingrese su profesión:");
        profesion = input.nextLine();
        usuarios[cont][5] = profesion;
        
        System.out.println("Ingrese una contraseña:");
		usuarios[cont][6] = input.nextLine();
		
        
        cont++;
		
		
		
	}
	
	
	
	
}
