package stack.StackWithArrays;



import stack.StackEmptyException;

public class Stack{
	private int[] data;
	private int top;
	
	public Stack() {
		top=-1;
	}
	public Stack(int size) {
		top=-1;
		data=new int[size];
		
	}
	
	
	//5 functions are their in stack
	public void push(int value)
	{
		if(top<data.length-1)
		{
			data[++top]=value;
		}
		
		else {
			
			//create a double size array and copy all the elements 
			data=increaseSize();
			data[++top]=value;
		}
		
		
	}
	
	private int[] increaseSize() {
		
		int[] newData=new int[2*data.length];
		for(int i=0;i<data.length;i++)
		{
			newData[i]=data[i];
		}
		return newData;
		
	}
	public int pop() throws StackEmptyException
	{
		if(top==-1)
			throw new StackEmptyException();
		else {
			return data[top--];
		}
		
		
	}
	
	public int size()
	{
		return top+1;
	}
	
	public boolean isEmpty()
	{
		return top==-1;
	}
	
	public int top() throws StackEmptyException
	{
		if (top==-1) {
			throw new StackEmptyException();
		}
		
		else {
			return data[top];
		}
	}

}
