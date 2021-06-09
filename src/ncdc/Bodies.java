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
	
	
	return table.toString();
}
public Bodies() {
	this.table = new TreeMap<Double,Body>() ;
}
public SortedMap<Double,Body> countBodies(double day) {
	Bodies res = new Bodies();
	res.add(this.center);
	for(Map.Entry<Double,Body> body:table.entrySet()) {
		Body b = table.get(body.getKey());
		b.position = b.calculatePosition(day);
		res.add(b);
	}
	return res.table;
}
public static void main(String [] args) {
	Bodies bodies = new Bodies();
	bodies.add(new Body("Mars",0,0));
	bodies.add(new Body("Venus",4,1));
	bodies.add(new Body("Sun",24,2));

	//bodies.countBodies(3);
	System.out.print(bodies.countBodies(75).toString());
}
}
