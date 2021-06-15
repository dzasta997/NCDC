



import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Uproszczenia {
	
String [][]arr;
int size, path=0;
public Uproszczenia(int s, String direction) {

size=s;

switch (direction) {
case "E":
	arr =new String [s+3][s+2];
	fill();
	east();
	break;
case "W":
	arr =new String [s+3][s+2];
	fill();
	west();
	break;
case "N":
	arr =new String [s+2][s+3];
	fill();
	north();
	break;
case "S":
	arr =new String [s+2][s+3];
	fill();
	south();
	break;
	}
display();
System.out.println(path);
}

public void fill() {
	
	for(int i=0; i<arr.length; i++) {
		Arrays.fill(arr[i], "*");
	}
	
}
public void west() {
	int counter = size;
	int i=1, j=0,k;
	while(counter>=0) {
		for( k=j; k<=j+counter; k++) {
			arr[i][k]=" ";
			path++;
		}
		j=j+counter;
		i++;
		counter--;
		for( k=i; k<=i+counter ; k++) {
			arr[k][j]=" ";
			path++;

		}
		i=i+counter;
		counter--;
		j--;
		for( k=j; k>=j-counter; k--) {
			arr[i][k]=" ";
			path++;

			
		}
		j=j-counter;
		i--;
		counter--;

		for( k=i; k>=i-counter;k--) {
			arr[k][j]=" ";
			path++;
			
		}
		i=i-counter;
		counter--;
		j++;
	}
}
public void north() {
	int counter = size;
	int i=0, j=arr[0].length-2,k;
	while(counter>=0) {
		
		for( k=i; k<=i+counter ; k++) {
			arr[k][j]=" ";
			path++;

		}
		i=i+counter;
		counter--;
		j--;
		for( k=j; k>=j-counter; k--) {
			arr[i][k]=" ";
			path++;

			
		}
		j=j-counter;
		i--;
		counter--;
		for( k=i; k>=i-counter;k--) {
			arr[k][j]=" ";
			path++;

			
		}
		i=i-counter;
		counter--;
		j++;
		for( k=j; k<=j+counter; k++) {
			arr[i][k]=" ";
			path++;

		}
		j=j+counter;
		i++;
		counter--;
	}
	
}
public void south() {
	int counter = size;
	int i=arr.length-1, j=1,k;
	while(counter>=0) {
		
		for( k=i; k>=i-counter;k--) {
			arr[k][j]=" ";
			path++;
			
		}
		i=i-counter;
		counter--;
		j++;
		for( k=j; k<=j+counter; k++) {
			arr[i][k]=" ";
			path++;
		}
		j=j+counter;
		i++;
		counter--;

		for( k=i; k<=i+counter ; k++) {
			arr[k][j]=" ";
			path++;
		}
		i=i+counter;
		counter--;
		j--;
		for( k=j; k>=j-counter; k--) {
			arr[i][k]=" ";
			path++;
			
		}
		j=j-counter;
		i--;
		counter--;
		}
		
	}
	public void east() {
		int counter = size;
		int i=arr.length-2, j=arr[0].length-1,k;
		while(counter>=0) {
		
			for( k=j; k>=j-counter; k--) {
				arr[i][k]=" ";
				path++;
				
			}
			j=j-counter;
			i--;
			counter--;
			
			for( k=i; k>=i-counter;k--) {
				arr[k][j]=" ";
				path++;
				
			}
			i=i-counter;
			counter--;
			j++;
			for( k=j; k<=j+counter; k++) {
				arr[i][k]=" ";
				path++;
			}
			j=j+counter;
			i++;
			counter--;

			for( k=i; k<=i+counter ; k++) {
				arr[k][j]=" ";
				path++;
			}
			i=i+counter;
			counter--;
			j--;
		}
	}

public void display() {
	for(int i=0; i<arr.length; i++) {
		for(int j=0; j<arr[i].length; j++) {
			System.out.print(arr[i][j]);
		}
		System.out.print("\n");
}
	System.out.print("\n");
}
public static void main(String []args) throws Exception {
	
	
	try{
		int val = Integer.parseInt(args[0].substring(0,args[0].length()-1));
		String direction = args[0].substring(args[0].length()-1);
		if(!Character.isUpperCase(direction.charAt(0))) {
			direction = null;
		}else if(val>10000) {
			val =(Integer) null;
		}
		Uproszczenia up =new Uproszczenia(val,direction);
	}
	catch(Exception e) {
		System.out.println("klops");
	}
	
}
}

