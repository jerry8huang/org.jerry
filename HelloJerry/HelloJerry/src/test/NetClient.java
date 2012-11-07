package test;

import java.net.*;
import java.io.*;
import java.util.*;
import test.IMCliServer;

public class NetClient {
	
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
	  ObjectInputStream inObj=new ObjectInputStream(soc.getInputStream());
	  @SuppressWarnings("unchecked")
	  HashMap<String,Integer> userPort=(HashMap<String,Integer>)inObj.readObject();
	    
     
	
	 
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
	  
	  tIn.start();//must start thread t before send message to server.
	 
	
	  
	
	//send message(user:cliSerPort) from client to server
	 
	 Thread t = new Thread(){
		  
		  public void run(){
			  
			  
				  IMCliServer.server(cliSerSoc);
					
			  
			 }
		  
		  
		  
	  };
	 
	 t.start();
	 
	 
	   int cliSerPort=cliSerSoc.getLocalPort();
		
	    toServer.print("jerry"+":"+cliSerPort);
	    toServer.flush();
	 
	  //check message from system.in and handle it accordingly 
	    char[]bufferU=new char[100];
		   int readChar=fromUser.read(bufferU);
		   String temp=new String(bufferU,0,readChar);
		   
		   
	   if(temp.contains("contact")){//if message contain "contact" create socket to related client 
		  String []userName=temp.split(" "); 
		  Socket talkSoc=new Socket(InetAddress.getLocalHost(),userPort.get(userName[1]));  
		  
		//create input fromServer and output toServer
		 final Reader fromSer=new InputStreamReader(talkSoc.getInputStream());
		  PrintWriter toSer=new PrintWriter(talkSoc.getOutputStream());
		
		//create input fromUser and output toUser
	     Reader fromUsr=new InputStreamReader(System.in);//transform Byte stream into Char stream with class InputStreamReader 
		final  PrintWriter toUsr=new PrintWriter(System.out,true);
		  
		  //create thread talkIn to handle message from other client.
		  Thread talkIn = new Thread(){
				 
			  public void run(){
				  
				  try{
					  
					  
				  char []buffer=new char[100];
				  int charRead;
				  
				  while ((charRead=fromSer.read(buffer))>0){
					 toUsr.write(buffer, 0, charRead); 
				     toUsr.flush();
				  }
					  
				  }
				  
				  catch(Exception e){toUsr.println(e);}
				  toUsr.println("timeout,connection close by server");
			  System.exit(0);
				  
				 }
			  
			  
			  
		  };
		  
		  talkIn.start();//must start thread t before send message to server.
		  
		//send message from system.in to server;
		  while((readChar=fromUsr.read(bufferU))>0){
				 
			  toSer.write(bufferU, 0, readChar);
			  toSer.flush();
			  
		  }
		  
		  talkSoc.close(); 
	   }
	   else{
		   //send message from system.in to server;
		  
		  while((readChar=fromUser.read(bufferU))>0){
			 
			  toServer.write(bufferU, 0, readChar);
			  toServer.flush();
			  
		  }
	   
	   }
	  
	 
	 //
	  
	//close socket and terminate JVM to quit
	  soc.close();
	  toUser.println("connection closed by client");
	   //System.exit(0);
	
	}catch (Exception e){System.err.println(e);
	                     System.err.println("USAGE:java NetClient <host> <port>");}
	
	
	}

}
