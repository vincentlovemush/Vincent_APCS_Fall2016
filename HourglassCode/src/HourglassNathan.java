import java.util.*;
public class HourglassNathan {
	public static void main(String[] args){
		Scanner Input=new Scanner(System.in);
		System.out.println("How big do you want your hourglass(integar value)?");
		int size=Input.nextInt();
		specialLine(2*size);
		for(int i=-size+1;i<=size-1;i++){
			int positive=i;if (i<0)positive=-i;
			for(int j=size-positive-1;j>=0;j--)
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
		specialLine(2*size);
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