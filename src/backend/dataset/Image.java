package backend.dataset;

import java.awt.image.BufferedImage;

import backend.prof.ImageCalculs;
import backend.prof.ImageNB;

public class Image {

	protected ImageNB image_data;
	private Features features;
	private String label;
	private String filename;
	private double[] flattened;

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
	
	/**
	 * Compute Image Features
	 */
	public void computeFeatures() {
		this.features.compute();
	}
	
	/**
	 * The label of the current image
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Return array of images features
	 */
	public double[] getFeatures() {
		return this.features.getArray();
	}
	
	/**
	 * Flatten image to array line by line
	 */
	public double[] flatten() {
		int size_x = this.image_data.getTailleX();
		int size_y = this.image_data.getTailleY();
		double[] flattened = new double[size_x * size_y];
		
		for (int y = 0; y < size_y; y++) {
			for (int x = 0; x < size_x; x++) {
				flattened[y * size_x + x] = this.image_data.getPoint(x, y);
			}
		}
		return flattened;
	}
	
	/**
	 * toString method used to build backup files
	 */
	@Override
	public String toString() {
		return "image:\n    name: " + this.filename + "\n    label: " + this.label + "\n    features: " + this.features.toString();
	}

	public double[] getFlattened() {
		return flattened;
	}

	public void setFlattened(double[] flattened) {
		this.flattened = flattened;
	}
	
	public BufferedImage toBufferedImage() {
		return ImageCalculs.imageNBToBuff(this.image_data);
	}
	
}