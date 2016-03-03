package packModelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import packVentanas.VentanaBuscaminas;

public class Buscaminas {
	
	private static Buscaminas miBuscaminas;
	private Usuario jugador;
	private int nivel;
	private MatrizCasillas matriz;
	private int minas;
	
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
	
	private void setMinas(int pMinas){
		minas=pMinas;	
	}
	
	public Usuario getJugador(){
		return jugador;
	}
	
	public int getMinas(){
		return minas;
	}
	
	private MatrizCasillas getMatriz(){
		return matriz;
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
	
	public void login(Usuario usu) {
		setJugador(usu);
	}
	
	public int masMinas(){
		minas++;
		return minas;
	}
	
	public int menosMinas(){
		minas--;
		return minas;
	}
	

	public void crearMatriz(int level){
		setNivel(level);
		matriz = MatrizCasillas.getMatrizCasillas();
		matriz.crearMatriz();
		matriz.llenarMatriz();
		setMinas(level*matriz.getColumnas());
	}
	
	
	public void reinicio(){
		Buscaminas.miBuscaminas=null;
	}
	
	public void calcularPuntuacion(){
		jugador.calcularPuntos();
	}
	
	public ArrayList<Casilla> mostrarBlancas(int fil,int col){
		ArrayList<Casilla> devol=Buscaminas.getBuscaminas().matriz.mostrarBlancas(fil,col);
		return devol;
	}
	
	public boolean esMina(int pFil,int pCol){
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
