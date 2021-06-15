


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class DeRevolutionibus {
	private class Body {
		String name;
		
		double positionX,positionY, period,radius;
		public Body(String name, double radius,double period) {
			
			this.name = name;
			this.period =(double) Math.round(100*period)/100;
			this.radius = (double) Math.round(100*radius)/100;
			this.positionX = (double)Math.round(Math.cos(Math.PI)*radius*100)/100;
			this.positionY=(double)0;
		}
		public String toString() {
			
			return this.name+" "+this.radius+this.positionX;
		}
		public void calculatePosition(double day) {
			this.positionX = (double) Math.round(Math.cos(Math.PI+Math.PI*2*day/period)*radius*100)/100;
			this.positionY = (double) Math.round(Math.sin(Math.PI+Math.PI*2*day/period)*radius*100)/100;
		}
		public boolean equals(Body other) {
			if(this.radius-other.radius<0.01)
				return true;
			else
				return false;
		}}
	private class Bodies {
		//LinkedList <Body> table;
		SortedMap <Double,Body> table;	
		Body center;
		public boolean add(Body body) {
			if(body ==null) {
				return false;
			}
			if((int)body.radius==0 && center == null) {
				center = body;
			}
			if(!table.containsKey(body.positionX)) {
				table.put(body.positionX, body);
			}
			if(table.containsKey(body.positionX) && table.get(body.positionX).positionY< body.positionY) {
				table.remove(body.positionX);
				table.put(body.positionX, body);
			}
			return true;
		}
		public String toString() {
			String str = "";
			for(Map.Entry<Double,Body> body:table.entrySet()) {
				str+=table.get(body.getKey()).name+", ";
			}
			if(str.length()>2)
			return str.substring(0, str.length()-2);
			else return "";
		}
		public Bodies() {
			this.table = new TreeMap<Double,Body>() ;
		}
		public Bodies  countBodies(double day) {
			if(this.table==null) {
				return null;
			}
			Bodies res = new Bodies();
			res.add(this.center);
			
			for(Map.Entry<Double,Body> body:table.entrySet()) {
				Body b = table.get(body.getKey());
				b.calculatePosition(day);
				
				res.add(b);
			}
			
			return res;
		}
	}
	DeRevolutionibus(double day){
		Bodies bodies = new Bodies();
		String input;
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		try {
			
			while(true) {
			input = reader.readLine();
			
			if(input==null)
				break;
			
			String []word = input.split(",");
			bodies.add(new Body(word[0],Double.parseDouble(word[1]),Double.parseDouble(word[2])));
			}	

		
		}catch(IOException e){
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

    
//        // Enter data using BufferReader
//        BufferedReader reader = new BufferedReader(
//            new InputStreamReader(System.in));
// 
//        // Reading data using readLine
//        String name = reader.readLine();
// 
//        // Printing the read line
//        System.out.println(name);
    
	new DeRevolutionibus(Double.parseDouble(args[0]));
}
}
