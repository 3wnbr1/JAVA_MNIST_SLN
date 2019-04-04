package backend;



public class InferenceEngine extends Engine {
	
	String imagePath;

	public void loadModel() {
		// TODO - implement InferenceEngine.loadModel
		throw new UnsupportedOperationException();
	}
	
	public void recupererImage() {
		imagePath=MainFrame.getChosenImagePath();
		
	}

}