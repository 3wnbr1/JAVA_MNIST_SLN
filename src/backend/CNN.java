package backend;

import backend.dataset.Dataset;
import backend.dataset.Image;

public class CNN extends Model {

	private int layers;
	
	
	public CNN(String name, Dataset dataset) {
		super(name, dataset);
		// TODO Auto-generated constructor stub
	}

	public void saveToDisk() {
		// TODO - implement CNN.saveToDisk
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param image
	 */
	public double run(Image image) {
		// TODO - implement CNN.run
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param batchSize
	 * @param trainingSteps
	 * @param steps
	 */
	public void train(long batchSize, double trainingSteps, long steps) {
		// TODO - implement CNN.train
		throw new UnsupportedOperationException();
	}

	public double evaluate() {
		// TODO - implement CNN.evaluate
		throw new UnsupportedOperationException();
	}

}