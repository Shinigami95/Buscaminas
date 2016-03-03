package packModelo;

import java.util.ArrayList;

public class MatrizCasillas {
	private static MatrizCasillas matrizCasilla;
	private Casilla[][] matriz;
	private int filas;
	private int columnas;
	
	private MatrizCasillas(){
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
	
	/*public Casilla getCasilla(int pFil,int pCol){
		return matriz[pFil][pCol];
	}*///TODO
	
	public void crearMatriz(){
		if(Buscaminas.getBuscaminas().getNivel()==1){
			filas=7;
			columnas=10;
		}else if(Buscaminas.getBuscaminas().getNivel()==2){
			filas=10;
			columnas=15;
		}else{
			filas=12;
			columnas=25;
		}
		matriz=new Casilla[filas][columnas];
	}
	
	public void llenarMatriz(){
		int[][] numMatrix=crearMatrixNum();
		ponerCasillas(numMatrix);
	}
	
	private int[][] crearMatrixNum(){
		int[][] numMatrix=rellenarConCero();
		int fil,col;
		int i=0;
		//Mientras las minas esten sin poner
		while(i<columnas*Buscaminas.getBuscaminas().getNivel()){
			//La colocamos aleatoriamente
			fil=(int) (Math.random()*filas-1);
			col=(int) (Math.random()*columnas-1);
			if(numMatrix[fil][col]!=-1){
				numMatrix[fil][col]=-1;
				i++;
				numMatrix=calcNum(numMatrix, fil-1, col-1);
				numMatrix=calcNum(numMatrix, fil-1, col);
				numMatrix=calcNum(numMatrix, fil-1, col+1);
				numMatrix=calcNum(numMatrix, fil, col-1);
				numMatrix=calcNum(numMatrix, fil, col+1);
				numMatrix=calcNum(numMatrix, fil+1, col-1);
				numMatrix=calcNum(numMatrix, fil+1, col);
				numMatrix=calcNum(numMatrix, fil+1, col+1);
			}
		}
		imprimirMatriz(numMatrix);
		return numMatrix;
	}
	
	private int[][] calcNum(int[][] numMatrix,int fil,int col){
		try{
			if(numMatrix[fil][col]!=-1){
			numMatrix[fil][col]=numMatrix[fil][col]+1;
			}
		}catch(Exception e){}
		return numMatrix;
	}
	
	private void imprimirMatriz(int[][] numMatrix){
		String res="";
		for(int s=0;s<filas;s++){
			for(int c=0;c<columnas;c++){
				res+="\t"+numMatrix[s][c];
			}
			res+="\n";
		}
		System.out.println(res);
	}
	
	private int[][] rellenarConCero(){
		int[][] numMatrix=new int[filas][columnas];
		for(int i=0;i<=filas-1;i++){
			for(int j=0;j<=columnas-1;j++){
				numMatrix[i][j]=0;
			}
		}
		return numMatrix;
	}
	
	private void ponerCasillas(int[][] matrix){
		for(int i=0;i<=filas-1;i++){
			for(int j=0;j<=columnas-1;j++){
				if(matrix[i][j]==-1){
					matriz[i][j]=new CasillaMina(i,j);
				}else if(matrix[i][j]>0){
					matriz[i][j]=new CasillaNumero(matrix[i][j],i,j);
				}
				else if(matrix[i][j]==0){
					matriz[i][j]=new CasillaBlanca(i,j);
				}
			}
		}
	}
	
	public ArrayList<Casilla> mostrarBlancas(int fi,int co){
		ArrayList<Casilla>[] listas=new ArrayList[2];
		ArrayList<Casilla> devol=new ArrayList<Casilla>();
		ArrayList<Casilla> mirar=new ArrayList<Casilla>();
		int index=0;
		Casilla prueba=matriz[fi][co];
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
	
	private boolean recorrer(ArrayList<Casilla> mirar,int index){
		boolean flag=false;
		try{
			mirar.get(index);
			flag=true;
		}catch(Exception e){}
		return flag;
	}
	
	private ArrayList<Casilla>[] mirarBlancas(ArrayList<Casilla> devol,ArrayList<Casilla> mirar,int fil,int col){
		ArrayList<Casilla>[] listas=new ArrayList[2];
		try{
			if(matriz[fil][col]instanceof CasillaBlanca && !matriz[fil][col].getVista()){
				mirar.add(matriz[fil][col]);
			}else if(matriz[fil][col]instanceof CasillaNumero && !matriz[fil][col].getVista()){
				devol.add(matriz[fil][col]);
			}
		}catch(Exception e){}
		listas[0]=mirar;
		listas[1]=devol;
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
	
	public boolean cambiarMarcada(int pFil,int pCol){
		return matriz[pFil][pCol].cambiarMarca();
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
