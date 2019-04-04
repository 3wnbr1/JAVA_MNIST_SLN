package backend;

import backend.dataset.Dataset;
import frontend.TrainingFrame2;

public class TrainingEngine extends Engine {
	
	
	private Dataset dataset;
	private int progressStatus; //etat d'avancement d'entrainement
	// TODO implementer progressStatus dans la barre d'avancement dans trainingFrame
	
	
	public TrainingEngine() {
		
	}
	
	/*
	 * Save trained model
	 */
	public void saveModel() {
		// TODO - implement TrainingEngine.saveModel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param batchSize
	 * @param training_step
	 * @param step
	 */
	public void train(long batchSize, double training_step, long nombreEpoch) {
		// TODO - implement TrainingEngine.train - VOIR TRAININGFRAME
		//throw new UnsupportedOperationException();
		System.out.println("lancement de la phase d'entrainement reussi avec succes");
		System.out.println("les parametres selectionnees sont : ");
		System.out.println("Epoch = " + TrainingFrame2.nombreEpoch);		
		System.out.println("batchSize = " + TrainingFrame2.batchSize);
		System.out.println("trainingStep = " + TrainingFrame2.trainingStep);
		
		
		
		
		
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
		return inferer;
	}
	
	public void setProgressionStatus(int a) {
		progressStatus = 42;
	}
	
	public int getProgressionStatus() {
		return progressStatus;
	}

}