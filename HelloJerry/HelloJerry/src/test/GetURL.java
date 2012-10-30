package test;

/*
 * Copyright (c) 2004 David Flanagan.  All rights reserved.
 * This code is from the book Java Examples in a Nutshell, 3nd Edition.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose,
 * including teaching and use in open-source projects.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, or to purchase the book, 
 * please visit http://www.davidflanagan.com/javaexamples3.
 */

import java.io.*;
import java.net.*;

/**
 * This simple program uses the URL class and its openStream() method to
 * download the contents of a URL and copy them to a file or to the console.
 **/
public class GetURL {
	
	
	public static void main(String[] args){
		
		InputStream in=null;
		OutputStream out=null;
		
		try{
			 
			 
			if(args.length!=1&&args.length!=2)
				throw new IllegalArgumentException("wrong number of arguments");
			URL url=new URL(args[0]);
			in=url.openStream();
			
			//if user don't specify the file name, output to console, otherwise move to file
			if(args.length==1)
			out=System.out;
			else if(args.length==2) 
			out=new FileOutputStream(args[1]);
			
			//write output to console or file
			byte [] buffer=new byte[100];
			int readByte;
			
			while((readByte=in.read(buffer))!=-1){
				
				out.write(buffer,0,readByte);
				out.flush();
				
			}
		}
		catch(Exception e ){ System.err.println(e);
		                     System.out.println("USAGE:java GetURL <url> [file]");
		                   }
		finally{
			
			System.out.println("finally....");
			 // Always close the streams, no matter what.
			try { in.close();  out.close(); } catch (Exception e) {}
		}
		
	}
	
	
	
}
