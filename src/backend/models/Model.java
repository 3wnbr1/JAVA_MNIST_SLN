package backend.models;

import java.io.Serializable;

import backend.dataset.Dataset;
import backend.dataset.Image;


public abstract class Model implements Serializable {


	protected String name;
	protected transient Dataset dataset;
	private static final long serialVersionUID = 1L;
	
	
	public abstract double evaluate();
	
	public abstract double[] predict(Image image);

	public abstract void train(int batchsize, double learningRate, int epochs_number);
	
	
	/**
	 * Provide default batchsize value
	 * @param learningRate
	 * @param epochs_number
	 */
	public void train(double learningRate, int epochs_number) {
		this.train(this.dataset.getTraining_images().size(), learningRate, epochs_number);
	}
	
	/**
	 * Provide default value for leaning_rate and batchsize
	 * @param epochs_number
	 */
	public void train(int epochs_number) {
		this.train(0.005, epochs_number);
	}

	/**
	 * Generic model constructor
	 * @param name
	 * @param dataset
	 */
	public Model(String name, Dataset dataset) {
		this.name = name;
		this.dataset = dataset;
	}
	
	
	/**
	 * Sum elements from an array
	 * @param input
	 * @return
	 */
	protected double sum(double[] input) {
		double output = 0;
		for (double i : input) {
			output += i;
		}
		return output;
	}

	/**
	 * Return average value of an array
	 * @param input
	 * @return
	 */
	protected double average(double[] input) {
		return this.sum(input) / (double) input.length;
	}

}