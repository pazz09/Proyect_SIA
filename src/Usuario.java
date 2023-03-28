
public class Usuario {
	private String nombre;
	private int edad;
	private String genero;
	private String clave;
	private String rut;
	private int ubicacion;
	private String profesion;
	private boolean posee_Titulo;
	private String exp;
	

	
	public void setUbicacion(int a) {
		this.ubicacion=a;
	}
	
	public int getUbicacion() {
		return ubicacion;
	}
	public void setEdad(int a) {
		this.edad=a;
	}
	
	public int getEdad() {
		return edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String a) {
		this.nombre = a;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String a) {
		this.exp = a;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String a) {
		this.genero = a;
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(String a) {
		this.clave = a;
	}
	
	public String getRut() {
		return rut;
	}
	public void setRut(String a) {
		this.rut = a;
	}
	
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String a) {
		this.profesion = a;
	}
	public boolean getposee() {
		return posee_Titulo;
	}
	public void setposee(boolean a) {
		this.posee_Titulo = a;
	}
	
	
}
