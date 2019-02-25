package backend.dataset;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class FileIO {
	
	private File file;
	private FileReader reader;
	private FileWriter writer;
	private BufferedReader readBuffer;
	
	/*
	 * Construct a FileIO from a filepath
	 */
	public FileIO(String filepath) {
		this.file = new File(filepath);
	}
	
	/*
	 * Private method to a file
	 */
	private void write(String contents, boolean append) throws IOException {
		if (!this.file.canWrite()) {
			throw new IOException();
		}
		this.writer = new FileWriter(this.file, append);
		this.writer.write(contents);
		this.writer.close();
	}
	
	/*
	 * Write to a file
	 */
	public void write(String contents) throws IOException {
		this.write(contents, false);
	}
	
	/*
	 * Append to a file
	 */
	public void append(String contents) throws IOException {
		this.write(contents, true);
	}
	
	/*
	 * Read a file and return it
	 */
	List<String> readlines() throws IOException {
		if (!this.file.canRead()) {
			throw new IOException();
		}
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
	
	/*
	 * Delete File from FileSystem
	 */
	public void delete() throws IOException {
		if (!this.file.canWrite()) {
			throw new IOException();
		}
		this.file.delete();
	}
}
