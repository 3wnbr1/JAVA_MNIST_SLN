package frontend;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class ImageInserter extends JButton {
	
	private String path;
	private int width;
	private int height;
	private JPanel panel = new JPanel();
	private Image img;
	private JLabel label;
	private Icon icon;
	private Image scaleImage;
	
	
	
	public ImageInserter(String Ppath, JPanel Ppanel) {
		
		path = Ppath;
		panel = Ppanel;				
	}
	
	
	void rescale() {
		
		panel.setVisible(true); 
		width = (int) panel.getSize().getWidth();
		height = (int) panel.getSize().getHeight();		
		img = Toolkit.getDefaultToolkit().getImage(path); //TODO conserver proportions image
		scaleImage = img.getScaledInstance(width, height,Image.SCALE_DEFAULT);
		icon = new ImageIcon(scaleImage, "image choisie");
		label = new JLabel(icon);
	}
	
	//experimental: rescale each time the mouse button is released
	public void mouseReleased(MouseEvent e) {
		rescale();
	}
	//end

	
	public JLabel getlabel() {
		
		return label;
		
	}
	


}
