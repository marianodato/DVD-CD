import java.util.ArrayList;
import java.util.Collections;


public class Gestor {

	//Constructor
	public Gestor(){ 	
	}
	 
	//Metodos
	public void alta(Elemento e)throws Exception{
			if(e instanceof Dvd)
			{
				ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
				archDvd.fin();//Posiciono el cursor al final para no sobreescribir todo lo anterior
				archDvd.escribir((Dvd) e);
				archDvd.cerrar();	
			}else{
				ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
				archCd.fin();//Posiciono el cursor al final para no sobreescribir todo lo anterior
				archCd.escribir((Cd) e);
				archCd.cerrar();	
			}
	}
	
	public long buscar(String titulo, int cat)throws Exception //devuelve pos del registro
	{
		if(cat==1){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
			Dvd d;
			for(long i=0;i<archDvd.cantRegistro();i++)
			{
				d=archDvd.leer();
				if(d.getTitulo().equals(titulo))
				{	
					archDvd.cerrar();
					return i;
				}
			}
			archDvd.cerrar();
			return -1;
			
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
			Cd c;
			for(long i=0;i<archCd.cantRegistro();i++)
			{
				c=archCd.leer();
				if(c.getTitulo().equals(titulo))
				{	archCd.cerrar();
					return i;
				}
			}
			archCd.cerrar();
			return -1;
		}	
	}

	public void eliminar (long  pos, int cat) throws Exception{
		
		if(cat==1){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
			archDvd.posReg(pos);
			Dvd d;
			d=archDvd.leer();
			d.setActivo(false);
			archDvd.posReg(pos);
			archDvd.escribir(d);
			archDvd.cerrar();
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
			archCd.posReg(pos);
			Cd c;
			c=archCd.leer();
			c.setActivo(false);
			archCd.posReg(pos);
			archCd.escribir(c);
			archCd.cerrar();
		}
		
	}
	
	public void modificar (long pos, Elemento e) throws Exception{
		
		if(e instanceof Dvd){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
			archDvd.posReg(pos);
			archDvd.escribir((Dvd) e);
			archDvd.cerrar();
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
			archCd.posReg(pos);
			archCd.escribir((Cd) e);
			archCd.cerrar();
		}
	}
	
	public String listarTodos(long cat) throws Exception{
		String str="";
		if(cat==1){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
			Dvd d;
			for(long i=0;i<archDvd.cantRegistro();i++)
			{
				d=archDvd.leer();
				str= str + d.toString("Dvd: ")+ "\n";
			}
			archDvd.cerrar();
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
			Cd c;
			for(long i=0;i<archCd.cantRegistro();i++)
			{
				c=archCd.leer();
				str= str + c.toString("Cd: ")+ "\n";
			}
			archCd.cerrar();
		}
		return str;    
	}
	
	public String listarPorExistencia(String exis, int cat) throws Exception{
		String str="";
		if(cat==1){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
			Dvd d;
			for(long i=0;i<archDvd.cantRegistro();i++)
			{
				d=archDvd.leer();
				if(d.getExistencia()&& exis.equals("Si"))
				{
					str= str + d.toString("Dvd: ")+ "\n";
				}else if (!d.getExistencia()&& exis.equals("No")){
					str= str + d.toString("Dvd: ")+ "\n";
				}else{}	
			}	
			archDvd.cerrar();
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
			Cd c;
			for(long i=0;i<archCd.cantRegistro();i++)
			{
				c=archCd.leer();
				if(c.getExistencia()&& exis.equals("Si"))
				{
					str= str + c.toString("Cd: ")+ "\n";
				}else if (!c.getExistencia()&& exis.equals("No")){
					str= str + c.toString("Cd: ")+ "\n";
				}else{}
			}	
			archCd.cerrar();
		}return str;		
	}
	
	public String listarPorDuracion(int duracion, int cat) throws Exception{

		String str="";
		if(cat==1){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
			Dvd d;
			for(long i=0;i<archDvd.cantRegistro();i++)
			{
				d=archDvd.leer();
				if(d.getDuracion()==duracion)
				{
					str= str + d.toString("Dvd: ")+ "\n";
				}
			}		
			archDvd.cerrar();
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
			Cd c;
			for(long i=0;i<archCd.cantRegistro();i++)
			{
				c=archCd.leer();
				if(c.getDuracion()==duracion)
				{
					str= str + c.toString("Cd: ")+ "\n";
				}
				
			}	
			archCd.cerrar();
		}
		return str;
	}
	
	public String listarPorDirector(String director,int cat) throws Exception{

		String str="";
		if (cat==1){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
			Dvd d;
			for(long i=0;i<archDvd.cantRegistro();i++)
			{
				d=archDvd.leer();
				if(d.getDirector().equals(director))
				{
					str= str + d.toString("Dvd: ")+ "\n";
				}
			}	
			archDvd.cerrar();
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
			Cd c;
			for(long i=0;i<archCd.cantRegistro();i++)
			{
				c=archCd.leer();
				if(c.getDirector().equals(director))
				{
					str= str + c.toString("Cd: ")+ "\n";
				}
				
			}	
			archCd.cerrar();
		}return str;
	}
	
