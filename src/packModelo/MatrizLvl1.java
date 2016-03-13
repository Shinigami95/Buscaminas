package packModelo;

public class MatrizLvl1 extends MatrizCasillas{
	
	private int filas=7;
	private int columnas=10;
	
	public MatrizLvl1(){
		super();
	}
	
	public int getFilas(){
		return filas;
	}
	
	public int getColumnas(){
		return columnas;
	}
	
	public Casilla[][] llenarMatriz(){
		int[][] numMatrix=crearMatrixNum();
		Casilla[][] matriz=new Casilla[filas][columnas];
		matriz=ponerCasillas(numMatrix);
		return matriz;
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
	
	private Casilla[][] ponerCasillas(int[][] pMatrix){
		Casilla[][] matriz=new Casilla[filas][columnas];
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
		return matriz;
	}

}
