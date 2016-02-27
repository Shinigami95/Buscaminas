package packModelo;

public class Usuario {
	
	private String nombre;
	private Score puntos;
	
	public Usuario(String pNombre,int pPuntos){
		this.nombre=pNombre;
		puntos=new Score();
		this.puntos.setScore(pPuntos);
	}

	public String getNombre() {
		return nombre;
	}

	public Score getPuntos() {
		return puntos;
	}

}
