package packModelo;

public class CasillaNumero extends Casilla{
	private int numero;
	
	public CasillaNumero(int num,int fil,int col){
		super(fil,col);
		numero=num;
	}
	
	public int getNumero(){
		return numero;
	};

}
