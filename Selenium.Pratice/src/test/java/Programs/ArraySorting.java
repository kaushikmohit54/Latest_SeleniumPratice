package Programs;

import java.util.Arrays;

public class ArraySorting {

	
			
		public static void main(String[] args) {

			int[] a = { 3, 4, 7, 2, 1 };
			
			 for (int i = 0; i < a.length; i++) { 
				 
				 for (int j = i + 1; j < a.length ; j++) 
			         { 
					 if (a[i] < a[j]) 
					 { 
						 int temp = a[j]; 
						 a[j] = a[i]; 
						 a[i] =temp; 
						 } 
					 } 
				 }		
			/*	Arrays.sort(a);
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}*/
	      System.out.println(Arrays.toString(a));
		}
		
		

	}


