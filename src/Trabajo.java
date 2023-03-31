import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public void mostrarTrabajos() {
		System.out.println("Nombre: "+ this.getNombre());
		System.out.println("Ubicación: "+ this.getRegion());
		System.out.println("Sueldo base: "+ this.getSueldo());
		System.out.println("Horario: "+ this.getHorario());
		System.out.println("Vacantes: "+ this.getVacantes());
		System.out.println("Experiencia necesaria: "+ this.getExp()+" años");
		System.out.println("Título "+ this.getTitulo());
		System.out.println("");
	}

	public void setPostulante(Usuario a) {
        Scanner input = new Scanner(System.in);
        if(this.titulo==null) {
            if(a.getExp()>=this.exp) {
                this.listPostulantes.add(a);
                System.out.println("Postulacion exitosa");
            }
            else if (a.getExp()<this.exp) {
                System.out.println("No posees la experiencia requerida ¿Aun quiere continuar?(si/no)");
                String aux=input.nextLine();
                if(aux.contentEquals("si"));{
                    this.listPostulantes.add(a);
                    System.out.println("Postulacion exitosa");
                }
                if(aux.contentEquals("si")==false) {
                    System.out.println("entendido postulacion cancelada");
                }

            }
        }
        else if(a.getTitulo().contentEquals(this.titulo)) {
            if(a.getExp()>=this.exp) {
                this.listPostulantes.add(a);
                System.out.println("Postulacion exitosa");
            }
            else {
                System.out.println("No posees la experiencia requerida ¿Aun quiere continuar?(si/no)");
                String aux=input.nextLine();
                if(aux.contentEquals("si"));{
                    this.listPostulantes.add(a);
                    System.out.println("Postulacion exitosa");
                }
                if(aux.contentEquals("si")==false) {
                    System.out.println("entendido postulacion cancelada");
                }
            }
        }
        else {
            System.out.println("No posees el titulo nesesario");
        }

    }
	public void Mostrar_postulantes() {
		for (int i=0;i<this.listPostulantes.size();i++) {
			System.out.println(this.listPostulantes.get(i).getNombre()+"\n");
		}
	}
	public void eliminarPostulante(String nombre) {
        for (int i=0;i<this.listPostulantes.size();i++) {
            if(this.listPostulantes.get(i).getNombre().contentEquals(nombre)) {
                this.listPostulantes.remove(i);
                System.out.println("postulacion removida");
            }
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
