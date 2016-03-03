package packModelo;

import java.util.ArrayList;

public class Buscaminas {
	
	private static Buscaminas miBuscaminas;
	private Usuario jugador;
	private int nivel;
	private MatrizCasillas matriz;
	private int minas;
	private boolean gameOver;
	
	private Buscaminas() {
		gameOver=false;
	}

	public static Buscaminas getBuscaminas(){
		if(miBuscaminas == null){
			miBuscaminas = new Buscaminas();
		}
		return miBuscaminas;
	}
	
	private void setMinas(int pMinas){
		minas=pMinas;	
	}
	
	public Usuario getJugador(){
		return jugador;
	}
	
	public boolean getGameOver(){
		return gameOver;
	}
	
	public int getMinas(){
		return minas;
	}
	
	public int getColumans(){
		return matriz.getColumnas();
	}
	
	public int getFilas(){
		return matriz.getFilas();
	}
	
	public int getNivel(){
		return nivel;
	}
	
	public void login(Usuario pUsu) {
		jugador=pUsu;
	}
	
	public int masMinas(){
		minas++;
		return minas;
	}
	
	public int menosMinas(){
		minas--;
		return minas;
	}
	

	public void crearMatriz(int pLevel){
		nivel=pLevel;
		matriz = MatrizCasillas.getMatrizCasillas();
		matriz.crearMatriz();
		matriz.llenarMatriz();
		setMinas(pLevel*matriz.getColumnas());
	}
	
	
	public void reinicio(){
		Buscaminas.miBuscaminas=null;
	}
	
	public void calcularPuntuacion(){
		jugador.calcularPuntos();
	}
	
	public ArrayList<Casilla> mostrarBlancas(int pFil,int pCol){
		ArrayList<Casilla> devol=matriz.mostrarBlancas(pFil,pCol);
		return devol;
	}
	
	public boolean esMina(int pFil,int pCol){
		if(matriz.esMina(pFil, pCol)){
			gameOver=true;
		}
		return matriz.esMina(pFil, pCol);
	}
	
	public boolean esBlanca(int pFil,int pCol){
		return matriz.esBlanca(pFil, pCol);
	}
	
	public boolean esNumero(int pFil,int pCol){
		return matriz.esNumero(pFil, pCol);
	}
	
	public boolean cambiarMarcada(int pFil,int pCol){
		return matriz.cambiarMarcada(pFil,pCol);
	}
	
	public boolean casillaVista(int pFil,int pCol){
		return matriz.casillaVista(pFil,pCol);
	}
	
	public void cambiarVistaCasilla(int pFil,int pCol){
		 matriz.cambiarVistaCasilla(pFil,pCol);	
		 }
	
	public int numCasilla(int pFil,int pCol){
		return matriz.numCasilla(pFil, pCol);
	}

}
