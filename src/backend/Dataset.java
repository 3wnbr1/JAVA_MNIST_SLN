package backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;

public class Dataset {

	private String name;
	private String path;
	private Random random;
	private LinkedList<Image> images;
	private String[] features_maping;
	private LireDossier folder_reader;

	public Dataset(String paramName, String paramPath) {
		name = paramName;
		path = paramPath;
	}

	/**
	 * 
	 * @param dataset_file_path
	 */

	public Dataset(String dataset_file_path) {
		// TODO - implement Dataset.Dataset
		throw new UnsupportedOperationException();
	}

	public String datasetFiles() {

		// TODO - implement Dataset.datasetFiles
		throw new UnsupportedOperationException();
	}

	public void saveToDisk() {

		throw new UnsupportedOperationException();
	}

	public LinkedList<Image> replirTest(LinkedList<Image> list) {
		int taille = list.size();

		LinkedList<Image> imagesTest = new LinkedList<Image>();
		for (int i = 0; i <= taille; i++) {
			boolean choix = Math.random() < 0.5;
			if (choix = true) {
				imagesTest.addLast(list.get(i));
			}
		}
		return imagesTest;
	}

	// nb defini puis reste (sans duplicata) dans l'autre liste

	public LinkedList<Image> replirTraining(int tailleEchantillon, LinkedList<Image> list) {

		LinkedList<Image> imagesTrain = new LinkedList<Image>();
		int taille = list.size();
		int randomNum = andom.nextInt(taille - 0 + 1) + 0; // random.nextInt(max - min + 1) + min
		for (int i = 0; i <= tailleEchantillon + 1; i++) {
			imagesTrain.addLast(list.get(randomNum));
		}

		return imagesTrain;

	}

	// public void replace() {
	// String oldFileName = "try.dat";
	// String tmpFileName = "tmp_try.dat";}

	// PrintWriter writer = new PrintWriter(name + .txt, );
	// writer.newLine();
	// line.separator
	// newLine()
	// Image.tostring()
	// PrintWriter out = new PrintWriter(new BufferedWriter(new
	// FileWriter("foo.out")));
	// will buffer the PrintWriter's output to the file. Without buffering, each
	// invocation of a print() method would cause characters to be converted into
	// bytes that would then be written immediately to the file, which can be very
	// inefficient.

	// FileHandler.exportDataset(data,new File("output.txt"));

	// File file = new File(path);
	// if(file.isFile())
	// {
	// C'est un fichier
	// }
	// else {

	// }
}
