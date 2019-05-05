package backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import backend.dataset.Dataset;
import backend.models.FeaturesPerceptron;
import backend.models.SLN;
import frontend.TrainingFrame2;

public class TrainingEngine extends Engine {


	private Dataset dataset;
	private int progressStatus; //etat d'avancement d'entrainement
	// TODO implementer progressStatus dans la barre d'avancement dans trainingFrame


	public TrainingEngine() {
		this.dataset = new Dataset("mnist", "mnist", 0.2, 28, 28);

	}

	/*
	 * Save trained model
	 */
	public void saveModel(String path) {
		try {
			FileOutputStream file_output = new FileOutputStream(new File(path));
			ObjectOutputStream object_output = new ObjectOutputStream(file_output);
			object_output.writeObject(this.model);
			object_output.close();
			file_output.close();
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	/**
	 *
	 * @param batchSize
	 * @param training_step
	 * @param step
	 */
	public void train(int batchSize, double training_step, long nombreEpoch) {
		this.model.train(batchSize, training_step, nombreEpoch);
	}

	public void train(double training_step, long nombreEpoch) {
		this.model.train(training_step, nombreEpoch);
	}

	public void train(long nombreEpoch) {
		this.model.train(nombreEpoch);
	}

	/*
	 * Return current dataset
	 */
	public Dataset getDataset() {
		return this.dataset;
	}

	/*
	 * Change the dataset used in training
	 */
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}

	/**
	 * Return corresponding InferenceEngine
	 * @return
	 */
	public InferenceEngine toInference() {
		InferenceEngine inferer = new InferenceEngine();
		inferer.model = this.model;
		return inferer;
	}

	public void setProgressionStatus(int a) {
		progressStatus = 42;
	}

	public int getProgressionStatus() {
		return progressStatus;
	}

}
