package packModelo;


public class Casilla {

	private boolean vista=false;
	private int fila;
	private int columna;
	private boolean marcada=false;
	
	public Casilla(int fi,int col) {
		fila=fi;
		columna=col;
	}
	
	public boolean getVista(){
		return vista;
	}
	
	public int getFila(){
		return fila;
	}
	
	public int getColumna(){
		return columna;
	}
	
	public void cambiarVista(){
		vista=true;
	}
	
	
	public boolean cambiarMarca(){
		marcada=!marcada;
		return marcada;
	}
	
}
