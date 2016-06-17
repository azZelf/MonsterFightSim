package com.camt.java.labs.cupcakemaker;

import camt491.CupcakeSupport.Cupcake;

//TODO: (Lab Activity 5) Import CupcakeSupport HERE

/**
 * This is the app class for lab01. This class contains the main() method and
 * will be making cupcakes!
 */
public class App {

	public static void main(String[] args) {
	   
	   System.out.println("Let's make a cupcake!");
		
		/**
		 * TODO: (Lab Activity 4) Create a new Cupcake Here!
		 */
	   Cupcake c = new Cupcake();
		
		/**
		 * TODO: (Lab Activity 4) Create a new CupcakeMaker Here!
		 * 		 Initialize the new CupcakeMaker with your
		 * 		 plain cupcake.
		 */		
	   CupcakeMaker cm = new CupcakeMaker(c);
		 
	}

}
