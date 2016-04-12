package packModelo;

import java.util.ArrayList;

public class Buscaminas {
	
	private static Buscaminas miBuscaminas;
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
	
	public boolean getGameOver(){
		return gameOver;
	}
	
	public int getMinas(){
		return minas;
	}
	
	public int getColumnas(){
		return Tablero.getTablero().getColumnas();
	}
	
	public int getFilas(){
		return Tablero.getTablero().getFilas();
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
		Tablero.getTablero().crearMatrizTablero();
		setMinas(Sesion.getSesion().getNivel()*Tablero.getTablero().getColumnas());
	}
	
	
	public void reinicio(){
		Buscaminas.miBuscaminas=null;
	}
	
	public ArrayList<Casilla> mostrarBlancas(int pFil,int pCol){
		ArrayList<Casilla> devol=Tablero.getTablero().mostrarBlancas(pFil,pCol);
		return devol;
	}
	
	public void gameOver(){
		gameOver=true;
	}
	
	public String mostrar(int pFil,int pCol){
		return Tablero.getTablero().mostrar(pFil, pCol);
	}
	
	public void cambiarMarcada(int pFil,int pCol){
		Tablero.getTablero().cambiarMarcada(pFil,pCol);
	}
	
	public boolean casillaVista(int pFil,int pCol){
		return Tablero.getTablero().casillaVista(pFil,pCol);
	}
	
	public void cambiarVistaCasilla(int pFil,int pCol){
		Tablero.getTablero().cambiarVistaCasilla(pFil,pCol);	
		 }
	
	public int numCasilla(int pFil,int pCol){
		return Tablero.getTablero().numCasilla(pFil, pCol);
	}

}
