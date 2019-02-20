package backend;

public class Gradient {
	private double angle;
	private double norme;

	public Gradient(double angle, double norme) {
		this.angle = angle;
		this.norme = norme;
	}

	public Gradient() {
		this.angle = 0;
		this.norme = 0;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getNorme() {
		return norme;
	}

	public void setNorme(double norme) {
		this.norme = norme;
	}

	@Override
	public String toString() {
		return "Gradiant [angle=" + angle + ", norme=" + norme + "]";
	}
}
