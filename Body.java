package ncdc;

public class Body {
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
	}
//	public static void main(String []args) {
//		Body b = new Body("m", (float)8, (float) 2);
//		System.out.println(b.toString());
//		System.out.println(b.calculatePosition(3));
//	}
}