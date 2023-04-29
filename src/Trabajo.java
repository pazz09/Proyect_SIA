import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class Trabajo {
	
	private String nombre;
	private String region;
	private int sueldo;
	private String horario;
	private int vacantes;
	private int exp;
	private String titulo;
	private List<Usuario> listPostulantes = new ArrayList();
	
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void mostrarTrabajo() {
		System.out.println("Nombre: "+ this.getNombre());
		System.out.println("Ubicación: "+ this.getRegion());
		System.out.println("Sueldo base: "+ this.getSueldo());
		System.out.println("Horario: "+ this.getHorario());
		System.out.println("Vacantes: "+ this.getVacantes());
		System.out.println("Experiencia necesaria: "+ this.getExp()+" años");
		System.out.println("Título "+ this.getTitulo());
		System.out.println("");
	}


	public void manipularPostulantes(Usuario a) {
	    try {
	        Scanner input = new Scanner(System.in);

	        // Se comprueba que existan vacantes disponibles
	        if (this.vacantes <= 0) {
	            System.out.println("No hay vacantes disponibles");
	            return;
	        }

	        // Se comprueba si se requiere título o experiencia
	        if (!cumpleRequisitos(a)) {
	            System.out.println("No cumples los requisitos para este trabajo");
	            return;
	        }

	        // Se pide confirmación para postularse si no se cumple con la experiencia requerida
	        if (this.titulo == null || this.titulo.equals("No posee")) {
	            if (a.getExp() < this.exp) {
	                if (!confirmarPostulacion()) {
	                    System.out.println("Postulación cancelada");
	                    return;
	                }
	            }
	        }

	        // Se agrega el usuario a la lista de postulantes y se decrementa la cantidad de vacantes
	        this.listPostulantes.add(a);
	        System.out.println("Postulación exitosa");
	        this.vacantes--;
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	private boolean cumpleRequisitos(Usuario a) {
	    if (this.titulo == null || this.titulo.equals("No posee")) {
	        return a.getExp() >= this.exp || this.exp == 0;
	    } else {
	        return a.getTitulo().equals(this.titulo) && a.getExp() >= this.exp;
	    }
	}

	private boolean confirmarPostulacion() {
	    Scanner input = new Scanner(System.in);
	    System.out.println("No posees la experiencia requerida ¿Aún quieres continuar? (si/no)");
	    String respuesta = input.nextLine();
	    return respuesta.equalsIgnoreCase("si");
	}
	public void manipularPostulantes(String nombre) {
	    try {
	        boolean found = false;
	        for (int i = 0; i < this.listPostulantes.size(); i++) {
	            if (this.listPostulantes.get(i).getNombre().contentEquals(nombre)) {
	                this.listPostulantes.remove(i);
	                System.out.println("Postulacion removida");
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            throw new Exception("No se encontró ninguna postulación con el nombre proporcionado.");
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	public void mostrarPostulantes() {
	    try {
	        for (int i = 0; i < this.listPostulantes.size(); i++) {
	            System.out.println(this.listPostulantes.get(i).getNombre() + "\n");
	        }
	    } catch (Exception e) {
	        System.out.println("Error al mostrar los postulantes: " + e.getMessage());
	    }
	}
	public void buscarPostulante(String n) {
		for (int i=0;i<this.listPostulantes.size();i++) {
			if(this.listPostulantes.get(i).getNombre().contentEquals(n)) {
				System.out.println(this.nombre);
			}
		}
		
	}
	public void editarPostulacion(String nombre, String b) {
	    Scanner input = new Scanner(System.in);
	    for (int i = 0; i < this.listPostulantes.size(); i++) {
	        if (this.listPostulantes.get(i).getNombre().contentEquals(nombre)) {
	            switch(b) {
	                case "nombre":
	                    System.out.println("Ingrese el nuevo valor de la variable 'nombre': ");
	                    listPostulantes.get(i).setNombre(input.nextLine());
	                    System.out.println("Cambio realizado con exito");
	                    break;
	                case "edad":
	                    System.out.println("Ingrese el nuevo valor de la variable 'edad': ");
	                    listPostulantes.get(i).setEdad(Integer.parseInt(input.nextLine()));
	                    System.out.println("Cambio realizado con exito");
	                    break;
	                case "clave":
	                    System.out.println("Ingrese el nuevo valor de la variable 'clave': ");
	                    listPostulantes.get(i).setClave(input.nextLine());
	                    System.out.println("Cambio realizado con exito");
	                    break;
	                case "rut":
	                    System.out.println("Ingrese el nuevo valor de la variable 'rut': ");
	                    listPostulantes.get(i).setRut(input.nextLine());
	                    System.out.println("Cambio realizado con exito");
	                    break;
	                case "ubicacion":
	                    System.out.println("Ingrese el nuevo valor de la variable 'ubicacion': ");
	                    listPostulantes.get(i).setUbicacion(input.nextLine());
	                    System.out.println("Cambio realizado con exito");
	                    break;
	                case "titulo":
	                    System.out.println("Ingrese el nuevo valor de la variable 'titulo': ");
	                    listPostulantes.get(i).setTitulo(input.nextLine());
	                    System.out.println("Cambio realizado con exito");
	                    break;
	                case "exp":
	                    System.out.println("Ingrese el nuevo valor de la variable 'exp': ");
	                    listPostulantes.get(i).setExp(input.nextInt());
	                    System.out.println("Cambio realizado con exito");
	                    break;
	                case "sueldo":
	                    System.out.println("Ingrese el nuevo valor de la variable 'sueldo': ");
	                    listPostulantes.get(i).setSueldo(input.nextInt());
	                    System.out.println("Cambio realizado con exito");
	                    break;
	                default:
	                    System.out.println("Variable no encontrada");
	                    break;
	            }
	        }
	    }
	}
}
