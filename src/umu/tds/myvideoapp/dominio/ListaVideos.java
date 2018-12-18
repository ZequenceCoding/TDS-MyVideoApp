package umu.tds.myvideoapp.dominio;

import java.util.LinkedList;
import java.util.List;
public class ListaVideos {

	private String nombreLista;
	private List<Video> videos;
	private int codigo;
	
	public ListaVideos(String nombreLista) {
		this.nombreLista = nombreLista;
		videos = new LinkedList<Video>();
	}

	
	/* devuelve todos los Videos de la lista */
	public List<Video> getVideos() {
		return new LinkedList<Video>(videos);
	}

	public Video getVideo(int codigo) {
		for (Video v : videos) {
			if (v.getCodigo() == codigo)
				return v;
		}
		return null;
	}

	public Video getVideo(String url) {
		for (Video v : videos) {
			if (v.getUrl() == url)
				return v;
		}
		return null;
	}
	
	public void addVideo(Video vid) {
		videos.add(vid);
	}
	
	public void removeVideo(String url) {
		videos.remove(getVideo(url));
	}
	
	/* getters and setters */
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreLista() {
		return nombreLista;
	}
	
	
}