	public ArrayList<Elemento> pasaje() throws Exception
	{
		ArrayList<Elemento> catalogo = new ArrayList<Elemento>();
		
		ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
		Dvd d;
		for(long i=0;i<archDvd.cantRegistro();i++)
		{
			d=archDvd.leer();
			catalogo.add(d);
		}	
		archDvd.cerrar();
	
		ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
		Cd c;
		for(long i=0;i<archCd.cantRegistro();i++)
		{
			c=archCd.leer();
			catalogo.add(c);	
		}	
		archCd.cerrar();
		
		return catalogo;
	}
	
	public String ordenarPorTitulo(int cat) throws Exception
	{
		String str="";
		ArrayList<Elemento> catalogo = pasaje();
		Collections.sort(catalogo);
		
		if (cat==1)
		{
			for(int i=0;i<catalogo.size();i++){
				if (catalogo.get(i) instanceof Dvd)
				{
					str= str + catalogo.get(i).toString("Dvd: ")+ "\n";
				}
			}
		}else
		{
			for(int i=0;i<catalogo.size();i++){
				if (catalogo.get(i) instanceof Cd)
				{
					str= str + catalogo.get(i).toString("Cd: ")+ "\n";
				}
			}
		}
		return str;
	}

	public String ordenarPorGenero(int cat) throws Exception
	{
		String str="";
		ArrayList<Elemento> catalogo = pasaje();
		Collections.sort(catalogo, new OrdenarPorGenero());
		if (cat==1)
		{
			for(int i=0;i<catalogo.size();i++){
				if (catalogo.get(i) instanceof Dvd)
				{
					str= str + catalogo.get(i).toString("Dvd: ")+ "\n";
				}
			}
		}else
		{
			for(int i=0;i<catalogo.size();i++){
				if (catalogo.get(i) instanceof Cd)
				{
					str= str + catalogo.get(i).toString("Cd: ")+ "\n";
				}
			}
			
		}
		return str;
	}
	
	public String ordenarPorDuracion(int cat) throws Exception
	{
		String str="";
		ArrayList<Elemento> catalogo = pasaje();
		Collections.sort(catalogo, new OrdenarPorDuracion());
		if (cat==1)
		{
			for(int i=0;i<catalogo.size();i++){
				if (catalogo.get(i) instanceof Dvd)
				{
					str= str + catalogo.get(i).toString("Dvd: ")+ "\n";
				}
			}
		}else
		{
			for(int i=0;i<catalogo.size();i++){
				if (catalogo.get(i) instanceof Cd)
				{
					str= str + catalogo.get(i).toString("Cd: ")+ "\n";
				}
			}
			
		}
		return str;
	}
	
	public long cant(int cat) throws Exception{
		long res;
		if(cat==1){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");//Si existe lo abre y me paro al principio, sino lo crea
			res = archDvd.cantRegistro();
			archDvd.cerrar();
			return  res;
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
			res = archCd.cantRegistro();
			archCd.cerrar();
			return  res;
		}  
	}
	
	public int cantPorExistencia(String str){
		
		int cont =0;
		for (int i=0; i< str.length(); i++){
			
			if (str.charAt(i)=='\n')
			{
				cont++;
			}
		}	
		return cont;
	}
	
	public int cantTemas(long pos) throws Exception{
		Cd c;
		ArchivoCd archCd = new ArchivoCd("Cds");//Si existe lo abre y me paro al principio, sino lo crea
		archCd.posReg(pos);
		c=archCd.leer();
		archCd.cerrar();
		return c.getCantTemas();
	}
	
	public void compactar (int cat) throws Exception
	{
		if (cat==1){
			ArchivoDvd archDvd = new ArchivoDvd("Dvds");
			ArchivoDvd archDvdTemp = new ArchivoDvd("TemporalDvds");
			Dvd d;
			for(long i=0; i<archDvd.cantRegistro();i++){
				d= archDvd.leer();
				if(d.isActivo())
					archDvdTemp.escribir(d);
					// agregar un contador de reg o progress bar
			}
			archDvd.cerrar();
			archDvdTemp.cerrar();
			archDvd.borrar();
			archDvdTemp.renombrar("Dvds");
		}else{
			ArchivoCd archCd = new ArchivoCd("Cds");
			ArchivoCd archCdTemp = new ArchivoCd("TemporalCds");
			Cd c;
			for(long i=0; i<archCd.cantRegistro();i++){
				c= archCd.leer();
				if(c.isActivo())
					archCdTemp.escribir(c);
					// agregar un contador de reg o progress bar
			}
			archCd.cerrar();
			archCdTemp.cerrar();
			archCd.borrar();
			archCdTemp.renombrar("Cds");
		}
	}
}
	
	