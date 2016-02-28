package packModelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import packVentanas.VentanaBuscaminas;

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
	
	private void setJugador(Usuario usu){
		jugador = usu;
		
	}
	
	public Usuario getJugador(){
		return jugador;
		
	}
	
	public MatrizCasillas getMatriz(){
		return matriz;
	}
	
	public int getNivel(){
		return nivel;
	}
	
	public void login(Usuario usu) {
		setJugador(usu);
	}
	

	public void crearMatriz(int level){
		setNivel(level);
		matriz = MatrizCasillas.getMatrizCasillas();
		matriz.crearMatriz();
		matriz.llenarMatriz();
		VentanaBuscaminas.getVentana().setVisible(true);
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(null, "GAME OVER");
	}
	
	public void reinicio(){
		Buscaminas.miBuscaminas=null;
	}
	
	public ArrayList<Casilla> mostrarBlancas(int fil,int col){
		ArrayList<Casilla> devol=Buscaminas.getBuscaminas().matriz.mostrarBlancas(fil,col);
		return devol;
	}

}
