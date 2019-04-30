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
	
	
	public ImageInserter(JPanel Ppanel) {
		panel = Ppanel;
	}
	
	void rescale(String path) {
		panel.setVisible(true); 
		width = (int) panel.getSize().getWidth();
		height = (int) panel.getSize().getHeight();		
		img = Toolkit.getDefaultToolkit().getImage(path); //TODO conserver proportions image
		scaleImage = img.getScaledInstance(width, height,Image.SCALE_DEFAULT);
		icon = new ImageIcon(scaleImage, "image choisie");
		label = new JLabel(icon);
	}
	
	public void set_path(String path) {
		this.path = path;
	}
}
