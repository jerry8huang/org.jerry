package framwork;



/* following implement the application
 * @Client to send request to server
 * @Service interface to define what service to be provided
 * @ServiceImplement implements the service
 * */


public class Client {
	
	
	public void request(Service service){
		
		service.sayHello();
	}

}


///////////////////////////////////////

interface Service{
	
	public void sayHello();
			
	
}

///////////////////////////////////////

class ServiceImplement implements Service{
	
	public void sayHello(){
		
		System.out.println("Hello World!");
	}
	
}


class ServiceImplement02 implements Service{
	
	public void sayHello(){
		
		System.out.println("fuck World!");
	}
	
}
//////////////////////////////////////////////////////////
//following will connect application to the framework

//this one wrap class that implements interface Service
class SayHello implements MethodRequest{
	
	private Service service;
	
	SayHello(Service s){
		service=s;
	}
	
	public void call(){
		
		service.sayHello();
	}
}


//this one make framework transparent to Client 
class ServiceProxy implements Service{
	
	private ActiveObject aObject;
	private Service service;
	
	ServiceProxy(Service service){
	   aObject=new ActiveObject();
	   this.service=service;
		
	}
	
	public void sayHello(){
		
		MethodRequest mr=new SayHello(service);
		aObject.enqueue(mr);
		
	}
}
