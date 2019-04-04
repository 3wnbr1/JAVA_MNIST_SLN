package backend.models;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import backend.Model;
import backend.dataset.Dataset;
import backend.dataset.Image;
import backend.prof.ImageCalculs;
import backend.prof.ImageNB;

public class SLN extends Model {


	private int LABELS = 10;
	private int IMAGE_XSIZE = 12;
	private int IMAGE_YSIZE = 12;

	private Random randomizer = new Random();
	private double[][] weights = new double[LABELS][IMAGE_XSIZE*IMAGE_YSIZE];



	public SLN(String model_file_path) {
		super(model_file_path);
		// TODO Auto-generated constructor stub
	}
	
	public SLN(String name, Dataset dataset) {
		super(name, dataset);
		this.initDataset(dataset);
	}

	/**
	 * Flatten an ImageNB to a 1-Dimension Array
	 * @param image
	 * @return
	 */
	private double[] flatten(ImageNB image) {
		int x_size = image.getTailleX();
		int y_size = image.getTailleY();
		double[] flattened = new double[x_size*y_size];

		for (int y=0; y<y_size; y++) {
			for (int x=0; x<x_size; x++) {
				flattened[(y*y_size + x_size) - 1] = (double) image.getPoint(x, y) / 255;
			}
		}

		return flattened;
	}


	/**
	 * Preprocess an Image object resising and flattening it for the Perceptron
	 * @param image
	 * @return
	 */
	private Image preprocess(Image image) {
		double[] flattened = new double[IMAGE_XSIZE * IMAGE_YSIZE];
		ImageNB sm_image = ImageCalculs.buffToImageNB(ImageCalculs.redimensionnerImage(image.toBufferedImage(), IMAGE_XSIZE, IMAGE_YSIZE));
		image.setFlattened(this.flatten(sm_image));
		return image;
	}


	/**
	 * Init the dataset with flattened and resized images
	 * @param dataset
	 */
	private void initDataset(Dataset dataset) {
		LinkedList<Image> training_dataset = dataset.getTraining_images();
		LinkedList<Image> testing_dataset = dataset.getTesting_images();
		LinkedList<Image> training_dataset_preproc = new LinkedList<Image>();
		LinkedList<Image> testing_dataset_preproc = new LinkedList<Image>();

		for (Iterator<Image> itr = training_dataset.iterator(); itr.hasNext();) {
			training_dataset_preproc.add(this.preprocess(itr.next()));
		}

		for (Iterator<Image> itr = testing_dataset.iterator(); itr.hasNext();) {
			testing_dataset_preproc.add(this.preprocess(itr.next()));
		}

		dataset.overrideTrainingImages(training_dataset_preproc);
		dataset.overrideTestingImages(testing_dataset_preproc);
		this.dataset = dataset;
	}


	/**
	 * Init cells weights
	 */
	private void initWeights() {
		for (int index = 0; index < LABELS; index++) {
			for (int i = 0; i<(IMAGE_XSIZE*IMAGE_YSIZE); i++) {
				weights[index][i] = randomizer.nextDouble();
			}
		}
	}


	/**
	 * Run forward propagation for alls cells
	 * @return output
	 */
	private double[] forwardPropagation(double[] input) {
		double[] output = new double[LABELS];
		for (int label = 0; label<LABELS; label++) {
			for (int i = 0; i < input.length; i++) {
				output[label] += this.weights[label][i] * input[i];
			}
		}
		return output;
	}
	
	
	/**
	 * Loss function
	 * @param input
	 * @param target_vector
	 * @return loss for each cell
	 */
	private double[] loss(double[] output, double[] target_vector) {
		double[] loss = new double[LABELS];
		for (int label = 0; label<LABELS; label++) {
			loss[label] = target_vector[label] - output[label];
		}
		return loss;
	}

	/**
	 * Return the output vector corresponding to label
	 * @param label
	 * @return
	 */
	private double[] getTargetVector(int label) {
		double[] vector = new double[LABELS];
		vector[label] = 1;
		return vector;
	}
	
	
	/**
	 * Backpropagate the error and update weights
	 * @param input
	 * @param loss
	 * @param learning_rate
	 */
	private void backpropagation(double[] input, double loss[], double learning_rate) {
		for (int label = 0; label<LABELS; label++) {
			for (int i = 0; i < input.length; i++) {
				this.weights[label][i] += learning_rate * input[i] * loss[label];
			}
		}
	}
	
	/**
	 * Sum elements from an array
	 * @param input
	 * @return
	 */
	private double sum(double[] input) {
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
	private double average(double[] input) {
		return this.sum(input) / (double) input.length;
	}
	
	
	/**
	 * Run single training step
	 * @param learning_rate
	 * @param input
	 * @param label
	 * @return average loss
	 */
	private double trainStep(double learning_rate, double[] input, int label) {
		double[] target_vector = this.getTargetVector(label);
		double[] output = this.forwardPropagation(input);
		double[] loss = this.loss(output, target_vector);
		this.backpropagation(input, loss, learning_rate);
		return this.average(loss);
	}
	
	
	/**
	 * get a dataset batch
	 * @param images_set
	 * @param batchsize
	 * @return
	 */
	private LinkedList<Image> getBatch(LinkedList<Image> images_set, long batchsize) {
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
	

	public void saveToDisk() {
		// TODO - implement Perceptron.saveToDisk
		throw new UnsupportedOperationException();
	}
	
	public void train(double learningRate, long epochs_number) {
		this.train(this.dataset.getTraining_images().size(), learningRate, epochs_number);
	}
	
	public void train(long epochs_number) {
		this.train(0.05, epochs_number);
	}

	public void train(int batchsize, double learningRate, long epochs_number) {
		this.initWeights();
		for (int epoch = 0; epoch < epochs_number; epoch++) {
			System.out.printf("Training epoch %d / %d with %d images\n", epoch, epochs_number, batchsize);
			double[] losses = new double[batchsize];
			int index = 0;
			LinkedList<Image> training = this.getBatch(dataset.getTraining_images(), batchsize); 
			for (Iterator<Image> itr = training.iterator(); itr.hasNext();) {
				Image image = itr.next();
				losses[index] = this.trainStep(learningRate, image.getFlattened(), Integer.parseInt(image.getLabel()));
				index++;
			}
			System.out.printf("Average loss for epoch %f\n", this.average(losses));
		}
	}

	public double evaluate() {
		return accuracy;

	}

	public double run(Image image) {
		return accuracy;

	}

}
