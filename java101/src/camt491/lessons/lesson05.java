package camt491.lessons;

public class lesson05 {

	public static double var = 3;
	
	public static void main(String[] args) {
		
		localFunction(1,2);
		System.out.println("Global " + var);
	}
	
	public static int localFunction(int a, int b) {
		
		double var = 4;
		
		System.out.println("Global " + var);
		
		return 1;
	}
}
