package packModelo;

import javax.swing.JOptionPane;

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
	
	public MatrizCasillas getMatriz(){
		return matriz;
	}
	
	public int getNivel(){
		return nivel;
	}
	
	public void login(String pNomjug) {
		setJugador(pNomjug);
	}
	

	public void crearMatriz(int level){
		setNivel(level);
		matriz = MatrizCasillas.getMatrizCasillas();
		matriz.crearMatriz();
		matriz.llenarMatriz();
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(null, "GAME OVER");
	}

}
