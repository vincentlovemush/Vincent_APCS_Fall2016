import java.util.*;
public class ProcessingNumbers {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("Enter amount of numbers");
		int evenMax=0;
		int n=input.nextInt();
		if(n<1)
			throw new IllegalArgumentException("Please enter a positive integar");
		System.out.println("Start entering your numbers");
		int firstNumber=input.nextInt();
		int max=firstNumber;
		int min=firstNumber;
		int evenSum=1;
		if(firstNumber%2==0){
			evenMax=firstNumber;
			evenSum=firstNumber;
		}
		for(int i=1;i<n;i++){
			int listOfNumbers=input.nextInt();
			if (listOfNumbers>max)
				max=listOfNumbers;
			if (listOfNumbers<min)
				min=listOfNumbers;
			if(listOfNumbers%2==0){
				evenSum+=listOfNumbers;
				if (listOfNumbers>evenMax)
					evenMax=listOfNumbers;
			}
		}
		if(evenSum==1){
			System.out.println("max: "+max);
			System.out.println("min: "+min);
			System.out.println("You did not enter any even numbers");
		}
		else{
					System.out.println("max: "+max);
		System.out.println("min: "+min);
		System.out.println("sum of even numbers: "+evenSum);
		System.out.println("max of even numbers: "+evenMax);
		}

	}

}
