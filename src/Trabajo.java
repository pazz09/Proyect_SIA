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
	    Scanner input = new Scanner(System.in);
	    try {
	        //Se comprueba que existan vacantes disponibles
	        if (this.vacantes <= 0) {
	            System.out.println("No hay vacantes disponibles");
	            return;
	        }

	        //En caso de existir vacantes se comprueba la experiencia necesaria

	        //este if comprueba si no se requiere titulo
	        if (this.titulo == null || this.titulo.equals("No posee")) {
	            // comprueba si se requiere experiencia 
	            if (a.getExp() >= this.exp || this.exp == 0) {
	                this.listPostulantes.add(a);
	                System.out.println("Postulacion exitosa");
	                this.vacantes--;
	                return;
	            } else {
	                System.out.println("No posees la experiencia requerida ¿Aun quieres continuar? (si/no)");
	                String aux = input.nextLine();
	                if (aux.equals("si")) {
	                    this.listPostulantes.add(a);
	                    System.out.println("Postulacion exitosa");
	                    this.vacantes--;
	                    return;
	                } else {
	                    System.out.println("Postulacion cancelada");
	                    return;
	                }
	            }
	        }
	        //Comprueba si se posee el titulo necesario
	        if (a.getTitulo().contentEquals(this.titulo)) {
	            if (a.getExp() >= this.exp) {
	                this.listPostulantes.add(a);
	                System.out.println("Postulacion exitosa");
	                this.vacantes -= 1;
	                return;
	            } else {
	                System.out.println("No posees la experiencia requerida ¿Aun quieres continuar? (si/no)");
	                String aux = input.nextLine();
	                if (aux.equals("si")) {
	                    this.listPostulantes.add(a);
	                    System.out.println("Postulacion exitosa");
	                    this.vacantes--;
	                    return;
	                } else {
	                    System.out.println("Postulacion cancelada");
	                    return;
	                }
	            }
	        }
	        //en caso de no poseer el titulo necesario para el trabajo se manda el siguiente mensaje
	        else {
	            System.out.println("No posees el titulo necesario para postular a este trabajo");
	            return;
	        }
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error: " + e.getMessage());
	        e.printStackTrace();
	    }
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
	
	
	
	
	
}
