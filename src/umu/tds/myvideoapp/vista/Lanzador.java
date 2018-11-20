package umu.tds.myvideoapp.vista;

import java.awt.EventQueue;

public class Lanzador {
	public static void main(final String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchFrame ventana = new LaunchFrame();
					ventana.mostrarVentana();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
