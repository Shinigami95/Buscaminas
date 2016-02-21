package packModelo;

public class Usuario {
	
	private String nombre;
	private int puntos;
	
	public Usuario(String pNombre, int pPuntos){
		this.setNombre(pNombre);
		this.setPuntos(pPuntos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
