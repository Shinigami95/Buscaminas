package packMain;

import packExcepciones.FicheroNoEncontradoException;
import packModelo.CatalogoUsuarios;
import packVentanas.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		try {
			CatalogoUsuarios.getCatalogo().cargarFichero();
		} catch (FicheroNoEncontradoException e) {
			e.printStackTrace();
		}
		VentanaPrincipal.getVentana().setVisible(true);
	}
}
