/*
Min Steps to One

Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. 
You can perform any one of the following 3 steps:

1) Subtract 1 from it. (n = n - ­1) ,
2) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).

Input: 4
Output: 2

Explanation:
--------------------
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 

Input: 7
Output: 3

*/
import java.io.*;

public class MinStepsToOne {
	
	//Recursive solution
	private static int countMinStepsToOneRecur(int n) {
		
		if(n == 1)
			return 0;
		
		int s1 = Integer.MAX_VALUE;
		int s2 = Integer.MAX_VALUE;
		int s3 = Integer.MAX_VALUE;
		
		s1 = countMinStepsToOneRecur(n-1);
		
		if(n%2 == 0)
			s2 = countMinStepsToOneRecur(n/2);
		
		if(n%3 == 0)
			s3 = countMinStepsToOneRecur(n/3);
		
		return 1+Math.min(s1, Math.min(s2, s3));
	}
	
	//Memoize technique = Recursion + storage (Top down Approach)
	private static int countMinStepsToOneMemoize(int n) {
		
		int storage[] = new int[n+1];
		for(int i = 1; i <= n; i++)
			storage[i] = -1;
		
		return countMinStepsToOneMemoizeHelper(n, storage);
	}

	//Memoize technique helper function
	private static int countMinStepsToOneMemoizeHelper(int n, int[] storage) {
		
		if(n == 1) {
			storage[n] = 0;
			return storage[n];
		}
		
		if(storage[n] != -1)
			return storage[n];
		
		int ans = countMinStepsToOneMemoizeHelper(n-1, storage);
		
		if(n%2 == 0)
			ans = Math.min(ans, countMinStepsToOneMemoizeHelper(n/2, storage));
		
		if(n%3 == 0)
			ans = Math.min(ans, countMinStepsToOneMemoizeHelper(n/3, storage));
		
		storage[n] = 1+ans;
		return storage[n];
	}
	
	//Dp = Storage + iterative (Bottomup approach)
	private static int countMinStepsToOneDP(int n) {
		
		if(n == 1)
			return 0;
		
		int minSteps[] = new int[n+1];
		minSteps[1] = 0;
		
		for(int currStep = 2; currStep < n+1; currStep++) {
			
			int subtractOne = Integer.MAX_VALUE;
			int divideByTwo = Integer.MAX_VALUE;
			int divideByThree = Integer.MAX_VALUE;
			
			subtractOne = minSteps[currStep-1];
			
			if(currStep%2 == 0)
				divideByTwo = minSteps[currStep/2];
			
			if(currStep%3 == 0)
				divideByThree = minSteps[currStep/3];
			
			minSteps[currStep] = 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
		}
		
		return minSteps[n];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number: ");
		int n = Integer.parseInt(br.readLine().trim());
		
		System.out.println("DP solution: " + countMinStepsToOneDP(n));
		System.out.println("Memoize solution: " + countMinStepsToOneMemoize(n));
        System.out.println("Recursive solution: " + countMinStepsToOneRecur(n));
	}
}
