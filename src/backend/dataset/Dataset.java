package backend.dataset;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


import backend.prof.LireDossier;


public class Dataset {

	private double test_proportion;
	private String name;
	private String path;
	private Random randomizer;
	private LinkedList<String> training_images_paths;
	private LinkedList<String> testing_images_paths;
	private LinkedList<Image> training_images;
	private LinkedList<Image> testing_images;
	private LireDossier folder_reader;
	private FileIO file;
	
	
	private String[] features_maping = {"\"black pixels ratio\"", "\"entropy\"", "\"gradient average angle\"", "\"gradient average norm\""};

	
	/**
	 * Constructs a new dataset
	 * @param paramName
	 * @param paramPath
	 */
	public Dataset(String paramName, String paramPath, double test_proportion) {
		this.name = paramName;
		this.path = paramPath;
		this.test_proportion = test_proportion;
		this.folder_reader = new LireDossier(this.path);
		this.randomizer = new Random();
		this.splitDataset();
	}

	/**
	 * Constructs a dataset from a backup file with features already computed
	 * @param dataset_file_path
	 */

	public Dataset(String dataset_file_path) {
		this.randomizer = new Random();
		// TODO - implement Dataset.Dataset
		throw new UnsupportedOperationException();
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
	 * Dumps a backup file on disk which we can use later for recreating the Dataset
	 * @throws IOException 
	 */
	public void saveToDisk() throws IOException {
		String writeBuffer = new String();
		this.file = new FileIO(this.path + "/dataset.yml");
		writeBuffer.concat("version: 1\n\n" + "dataset: " + this.name + "\n\nfeatures:\n"); // Header
		for (String feature : this.features_maping) {
			writeBuffer.concat("\t- " + feature + "\n");
		}
		writeBuffer.concat("\ntraining:\n");
		for (Iterator<Image> i = this.testing_images.iterator(); i.hasNext();) { // Training images
			writeBuffer.concat("\t" + i.next().toString() + "\n");
		}
		writeBuffer.concat("\ntesting:\n");
		for (Iterator<Image> i = this.training_images.iterator(); i.hasNext();) { // Testing images
			writeBuffer.concat("\t" + i.next().toString() + "\n");
		}
		this.file.write(writeBuffer);
	}

	/**
	 * Splits the dataset
	 */
	public void splitDataset() {
		LinkedList<String> test_images = new LinkedList<String>();
		LinkedList<String> images = this.datasetImages(this.test_proportion);
		int test_images_number = (int) (this.test_proportion * images.size());
		int bound = images.size();
		
		// Take test_image_number from images. The rest is training images
		for (int i=0; i < test_images_number; i++) {
			test_images.add(images.remove(this.randomizer.nextInt(bound)));
			bound -= 1;
		}
		
		// Writeback results
		this.testing_images_paths = test_images;
		this.training_images_paths = images;
		
		// Create all images
		this.imagesToMemory();
	}
	
	/*
	 * Create all images in memory
	 */
	private void imagesToMemory() {
		this.training_images.clear();
		this.testing_images.clear();
		
		for (Iterator<String> i = this.training_images_paths.iterator(); i.hasNext();) {
			this.training_images.add(new Image(i.next()));
		}
		
		for (Iterator<String> i = this.testing_images_paths.iterator(); i.hasNext();) {
			this.testing_images.add(new Image(i.next()));
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

}
