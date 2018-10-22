package umu.tds.myvideoapp.dao;

public class TDSFactoriaDAO extends FactoriaDAO {
	public TDSFactoriaDAO () {
	}
	
	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return AdaptadorUsuarioTDS.getUnicaInstancia();
	}

	@Override
	public IAdaptadorVideoDAO getVideoDAO() {
		return AdaptadorVideoTDS.getUnicaInstancia();
	}


//	@Override
//	public IAdaptadorLineaVentaDAO getLineaVentaDAO() {
//		return AdaptadorLineaVentaTDS.getUnicaInstancia();
//	}
//
//	@Override
//	public IAdaptadorProductoDAO getProductoDAO() {
//		return AdaptadorProductoTDS.getUnicaInstancia();
//	}
//
//	@Override
//	public IAdaptadorClienteDAO getClienteDAO() {
//		return AdaptadorClienteTDS.getUnicaInstancia();
//	}

}
