import java.util.ArrayList;
import java.util.List;

public class Solicitudes {
	private List<Empresa> ofertasT;
	private List<Usuario> puesto;
	
	
	public Solicitudes(){
		ofertasT=new ArrayList<>();
		puesto= new ArrayList<>();
	}
	public void agregarOfertaE(Empresa oferta) {
        ofertasT.add(oferta);
    }
	public void agregarOfertaT(Usuario oferta) {
        puesto.add(oferta);
    }
}
