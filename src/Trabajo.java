import java.util.ArrayList;
import java.util.List;

public class Trabajo {
	private String nombre;
	private boolean titulo;
	private String T_nesesario;
	private boolean exp;
	private String ubicacion;
	private String area;
	private String horario;
	private static List<Usuario> listPostulantes = new ArrayList();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getT_nesesario() {
		return T_nesesario;
	}
	public void setT_nesesario(String nombre) {
		this.T_nesesario = nombre;
	}
	public boolean getTitulo() {
		return titulo;
	}
	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}
	public boolean getExp() {
		return exp;
	}
	public void setExp(boolean exp) {
		this.exp = exp;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	public void setPostulante(Usuario a) {
		this.listPostulantes.add(a);
	}
	
	public void Mostrar_postulantes() {
		for (int i=0;i<this.listPostulantes.size();i++) {
			System.out.println(this.listPostulantes.get(i).getNombre()+"\n");
		}
	}
	
	public void mostrarTrabajos(){
		System.out.println(this.getNombre());
		System.out.println(this.getTitulo());
		System.out.println(this.getT_nesesario());
		System.out.println(this.getExp());
		System.out.println(this.getUbicacion());
		System.out.println(this.getArea());
		System.out.println(this.getHorario());
	}
	
	
}
