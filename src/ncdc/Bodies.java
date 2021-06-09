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
public void add(Body body) {
	if((int)body.radius==0 && center == null) {
		center = body;
	}
	if(!table.containsKey(body.position)) {
		table.put(body.position, body);
	}
}
public String toString() {
	String str = "";
	for(Map.Entry<Double,Body> body:table.entrySet()) {
		str+=table.get(body.getKey()).name+", ";
	}
	return str;
}
public Bodies() {
	this.table = new TreeMap<Double,Body>() ;
}
public Bodies  countBodies(double day) {
	Bodies res = new Bodies();
	res.add(this.center);
	for(Map.Entry<Double,Body> body:table.entrySet()) {
		Body b = table.get(body.getKey());
		b.position = b.calculatePosition(day);
		res.add(b);
	}
	return res;
}
public static void main(String [] args) {
	Bodies bodies = new Bodies();
	bodies.add(new Body("Mars",0,0));
	bodies.add(new Body("Venus",4,1));
	bodies.add(new Body("Sun",24,2));
	Bodies boo = bodies.countBodies(75);
	//bodies.countBodies(3);
	System.out.print(boo.toString());
}
}
