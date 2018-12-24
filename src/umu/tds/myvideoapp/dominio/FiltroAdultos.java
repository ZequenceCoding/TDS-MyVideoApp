package umu.tds.myvideoapp.dominio;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;

public class FiltroAdultos implements ITest<Video>{
	
	@Override
	public boolean test(Video o) {
		if(ControladorMyVideoApp.getUnicaInstancia().usuarioMayorEdad())
			return true;
		for (Etiqueta etiqueta : o.getEtiquetas()) {
			if(etiqueta.getNombre().equals("Adultos"))
				return false;
		}
		return true;
	}

	@Override
	public String getNombreClase() {
		return "umu.tds.myvideoapp.dominio.FiltroAdultos";
	}
	
	public String getNombre() {
		return "Adultos";
	}

}
