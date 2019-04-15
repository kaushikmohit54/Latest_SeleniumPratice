package Programs;

public class RemovalString {

	public static void main(String[] args) {
		
		String s ="asdfsdf__3_xgvdfg456__5443_123__76";
		
		String replace = "[_]";
		
		       String result= s.replaceAll(replace, "");
		          System.out.println(result);
		          

	}

}
