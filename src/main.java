import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
	
	private static String[][] usuarios = new String[30][10];
	//30 max de usuarios
    //5 sig que se guarda el nombre, contraseña, edad, profesión, ubicación
	private static int cont = 0;
	/*
	private static String csvProfe = "profesiones.csv";
	private static String separador = ",";
	private static String linea;
	*/
	
	
	public static void main(String[] arg) {
		
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
	}
	
	private static boolean existe(String nombre, String clave) {
		for(int i = 0; i < cont; i++) {
			if(usuarios[i][0].equals(nombre)&& usuarios[i][1].equals(clave)) {
				return true;
			}
		}
		return false;
	}
	
	private static void crear(String nombre, String clave, Scanner input) {
		
		String profesion = "";
		
		usuarios[cont][0] = nombre;
		usuarios[cont][1] = clave;
		
		System.out.println("Ingrese nombre de usuario:");
		usuarios[cont][2] = input.nextLine();
		System.out.println("Ingrese su edad:");
		usuarios[cont][3] = input.nextLine();
		System.out.println("Indique la Región donde vive: (seleccione el número correspondiente)");
		System.out.println("1. Region Tarapaca");
		System.out.println("2. Region Metropolitana");
		System.out.println("3. Region Valparaiso");
		System.out.println("4. Region Biobio");
		System.out.println("5. Region de Magallanes");
		
		usuarios[cont][4] = input.nextLine();
		
		System.out.println("Ingrese su profesión:");
        profesion = input.nextLine();
        usuarios[cont][5] = profesion;
        
        System.out.println("Ingrese una contraseña:");
		usuarios[cont][6] = input.nextLine();
		
        
        cont++;
		
		
		
	}
	
	
	
	
}
