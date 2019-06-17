package Programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFromFileLinebyLine {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("C:\\Users\\asutosh.m\\Desktop\\javareading.txt");
		BufferedReader br = new BufferedReader(fr);
		StringBuffer str = new StringBuffer();
		try {
		while (br.readLine()!= null){
		str.append(br.readLine());
		}
		} catch (IOException e) {
		e.printStackTrace();
		}
		System.out.println(str);

	}

}
