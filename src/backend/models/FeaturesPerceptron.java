package backend.models;

import java.util.LinkedList;

import backend.dataset.Dataset;
import backend.dataset.Image;

public class FeaturesPerceptron extends Model {

	private Boolean[] featuresEnabled;
	private double[] weights;
	private double poidsZero;

	/**
	 * Constructs a new perceptron and initialize poidsZero and weights to zero
	 * 
	 * @param name
	 * @param dataset
	 */
	public FeaturesPerceptron(String name, Dataset dataset) {
		super(name, dataset);
		this.poidsZero = 0;
		this.weights = new double[this.dataset.getTraining_images().get(0).getFeatures().length];
	}

	public void saveToDisk() {
		// TODO - implement Perceptron.saveToDisk
		throw new UnsupportedOperationException();
	}

	/**
	 * training of the perceptron with images from training_images list
	 * 
	 * @param batchSize
	 * @param trainingSteps
	 * @param NombreEpoch
	 */
	public void train(long batchSize, double trainingSteps, long NombreEpoch) {
		LinkedList<Image> trainingImages = this.dataset.getTraining_images();
		double yRealite;
		int nbEpoch = 0;
		int nbBatch = 0;
		int nbTrainedImages = 0;
		while (nbEpoch < NombreEpoch) {
			while (nbBatch < trainingImages.size() / batchSize)
				while (nbTrainedImages < batchSize) {
					Image trainedImage = trainingImages.get((int) (nbTrainedImages + nbBatch * batchSize));
					double[] caracteristiques = trainedImage.getFeatures();
					yRealite = 0;
					// met a zero les valeurs du tableau correspondantes aux caracteristiques non
					// souhaitees
					for (int i = 0; i < caracteristiques.length; i++) {
						if (featuresEnabled[i] == false) {
							caracteristiques[i] = 0;
						}
					}
					// extraction de la valeur attendue(yrealite) dans le nom de l image en passant
					// par getLabel()
					if (trainedImage.getLabel() == "5") {
						yRealite = 1;
					} else if (trainedImage.getLabel() != "5") {
						yRealite = -1;
					}
					// application de la fonction
					if (yRealite * this.produitScalaire(weights, caracteristiques) + poidsZero <= 0) {
						poidsZero = poidsZero + trainingSteps * yRealite;
						for (int j = 0; j < weights.length; j++) {
							weights[j] = weights[j] + trainingSteps * yRealite * caracteristiques[j];
						}
						nbTrainedImages = nbTrainedImages + 1;
					}
					nbBatch = nbBatch + 1;
				}
			nbEpoch = nbEpoch + 1;
		}
	}

	/**
	 * evaluation of the perceptron with images from testing_images list
	 * 
	 * @return the proportion of good answers from the trained perceptron
	 */
	public double evaluate() {
		LinkedList<Image> testingImages = this.dataset.getTesting_images();
		int compteur = 0;
		double yReal = 0;
		for (int i = 0; i < testingImages.size(); i++) {

			Image testedImage = testingImages.get(i);

			// extraction de la valeur attendue(yrealite) dans le nom de l image en passant
			// par getLabel()
			if (testedImage.getLabel() == "5") {
				yReal = 1;
			} else if (testedImage.getLabel() != "5") {
				yReal = -1;
			}
			// count of good answers
			if (run(testedImage) == yReal) {
				compteur = compteur + 1;
			}
		}
		return (compteur / testingImages.size());
	}

	/**
	 * 
	 * @param image
	 * @return -1 if the image does not represent the number five; returns 1 if it
	 *         does
	 */
	public double run(Image image) {

		if (this.produitScalaire(weights, image.getFeatures()) + poidsZero <= 0) {
			return 1;
		} else
			return -1;

	}

	public double produitScalaire(double[] x, double[] y) {
		if (x.length != y.length)
			throw new RuntimeException("Illegal vector dimensions.");
		double sum = 0.0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i] * y[i];
		}
		return sum;
	}

	@Override
	public double[] predict(Image image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void train(int batchsize, double learningRate, long epochs_number) {
		// TODO Auto-generated method stub

	}

}
