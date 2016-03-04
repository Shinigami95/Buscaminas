package packModelo;

public class Score {

	private int puntuacion;

	public Score() {
		this.puntuacion = 0;
	}

	public void setScore(int pPuntos) {
		this.puntuacion = pPuntos;
	}

	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	public void calcular(){
		int punt=0;
		if(Sesion.getSesion().getNivel()==1){
			//5 mins
			punt=3000-(Reloj.getGestor().tiempoASegundos()*10);
		}
		else if(Sesion.getSesion().getNivel()==2){
			//12 mins
			punt=7200-(Reloj.getGestor().tiempoASegundos()*10);}
		else{
			//30 mins
			punt=18000-(Reloj.getGestor().tiempoASegundos()*10);}
		puntuacion=puntuacion+punt;
		if(puntuacion<0){puntuacion=0;}
	}
}
