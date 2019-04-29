package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.TrainingEngine;

public class TrainingEngineTest {

	private TrainingEngine training_engine;
	
	@Test
	public void test() {
		
		this.training_engine = new TrainingEngine();
		
		this.training_engine.train(8000, 0.01, 15);
		
		this.training_engine.saveModel("sln.model");
	}

}
