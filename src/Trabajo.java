import java.util.ArrayList;
import java.util.List;

public class Trabajo {
	
	private String nombre;
	private String region;
	private int sueldo;
	private String horario;
	private int vacantes;
	private int exp;
	private String titulo;
	
	
	
	
	
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
	
	
	private static List<Usuario> listPostulantes = new ArrayList();
	
	
	
	
	public void setPostulante(Usuario a) {
		this.listPostulantes.add(a);
	}
	
	public void Mostrar_postulantes() {
		for (int i=0;i<this.listPostulantes.size();i++) {
			System.out.println(this.listPostulantes.get(i).getNombre()+"\n");
		}
	}

	
	
	
	
	
}
