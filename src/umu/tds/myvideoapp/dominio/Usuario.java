package umu.tds.myvideoapp.dominio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JCheckBox;

public class Usuario {
	
	private int codigo;
	private boolean premium;
	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	//private Date fechaNac;
	private String email;
	private List<ListaVideos> listasVideos;
	
	public Usuario(String username, String password, String nombre, String apellidos, String email) {
		this.codigo = 0;
		this.premium = false;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		//this.fechaNac = fechaNac;
		this.email = email;
		this.listasVideos = new LinkedList<ListaVideos>();
	}
	
	public Usuario(Boolean premium, String username, String password, String nombre, String apellidos, String email,
			List<ListaVideos> listasVideos) {
		this(username, password, nombre, apellidos, email);
		this.premium = premium;
		this.listasVideos = listasVideos;
	}

	public void addListaVideos(String nombreLista) {
		listasVideos.add(new ListaVideos(nombreLista));
	}
	
	public ListaVideos getListaVideos(String nombreLista) {
		for (ListaVideos listaVideos : listasVideos) {
			if(listaVideos.getNombreLista().equals(nombreLista))
				return listaVideos;
		}
		return null;
	}
	
	public void anadirVideoALista(Video video, String nombreLista) {
		if(getListaVideos(nombreLista).getVideo(video.getUrl()) != null) {
			getListaVideos(nombreLista).removeVideo(video.getUrl());
			return;
		}
		getListaVideos(nombreLista).addVideo(video);

	}
	// Gets and Sets
	public int getCodigo() {
		return codigo;
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

	public List<ListaVideos> getListasVideos() {
		return new LinkedList<ListaVideos>(this.listasVideos);
	}
	public void setCodigo(int id) {
		this.codigo = id;
	}

	public List<Video> getVideosListaVideos(String nombreLista) {
		return getListaVideos(nombreLista).getVideos();
	}

	public LinkedList<JCheckBox> getAnadirA(String url) {
		LinkedList<JCheckBox> lista = new LinkedList<JCheckBox>();
		for (ListaVideos listaVideos : listasVideos) {
			JCheckBox checkBox = new JCheckBox();
			checkBox.setText(listaVideos.getNombreLista());
			checkBox.setName(listaVideos.getNombreLista());
			checkBox.setSelected(listaVideos.getVideo(url) != null);
			lista.add(checkBox);
			
		}
		return lista;
	}
	
}
