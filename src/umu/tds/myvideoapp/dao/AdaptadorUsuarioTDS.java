package umu.tds.myvideoapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.myvideoapp.dominio.Usuario;
import beans.Entidad;
import beans.Propiedad;

public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO{

	private ServicioPersistencia servPersistencia;
	
	public AdaptadorUsuarioTDS() { 
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia(); 
	}	
	
	private Usuario entidadToUsuario(Entidad eUsuario) {
		
		String username = servPersistencia.recuperarPropiedadEntidad(eUsuario, "username");
		String password = servPersistencia.recuperarPropiedadEntidad(eUsuario, "password");
		
		String nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
		String apellidos = servPersistencia.recuperarPropiedadEntidad(eUsuario, "apellidos");

		//String fechaNac = servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaNac");
		String email = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
		
		
	   /* Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/mm/dd").parse(fechaNac);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/  
		
		Usuario Usuario = new Usuario(username, password, nombre, apellidos, /*date,*/ email);
		Usuario.setId(eUsuario.getId());
		return Usuario;
	}
	
	private Entidad UsuarioToEntidad(Usuario Usuario) {
		Entidad  eUsuario = new Entidad();
		eUsuario.setNombre("usuario"); 
	
		eUsuario.setPropiedades(
				new ArrayList<Propiedad>(Arrays.asList(
						new Propiedad("username", Usuario.getUsername()),
						new Propiedad("password", Usuario.getPassword()),
						
						new Propiedad("nombre", Usuario.getNombre()), 
						new Propiedad("apellidos", Usuario.getApellidos()),

						new Propiedad("email", Usuario.getEmail())
						//new Propiedad("fechaNac", Usuario.getFechaNac().toString())						
						))
				);
		return eUsuario;
	}
	
	public void registrarUsuario(Usuario Usuario) {
		Entidad  eUsuario = this.UsuarioToEntidad(Usuario);
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		Usuario.setId(eUsuario.getId());
	}
	
	public boolean borrarUsuario(Usuario Usuario) {
		Entidad eUsuario;
		eUsuario = servPersistencia.recuperarEntidad(Usuario.getId());
		return servPersistencia.borrarEntidad(eUsuario);
	}
	
	/**
	 * Permite que un Usuario modifique su perfil: email y password
	 */
	public void modificarUsuario(Usuario Usuario ) {
		Entidad eUsuario = servPersistencia.recuperarEntidad(Usuario.getId());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "password");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "password",Usuario.getPassword());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "email");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "email",Usuario.getEmail());
	}
	
	public Usuario recuperarUsuario(int id) {
		Entidad eUsuario = servPersistencia.recuperarEntidad(id);
		return entidadToUsuario(eUsuario);
	}
	
	public List<Usuario> recuperarTodosUsuarios() {
		List<Entidad> entidades = servPersistencia.recuperarEntidades("usuario");
		
		List<Usuario> Usuarios  = new LinkedList<Usuario>();
		
		for (Entidad eUsuario : entidades) {
			Usuarios.add(recuperarUsuario(eUsuario.getId()));
		}
		
		return Usuarios;
	}
}
