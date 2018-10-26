package umu.tds.myvideoapp.dao;

import java.util.List;

import umu.tds.myvideoapp.dominio.Usuario;

public interface IAdaptadorUsuarioDAO {

	void registrarUsuario(Usuario usuario);
	boolean borrarUsuario(Usuario usuario);
	void modificarUsuario(Usuario usuario);
	Usuario recuperarUsuario(int codigo);
	List<Usuario> getAll();
}
