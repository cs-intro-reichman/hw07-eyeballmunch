/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
        	StdDraw.line(x1, y1, x2, y2); 
       	 	return;
    	}

		// i really cant seem to get this snowflake right i dont know why 

		double x_L = x1 + (x2 - x1) / 3.0;
		double y_L = y1 + (y2 - y1) / 3.0;
		double x_R = x1 + 2.0 * (x2 - x1) / 3.0;
		double y_R = y1 + 2.0 * (y2 - y1) / 3.0;

		double commonFactor = Math.sqrt(3) / 6.0;
    	double x_Tip = commonFactor * (y1 - y2) + 0.5 * (x1 + x2);
    	double y_Tip = commonFactor * (x2 - x1) + 0.5 * (y1 + y2);

		
		curve(n - 1, x1, y1, x_L, y_L);            
		curve(n - 1, x_L, y_L, x_Tip, y_Tip);       
		curve(n - 1, x_Tip, y_Tip, x_R, y_R);       
		curve(n - 1, x_R, y_R, x2, y2);             
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		// Coordinates for an equilateral triangle base
		double x1 = 0.1, y1 = 0.3;
		double x2 = 1.0, y2 = 0.3;
		double x3 = 0.55, y3 = 0.3 + 0.45 * Math.sqrt(3);

		// Draw three curves to form the snowflake
		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
		
	}
}
