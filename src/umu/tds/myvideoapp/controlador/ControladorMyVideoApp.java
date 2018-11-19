package umu.tds.myvideoapp.controlador;

import umu.tds.myvideoapp.dao.*;
import umu.tds.myvideoapp.dominio.CatalogoUsuarios;
import umu.tds.myvideoapp.dominio.CatalogoVideos;
import umu.tds.myvideoapp.dominio.ListaVideos;
import umu.tds.myvideoapp.dominio.Usuario;
import umu.tds.myvideoapp.dominio.Video;

public class ControladorMyVideoApp {

	private static ControladorMyVideoApp unicaInstancia;

	private IAdaptadorListaVideosDAO adaptadorListaVideos;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorVideoDAO adaptadorVideo;

	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoVideos catalogoVideos;

	private Usuario usuarioActual;

	public ControladorMyVideoApp() {
		inicializarAdaptadores();

		inicializarCatalogos();
	}

	public static ControladorMyVideoApp getUnicaInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new ControladorMyVideoApp();
		return unicaInstancia;
	}

	public void registrarUsuario(String username, String password, String nombre, String apellidos, String email) {
		Usuario usuario = new Usuario(username, password, nombre, apellidos, email);
		adaptadorUsuario.registrarUsuario(usuario);
		catalogoUsuarios.addUsuario(usuario);
	}

	public void registrarVideo(String url, String titulo) {
		Video video = new Video(url, titulo);
		adaptadorVideo.registrarVideo(video);
		catalogoVideos.addVideo(video);
	}

	public void registrarListaVideos(String nombreLista) {
		ListaVideos listaVideos = new ListaVideos(nombreLista);
		adaptadorListaVideos.registrarListaVideos(listaVideos);
		usuarioActual.addListaVideos(listaVideos);
	}

	public boolean existUsername(String username) {
		return catalogoUsuarios.getUsuario(username) != null;
	}

	public boolean loginUsuario(String username, String password) {
		Usuario usuario = catalogoUsuarios.getUsuario(username);
		if (usuario == null)
			return false;
		if (usuario.getPassword().equals(password)) {
			usuarioActual = usuario;
			return true;
		}
		return false;
	}
	
	public void anadirVideoALista(String url, String nombreLista) {
		ListaVideos listaVideos = usuarioActual.getListaVideos(nombreLista);
		listaVideos.addVideo(catalogoVideos.getVideo(url));
		adaptadorListaVideos.modificarListaVideos(listaVideos);
	}
	
	private void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorListaVideos = factoria.getListaVideosDAO();
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorVideo = factoria.getVideoDAO();
	}

	private void inicializarCatalogos() {
		catalogoUsuarios = CatalogoUsuarios.getUnicaInstancia();
		catalogoVideos = CatalogoVideos.getUnicaInstancia();
	}
}
