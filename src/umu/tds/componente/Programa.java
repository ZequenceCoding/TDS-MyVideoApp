package umu.tds.componente;

public class Programa {

	public static void main(String[] args) {

		Videos videos = CargadorVideos
				.cargarVideos("xml/videos.xml"); //Obtener fichero a cargar mediante JFileChooser en Swing
	
		for (Video video : videos.getVideo()) {
			
			System.out.println("Video: " + video.getTitulo());
			System.out.println("    -> " + video.getUrl());
			
			for (Etiqueta etiqueta : video.getEtiqueta()) {
				System.out.println("    -> " + etiqueta.getNombre());				
			}
			
		}
	
	}

}
