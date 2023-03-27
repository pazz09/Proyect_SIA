
public class Empresa {
	
	private String puesto;
	private String nombre;
	private String area;
	private boolean exp;
	private int exp_nesesaria;
	
	public void set_expn(int exp) {
		this.exp_nesesaria=exp;
	}
	public int get_expn() {
		return exp_nesesaria;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String a) {
		this.nombre = a;
	}
	
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String a) {
		this.puesto = a;	
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String a) {
		this.area = a;
	}
	
	public boolean getexp() {
		return exp;
	}
	public void setexp(boolean a) {
		this.exp = a;
	}

}
