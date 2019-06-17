package Pratice;

public class whitespace {

	public static void main(String[] args) {
		  String str = "  Core Java jsp servlets             jdbc struts hibernate spring  ";
		  
	        //1. Using replaceAll() Method
	 
	        String strWithoutSpace = str.replaceAll("\\s", "");
	 
	        System.out.println(strWithoutSpace);   

	}

}
