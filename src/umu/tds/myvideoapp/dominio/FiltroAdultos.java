package umu.tds.myvideoapp.dominio;

public class FiltroAdultos implements ITest<Video>{
	
	@Override
	public boolean test(Video o) {
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
