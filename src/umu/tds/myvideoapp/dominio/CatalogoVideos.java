package umu.tds.myvideoapp.dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import umu.tds.myvideoapp.dao.DAOException;
import umu.tds.myvideoapp.dao.FactoriaDAO;
import umu.tds.myvideoapp.dao.IAdaptadorVideoDAO;

/* El cat�logo mantiene los objetos en memoria, en una tabla hash
 * para mejorar el rendimiento. Esto no se podr�a hacer en una base de
 * datos con un n�mero grande de objetos. En ese caso se consultar�a
 * directamente la base de datos
 */
public class CatalogoVideos {
	private Map<String, Video> videos;
	private static CatalogoVideos unicaInstancia;

	private FactoriaDAO dao;
	private IAdaptadorVideoDAO adaptadorVideo;

	private CatalogoVideos() {
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorVideo = dao.getVideoDAO();
			videos = new HashMap<String, Video>();
			this.cargarCatalogo();
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}

	public static CatalogoVideos getUnicaInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new CatalogoVideos();
		return unicaInstancia;
	}

	/* devuelve todos los Usuarios */
	public List<Video> getVideos() {
		LinkedList<Video> lista = new LinkedList<Video>();
		for (Video c : videos.values())
			lista.add(c);
		return lista;
	}

	public Video getVideo(int codigo) {
		for (Video p : videos.values()) {
			if (p.getCodigo() == codigo)
				return p;
		}
		return null;
	}

	public Video getVideo(String url) {
		return videos.get(url);
	}

	public void addVideo(Video vid) {
		videos.put(vid.getUrl(), vid);
	}

	public void removeVideo(Video vid) {
		videos.remove(vid.getUrl());
	}

	public void verVideo(String url) {
		videos.get(url).verVideo();
	}
	
	public int getNumReproducciones(String url) {
		return videos.get(url).getNumReproducciones();
	}
	
	public List<Etiqueta> getEtiquetasVideo(String url) {
		return videos.get(url).getEtiquetas();
	}
	
	public Set<Etiqueta> getEtiquetas() {
		Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
		for (Video video : videos.values()) {
			etiquetas.addAll(video.getEtiquetas());
		}
		return etiquetas;
	}
	/* Recupera todos los Usuarios para trabajar con ellos en memoria */
	private void cargarCatalogo() throws DAOException {
		List<Video> UsuariosBD = adaptadorVideo.recuperarTodosVideos();
		for (Video vid : UsuariosBD)
			videos.put(vid.getUrl(), vid);
	}

	public List<Video> getVideosConEtiquetas(Set<Etiqueta> etiquetasSeleccionadas) {
		if(etiquetasSeleccionadas.isEmpty())
			return getVideos();
		List<Video> videosConEtiquetas = new LinkedList<Video>();
		for (Video video : videos.values()) {
			if (video.contieneEtiqueta(etiquetasSeleccionadas)) {
				videosConEtiquetas.add(video);
			}
		}
		return videosConEtiquetas;
	}

	public boolean contieneEtiq(String url, String etiq) {
		return videos.get(url).contieneEtiqueta(etiq);
	}

	public void anadirEtiq(String url, String etiq) {
		videos.get(url).addEtiqueta(etiq);
	}

}
