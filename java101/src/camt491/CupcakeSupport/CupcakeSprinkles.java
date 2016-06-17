package camt491.CupcakeSupport;

public class CupcakeSprinkles {
	private String description;
	
	public CupcakeSprinkles() {
		this.description = "\tRainbow Sprinkles";
	}
	
	public void setDescription(String d) {
		this.description = d;
	}
	
	public void displaySprinkles() {
		System.out.println(description);
	}

}
