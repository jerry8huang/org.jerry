package framwork;

public class Entry {

	
	
public static void main(String[] args){
	 Client client=new Client();
	 Service service=new ServiceProxy(new ServiceImplement02());
	 
	 for(int i=0;i<5;i++)
	 client.request(service);
		
	}
	
	
	
}
