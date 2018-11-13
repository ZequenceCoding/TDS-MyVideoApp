package umu.tds.myvideoapp.dao;

import umu.tds.myvideoapp.dominio.ListaVideos;

public interface IAdaptadorListaVideosDAO {
	void registrarListaVideos(ListaVideos listaVideos);

	void borrarListaVideos(ListaVideos listaVideos);

	void modificarListaVideos(ListaVideos listaVideos);

	ListaVideos recuperarListaVideos(int codigo);
}
