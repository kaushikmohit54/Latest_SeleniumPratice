package Pratice;
public class Pattern {

	
	
    public static void main(String[] args) {
    	
    	
        int rows = 7;

        for(int i = rows; i >= 1; --i) {
            for(int j = 1; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    
    
}