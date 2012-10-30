package test;

import java.net.*;
import java.io.*;

public class NetClient {
	
	public static void main(String[] args) {
	
		
	try{
	//initial a socket with host and port.
	String host= args[0];
	int port=Integer.parseInt(args[1]);
	if (args.length !=2)
		throw new IllegalArgumentException("pls enter 2 arguments,no more and no less");
	Socket soc=new Socket(host,port);
	
	
	//create input fromServer and output toServer
	 final Reader fromServer=new InputStreamReader(soc.getInputStream());
	 PrintWriter toServer=new PrintWriter(soc.getOutputStream());
	
	//create input fromUser and output toUser
     Reader fromUser=new InputStreamReader(System.in);//transform Byte stream into Char stream with class InputStreamReader 
	 final PrintWriter toUser=new PrintWriter(System.out,true);
	 
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
	  ///test String line;
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
	                     System.err.println("USAGE:java NetClient <host> <port>");}
	
	
	}

}
