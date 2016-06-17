package camt491.CupcakeSupport;

public class Cupcake {
	
	private CupcakeFrosting frosting;
	private CupcakeSprinkles sprinkles;
	private CupcakeCherry cherry;
	
	public Cupcake() {
		
		this.frosting = null;
		this.sprinkles = null;
		this.cherry = null;
	}
	
	public void add(CupcakeFrosting f) {
		this.frosting = f;
	}
	
	public void add(CupcakeSprinkles s) {
		this.sprinkles = s;
	}
	
	public void add(CupcakeCherry c) {
		this.cherry = c;
	}
	
	public void displayCupcake() {
		System.out.println("**Start display Cupcake**");
		if (frosting != null) {
			frosting.displayFrosting();
		}
		else {
			System.out.println("\tNo Frosting");
		}
		
		if(sprinkles != null) {
			sprinkles.displaySprinkles();
		}
		else {
			System.out.println("\tNo Sprinkles");
		}
		
		if(cherry != null) {
			cherry.displayCherry();
		}
		else {
			System.out.println("\tNo Cherry");
		}
			
		System.out.println("**End display Cupcake**");
	}

}
