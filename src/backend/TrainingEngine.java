package backend;

import backend.dataset.Dataset;

public class TrainingEngine extends Engine {
	
	
	private Dataset dataset;
	
	
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
	public void train(long batchSize, double training_step, double step) {
		// TODO - implement TrainingEngine.train
		throw new UnsupportedOperationException();
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

}