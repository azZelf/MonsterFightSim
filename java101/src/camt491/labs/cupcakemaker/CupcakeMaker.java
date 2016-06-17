package camt491.labs.cupcakemaker;

import camt491.CupcakeSupport.CupcakeCherry;
import camt491.CupcakeSupport.CupcakeFrosting;
import camt491.CupcakeSupport.CupcakeSprinkles;

/*
 * TODO: (Lab Activity 5) Import CupcakeSupport here!
 */

/*
 * This is the CupcakeMaker class! This class will create all the ingredients and assemble the final cupcake.
 */
public class CupcakeMaker {
	/**
	 * The Default Constructor Does Nothing
	 */
	public CupcakeMaker() {

	}

	/**
	 * TODO: 
	 * (Lab Activity 4) Create a Constructor that takes a Cupcake as the argument
	 * 
	 * This constructor should
	 * (Lab Activity 5) Initialize new frosting and add it to the cupcake
	 * (Lab Activity 6) Initialize new Sprinkles and add it to the cupcake
	 * (Lab Activity 6) Initialize a new cherry and add it to the cupcake
	 * 
	 * (Lab Activity 4) Call cupcake.displayCupcake(); at the END of this method!
	 */
	public CupcakeMaker(camt491.CupcakeSupport.Cupcake c) {
		CupcakeFrosting cf = new CupcakeFrosting();
		CupcakeSprinkles cs = new CupcakeSprinkles();
		CupcakeCherry cc = new CupcakeCherry();
		c.add(cf);
		c.add(cc);
		c.add(cs);
		
		c.displayCupcake();
	}

}
