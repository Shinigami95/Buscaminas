package packModelo;

import java.util.ArrayList;

public class Tablero {
	private static Tablero tablero;
	private Casilla[][] matriz;
	private int filas;
	private int columnas;

	private Tablero(){}
	
	public static Tablero getTablero(){
		if(tablero==null){
			tablero=new Tablero();
		}
		return tablero;
	}
	
	public int getFilas(){
		return filas;
	}
	
	public int getColumnas(){
		return columnas;
	}
	
	public void crearMatrizTablero(){
		MatrizCasillas x=new MatrizCasillas();
		matriz=x.crearMatriz();
		filas=x.getFilas();
		columnas=x.getColumnas();
	}
	
	public ArrayList<Casilla> mostrarBlancas(int pFil,int pCol){
		ArrayList<Casilla>[] listas=new ArrayList[2];
		ArrayList<Casilla> devol=new ArrayList<Casilla>();
		ArrayList<Casilla> mirar=new ArrayList<Casilla>();
		int index=0;
		//Cogemos una casilla
		Casilla prueba=matriz[pFil][pCol];
		int fil,col;
		//La ponemos para mirarla
		mirar.add(prueba);
		//Recorremos dicho arraylist
		while(recorrer(mirar,index)){
			//Cogemos esa casilla para hacer operaciones con ella
			prueba=mirar.get(index);
			fil=prueba.getFila();
			col=prueba.getColumna();
			//Cambiamos su vista
			matriz[fil][col].cambiarVista();
			//Lista para devolver
			devol.add(prueba);
			//Vemos las casillas adyacentes de la casilla cogida
			listas=mirarBlancas(devol, mirar, fil+1, col+1);
			listas=mirarBlancas(devol, mirar, fil+1, col);
			listas=mirarBlancas(devol, mirar, fil+1, col-1);
			listas=mirarBlancas(devol, mirar, fil, col+1);
			listas=mirarBlancas(devol, mirar, fil, col-1);
			listas=mirarBlancas(devol, mirar, fil-1, col+1);
			listas=mirarBlancas(devol, mirar, fil-1, col);
			listas=mirarBlancas(devol, mirar, fil-1, col-1);
			//Preparamos las casillas miradas y devolvemos las vistas
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
	
	public String mostrar(int pFil,int pCol){
		return matriz[pFil][pCol].mostrar();
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
