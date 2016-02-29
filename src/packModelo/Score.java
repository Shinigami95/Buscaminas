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
		if(Buscaminas.getBuscaminas().getNivel()==1){
			punt=2000-(Reloj.getGestor().tiempoASegundos()*10);
		}
		else if(Buscaminas.getBuscaminas().getNivel()==2){
			punt=10000-(Reloj.getGestor().tiempoASegundos()*20);}
		else{
			punt=40000-(Reloj.getGestor().tiempoASegundos()*20);}
		puntuacion=puntuacion+punt;
		if(puntuacion<0){puntuacion=0;}
	}
}
