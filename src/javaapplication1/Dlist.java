/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author STUDENT
 */
public class Dlist {

    
    
    class Node{
    
    int NodeNo;
    int NodeId;
    int refNodeId;
    int[] childrefId;
    TimeStamp timestamp;
    Data data;
    int sum;
    ArrayList<Node> children = null;
    String hashval;
    
    
        public Node(int NodeNo, int NodeId,int refNodeId, TimeStamp timestamp, Data data, String hashval ) {
			this.data = data;
                        this.NodeNo = NodeNo;
                        this.NodeId = NodeId;
                        this.refNodeId = refNodeId;
                        this.timestamp = timestamp;
                        this.data = data;
                        this.hashval = hashval;
			children = new ArrayList<Node>();
		}
    }
    
    private Node root;
    private int size;
    
    
    
    
    
    
    public class TimeStamp{
        int dd;
        int mm;
        int yy;

    }
    
    public class Data{
        int OId;
        float val;
        String Oname;
        

    }
    
   
    

    
    
    
    
        private Node takeInput(Scanner scn, Node parent, int ithChild) {
		if (parent == null) {
			System.out.println("enter data for Genesis Node");
		} else {
			System.out.println("enter data for " + ithChild + " child of node "
					+ parent.data);
		}

		Data data = null;
                System.out.println("Enter Owner id");
                int OId = scn.nextInt();
                
                 System.out.println("Enter Value");
                float val = scn.nextInt();
                
                 System.out.println("Enter Owner Name");
                String Oname = scn.nextLine();
                
                
                System.out.println("Enter Data");
                
                
                System.out.println("Enter Node No");
                int NodeNo = scn.nextInt();
                System.out.println("Enter id");
                 int NodeId = scn.nextInt();
                 System.out.println("Enter Ref No");
                 int refNodeId = scn.nextInt();
                 
                 String hashval = Createhashval(refNodeId);
                 
                 
    
                 System.out.println("Enter Date(dd-mm-yy)");
                 TimeStamp timestamp = null;
                 timestamp.dd= scn.nextInt();
                 timestamp.mm = scn.nextInt();
                 timestamp.yy = scn.nextInt();
                 
                 
    
    
    
                
                
                
		Node child = new Node(NodeNo, NodeId,refNodeId,timestamp,data , hashval);
		this.size++;

		System.out.println("enter number of children of " + child.data.val);
		int GCchild = scn.nextInt();

		for (int i = 0; i < GCchild; i++) {
			Node grandChild = this.takeInput(scn, child, i);
			child.children.add(grandChild);
		}
		return child;
                
        
	
    }
        
        private String Createhashval(int refno){
            
            String res = "";
            
            while(refno>0){
                res = res + refno%10 + ".";
                refno/=10;
            }
            
            return res;
            
        }
        
        public int Longestchain() {
		return longestchain(this.root);
	}

	private int longestchain(Node node) {

		int rv = -1;
		for (Node val : node.children) {
			int cht = this.longestchain(val);
			if (cht > rv) {
				rv = cht;
                                System.out.println(node.NodeId);
			}
		}

		rv = rv + 1;
		return rv;
	}

    
        
        
        
        

}




