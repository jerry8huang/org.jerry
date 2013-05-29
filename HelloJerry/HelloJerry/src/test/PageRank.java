package test;

import java.util.*;

public class PageRank {
	
	public static void main(String [] args){
		
		Node n1=new Node();
		n1.set(1);
		n1.setAdjList(2);
		n1.setAdjList(4);
		
		Node n2=new Node();
		n2.set(2);
		n2.setAdjList(3);
		n2.setAdjList(5);
		
		Node n3=new Node();
		n3.set(3);
		n3.setAdjList(4);
		
		Node n4=new Node();
		n4.set(4);
		n4.setAdjList(5);
		
		Node n5=new Node();
		n5.set(5);
		n5.setAdjList(1);
		n5.setAdjList(2);
		n5.setAdjList(3);
		
		while(true){
			
			//n1.pageRank/n1.getAdjList().size();
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}


class Node{
	
	private int id;
	private ArrayList<Integer> adjList=new ArrayList<Integer>();
	public final double pageRank=0.2;
	
	
	void set(Integer nodeId){
		
		id=nodeId;
	}
	
	int get(){
		
		return id;
	}
	
	void setAdjList(Integer adjNode){
		
		adjList.add(adjNode);
	}
	
	ArrayList<Integer> getAdjList(){
		
		return adjList;
		
	}
	
}
