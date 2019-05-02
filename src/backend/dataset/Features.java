package backend.dataset;

import java.util.Arrays;

public class Features {

	private double[] array;
	private long[] histogram;
	private Gradient[][] gradient;
	private Image image;

	
	/*
	 * Array of features
	 */
	public double[] getArray() {
		return this.array;
	}

	/*
	 * Features construction
	 */
	public Features(Image image) {
		this.image = image;
		this.computeGradient();
		this.computeHistogram();
	}

	/**
	 * Run all compute features 
	 * @return Void, saves to this.array for efficiency.
	 */
	public void compute() {
		this.array = new double[4]; // Reset the array
		this.array[0] = this.computeFeatureBlackPixelsRatio();
		this.array[1] = this.computeFeatureEntropy();
		this.array[2] = this.computeFeatureGradientAverageAngle();
		this.array[3] = this.computeFeatureGradientAverageNorm();
	}

	
	/**
	 * Ratio of black pixels in image,
	 * @return double in range 0 to 1
	 */
	private double computeFeatureBlackPixelsRatio() {
		int counter = 0;
		int rows = this.image.image_data.getTailleX();
		int columns = this.image.image_data.getTailleY();
		for (int y = 0; y<rows; y++) {
			for (int x = 0; x<columns; x++) {
				if (this.image.image_data.estNoir(this.image.image_data.getPoint(x, y))) {
					counter += 1;
				}
			}
		}
		return counter / (double) (rows * columns);
	}
	
	/*
	 * Compute grayscale histogram for entropy computation
	 */
	private void computeHistogram() {
		long[] histogram = new long[256];
		
		for (int y = 0; y<this.image.image_data.getTailleY(); y++) {
			for (int x = 0; x<this.image.image_data.getTailleX(); x++) {
				histogram[this.image.image_data.getPoint(x, y)] += 1;
			}
		}
		this.histogram = histogram;
	}

	/**
	 * Compute entropy of image using MATLAB Formulation
	 * @return
	 */
	private double computeFeatureEntropy() {
		long sum = 0;
		double p;
		for (int i = 0; i<this.histogram.length; i++) {
			p = this.histogram[i];
			sum += p * Math.log(p) / Math.log(2);
		}
		return -1*sum;
	}
	
	/*
	 * Compute the average gradient angle
	 */
	private double computeFeatureGradientAverageAngle() {
		long sum = 0;
		
		for (int y = 0; y<this.image.image_data.getTailleY(); y++) {
			for (int x = 0; x<this.image.image_data.getTailleX(); x++) {
				sum += this.gradient[y][x].getAngle();
			}
		}
		return sum / (double) (this.image.image_data.getTailleY() * this.image.image_data.getTailleX());
	}
	
	/*
	 * Compute the average gradient norm
	 */
	private double computeFeatureGradientAverageNorm() {
		long sum = 0;
		
		for (int y = 0; y<this.image.image_data.getTailleY(); y++) {
			for (int x = 0; x<this.image.image_data.getTailleX(); x++) {
				sum += this.gradient[y][x].getNorme();
			}
		}
		return sum / (double) (this.image.image_data.getTailleY() * this.image.image_data.getTailleX());
	}

	/*
	 * Compute image gradient for later use
	 */
	private void computeGradient() {
		int rows = this.image.image_data.getTailleX();
		int columns = this.image.image_data.getTailleY();
		Gradient[][] gradient = new Gradient[rows][columns];
		double dx;
		double dy;
		boolean computable;
		double norme;
		double angle;
		
		for (int x = 0; x < image.image_data.getTailleX(); x++) {
			for (int y = 0; y < image.image_data.getTailleY(); y++) {
				computable = true;
				
				if ((x > 0) && (x < image.image_data.getTailleX() - 1)) {
					dx = Math.abs((image.image_data.getPoint(x-1, y) - image.image_data.getPoint(x+1, y)) / 255);
					if (dx == 0) {
						dx = 0.0001;
					}
				} else {
					dx = 0.0001;
					computable = false;
				}
				
				if ((y>0) && (y < this.image.image_data.getTailleY() - 1)) {
					dy = Math.abs((image.image_data.getPoint(x, y-1) - image.image_data.getPoint(x, y+1)) / 255);
				} else {
					dy = 0;
					computable = false;
				}
											
				if (!computable) {
					gradient[x][y] = new Gradient(0.0,0.0);
					
				} else {
					norme = 255 - Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2))*0.7;
					angle = (Math.atan(dy/dx) + Math.PI/2)*255/Math.PI;
					gradient[x][y] = new Gradient(angle,norme);
				}
				
			}
		}
		this.gradient = gradient;
		
	}

	/*
	 * toString for features array
	 */
	@Override
	public String toString() {
		return Arrays.toString(this.getArray());
	}

}