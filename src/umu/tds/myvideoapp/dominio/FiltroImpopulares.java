package umu.tds.myvideoapp.dominio;

public class FiltroImpopulares implements ITest<Video> {

	
	@Override
	public boolean test(Video o) {
		return o.getNumReproducciones() >= 5;
	}

	@Override
	public String getNombre() {
		return "Impopulares";
	}

	@Override
	public String getNombreClase() {
		return "umu.tds.myvideoapp.dominio.FiltroImpopulares";
	}

}
