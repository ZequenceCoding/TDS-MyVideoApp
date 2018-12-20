package umu.tds.componente;

import java.io.File;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import umu.tds.componente.Videos;

public class CargadorVideos {

	public static Videos cargarVideos(String datos) {

		JAXBContext jc;
		Videos asistencias = null;
		try {
			jc = JAXBContext.newInstance("umu.tds.componente");
			Unmarshaller u = jc.createUnmarshaller();
			File file = new File(datos);
			asistencias = (Videos) u.unmarshal(file);
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Error al abrir el fichero, prueba con un fichero .xml",
					"Error", JOptionPane.ERROR_MESSAGE);
		}	
		return asistencias;
	}
}
