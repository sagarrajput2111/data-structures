package stack.StackWithArrays;

import java.util.Arrays;

import stack.StackEmptyException;

public class StackUse {

	public static void main(String[] args) throws StackEmptyException {

		//the stack size will get doubled if it it reaches the maximum capacity
		
		int[] arr=new int[] {1,2,3,4,5,1,2,3,4,5,6,7,8,9,0};
		//inserting all the array element in the stack;
		Stack stack=new Stack(6);
		System.out.println(stack.isEmpty());
	
		Arrays.stream(arr).forEach(n->stack.push(n));
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
		
		
		
		
	}

}
