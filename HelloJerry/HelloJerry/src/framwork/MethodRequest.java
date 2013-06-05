package framwork;

import java.util.*;
import java.lang.Thread;



/*
 * create MethodRequest to provide interface for application 
 * ActiveQueue to enqueue and dequeue request MethodRequest
 * ActiveObject to accept request from client and return service with another thread.
 * 
 */


public interface MethodRequest {
	
	public void call();

}


//////////////////////////////////////////////
class ActiveQueue{
	
	private Stack<MethodRequest> queue;
	private final int QUEUESIZE=10;
	
	ActiveQueue(){
		
		queue=new Stack<MethodRequest>();
		
	}
	
	//check if the queue is full, if yes block it with wait();
	//if no, put MethodRequest into it.
	public synchronized void  enqueue(MethodRequest mr){//"synchronized" is required, as dequeue would be accessed by multi-threads at the same time
		try{
			if (queue.size()>QUEUESIZE)
				wait();
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		queue.push(mr);
		notifyAll();//notify all threads waiting for getting MethodRequest from queue
		
	}
	
	
	//check if queue is empty, if yes wait until there is MethodRequest put into it,
	//if no, just return MethodRequest
	
	public synchronized MethodRequest dequeue(){//"synchronized" is required, as dequeue would be accessed by multi-threads at the same time
		
		try{
		   if(queue.isEmpty())	
			wait();
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		MethodRequest mr=queue.pop();
		notifyAll();
		
		return mr;
		
	}
	
	
}

////////////////////////////////////////////////////////////
class ActiveObject extends Thread{
	
	private ActiveQueue queue;
	
	ActiveObject(){
		
		queue=new ActiveQueue();
		start();
	}
	
	public void enqueue(MethodRequest mr){
		
		queue.enqueue(mr);
		
	}
	
//keep running to return service with call(), once request coming from queue
	public void run(){
		while(true){
			
			MethodRequest mr=queue.dequeue();
			mr.call();
						
		}
		
	}
	
}









