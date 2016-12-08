package fracCalc;
import java.util.*;

public class FracCalc {
	public static void main (String [] args){
		Scanner input=new Scanner (System.in);
		System.out.println("Please input");
		boolean stop=false;
		while (!stop){
			String question=input.nextLine();
			if(question.equals("quit"))
				stop=true;

			else if (question.indexOf('1')==-1&&question.indexOf('2')==-1&&question.indexOf('3')==-1&&question.indexOf('4')==-1&&question.indexOf('5')==-1&&
					question.indexOf('6')==-1&&question.indexOf('7')==-1&&question.indexOf('8')==-1&&question.indexOf('9')==-1&&question.indexOf('0')==-1)
				System.out.println("wrong input");
			else
				System.out.println(produceAnswer(question));
		}
	}
	public static String produceAnswer (String input){
		if (input.indexOf(' ')==-1)
			return "wrong input";
		String [] question=parseInput(input);
		//setting answer as the first operand
		int [] answer=parseOperand(question[0]);
		for(int i=1;i<question.length;i=i+2){
			//if operands don't have numbers
			if (question[i+1].indexOf('1')==-1&&question[i+1].indexOf('2')==-1&&question[i+1].indexOf('3')==-1&&question[i+1].indexOf('4')==-1&&question[i+1].indexOf('5')==-1&&
					question[i+1].indexOf('6')==-1&&question[i+1].indexOf('7')==-1&&question[i+1].indexOf('8')==-1&&question[i+1].indexOf('9')==-1&&question[i+1].indexOf('0')==-1)
				return "wrong input";
			else if (question[i].equals("+"))
				answer= addFrac(answer,parseOperand(question[i+1]));
			else if (question[i].equals("-"))
				answer=subtractFrac(answer,parseOperand(question[i+1]));
			else if (question[i].equals("*"))
				answer=multiplyFrac(answer,parseOperand(question[i+1]));
			else if (question[i].equals("/"))
				answer=divideFrac(answer,parseOperand(question[i+1]));
			else 
				return "wrong input";
		}
		return toMixed(reduceFrac(answer));//simplify answer at the end
	}
	public static String [] parseInput(String input){
		String [] answer=input.split(" "); //split into operand operator operand operator...
		return answer;
	}
	public static int []parseOperand (String operand){
		//also includes changing it to improper
		int [] easyOperand=new int [3];
		String whole="0";
		String numerator="0";
		String denominator="1";
		if (operand.indexOf('/')==-1){ //if only whole numbers
			whole=operand;
		}
		else if(operand.indexOf('_')==-1){ //if no whole numbers
			numerator=operand.substring(0,operand.indexOf('/'));
			denominator=operand.substring(operand.indexOf('/')+1,operand.length());
		}
		else {
			whole=operand.substring(0,operand.indexOf('_'));
			numerator=operand.substring(operand.indexOf('_')+1,operand.indexOf('/'));
			denominator=operand.substring(operand.indexOf('/')+1,operand.length());
		}
		//changes to improper fraction
		int wholeNum=Integer.parseInt(whole);
		int numeratorNum=Integer.parseInt(numerator);
		if(wholeNum<0)
			numeratorNum=-numeratorNum;//make the numerator negative if whole number is negative
		easyOperand[2]=0; //determining if denominator is 0 (a 0 indicates false)
		easyOperand[1]=Integer.parseInt(denominator); 
		easyOperand[0]=wholeNum*easyOperand[1]+numeratorNum; //multiply whole number by denominator and add numerator
		return easyOperand;
	}
	public static int[] addFrac (int [] operand1, int [] operand2){
		int [] answer=new int[3];
		int commonDen=operand1[1]*operand2[1]; //a*b is always a common factor of a and b
		int sumOfNumerator=operand1[0]*operand2[1]+operand2[0]*operand1[1]; //adding the numerator (multiply to make denominator the common factor)
		answer[0]=sumOfNumerator;
		answer[1]=commonDen;
		return answer;
	}
	public static int[] subtractFrac (int [] operand1, int [] operand2){
		operand2[0]=-operand2[0]; //make the second operand's numerator negative
		return addFrac(operand1, operand2);
	}
	public static int[] multiplyFrac (int [] operand1, int [] operand2){
		int [] answer=new int[3];
		int numerator=operand1[0]*operand2[0]; //multiply numerator
		int denominator=operand1[1]*operand2[1]; //multiply denominator
		answer[0]=numerator;
		answer[1]=denominator;
		return answer;
	}
	public static int[] divideFrac  (int [] operand1, int [] operand2){
		int [] answer=new int[3];
		int numerator=operand1[0]*operand2[1];//flips the second operator's numerator and denominator
		int denominator=operand1[1]*operand2[0];//flips the second operator's numerator and denominator
		answer[0]=numerator;
		answer[1]=denominator;
		return answer;
	}
	public static int [] reduceFrac(int [] evaluated){
		int[] notSimp=new int[2];
		notSimp=evaluated;
		notSimp[2]=0;
		int min;
		int max;	
		//simplifying fractions
		int number1=notSimp[0];
		int number2=notSimp[1];
		if(number2==0){
			notSimp[2]=1;
			return notSimp;
		}
		if(notSimp[0]<0)
			number1=-number1;
		if(notSimp[1]<0)
			number2=-number2;
		if(notSimp[0]<notSimp[1]){
			min=number1;
			max=number2;
		}
		else{
			min=number2;
			max=number1;
		}
		for(int i=min;i>1;i--){
			if(max%i==0&&min%i==0){
				notSimp[0]=notSimp[0]/i;
				notSimp[1]=notSimp[1]/i;
				break;
			}
		}
		return notSimp;
	}
	public static String toMixed (int [] simplified){
		int[] answer=new int[3];
		if(simplified[2]==1)
			return "Cannot divide by zero";
		if(simplified[1]<0){
			answer[0]=-simplified[0];
			answer[1]=-simplified[1];
		}
		else{
			answer[0]=simplified[0];
			answer[1]=simplified[1];
		}
		int whole=0, numerator=0, denominator=1;
		if(answer[0]%answer[1]==0||-answer[0]%answer[1]==0)
			return ""+answer[0]/answer[1];
		else if(answer[0]==0)
			return ""+0;
		//check if numerator is larger than denominator
		else if((-answer[0]<answer[1]&&answer[0]<0)||(answer[0]>0&&answer[0]<answer[1])){
			numerator=answer[0];
			denominator=answer[1];
			return numerator+"/"+denominator;
		}
		else if(answer[0]<0&&answer[1]<-answer[0]){
			denominator=answer[1];
			numerator=-answer[0]%denominator;
			whole=answer[0]/answer[1];
			return whole+"_"+numerator+"/"+denominator;
		}
		else if(answer[0]==0)
			return ""+0;
		else{
			denominator=answer[1];
			numerator=answer[0]%denominator;
			whole=answer[0]/answer[1];
			return whole+"_"+numerator+"/"+denominator;
		}
	}
}