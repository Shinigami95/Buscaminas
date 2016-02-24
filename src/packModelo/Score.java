package packModelo;

public class Score {

	private int puntuacion;


	public Score() {
		this.puntuacion = 0;
	}


	public void setScore(int pP) {
		this.puntuacion = pP;
		
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
