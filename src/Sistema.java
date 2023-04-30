import java.io.IOException;
import java.util.Scanner;

public class Sistema {
	public static void main(String[] arg) throws IOException, UsuarioException, TrabajoException{
		
		int ingresado;
		Scanner input = new Scanner(System.in);
		Usuario usuario = null;
		Trabajo trabajo = new Trabajo();
		Bolsa bolsa = new Bolsa();
		bolsa.IniciaBolsa();
		
		
		System.out.println("--> BOLSA DE TRABAJO ONLINE CHILENA <--");
		System.out.println(" ");
		System.out.println("INICIO DE SESIÓN");
		usuario = bolsa.iniciarSesion(input);
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
		    		if (usuario == null) {
		    			System.out.println("¡¡Para buscar trabajo necesita iniciar sesion!!\n");
		                usuario = bolsa.iniciarSesion( input);
		    		}
		    		System.out.println("Indique la opción que le gustaría mostrar:");
		            System.out.println("1. Trabajos disponibles");
		            System.out.println("2. Trabajos recomendados");
		            System.out.println("3. Trabajos a los que postulaste");
		            System.out.println("4. Trabajos cercanos a tu ubicación");
		            System.out.println("5. Mostrar postulantes de un trabajo");
		            System.out.println("6. Editar datos de tus postulaciones");
		            ingresado = Integer.parseInt(input.nextLine());
		            
		            switch (ingresado) {
		            case 1: //motrar trabajos disponibles
		            	bolsa.mostrarTrabajos();
		            	break;
		            case 2: //mostrar trabajos recomendados
		            	bolsa.mostrarTrabajo(usuario);
		            	break;
		            case 3: //Trabajos a los que postulaste
		            	bolsa.mostrarTrabajosPustulados(usuario,input);
		            	break;
		            case 4: //Trabajos cercanos a tu ubicacion
		            	bolsa.mostrarTrabajo(usuario.getUbicacion());
		            	break;
		            case 5: //Mostrar postulantes de un Trabajo
		            	bolsa.mostrarPostulantes(input);
		            	break;
		            case 6: //Editar datos de los pustulantes??
		            	
		            	break;
		            default:
	                    System.out.println("Opción inválida");
	                    break;
		            }
		            break;
		    	case 2:
		    		//se retorna trabajo porque se le puede dar un uso posterior
		    		trabajo = bolsa.crear(input);
		    		break;
		    	case 0:
		    		bolsa.Exportar();
		    		break;
		    	default:
		    		System.out.println("Opción inválida");
		            break;
		        
		    }
		    
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
