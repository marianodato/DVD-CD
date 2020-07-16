import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Io {

	static JFrame windowPrincipal = new JFrame("Dvds/Cds");
	static JDialog windowDvd;
	static JDialog windowCd;
	private static Gestor g;
	static String str;
	
	public Io()
	{
		 g = new Gestor(); 
		 final ImageIcon imagen = new ImageIcon(getClass().getResource("/images/disco2.png"));
		 
		//Ventana Principal
		windowPrincipal.setSize(310,285);
		windowPrincipal.setLayout(null);
		windowPrincipal.setIconImage(imagen.getImage());
		windowPrincipal.setResizable(false);
		
		//Botones
		JButton bDvds = Boton("Gestionar Dvds",50,50,200,50,windowPrincipal);
		JButton bCds = Boton("Gestionar Cds",50,150,200,50,windowPrincipal);
		
		//Ventana Dvds
		bDvds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowPrincipal.setVisible(false);
					WDvds();
		}});
		
		//Ventana Cds
		bCds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowPrincipal.setVisible(false);
					WCds();
		}});

		// Mostrar la ventana principal
		windowPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		windowPrincipal.setVisible(true);
	}

public static JButton Boton (String nombre, int x, int y, int ancho, int alto, JFrame window)
{
	JButton button = new JButton(nombre);
	button.setBounds(new Rectangle(x, y, ancho, alto));
	button.setFont(new java.awt.Font("Courier New", 1, 15)); 
	window.getContentPane().add(button);
	return button;
}

public static JButton Boton (String nombre, int x, int y, int ancho, int alto, JDialog window)
{
	JButton button = new JButton(nombre);
	button.setBounds(new Rectangle(x, y, ancho, alto));
	button.setFont(new java.awt.Font("Courier New", 1, 15)); 
	window.getContentPane().add(button);
	return button;
}

public static JLabel Label (String nombre, int x, int y, int ancho, int alto, JDialog dialog)
{
	JLabel label = new JLabel(nombre);
    label.setBounds(x, y, ancho, alto);
    label.setFont(new java.awt.Font("Courier New", 1, 15)); 
    dialog.add(label);
	return label;
}

public static JTextField TextField (int x, int y, int ancho, int alto, JDialog dialog)
{
	JTextField text = new JTextField();
    text.setBounds(x, y, ancho, alto);
    text.setFont(new java.awt.Font("Courier New", 1, 15)); 
    dialog.add(text);
	return text;
}

public static JTextField TextField (int x, int y, int ancho, int alto, JDialog dialog, String texto)
{
	JTextField text = new JTextField(texto);
    text.setBounds(x, y, ancho, alto);
    text.setFont(new java.awt.Font("Courier New", 1, 15)); 
    dialog.add(text);
	return text;
}
static void Mensaje(String text, JDialog ventana)
{
	final JDialog mensaje = new JDialog(ventana,"Mensaje");
	mensaje.setSize(350,150);
	mensaje.setLayout(null);
	mensaje.setResizable(false);
	mensaje.setVisible(true);
	Label(text,20,20,310,30,mensaje);
	
	JButton Aceptar = Boton("Aceptar",100,60,150,35,mensaje);
	//Modificar
			Aceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mensaje.setVisible(false);
				
			}});
}

static void Mensaje(String text, JFrame ventana)
{
	final JDialog mensaje = new JDialog(ventana,"Mensaje");
	mensaje.setSize(350,150);
	mensaje.setLayout(null);
	mensaje.setResizable(false);
	mensaje.setVisible(true);
	Label(text,20,20,310,30,mensaje);
	
	JButton Aceptar = Boton("Aceptar",100,60,150,35,mensaje);
	//Modificar
			Aceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mensaje.setVisible(false);
				
			}});
}

