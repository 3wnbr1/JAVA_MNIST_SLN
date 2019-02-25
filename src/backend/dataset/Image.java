package backend.dataset;

import backend.prof.ImageCalculs;
import backend.prof.ImageNB;

public class Image {

	protected ImageNB image_data;
	private Features features;
	private String label;
	private String filename;

	/**
	 * Construct a new image with only a filepath
	 * @param filepath
	 */
	public Image(String filepath) {
		String[] path = filepath.split("\\\\|/");  // Regex matching windows and unix paths
		this.image_data = ImageCalculs.buffToImageNB(ImageCalculs.chargerImage(filepath));
		this.label = path[path.length-1].substring(0, 1);
		this.filename = path[path.length-1];
		this.features = new Features(this);
	}
	
	/*
	 * Compute Image Features
	 */
	public void computeFeatures() {
		this.features.compute();
	}
	
	/*
	 * The label of the current image
	 */
	public String getLabel() {
		return this.label;
	}
	
	/*
	 * toString method used to build backup files
	 */
	@Override
	public String toString() {
		return "image:\n\t\tname: " + this.filename + "\n\t\tlabel: " + this.label + "\n\t\tfeatures: " + this.features.toString();
	}
}