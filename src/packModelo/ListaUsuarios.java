package packModelo;

public class ListaUsuarios {
	
	private Node<Usuario> first;
	private Node<Usuario> last;
	
	private static class Node<Usuario> {
        private Usuario usu;
        private Node<Usuario> next;
        private Node<Usuario> prev;

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
        if (estaVacia()) {
        	usu.next = null;
        	usu.prev = null;
            first = usu;
            last = usu;

        } else {
            addOrdenado(usu);
        }
    }
	
	private boolean estaVacia(){
		return (first==null);
	}
	
	private void addOrdenado(Node<Usuario> pUsu){
		Node<Usuario> usu1=first;
		Node<Usuario> usu2;
		boolean flag=false;
		if(pUsu.getUsuario().getPuntos().getPuntuacion()>first.getUsuario().getPuntos().getPuntuacion()){
			first.prev = pUsu;
	        pUsu.next = first;
	        pUsu.prev = null;
	        first = pUsu;
	        flag=true;
		}
		while(usu1!=last && flag==true){
			usu1=usu1.next;
			if(pUsu.getUsuario().getPuntos().getPuntuacion()>usu1.getUsuario().getPuntos().getPuntuacion()){
				usu2=usu1.prev;
				usu2.next=pUsu;
				pUsu.prev=usu2;
				pUsu.next=usu1;
				usu1.prev=pUsu;
				flag=true;
			}
		}
		if(flag==false){
			last.next=pUsu;
			pUsu.prev=last;
			last=pUsu;
		}
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
}
