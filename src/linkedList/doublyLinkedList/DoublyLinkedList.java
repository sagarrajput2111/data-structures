package linkedList.doublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedList{

	public static Node<Integer> create()
	{
		Scanner scanner=new Scanner(System.in);
		Node<Integer> head=null,tail=null;
		int data=scanner.nextInt();
		while(data!=-1)
		{
			Node<Integer> node=new Node<Integer>(data);
			if(head==null)
			{
				head=node;
				tail=node;
			}
			
			else {
				
				tail.next=node;
				node.prev=tail;
				tail=tail.next;
				
			}
			
			data=scanner.nextInt();
		}
	
		scanner.close();
		return head;
	}
	
	public static void print(Node<Integer> head)
	{
		
		Node<Integer> temp=head;
		System.out.println();
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> add(Node<Integer> head,int  data, int pos)
	{
		
		//pos 0 means 1st node
		Node<Integer> node=new Node<Integer>(data);
		if(head==null)
			return node;
		if(pos==0)
		{
			node.next=head;
			head.prev=node;
			head=node;
			
		}
		
		else {
			
			Node<Integer> temp=head;
			int i=0;
			while(i<pos-1&&temp!=null)
			{
				temp=temp.next;
				i++;
			}
			
			if(temp==null)
				return head;
			else {
				
				Node<Integer> newNode=temp.next;
				if(newNode!=null)
				newNode.prev=node;
				node.prev=temp;
				temp.next=node;
				node.next=newNode;
			}
		}
	
		return head;
	}
	public static Node<Integer> delete(Node<Integer> head, int pos)
	{
		
		if(head==null)
			return null;
		if(pos==0)
		{
			head=head.next;
			head.prev=null;
			return head;
			
		}
		
		
		else
		{
			int i=0;
			Node<Integer> tempNode=head;
			while(i<pos-1&&tempNode!=null)
			{
				tempNode=tempNode.next;
				i++;
				
			}
			
			if(tempNode==null||tempNode.next==null)
			{
				return head;
			}
			
			else {
				
				tempNode.next=tempNode.next.next;
				tempNode=tempNode.next;
				if(tempNode!=null)
				tempNode.prev=tempNode.prev.prev;
				return head;
				
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		//put the function in another class and make it generic

		//creating a linked list
		//1 2 3 4 5 -1
		Node<Integer> head=create();
		print(head);
		printReverse(head);
		
	//adding in the list
//		//adding at head
		head=add(head, 77, 0);
		print(head);
		printReverse(head);
		
//		//adding in mid
		head=add(head, 88, 3);
		print(head);
		printReverse(head);
//		//adding in the last
		head=add(head, 99, 7);
		print(head);
		printReverse(head);
//		//adding in out of index
		head=add(head, 109, 10);
		print(head);
		printReverse(head);
		
		System.out.println();
		System.out.println("start deleting from here");
		//deleting in the list
		//deleting the head
		head=delete(head, 0);
		print(head);
		printReverse(head);

		//deleting a mid node
		head=delete(head, 2);
		print(head);
		printReverse(head);

		//deleting last node
		head=delete(head, 5);
		print(head);
		printReverse(head);

		//deleting a outside index;//donot delete anything
		head=delete(head, 10);
		print(head);
		printReverse(head);

		
		//checking if prev node are corrected properly
		
	
		
		

		
	}
	
	public static void printReverse(Node<Integer>head)
	{
		Node<Integer> temp=head;
		while(temp.next!=null)
		{
		   temp=temp.next;
		}
		
		System.out.println();
		while(temp!=null)
		{
			System.err.print(temp.data+" ");
			temp=temp.prev;
		}
		System.out.println();
		
	}

}
