package umu.tds.myvideoapp.dominio;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import umu.tds.myvideoapp.dao.DAOException;
import umu.tds.myvideoapp.dao.FactoriaDAO;
import umu.tds.myvideoapp.dao.IAdaptadorUsuarioDAO;


/* El cat�logo mantiene los objetos en memoria, en una tabla hash
 * para mejorar el rendimiento. Esto no se podr�a hacer en una base de
 * datos con un n�mero grande de objetos. En ese caso se consultar�a
 * directamente la base de datos
 */
public class CatalogoUsuarios {
	private Map<String,Usuario> Usuarios; 
	private static CatalogoUsuarios unicaInstancia = new CatalogoUsuarios();
	
	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	
	private CatalogoUsuarios() {
		try {
  			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
  			adaptadorUsuario = dao.getUsuarioDAO();
  			Usuarios = new HashMap<String,Usuario>();
  			this.cargarCatalogo();
  		} catch (DAOException eDAO) {
  			eDAO.printStackTrace();
  		}
	}
	
	public static CatalogoUsuarios getUnicaInstancia(){
		return unicaInstancia;
	}
	
	/*devuelve todos los Usuarios*/
	public List<Usuario> getUsuarios(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		for (Usuario c:Usuarios.values()) 
			lista.add(c);
		return lista;
	}
	
	public Usuario getUsuario(int codigo) {
		for (Usuario p : Usuarios.values()) {
			if (p.getCodigo()==codigo) return p;
		}
		return null;
	}
	public Usuario getUsuario(String nombre) {
		return Usuarios.get(nombre); 
	}
	
	public void addUsuario(Usuario usu) {
		Usuarios.put(usu.getNombre(),usu);
	}
	public void removeUsuario(Usuario usu) {
		Usuarios.remove(usu.getNombre());
	}
	
	/*Recupera todos los Usuarios para trabajar con ellos en memoria*/
	private void cargarCatalogo() throws DAOException {
		 List<Usuario> UsuariosBD = adaptadorUsuario.recuperarTodosUsuarios();
		 for (Usuario pro: UsuariosBD) 
			     Usuarios.put(pro.getNombre(),pro);
	}
	
}
