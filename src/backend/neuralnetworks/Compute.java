package backend.neuralnetworks;

public class Compute {
	
	/**
	 * Dot product between 2 2-dimensionnal arrays
	 * @param mat1
	 * @param mat2
	 */
	public static double[][] dot(double[][] mat1, double[][] mat2) {
		double result = 0;
		int x1 = mat1.length;
		int x2 = mat2.length;
		int y1 = mat1[0].length;
		int y2 = mat2[0].length;
		double[][] output = new double[x2][y1];
		
		for (int x=0; x<x2; x++) {
			for (int y=0; y<y1; y++) {
				result = 0;
				for (int i=0; i<y2; i++) {
					for (int j=0; j<x1; j++) {
						result += mat2[i][x] * mat1[y][j];
					}
				}
				output[x][y] = result;
			}
		}
		return output;
	}
	
}
