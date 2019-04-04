package backend.prof;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCalculs {

	public static ImageNB buffToImageNB(BufferedImage buff) {
		ImageNB image = new ImageNB(buff.getWidth(), buff.getHeight());
		int rgb, rouge, vert, bleu, valeur;
		// int alpha;
		// System.out.println(buff.getWidth()+" "+buff.getHeight());
		int i, j;
		for (i = 0; i < buff.getHeight(); i++) {
			for (j = 0; j < buff.getWidth(); j++) {
				rgb = buff.getRGB(j, i);
				// alpha = (rgb >>24 ) & 0xFF;
				rouge = (rgb >> 16) & 0xFF;
				vert = (rgb >> 8) & 0xFF;
				bleu = rgb & 0xFF;
				valeur = (rouge + vert + bleu) / 3;
				image.setPoint(j, i, valeur);
			}
		}
		return image;
	}

	public static BufferedImage redimensionnerImage(BufferedImage image, int iTailleFenX, int iTailleFenY) {
		BufferedImage imageRedim = new BufferedImage(iTailleFenX, iTailleFenY, image.getType());
		int i, j, rgb;
		int oldX, oldY;
		for (i = 0; i < imageRedim.getHeight(); i++) {
			for (j = 0; j < imageRedim.getWidth(); j++) {
				oldX = (int) (j * image.getWidth() / (double) imageRedim.getWidth());
				oldY = (int) (i * image.getHeight() / (double) imageRedim.getHeight());
				rgb = image.getRGB(oldX, oldY);
				imageRedim.setRGB(j, i, rgb);
			}
		}
		return imageRedim;
	}

	public static BufferedImage imageNBToBuff(ImageNB image) {
		BufferedImage buff = new BufferedImage(image.getTailleX(), image.getTailleY(), 5);
		int i, j, rgb;
		for (i = 0; i < buff.getHeight(); i++) {
			for (j = 0; j < buff.getWidth(); j++) {
				rgb = (255 << 24) + (image.getPoint(j, i) << 16) + (image.getPoint(j, i) << 8) + image.getPoint(j, i);
				buff.setRGB(j, i, rgb);
			}
		}
		return buff;
	}

	public static void sauvegarderImage(BufferedImage image, String nomFichier) {
		try {
			File outputfile = new File(nomFichier);
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static BufferedImage chargerImage(String nomFichier) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(nomFichier));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
