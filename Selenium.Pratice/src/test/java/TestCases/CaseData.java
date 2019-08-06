package TestCases;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.person.PersonProperties;

public class CaseData {
	
	public static void main(String[] args) {

		Fairy fairy = Fairy.create();
		Person person = fairy.person();

		System.out.println(person.getFirstName());            
		// Chloe Barker
		System.out.println(person.getEmail());               
		// barker@yahoo.com
		System.out.println(person.getTelephoneNumber());     
		// 690-950-802

		Person adultMale = fairy.person(PersonProperties.male(), PersonProperties.minAge(21));
		System.out.println(adultMale.isMale());           
		// true
		   
		// at least 21 years earlier
	
		
		
	}
   
	

}

