/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {

		//// Replace this comment with your code	
		/// 
		StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();
        
       	double x1 = 0.5;     // Top center
		double y1 = 0.8;    // Top 

		double x2 = 0.1;   // Bottom left (with margin)
		double y2 = 0.15;    // Bottom 

		double x3 = 0.9;   // Bottom right (with margin)
		double y3 = 0.15;    // Bottom
        
      
        sierpinski(n, x1,  x2, x3, y1, y2, y3);
        

        StdDraw.show();
		
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {

		if (n == 0) {
            double[] x = {x1, x2, x3};
            double[] y = {y1, y2, y3};
            StdDraw.filledPolygon(x, y);
            return;
        }
        
        // Recursive case: find midpoints of the three sides
        double midX12 = (x1 + x2) / 2;  
        double midY12 = (y1 + y2) / 2;
        
        double midX23 = (x2 + x3) / 2;  
        double midY23 = (y2 + y3) / 2;
        
        double midX13 = (x1 + x3) / 2;  
        double midY13 = (y1 + y3) / 2;
        
        // Top triangle
        sierpinski(n - 1, x1, midX12, midX13, y1, midY12, midY13);
        
        // Bottom left triangle
        sierpinski(n - 1, midX12, x2, midX23, midY12, y2, midY23);
        
        // Bottom right triangle
        sierpinski(n - 1, midX13, midX23, x3, midY13, midY23, y3);

		
    }
	
}
