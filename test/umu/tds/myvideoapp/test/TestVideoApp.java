package umu.tds.myvideoapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

import org.junit.BeforeClass;
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
	void test1RegistroYLogin() {
		controlador.registrarUsuario(usuario.getUsername(), usuario.getPassword(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getFechaNac());
		controlador.loginUsuario(usuario.getUsername(), usuario.getPassword());
		assertEquals("Test Registro y Login: ", usuario.getUsername(), controlador.getUsuarioActualUsername());
	}
	
	@Test
	void test2RegistroVideo() {
		controlador.registrarVideo(video.getUrl(), video.getTitulo(), video.getEtiquetas());
		assertTrue("Test Registro video: ", controlador.existVideo(video.getUrl()));
	}
	
	@Test
	void test3VerVideo() {
		int numRep = controlador.getNumReproducciones(video.getUrl());
		controlador.loginUsuario(usuario.getUsername(), usuario.getPassword());
		controlador.verVideo(video.getUrl());
		controlador.stopVideo();
		assertEquals("Test ver video: ", numRep+1, controlador.getNumReproducciones(video.getUrl()));
	}
	
	@Test
	void test4AnadirVideoALista() {
		
	}
	

}
