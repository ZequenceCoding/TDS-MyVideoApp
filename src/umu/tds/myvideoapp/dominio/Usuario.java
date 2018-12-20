package umu.tds.myvideoapp.dominio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Usuario {
	
	private int codigo;
	private boolean premium;
	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	private Date fechaNac;
	private String email;
	private List<ListaVideos> listasVideos;
	private ListaVideos recientes;
	private ITest<Video> filtro;

	
	public Usuario(String username, String password, String nombre, String apellidos, String email, Date fechaNac) {
		this.codigo = 0;
		this.premium = false;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.email = email;
		this.listasVideos = new LinkedList<ListaVideos>();
		this.recientes = new ListaVideos("Recientes");
		this.filtro = new NoFiltro();
		System.out.println(fechaNac.toString());
	}
	
	public Usuario(Boolean premium, String username, String password, String nombre, String apellidos, String email,
			Date fechaNac, List<ListaVideos> listasVideos, ListaVideos recientes, ITest<Video> filtro) {
		this(username, password, nombre, apellidos, email, fechaNac);
		this.premium = premium;
		this.listasVideos = listasVideos;
		this.recientes = recientes;
		this.filtro = filtro;
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
	public Date getFechaNac() {
		return fechaNac;
	}
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

	public void eliminarListaVideos(String nombreLista) {
		listasVideos.remove(getListaVideos(nombreLista));
	}
	
	public void verVideo(Video video) {
		recientes.removeVideo(video.getUrl());
		recientes.addVideoPrincipio(video);
		if(recientes.getNumVideos() > 5)
			recientes.removeUltimoVideo();
	}

	public JLabel[][] recientesToArray() {
		return recientes.toArray();
	}

	public ListaVideos getRecientes() {
		return recientes;
	}
	
	public ITest<Video> getFiltro() {
		return filtro;
	}
	
	public void setFiltro(ITest<Video> filtro) {
		this.filtro = filtro;
	}

	public void listasToPDF(String nombre) throws FileNotFoundException, DocumentException {
		FileOutputStream archivo;
		archivo = new FileOutputStream(nombre + ".pdf");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		documento.add(new Paragraph("  "));
		for (ListaVideos listaVideos : listasVideos) {
			documento.add(listaVideos.nombreToParagraph());
			documento.add(listaVideos.videosToParagraph());
		}
		documento.close();
		
	}
	
}
