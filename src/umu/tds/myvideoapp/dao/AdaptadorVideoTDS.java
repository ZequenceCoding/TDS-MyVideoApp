package umu.tds.myvideoapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.myvideoapp.dominio.Video;
import beans.Entidad;
import beans.Propiedad;

public class AdaptadorVideoTDS implements IAdaptadorVideoDAO{

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
		if (existe) return;

		// registrar primero los atributos que son objetos
//		AdaptadorVentaTDS adaptadorVenta = AdaptadorVentaTDS.getUnicaInstancia();
//		for (Venta v : cliente.getVentas())
//			adaptadorVenta.registrarVenta(v);

		// crear entidad Cliente
		eVideo = new Entidad();
		eVideo.setNombre("video");
		eVideo.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("url", video.getUrl()),	
							new Propiedad("titulo", video.getTitulo()),
							new Propiedad("numReproducciones", String.valueOf(video.getNumReproducciones()))
						)));
		
		// registrar entidad cliente
		eVideo = servPersistencia.registrarEntidad(eVideo);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		video.setCodigo(eVideo.getId()); 		
	}

	@Override
	public void borrarVideo(Video video) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarVideo(Video video) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Video recuperarVideo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> recuperarTodosVideos() {
		// TODO Auto-generated method stub
		return null;
	}

}
