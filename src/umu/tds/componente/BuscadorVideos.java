package umu.tds.componente;

import java.io.Serializable;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;

import pulsador.IEncendidoListener;



public class BuscadorVideos implements Serializable, IEncendidoListener{
	

	private static final long serialVersionUID = 1L;
	private Videos archivoVideos; // PROPIEDAD LIGADA
	List<VideosListener> oyentesVideos;
	
	
	
	public void setArchivoVideos(Videos archivoVideos) {
		if (archivoVideos != this.archivoVideos) {
			VideosEvent evento = new VideosEvent(this, this.archivoVideos, archivoVideos);
			this.archivoVideos = archivoVideos;
			notificarCambioVideos(evento);
		}
	}
	
	public void notificarCambioVideos(VideosEvent evento) {
		List<VideosListener> copia ;
		synchronized (oyentesVideos) {
			copia = new LinkedList<>(oyentesVideos);		
		}
		for (VideosListener sueldoListener : copia) {
			sueldoListener.enteradoCambioVideos(evento);
		}
	}
	
	synchronized public void addVideosListener(VideosListener listener) {
		this.oyentesVideos.add(listener);
	}
	synchronized public void removeVideosListener(VideosListener listener) {
		this.oyentesVideos.remove(listener);
	}

	@Override
	public void enteradoCambioEncendido(EventObject arg0) {
		CargadorVideos.cargarVideos((String) arg0.getSource());
	}
}
