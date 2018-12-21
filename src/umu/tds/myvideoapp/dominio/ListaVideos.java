package umu.tds.myvideoapp.dominio;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

import com.itextpdf.text.Paragraph;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;

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
	
	public void addVideoPrincipio(Video vid) {
		((LinkedList<Video>)videos).addFirst(vid);
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


	public int getNumVideos() {
		return videos.size();
	}


	public void removeUltimoVideo() {
		((LinkedList<Video>) videos).removeLast();
	}


	public JLabel[][] toArray() {
		System.out.println("Llega");
		int nFilas = (int) (Math.ceil(videos.size()/3.0));
		JLabel tab[][] = new JLabel[nFilas][3];
		int k = 0;
		for (int i = 0; i < nFilas; i++) {
			for (int j = 0; j < 3; j++) {
				if(k >= videos.size())
					break;
				tab[i][j] = new JLabel();
				tab[i][j].setIcon(ControladorMyVideoApp.getUnicaInstancia().getVideoWeb().getThumb(videos.get(k).getUrl()));
				tab[i][j].setText(videos.get(k).getTitulo());
				System.out.println(videos.get(k).getTitulo());
				System.out.println("Hola");
				tab[i][j].setHorizontalTextPosition(JLabel.CENTER);
				tab[i][j].setVerticalTextPosition(JLabel.BOTTOM);
				tab[i][j].setForeground(Color.WHITE);
				tab[i][j].setName(videos.get(k).getUrl());
				k++;
			}
		}

		return tab;
	}


	public Paragraph nombreToParagraph() {
		return new Paragraph(nombreLista);
	}


	public Paragraph videosToParagraph() {
		String cadVideos = "";
		for (Video video : videos) {
			cadVideos += "      Titulo video: " + video.getTitulo() + "      Numero de reproducciones: " + video.getNumReproducciones() + "\n";
		}
		return new Paragraph(cadVideos);
	}
	
	
}
