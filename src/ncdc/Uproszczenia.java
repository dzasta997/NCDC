package ncdc;

import java.util.Arrays;
import java.util.Scanner;

public class Uproszczenia {
	
String [][]arr;
int size;
public Uproszczenia(int s, String direction) {

size=s;

switch (direction) {
case "e":
	arr =new String [s+3][s+2];
	fill();
	east();
case "w":
	arr =new String [s+3][s+2];
	fill();
	west();
case "n":
	arr =new String [s+2][s+3];
	fill();
	north();
case "s":
	arr =new String [s+2][s+3];
	fill();
	south();
	}
display();
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
		}
		j=j+counter;
		i++;
		counter--;
		for( k=i; k<=i+counter ; k++) {
			arr[k][j]=" ";

		}
		i=i+counter;
		counter--;
		j--;
		for( k=j; k>=j-counter; k--) {
			arr[i][k]=" ";

			
		}
		j=j-counter;
		i--;
		counter--;

		for( k=i; k>=i-counter;k--) {
			arr[k][j]=" ";
			display();
			
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

		}
		i=i+counter;
		counter--;
		j--;
		for( k=j; k>=j-counter; k--) {
			arr[i][k]=" ";

			
		}
		j=j-counter;
		i--;
		counter--;
		display();
		for( k=i; k>=i-counter;k--) {
			arr[k][j]=" ";

			
		}
		i=i-counter;
		counter--;
		j++;
		for( k=j; k<=j+counter; k++) {
			arr[i][k]=" ";

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

			
		}
		i=i-counter;
		counter--;
		j++;
		for( k=j; k<=j+counter; k++) {
			arr[i][k]=" ";

		}
		j=j+counter;
		i++;
		counter--;

		for( k=i; k<=i+counter ; k++) {
			arr[k][j]=" ";

		}
		i=i+counter;
		counter--;
		j--;
		for( k=j; k>=j-counter; k--) {
			arr[i][k]=" ";

			
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

				
			}
			j=j-counter;
			i--;
			counter--;
			
			for( k=i; k>=i-counter;k--) {
				arr[k][j]=" ";

				
			}
			i=i-counter;
			counter--;
			j++;
			for( k=j; k<=j+counter; k++) {
				arr[i][k]=" ";

			}
			j=j+counter;
			i++;
			counter--;

			for( k=i; k<=i+counter ; k++) {
				arr[k][j]=" ";

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
public static void main(String []args) {
	Scanner scan  = new Scanner(System.in);
	String s = scan.next();
	scan.close();
	int val = Integer.parseInt(s.substring(0,1));
	String direction = s.substring(1,2);
	Uproszczenia up =new Uproszczenia(val,direction);
	
}
}
