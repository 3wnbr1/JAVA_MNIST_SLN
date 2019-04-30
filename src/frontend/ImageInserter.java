package frontend;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class ImageInserter extends JButton {
	
	private int width;
	private int height;
	private JPanel panel = new JPanel();
	private Image img;
	private JLabel jlabel;
	private Icon icon;
	private Image scaledImage;
	
	
	public ImageInserter(JPanel Ppanel) {
		panel = Ppanel;
		this.jlabel = new JLabel();
	}
	
	void rescale(String path) {
		this.panel.setVisible(true); 
		this.width = (int) panel.getSize().getWidth();
		this.height = (int) panel.getSize().getHeight();		
		this.img = Toolkit.getDefaultToolkit().getImage(path); //TODO conserver proportions image
		this.scaledImage = img.getScaledInstance(width, height,Image.SCALE_DEFAULT);
		this.icon = new ImageIcon(scaledImage, "image choisie");
		this.jlabel.setIcon(icon);
	}
	
	public JLabel getJLabel() {
		return this.jlabel;
	}
}
