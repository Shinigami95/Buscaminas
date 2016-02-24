package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaUsuarios {
	
	private ArrayList<Usuario> lista;
	
	public ListaUsuarios(){
		lista=new ArrayList<Usuario>();
	}
	
	private Iterator<Usuario> getIterador(){
		return lista.iterator();
	}
	
	public void addUsuario(Usuario pUsuario){
		lista.add(pUsuario);
	}

}
