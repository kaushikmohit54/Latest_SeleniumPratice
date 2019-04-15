package Programs;

public class Occuranceofletter {

	public static void main(String[] args) {
		
		
		String str = "Welcome to the javatpoint prtal";
		
		int count =0;
		
		for(int i=0;i<str.length()-1;i++)
		{
			if(str.charAt(i)=='t')
			{
				count++;
			}
			
		}
		
		System.out.println("Frequency of t is "+ count);
	}

}
