package Programs;

import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//System.out.println("enter the sujm value");
		int sum = scn.nextInt();
	  int f1, f2=0, f3=1;
		 for(int i=0; i<sum; i++)  
		 {
			 f1=f2;
			 f2=f3;
			 f3=f1+f2;
			 
			 System.out.println(f3);
		 }
		
	}

}
