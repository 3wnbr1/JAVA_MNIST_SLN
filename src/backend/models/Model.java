package backend.models;

import java.io.Serializable;

import backend.dataset.Dataset;
import backend.dataset.Image;

public class Model implements Serializable {


	protected double accuracy;
	protected long batch_size;
	protected String date;
	protected String name;
	protected double test_proportion;
	protected double training_step;
	protected transient Dataset dataset;
	private static final long serialVersionUID = 1L;
	

	/**
	 * 
	 * @param model_file_path
	 */
	public Model(String model_file_path) {
		// TODO - implement Model.Model
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param dataset
	 */
	public Model(String name, Dataset dataset) {
		this.name = name;
		this.dataset = dataset;
	}

	public void saveToDisk() {
		// TODO - implement Model.saveToDisk
		throw new UnsupportedOperationException();
	}

	public double evaluate() {
		// TODO - implement Model.evaluate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param batchSize
	 * @param trainingSteps
	 * @param steps
	 */
	public void train(int batchsize, double learningRate, long epochs_number) {
		
	}

	/**
	 * 
	 * @param image
	 */
	public double run(Image image) {
		// TODO - implement Model.run
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param imageList
	 */
	public double runBatch(java.util.LinkedList<Image> imageList) {
		// TODO - implement Model.runBatch
		throw new UnsupportedOperationException();
	}

}