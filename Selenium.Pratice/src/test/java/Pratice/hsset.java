package Pratice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class hsset  {

	public static void main(String[] args) {
		//Hase set It Removes duplicates from the set
		Set<String> set=new HashSet<String>();
		set.add("Mohit");
		set.add("Rohit");
		set.add("Sohan");
		set.add("Zafar");
		set.add("Zafar");
		set.add("Zafar");
		
		set.add("Arun");
		for(String element:set) {
			System.out.println(element);
			
		}
		spl();
		spl2();
		
		
		

	}
	public static void spl() {
		String s="cococola";
		System.out.println(Arrays.toString(s.split("o")));
		
		
	}
	public static void spl2() {
	String s = "Pankaj,New York,USA";
	String[] data = s.split(",", 3);
	System.out.println("Name = "+data[0]); //Pankaj
	System.out.println("Address = "+data[1]); //New York,USA
	System.out.println("Conuntry = "+data[2]);
	}

}
