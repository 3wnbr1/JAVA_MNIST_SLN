package testing;

import org.junit.Assert;
import org.junit.Test;

import backend.dataset.Dataset;
import backend.dataset.Image;

public class DatasetTest {

	private Dataset dataset;
	private Image image;

	@Test
	public void test() {

		this.dataset = new Dataset("Test", "testing", 0.1, 12, 12);

		this.dataset.setName("UT");
		Assert.assertEquals("UT", this.dataset.getName());

		this.dataset.setTestProportion(0.2);
		Assert.assertEquals(0.2, this.dataset.getTestProportion(), 0);

		// Test images now
		this.image = this.dataset.getTraining_images().getFirst();
		this.image = this.dataset.getTesting_images().getFirst();
		this.image.getLabel();

		this.image.getFeatures();
	}

}
