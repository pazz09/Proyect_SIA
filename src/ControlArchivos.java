import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ControlArchivos {
	
	
	
	
	public static void guardar(List<Usuario> usuarios ) throws IOException {
		
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter("usuarios.csv"))){
			escritor.write("hola");
		}
		
	}

}
