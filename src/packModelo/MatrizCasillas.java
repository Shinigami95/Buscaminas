package packModelo;

import java.util.ArrayList;

public class MatrizCasillas {

	private int filas;
	private int columnas;
	
	public MatrizCasillas(){
	}
	
	public int getFilas(){
		return filas;
	}
	
	public int getColumnas(){
		return columnas;
	}
	
	public Casilla[][] crearMatriz(){
		if(Sesion.getSesion().getNivel()==1){
			MatrizLvl1 m=new MatrizLvl1();
			filas=m.getFilas();
			columnas=m.getColumnas();
			return m.llenarMatriz();
		}else if(Sesion.getSesion().getNivel()==2){
			MatrizLvl2 m=new MatrizLvl2();
			filas=m.getFilas();
			columnas=m.getColumnas();
			return m.llenarMatriz();
		}else{
			MatrizLvl3 m=new MatrizLvl3();
			filas=m.getFilas();
			columnas=m.getColumnas();
			return m.llenarMatriz();
		}
	}
	
	
}
