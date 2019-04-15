package Pratice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class alrrlist {

	public static void main(String[] args) {
		List<String> li=new ArrayList<String>();
		li.add("Mohit");
		li.add("rohit");
		li.add("sonam");
		/*for(int i=0;i<li.size();i++) {
			String ele=li.get(i);
			System.out.println(ele);
		}
		*/
		for(Iterator<String> iter=li.iterator();iter.hasNext();) {
			
			System.out.println(iter.next());
		}
		

	}

}
