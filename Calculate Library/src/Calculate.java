public class Calculate {
	public static int square(int number){
		return (number*number);
	}
	public static int cube(int number){
		return (number*number*number);
	}
	public static double average(double num1, double num2){
		return ((num1+num2)/2);
	}
	public static double average(double num1, double num2, double num3){
		return((num1+num2+num3)/3);
	}
	public static double toDegrees(double number){
		return((number*180/3.14159));
	}
	public static double toRadians(double number){
		return(number/180*3.14159);
	}
	public static double discriminant(double a,double b,double c){
		return(b*b-4*a*c);
	}
	public static int discriminant(int a,int b,int c){
		return(b*b-4*a*c);
	}
	public static String toImproperFrac(int a, int b, int c){
		int topnumber=a*c+b;
		String answer=(topnumber + "/" + c);
		return (answer);
	}
	public static String toMixedNum(int a, int b){
		int number=a/b;
		int numerator=a % b;
		String answer=(number + "_" +numerator+ "/" + b);
		return (answer);
	}
	public static String foil(int a, int b, int c, int d, String var){
		String answer=(a*c+var+"^2+"+(a*d+b*c)+var+"+"+(b*d));
		return answer;
	}
	public static boolean isDivisibleBy(int a, int b){
		if(b==0)
			throw new IllegalArgumentException("Divisor can't be 0!!!");
		if (a%b==0)
			return true;
		else
			return false;
	}
	public static double absValue(double a){
		if (a<0){
			return (-a);
			}
		else{
			return a;
			}
	}
	public static int max(int a, int b){
		if (a>b){
			return a;
		}
		else{
			return b;
		}
	}
	public static double max(double a, double b, double c){
			if (a>c&&a>b){
				return a;
				}
		else if(b>c&&b>a){
				return b;
			}
		else{
			return c;
		}
	}
	public static int min(int a, int b){
		if(a>b)
			return b;
		else
			return a;
	}
	public static double round2(double a){
		int b= (int) (100*a);
		double answer;
		if(100*a-b>=.5){
			answer= (int) (100*a+1);
			answer=answer/100;
			return answer;
			}
		else{
			answer= (int) (100*a);
			answer=answer/100;
			return answer;
			}
	}
	public static double exponent(double num, int power){
		if (power<0)
			throw new IllegalArgumentException("Sorry, my algorithm can't do negative powers");
		double answer=num;
		for(int i=0;i<power;i++){
			answer=answer*num;
			}
		return answer;
	}
	public static int factorial(int num){
		if(num<0)
			throw new IllegalArgumentException("No negative numbers for factorials!!");
		int answer=1;
		for(int i=num;i>0;i--){
			answer=answer*i;
		}
		return answer;
	}
	public static boolean prime(int num){
		for(int i=num-1;i>1;i--){
			if (isDivisibleBy(i,num)==true)
				return false;
		}
		return true;
	}
	public static int gcf(int a, int b){
		int answer=1;
		if(a<0)
			a=-a;
		if(b<0)
			b=-b;
		if (a==0)
			return b;
		if (b==0)
			return a;
		for (int i=min(a,b);i>=0;i--){
			if(isDivisibleBy(a,i)==true&&isDivisibleBy(b,i)){
				answer=i;
				return answer;
			}
		}
		return answer;
	}
	public static double sqrt(double number){
		if (number<0)
			throw new IllegalArgumentException("Can't square root a negative number!!");
		double decimal=0.00000000000001;
		double estimate=number;
		double low=0;
		double high=number+1;
		while(absValue(estimate*estimate-number)>decimal){
			estimate=(low+high)/2;
			if(estimate*estimate>number)
				high=estimate;
			else
				low=estimate;
		}
		return estimate;	
	}
	public static String quadForm(int a, int b, int c){
		double answer;
		double answer2;
		double squareroot;
		if(discriminant(a,b,c)<0)
			return ("no real roots");
		else if(discriminant(a,b,c)==0){
			squareroot=sqrt((double) (discriminant(a,b,c)));
			answer=round2((-b)/(2*a));
			return answer+" ";
		}
		else{
			squareroot=sqrt((double) (discriminant(a,b,c)));
			answer=round2((-b+squareroot)/(2*a));
			answer2=round2((-b-squareroot)/(2*a));
			return answer+" and "+answer2;
		}
		
	}
	
}
