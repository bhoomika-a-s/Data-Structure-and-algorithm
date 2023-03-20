import java.io.*;
import java.util.Scanner;
class Node{
	public int exp;
	public int coff;
	public Node next;
	
	public Node(int exp,int coff){
		this.exp=exp;
		this.coff=coff;
		this.next = null;
	}
}

class LinkedList{
	private Node head;
	
	public LinkedList(){
		head=null;
	}
	//addNode
	public void addNode(int coff,int exp){
		Node newNode = new Node(exp,coff);
		
		if(head==null){
			head=newNode;
			return;
		}
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next=newNode;
	}
	//display
	public void display(){
		Node temp = head;
		while(temp!=null){
			if(temp.coff==0){
				temp=temp.next;
			}
			if(temp.exp==0){
				System.out.print(temp.coff);
			}else{
				System.out.print(temp.coff+"x^"+temp.exp);
			}
			if(temp.next!=null){
				System.out.print(" + ");
			}
			temp = temp.next;
		}
		System.out.println();
	}
	//add polynomial
	public LinkedList addPoly(LinkedList list,int size1,int size2 ){
		LinkedList result = new LinkedList();
		Node temp1= this.head;
		Node temp2= list.head;
		
		int size =0;
		if(size1>size2){
			size=size1;
		}else{
			size=size2;
		}
		
		while(size>=0 &&(temp1 != null || temp2 != null)){
			if(temp1==null){
				result.addNode(temp2.coff,temp2.exp);
				temp2 = temp2.next;
			}else if(temp2==null){
				result.addNode(temp1.coff,temp1.exp);
				temp1 = temp1.next;
			}else if(temp1.exp == temp2.exp){
				int coff = temp1.coff+temp2.coff;
				result.addNode(coff,temp1.exp);
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else if(temp1.exp > temp2.exp){
				result.addNode(temp1.coff,temp1.exp);
				temp1 = temp1.next;
			}else if(temp1.exp < temp2.exp){
				result.addNode(temp2.coff,temp2.exp);
				temp2 = temp2.next;
			}
			size--;
		}

		return result;
	}
}

class Polynomial{
	public static void main(String args[]){
		//OBJECT SECTION
		LinkedList list1=new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList result = new LinkedList();
		Scanner scan = new Scanner(System.in);
		
		//INPUT SECTION
		System.out.print("\n Enter the First expression:");
		String firstExp = scan.nextLine();
		String[] first=firstExp.replace("^","").split("((?=\\+)|(?=\\-)|x)");
		for(int i=0;i<first.length;i+=2){
			int exp=0,coff=0;
			 coff = Integer.parseInt(first[i]);
			if((i+1)<first.length){
			 exp = Integer.parseInt(first[i+1]);}else{
				 exp=0;			
			}
			list1.addNode(coff,exp);
		}

		System.out.print("\n Enter the Second expression:");
		String secondExp = scan.nextLine();
		String[] second=secondExp.replace("^","").split("((?=\\+)|(?=\\-)|x)");
		for(int i=0;i<second.length;i+=2){
			int exp=0,coff=0;
			 coff = Integer.parseInt(second[i]);
			if((i+1)<second.length){
			 exp = Integer.parseInt(second[i+1]);}else{
				 exp=0;			
			}
			list2.addNode(coff,exp);
		}
		
		//OUTPUT SECTION
		System.out.print("\nFirst Expression : ");
		list1.display();
		System.out.print("\nSecond Expression : ");
		list2.display();
		result = list1.addPoly(list2,firstExp.length(),secondExp.length());
		System.out.print("\nAddition Result : ");
		result.display();

		scan.close();	
	}
}

/*
OUTPUT:

output1:
 Enter the First expression:2x^2-3x^1

 Enter the Second expression:3x^1+9

First Expression : 2x^2 + -3x^1

Second Expression : 3x^1 + 9

Addition Result : 2x^2 + 9


output2:

 Enter the First expression:2x^2+3x^1+9

 Enter the Second expression:3x^3+2x^2+1

First Expression : 2x^2 + 3x^1 + 9

Second Expression : 3x^3 + 2x^2 + 1

Addition Result : 3x^3 + 4x^2 + 3x^1 + 10


*/

