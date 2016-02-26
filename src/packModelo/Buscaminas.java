package packModelo;

public class Buscaminas {
	
	private static Buscaminas miBuscaminas;
	private String jugador;
	private Score puntos;
	private int nivel;
	
	private Buscaminas() {}

	public static Buscaminas getBuscaminas(){
		if(miBuscaminas == null){
			miBuscaminas = new Buscaminas();
		}
		return miBuscaminas;
	}
	
	public void restarPuntuacion(int pTiempo){
		double ponderacion;
		if(nivel == 1){
			ponderacion = 0.45;
		}else if(nivel == 2){
			ponderacion = 0.3;
		}else{
			ponderacion = 0.15;
		}
		puntos.setScore(puntos.getPuntuacion() - (int)(pTiempo*ponderacion));
	}

	public void setNivel(int pNivel) {
		nivel = pNivel;
	}

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String pNombre) {
		this.jugador = pNombre;
	}
}
