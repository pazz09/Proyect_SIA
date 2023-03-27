import java.util.ArrayList;
import java.util.List;

public class solicitudes {
	private List<empresa> ofertasT;
	private List<usuarios> puesto;
	
	
	public solicitudes(){
		ofertasT=new ArrayList<>();
		puesto= new ArrayList<>();
	}
	public void agregarOfertaE(empresa oferta) {
        ofertasT.add(oferta);
    }
	public void agregarOfertaT(usuarios oferta) {
        puesto.add(oferta);
    }
}
