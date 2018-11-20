package umu.tds.componente;

import java.util.EventObject;


public class VideosEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private Videos oldVideo, newVideo;
	
	public VideosEvent(Object arg0, Videos oldVideo, Videos newVideo) {
		super(arg0);
		this.oldVideo = oldVideo;
		this.newVideo = newVideo;
	}

	public Videos getOldVideo() {
		return oldVideo;
	}

	public Videos getNewVideo() {
		return newVideo;
	}

}
