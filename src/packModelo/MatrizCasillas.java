package packModelo;

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
	
	public Casilla[][] getMatriz(){
		return matriz;
	}
	
	public Casilla getCasilla(int pFil,int pCol){
		return matriz[pFil][pCol];
	}
	
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
		int i=0;int r=0;
		//Mientras las minas esten sin poner
		while(i<columnas*Buscaminas.getBuscaminas().getNivel()){
			//La colocamos aleatoriamente
			fil=(int) (Math.random()*filas-1);
			col=(int) (Math.random()*columnas-1);
			r++;
			System.out.println(r);
			if(numMatrix[fil][col]!=-1){
				numMatrix[fil][col]=-1;
				i++;
				try{
					if(numMatrix[fil-1][col-1]!=-1){
					numMatrix[fil-1][col-1]=numMatrix[fil-1][col-1]+1;
					}
				}catch(Exception e){}
				try{
					if(numMatrix[fil-1][col]!=-1){
					numMatrix[fil-1][col]=numMatrix[fil-1][col]+1;
					}
				}catch(Exception e){}
				try{
					if(numMatrix[fil][col-1]!=-1){
					numMatrix[fil][col-1]=numMatrix[fil][col-1]+1;
					}
				}catch(Exception e){}
				try{
					if(numMatrix[fil+1][col]!=-1){
					numMatrix[fil+1][col]=numMatrix[fil+1][col]+1;
					}
				}catch(Exception e){}
				try{
					if(numMatrix[fil+1][col+1]!=-1){
					numMatrix[fil+1][col+1]=numMatrix[fil+1][col+1]+1;
					}
				}catch(Exception e){}
				try{
					if(numMatrix[fil][col+1]!=-1){
					numMatrix[fil][col+1]=numMatrix[fil][col+1]+1;
					}
				}catch(Exception e){}
				try{
					if(numMatrix[fil+1][col-1]!=-1){
					numMatrix[fil+1][col-1]=numMatrix[fil+1][col-1]+1;
					}
				}catch(Exception e){}
				try{
					if(numMatrix[fil-1][col+1]!=-1){
					numMatrix[fil-1][col+1]=numMatrix[fil-1][col+1]+1;
					}
				}catch(Exception e){}
			}
		}
		imprimirMatriz(numMatrix);
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
					matriz[i][j]=new CasillaMina();
				}else if(matrix[i][j]>0){
					matriz[i][j]=new CasillaNumero(matrix[i][j]);
				}
				else if(matrix[i][j]==0){
					matriz[i][j]=new CasillaBlanca();
				}
			}
		}
	}
}
