
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Drwal {
	Field [][] arr;
	int xStart,yStart,height,width;
	String color;
public Drwal (int xStart,int yStart, String color, int width, int height) {
	this.arr = new Field [height][width];
	this.xStart=xStart;
	this.yStart=yStart;
	this.color=color;
	this.height = height;
	this.width = width;
	String s;
	fillSpaces();
	int counter=0;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
		while(true) {
			s=reader.readLine();
			if(s==null)
				break;
			for(int i=0; i<s.length() && i<arr[i].length; i++) {
				arr[counter][i]=new Field(Character.toString(s.charAt(i)));
				
			}

			counter++;
		}}catch(IOException e) {
			System.out.println("klops");
		}

	

if(arr[yStart-1][xStart-1].taken==false) {
	fill(xStart-1,yStart-1);
	 display();
}else {
	System.out.println("klops");
}
 }
public void fillSpaces() {
	for(int i=0; i< arr.length; i++) {
		Arrays.fill(arr[i], new Field(" "));
		
	}
}
public void display() {
	for(int i=0; i< arr.length; i++) {
		for(int j=0; j<arr[i].length; j++) {
			System.out.print(arr[i][j].value);
		}
		System.out.print("\n");
		
	}
}
private class Field {
	String value;
	boolean taken;
	Field(String value){
		this.value=value;
		if(value.equals(" "))
			taken=false;
		else
			taken=true;
	}
	public void take() {
		this.value=color;
		this.taken=true;
	}
	public boolean isTaken() {
		return taken;
	}
}
public void fill (int x,int y) {
	arr[y][x].take();
	
	if(arr[y+1][x].taken==false)
		fill(x,y+1);
	if(arr[y-1][x].taken==false)
		fill(x,y-1);
	if(arr[y][x+1].taken==false)
		fill(x+1,y);
	if(arr[y][x-1].taken==false)
		fill(x-1,y);
	
}
public static void main(String []args) {

	try {
		new Drwal(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),Integer.parseInt(args[4]));
	}catch (Exception e) {
		System.out.println("klops");
	}
	
}
}
