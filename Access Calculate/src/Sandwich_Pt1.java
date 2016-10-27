
public class Sandwich_Pt1 {


	public static void main(String[] args) {
		String test="breadmeatleetuceeadmayoketchuead";
		String answer=sandwich(test);
		System.out.println((answer));
		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" "); 
		//		it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		//		it will split at the word "really" and return an array of ["I "," like "," apples!"]

		//play around with String.split! what happens if you "I reallyreally like apples".split("really") ?


		//Your task:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		 * What if it's a fancy sandwich with multiple pieces of bread?
		 */


		//Your task pt 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		 * Again, what if it's a fancy sandwich with multiple pieces of bread?
		 */



	}
	public static String sandwich(String messedUpSandwich){
		if(messedUpSandwich.indexOf("bread")<0||messedUpSandwich.indexOf("bread")==messedUpSandwich.lastIndexOf("bread"))
			return "Not a sandwich!";
		String orderedSandwich=messedUpSandwich.substring(messedUpSandwich.indexOf("bread"), messedUpSandwich.lastIndexOf("bread"));
		String split[] =orderedSandwich.split("bread");
		String answer="";
		for(int i=1;i<split.length;i++)
					answer=answer+split[i];
		if (answer.trim().length()==0)
			return "Not a sandwich!";
		return answer;
	}

}
