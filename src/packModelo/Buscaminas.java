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
	
	private void setNivel(int pNivel){
		nivel = pNivel;
	}
	
	private void setJugador(String pNomjug){
		jugador = new Usuario(pNomjug, 0);
		
	}
	
	public int getNivel(){
		return nivel;
	}
	
	public void login(String pNomjug) {
		setJugador(pNomjug);
	}
	
	public void crearMatriz(int pLevel){
		setNivel(pLevel);
		System.out.println("hola");
		matriz = MatrizCasillas.getMatrizCasillas();
		System.out.println("hola");
		matriz.crearMatriz();
		System.out.println("hola");
		matriz.llenarMatriz();
		System.out.println("hola");
	}

}
