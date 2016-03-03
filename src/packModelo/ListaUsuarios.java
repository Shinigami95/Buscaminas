package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaUsuarios {
	
	private Node<Usuario> first;
	
	
	private static class Node<Usuario> {
        private Usuario usu;
        private Node<Usuario> next;

        public Node(Usuario pUsu) {
            this.usu = pUsu;
        }
        
        public Usuario getUsuario(){
        	return usu;
        }
    }
	
	public ListaUsuarios(){}
	
	public void addUsuario(Usuario pUsu) {
        Node<Usuario> usu = new Node<Usuario>(pUsu);
        Node<Usuario> usu1;
        Node<Usuario> usu2;
        int ptos=usu.getUsuario().getPuntos().getPuntuacion();
        if (estaVacia()) {
        	usu.next = null;
            first = usu;
        } else {
        	usu1=first;
        	while(usu1!=null){
        		usu2=usu1.next;
        		if(ptos>=usu1.getUsuario().getPuntos().getPuntuacion()){
        			usu.next=first;
        			first=usu;
        			break;
        		}else{
        			if(ptos<usu1.getUsuario().getPuntos().getPuntuacion()&&usu2==null){
        				usu1.next=usu;
        				usu.next=null;
        				break;
        			}else{
        				if(ptos<usu1.getUsuario().getPuntos().getPuntuacion()&&usu2.getUsuario().getPuntos().getPuntuacion()<=ptos){
        					usu1.next=usu;
        					usu.next=usu2;
        					break;
        				}
        				else{
        					usu1=usu1.next;
        				}
        			}
        		}
        	}
        }
    }
	
	private boolean estaVacia(){
		return (first==null);
	}
	
	public String mejores(){
		String res="Nº\tUsuario\tPuntos\n";
		if(first!=null){
			Node<Usuario> usu1=first;
			Usuario usu=usu1.getUsuario();
			int i=1;
			res+=i+"º\t"+usu.getNombre()+"\t"+usu.getPuntos().getPuntuacion()+"\n";
			for(i=2;i<11;i++){
				if(usu1.next!=null){
					usu1=usu1.next;
					usu=usu1.getUsuario();
					res+=i+"º\t"+usu.getNombre()+"\t"+usu.getPuntos().getPuntuacion()+"\n";
				}
			}
		}
		return res;
	}
	
	
	public Iterator<Usuario> getUsuarios(){
		ArrayList<Usuario> lista=new ArrayList<Usuario>();	
		Node<Usuario> usu=first;
		while (usu!=null){
			lista.add(usu.getUsuario());
			usu=usu.next;
		}
		return lista.iterator();
	}
	
}
