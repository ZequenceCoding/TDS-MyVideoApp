package umu.tds.myvideoapp.dominio;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;

public class FiltroMisListas implements ITest<Video> {
	
	@Override
	public String getNombre() {
		return "Mis listas";
	}

	@Override
	public boolean test(Video o) {
		for (ListaVideos listaVideos :ControladorMyVideoApp.getUnicaInstancia().getListasVideosUsuario()) {
			if (listaVideos.getVideo(o.getUrl()) != null) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String getNombreClase() {
		return "umu.tds.myvideoapp.dominio.FiltroMisListas";
	}
}
