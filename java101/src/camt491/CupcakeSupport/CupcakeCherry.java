package camt491.CupcakeSupport;

public class CupcakeCherry {
	private String description;
	
	public CupcakeCherry() {
		this.description = "\tRed Cherry";
	}
	
	public void setDescription(String d) {
		this.description = d;
	}
	
	public void displayCherry() {
		System.out.println(description);
	}

}
