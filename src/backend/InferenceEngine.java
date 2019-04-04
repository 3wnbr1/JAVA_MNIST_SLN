package backend;

import backend.TrainingEngine;
import backend.dataset.Dataset;
import backend.dataset.Image;


public class InferenceEngine extends Engine {

	private Dataset dataset;
	private String imagePath;

	/*
	 * Construct an Inference Engine
	 */
	public InferenceEngine() {

	}

	public void loadModel() {
		// TODO - implement InferenceEngine.loadModel
		throw new UnsupportedOperationException();
	}

	/*
	 * Run inference on an image batch
	 */
	public double[] runInference(Image[] inputBatch) {
		return null;
	}


	/**
	 * Return corresponding TrainingEngine
	 * @param dataset
	 * @return
	 */
	public TrainingEngine toTraining(Dataset dataset) {
		TrainingEngine trainer = new TrainingEngine();
		trainer.setDataset(dataset);
		return trainer;
	}

	public void recupererImage() {
		imagePath=MainFrame.getChosenImagePath();

	}


}
