package backend.dataset;

import java.awt.image.BufferedImage;

import backend.prof.ImageCalculs;
import backend.prof.ImageNB;

public class Image {

	protected ImageNB image_data;
	private String label;
	private String filename;

	/**
	 * Construct a new image with only a filepath
	 * 
	 * @param filepath
	 */
	public Image(String filepath, int image_height, int image_width) {
		String[] path = filepath.split("\\\\|/"); // Regex matching windows and unix paths
		this.image_data = ImageCalculs.buffToImageNB(
				ImageCalculs.redimensionnerImage(ImageCalculs.chargerImage(filepath), image_height, image_width));
		this.label = path[path.length - 1].substring(0, 1);
		this.filename = path[path.length - 1];
	}

	/**
	 * The label of the current image
	 */
	public String getLabel() {
		return this.label;
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
				flattened[y * size_x + x] = 1 - (this.image_data.getPoint(x, y) / (double) 255);
			}
		}
		return flattened;
	}

	/**
	 * toString method used to build backup files
	 */
	@Override
	public String toString() {
		return "image:\n    name: " + this.filename + "\n    label: " + this.label + "\n    features: ";
	}

	public BufferedImage toBufferedImage() {
		return ImageCalculs.imageNBToBuff(this.image_data);
	}

}
