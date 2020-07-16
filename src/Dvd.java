public class Dvd extends Elemento{
	
	public Dvd(String titulo, String director, String genero, int duracion,
			boolean existencia, String comentario, boolean activo) {
		super(titulo, director, genero, duracion, existencia, comentario, activo);
	}

	public String toString(String tipo) {
		return super.toString(tipo);
	}
}
