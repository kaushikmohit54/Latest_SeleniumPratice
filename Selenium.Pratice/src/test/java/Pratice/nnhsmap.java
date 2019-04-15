package Pratice;

import java.util.HashMap;
import java.util.Map.Entry;

public class nnhsmap {

	public static void main(String[] args) {
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("name", "Nsr Technology");
		map.put("subject", "Selenium");
		map.put("address", "BTM Layout");
		
		// getting the value
		for(String key:map.keySet()){
			System.out.println(map.get(key));
		}
		
		// getting the key
		for(Entry<String, String> key:map.entrySet()){
			System.out.println(key.getKey());
		}
	}

}
