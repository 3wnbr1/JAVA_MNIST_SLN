package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import backend.TrainingEngine;
import backend.dataset.Dataset;
import backend.dataset.Image;


public class InferenceEngine extends Engine {

	private static String imagePath;
	private static int lancement;
	private static int valeurLancement;

	/*
	 * Construct an Inference Engine
	 */
	public InferenceEngine() {

	}

	/**
	 * Restore a saved model
	 * @param path
	 */
	public void loadModel(String path) {
		try {
			FileInputStream file_input = new FileInputStream(new File(path));
			ObjectInputStream object_input = new ObjectInputStream(file_input);
			this.model = (backend.models.Model) object_input.readObject();
			object_input.close();
			file_input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Object stream error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



	/*
	 * Run inference on an image batch
	 */
	public double[] runInference(Image input_image) {
		return this.model.predict(input_image);
	}


	/**
	 * Return corresponding TrainingEngine
	 * @param dataset
	 * @return
	 */
	public TrainingEngine toTraining(Dataset dataset) {
		TrainingEngine trainer = new TrainingEngine();
		trainer.model = this.model;
		trainer.setDataset(dataset);
		return trainer;
	}

}
