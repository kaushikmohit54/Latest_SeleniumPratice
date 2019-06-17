package Programs;

public class arrayequals {

	public static void main(String[] args) {
		int a[]={3, 5, 6, 7 ,9};
		int b[]={3, 6, 6, 7 ,9};
		int flag=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==b[i]){
				flag++;
			}
			
			System.out.println(flag);
		}
		if (flag==a.length) {
			System.out.println("true");
		} else {
			System.out.println("false");

		}

	}

}
