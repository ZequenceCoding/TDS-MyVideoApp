package umu.tds.myvideoapp.dominio;

import java.util.ArrayList;
import java.util.List;
public class ListaVideos {

	private String nombreLista;
	private List<Video> videos;
	private int id;
	
	public ListaVideos(String nombreLista) {
		this.nombreLista = nombreLista;
		videos = new ArrayList<Video>();
	}

	
	/* devuelve todos los Videos de la lista */
	public List<Video> getVideos() {
		return new ArrayList<Video>(videos);
	}

	public Video getVideo(int codigo) {
		for (Video v : videos) {
			if (v.getCodigo() == codigo)
				return v;
		}
		return null;
	}

	public Video getVideo(String titulo) {
		for (Video v : videos) {
			if (v.getTitulo() == titulo)
				return v;
		}
		return null;
	}
	
	public void addVideo(Video vid) {
		videos.add(vid);
	}
	
	
	/* getters and setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreLista() {
		return nombreLista;
	}
	
	
}
