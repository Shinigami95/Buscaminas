package packModelo;

import java.awt.Point;
import java.util.Observable;

public class Casilla extends Observable{

	private boolean vista=false;
	private int fila;
	private int columna;

	
	public Casilla(int pFil,int pCol) {
		fila=pFil;
		columna=pCol;
	}
	
	public void factoryCasilla(int pFil,int pCol,int pNum){
		if(pNum==0){
			CasillaBlanca casilla =new CasillaBlanca(pFil,pCol);
		}
		else if(pNum<0){
			CasillaMina casilla=new CasillaMina(pFil, pCol);
		}
		else if(pNum>0){
			CasillaNumero casilla=new CasillaNumero(pFil, pCol,pNum);
		}
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
		Point coordenadas=new Point(fila, columna);
		setChanged();
		notifyObservers(coordenadas);
	}

	
}
