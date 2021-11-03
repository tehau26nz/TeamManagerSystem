package fileContainer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.VideoTrack;

public class Media {

	private ImageView photo;
	private VideoTrack video;
	private AudioClip audio;

	public void getPhoto() {
		// TODO - implement Media.getPhoto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param photo
	 */
	public void setPhoto(ImageView photo) {
		this.photo = photo;
	}

	public void getVideo() {
		// TODO - implement Media.getVideo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param video
	 */
	public void setVideo(VideoTrack video) {
		this.video = video;
	}

	public void getAudio() {
		// TODO - implement Media.getAudio
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param audio
	 */
	public void setAudio(AudioClip audio) {
		this.audio = audio;
	}

}