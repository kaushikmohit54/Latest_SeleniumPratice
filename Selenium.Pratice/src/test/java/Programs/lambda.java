package Programs;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class lambda {

	@Test
	public void testing() {
		ArrayList<String> ar=new ArrayList<String>();
		ar.add("Mohit");
		ar.add("Mohan");
		ar.add("Rohit");
		ar.add("Sohit");
		ar.add("Lohit");
		ar.add("Mohit");
		
		Long c=ar.stream().filter(s->s.startsWith("M")).count();
		System.out.println(c);
		ar.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	    ar.stream().filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}

}
