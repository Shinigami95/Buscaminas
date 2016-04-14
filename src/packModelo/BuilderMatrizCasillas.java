package packModelo;


public class BuilderMatrizCasillas {

	private int filas;
	private Casilla[][] matriz;
	private int columnas;
	
	public BuilderMatrizCasillas(){
	}
	
	public int getFilas(){
		return filas;
	}
	
	public int getColumnas(){
		return columnas;
	}
	
	public Casilla[][] devolverBuilder(){
		crearMatriz();
		return matriz;
	}
	
	public void crearMatriz(){
		if(Sesion.getSesion().getNivel()==1){
			BMatrizLvl1 m = new BMatrizLvl1();
			filas = m.getFilas();
			columnas = m.getColumnas();
			matriz = m.devolverBuilder();
		}else if(Sesion.getSesion().getNivel()==2){
			BMatrizLvl2 m = new BMatrizLvl2();
			filas = m.getFilas();
			columnas = m.getColumnas();
			matriz = m.devolverBuilder();
		}else{
			BMatrizLvl3 m=new BMatrizLvl3();
			filas = m.getFilas();
			columnas = m.getColumnas();
			matriz = m.devolverBuilder();
		}
	}
	
	
}
