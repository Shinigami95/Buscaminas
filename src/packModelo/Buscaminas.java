package packModelo;

import java.util.ArrayList;

public class Buscaminas {
	
	private static Buscaminas miBuscaminas;
	private Tablero tablero;
	private int minas;
	private boolean gameOver;
	
	private Buscaminas() {
		gameOver=false;
		tablero=new Tablero();
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
	
	public boolean getGameOver(){
		return gameOver;
	}
	
	public int getMinas(){
		return minas;
	}
	
	public int getColumnas(){
		return tablero.getColumnas();
	}
	
	public int getFilas(){
		return tablero.getFilas();
	}
	
	public int masMinas(){
		minas++;
		return minas;
	}
	
	public int menosMinas(){
		minas--;
		return minas;
	}

	public void crearMatriz(){
		tablero.crearMatrizTablero();
		setMinas(Sesion.getSesion().getNivel()*tablero.getColumnas());
	}
	
	
	public void reinicio(){
		Buscaminas.miBuscaminas=null;
	}
	
	public ArrayList<Casilla> mostrarBlancas(int pFil,int pCol){
		ArrayList<Casilla> devol=tablero.mostrarBlancas(pFil,pCol);
		return devol;
	}
	
	public void gameOver(){
		gameOver=true;
	}
	
	public String mostrar(int pFil,int pCol){
		return tablero.mostrar(pFil, pCol);
	}
	
	public void cambiarMarcada(int pFil,int pCol){
		tablero.cambiarMarcada(pFil,pCol);
	}
	
	public boolean casillaVista(int pFil,int pCol){
		return tablero.casillaVista(pFil,pCol);
	}
	
	public void cambiarVistaCasilla(int pFil,int pCol){
		tablero.cambiarVistaCasilla(pFil,pCol);	
		 }
	
	public int numCasilla(int pFil,int pCol){
		return tablero.numCasilla(pFil, pCol);
	}

}
