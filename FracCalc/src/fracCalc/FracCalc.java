package fracCalc;
import java.util.*;

public class FracCalc {
	public static void main (String [] args){
		Scanner input=new Scanner (System.in);
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
	}
	public static String produceAnswer (String input){
		String [] question=parseInput(input);
		int [] answer=parseOperand(question[0]);
		for(int i=1;i<question.length;i=i+2){
		if (question[i].equals("+"))
			answer= addFrac(answer,parseOperand(question[i+1]));
		else if (question[i].equals("-"))
			answer=subtractFrac(answer,parseOperand(question[i+1]));
		else if (question[i].equals("*"))
			answer=multiplyFrac(answer,parseOperand(question[i+1]));
		else
			answer=divideFrac(answer,parseOperand(question[i+1]));
		}
		return simplify(answer);
	}
	public static String [] parseInput(String input){
		String [] answer=input.split(" "); 
		return answer;
		
	}
	public static int []parseOperand (String operand){
		//also toImproper
		int [] easyOperand=new int [2];
		String whole="0";
		String numerator="0";
		String denominator="1";
		if (operand.indexOf('/')==-1){
			whole=operand;
		}
		else if(operand.indexOf('_')==-1){
			numerator=operand.substring(0,operand.indexOf('/'));
			denominator=operand.substring(operand.indexOf('/')+1,operand.length());
		}
		else{
			whole=operand.substring(0,operand.indexOf('_'));
			numerator=operand.substring(operand.indexOf('_')+1,operand.indexOf('/'));
			denominator=operand.substring(operand.indexOf('/')+1,operand.length());
		}
		//changes to improper fraction
		int wholeNum=Integer.parseInt(whole);
		int numeratorNum=Integer.parseInt(numerator);
		easyOperand[1]=Integer.parseInt(denominator);
		easyOperand[0]=wholeNum*easyOperand[1]+numeratorNum;
		return easyOperand;
		}
	public static int[] addFrac (int [] operand1, int [] operand2){
		int [] answer=new int[2];
		int commonDen=operand1[1]*operand2[1];
		int sumOfNumerator=operand1[0]*operand2[1]+operand2[0]*operand1[1];
		answer[0]=sumOfNumerator;
		answer[1]=commonDen;
		return answer;
	}
	public static int[] subtractFrac (int [] operand1, int [] operand2){
		operand2[0]=-operand2[0]; //make the second operand's numerator negative
		return addFrac(operand1, operand2);
	}
	public static int[] multiplyFrac (int [] operand1, int [] operand2){
		int [] answer=new int[2];
		int numerator=operand1[0]*operand2[0];
		int denominator=operand1[1]*operand2[1];
		answer[0]=numerator;
		answer[1]=denominator;
		return answer;
	}
	public static int[] divideFrac  (int [] operand1, int [] operand2){
		int [] answer=new int[2];
		int numerator=operand1[0]*operand2[1];//flips the second operator's numerator and denominator
		int denominator=operand1[1]*operand2[0];//flips the second operator's numerator and denominator
		answer[0]=numerator;
		answer[1]=denominator;
		return answer;
	}
	public static String simplify(int [] evaluated){
		int[] notSimp=new int[2];
		notSimp=evaluated;
		String finalAnswer="";
		int whole=0;
		int numerator=notSimp[0];
		int denominator=notSimp[1];
		for(int i=numerator;i>0;i--){
			if(denominator%i==0){
				denominator=denominator/i;
				numerator=numerator/i;
			}
		}
			whole=numerator/denominator; // getting whole number by dividing numerator by denominator
			numerator=numerator-(whole*denominator);//subtracting the numerator by the whole number value
		if(numerator==0){
			finalAnswer=""+whole;
		}
		else if(whole==0){
			finalAnswer=numerator+"/"+denominator;
		}
		else
			finalAnswer=whole+"_"+numerator+"/"+denominator;
		return finalAnswer;
	}
	
}
