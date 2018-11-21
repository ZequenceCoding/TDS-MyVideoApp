package umu.tds.myvideoapp.controlador;

import java.util.LinkedList;
import java.util.List;

import umu.tds.componente.VideosEvent;
import umu.tds.componente.VideosListener;
import umu.tds.myvideoapp.dao.*;
import umu.tds.myvideoapp.dominio.CatalogoUsuarios;
import umu.tds.myvideoapp.dominio.CatalogoVideos;
import umu.tds.myvideoapp.dominio.Etiqueta;
import umu.tds.myvideoapp.dominio.ListaVideos;
import umu.tds.myvideoapp.dominio.Usuario;
import umu.tds.myvideoapp.dominio.Video;

public class ControladorMyVideoApp implements VideosListener {

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

	public void registrarVideo(String url, String titulo, List<Etiqueta> etiquetas) {
		Video video = new Video(url, titulo, etiquetas);
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

	public boolean existVideo(String url) {
		return catalogoVideos.getVideo(url) != null;
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
		usuarioActual.anadirVideoALista(catalogoVideos.getVideo(url), nombreLista);
		adaptadorListaVideos.modificarListaVideos(usuarioActual.getListaVideos(nombreLista));
	}

	public void verVideo(String url) {
		catalogoVideos.verVideo(url);
		adaptadorVideo.modificarVideo(catalogoVideos.getVideo(url));
	}

	/* Funciones auxiliares */
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

	@Override
	public void enteradoCambioVideos(VideosEvent evento) {
		System.out.println("Luz pulsado");
		for (umu.tds.componente.Video video : evento.getNewVideo().getVideo()) {
			if (!existVideo(video.getUrl())) {
				LinkedList<Etiqueta> etiquetas = new LinkedList<Etiqueta>();
				for (umu.tds.componente.Etiqueta etiqueta : video.getEtiqueta()) {
					etiquetas.add(new Etiqueta(etiqueta.getNombre()));
				}
				registrarVideo(video.getUrl(), video.getTitulo(), etiquetas);
			}
		}
		System.out.println("Videos Registrados");
	}
}
