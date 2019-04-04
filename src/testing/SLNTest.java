package testing;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		
		try {
			FileOutputStream f = new FileOutputStream(new File("sln.bin"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(this.sln);
			o.close();
			System.out.println("File writen");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		
		this.sln = null;
		
		try {
			FileInputStream fi = new FileInputStream(new File("sln.bin"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			this.sln = (SLN) oi.readObject();
			oi.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
	}

}
