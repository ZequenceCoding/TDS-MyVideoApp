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
 * datos con un n�mero grande de objetos. En ese caso se consultaria
 * directamente la base de datos
 */
public class CatalogoUsuarios {
	private Map<String, Usuario> usuarios;
	private static CatalogoUsuarios unicaInstancia;

	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	private CatalogoUsuarios() {
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorUsuario = dao.getUsuarioDAO();
			usuarios = new HashMap<String, Usuario>();
			this.cargarCatalogo();
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}

	public static CatalogoUsuarios getUnicaInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new CatalogoUsuarios();
		return unicaInstancia;
	}

	/* devuelve todos los Usuarios */
	public List<Usuario> getUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		for (Usuario u : usuarios.values())
			lista.add(u);
		return lista;
	}

	public Usuario getUsuario(int codigo) {
		for (Usuario u : usuarios.values()) {
			if (u.getCodigo() == codigo)
				return u;
		}
		return null;
	}

	public Usuario getUsuario(String username) {
		return usuarios.get(username);	// Devuelve null si no esta el username
	}

	public void addUsuario(Usuario usu) {
		usuarios.put(usu.getUsername(), usu);
	}

	public void removeUsuario(Usuario usu) {
		usuarios.remove(usu.getUsername());
	}

	/* Recupera todos los Usuarios para trabajar con ellos en memoria */
	private void cargarCatalogo() throws DAOException {
		List<Usuario> UsuariosBD = adaptadorUsuario.recuperarTodosUsuarios();
		for (Usuario usu : UsuariosBD)
			usuarios.put(usu.getUsername(), usu);
	}

}
