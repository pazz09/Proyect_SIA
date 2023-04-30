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

    public void setUbicacion(String a) throws UsuarioException {
        if (a.isEmpty()) {
            throw new UsuarioException("La ubicación no puede estar vacía");
        }
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

    public void setNombre(String a) throws UsuarioException {
        if (a.isEmpty()) {
            throw new UsuarioException("El nombre no puede estar vacío");
        }
        this.nombre = a;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int a) throws UsuarioException {
        if (a < 0) {
            throw new UsuarioException("La experiencia no puede ser negativa");
        }
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

    public void setRut(String a) throws UsuarioException {
        if (a.isEmpty()) {
            throw new UsuarioException("El RUT no puede estar vacío");
        }
        this.rut = a;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String a) throws UsuarioException {
        if (a.isEmpty()) {
            throw new UsuarioException("El título no puede estar vacío");
        }
        this.titulo= a;
    }
}
