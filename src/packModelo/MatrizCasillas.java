package packModelo;

import java.util.ArrayList;

public class MatrizCasillas {
	private static MatrizCasillas matrizCasilla;
	private Casilla[][] matriz;
	private int filas;
	private int columnas;
	
	public MatrizCasillas(){
	}
	
	public static MatrizCasillas getMatrizCasillas(){
		if(matrizCasilla==null){
			matrizCasilla=new MatrizCasillas();
		}
		return matrizCasilla;
	}
	
	public int getFilas(){
		return filas;
	}
	
	public int getColumnas(){
		return columnas;
	}
	
	public void crearMatriz(){
		if(Sesion.getSesion().getNivel()==1){
			MatrizLvl1 m=new MatrizLvl1();
			matriz=m.llenarMatriz();
			filas=m.getFilas();
			columnas=m.getColumnas();
		}else if(Sesion.getSesion().getNivel()==2){
			MatrizLvl2 m=new MatrizLvl2();
			matriz=m.llenarMatriz();
			filas=m.getFilas();
			columnas=m.getColumnas();
		}else{
			MatrizLvl3 m=new MatrizLvl3();
			matriz=m.llenarMatriz();
			filas=m.getFilas();
			columnas=m.getColumnas();
		}
	}
	
	public ArrayList<Casilla> mostrarBlancas(int pFil,int pCol){
		ArrayList<Casilla>[] listas=new ArrayList[2];
		ArrayList<Casilla> devol=new ArrayList<Casilla>();
		ArrayList<Casilla> mirar=new ArrayList<Casilla>();
		int index=0;
		Casilla prueba=matriz[pFil][pCol];
		int fil,col;
		mirar.add(prueba);
		while(recorrer(mirar,index)){
			prueba=mirar.get(index);
			fil=prueba.getFila();
			col=prueba.getColumna();
			matriz[fil][col].cambiarVista();
			devol.add(prueba);
			listas=mirarBlancas(devol, mirar, fil+1, col+1);
			listas=mirarBlancas(devol, mirar, fil+1, col);
			listas=mirarBlancas(devol, mirar, fil+1, col-1);
			listas=mirarBlancas(devol, mirar, fil, col+1);
			listas=mirarBlancas(devol, mirar, fil, col-1);
			listas=mirarBlancas(devol, mirar, fil-1, col+1);
			listas=mirarBlancas(devol, mirar, fil-1, col);
			listas=mirarBlancas(devol, mirar, fil-1, col-1);
			mirar=listas[0];
			devol=listas[1];
			index++;
		}
		return devol;
	}
	
	private boolean recorrer(ArrayList<Casilla> pMirar,int pIndex){
		boolean flag=false;
		try{
			pMirar.get(pIndex);
			flag=true;
		}catch(Exception e){}
		return flag;
	}
	
	private ArrayList<Casilla>[] mirarBlancas(ArrayList<Casilla> pDevol,ArrayList<Casilla> pmirar,int pFil,int pCol){
		ArrayList<Casilla>[] listas=new ArrayList[2];
		try{
			if(matriz[pFil][pCol]instanceof CasillaBlanca && !matriz[pFil][pCol].getVista()){
				pmirar.add(matriz[pFil][pCol]);
			}else if(matriz[pFil][pCol]instanceof CasillaNumero && !matriz[pFil][pCol].getVista()){
				pDevol.add(matriz[pFil][pCol]);
			}
		}catch(Exception e){}
		listas[0]=pmirar;
		listas[1]=pDevol;
		return listas;
	}
	
	public boolean esMina(int pFil,int pCol){
		if(matriz[pFil][pCol] instanceof CasillaMina){
			return true;
		}
		else{return false;}
	}
	
	public boolean esBlanca(int pFil,int pCol){
		if(matriz[pFil][pCol] instanceof CasillaBlanca){
			return true;
		}
		else{return false;}
	}
	
	public boolean esNumero(int pFil,int pCol){
		if(matriz[pFil][pCol] instanceof CasillaNumero){
			return true;
		}
		else{return false;}
	}
	
	public void cambiarMarcada(int pFil,int pCol){
		matriz[pFil][pCol].cambiarMarca();
	}

	
	public boolean casillaVista(int pFil,int pCol){
		return matriz[pFil][pCol].getVista();
	}
	
	public void cambiarVistaCasilla(int pFil,int pCol){
		 matriz[pFil][pCol].cambiarVista();	
		 }
	
	public int numCasilla(int pFil,int pCol){
		CasillaNumero cas=(CasillaNumero)matriz[pFil][pCol];
		return cas.getNumero();
	}
}
