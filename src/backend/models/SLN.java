package backend.models;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import backend.dataset.Dataset;
import backend.dataset.Image;

public class SLN extends Model {

	protected int IMAGE_XSIZE;
	protected int IMAGE_YSIZE;
	protected int LABELS = 10;
	protected Random randomizer = new Random();
	protected double[][] weights;

	public SLN(String name, Dataset dataset) {
		super(name, dataset);
		this.IMAGE_XSIZE = this.dataset.getImagesWidth();
		this.IMAGE_YSIZE = this.dataset.getImagesHeight();
		this.weights = new double[LABELS][IMAGE_XSIZE * IMAGE_YSIZE];
	}

	/**
	 * Init cells weights
	 */
	protected void initWeights() {
		for (int index = 0; index < LABELS; index++) {
			for (int i = 0; i < (IMAGE_XSIZE * IMAGE_YSIZE); i++) {
				weights[index][i] = randomizer.nextDouble();
			}
		}
	}

	/**
	 * Run forward propagation for alls cells
	 * 
	 * @return output
	 */
	protected double[] forwardPropagation(double[] input) {
		double[] output = new double[LABELS];
		for (int label = 0; label < LABELS; label++) {
			for (int i = 0; i < input.length; i++) {
				output[label] += this.weights[label][i] * input[i];
			}
			output[label] = 1 / (1 + Math.exp(-output[label]));
		}
		return output;
	}

	/**
	 * Loss function
	 * 
	 * @param input
	 * @param target_vector
	 * @return loss for each cell
	 */
	protected double[] loss(double[] output, double[] target_vector) {
		double[] loss = new double[LABELS];
		for (int label = 0; label < LABELS; label++) {
			loss[label] = target_vector[label] - output[label];
		}
		return loss;
	}

	/**
	 * Return the output vector corresponding to label
	 * 
	 * @param label
	 * @return
	 */
	protected double[] getTargetVector(int label) {
		double[] vector = new double[LABELS];
		vector[label] = 1;
		return vector;
	}

	/**
	 * Backpropagate the error and update weights
	 * 
	 * @param input
	 * @param loss
	 * @param learning_rate
	 */
	protected void backpropagation(double[] input, double loss[], double learning_rate) {
		for (int label = 0; label < LABELS; label++) {
			for (int i = 0; i < input.length; i++) {
				this.weights[label][i] += learning_rate * input[i] * loss[label];
			}
		}
	}

	/**
	 * Run single training step
	 * 
	 * @param learning_rate
	 * @param input
	 * @param label
	 * @return average loss
	 */
	protected double trainStep(double learning_rate, double[] input, int label) {
		double[] target_vector = this.getTargetVector(label);
		double[] output = this.forwardPropagation(input);
		double[] loss = this.loss(output, target_vector);
		this.backpropagation(input, loss, learning_rate);
		return this.average(loss);
	}

	/**
	 * get a dataset batch
	 * 
	 * @param images_set
	 * @param batchsize
	 * @return
	 */
	protected LinkedList<Image> getBatch(LinkedList<Image> images_set, long batchsize) {
		int image_set_size = images_set.size();
		if ((batchsize == 0) || (batchsize == image_set_size)) {
			return images_set;
		} else if (batchsize > (image_set_size / 2)) {
			// TODO
			return null;
		} else {
			// TODO
			return null;
		}
	}

	/**
	 * Return most probable result
	 * 
	 * @param output
	 * @return
	 */
	public static int maxDetection(double[] output) {
		int max = 0;
		for (int i = 0; i < output.length; i++) {
			if (output[max] < output[i]) {
				max = i;
			}
		}
		return max;
	}

	public void train(int batchsize, double learningRate, long epochs_number) {
		this.initWeights();
		for (int epoch = 0; epoch < epochs_number; epoch++) {
			System.out.printf("Training epoch %d / %d with %d images\n", epoch, epochs_number, batchsize);
			double[] losses = new double[batchsize];
			int index = 0;
			LinkedList<Image> training = this.getBatch(dataset.getTraining_images(), batchsize);
			Collections.shuffle(training);
			for (Iterator<Image> itr = training.iterator(); itr.hasNext();) {
				Image image = itr.next();
				losses[index] = this.trainStep(learningRate, image.flatten(), Integer.parseInt(image.getLabel()));
				index++;
			}
			System.out.printf("Average loss for epoch %f\n", this.average(losses));
			System.out.printf("Success rate on testing is %f \n", this.evaluate() * 100);
		}
	}

	public double[] predict(Image image) {
		return this.forwardPropagation(image.flatten());
	}

	public double evaluate() {
		double[] output;
		int label;
		Image image;
		int sucess = 0;
		int total = 0;
		LinkedList<Image> testing = this.dataset.getTesting_images();
		for (Iterator<Image> itr = testing.iterator(); itr.hasNext();) {
			image = itr.next();
			label = Integer.parseInt(image.getLabel());
			output = this.predict(image);
			if (SLN.maxDetection(output) == label) {
				sucess++;
			}
			total++;
		}
		return sucess / (double) total;
	}
}
