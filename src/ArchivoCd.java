

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoCd {
	
	private File fcd;
	private RandomAccessFile rafcd;
	private long tamanioReg;
	
	public ArchivoCd(String nombre) throws FileNotFoundException {//Tiro la exepcion para arriba asi la atrapa el el io
		fcd=new File(nombre);
		rafcd= new RandomAccessFile(fcd,"rw");//Siempre conviene usar el file porque ya tiene funciones hechas
		tamanioReg= 88; //25+2+15+2+15+2+4+1+15+2+4+1
	}

	public File getFcd() {
		return fcd;
	}

	public void setFcd(File fcd) {
		this.fcd = fcd;
	}

	public RandomAccessFile getRafcd() {
		return rafcd;
	}

	public void setRafcd(RandomAccessFile rafcd) {
		this.rafcd = rafcd;
	}

	public long getTamanioReg() {
		return tamanioReg;
	}

	public void setTamanioReg(long tamanioReg) {
		this.tamanioReg = tamanioReg;
	}

	public void escribir(Cd c) throws IOException//Hay que llamar en el Io previamente a adaptar
	{
		rafcd.writeUTF(c.getTitulo());
		rafcd.writeUTF(c.getDirector());
		rafcd.writeUTF(c.getGenero());
		rafcd.writeInt(c.getDuracion());
		rafcd.writeBoolean(c.getExistencia());
		rafcd.writeUTF(c.getComentario());
		rafcd.writeBoolean(c.isActivo());
		rafcd.writeInt(c.getCantTemas());
	}
	
	public void cerrar() throws IOException
	{
		rafcd.close();
	}
	
	public long longitud() throws IOException
	{
		return rafcd.length();
	}
	
	public long cantRegistro() throws IOException
	{
		
		return rafcd.length()/tamanioReg;
	}
	
	public Cd leer() throws IOException
	{
		return(new Cd(rafcd.readUTF(), rafcd.readUTF(), rafcd.readUTF(), rafcd.readInt(),rafcd.readBoolean(),rafcd.readUTF(),rafcd.readBoolean(),rafcd.readInt()));
	}
	
	public void inicio() throws IOException //Cursor al inicio
	{
		rafcd.seek(0);
	}
	
	public void fin() throws IOException //Cursor al final
	{
		rafcd.seek(rafcd.length());
	}
	
	public void posReg(long reg) throws IOException //Posiciona cursor en el registro que quiero
	{
		//reg-1 porque empieza en 0
		rafcd.seek((reg)*tamanioReg);
	}
	
	public void borrar() throws IOException {
		fcd.delete();
	}
	
	public void renombrar(String nombre) throws IOException {
		File file = new File (nombre);
		fcd.renameTo(file);
	}
	
}
