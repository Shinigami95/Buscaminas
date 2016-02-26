package packModelo;

public class Score {

	private int puntuacion;

	public Score() {
		this.puntuacion = 0;
	}


	public void setScore(int pPuntos) {
		this.puntuacion = pPuntos;
		
	}

	public String toString() {
		return "score: "+this.puntuacion+"\t";
	}

	public String toStringParaFichero() {
		return this.puntuacion+" \\ ";
	}

	public int getPuntuacion() {
		return this.puntuacion;
	}
}
