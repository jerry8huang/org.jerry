package test;

import java.net.*;
import java.io.*;

public class NetServer extends Thread {

	 Socket soc;
	 
	 //constructor NetServer();
	  NetServer(Socket soc){
		 
		 this.soc=soc;
	 }
	 
	 
	 //run()
	 public void run(){
		 try{
			 InputStream in=soc.getInputStream();
			 PrintWriter out=new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
			 out.println("hello client...");
			 out.flush();
			 
			 
			 byte [] buf=new byte[100];
			 int readByte;
			 
			 while((readByte=in.read(buf))>0){
				 System.out.println(new String(buf, 0, readByte));
				 out.println("fromServer...");
				 out.flush();
			 }
			 
			 
			 
			 
			 in.close();
			 out.close();
			 soc.close();
			 
		 }
		 catch(IOException e){System.err.println(e);}
		 
		 
	 }
	 
	 
	 //server() to accept and create socket, and also bind a port to the server
	 
	  static void server() {
		   try{
			   ServerSocket serSoc=new ServerSocket(8889);
			   while(true){
				   Socket s=serSoc.accept();
				   new NetServer(s).start();
			   }
			   
		   }catch(IOException e){System.err.println(e);}
		   
		   
		   
	   }
	    
	 
	 //main() start the server
	 
	public static void main(String [] args){
		
		server();
		
		
	}
	
	
}
