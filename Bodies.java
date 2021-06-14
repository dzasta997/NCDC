package ncdc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Bodies {
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
//public static void main(String [] args) {
//	Bodies bodies = new Bodies();
//	bodies.add(new Body("Mars",0,0));
//	bodies.add(new Body("Venus",4,1));
//	bodies.add(new Body("Sun",24,2));
//	//Bodies boo = bodies.countBodies(75);
//	//bodies.countBodies(3);
//	System.out.print(bodies.countBodies(75).toString());
//}
}
