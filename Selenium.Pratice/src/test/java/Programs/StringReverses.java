package Programs;

import java.util.Scanner;

public class StringReverses {

	public static void main(String[] args) {
		
		String s="vyhv ygu uhi";
		/*Scanner scn = new Scanner(System.in);
		scn.nextLine();*/
		String s1 = "";
		String s2[]= s.split(" ");
	
		for(int i=s2.length-1; i>=0;i--)
		{
			s1=s1+" "+s2[i];
		}

		System.out.print(s1);
	}

}
