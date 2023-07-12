package stack.stackWithLinkedList;

import stack.StackEmptyException;

public class StackLL<T> {
	
private	Node<T> top=null;
private int size=0;

public void push(T value)
{
	//going to push on head of list O(1)
	Node<T> node=new Node<>(value);
	if(top==null)
	{
		top=node;
		size++;
	}
	
	else {
		node.next=top;
		top=node;
		size++;
	}
	
}

public T pop() throws StackEmptyException
{
	if(size==0)
		throw new StackEmptyException();
	else {
		T value=top.data;
		top=top.next;
		size--;
		return value;
	}
	
}

public int size()
{
	return size;
}

public boolean isEmpty()
{
	
	return size==0;
}

public T top() throws StackEmptyException {
if(top==null)
	throw new StackEmptyException();
else 
	return top.data;
   
}
}
