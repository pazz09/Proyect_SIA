
public class usuarios {
	private String nombre;
	private int edad;
	private String genero;
	private String correo;
	private String rut;
	private int exp;
	private String titulo;
	private boolean posee_Titulo;
	
	public void set_expt(int a) {
		this.exp=a;
	}
	
	public int get_expt() {
		return exp;
	}
	public void set_edad(int a) {
		this.edad=a;
	}
	
	public int get_edad() {
		return edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String a) {
		this.nombre = a;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String a) {
		this.genero = a;
	}
	
	public String getcorreo() {
		return correo;
	}
	public void setcorreo(String a) {
		this.correo = a;
	}
	
	public String getrut() {
		return rut;
	}
	public void setrut(String a) {
		this.rut = a;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String a) {
		this.titulo = a;
	}
	public boolean getposee() {
		return posee_Titulo;
	}
	public void setposee(boolean a) {
		this.posee_Titulo = a;
	}
	
	
}
