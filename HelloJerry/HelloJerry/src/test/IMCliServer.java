package test;

import java.net.*;
import java.io.*;


public class IMCliServer extends Thread{

	 Socket soc;
	 
	 
	 
	 
	 //constructor IMCliServer();
	  IMCliServer(Socket soc){
		 
		 this.soc=soc;
	 }
	 
	 
	 //run() to handle input from talker and send message to cliSer
	 //and start thread toTalk
	 public void run() {
		 
		     toTalk.start();
		 
		 try{
			 Reader fromTalker=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			 PrintWriter toTalker=new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
			 
			 
			 PrintWriter toCliSer=new PrintWriter(System.out,true);
			 
			 
			 /*
			 InputStream in=soc.getInputStream();
			 PrintWriter out=new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
			 out.println("hello client...");
			 out.flush();
			 */
			 
			
			 
			 
			 //read message from Talker and output it to cliSer console
			 char [] buf=new char[100];
			 int readChar;
			 
			 while((readChar=fromTalker.read(buf))>0){
				 //System.out.println(new String(buf, 0, readChar));
				 toCliSer.write(buf, 0, readChar);
				 toCliSer.flush();
			 }
			 
			 
			 
			 
			 toTalker.close();
			 fromTalker.close();
			 toCliSer.close();
			 soc.close();
			 
		 }
		 catch(IOException e){System.err.println(e);}
		 
		 
	 }
	 
	 
	 
	// create another thread to handle input from CliSer and send message to talker
	 
	 Thread toTalk=new Thread(){
		 
		 public void run(){
			 
			 try{
				 PrintWriter toTalker=new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
				 
				 Reader fromCliSer=new BufferedReader(new InputStreamReader(System.in));
				 
				 toTalker.println("hi guy");
				 toTalker.flush();
				 
				 
				 char [] buf=new char[100];
				 int readChar;
				 
				 while((readChar=fromCliSer.read(buf))>0){
					 
					 toTalker.write(buf, 0, readChar);
					 toTalker.flush();
				 }
				 
				 toTalker.close();
				 
				 fromCliSer.close();
				 soc.close();
				 
			 }
			 catch(Exception e){
				 
				 System.err.println(e);
				 
				 
			 }
			 
			 
			 
		 }
		 
		 
		 
	 };
	 
	 
	 
	 
	 
	 
	 
	 //server() to accept and create socket, and also bind a port to the server
	 
	  public static void server(ServerSocket cliSerSoc) {
		   try{
			    
			   //System.out.println("this:"+cliSerSoc.getLocalPort());
			   
			   while(true){
				   Socket s=cliSerSoc.accept();
				   new IMCliServer(s).start();
				   
			   }
			   
		   }catch(IOException e){System.err.println(e);}
		   
		   
		   
	   }
	    
	 
	 
	
	
}
