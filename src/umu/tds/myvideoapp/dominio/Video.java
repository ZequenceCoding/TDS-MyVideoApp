package umu.tds.myvideoapp.dominio;

import java.util.HashSet;
import java.util.Set;

public class Video {

	private int codigo;
	private String url;
	private String titulo;
	private int numReproducciones;
	private Set<Etiqueta> etiquetas;
	
	// Constructor
	public Video(String url, String titulo) {
		this.codigo = 0;
		this.url = url;
		this.titulo = titulo;
		this.numReproducciones = 0;
		this.etiquetas = new HashSet<Etiqueta>();
	}
	
	public Video(String url, String titulo, int numReproducciones, Set<Etiqueta> etiquetas) {
		this(url, titulo);
		this.numReproducciones = numReproducciones;
		this.etiquetas = etiquetas;
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
	
	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	
	
}
