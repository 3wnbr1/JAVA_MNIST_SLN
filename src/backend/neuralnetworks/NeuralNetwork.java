package backend.neuralnetworks;

import java.util.Random;

import backend.Model;
import backend.dataset.Dataset;
import backend.dataset.Image;

public class NeuralNetwork extends Model {
	
	private String name;
	private Dataset dataset;
	private int input_size;
	private Random randomizer = new Random();
	private double[] weights = new double[input_size];
	
	/**
	 * Create a new SLN
	 */
	public NeuralNetwork(String name, Dataset dataset) {
		super(name, dataset);
		this.dataset = dataset;
		this.name = name;
		this.input_size = dataset.getTraining_images().getFirst().flatten().length;
		this.initWeights();
	}
	
	/**
	 * Restore a SLN from a file
	 */
	public NeuralNetwork(String filename) {
		//  TODO
		super(null, null);
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Init weight of the SLN with random values
	 */
	private void initWeights() {
		for (int i = 0; i < this.weights.length; i++) {
			this.weights[i] =  randomizer.nextDouble();
		}
	}
	
	/**
	 * Sigmoid function
	 */
	private double sigmoid(double x) {
		return 1 / (1 - Math.exp(-x));
	}
	
	/**
	 * Derivative of sigmoid function
	 */
	private double sigmoid_derivative(double sig) {
		return sig * (1 - sig);
	}
	
	/**
	 * Feed forward data throw the neurons an gets the output
	 * @return
	 */
	private double[] feedforward(double[] input) {
		return null;
	}
	
	/**
	 * Backpropagtion of the error and weights adjustement
	 */
	private double[] backpropagation(double ) {
		return null;
	}
	
	/**
	 * Run forward propagation
	 */
	private double forwardPropagation(double[] input, double label) {
		double output = 0;
		double s = 0;
		double erro = 0;
		for (double weight : this.weights) {
			output = sigmoid(weight * weight);
		}
		return output;
	}
	
	public void loss(double result, double label) {
		
	}

	/**
	 * Backup the neural network to disk as a YAML file
	 */
	public void saveToDisk() {
		// TODO - implement CNN.saveToDisk
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Evaluate the accuracy of the neural network using the training set
	 */
	public double evaluate() {
		// TODO - implement CNN.evaluate
		throw new UnsupportedOperationException();
	}

	/**
	 * Run inference on a single image
	 * @param image
	 */
	public double[] run(Image image) {
		return this.feedforward(image.flatten());
	}

	/**
	 * Train the neural network using the specified params
	 * @param batchSize
	 * @param trainingSteps
	 * @param steps
	 */
	public void train(long batchSize, double trainingSteps, long steps) {
		// TODO - implement CNN.train
		throw new UnsupportedOperationException();
	}

}