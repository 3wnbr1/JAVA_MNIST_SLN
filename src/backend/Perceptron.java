package backend;

import backend.dataset.Dataset;
import backend.dataset.Image;
import backend.models.Model;

public class Perceptron extends Model {


	private Boolean[] featuresEnabled;
	private double[] weights;
	
	
	public Perceptron(String name, Dataset dataset) {
		super(name, dataset);
		// TODO Auto-generated constructor stub
	}

	public void saveToDisk() {
		// TODO - implement Perceptron.saveToDisk
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param batchSize
	 * @param trainingSteps
	 * @param steps
	 */
	public void train(long batchSize, double trainingSteps, long steps) {
		// TODO - implement Perceptron.train
		throw new UnsupportedOperationException();
	}

	public double evaluate() {
		// TODO - implement Perceptron.evaluate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param image
	 */
	public double run(Image image) {
		// TODO - implement Perceptron.run
		throw new UnsupportedOperationException();
	}

}