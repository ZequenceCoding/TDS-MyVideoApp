package umu.tds.myvideoapp.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.myvideoapp.dominio.Usuario;
import umu.tds.myvideoapp.dominio.Video;
import umu.tds.myvideoapp.dominio.ITest;
import umu.tds.myvideoapp.dominio.ListaVideos;
import umu.tds.myvideoapp.dominio.NoFiltro;
import beans.Entidad;
import beans.Propiedad;

public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO{

	private static ServicioPersistencia servPersistencia;
	private static AdaptadorUsuarioTDS unicaInstancia = null;

	
	public static AdaptadorUsuarioTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorUsuarioTDS();
		else
			return unicaInstancia;
	}	
	
	public AdaptadorUsuarioTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia(); 
	}

	public void registrarUsuario(Usuario usuario) {
		Entidad eUsuario;
		boolean existe = true;

		// Si la entidad est� registrada no la registra de nuevo
		try {
			eUsuario = servPersistencia.recuperarEntidad(usuario.getCodigo());
		} catch (NullPointerException e) {
			existe = false;
		}
		if (existe)
			return;
		// registrar primero los atributos que son objetos
		AdaptadorListaVideosTDS adaptadorListaVideos = AdaptadorListaVideosTDS.getUnicaInstancia();
		for (ListaVideos lv : usuario.getListasVideos()) {
			adaptadorListaVideos.registrarListaVideos(lv);
		}
		
		adaptadorListaVideos.registrarListaVideos(usuario.getRecientes());

		// crear entidad Usuario
		eUsuario = new Entidad();
		eUsuario.setNombre("usuario");
		eUsuario.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("premium", String.valueOf(usuario.isPremium())),
						new Propiedad("username", usuario.getUsername()),
						new Propiedad("password", usuario.getPassword()),
						new Propiedad("nombre", usuario.getPassword()),
						new Propiedad("apellidos", usuario.getApellidos()),
						new Propiedad("fechaNac", obtenerStringDeFecha(usuario.getFechaNac())),
						new Propiedad("email", usuario.getEmail()),
						new Propiedad("listasVideos", obtenerCodigosListaVideos(usuario.getListasVideos())),
						new Propiedad("recientes", String.valueOf(usuario.getRecientes().getCodigo())),
						new Propiedad("filtro", usuario.getFiltro().getNombreClase())
						)));

		// registrar entidad cliente
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		usuario.setCodigo(eUsuario.getId());
	}
	



	public void borrarUsuario(Usuario usuario) {
		Entidad eUsuario= servPersistencia.recuperarEntidad(usuario.getCodigo());
		servPersistencia.borrarEntidad(eUsuario);
	}
	
	
	public void modificarUsuario(Usuario usuario ) {
		Entidad eUsuario = servPersistencia.recuperarEntidad(usuario.getCodigo());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "premium");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "premium", String.valueOf(usuario.isPremium()));
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "username");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "username", usuario.getUsername());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "password");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "password",usuario.getPassword());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "nombre");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "nombre", usuario.getNombre());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "apellidos");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "apellidos", usuario.getApellidos());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "fechaNac");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "fechaNac", obtenerStringDeFecha(usuario.getFechaNac()));
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "email");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "email",usuario.getEmail());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "listasVideos");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "listasVideos", obtenerCodigosListaVideos(usuario.getListasVideos()));
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "recientes");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "recientes", String.valueOf(usuario.getRecientes().getCodigo()));
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "filtro");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "filtro", usuario.getFiltro().getNombreClase());
	}
	
	@SuppressWarnings("unchecked")
	public Usuario recuperarUsuario(int codigo) {
		// Si la entidad est� en el pool la devuelve directamente
				if (PoolDAO.getUnicaInstancia().contiene(codigo))
					return (Usuario) PoolDAO.getUnicaInstancia().getObjeto(codigo);

				// si no, la recupera de la base de datos
				Entidad eUsuario;
				Boolean premium;
				String username;
				String password;
				String nombre;
				String apellidos;
				Date fechaNac;
				String email;
				List<ListaVideos> listasVideos;
				ListaVideos recientes;
				ITest<Video> filtro = null;

				// recuperar entidad
				eUsuario = servPersistencia.recuperarEntidad(codigo);

				// recuperar propiedades que no son objetos
				premium = Boolean.valueOf(servPersistencia.recuperarPropiedadEntidad(eUsuario, "premium"));
				username = servPersistencia.recuperarPropiedadEntidad(eUsuario, "username");
				password = servPersistencia.recuperarPropiedadEntidad(eUsuario, "password");
				nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
				apellidos = servPersistencia.recuperarPropiedadEntidad(eUsuario, "apellidos");
				email = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
				fechaNac = obtenerFechaDeString(servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaNac"));
				listasVideos = obtenerListaVideosDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eUsuario, "listasVideos"));
				recientes = AdaptadorListaVideosTDS.getUnicaInstancia().recuperarListaVideos(
						Integer.parseInt(servPersistencia.recuperarPropiedadEntidad(eUsuario, "recientes")));
				try {
					System.out.println(servPersistencia.recuperarPropiedadEntidad(eUsuario, "filtro"));
					filtro = (ITest<Video>) Class.forName(servPersistencia.recuperarPropiedadEntidad(eUsuario, "filtro")).newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Usuario usuario = new Usuario(premium, username, password, nombre, apellidos, email, fechaNac, listasVideos, recientes, filtro);
				usuario.setCodigo(codigo);

				// IMPORTANTE:a�adir el cliente al pool antes de llamar a otros
				// adaptadores
				PoolDAO.getUnicaInstancia().addObjeto(codigo, usuario);

				return usuario;
	}
	
	public List<Usuario> recuperarTodosUsuarios() {
		List<Entidad> entidades = servPersistencia.recuperarEntidades("usuario");
		
		List<Usuario> usuarios  = new LinkedList<Usuario>();
		
		for (Entidad eUsuario : entidades) {
			usuarios.add(recuperarUsuario(eUsuario.getId()));
		}
		
		return usuarios;
	}
	
	/* Funciones auxiliares*/
	
	private String obtenerCodigosListaVideos(List<ListaVideos> listaListaVideoss) {
		String aux = "";
		for (ListaVideos v : listaListaVideoss) {
			aux += v.getCodigo() + " ";
		}
		return aux.trim();
	}
	
	private List<ListaVideos> obtenerListaVideosDesdeCodigos(String listasVideos) {

		List<ListaVideos> listaListaVideos = new LinkedList<ListaVideos>();
		if(listasVideos == null)
			return listaListaVideos;
		StringTokenizer strTok = new StringTokenizer(listasVideos, " ");
		AdaptadorListaVideosTDS adaptadorV = AdaptadorListaVideosTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			listaListaVideos.add(adaptadorV.recuperarListaVideos(Integer.valueOf((String) strTok.nextElement())));
		}
		return listaListaVideos;
	}

	private String obtenerStringDeFecha(Date fechaNac) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(fechaNac);
	}
	
	private Date obtenerFechaDeString(String fecha) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return df.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
	}
	
}
