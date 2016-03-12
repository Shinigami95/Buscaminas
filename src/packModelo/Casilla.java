package packModelo;

import java.awt.Point;
import java.util.Observable;

public class Casilla extends Observable{

	private boolean vista=false;
	private int fila;
	private int columna;
	private boolean marcada=false;
	
	public Casilla(int pFil,int pCol) {
		fila=pFil;
		columna=pCol;
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
	
	public void cambiarMarca(){
		marcada=!marcada;
		Point coordenadas=new Point(fila, columna);
		setChanged();
		notifyObservers(coordenadas);
	}

	
}
