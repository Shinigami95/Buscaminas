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
	
	public void crearMatriz(){
		if(Sesion.getSesion().getNivel()==1){
			filas=7;
			columnas=10;
		}else if(Sesion.getSesion().getNivel()==2){
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
		//Mientras haya minas cuyos numeros alrededor esten sin calcular
		while(i<columnas*Sesion.getSesion().getNivel()){
			//Buscamos una casilla para poner mina
			fil=(int) (Math.random()*filas-1);
			col=(int) (Math.random()*columnas-1);
			if(numMatrix[fil][col]!=-1){
				//Ponemos la mina
				numMatrix[fil][col]=-1;
				i++;
				//Calculamos los numeros de las casillas que rodean la mina
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
	
	private int[][] calcNum(int[][] pNumMatrix,int pFil,int pCol){
		try{
			if(pNumMatrix[pFil][pCol]!=-1){
				pNumMatrix[pFil][pCol]=pNumMatrix[pFil][pCol]+1;
			}
		}catch(Exception e){}
		return pNumMatrix;
	}
	
	private void imprimirMatriz(int[][] pNumMatrix){
		String res="";
		for(int s=0;s<filas;s++){
			for(int c=0;c<columnas;c++){
				res+="\t"+pNumMatrix[s][c];
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
	
	private void ponerCasillas(int[][] pMatrix){
		for(int i=0;i<=filas-1;i++){
			for(int j=0;j<=columnas-1;j++){
				if(pMatrix[i][j]==-1){
					matriz[i][j]=new CasillaMina(i,j);
				}else if(pMatrix[i][j]>0){
					matriz[i][j]=new CasillaNumero(pMatrix[i][j],i,j);
				}
				else if(pMatrix[i][j]==0){
					matriz[i][j]=new CasillaBlanca(i,j);
				}
			}
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
	
	public boolean cambiarMarcada(int pFil,int pCol){
		return matriz[pFil][pCol].cambiarMarca();
	}
	
	public boolean estaMarcada(int pFil,int pCol){
		return matriz[pFil][pCol].estaMarcada();
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
