package umu.tds.myvideoapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;
import umu.tds.myvideoapp.dominio.Etiqueta;
import umu.tds.myvideoapp.dominio.Usuario;
import umu.tds.myvideoapp.dominio.Video;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestVideoApp {

	private static ControladorMyVideoApp controlador = ControladorMyVideoApp.getUnicaInstancia();
	@SuppressWarnings("deprecation")
	private static Usuario usuario = new Usuario("user", "pass", "Edu", "Salmeron", "edu@gmail.com", new Date(1998, 12, 2));
	private static Video video= new Video("https://www.youtube.com/watch?v=BEgEoMz6WVk", "Miguel", new LinkedList<Etiqueta>(Arrays.asList(new Etiqueta("Humor"))));

	
	@Test
	public void test1Login() {
		controlador.registrarUsuario(usuario.getUsername(), usuario.getPassword(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getFechaNac());
		controlador.loginUsuario(usuario.getUsername(), usuario.getPassword());
		assertEquals("Test Registro y Login: ", usuario.getUsername(), controlador.getUsuarioActualUsername());
	}
	
	@Test
	public void test2RegistroVideo() {
		controlador.registrarUsuario(usuario.getUsername(), usuario.getPassword(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getFechaNac());
		controlador.registrarVideo(video.getUrl(), video.getTitulo(), video.getEtiquetas());
		assertTrue("Test Registro video: ", controlador.existVideo(video.getUrl()));
	}
	
	@Test
	public void test3VerVideo() {
		controlador.registrarUsuario(usuario.getUsername(), usuario.getPassword(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getFechaNac());
		int numRep = controlador.getNumReproducciones(video.getUrl());
		controlador.loginUsuario(usuario.getUsername(), usuario.getPassword());
		controlador.verVideo(video.getUrl());
		controlador.stopVideo();
		assertEquals("Test ver video: ", numRep+1, controlador.getNumReproducciones(video.getUrl()));
	}
	
	@Test
	public void test4AnadirVideoALista() {
		controlador.registrarUsuario(usuario.getUsername(), usuario.getPassword(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getFechaNac());
		controlador.loginUsuario(usuario.getUsername(), usuario.getPassword());
		controlador.registrarVideo(video.getUrl(), video.getTitulo(), video.getEtiquetas());
		controlador.registrarListaVideos("Lista 1");
		controlador.anadirVideoALista(video.getUrl(), "Lista 1");
		LinkedList<Video> lista = (LinkedList<Video>)controlador.getVideosLista("Lista 1");
		boolean condition = false;
		for (Video v : lista) {
			if(v.getUrl().equals(video.getUrl())){
				condition = true;
			}
		}
		assertTrue("Test añadir video a lista: ", condition);
	}
	
	@Test
	public void test5() {
		controlador.registrarUsuario(usuario.getUsername(), usuario.getPassword(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getFechaNac());
		controlador.loginUsuario(usuario.getUsername(), usuario.getPassword());
		controlador.registrarVideo(video.getUrl(), video.getTitulo(), video.getEtiquetas());
		controlador.registrarEtiq(video.getUrl(), "Gracioso");
		assertTrue("Test añadir etiqueta a video: ", controlador.getEtiquetasVideo(video.getUrl()).contains(new Etiqueta("Gracioso")));
	}

}
