public class Usuario {
    private String nombre;
    private int edad;
    private String clave;
    private String rut;
    private String ubicacion;
    private String titulo;
    private int exp;
    private int sueldo;


    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setUbicacion(String a) {
        this.ubicacion=a;
    }

    public String getUbicacion() {
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
    public int getExp() {
        return exp;
    }
    public void setExp(int a) {
        this.exp = a;
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

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String a) {
        this.titulo= a;
    }



}