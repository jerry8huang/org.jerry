
package test;
import java.io.*;
import java.net.*;

/**
 * This program connects to a server at a specified host and port.
 * It reads text from the console and sends it to the server.
 * It reads text from the server and sends it to the console.
 **/
public class subClient {
	  Socket s;
	  Reader fromServer;
	  PrintWriter toServer;
	  
	  BufferedReader fromUser;
	  PrintWriter toUser;
	
	  public subClient(Socket soc) {
		  
		  s=soc;
		  
		  try{
			  // Set up streams for reading from and writing to the server.
	          // The fromServer stream is final for use in the inner class below
	          fromServer=new InputStreamReader(s.getInputStream());
	          toServer = new PrintWriter(s.getOutputStream());
	          
	          // Set up streams for reading from and writing to the console
	          // The toUser stream is final for use in the anonymous class below
	          fromUser = 
	              new BufferedReader(new InputStreamReader(System.in));
		    // Pass true for auto-flush on println()
		      toUser = new PrintWriter(System.out, true);
			  
		  }
		  
	    
	    catch (Exception e) { 
            System.err.println(e);
           
        }
		  
	  }
	
	  public void serToUsr() {
          char[] buffer = new char[1024];
          int chars_read;
          try { 
	// Read characters from the server until the
	// stream closes, and write them to the console
              while((chars_read = fromServer.read(buffer)) != -1) {
	    toUser.write(buffer, 0, chars_read);
	    toUser.flush();
	}
          }
          catch (IOException e) { toUser.println(e); }

          // When the server closes the connection, the loop above
          // will end.  Tell the user what happened, and call
          // System.exit(), causing the main thread to exit along
          // with this one.
       toUser.println("Connection closed by server.");
       System.exit(0);
	  }

//////////////////////////////////////////////	  
	  
	 public void usrToSer(){
		  
		 try{ String line;
          while((line = fromUser.readLine()) != null) {
              toServer.print(line + "\r\n");
              toServer.flush();
          }
          
          // If the user types a Ctrl-D (Unix) or Ctrl-Z (Windows) to end
          // their input, we'll get an EOF, and the loop above will exit.
          // When this happens, we stop the server-to-user thread and close
          // the socket.

          s.close();
          toUser.println("Connection closed by client.");
	    System.exit(0);
	    }
		 catch(IOException e){
			 
			 System.err.println(e);
		 }
		 
		  
	  }
	  
	
	 
	 
	/* 
    public static void main(String[] args) throws IOException {
    	
    	final subClient cli=new subClient(new Socket("localhost",8889));
    	Thread t=new Thread(){
    		public void run(){
    			
    			cli.serToUsr();
    		}
    		
    	};
    	
    	t.start(); //need to start thread to standby for handling serToUsr
    	           //before launch usrToSer()
    	
    	cli.usrToSer();
    	
    }
    */
}
