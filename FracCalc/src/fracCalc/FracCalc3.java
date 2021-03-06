package fracCalc;
import java.util.*;

public class FracCalc3 {
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
		int [] firstOperand=parseOperand(question[0]);
		int [] secondOperand=parseOperand(question[2]);//index 1 is the operator
		if (question[1].equals("+"))
			return addFrac(firstOperand,secondOperand);
		else if (question[1].equals("-"))
			return subtractFrac(firstOperand,secondOperand);
		else if (question[1].equals("*"))
			return multiplyFrac(firstOperand,secondOperand);
		else
			return divideFrac(firstOperand,secondOperand);
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
		if(wholeNum<0)
			numeratorNum=-numeratorNum;
		easyOperand[1]=Integer.parseInt(denominator);
		easyOperand[0]=wholeNum*easyOperand[1]+numeratorNum;
		return easyOperand;
		}
	public static String addFrac (int [] operand1, int [] operand2){
		String answer="";
		int commonDen=operand1[1]*operand2[1];
		int sumOfNumerator=operand1[0]*operand2[1]+operand2[0]*operand1[1];
		answer=sumOfNumerator+"/"+commonDen;
		return answer;
	}
	public static String subtractFrac (int [] operand1, int [] operand2){
		String answer="";
		operand2[0]=-operand2[0]; //make the second operand's numerator negative
		return addFrac(operand1, operand2);
	}
	public static String multiplyFrac (int [] operand1, int [] operand2){
		String answer="";
		int numerator=operand1[0]*operand2[0];
		int denominator=operand1[1]*operand2[1];
		answer=numerator+"/"+denominator;
		return answer;
	}
	public static String divideFrac  (int [] operand1, int [] operand2){
		String answer="";
		int numerator=operand1[0]*operand2[1];//flips the second operator's numerator and denominator
		int denominator=operand1[1]*operand2[0];//flips the second operator's numerator and denominator
		answer=numerator+"/"+denominator;
		return answer;
	}
	
}
