package umu.tds.myvideoapp.controlador;

import java.awt.Color;
import java.awt.Label;
import java.awt.LayoutManager;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import tds.video.VideoWeb;
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
	private static VideoWeb videoWeb = new VideoWeb();


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
		videoWeb.playVideo(url);
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

	public JLabel[][] videosToArray() {
		int nFilas = (int) (Math.ceil(catalogoVideos.getVideos().size()/3.0));
		System.out.println(catalogoVideos.getVideos().size() + " >> "+ Math.ceil(catalogoVideos.getVideos().size()));
		System.out.println(nFilas);
		JLabel tab[][] = new JLabel[nFilas][3];
		LinkedList<Video> videos = (LinkedList<Video>) catalogoVideos.getVideos();
		int k = 0;
		for (int i = 0; i < nFilas; i++) {
			for (int j = 0; j < 3; j++) {
				if(k >= videos.size())
					break;
				tab[i][j] = new JLabel();
				tab[i][j].setIcon(videoWeb.getThumb(videos.get(k).getUrl()));
				tab[i][j].setText(videos.get(k).getTitulo());
				tab[i][j].setHorizontalTextPosition(JLabel.CENTER);
				tab[i][j].setVerticalTextPosition(JLabel.BOTTOM);
				tab[i][j].setForeground(Color.WHITE);
				tab[i][j].setName(videos.get(k).getUrl());
				k++;
			}
		}

		return tab;
	}
	
	public JTable videosToTable() {
		int nFilas = (int) Math.ceil(catalogoVideos.getVideos().size());
		LinkedList<Video> videos = (LinkedList<Video>) catalogoVideos.getVideos();
		ImageIcon icon[][] = new ImageIcon[][] {{videoWeb.getThumb(videos.get(0).getUrl())}};
		/*
		int k = 0;
		for (int i = 0; i < nFilas; i++) {
			for (int j = 0; j < 3; j++) {
				if(k >= videos.size())
					break;
				tabla.set(videoWeb.getThumb(videos.get(k).getUrl()), k);
				k++;
			}
		}
		*/
		JTable tabla = new JTable(icon, new String[]{""}) ;
		return tabla;
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
