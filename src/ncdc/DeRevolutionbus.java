package ncdc;
import ncdc.Body;
import ncdc.Bodies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeRevolutionbus {
	DeRevolutionbus(double day){
		Bodies bodies = new Bodies();
		String input;
		try {
			Scanner scan = new Scanner(new File("plik.txt"));
			while(scan.hasNext()) {
			input = scan.next();
			String []word = input.split(",");
			bodies.add(new Body(word[0],Double.parseDouble(word[1]),Double.parseDouble(word[2])));
			}	
			scan.close();
		
		}catch(FileNotFoundException e){
			
		}
		System.out.print(bodies.countBodies(day).toString()); 
	}
public static void main ( String [] args) {
	new DeRevolutionbus(75);
}
}
