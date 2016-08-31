
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
			a=a*-1;
			return (a);
			}
		else{
			return a;
			}
	}
}
