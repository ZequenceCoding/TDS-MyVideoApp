package umu.tds.myvideoapp.controlador;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import tds.video.VideoWeb;
import umu.tds.componente.VideosEvent;
import umu.tds.componente.VideosListener;
import umu.tds.myvideoapp.dao.*;
import umu.tds.myvideoapp.dominio.CatalogoUsuarios;
import umu.tds.myvideoapp.dominio.CatalogoVideos;
import umu.tds.myvideoapp.dominio.Etiqueta;
import umu.tds.myvideoapp.dominio.ITest;
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
	private Set<Etiqueta> etiquetas;
	private Set<Etiqueta> etiquetasSeleccionadas;
	
	private String textoBusqueda;


	public ControladorMyVideoApp() {
		System.out.println("Crea el controlador");
		inicializarAdaptadores();
		inicializarCatalogos();
		etiquetas = catalogoVideos.getEtiquetas();
		etiquetasSeleccionadas = new HashSet<Etiqueta>();
		textoBusqueda = "";
	}

	public static ControladorMyVideoApp getUnicaInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new ControladorMyVideoApp();
		return unicaInstancia;
	}

	public void registrarUsuario(String username, String password, String nombre, String apellidos, String email, Date date) {
		System.out.println(DateFormat.getDateInstance().format(date));
		Usuario usuario = new Usuario(username, password, nombre, apellidos, email, date);
		adaptadorUsuario.registrarUsuario(usuario);
		catalogoUsuarios.addUsuario(usuario);
	}

	public void registrarVideo(String url, String titulo, List<Etiqueta> etiquetas) {
		Video video = new Video(url, titulo, etiquetas);
		adaptadorVideo.registrarVideo(video);
		catalogoVideos.addVideo(video);
	}

	public boolean registrarListaVideos(String nombreLista) {
		if(usuarioActual.getListaVideos(nombreLista) != null)
			return false;
		usuarioActual.addListaVideos(nombreLista);
		adaptadorListaVideos.registrarListaVideos(usuarioActual.getListaVideos(nombreLista));
		adaptadorUsuario.modificarUsuario(usuarioActual);
		return true;
	}

	public void borrarListaVideos(String nombreLista) {
		adaptadorListaVideos.borrarListaVideos(usuarioActual.getListaVideos(nombreLista));
		usuarioActual.eliminarListaVideos(nombreLista);
		adaptadorUsuario.modificarUsuario(usuarioActual);
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
			System.out.println(usuario.getListasVideos());
			return true;
		}
		return false;
	}

	public void anadirVideoALista(String url, String nombreLista) {
		usuarioActual.anadirVideoALista(catalogoVideos.getVideo(url), nombreLista);
		adaptadorListaVideos.modificarListaVideos(usuarioActual.getListaVideos(nombreLista));
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public void verVideo(String url) {
		catalogoVideos.verVideo(url);
		usuarioActual.verVideo(catalogoVideos.getVideo(url));
		adaptadorUsuario.modificarUsuario(usuarioActual);
		adaptadorListaVideos.modificarListaVideos(usuarioActual.getRecientes());
		adaptadorVideo.modificarVideo(catalogoVideos.getVideo(url));
		videoWeb.playVideo(url);
	}

	public void stopVideo() {
		videoWeb.cancel();
	}
	
	/* Funciones auxiliares */
	private void inicializarAdaptadores() {
		System.out.println("Inicializa los adaptadores");
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println("Adaptador Video");
		adaptadorVideo = factoria.getVideoDAO();
		System.out.println("Adaptador Lista Videos");
		adaptadorListaVideos = factoria.getListaVideosDAO();
		System.out.println("Adaptador Usuario");
		adaptadorUsuario = factoria.getUsuarioDAO();

	}

	private void inicializarCatalogos() {
		System.out.println("Inicializa los catalogos");
		System.out.println("Catalogo videos");
		catalogoVideos = CatalogoVideos.getUnicaInstancia();
		System.out.println("Catalogo Usuario");
		catalogoUsuarios = CatalogoUsuarios.getUnicaInstancia();

	}

	
	private List<Video> videosConEtiquetasTextoYFiltro(){
		return catalogoVideos.getVideosConEtiquetasTextoYFiltro(etiquetasSeleccionadas, textoBusqueda, usuarioActual.getFiltro());
	}
	
	public JLabel[][] videosToArray() {
		LinkedList<Video> videos = (LinkedList<Video>) videosConEtiquetasTextoYFiltro();
		
		int nFilas = (int) (Math.ceil(videos.size()/3.0));
		JLabel tab[][] = new JLabel[nFilas][3];
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
	
	public JLabel[][] videosToArray(String nombreLista) {
		LinkedList<Video> videos = (LinkedList<Video>) usuarioActual.getVideosListaVideos(nombreLista);
		int nFilas = (int) (Math.ceil(videos.size()/3.0));
		JLabel tab[][] = new JLabel[nFilas][3];
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

	
	public boolean isEtiquetasSeleccionada(String nombreEtiqueta) {
		for (Etiqueta etiqueta : etiquetasSeleccionadas) {
			if(etiqueta.getNombre().equals(nombreEtiqueta))
				return true;
		}
		return false;
	}
	
	public void etiquetaSeleccionada(Etiqueta etiqueta) {
		for (Etiqueta etiquetaSeleccionada : etiquetasSeleccionadas) {
			if(etiquetaSeleccionada.getNombre().equals(etiqueta.getNombre())) {
				etiquetasSeleccionadas.remove(etiquetaSeleccionada);
				return;
			}	
		}
		etiquetasSeleccionadas.add(etiqueta);
		
	}
	public int getNumReproducciones(String url) {
		return catalogoVideos.getNumReproducciones(url);
	}
	
	public VideoWeb getVideoWeb() {
		return videoWeb;
	}
	
	@Override
	public void enteradoCambioVideos(VideosEvent evento) {
		System.out.println("Luz pulsado");
		if(evento == null)
			return;
		for (umu.tds.componente.Video video : evento.getNewVideo().getVideo()) {
			if (!existVideo(video.getUrl())) {
				LinkedList<Etiqueta> etiquetas = new LinkedList<Etiqueta>();
				for (umu.tds.componente.Etiqueta etiqueta : video.getEtiqueta()) {
					etiquetas.add(new Etiqueta(etiqueta.getNombre()));
				}
				registrarVideo(video.getUrl(), video.getTitulo(), etiquetas);
			}
		}
		etiquetas = catalogoVideos.getEtiquetas();
		System.out.println("Videos Registrados");
	}

	public List<Etiqueta> getEtiquetasVideo(String url) {
		return catalogoVideos.getEtiquetasVideo(url);
	}
	
	public Set<Etiqueta> getEtiquetas() {
		return new HashSet<Etiqueta>(etiquetas);
	}

	public String getUsuarioActualName() {
		return usuarioActual.getNombre();
	}

	public Object[] getListasUsuario() {
		return usuarioActual.getListasVideos().toArray();
	}

	public LinkedList<JCheckBox> getAnadirA(String url) {
		return usuarioActual.getAnadirA(url);
	}

	public boolean registrarEtiq(String url, String etiq) {
		if(catalogoVideos.contieneEtiq(url, etiq))
			return false;
		catalogoVideos.anadirEtiq(url, etiq);
		etiquetas.add(new Etiqueta(etiq));
		return true;
	}

	public JLabel[][] recientesToArray() {
		return usuarioActual.recientesToArray();
	}

	public JLabel[][] topToArray() {
		return catalogoVideos.topToArray();
	}

	public void buscaVideos(String text) {
		textoBusqueda = text;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void reproducirTodos(String tituloLista, int tiempo) {
		
	}

	public List<Video> getVideosLista(String tituloLista) {
		return usuarioActual.getVideosListaVideos(tituloLista); 
	}

	public List<ListaVideos> getListasVideosUsuario() {
		return usuarioActual.getListasVideos();
	}

	public void cambiaFiltro(ITest<Video> filtro) {
		usuarioActual.setFiltro(filtro);
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public String getFiltroActual() {
		return usuarioActual.getFiltro().getNombre();
	}

	public boolean isPremium() {
		return usuarioActual.isPremium();
	}

	public void doPremium() {
		usuarioActual.setPremium();
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public void listasToPDF(String nombre) throws FileNotFoundException, DocumentException {
		usuarioActual.listasToPDF(nombre);
	}


}
