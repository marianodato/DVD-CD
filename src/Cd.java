public class Cd extends Elemento{

	private int cantTemas;

	public Cd(String titulo, String director, String genero, int duracion,
			boolean existencia, String comentario, boolean activo, int cant) {
		super(titulo, director, genero, duracion, existencia, comentario, activo);
		this.cantTemas=cant;
	}
	
	public int getCantTemas() {
		return cantTemas;
	}
	
	public void setCantTemas(int cantTemas) {
		this.cantTemas = cantTemas;
	}

	public String toString(String tipo) {
		return super.toString(tipo) + ",    " + cantTemas;
	}
	
}

