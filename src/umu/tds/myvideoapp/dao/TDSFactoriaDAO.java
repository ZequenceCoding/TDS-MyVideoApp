package umu.tds.myvideoapp.dao;

public class TDSFactoriaDAO extends FactoriaDAO {
	
	public TDSFactoriaDAO () {
	}
	
	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return new AdaptadorUsuarioTDS();
	}

	@Override
	public IAdaptadorVideoDAO getVideoDAO() {
		return AdaptadorVideoTDS.getUnicaInstancia();
	}

}
