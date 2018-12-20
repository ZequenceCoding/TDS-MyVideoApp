package umu.tds.myvideoapp.dominio;

public class FiltroNombresLargos implements ITest<Video> {

	
	@Override
	public boolean test(Video o) {
		return o.getTitulo().length() <= 16;
	}

	@Override
	public String getNombre() {
		return "Nombres Largos";
	}

	@Override
	public String getNombreClase() {
		return "umu.tds.myvideoapp.dominio.FiltroNombresLargos";
	}

}
