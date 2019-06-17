package Pratice;

public class revp {
	public static void main(String[] args) {
		revp.reverse();
		revp.revff();
	}
	
	public static void revff() {
		String s="abc is my name";
		 for(int i=s.length()-1;i>=0;i--)
	     {
	         System.out.print(s.charAt(i));
	     }
	
	}
	
	public static void reverse() {
		
		String str = "I use selenium webdriver. selenium is a tool for web applications.";
		//int i = str.length();
		StringBuffer strb = new StringBuffer();
		for( int i=str.length()-1; i>=0; i--){
			//System.out.println(str.charAt(i));
		strb = strb.append(str.charAt(i));
		}
		System.out.println(strb);
		}
	
}
