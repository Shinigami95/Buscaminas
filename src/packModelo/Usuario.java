package packModelo;

public class Usuario {
	
	private String nombre;
	private Score puntos;
	
	public Usuario(String pNombre,int puntos){
		this.nombre=pNombre;
		this.puntos.setScore(puntos);
	}

	public String getNombre() {
		return nombre;
	}

	public Score getPuntos() {
		return puntos;
	}

}
