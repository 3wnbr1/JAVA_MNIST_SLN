package backend;

import backend.dataset.Dataset;
import backend.dataset.Image;

public class InferenceEngine extends Engine {
	
	private Dataset dataset;

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


}