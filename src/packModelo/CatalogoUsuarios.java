package packModelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import packExcepciones.FicheroNoEncontradoException;

public class CatalogoUsuarios {
	
	private static CatalogoUsuarios catalogo;
	private ListaUsuarios lUsuarios = new ListaUsuarios();
	
	private CatalogoUsuarios(){}
	
	public static CatalogoUsuarios getCatalogo(){
		if (catalogo==null){
			catalogo=new CatalogoUsuarios();
			
		}
		return catalogo;
	}
	
	public ListaUsuarios getLista(){
		return lUsuarios;
	}
	
	public void cargarFichero() throws FicheroNoEncontradoException{
		System.out.println("Cargando usuarios");
		try{
			File archivo = new File(".","src/Usuarios.txt");
			Scanner entrada = new Scanner(new FileReader(archivo));
			String linea;
			String[] tokens;
			Usuario usu;
			
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				tokens = linea.split("\\s+\\\\\\s+");
				usu=new Usuario(tokens[0],Integer.parseInt(tokens[1]));
				lUsuarios.addUsuario(usu);
			}
			entrada.close();
		} 
		catch(FileNotFoundException e){throw new FicheroNoEncontradoException();}
		catch(NullPointerException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		System.out.println("Fin carga\n");
	}
	
	public String mejores(){
		return CatalogoUsuarios.getCatalogo().getLista().mejores();

	}

}
