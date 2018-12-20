package umu.tds.myvideoapp.dominio;


public class NoFiltro implements ITest<Video>{
	
	@Override
	public boolean test(Video o) {
		return true;
	}

	public String getNombre() {
		return "No filtro";
	}
	
	@Override
	public String getNombreClase() {
		return "umu.tds.myvideoapp.dominio.NoFiltro";
	}

}
