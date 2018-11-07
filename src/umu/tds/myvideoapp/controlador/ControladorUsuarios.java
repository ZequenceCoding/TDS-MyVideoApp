package umu.tds.myvideoapp.controlador;

import umu.tds.myvideoapp.dao.DAOException;
import umu.tds.myvideoapp.dao.FactoriaDAO;
import umu.tds.myvideoapp.dao.IAdaptadorUsuarioDAO;
import umu.tds.myvideoapp.dominio.CatalogoUsuarios;
import umu.tds.myvideoapp.dominio.Usuario;

public class ControladorUsuarios {

	private Usuario usuarioActual;
	private static ControladorUsuarios unicaInstancia;
	private FactoriaDAO factoria;
	
	private ControladorUsuarios() {
		usuarioActual = null;
		try {
			factoria = FactoriaDAO.getInstancia();
		} catch (DAOException e) {
			e.printStackTrace();
		}	
	}
	
	public static ControladorUsuarios getUnicaInstancia() {
		if (unicaInstancia == null) unicaInstancia = new ControladorUsuarios();
		return unicaInstancia;
	}
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	
	public boolean esUsuarioRegistrado(String username) {
		return CatalogoUsuarios.getUnicaInstancia().getUsuario(username)!=null;
	}
	
	public boolean loginUsuario(String username,String password) {
		Usuario usuario = CatalogoUsuarios.getUnicaInstancia().getUsuario(username);
		if (usuario != null && usuario.getPassword().equals(password)) {
				this.usuarioActual = usuario;
				System.out.println("Login usuario true");
				return true;
		}
		System.out.println("Login usuario false");
		return false;
	}
	
	public boolean registrarUsuario(String username,
									String password, 
									String nombre,
									String apellidos,
									String email) {

			if (esUsuarioRegistrado(username)) return false;
			Usuario Usuario = new Usuario(username, password, nombre, apellidos, email);
			
			IAdaptadorUsuarioDAO usuarioDAO = factoria.getUsuarioDAO(); /*Adaptador DAO para almacenar el nuevo Usuario en la BD*/
			usuarioDAO.registrarUsuario(Usuario);
			
			CatalogoUsuarios.getUnicaInstancia().addUsuario(Usuario);
			return true;
	}
	
	public boolean borrarUsuario(Usuario Usuario) {
		if (!esUsuarioRegistrado(Usuario.getUsername())) return false;
		
		IAdaptadorUsuarioDAO usuarioDAO = factoria.getUsuarioDAO();  /*Adaptador DAO para borrar el Usuario de la BD*/
		usuarioDAO.borrarUsuario(Usuario);
		
		CatalogoUsuarios.getUnicaInstancia().removeUsuario(Usuario);
		return true;
	}
	
}
