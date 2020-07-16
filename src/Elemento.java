public abstract class Elemento implements Comparable<Elemento>{
	
	private String titulo;
	private String director;
	private String genero;
	private int duracion;
	private boolean existencia;
	private String comentario;
	private boolean activo;
	
	public Elemento(String titulo, String director, String genero,
			int duracion, boolean existencia, String comentario, boolean activo) {
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.duracion = duracion;
		this.existencia = existencia;
		this.comentario = comentario;
		this.activo=activo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean getExistencia() {
		return existencia;
	}

	public void setExistencia(boolean existencia) {
		this.existencia = existencia;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String toString(String tipo) {
		String aux="No";
		String aux2="No";
		
		if (existencia==true)
		{
			aux="Si";
		}
		
		if (activo==true)
		{
			aux2="Si";
		}
		
		return tipo + titulo + ", " + genero + ", "
				+ aux + ",    "
				+ director + ", " + comentario+", "+ aux2 + ",    "+duracion;
	}
	
	public int compareTo(Elemento e)
	{
		return this.titulo.compareTo(e.titulo);	
	}
	
}