package umu.tds.myvideoapp.dominio;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private int id;
	private boolean premium;
	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	//private Date fechaNac;
	private String email;
	private List<ListaVideos> listasVideos;
	
	public Usuario(String username, String password, String nombre, String apellidos, String email) {
		this.id = 0;
		this.premium = false;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		//this.fechaNac = fechaNac;
		this.email = email;
		this.listasVideos = new LinkedList<ListaVideos>();
	}
	
	public void addListaVideos(ListaVideos listaVideos) {
		listasVideos.add(listaVideos);
	}
	
	public ListaVideos getListaVideos(String nombreLista) {
		for (ListaVideos listaVideos : listasVideos) {
			if(listaVideos.getNombreLista().equals(nombreLista))
				return listaVideos;
		}
		return null;
	}
	// Gets and Sets
	public int getId() {
		return id;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium() {
		this.premium = !this.premium;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	/*public Date getFechaNac() {
		return fechaNac;
	}*/
	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
