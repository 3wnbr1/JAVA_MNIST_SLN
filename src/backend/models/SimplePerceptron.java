package backend.models;

import backend.Model;
import backend.dataset.Dataset;
import backend.dataset.Image;

public class SimplePerceptron extends Model {

	public SimplePerceptron(String model_file_path) {
		super(model_file_path);
		// TODO Auto-generated constructor stub
	}
	
	public SimplePerceptron(String name, Dataset dataset) {
		super(name, dataset);
	}
	
	public void saveToDisk() {
		// TODO - implement Perceptron.saveToDisk
		throw new UnsupportedOperationException();
	}
	
	public void train(long batchSize, double trainingSteps, long NombreEpoch) {
		
	}
	
	public double evaluate() {
		return accuracy;
		
	}
	
	public double run(Image image) {
		return accuracy;
		
	}
	
}
