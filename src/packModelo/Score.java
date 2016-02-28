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
			punt=5000-(Reloj.getGestor().tiempoASegundos()*10);
		}
		else if(Buscaminas.getBuscaminas().getNivel()==2){
			punt=12000-(Reloj.getGestor().tiempoASegundos()*10);}
		else{
			punt=20000-(Reloj.getGestor().tiempoASegundos()*10);}
		puntuacion=puntuacion+punt;
	}
}
