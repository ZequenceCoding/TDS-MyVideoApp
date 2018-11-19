package umu.tds.myvideoapp.dominio;

public class Video {

	private int codigo;
	private String url;
	private String titulo;
	private int numReproducciones;
	
	// Constructor
	public Video(String url, String titulo) {
		this.codigo = 0;
		this.url = url;
		this.titulo = titulo;
		this.numReproducciones = 0;
	}
	
	public Video(String url, String titulo, int numReproducciones) {
		this(url, titulo);
		this.numReproducciones = numReproducciones;
	}
	
	// Metodo para cuando se reproduce un video
	public int reproduce() {
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
	
	
}
