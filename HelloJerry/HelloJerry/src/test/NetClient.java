package test;

import java.net.*;
import java.io.*;
//import java.util.*;
//import test.IMCliServer;

public class NetClient {
	
	 static Socket s;
	 static subClient subMe; 
	 
	public static void main(String[] args) {
	  
	
		
	try{
		
	
	final ServerSocket cliSerSoc=new ServerSocket(0);
		
	final subClient subCli=new subClient(new Socket("localhost",8889));
	
	
    	Thread thread_toUsr=new Thread(){
    		public void run(){
    			
    			subCli.serToUsr();
    		}
    		
    	};
    	
    	thread_toUsr.start(); //need to start thread to standby for handling serToUsr
    	           //before launch usrToSer()
	
	  
	
	//need a thread to launch IMCliServer and keep it running
	 
	/* Thread thread_startIMCliSer = new Thread(){
		  
		  public void run(){
			  
			  
				  IMCliServer.server(cliSerSoc);
					
			  
			 }
		  
		  
		  
	  };
	 
	 thread_startIMCliSer.start();
	 */
	 
	 //send message(user:cliSerPort) from client to server
	   int cliSerPort=cliSerSoc.getLocalPort();
		
	   subCli.toServer.print("jerry"+":"+cliSerPort);
	   subCli.toServer.flush();
	 
	 ///////////////////////////////////////////
	   
	 //standby to wait for incoming talker
		 Thread thread_incomeTal=new Thread(){
			 
			 public void run(){
				 
				 try{
					    
					   //System.out.println("this:"+cliSerSoc.getLocalPort());
					   
					   while(true){
						    s=cliSerSoc.accept();
						    subMe=new subClient(s);
						   Thread thread_IOforMe=new Thread(){
					    		public void run(){
					    			
					    			subMe.serToUsr();
					    		}
					    		
					    	};
					    	
					    	thread_IOforMe.start(); //need to start thread to standby for handling serToUsr
					    	                        //before launch usrToSer()
					    	
					    	
						   
					   }
					   
				   }catch(IOException e){System.err.println(e);}
				 
				 
			 }
			 
		 };
		 
		 thread_incomeTal.start();
	   
	   
	   
	   
	   
	/////////////////////////////////////////////   
	   
	   
	  //check message from system.in and handle it accordingly 
	  //then send to server;
		   char[]bufferU=new char[100];
		   int readChar;
		  
		  while((readChar=subCli.fromUser.read(bufferU))>0){
			  			  
			 if(new String(bufferU,0,readChar).contains("contact")){
				 
				String[] tok= new String(bufferU,0,readChar).split(" ");
				System.out.println(tok[1]);
				
				//connect to talker specified by port tok[1]
				final subClient subTal=new subClient(new Socket("localhost",Integer.parseInt(tok[1].trim()))); 
				Thread thread_talCli=new Thread(){
    		          public void run(){
    			
    			        subTal.serToUsr();
    		         }
    		
    	        };
    	
    	       thread_talCli.start(); //need to start thread to standby for handling serToUsr
    	                       //before launch usrToSer()
    	
    	       subTal.usrToSer();
				
			 }
			 else{
				 if(s!=null&&s.isConnected()){
					 System.out.println("socket connected...1");
					 //subClient subMe=new subClient(s);
					 subMe.usrToSer();/////////////////////
					 System.out.println("socket connected...2");
					 
				 }
				 else{
					 subCli.toServer.write(bufferU, 0, readChar);
					 subCli.toServer.flush();
					 
				 }
				 
				 
			 }
			  
			  
		  }
	    
	  
	
	
	}catch (Exception e){System.err.println(e);
	                     System.err.println("USAGE:java NetClient <host> <port>");}
	
	
	}

}
