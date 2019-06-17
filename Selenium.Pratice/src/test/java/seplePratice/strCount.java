package seplePratice;

import java.util.HashMap;
import java.util.Map;

public class strCount {
	public static void main(String args[])
	{
	String s="Good morning";
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
	
	}

}