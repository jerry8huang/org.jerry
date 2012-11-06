package test;

/*
 * this program will hash lines in a file to 3 different files
 * 
 * 
 * */


import java.io.*;

public class HashFile {

	public static void main(String[] args){
		
		//throw new IllegalArgumentException("num of args should be 4,no more no less");
		
		try{
			
			BufferedReader br=new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw=new BufferedWriter(new FileWriter(args[1]));
			BufferedWriter bw01=new BufferedWriter(new FileWriter(args[2]));
			BufferedWriter bw02=new BufferedWriter(new FileWriter(args[3]));
			
			
			
			String line;
			while((line=br.readLine())!=null){
				
				if(line.hashCode()%3==0){
					
					bw.write(line+"\n");
					bw.flush();
				}
				else if((line.hashCode()%3==1)){
					
					bw01.write(line+"\n");  
					bw01.flush();
				}
				else{
					bw02.write(line+"\n");
					bw02.flush();
				
				}
				
			}
			br.close();bw.close();bw01.close();bw02.close();	
		}
		catch(Exception e){
			System.out.println(e);
			System.out.println("Usage java HashFile <inFile> <outFile01> <outFile02> <outFile03>"); 
		
		}
		
		
	}
	
	
}
