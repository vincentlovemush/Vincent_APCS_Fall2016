package fracCalc;
import java.util.*;
public class FracCalc {

	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Please input");
		boolean stop=false;
		while (!stop){
			String question=input.nextLine();
			if(question.equals("quit")){
				stop=true;
			}
			else
				System.out.println(produceAnswer(question));
		}

		// TODO: Read the input from the user and call produceAnswer with an equation

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	//      e.g. input ==> "1/2 + 3/4"
	//        
	// The function should return the result of the fraction after it has been calculated
	//      e.g. return ==> "1_1/4"
	public static String produceAnswer(String input)
	{ 
		/*
		String answer="";
		String temp="";
		if(input.indexOf("+")!=-1){
			answer=input.substring(input.indexOf("+")+1);
		}
		else if(input.indexOf("-")!=-1){
			answer=input.substring(input.indexOf("-")+1);
		}
		else if(input.indexOf("*")!=-1){
			answer=input.substring(input.indexOf("*")+1);
		}
		else{
			temp=input.substring(input.indexOf("/")+1);
			answer=temp.substring(temp.indexOf("/")+1);
		}
		return answer;
		 */
		String answer="";
		answer=input.substring(input.lastIndexOf(" ")+1);
		String whole="0";
		String numerator="0";
		String denominator="1";
		if (answer.indexOf('/')!=-1){
			numerator=answer.substring(answer.indexOf('_'),answer.indexOf('/') );
			denominator=answer.substring(answer.indexOf('/')+1);
		}
		if(answer.indexOf('_')!=-1)
			whole=answer.substring(0,input.indexOf('_'));
		else if(answer.indexOf('/')==-1)
			whole=answer.substring(0);
		answer="whole:"+numerator+" numerator:"+numerator+" denominator:"+denominator;
		return answer;
		

		// TODO: Implement this function to produce the solution to the input
	}

	// TODO: Fill in the space below with any helper methods that you think you will need

}