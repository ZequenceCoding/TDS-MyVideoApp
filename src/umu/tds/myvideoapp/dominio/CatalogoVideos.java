package umu.tds.myvideoapp.dominio;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import umu.tds.myvideoapp.dao.DAOException;
import umu.tds.myvideoapp.dao.FactoriaDAO;
import umu.tds.myvideoapp.dao.IAdaptadorVideoDAO;


/* El cat�logo mantiene los objetos en memoria, en una tabla hash
 * para mejorar el rendimiento. Esto no se podr�a hacer en una base de
 * datos con un n�mero grande de objetos. En ese caso se consultar�a
 * directamente la base de datos
 */
public class CatalogoVideos {
	private Map<String, umu.tds.myvideoapp.dominio.Video> Video; 
	private static CatalogoVideos unicaInstancia = new CatalogoVideos();
	
	private FactoriaDAO dao;
	private IAdaptadorVideoDAO adaptadorVideo;
	
	private CatalogoVideos() {
		try {
  			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
  			adaptadorVideo = dao.getVideoDAO();
  			Video = new HashMap<String,Video>();
  			this.cargarCatalogo();
  		} catch (DAOException eDAO) {
  			eDAO.printStackTrace();
  		}
	}
	
	public static CatalogoVideos getUnicaInstancia(){
		return unicaInstancia;
	}
	
	/*devuelve todos los Usuarios*/
	public List<Video> getVideos(){
		ArrayList<Video> lista = new ArrayList<Video>();
		for (Video c:Video.values()) 
			lista.add(c);
		return lista;
	}
	
	public Video getVideo(int codigo) {
		for (Video p : Video.values()) {
			if (p.getCodigo()==codigo) return p;
		}
		return null;
	}
	public Video getVideo(String titulo) {
		return Video.get(titulo); 
	}
	
	public void addVideo(Video vid) {
		Video.put(vid.getTitulo(),vid);
	}
	public void removeVideo(Video vid) {
		Video.remove(vid.getTitulo());
	}
	
	/*Recupera todos los Usuarios para trabajar con ellos en memoria*/
	private void cargarCatalogo() throws DAOException {
		 List<Video> UsuariosBD = adaptadorVideo.recuperarTodosVideos();
		 for (Video pro: UsuariosBD) 
			     Video.put(pro.getTitulo(),pro);
	}
	
}