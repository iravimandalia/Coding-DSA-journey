/*
* Recursion in computer science is a method where the solution to a problem depends on solutions to smaller instances of the same problem.
* 3-Step Process
* ---------------
* 1. Base Case
* 2. Hypothesis
* 3. Induction
*
* Step 2 & step 3 are interchangeable depending on the problem.
*
* With this let's get started and solve how to calculate factorial of a number using recursion.
*
* Input - 5
* Output - 120
*/

public class Factorial {
	
	public static int fact(int n) {
		if(n == 0 || n == 1) //Base case
			return 1;
		
		return n*fact(n-1); //Hypothesis - Induction
	}

	//Driver method
	public static void main(String[] args) {
		int n = 5;
		int result = fact(n);
		System.out.println("Factorial of " + n + " is " + result);
	}
}
