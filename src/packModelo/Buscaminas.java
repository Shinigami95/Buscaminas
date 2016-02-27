package packModelo;

public class Buscaminas {
	
	private static Buscaminas miBuscaminas;
	private Usuario jugador;
	private int nivel;
	private MatrizCasillas matriz;
	
	private Buscaminas() {}

	public static Buscaminas getBuscaminas(){
		if(miBuscaminas == null){
			miBuscaminas = new Buscaminas();
		}
		return miBuscaminas;
	}
	private void setNivel(int niv){
		nivel=niv;
	}
	private void setJugador(String nomjug){
		jugador=new Usuario(nomjug, 0);
		
	}
	
	public int getNivel(){
		return nivel;
	}
	
	public void login(String nomjug) {
		setJugador(nomjug);
	}
	
	public void crearMatriz(int level){
		setNivel(level);
		System.out.println("hola");
		matriz=MatrizCasillas.getMatrizCasillas();
		System.out.println("hola");
		matriz.crearMatriz();
		System.out.println("hola");
		matriz.llenarMatriz();
		System.out.println("hola");
	}

}
