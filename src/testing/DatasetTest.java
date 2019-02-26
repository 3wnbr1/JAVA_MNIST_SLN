package testing;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import backend.dataset.Dataset;
import backend.dataset.Image;

public class DatasetTest {
	
	private Dataset dataset;
	private Image image;

	
	@Test
	void test() {
		
		//Testing Dataset
		this.dataset = new Dataset("Test", "testing", 0.1);
		
		this.dataset.setName("UT");
		assertEquals("UT", this.dataset.getName());
		
		this.dataset.setTestProportion(0.2);
		assertEquals(0.2, this.dataset.getTestProportion());
		
		this.dataset.computeFeatures();
		
		try {
			this.dataset.saveToDisk();
			
			throw new IOException();
		} catch (IOException e) {
			
		}
		
		// Test images now
		this.image = this.dataset.getTraining_images().getFirst();
		this.image = this.dataset.getTesting_images().getFirst();
		this.image.getLabel();
		
		this.image.getFeatures();
	}

}
