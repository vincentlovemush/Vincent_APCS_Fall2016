
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
		if (a>b){
			if (a>c){
				return a;
				}
			else if(c>b){
				return c;
				}
			}	
		else if(b>c){
			if (b>a){
				return b;
				}
			else if(a>c){
				return a;
				}
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
		int b= (int) (10*a);
		double answer;
		if(10*a-b>=.5){
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
}
