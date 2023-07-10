package linkedList.singlyLinkedList;

import java.util.Scanner;

public class SingleLinkedList {
	
	
	public static Node<Integer> create()
	{
		Scanner scanner =new Scanner(System.in);
		int data=scanner.nextInt();
		Node<Integer> head=null;
		Node<Integer> tail=null;
		
		while(data!=-1)
		{
			Node<Integer> node=new Node<Integer>(data);
			if(head==null)
			{
				head=node;
				tail=node;
			}
			
			tail.next=node;
			tail=tail.next;
			
			data=scanner.nextInt();			
			
		}
		
		scanner.close();
		return head;
	}
	
	public static void print(Node<Integer> head)
	{
		
		Node<Integer> temp=head;
		System.out.println();
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
		return ;
	}
	
	public static Node<Integer> add(Node<Integer> head,int  data, int pos)
	{
		//we are taking 0th position as head node;
		
		Node<Integer> node=new Node<Integer>(data);
		if(pos==0)
		{
			node.next=head;
			head=node;
			return node;
		}
		else {
			
			Node<Integer> temp=head;
			int i=0;
			while(i<pos-1&&temp!=null)
			{
				temp=temp.next;
				i++;
			}
			if(temp!=null)
			{
			Node<Integer> remiNode=temp.next;
			temp.next=node;
			node.next=remiNode;
			
			}
			else {
				return head;
			}
			
		}
		
		return head;
	}
	
	public static Node<Integer> delete(Node<Integer> head, int pos)
	{

		//here 0 pos means 1st node
		if(head==null)
			return head;
		if(pos==0)
			return head.next;
		else {
			
			Node<Integer> temp=head;
			int i=0;
			while(i<pos-1&&temp.next!=null)
			{
				temp=temp.next;
				i++;
			}
			
			if(temp.next==null)
				return head;
			else {
			    temp.next=temp.next.next;
			}
			
		}
		
		
		
		return head;
		
		
	}

	public static void main(String[] args) {
		//creating the linked list;
		//1 2 3 4 5 -1
		Node<Integer> head=create();
		print(head);
		//adding a node
		//1. adding at headnode
		head=add(head, 15, 0);
		print(head);
		//2.adding in between
		head=add(head, 44, 3);
		print(head);
		//adding at last
		head=add(head, 88, 7);
		print(head);
		//adding outside length// do not add
		head=add(head, 99, 9);
		print(head);
		
		
		//deleting a node
		//deleting the head node
		head=delete(head, 0);
		print(head);
		//deleting a mid node
		head=delete(head, 2);
		print(head);
		//deleting last node
		head=delete(head, 5);
		print(head);
		//deleting a outside index;//donot delete anything
		head=delete(head, 10);
		print(head);
		
		
		

	}

}
