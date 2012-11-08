package test;

import java.net.*;
import java.io.*;
//import java.util.*;
import test.IMCliServer;

public class NetClient02 {
	
	public static void main(String[] args) {
	  
		
		
	try{
		
		
	final ServerSocket cliSerSoc=new ServerSocket(0);
		
	//initial a socket with host and port.
	String host= args[0];
	int port=Integer.parseInt(args[1]);
	if (args.length !=2)
		throw new IllegalArgumentException("pls enter 2 arguments,no more and no less");
	final Socket soc=new Socket(host,port);
	
	
	//create input fromServer and output toServer
	 final Reader fromServer=new InputStreamReader(soc.getInputStream());
	 final PrintWriter toServer=new PrintWriter(soc.getOutputStream());
	
	//create input fromUser and output toUser
     Reader fromUser=new InputStreamReader(System.in);//transform Byte stream into Char stream with class InputStreamReader 
	 final PrintWriter toUser=new PrintWriter(System.out,true);
	 
	 //create inObj to receive object(userPort) from IMServer
	 // ObjectInputStream inObj=new ObjectInputStream(soc.getInputStream());
	 // @SuppressWarnings("unchecked")
	 // HashMap<String,Integer> userPort=(HashMap<String,Integer>)inObj.readObject();
	    
     
	
	 
	// create another thread to handle input fromServer and send message to user
	  Thread tIn = new Thread(){
		 
		  public void run(){
			  
			  try{
				  
				  
			  char []buffer=new char[100];
			  int charRead;
			  
			  while ((charRead=fromServer.read(buffer))>0){
				 toUser.write(buffer, 0, charRead); 
			     toUser.flush();
			  }
				  
			  }
			  
			  catch(Exception e){toUser.println(e);}
			  toUser.println("timeout,connection close by server");
		  System.exit(0);
			  
			 }
		  
		  
		  
	  };
	  
	  tIn.start();//must start thread tIn before send message to server.
	 
	
	  
	
	//need a thread to launch IMCliServer and keep it running
	 
	 Thread t = new Thread(){
		  
		  public void run(){
			  
			  
				  IMCliServer.server(cliSerSoc);
					
			  
			 }
		  
		  
		  
	  };
	 
	 t.start();
	 
	 //send message(user:cliSerPort) from client to server
	   int cliSerPort=cliSerSoc.getLocalPort();
		
	    toServer.print("mike"+":"+cliSerPort);
	    toServer.flush();
	 
	  //check message from system.in and handle it accordingly 
	    char[]bufferU=new char[100];
		   int readChar;
		   
		   
		   
	 
	   
		   //send message from system.in to server;
		  
		  while((readChar=fromUser.read(bufferU))>0){
			  
			  
			 if(new String(bufferU,0,readChar).contains("contact")){
				 
				String[] tok= new String(bufferU,0,readChar).split(" ");
				System.out.println(tok[1]);
				new subClient(new Socket("localhost",Integer.parseInt(tok[1]))); 
			 }
			 else{
				 toServer.write(bufferU, 0, readChar);
				 toServer.flush();
				 
			 }
			  
			  
		  }
	   
	   
	  
	 
	 
	  
	//close socket and terminate JVM to quit
	  soc.close();
	  toUser.println("connection closed by client");
	   //System.exit(0);
	
	}catch (Exception e){System.err.println(e);
	                     System.err.println("USAGE:java NetClient02 <host> <port>");}
	
	
	}

}
