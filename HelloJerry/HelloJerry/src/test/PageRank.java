package test;

import java.text.DecimalFormat;
import java.util.*;

public class PageRank {
	
	public static void main(String [] args){
		
		Node n1=new Node(1);
		n1.setAdjList(2);
		n1.setAdjList(4);
		
		Node n2=new Node(2);
		n2.setAdjList(3);
		n2.setAdjList(5);
		
		Node n3=new Node(3);
		n3.setAdjList(4);
		
		Node n4=new Node(4);
		n4.setAdjList(5);
		
		Node n5=new Node(5);
		n5.setAdjList(1);
		n5.setAdjList(2);
		n5.setAdjList(3);
		
		//create a HashMap to store nodes
		HashMap<Integer,Node> hMap=new HashMap<Integer,Node>();
		hMap.put(1, n1);
		hMap.put(2, n2);
		hMap.put(3, n3);
		hMap.put(4, n4);
		hMap.put(5, n5);
		
		
		double p;
		//return each double num with 4 digits.
		DecimalFormat format=new DecimalFormat("0.000");
		
		int count=0;
		//set to 10 iterations 
		while(count<10){
		 count++;
		 for(int key:hMap.keySet()){
			 //divide pageRank for 	
			 p=hMap.get(key).pageRank/hMap.get(key).getAdjList().size();
			 p=Double.valueOf(format.format(p));
			 //System.out.println("hey.."+p);
			 //put the partition of pageRank from each node to their Adjacency node
			 for(int i:hMap.get(key).getAdjList()){
				 
					 hMap.get(i).addPR(p);
					 
				 	
				 
			 }
			 
		 }
		 
		 //print pageRank in each node after one iteration
		 
		 for(int key:hMap.keySet()){
			 
			 hMap.get(key).setPR();
			 hMap.get(key).sumPr=0;//reset sumPr to 0 after each iteration
			System.out.println(key+":"+format.format(hMap.get(key).pageRank));
		 }
		 
		 
		 
		}
		
		
	}
	
	
		

}

//class Node to define the nodes 
class Node{
	
	private int id;
	private ArrayList<Integer> adjList=new ArrayList<Integer>();
	public double pageRank=0.2;// set to 0.2 because there're 5 nodes,0.2*5=1
	public double sumPr=0;
	
	Node(int nid){
		
		set(nid);
		
	}
	
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
	
	void addPR(double p){
		
		sumPr+=p;
		
	}
	
	void setPR(){
		pageRank=sumPr;
		
	}
	
}
