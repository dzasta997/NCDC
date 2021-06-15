

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Drwal {
public Drwal (int xStart,int yStart, String color, int width, int height) {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<String> input = new ArrayList<String>();
	String s;
	int start, end;
	try {
		while(true) {
			s=reader.readLine();
			if(s==null)
				break;
				
			input.add(s);
			
		}
	}catch(IOException e){
		System.out.println("klops");
	}
	String arr [] = new String [input.size()];
	arr = input.toArray(arr);
 	for(int i=0; i<arr.length; i++) {
		start = arr[i].indexOf("# ");
		end=arr[i].indexOf(" #",start);
		if(start>-1 && end>-1)
		arr[i]=arr[i].substring(0,start+1)+spaces(start,end)+arr[i].substring(end+1);
	}
 	display(arr);
}
public void display(String []arr) {
	for(int i=0; i< arr.length; i++) {
		System.out.println(arr[i]);
	}
}
public String spaces(int start, int end) {
		String s="";
		for(int i=0; i<end-start; i++) {
			s+="*";
		}
		return s;
	}
public static void main(String []args) {
	try {
		new Drwal(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),Integer.parseInt(args[4]));
	}catch (Exception e) {
		
	}
}
}

