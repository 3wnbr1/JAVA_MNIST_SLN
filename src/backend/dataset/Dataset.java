package backend.dataset;


import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import backend.prof.ImageNB;
import backend.prof.LireDossier;


public class Dataset {

	private double test_proportion;
	private int images_height;
	private int images_width;
	private String name;
	private String path;
	private Random randomizer;
	private LinkedList<String> training_images_paths;
	private LinkedList<String> testing_images_paths;
	private LinkedList<Image> training_images;
	private LinkedList<Image> testing_images;
	private LireDossier folder_reader;


	/**
	 * Constructs a new dataset
	 * @param paramName
	 * @param paramPath
	 */
	public Dataset(String name, String path, double test_proportion, int images_height, int images_width) {
		this.name = name;
		this.path = path;
		this.images_height = images_height;
		this.images_width = images_width;
		this.test_proportion = test_proportion;
		this.folder_reader = new LireDossier(this.path);
		this.randomizer = new Random();
		this.splitDataset();
	}


	/**
	 * Outputs only the *.JPG filenames in current folder
	 * @return String[]
	 */
	private LinkedList<String> datasetImages(double test_proportion) {
		String[] files = this.folder_reader.getNomFichiers();
		LinkedList<String> images = new LinkedList<String>();
		for (String file : files) {
			if (file.toLowerCase().endsWith(".jpg")) {
				images.add(file);
			}
		}
		return images;
	}

	/**
	 * Splits the dataset
	 */
	public void splitDataset() {
		LinkedList<String> test_images = new LinkedList<String>();
		LinkedList<String> images = this.datasetImages(this.test_proportion);
		int test_images_number = (int) (this.test_proportion * images.size());
		int bound = images.size();

		System.out.println("Spliting Dataset");

		// Take test_image_number from images. The rest is training images
		for (int i=0; i < test_images_number; i++) {
			test_images.add(images.remove(this.randomizer.nextInt(bound)));
			bound -= 1;
		}

		System.out.println("Dataset has been split");

		// Writeback results
		this.testing_images_paths = test_images;
		this.training_images_paths = images;

		// Create all images
		this.imagesToMemory();
		System.out.println("Images are now in memory");
	}

	/*
	 * Create all images in memory
	 */
	private void imagesToMemory() {
		this.training_images = new LinkedList<Image>();
		this.testing_images = new LinkedList<Image>();

		for (Iterator<String> i = this.training_images_paths.iterator(); i.hasNext();) {
			this.training_images.add(new Image(this.path+"/"+i.next(), this.images_height, this.images_width));
		}

		for (Iterator<String> i = this.testing_images_paths.iterator(); i.hasNext();) {
			this.testing_images.add(new Image(this.path+"/"+i.next(), this.images_height, this.images_width));
		}
	}

	/*
	 * Return the proportion of test image in Dataset
	 */
	public double getTestProportion() {
		return test_proportion;
	}

	/*
	 * Method that can be used to change the proportion of test image in Dataset
	 */
	public void setTestProportion(double test_proportion) {
		this.test_proportion = test_proportion;
		this.splitDataset();
	}
	
	/*
	 * Returns Dataset Name
	 */
	
	public String getName() {
		return name;
	}

	/*
	 * Method that can be used to change Dataset name
	 */
	
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Return Training Images
	 */
	public LinkedList<Image> getTraining_images() {
		return training_images;
	}

	/*
	 * Return Testing Images
	 */
	public LinkedList<Image> getTesting_images() {
		return testing_images;
	}


	public int getImagesHeight() {
		return images_height;
	}


	public int getImagesWidth() {
		return images_width;
	}
}
