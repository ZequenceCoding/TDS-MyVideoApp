package umu.tds.myvideoapp.launcher;

import java.awt.EventQueue;

import umu.tds.myvideoapp.launchframe.LaunchFrame;

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
