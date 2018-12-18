package umu.tds.myvideoapp.dominio;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Video {

	private int codigo;
	private String url;
	private String titulo;
	private int numReproducciones;
	private List<Etiqueta> etiquetas;
	
	// Constructor
	public Video(String url, String titulo, List<Etiqueta> etiquetas) {
		this.codigo = 0;
		this.url = url;
		this.titulo = titulo;
		this.numReproducciones = 0;
		this.etiquetas = etiquetas;
	}
	
	public Video(String url, String titulo, int numReproducciones, List<Etiqueta> etiquetas) {
		this(url, titulo, etiquetas);
		this.numReproducciones = numReproducciones;
	}
	
	// Metodo para cuando se reproduce un video
	public int verVideo() {
		this.numReproducciones++;
		return this.numReproducciones;
	}
	
	//Gets && sets
	public int getCodigo() {
		return codigo;
	}
	public String getUrl() {
		return url;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getNumReproducciones() {
		return numReproducciones;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public List<Etiqueta> getEtiquetas() {
		return new LinkedList<>(etiquetas);
	}

	public boolean contieneEtiqueta(Set<Etiqueta> etiquetasSeleccionadas) {
		for (Etiqueta etiqueta : etiquetasSeleccionadas) {
			if (etiquetas.contains(etiqueta)) {
				return true;
			}
		}
		return false;
	}

	public boolean contieneEtiqueta(String etiq) {
		for (Etiqueta etiqueta : etiquetas) {
			if (etiqueta.getNombre().equals(etiq)) {
				return true;
			}
		}
		return false;
	}

	public void addEtiqueta(String etiq) {
		etiquetas.add(new Etiqueta(etiq));
	}
	
}
