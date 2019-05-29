package seplePratice;

import org.testng.annotations.Test;

import io.inbot.testfixtures.Person;
import io.inbot.testfixtures.RandomNameGenerator;

public class randomname {
	
	
	@Test(invocationCount=50)
	public void randomname123() {
		RandomNameGenerator randomNameGenerator = new RandomNameGenerator(666);
		Person p = randomNameGenerator.nextPerson();
		System.out.println(p.getFirstName() + " " + p.getLastName() + " " + p.getCompany() + " " + p.getEmail());
		
	}

}
