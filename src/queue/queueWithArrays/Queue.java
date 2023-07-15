package queue.queueWithArrays;

import queue.QueueEmptyException;

public class Queue {
	
	private int[] data;
	private int front=-1;
	private int rear=-1;
	private int size;
	
	public Queue() {
		data=new int[2];
	}
	
   public Queue(int size)
   {
	   data=new int[size];
   }
   
   public void push(int value)
   {
	   if(size==data.length)
	       data=resize();
	   
	   if(size==0)
	   {
		   front=0;
	   }
	   
	    if(size==data.length)
	       data=resize();
		  
//	     rear++;
	     rear=(rear+1)%data.length;
	     //this line is to make queue circular
//	     if(rear==data.length)
//	    	 rear=0;
	     data[rear%data.length]=value;
		 size++;
		 return;
	  
	  
	
   }
   
   public int pop() throws QueueEmptyException
   {
	   if(size==0)
		   throw new QueueEmptyException();
	
	   
	   else {
		int value=data[front];
		size--;
		if(size==0)
		{
			front=-1;
			rear=-1;
		}
//		front++;
//		//next line is to make circular queue
//		if(front==data.length)
//			front=0;
		front=(front+1)%data.length;
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
   
   public int front() throws QueueEmptyException
   {
	   if(front==-1)
		   throw new QueueEmptyException();
	   else {
		
		   return data[front];
	}
   }
   
   public int[] resize()
   {
	   int[] newData=new int[data.length*2];
	   //this will now allow to add the extra elements 
//	   for(int i=0;i<data.length;i++)
//	   {
//		   newData[i]=data[i];
//	   }
	   
	   int index=0;
	   for(int i=front;i<data.length;i++)
	   {
		   newData[index++]=data[i];
	   }
	   for(int i=0;i<=rear;i++)
	   {
		   newData[index++]=data[i];
	   }
	   front=0;
	   rear=data.length-1;
	   
	   
	   return newData;
   }
   
	

}
