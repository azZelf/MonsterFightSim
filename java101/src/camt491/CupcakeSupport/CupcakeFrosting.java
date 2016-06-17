package camt491.CupcakeSupport;

public class CupcakeFrosting {
	private String description;
	
	public CupcakeFrosting() {
		this.description = "\tVanilla Frosting";
	}
	
	public void setDescription(String d) {
		this.description = d;
	}
	
	public void displayFrosting() {
		System.out.println(description);
	}

}
