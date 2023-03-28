import java.util.ArrayList;
import java.util.List;

public class Trabajo {
	private String nombre;
	private boolean titulo;
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
	public boolean isTitulo() {
		return titulo;
	}
	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}
	public boolean isExp() {
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
}
