/*
* Sum of Array
* Given an array of length N, you need to find and return the sum of all elements of the array.
* 
* Constraints: 1 <= N <= 10^3
* 
* Sample Input: 
* 3
* 9 8 9
* 
* Sample Output:
* 26
*/

import java.util.Scanner;
public class SumOfArray {

	public static int sum(int input[]) {
		if(input.length <= 1)
            return input[0];
        
        int[] smallInput = new int[input.length-1];
        for(int i = 1; i < input.length; i++){
            smallInput[i-1] = input[i];
        }
        
        return sum(smallInput) + input[0]; //pass it to recursion and it will do its job for smaller input
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(sum(input));
	}
}