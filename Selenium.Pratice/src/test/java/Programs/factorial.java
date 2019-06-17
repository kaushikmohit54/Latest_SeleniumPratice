package Programs;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		 
       Scanner scn = new Scanner(System.in);
            int sum = scn.nextInt();
            int c, fact=1;
            
           if(sum<0)
           {
        	   System.out.println("it's a negative number");
           }
           else
           {
        	   for(int i=1;i<=sum;i++)
        	   {
        		 fact = fact*i;
        		 
        	   }
        	   System.out.println(fact);
           }
	}

}
