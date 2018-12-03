package umu.tds.myvideoapp.dominio;

public class Etiqueta {

	private String nombre;
	
	public Etiqueta(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj == this)
			return true;
		if(!(obj instanceof Etiqueta))
			return false;

		Etiqueta copia = (Etiqueta) obj;
		return this.nombre.equals(copia.getNombre());
	}
	@Override
	public int hashCode() {
		return this.nombre.hashCode();
	}
}
