package java101;



public class ThisHadAMain {
	
	
	public static void main(String[] args)
	{
		/* 
		 * Code that calculates the value for PI
		 */
		double deliciousPi = 4.0; // My starting value for pi

		// Starting value for my loop iterator in the loop
		double j = 3.0; 
		
		final float ACCURACY_THRESHOLD = 1000000000;

		// The while loop
		while(j<ACCURACY_THRESHOLD)
		{
			// Pi can be calculate with this formula
			// PI = 4 - 4/3 + 4/5 - 4/7 ...
			deliciousPi = deliciousPi - (4/j) + (4/(j+2));
			j += 4;
			//System.out.println(deliciousPi);
		}
		System.out.println("round1 " + deliciousPi);
		
		
		/* 
		 * Code that calculates the value for PI
		 */
		deliciousPi = 4.0;
		
		final double PI_CONSANT = 4.0;
		boolean toggleAddSubtractOperation = false;

		double pieIncrement = 3.0; 

		while(pieIncrement < ACCURACY_THRESHOLD)
		{
			
			
			deliciousPi = deliciousPi + (PI_CONSANT/pieIncrement);
			pieIncrement += 2;
			toggleAddSubtractOperation = !toggleAddSubtractOperation;
			
		}
		System.out.println("round2 " + deliciousPi);
		System.out.println("Value of PI: " + Math.PI);




		
		
	}

}
