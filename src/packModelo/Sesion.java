package packModelo;

public class Sesion {
	
	private Usuario jugador;
	private int nivel;
	private static Sesion sesion;
	
	private Sesion(){}
	
	public static Sesion getSesion(){
		if(sesion==null){
			sesion=new Sesion();
		}
		return sesion;
	}
	
	public void jugarNivel(int pLevel){
		nivel=pLevel;
	}
	
	public int getNivel(){
		return nivel;
	}
	
	public Usuario getJugador(){
		return jugador;
	}
	
	public void login(Usuario pUsu) {
		jugador=pUsu;
	}
	
	public void calcularPuntuacion(){
		jugador.calcularPuntos();
		
	}
	
	public void reinicio(){
		sesion=null;
	}

}
