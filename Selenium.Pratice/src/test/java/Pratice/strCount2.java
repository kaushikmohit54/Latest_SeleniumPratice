package Pratice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class strCount2 {
	public static void main(String args[])
	
	{
		String s="Good Morning";
		Map<Character, Integer> map=new HashMap<Character,Integer>();
		
		for(int i=0; i<s.length();i++)
		{
			
			char c=s.charAt(i);
			
			if(map.containsKey(c)) {
				int cnt=map.get(c);
				map.put(c, ++cnt);
				
			}
			else
			{
				map.put(c, 1);
			}
		}
		System.out.println(map.get('o'));
		
		
		
	}
	

}