public static void WDvds()
{
	windowDvd = new JDialog(windowPrincipal,"Gestionar Dvds"); 
	windowDvd.setSize(280,735);
	windowDvd.setLayout(null);
	windowDvd.setResizable(false);
	windowDvd.setVisible(true);
	
	JButton bDvdAgregar = Boton("Agregar",50,25,175,50,windowDvd);
	JButton bDvdEliminar = Boton("Eliminar",50,75,175,50,windowDvd);
	JButton bDvdModificar = Boton("Modificar",50,125,175,50,windowDvd);
	JButton bDvdListar = Boton("Listar",50,175,175,50,windowDvd);
	JButton bDvdListarExis = Boton("Listar Exis",50,225,175,50,windowDvd);
	JButton bDvdListarDur = Boton("Listar Dur",50,275,175,50,windowDvd);
	JButton bDvdListarDir = Boton("Listar Dir",50,325,175,50,windowDvd);
	JButton bDvdOrdenarTit = Boton("Ordenar Tit",50,375,175,50,windowDvd);
	JButton bDvdOrdenarGen = Boton("Ordenar Gen",50,425,175,50,windowDvd);
	JButton bDvdOrdenarDur = Boton("Ordenar Dur",50,475,175,50,windowDvd);
	JButton bDvdCantidad = Boton("Cantidad",50,525,175,50,windowDvd);
	JButton bDvdCantidadExis = Boton("Cantidad Exis",50,575,175,50,windowDvd);
	JButton bDvdCompactar = Boton("Compactar",50,625,175,50,windowDvd);

	//Agregar Dvd
		bDvdAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						WAgregar(1);
		}});
	//Eliminar Dvd
			bDvdEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WEliminar(1);
					
			}});
	//Modificar Dvd
			bDvdModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WModificar(1);
					
			}});			
	//Listar Dvd
			bDvdListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WListar(1);
			}});

	//Listar Exis Dvd
			bDvdListarExis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WListarExis(1);
			}});
	                                                
	//Listar Dur Dvd
			bDvdListarDur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WListarDur(1);
			}});
	
	//Listar Dir Dvd
			bDvdListarDir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WListarDir(1);
			}});
		
	//Ordenar Tit Dvd
			bDvdOrdenarTit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WOrdenarTit(1);
			}});
			
	//Ordenar Gen Dvd
			bDvdOrdenarGen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WOrdenarGen(1);
			}});
			
	//Ordenar Dur Dvd
			bDvdOrdenarDur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WOrdenarDur(1);
			}});
			
	//Cantidad Dvd
			bDvdCantidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WCantidad(1);
			}});
	
	//Cantidad Exis Dvd
			bDvdCantidadExis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WCantidadExis(1);
			}});
			
	//Compactar Dvd
			bDvdCompactar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WCompactar(1);
			}});
			
	// Hacer que al cerrarse la secundaria con la x de arriba a la derecha, se muestre la primaria
			windowDvd.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			windowPrincipal.setVisible(true);
			windowDvd.setVisible(false);
		}
		public void windowClosed(WindowEvent e) {
			windowPrincipal.setVisible(true);
			windowDvd.setVisible(false);
		}
	});	
	}

