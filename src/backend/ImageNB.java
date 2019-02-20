package backend;


public class ImageNB {
	private int[][] ptc;

	public ImageNB(int iTailleX, int iTailleY) {
		ptc = new int[iTailleY][iTailleX];
	}

	public int getPoint(int x, int y) {
		return ptc[y][x];
	}

	public void setPoint(int x, int y, int c) {
		if (c > 255) {
			ptc[y][x] = 255;
		} else
			ptc[y][x] = c;
	}

	public int getTailleX() {
		return ptc[0].length;
	}

	public int getTailleY() {
		return ptc.length;
	}
	
	public boolean estNoir(int couleur) {
		if (couleur>128) return false;
		return true;
	}
		
}
