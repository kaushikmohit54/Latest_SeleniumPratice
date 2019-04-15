package Pratice;

import java.io.FileNotFoundException;

public class program {
	public static void main( String[] args ) throws FileNotFoundException {
		for( int i=1; i<=5; i++ ){
		for( int j=1; j<=i; j++ ){
			
		System.out.print ( j );
		}
		System.out.println (); //to print new line for each iteration of outer loop
		}
		}

}
