

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoDvd {
	
	private File fdvd;
	private RandomAccessFile rafdvd;
	private long tamanioReg;
	
	public ArchivoDvd(String nombre) throws FileNotFoundException {//Tiro la exepcion para arriba asi la atrapa el el io
		fdvd=new File(nombre);
		rafdvd= new RandomAccessFile(fdvd,"rw");//Siempre conviene usar el file porque ya tiene funciones hechas
		tamanioReg= 84; //25+2+15+2+15+2+4+1+15+2+1
	}

	public File getFdvd() {
		return fdvd;
	}

	public void setFdvd(File fdvd) {
		this.fdvd = fdvd;
	}

	public RandomAccessFile getRafdvd() {
		return rafdvd;
	}

	public void setRafdvd(RandomAccessFile rafdvd) {
		this.rafdvd = rafdvd;
	}

	public long getTamanioReg() {
		return tamanioReg;
	}

	public void setTamanioReg(long tamanioReg) {
		this.tamanioReg = tamanioReg;
	}

	public void escribir(Dvd d) throws IOException//Hay que llamar en el Io previamente a adaptar
	{
		rafdvd.writeUTF(d.getTitulo());
		rafdvd.writeUTF(d.getDirector());
		rafdvd.writeUTF(d.getGenero());
		rafdvd.writeInt(d.getDuracion());
		rafdvd.writeBoolean(d.getExistencia());
		rafdvd.writeUTF(d.getComentario());
		rafdvd.writeBoolean(d.isActivo());
	}
	
	public void cerrar() throws IOException
	{
		rafdvd.close();
	}
	
	public long longitud() throws IOException
	{
		return rafdvd.length();
	}
	
	public long cantRegistro() throws IOException
	{
		
		return rafdvd.length()/tamanioReg;
	}
	
	public Dvd leer() throws IOException
	{
		return(new Dvd(rafdvd.readUTF(), rafdvd.readUTF(), rafdvd.readUTF(), rafdvd.readInt(),rafdvd.readBoolean(),rafdvd.readUTF(),rafdvd.readBoolean()));
	}
	
	public void inicio() throws IOException //Cursor al inicio
	{
		rafdvd.seek(0);
	}
	
	public void fin() throws IOException //Cursor al final
	{
		rafdvd.seek(rafdvd.length());
	}
	
	public void posReg(long reg) throws IOException //Posiciona cursor en el registro que quiero
	{
		rafdvd.seek((reg)*tamanioReg);
	}
	
	public void borrar() throws IOException {
		fdvd.delete();
	}
	
	public void renombrar(String nombre) throws IOException {
		File file = new File (nombre);
		fdvd.renameTo(file);
	}

	
}
