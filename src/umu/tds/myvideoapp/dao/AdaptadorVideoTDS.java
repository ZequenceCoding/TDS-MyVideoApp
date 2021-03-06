package umu.tds.myvideoapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.myvideoapp.dominio.Etiqueta;
import umu.tds.myvideoapp.dominio.Video;
import beans.Entidad;
import beans.Propiedad;

public class AdaptadorVideoTDS implements IAdaptadorVideoDAO {

	private static ServicioPersistencia servPersistencia;
	private static AdaptadorVideoTDS unicaInstancia = null;

	public static AdaptadorVideoTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorVideoTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorVideoTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	@Override
	public void registrarVideo(Video video) {
		Entidad eVideo;
		boolean existe = true;

		// Si la entidad est� registrada no la registra de nuevo
		try {
			eVideo = servPersistencia.recuperarEntidad(video.getCodigo());
		} catch (NullPointerException e) {
			existe = false;
		}
		if (existe)
			return;

		// crear entidad
		eVideo = new Entidad();
		eVideo.setNombre("video");
		eVideo.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("url", video.getUrl()), new Propiedad("titulo", video.getTitulo()),
						new Propiedad("numReproducciones", String.valueOf(video.getNumReproducciones())),
						new Propiedad("etiquetas", obtenerNombresEtiquetas(video.getEtiquetas())))));

		// registrar entidad 
		eVideo = servPersistencia.registrarEntidad(eVideo);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		video.setCodigo(eVideo.getId());
	}



	@Override
	public void borrarVideo(Video video) {
		Entidad eVideo = servPersistencia.recuperarEntidad(video.getCodigo());

		servPersistencia.borrarEntidad(eVideo);

	}

	@Override
	public void modificarVideo(Video video) {
		Entidad eVideo = servPersistencia.recuperarEntidad(video.getCodigo());

		servPersistencia.eliminarPropiedadEntidad(eVideo, "url");
		servPersistencia.anadirPropiedadEntidad(eVideo, "url", video.getUrl());
		
		servPersistencia.eliminarPropiedadEntidad(eVideo, "titulo");
		servPersistencia.anadirPropiedadEntidad(eVideo, "titulo", video.getTitulo());

		servPersistencia.eliminarPropiedadEntidad(eVideo, "numReproducciones");
		servPersistencia.anadirPropiedadEntidad(eVideo, "numReproducciones",
				String.valueOf(video.getNumReproducciones()));
		
		servPersistencia.eliminarPropiedadEntidad(eVideo, "etiquetas");
		servPersistencia.anadirPropiedadEntidad(eVideo, "etiquetas", 
				obtenerNombresEtiquetas(video.getEtiquetas()));
	}

	@Override
	public Video recuperarVideo(int codigo) {
		// Si la entidad est� en el pool la devuelve directamente
		if (PoolDAO.getUnicaInstancia().contiene(codigo))
			return (Video) PoolDAO.getUnicaInstancia().getObjeto(codigo);

		// si no, la recupera de la base de datos
		Entidad eVideo;
		String url;
		String titulo;
		int numReproducciones;
		List<Etiqueta> etiquetas;

		// recuperar entidad
		eVideo = servPersistencia.recuperarEntidad(codigo);

		// recuperar propiedades que no son objetos
		url = servPersistencia.recuperarPropiedadEntidad(eVideo, "url");
		titulo = servPersistencia.recuperarPropiedadEntidad(eVideo, "titulo");
		numReproducciones = Integer.parseInt(servPersistencia.recuperarPropiedadEntidad(eVideo, "numReproducciones"));
		etiquetas = obtenerEtiquetasDesdeNombres(servPersistencia.recuperarPropiedadEntidad(eVideo, "etiquetas"));
		
		Video video = new Video(url, titulo, numReproducciones, etiquetas);
		video.setCodigo(codigo);

		// IMPORTANTE:a�adir el cliente al pool antes de llamar a otros
		// adaptadores
		PoolDAO.getUnicaInstancia().addObjeto(codigo, video);

		return video;
	}

	@Override
	public List<Video> recuperarTodosVideos() {
		List<Entidad> entidades = servPersistencia.recuperarEntidades("video");

		List<Video> videos = new LinkedList<Video>();

		for (Entidad eVideo : entidades) {
			videos.add(recuperarVideo(eVideo.getId()));
		}

		return videos;
	}

	/* Metodos auxiliares*/
	private String obtenerNombresEtiquetas(List<Etiqueta> listaEtiquetas) {
		String aux = "";
		for (Etiqueta e : listaEtiquetas) {
			aux += e.getNombre() + " ";
		}
		return aux.trim();
	}
	
	private List<Etiqueta> obtenerEtiquetasDesdeNombres(String etiquetas) {

		List<Etiqueta> listaEtiquetas = new LinkedList<Etiqueta>();
		if(etiquetas == null)
			return listaEtiquetas;
		StringTokenizer strTok = new StringTokenizer(etiquetas, " ");
		while (strTok.hasMoreTokens()) {
			listaEtiquetas.add(new Etiqueta((String) strTok.nextElement()));
		}
		return listaEtiquetas;
	}
}
