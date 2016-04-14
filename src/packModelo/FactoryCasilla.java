package packModelo;

public class FactoryCasilla {
	
	private static FactoryCasilla factory;
	
	private FactoryCasilla(){}
	
	public static FactoryCasilla getFactory(){
		if(factory == null){
			factory = new FactoryCasilla();
		}
		return factory;
	}
	
	public Casilla crearCasilla(int num, int i, int j){
		if(num==-1){
			return new CasillaMina(i, j);
		}else if(num>0){
			return new CasillaNumero(num, i, j);
		}else {
			return new CasillaBlanca(i, j);
		}
	}
}
