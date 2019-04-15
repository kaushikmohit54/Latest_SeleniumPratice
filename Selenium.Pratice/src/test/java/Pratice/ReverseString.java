package Pratice;

public class ReverseString {
	
	private String name;
	
	public ReverseString(String name) {
	}
	
    public ReverseString() {
	}
    

	public static void main(String[] args) {
    	/*StringBuffer buffer = new StringBuffer("Game Plan");
    	   buffer.reverse();
    	   System.out.println(buffer);*/
        String s1 = "Hello World";
        
        String[] arr = s1.split(" ");
        
        for (int i = arr.length; i  > 0; i--) {
			String string = arr[i-1];
			
			System.out.print(string);
			System.out.print(" ");
		}
        System.out.println();
        
        for(int i=s1.length()-1;i>=0;i--)
            {
                System.out.print(s1.charAt(i));
            }
        
        String name = "Mohit";
        System.out.println();
       
        char[] cr = name.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cr.length; i++) {
			if(cr[i] == 'o') {
				builder.append("a");
			}else {
				builder.append(cr[i]);
			}
			
		}
        System.out.println(builder);
        
        System.out.println(name.replace("oh", "bb"));
    }
    
    
}
