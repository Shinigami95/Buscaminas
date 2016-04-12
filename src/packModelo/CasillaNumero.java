package packModelo;

public class CasillaNumero extends Casilla {
	private int numero;
	
	public CasillaNumero(int pNum,int pFil,int pCol){
		super(pFil,pCol);
		numero=pNum;
	}
	
	public int getNumero(){
		return numero;
	};
	
	public String mostrar(){
		return "num";
	}

}
