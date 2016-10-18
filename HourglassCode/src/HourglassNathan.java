import java.util.*;
public class HourglassNathan {
	public static void main(String[] args){
		Scanner size=new Scanner(System.in);
		System.out.println("Please input numbers greater than 0");
		int x=size.nextInt();
		specialLine(2*x);
		for(int i=-x+1;i<=x-1;i++){
			int positive=i;
			if (i<0)
				positive=-i;
			for(int j=4-positive;j>=0;j--)
				System.out.print(" ");
			if(i<0){
				System.out.print("\\");
				colons(positive);
				System.out.println("/");
			}
			else if(i>0){
				System.out.print("/");
				colons(positive);
				System.out.println("\\");
			}
			else
				System.out.println("||");
		}
		specialLine(2*x);
	}
	public static void specialLine(int number){
		System.out.print("|");
		for(int i=1;i<=number;i++)
			System.out.print("\"");
		System.out.println("|");
	}
	public static void colons(int number){
		for(int i=number;i>0;i--)
			System.out.print("::");
	}
}

