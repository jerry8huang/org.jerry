package test;



import java.net.*;
import java.io.*;



public class subClient  {
	
	
	    Reader fromServer;
        PrintWriter toServer;

        Reader fromUser;
        PrintWriter toUser;
	
		
	

        public subClient(Socket soc){

    

	try{
		
		
	     //create input fromServer and output toServer
		  fromServer=new InputStreamReader(soc.getInputStream());
		  toServer=new PrintWriter(soc.getOutputStream());
		
		//create input fromUser and output toUser
	          fromUser=new InputStreamReader(System.in);//transform Byte stream into Char stream with class InputStreamReader 
		  toUser=new PrintWriter(System.out,true);
		
	 
	//create another thread to handle input fromServer and send message to user
	  Thread t = new Thread(){
		  
		  public void run(){
			  
			  try{
			  char []buffer=new char[100];
			  int charRead;
			  
			  while ((charRead=fromServer.read(buffer))>0){
				 toUser.write(buffer, 0, charRead); 
			     toUser.flush();
			  }
				  
			  }
			  
			  catch(IOException e){toUser.println(e);}
			  toUser.println("timeout,connection close by server");
		  System.exit(0);
			  
			 }
		  
		  
		  
	  };
	  
	  t.start();//must start thread t before send message to server.
	 
	
	//send message from user to server
	  
	   char[]bufferU=new char[10];
	   int readint;
	  while((readint=fromUser.read(bufferU))>0){
		 
		  toServer.write(bufferU, 0, readint);
		  toServer.flush();
		  
	  }
	
	//close socket and terminate JVM to quit
	  soc.close();
	  toUser.println("connection closed by client");
	   System.exit(0);
	
	}catch (Exception e){System.err.println(e);
	                     System.err.println("USAGE:java subClient <host> <port>");}
	
	
	}

}
