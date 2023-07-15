package queue.queueWithArrays;

import queue.QueueEmptyException;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException {
		
		
		Queue queue=new Queue(4);
		System.out.println(queue.size());
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		
		queue.pop();
		queue.pop();
		queue.pop();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(1);
		queue.push(2);
		queue.push(3);
		
		
		while(!queue.isEmpty())
			System.out.println(queue.pop());

	}

}
