package ncdc;
import ncdc.Body;
import ncdc.Bodies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
			System.out.println("klops");
		}
		Bodies b =bodies.countBodies(day);
		if(b.center==null) {
			System.out.print("klops");
		}
		else {
			System.out.print(b.toString());
		}
		 
	}
public static void main ( String [] args) 	throws IOException{

    
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name = reader.readLine();
 
        // Printing the read line
        System.out.println(name);
    
	new DeRevolutionbus(Double.parseDouble(name));
}
}
