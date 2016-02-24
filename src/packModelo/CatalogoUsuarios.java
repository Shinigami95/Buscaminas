package packModelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import packExcepciones.FicheroNoEncontradoException;

public class CatalogoUsuarios {
	
	private static CatalogoUsuarios catalogo;
	
	private CatalogoUsuarios(){}
	
	public static CatalogoUsuarios getCatalogo(){
		if (catalogo==null){
			catalogo=new CatalogoUsuarios();
		}
		return catalogo;
	}
	
	public void cargarFichero() throws FicheroNoEncontradoException{
		System.out.println("Cargando usuarios");
		try{
			File archivo = new File(".","Usuarios.txt");
			Scanner entrada = new Scanner(new FileReader(archivo));
			
			String linea;
			String[] tokens;
			
			ListaUsuarios lUsuarios = new ListaUsuarios();
			Usuario usu;
			
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				tokens = linea.split("\\s+\\\\\\s+");
				usu=new Usuario(tokens[1],Integer.parseInt(tokens[2]));
				lUsuarios.addUsuario(usu);
			}
			entrada.close();
		} 
		catch(FileNotFoundException e){throw new FicheroNoEncontradoException();}
		catch(NullPointerException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		System.out.println("Fin carga\n");
	}

}
