package umu.tds.myvideoapp.dao;

import java.util.List;

import umu.tds.myvideoapp.dominio.Video;

public interface IAdaptadorVideoDAO {

	public void registrarVideo(Video video);

	public void borrarVideo(Video video);

	public void modificarVideo(Video video);

	public Video recuperarVideo(int video);

	public List<Video> recuperarTodosVideos();
}
