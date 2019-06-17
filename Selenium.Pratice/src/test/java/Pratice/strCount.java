package Pratice;

import java.util.HashMap;
import java.util.Map;

public class strCount {
	public static void main(String args[])
	{
	String s="Hello World";
	Map<Character,Integer> map = new HashMap<Character,Integer>();
	for (int i = 0; i < s.length(); i++) {
	  char c = s.charAt(i);
	  if (map.containsKey(c)) {
	    int cnt = map.get(c);
	    map.put(c, ++cnt);
	  } else {
	    map.put(c, 1);
	  }
	 
	
	}
	
	 for ( Character key : map.keySet()){
         System.out.println("Character : '"+key+"' Count :"+map.get(key));
     } 
	 
	 String s1=s.toLowerCase();
	 System.out.println(s1);
	 int index=s.indexOf('m');
	 System.out.println(index);
	 
	 System.out.println(s.replaceFirst("el", "mm"));
	 System.out.println(s.concat("mohit"));
	 
	
	
	
	 
	
	
	
	}

}
