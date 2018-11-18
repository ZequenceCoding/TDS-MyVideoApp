package umu.tds.myvideoapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.myvideoapp.dominio.ListaVideos;
import umu.tds.myvideoapp.dominio.Video;

public class AdaptadorListaVideosTDS implements IAdaptadorListaVideosDAO {

	private static ServicioPersistencia servPersistencia;
	private static AdaptadorListaVideosTDS unicaInstancia;

	public static AdaptadorListaVideosTDS getUnicaInstancia() { // patron
																// singleton
		if (unicaInstancia == null)
			return new AdaptadorListaVideosTDS();
		else
			return unicaInstancia;
	}

	public AdaptadorListaVideosTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	@Override
	public void registrarListaVideos(ListaVideos listaVideos) {
		Entidad eListaVideos;
		// Si la entidad est� registrada no la registra de nuevo
		boolean existe = true;
		try {
			eListaVideos = servPersistencia.recuperarEntidad(listaVideos.getId());
		} catch (NullPointerException e) {
			existe = false;
		}
		if (existe)
			return;

		// registrar primero los atributos que son objetos
		AdaptadorVideoTDS adaptadorVideo = AdaptadorVideoTDS.getUnicaInstancia();
		for (Video v : listaVideos.getVideos()) {
			adaptadorVideo.registrarVideo(v);
		}

		// crear entidad lista de videos
		eListaVideos = new Entidad();
		eListaVideos.setNombre("listavideos");
		eListaVideos.setPropiedades(
				new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nombre lista", listaVideos.getNombreLista()),
						new Propiedad("videos", obtenerCodigosVideos(listaVideos.getVideos())))));

		// registrar entidad lista de videos
		eListaVideos = servPersistencia.registrarEntidad(eListaVideos);
		// asignar identificador unico.
		// Se aprovecha el que genera el servicio de persistencia
		listaVideos.setId(eListaVideos.getId());
	}

	@Override
	public void borrarListaVideos(ListaVideos listaVideos) {
		Entidad eListaVideos = servPersistencia.recuperarEntidad(listaVideos.getId());
		servPersistencia.borrarEntidad(eListaVideos);
	}

	@Override
	public void modificarListaVideos(ListaVideos listaVideos) {
		Entidad eListaVideos;

		eListaVideos = servPersistencia.recuperarEntidad(listaVideos.getId());

		servPersistencia.eliminarPropiedadEntidad(eListaVideos, "nombre lista");
		servPersistencia.anadirPropiedadEntidad(eListaVideos, "nombre lista",
				listaVideos.getNombreLista());
		servPersistencia.eliminarPropiedadEntidad(eListaVideos, "videos");
		servPersistencia.anadirPropiedadEntidad(eListaVideos, "videos",
				obtenerCodigosVideos(listaVideos.getVideos()));
	}

	@Override
	public ListaVideos recuperarListaVideos(int codigo) {
		Entidad eListaVideos;
		String nombreLista;
		List<Video> videos;

		eListaVideos = servPersistencia.recuperarEntidad(codigo);
		nombreLista = servPersistencia.recuperarPropiedadEntidad(eListaVideos, "nombre lista");
		videos = obtenerVideosDesdeCodigos(servPersistencia.recuperarPropiedadEntidad(eListaVideos, "videos"));

		ListaVideos listaVideos = new ListaVideos(nombreLista);
		for (Video video : videos) {
			listaVideos.addVideo(video);
		}
		return listaVideos;
	}

	// -------------------Funciones auxiliares-----------------------------
	private String obtenerCodigosVideos(List<Video> listaVideos) {
		String aux = "";
		for (Video v : listaVideos) {
			aux += v.getCodigo() + " ";
		}
		return aux.trim();
	}

	private List<Video> obtenerVideosDesdeCodigos(String videos) {

		List<Video> listaVideos = new LinkedList<Video>();
		StringTokenizer strTok = new StringTokenizer(videos, " ");
		AdaptadorVideoTDS adaptadorV = AdaptadorVideoTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			listaVideos.add(adaptadorV.recuperarVideo(Integer.valueOf((String) strTok.nextElement())));
		}
		return listaVideos;
	}
}
