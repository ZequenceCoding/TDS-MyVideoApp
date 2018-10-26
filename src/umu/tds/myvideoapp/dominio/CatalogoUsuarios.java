package umu.tds.myvideoapp.dominio;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import umu.tds.myvideoapp.dao.DAOException;
import umu.tds.myvideoapp.dao.FactoriaDAO;

public class CatalogoUsuarios {
	
	private static CatalogoUsuarios unicaInstancia;
	private FactoriaDAO factoria;
	
	private HashMap<Integer, Usuario> usuariosPorID;
	private HashMap<String, Usuario> usuariosPorUsername;
	
	public static CatalogoUsuarios getUnicaInstancia() {
		if (unicaInstancia == null) unicaInstancia = new CatalogoUsuarios();
		return unicaInstancia;
	}
	
	private CatalogoUsuarios() {
		usuariosPorID = new HashMap<Integer, Usuario>();
		usuariosPorUsername = new HashMap<String, Usuario>();
		
		try {
			factoria = FactoriaDAO.getInstancia();
			
			List<Usuario> listaUsuarios = factoria.getUsuarioDAO().getAll();
			for (Usuario usuario : listaUsuarios) {
				usuariosPorID.put(usuario.getId(), usuario);
				usuariosPorUsername.put(usuario.getUsername(), usuario);
			}
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}
	
	public List<Usuario> getUsuarios() throws DAOException {
		return new LinkedList<Usuario>(usuariosPorUsername.values());
	}
	
	public Usuario getUsuario(String username) {
		return usuariosPorUsername.get(username);
	}
	
	public Usuario getUsuario(int id) {
		return usuariosPorID.get(id);
	}
	
	public void addUsuario(Usuario usuario) {
		usuariosPorID.put(usuario.getId(), usuario);
		usuariosPorUsername.put(usuario.getUsername(), usuario);
	}
	
	public void removeUsuario(Usuario usuario) {
		usuariosPorID.remove(usuario.getId());
		usuariosPorUsername.remove(usuario.getUsername());
	}
}
