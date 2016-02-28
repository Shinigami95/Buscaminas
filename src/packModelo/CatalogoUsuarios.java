package packModelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
			File archivo = new File(".","Usuarios.txt");
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
	
	public void guardarFichero() {
		System.out.println("Guardando usuarios...");
		Usuario uAux;
		String linea;
		FileWriter fw = null;
		PrintWriter pw = null;
		Iterator<Usuario> itr = CatalogoUsuarios.getCatalogo().getLista().getUsuarios();
		try {
			File archivo = new File(".","Usuarios.txt");
			archivo.createNewFile();
			fw = new FileWriter("Usuarios.txt");
			pw = new PrintWriter(fw);
			while (itr.hasNext()){
				uAux = itr.next();
				linea = uAux.toStringParaFichero();
				pw.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR, no es un path correcto.");
		} catch (IOException e) {
			System.out.println("ERROR, no se ha leido bien la linea.");
		} finally {
			try {
				if( fw != null ){
					fw.close();
				}
				if( pw != null ){
					pw.close();
				}
			} catch (IOException e2){
				e2.printStackTrace();
			}
		}
		System.out.println("Archivo guardado.");
	}
	
	public String mejores(){
		return CatalogoUsuarios.getCatalogo().getLista().mejores();

	}

}
