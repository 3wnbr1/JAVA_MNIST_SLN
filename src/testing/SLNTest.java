package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.dataset.Dataset;
import backend.models.SLN;

public class SLNTest {
	
	private Dataset dataset;
	private SLN sln;

	@Test
	public void test() {
		// Create Dataset
		this.dataset = new Dataset("testing", "testing", 0.00005);
		
		// Create SLN
		this.sln = new SLN("SingleLayerNeuralNetwork v0.1", this.dataset);
		
		this.sln.train(32);
	}

}
