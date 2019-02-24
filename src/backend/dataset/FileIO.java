package backend.dataset;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;


public class FileIO {
	
	private String name;
	private File file;
	private FileReader reader;
	private FileWriter writer;
	private BufferedReader readBuffer;
	private BufferedWriter writeBuffer;
	
	public FileIO(String name, String path) {
		this.name = name;
		this.file = new File(path + name + ".dtst");
	}
	
	/*
	 * 
	 */
	public FileIO(String filepath) {
		this.file = new File(filepath);
	}
	
	/*
	 * Write to a file
	 */
	void write(String contents) throws IOException {
		this.writer = new FileWriter(this.file);
		this.writer.write(contents);
		this.writer.close();
	}
	
	/*
	 * Read a file and return it
	 */
	List<String> readlines() throws IOException {
		this.reader = new FileReader(this.file);
		this.readBuffer = new BufferedReader(this.reader);
		Stream<String> lines = this.readBuffer.lines();
		
		List<String> contents = new ArrayList<String>();
		for (Iterator<String> line = lines.iterator(); line.hasNext();) {
			contents.add(line.next());
		}
		
		this.readBuffer = null;
		this.reader.close();
		return contents;
	}
	
}