public static void WCds()
{
	windowCd = new JDialog(windowPrincipal, "Gestionar Cds");
	windowCd.setSize(280,743);
	windowCd.setLayout(null);
	windowCd.setResizable(false);
	windowCd.setVisible(true);
	
	JButton bCdAgregar = Boton("Agregar",50,5,175,50,windowCd);
	JButton bCdEliminar = Boton("Eliminar",50,55,175,50,windowCd);
	JButton bCdModificar = Boton("Modificar",50,105,175,50,windowCd);
	JButton bCdListar = Boton("Listar",50,155,175,50,windowCd);
	JButton bCdListarExis = Boton("Listar Exis",50,205,175,50,windowCd);
	JButton bCdListarDur = Boton("Listar Dur",50,255,175,50,windowCd);
	JButton bCdListarDir = Boton("Listar Dir",50,305,175,50,windowCd);
	JButton bCdOrdenarTit = Boton("Ordenar Tit",50,355,175,50,windowCd);
	JButton bCdOrdenarGen = Boton("Ordenar Gen",50,405,175,50,windowCd);
	JButton bCdOrdenarDur = Boton("Ordenar Dur",50,455,175,50,windowCd);
	JButton bCdCantidad = Boton("Cantidad",50,505,175,50,windowCd);
	JButton bCdCantidadExis = Boton("Cantidad Exis",50,555,175,50,windowCd);
	JButton bCdCantidadTemas = Boton("Cantidad Temas",50,605,175,50,windowCd);
	JButton bCdCompactar = Boton("Compactar",50,655,175,50,windowCd);

	//Agregar Cd
		bCdAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						WAgregar(2);
		}});
	//Eliminar Cd
			bCdEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WEliminar(2);
					
			}});
	//Modificar Cd
			bCdModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WModificar(2);
					
			}});			
	//Listar Cd
			bCdListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WListar(2);
			}});

	//Listar Exis Cd
			bCdListarExis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WListarExis(2);
			}});
	
	//Listar Dur Cd
			bCdListarDur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WListarDur(2);
			}});
	
	//Listar Dir Cd
			bCdListarDir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WListarDir(2);
			}});
		
	//Ordenar Tit Cd
			bCdOrdenarTit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WOrdenarTit(2);
			}});
			
	//Ordenar Gen Cd
			bCdOrdenarGen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WOrdenarGen(2);
			}});
			
	//Ordenar Dur Cd
			bCdOrdenarDur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WOrdenarDur(2);
			}});	
			
	//Cantidad Cd
			bCdCantidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						WCantidad(2);
			}});
	
	//Cantidad Exis Cd
			bCdCantidadExis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WCantidadExis(2);
			}});
			
	//Cantidad Temas Cd
			bCdCantidadTemas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WCantidadTemas(2);
			}});
			
	//Compactar Cd
			bCdCompactar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WCompactar(2);
			}});
			
	// Hacer que al cerrarse la secundaria con la x de arriba a la derecha, se muestre la primaria
			windowCd.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			windowPrincipal.setVisible(true);
			windowCd.setVisible(false);
		}
		public void windowClosed(WindowEvent e) {
			windowPrincipal.setVisible(true);
			windowCd.setVisible(false);
		}
	});	
}

	public static void WAgregar(final int cat)
	{
		final JDialog ventana;
		int altobot = 290; 
		int altovent = 400; 
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
			altovent=450;
			altobot=335;
		}
		
		final JDialog windowAgregar = new JDialog(ventana,"Agregar");// In your case the local variable you created is a 
		//reference but after the method finished there will be no more references and dialog's memory will be freed.
		
		windowAgregar.setSize(400,altovent);
		windowAgregar.setLayout(null);
		windowAgregar.setResizable(false);
		windowAgregar.setVisible(true);
		
		Label("Titulo:",50,30,100,30,windowAgregar);
		Label("Director:",50,70,100,30,windowAgregar);
		Label("Genero:",50,110,100,30,windowAgregar);
		Label("Duracion:",50,150,100,30,windowAgregar);
		Label("Existencia:",50,190,100,30,windowAgregar);
		Label("Comentario:",50,230,100,30,windowAgregar);	
		
		if(cat==2)
		{
			Label("Cant Temas:",50,270,100,30,windowAgregar);
		}
		
		final JTextField titulo = TextField(150,30,200,30,windowAgregar);
		final JTextField director = TextField(150,70,200,30,windowAgregar);
		final JTextField genero = TextField(150,110,200,30,windowAgregar);
		final JTextField duracion = TextField(150,150,200,30,windowAgregar);
		final JTextField existencia = TextField(150,190,200,30,windowAgregar);
		final JTextField comentario = TextField(150,230,200,30,windowAgregar);
		final JTextField cantTemas= TextField(150,270,200,30,windowAgregar);;
		
		if(cat==1)
		{
			cantTemas.setVisible(false);
		}

		JButton Agregar = Boton("Agregar",150,altobot,150,50,windowAgregar);
			
		//Agregar
				Agregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
	
						try {
							long pos=-1;
							pos= g.buscar(Utilidades.adaptar(titulo.getText(),25),cat);
							if (pos != -1){
								Mensaje("       Ese titulo ya existe!", windowAgregar);
								return;
							}else{	
								String exis= existencia.getText();
								if (!exis.equals("Si") && !exis.equals("No"))
								{
									Mensaje("      Ingrese un dato valido!", windowAgregar);
									return;
								}
								boolean existencia= false;
								if(exis.equals("Si")){
									existencia=true;
								}
								
								if (cat==1)
								{
									g.alta(new Dvd(Utilidades.adaptar(titulo.getText(),25), Utilidades.adaptar(director.getText(),15), Utilidades.adaptar(genero.getText(),15), Integer.parseInt(duracion.getText()), existencia, Utilidades.adaptar(comentario.getText(),15), true));
								}else{
									g.alta(new Cd(Utilidades.adaptar(titulo.getText(),25), Utilidades.adaptar(director.getText(),15), Utilidades.adaptar(genero.getText(),15), Integer.parseInt(duracion.getText()), existencia, Utilidades.adaptar(comentario.getText(),15), true,Integer.parseInt(cantTemas.getText())));
								}
								
							}
							//para salir de la ventana
							windowAgregar.setVisible(false);
							
							if (cat==1)
							{
								Mensaje("           Dvd agregado!", windowAgregar);
								return;
							}else{
								Mensaje("            Cd agregado!", windowAgregar);
								return;
							}
							
						}catch(Exception e1) {
							Mensaje("      Ingrese un dato valido!", windowAgregar);
							return;
						}
				}});
	}
	
	public static void WEliminar(final int cat)
	{
		final JDialog ventana;
			
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		final JDialog windowEliminar = new JDialog(ventana,"Eliminar");
		
		windowEliminar.setSize(400,200);
		windowEliminar.setLayout(null);
		windowEliminar.setResizable(false);
		windowEliminar.setVisible(true);
		
		Label("Titulo:",50,30,100,30,windowEliminar);
		final JTextField titulo = TextField(150,30,200,30,windowEliminar);
		
		JButton Eliminar = Boton("Eliminar",150,90,150,50,windowEliminar);
		//Eliminar
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				long pos;
				pos= g.buscar(Utilidades.adaptar(titulo.getText(),25),cat);
				if (pos != -1){
					g.eliminar(pos,cat);
					
					//para salir de la ventana
					windowEliminar.setVisible(false);
					
					if (cat==1) Mensaje("           Dvd eliminado!", windowEliminar);
					else Mensaje("           Cd eliminado!", windowEliminar);
					return;
				}else{
					if (cat==1) Mensaje("         El dvd no existe!", windowEliminar);
					else  Mensaje("          El cd no existe!", windowEliminar);
				}
				
			}catch(Exception e1) {
				Mensaje("      Ingrese un dato valido!", windowEliminar);
				return;
			}
		}});	
	}
	
	public static void WModificar(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		final JDialog windowModificar = new JDialog(ventana,"Modificar");
		
		windowModificar.setSize(400,200);
		windowModificar.setLayout(null);
		windowModificar.setResizable(false);
		windowModificar.setVisible(true);
		
		Label("Titulo:",50,30,100,30,windowModificar);
		final JTextField titulo = TextField(150,30,200,30,windowModificar);
		
		JButton Modificar = Boton("Modificar",150,90,150,50,windowModificar);
		//Buscar
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try{	
				int altobot = 290; 
				int altovent = 400; 
				if(cat==2)altovent=450;
				final long pos;
				pos= g.buscar(Utilidades.adaptar(titulo.getText(),25),cat);
				if (pos != -1){
					
					final JDialog windowModificar2 = new JDialog(ventana,"Modificar ");
					windowModificar2.setSize(400,altovent);
					windowModificar2.setLayout(null);
					windowModificar2.setResizable(false);
					windowModificar2.setVisible(true);
					
					Label("Titulo:",50,30,100,30,windowModificar2);
					Label("Director:",50,70,100,30,windowModificar2);
					Label("Genero:",50,110,100,30,windowModificar2);
					Label("Duracion:",50,150,100,30,windowModificar2);
					Label("Existencia:",50,190,100,30,windowModificar2);
					Label("Comentario:",50,230,100,30,windowModificar2);	
					
					if(cat==2)
					{
						Label("Cant Temas:",50,270,100,30,windowModificar2);	
						altobot=335;
					}
					
					final JTextField titulo = TextField(150,30,200,30,windowModificar2);
					final JTextField director = TextField(150,70,200,30,windowModificar2);
					final JTextField genero = TextField(150,110,200,30,windowModificar2);
					final JTextField duracion = TextField(150,150,200,30,windowModificar2);
					final JTextField existencia = TextField(150,190,200,30,windowModificar2);
					final JTextField comentario = TextField(150,230,200,30,windowModificar2);
					final JTextField cantTemas= TextField(150,270,200,30,windowModificar2);;
					
					if(cat==1)
					{
						cantTemas.setVisible(false);
					}

					JButton Modificar2 = Boton("Agregar",150,altobot,150,50,windowModificar2);
					
					Modificar2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
		
							try {
								final long pos2;
								pos2= g.buscar(Utilidades.adaptar(titulo.getText(),25),cat);
								if (pos2 != -1){
									Mensaje("       Ese titulo ya existe!", windowModificar2);
									return;
								}else{	
									String exis= existencia.getText();
									if (!exis.equals("Si") && !exis.equals("No"))
									{
										Mensaje("      Ingrese un dato valido!", windowModificar2);
										return;
									}
									boolean existencia= false;
									if(exis.equals("Si")){
										existencia=true;
									}
									
									if (cat==1)
									{
										g.modificar(pos, new Dvd(Utilidades.adaptar(titulo.getText(),25), Utilidades.adaptar(director.getText(),15), Utilidades.adaptar(genero.getText(),15), Integer.parseInt(duracion.getText()), existencia, Utilidades.adaptar(comentario.getText(),15), true));
									}else{
										g.modificar(pos, new Cd(Utilidades.adaptar(titulo.getText(),25), Utilidades.adaptar(director.getText(),15), Utilidades.adaptar(genero.getText(),15), Integer.parseInt(duracion.getText()), existencia, Utilidades.adaptar(comentario.getText(),15), true,Integer.parseInt(cantTemas.getText())));
									}
									
								windowModificar.setVisible(false);
								windowModificar2.setVisible(false);
								
								if (cat==1)
								{
									Mensaje("           Dvd modificado!", windowModificar2);
									
								}else{
									Mensaje("           Cd modificado!", windowModificar2);
								}
								
								return;
								
								}
							}catch(Exception e1) {
								Mensaje("      Ingrese un dato valido!", windowModificar2);
								return;
							}
					}});
					
				}else{ 
					if (cat==1) Mensaje("         El dvd no existe!", windowModificar);
					else  Mensaje("         El cd no existe!", windowModificar);
					return;
				}	
				
			}catch(Exception e1) {
				Mensaje("      Ingrese un dato valido!", windowModificar);
				return;
			}
	 }});
	}  
	
	public static void WListar(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		int cantl=0;
		int ancho=1000;
		final JDialog windowListar = new JDialog(ventana,"Listar");
		
		try{
			str=g.listarTodos(cat);
			if (str.equals(""))
			{				
				windowListar.setVisible(false);
				if (cat==1) Mensaje("           No hay dvds!", windowListar);
				else  Mensaje("           No hay cds!", windowListar);
				return;
				
			}
				
				for(int i=0;i<str.length();i++)
				     if(str.charAt(i)=='\n')
				          cantl++;
				
				if (cat==2) ancho=1200;
				
				windowListar.setSize(ancho,100+(30*cantl)+80);
				windowListar.setLayout(null);
				windowListar.setResizable(false);
				windowListar.setVisible(true);
				
				Label("Titulo",50,15,100,30,windowListar);
				Label("Genero",150,15,100,30,windowListar);
				Label("Existencia",300,15,100,30,windowListar);
				Label("Director",450,15,100,30,windowListar);
				Label("Comentario",600,15,100,30,windowListar);
				Label("Activo",750,15,100,30,windowListar);
				Label("Duracion",900,15,100,30,windowListar);
				
				
				if (cat==2)
				{
					Label("Cant Temas",1050,15,100,30,windowListar);
				}
				
				for(int i=0;i<ancho;i++)Label("-",i,50,800,30,windowListar);
				for(int i=0;i<ancho;i++)Label("-",i,((30*cantl)+80),800,30,windowListar);
				
				String[] separada = str.split("\\\n"); 
				
					for(int i=0;i<cantl;i++)
					{
						Label(separada[i],50,80+(30*i),ancho,30,windowListar);
					}			
				
		}catch(Exception e1) {
			Mensaje("      Ingrese un dato valido!", windowListar);
			return;
		}
	}
	
	public static void WListarExis(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		final JDialog windowListarExistencia = new JDialog(ventana,"Listar Existencia");
		windowListarExistencia.setSize(400,200);
		windowListarExistencia.setLayout(null);
		windowListarExistencia.setResizable(false);
		windowListarExistencia.setVisible(true);
			
		Label("Existencia:",50,30,100,30,windowListarExistencia);	
		
		final JTextField existencia = TextField(150,30,200,30,windowListarExistencia);

		JButton ListarExistencia = Boton("Listar Existencia",150,90,200,50,windowListarExistencia);
			
		//ListarExistencia
		ListarExistencia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					int cantl=0;
					int ancho=1000;
						
						try{
							
							if (!existencia.getText().equals("Si") && !existencia.getText().equals("No"))
							{	
								Mensaje("      Ingrese un dato valido!", windowListarExistencia);
								return;
							}
						
							str= g.listarPorExistencia(existencia.getText(), cat);
							
							if (str.equals(""))
							{
								windowListarExistencia.setVisible(false);
								
								if (cat==1) Mensaje("           No hay dvds!", windowListarExistencia);
								else  Mensaje("           No hay cds!", windowListarExistencia);
								return;
								
							}else{
								windowListarExistencia.setVisible(false);
								for(int i=0;i<str.length();i++)
								     if(str.charAt(i)=='\n')
								          cantl++;
								final JDialog windowListarExistencia2 = new JDialog(ventana,"Listar Existencia");
								
								if (cat==2) ancho=1200;
								
								windowListarExistencia2.setSize(ancho,100+(30*cantl)+80);
								windowListarExistencia2.setLayout(null);
								windowListarExistencia2.setResizable(false);
								windowListarExistencia2.setVisible(true);
								
								Label("Titulo",50,15,100,30,windowListarExistencia2);
								Label("Genero",150,15,100,30,windowListarExistencia2);
								Label("Existencia",300,15,100,30,windowListarExistencia2);
								Label("Director",450,15,100,30,windowListarExistencia2);
								Label("Comentario",600,15,100,30,windowListarExistencia2);
								Label("Activo",750,15,100,30,windowListarExistencia2);
								Label("Duracion",900,15,100,30,windowListarExistencia2);
								
								
								if (cat==2)
								{
									Label("Cant Temas",1050,15,100,30,windowListarExistencia2);
								}
								
								for(int i=0;i<ancho;i++)Label("-",i,50,800,30,windowListarExistencia2);
								for(int i=0;i<ancho;i++)Label("-",i,((30*cantl)+80),800,30,windowListarExistencia2);
								
								String[] separada = str.split("\\\n"); 
								
									for(int i=0;i<cantl;i++)
									{
										Label(separada[i],50,80+(30*i),ancho,30,windowListarExistencia2);
									}		
								}	
							
						}catch(Exception e1) {
							Mensaje("      Ingrese un dato valido!", windowListarExistencia);
							return;
						}
					}});	
	}
	
	public static void WListarDur(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		final JDialog windowListarDuracion = new JDialog(ventana,"Listar Duracion");
		windowListarDuracion.setSize(400,200);
		windowListarDuracion.setLayout(null);
		windowListarDuracion.setResizable(false);
		windowListarDuracion.setVisible(true);
			
		Label("Duracion:",50,30,100,30,windowListarDuracion);	
		
		final JTextField duracion = TextField(150,30,200,30,windowListarDuracion);

		JButton ListarDuracion = Boton("Listar Duracion",150,90,200,50,windowListarDuracion);
			
		//ListarDuracion
		ListarDuracion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					int cantl=0;
					int ancho=1000;
						
						try{
												
							str= g.listarPorDuracion(Integer.parseInt(duracion.getText()), cat);
							
							if (str.equals(""))
							{
								windowListarDuracion.setVisible(false);
								
								if (cat==1) Mensaje("           No hay dvds!", windowListarDuracion);
								else  Mensaje("           No hay cds!", windowListarDuracion);
								return;
								
							}else{
								
								windowListarDuracion.setVisible(false);
								for(int i=0;i<str.length();i++)
								     if(str.charAt(i)=='\n')
								          cantl++;
								final JDialog windowListarDuracion2 = new JDialog(ventana,"Listar Duracion");
								
								if (cat==2) ancho=1200;
								
								windowListarDuracion2.setSize(ancho,100+(30*cantl)+80);
								windowListarDuracion2.setLayout(null);
								windowListarDuracion2.setResizable(false);
								windowListarDuracion2.setVisible(true);
								
								Label("Titulo",50,15,100,30,windowListarDuracion2);
								Label("Genero",150,15,100,30,windowListarDuracion2);
								Label("Existencia",300,15,100,30,windowListarDuracion2);
								Label("Director",450,15,100,30,windowListarDuracion2);
								Label("Comentario",600,15,100,30,windowListarDuracion2);
								Label("Activo",750,15,100,30,windowListarDuracion2);
								Label("Duracion",900,15,100,30,windowListarDuracion2);
								
								
								if (cat==2)
								{
									Label("Cant Temas",1050,15,100,30,windowListarDuracion2);
								}
								
								for(int i=0;i<ancho;i++)Label("-",i,50,800,30,windowListarDuracion2);
								for(int i=0;i<ancho;i++)Label("-",i,((30*cantl)+80),800,30,windowListarDuracion2);
								
								String[] separada = str.split("\\\n"); 
								
									for(int i=0;i<cantl;i++)
									{
										Label(separada[i],50,80+(30*i),ancho,30,windowListarDuracion2);
									}		
								}	
							
						}catch(Exception e1) {
							Mensaje("      Ingrese un dato valido!", windowListarDuracion);
							return;
						}
					}});	
	}
	
	public static void WListarDir(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		final JDialog windowListarDirector = new JDialog(ventana,"Listar Director");
		windowListarDirector.setSize(400,200);
		windowListarDirector.setLayout(null);
		windowListarDirector.setResizable(false);
		windowListarDirector.setVisible(true);
			
		Label("Director:",50,30,100,30,windowListarDirector);	
		
		final JTextField director = TextField(150,30,200,30,windowListarDirector);

		JButton ListarDirector = Boton("Listar Director",150,90,200,50,windowListarDirector);
			
		//ListarDirector
		ListarDirector.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					int cantl=0;
					int ancho=1000;
						
						try{
						
							str= g.listarPorDirector(Utilidades.adaptar(director.getText(), 15), cat);
							
							if (str.equals(""))
							{
								windowListarDirector.setVisible(false);
								
								if (cat==1) Mensaje("           No hay dvds!", windowListarDirector);
								else  Mensaje("           No hay cds!", windowListarDirector);
								return;
								
							}else{
								
								windowListarDirector.setVisible(false);
								
								for(int i=0;i<str.length();i++)
								     if(str.charAt(i)=='\n')
								          cantl++;
								final JDialog windowListarDirector2 = new JDialog(ventana,"Listar Director");
								
								if (cat==2) ancho=1200;
								
								windowListarDirector2.setSize(ancho,100+(30*cantl)+80);
								windowListarDirector2.setLayout(null);
								windowListarDirector2.setResizable(false);
								windowListarDirector2.setVisible(true);
								
								Label("Titulo",50,15,100,30,windowListarDirector2);
								Label("Genero",150,15,100,30,windowListarDirector2);
								Label("Existencia",300,15,100,30,windowListarDirector2);
								Label("Director",450,15,100,30,windowListarDirector2);
								Label("Comentario",600,15,100,30,windowListarDirector2);
								Label("Activo",750,15,100,30,windowListarDirector2);
								Label("Duracion",900,15,100,30,windowListarDirector2);
								
								
								if (cat==2)
								{
									Label("Cant Temas",1050,15,100,30,windowListarDirector2);
								}
								
								for(int i=0;i<ancho;i++)Label("-",i,50,800,30,windowListarDirector2);
								for(int i=0;i<ancho;i++)Label("-",i,((30*cantl)+80),800,30,windowListarDirector2);
								
								String[] separada = str.split("\\\n"); 
								
									for(int i=0;i<cantl;i++)
									{
										Label(separada[i],50,80+(30*i),ancho,30,windowListarDirector2);
									}		
								}	
							
						}catch(Exception e1) {
							Mensaje("      Ingrese un dato valido!", windowListarDirector);
							return;
						}
					}});	
	}
	
	public static void WOrdenarTit(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		int cantl=0;
		int ancho=1000;
		final JDialog windowOrdenarTitulo = new JDialog(ventana,"Ordenar Titulo");
		
		try{
			str=g.ordenarPorTitulo(cat);
			if (str.equals(""))
			{				
				windowOrdenarTitulo.setVisible(false);
				if (cat==1) Mensaje("           No hay dvds!", windowOrdenarTitulo);
				else  Mensaje("           No hay cds!", windowOrdenarTitulo);
				return;
				
			}
				
				for(int i=0;i<str.length();i++)
				     if(str.charAt(i)=='\n')
				          cantl++;
				
				if (cat==2) ancho=1200;
				
				windowOrdenarTitulo.setSize(ancho,100+(30*cantl)+80);
				windowOrdenarTitulo.setLayout(null);
				windowOrdenarTitulo.setResizable(false);
				windowOrdenarTitulo.setVisible(true);
				
				Label("Titulo",50,15,100,30,windowOrdenarTitulo);
				Label("Genero",150,15,100,30,windowOrdenarTitulo);
				Label("Existencia",300,15,100,30,windowOrdenarTitulo);
				Label("Director",450,15,100,30,windowOrdenarTitulo);
				Label("Comentario",600,15,100,30,windowOrdenarTitulo);
				Label("Activo",750,15,100,30,windowOrdenarTitulo);
				Label("Duracion",900,15,100,30,windowOrdenarTitulo);
				
				
				if (cat==2)
				{
					Label("Cant Temas",1050,15,100,30,windowOrdenarTitulo);
				}
				
				for(int i=0;i<ancho;i++)Label("-",i,50,800,30,windowOrdenarTitulo);
				for(int i=0;i<ancho;i++)Label("-",i,((30*cantl)+80),800,30,windowOrdenarTitulo);
				
				String[] separada = str.split("\\\n"); 
				
					for(int i=0;i<cantl;i++)
					{
						Label(separada[i],50,80+(30*i),ancho,30,windowOrdenarTitulo);
					}			
				
		}catch(Exception e1) {
			Mensaje("      Ingrese un dato valido!", windowOrdenarTitulo);
			return;
		}
	}
	
	public static void WOrdenarGen(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		int cantl=0;
		int ancho=1000;
		final JDialog windowOrdenarGenero = new JDialog(ventana,"Ordenar Genero");
		
		try{
			str=g.ordenarPorGenero(cat);
			if (str.equals(""))
			{				
				windowOrdenarGenero.setVisible(false);
				if (cat==1) Mensaje("           No hay dvds!", windowOrdenarGenero);
				else  Mensaje("           No hay cds!", windowOrdenarGenero);
				return;
				
			}
				
				for(int i=0;i<str.length();i++)
				     if(str.charAt(i)=='\n')
				          cantl++;
				
				if (cat==2) ancho=1200;
				
				windowOrdenarGenero.setSize(ancho,100+(30*cantl)+80);
				windowOrdenarGenero.setLayout(null);
				windowOrdenarGenero.setResizable(false);
				windowOrdenarGenero.setVisible(true);
				
				Label("Titulo",50,15,100,30,windowOrdenarGenero);
				Label("Genero",150,15,100,30,windowOrdenarGenero);
				Label("Existencia",300,15,100,30,windowOrdenarGenero);
				Label("Director",450,15,100,30,windowOrdenarGenero);
				Label("Comentario",600,15,100,30,windowOrdenarGenero);
				Label("Activo",750,15,100,30,windowOrdenarGenero);
				Label("Duracion",900,15,100,30,windowOrdenarGenero);
				
				
				if (cat==2)
				{
					Label("Cant Temas",1050,15,100,30,windowOrdenarGenero);
				}
				
				for(int i=0;i<ancho;i++)Label("-",i,50,800,30,windowOrdenarGenero);
				for(int i=0;i<ancho;i++)Label("-",i,((30*cantl)+80),800,30,windowOrdenarGenero);
				
				String[] separada = str.split("\\\n"); 
				
				for(int i=0;i<cantl;i++)
				{
					Label(separada[i],50,80+(30*i),ancho,30,windowOrdenarGenero);
				}			
				
		}catch(Exception e1) {
			Mensaje("      Ingrese un dato valido!", windowOrdenarGenero);
			return;
		}
	}
	
	public static void WOrdenarDur(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		int cantl=0;
		int ancho=1000;
		final JDialog windowOrdenarDuracion = new JDialog(ventana,"Ordenar Duracion");
		
		try{
			str=g.ordenarPorDuracion(cat);
			if (str.equals(""))
			{				
				windowOrdenarDuracion.setVisible(false);
				if (cat==1) Mensaje("           No hay dvds!", windowOrdenarDuracion);
				else  Mensaje("           No hay cds!", windowOrdenarDuracion);
				return;
				
			}
				
				for(int i=0;i<str.length();i++)
				     if(str.charAt(i)=='\n')
				          cantl++;
				
				if (cat==2) ancho=1200;
				
				windowOrdenarDuracion.setSize(ancho,100+(30*cantl)+80);
				windowOrdenarDuracion.setLayout(null);
				windowOrdenarDuracion.setResizable(false);
				windowOrdenarDuracion.setVisible(true);
				
				Label("Titulo",50,15,100,30,windowOrdenarDuracion);
				Label("Genero",150,15,100,30,windowOrdenarDuracion);
				Label("Existencia",300,15,100,30,windowOrdenarDuracion);
				Label("Director",450,15,100,30,windowOrdenarDuracion);
				Label("Comentario",600,15,100,30,windowOrdenarDuracion);
				Label("Activo",750,15,100,30,windowOrdenarDuracion);
				Label("Duracion",900,15,100,30,windowOrdenarDuracion);
				
				
				if (cat==2)
				{
					Label("Cant Temas",1050,15,100,30,windowOrdenarDuracion);
				}
				
				for(int i=0;i<ancho;i++)Label("-",i,50,800,30,windowOrdenarDuracion);
				for(int i=0;i<ancho;i++)Label("-",i,((30*cantl)+80),800,30,windowOrdenarDuracion);
				
				String[] separada = str.split("\\\n"); 
				
					for(int i=0;i<cantl;i++)
					{
						Label(separada[i],50,80+(30*i),ancho,30,windowOrdenarDuracion);
					}			
				
		}catch(Exception e1) {
			Mensaje("      Ingrese un dato valido!", windowOrdenarDuracion);
			return;
		}
	}
	
	public static void WCantidad(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
			str="Cantidad de dvds: ";
		}else{
			ventana= windowCd;
			str="Cantidad de cds: ";
		}
		
		long cant=0;
		final JDialog windowCantidad = new JDialog(ventana,"Cantidad");
		
		try{
				cant=g.cant(cat);					
				Mensaje("       "+str+cant, windowCantidad);
				
		}catch(Exception e1) {
			Mensaje("      Ingrese un dato valido!", windowCantidad);
			return;
		}
	}
	
	public static void WCantidadExis(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
			str = "Cantidad de dvds ";
		}else{
			ventana= windowCd;
			str = "Cantidad de cds ";
		}
		
		final JDialog windowCantidadExistencia = new JDialog(ventana,"Cantidad Existencia");
		windowCantidadExistencia.setSize(450,200);
		windowCantidadExistencia.setLayout(null);
		windowCantidadExistencia.setResizable(false);
		windowCantidadExistencia.setVisible(true);
			
		Label("Existencia:",50,30,100,30,windowCantidadExistencia);	
		
		final JTextField existencia = TextField(150,30,200,30,windowCantidadExistencia);
		
		JButton CantidadExistencia = Boton("Cantidad Existencia",150,90,250,50,windowCantidadExistencia);
			
		//CantidadExistencia
		CantidadExistencia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							String str2="";
							String str3="";
							
							if (!existencia.getText().equals("Si") && !existencia.getText().equals("No"))
							{	
								Mensaje("      Ingrese un dato valido!", windowCantidadExistencia);
								return;
							}
							
							if (existencia.getText().equals("Si"))
							{	
								str2="existentes: ";
							}else
							{
								str2="inexistentes: ";
							}
							str3= g.listarPorExistencia(existencia.getText(),cat);
						
							str= str + str2 + g.cantPorExistencia(str3);
							
							windowCantidadExistencia.setVisible(false);
							
							final JDialog windowCantidadExistencia2 = new JDialog(ventana,"Cantidad Existencia");
							
							Mensaje(str, windowCantidadExistencia2);	
							
						}catch(Exception e1) {
							Mensaje("      Ingrese un dato valido!", windowCantidadExistencia);
							return;
						}
					}});	
	}
	
	public static void WCantidadTemas(final int cat)
	{
		final JDialog ventana;
			
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		final JDialog windowCantidadTemas = new JDialog(ventana,"Cantidad Temas");
		
		windowCantidadTemas.setSize(400,200);
		windowCantidadTemas.setLayout(null);
		windowCantidadTemas.setResizable(false);
		windowCantidadTemas.setVisible(true);
		
		Label("Titulo:",50,30,100,30,windowCantidadTemas);
		final JTextField titulo = TextField(150,30,200,30,windowCantidadTemas);
		
		JButton CantTemas = Boton("Cantidad Temas",150,90,200,50,windowCantidadTemas);
		//Eliminar
		CantTemas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				long pos;
				pos= g.buscar(Utilidades.adaptar(titulo.getText(),25),cat);
				if (pos != -1){
					str = "Cantidad de temas: " + g.cantTemas(pos);
					windowCantidadTemas.setVisible(false);
					final JDialog windowCantidadTemas2 = new JDialog(ventana,"Cantidad");			
					Mensaje("       "+str, windowCantidadTemas2);	
					
				}else{
					if (cat==1) Mensaje("         El dvd no existe!", windowCantidadTemas);
					else  Mensaje("          El cd no existe!", windowCantidadTemas);
				}
				
			}catch(Exception e1) {
				Mensaje("      Ingrese un dato valido!", windowCantidadTemas);
				return;
			}
		}});	
	}
	
	public static void WCompactar(final int cat)
	{
		final JDialog ventana;
		
		if (cat==1)
		{
			ventana= windowDvd;
		}else{
			ventana= windowCd;
		}
		
		final JDialog windowCompactar = new JDialog(ventana,"Compactar");
		
		try{			
			g.compactar(cat);
			Mensaje("        Compactacion Exitosa!", windowCompactar);	
				
		}catch(Exception e1) {
			Mensaje("      Ingrese un dato valido!", windowCompactar);
			return;
		}
	}
}
