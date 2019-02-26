package backend.dataset;

public class Gradient {
	private double angle;
	private double norme;

	public Gradient(double angle, double norme) {
		this.angle = angle;
		this.norme = norme;
	}

	public double getAngle() {
		return angle;
	}

	public double getNorme() {
		return norme;
	}
}
