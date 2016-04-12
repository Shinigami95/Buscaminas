package packModelo;

import java.awt.Point;
import java.util.Observable;

public abstract class Casilla extends Observable{

	private boolean vista=false;
	private int fila;
	private int columna;

	
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
	
	public String mostrar(){
		return null;
	}
	
	public void cambiarMarca(){
		Point coordenadas=new Point(fila, columna);
		setChanged();
		notifyObservers(coordenadas);
	}

	
}
