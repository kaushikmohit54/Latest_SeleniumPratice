package Programs;

public class RemovalOfNumfromstring {

	public static void main(String[] args) {
		 
		 String s = "All (53454)";
		       String replc = "[A-Z a-z]";
		       
		       String number = "[0-9]";
		       
		       
		       String result =  s.replaceAll(replc, "");
		       String result1 =  s.replaceAll(number, "");
		       
		     System.out.println(result);
		    // System.out.println(result1);
   
	}

}
