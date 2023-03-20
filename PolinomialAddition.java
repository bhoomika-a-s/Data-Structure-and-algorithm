import java.util.*;
import java.io.*;

class Link {
    public int exp;
    public int coeff;
    public Link next;

    public Link( int e, int c) { 
        exp = e;
        coeff = c;
        next = null;
    }
}

class LinkedList {
    public Link first;
    public Link last;

    public LinkedList() {
        first = last = null;
    }

    public void display() {
        Link current = first;

        while(current != null) {
            System.out.println(current.coeff + ""+ current.exp + "");
            current = current.next;
        }
    }

    public void addNode( int exp, int coeff) {
        Link newlink = new Link(exp,coeff);

        if(first == null) {
            first = newlink;
            last = newlink;
            }
        else{
            last.next = newlink;
            newlink.next = null;
            last = newlink;
        }
    }

    public void length() {
                    Link current=first;
                    int count=0;
                    while(current!=null) {
                        count++;
                        current=current.next;
                    }
                    return count;
    }


public class PolinomialAddition {
  
    public LinkedList polinomialAddition(LinkedList p, LinkedList q) {
        LinkedList result = new LinkedList();
        int rcoeff = 0 , rexp = 0, m;
        
        Link temp1 = p.first;
        Link temp2 = q.first;

        int l1 = p.length();
        int l2 = q.length();

    if(l1>l2) {
        m=l1;
    } else {
        m=l2;
    }

    for(int i = 0; i < m; i++) {
        if(temp1.exp == temp2.exp){
            rcoeff = temp1.coeff+ temp2.coeff;
            rexp = temp1.exp;
            result.addNode(rexp,rcoeff);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        else if(temp1.exp < temp2.exp) {
            rcoeff = temp2.coeff;
            rexp = temp2.exp;
            result.addNode(rexp, rcoeff);
            temp2 = temp2.next;
        }
        else if(temp1.exp > temp2.exp) {
            rcoeff = temp1.coeff;
            rexp = temp1.exp;
            result.addNode(rexp, rcoeff);
            temp1 = temp1.next;
        }
    }

    while(temp1 != null) {
        rcoeff = temp1.coeff;
        rexp = temp1.exp;
        result.addNode(rcoeff, rexp);
        temp1 = temp1.next;
    }

    while( temp2 != null) {
        rcoeff = temp2.coeff;
        rexp = temp2.exp;
        result.addNode(rcoeff,rexp);
        temp2 = temp2.next;
    }
     result.display();
    }
}
    
public static void main(String st[]) {

        LinkedList poly_1 = new LinkedList();
        LinkedList poly_2 = new LinkedList();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the first polynomial elemnts");
        String first_expression = scan.nextLine();
        String[] exp_1 = first_expression.replace("^"," ").split("((?=\\+)|(?=\\-)|x)");
        for(int i = 0; i < exp_1.length; i += 2) {
            int coeff = Integer.parseInt(exp_1[i]);
            int exp = 0;
            if((i+1) < exp_1.length){
                exp = Integer.parseInt(exp_1[i+1]);
            } else {
                exp = 0;
            }
            poly_1.addNode(exp, coeff);
        }
        
        System.out.println("Enter the second polynomial elemnts");
        String second_expression = scan.nextLine();
        String[] exp_2 = second_expression.replace("^"," ").split("((?=\\+)|(?=\\-)|x)");
        for(int i = 0; i < exp_2.length; i += 2) {
            int coeff = Integer.parseInt(exp_2[i]);
            int exp = 0;
            if((i+1) < exp_2.length){
                exp = Integer.parseInt(exp_2[i+1]);
            } else {
                exp = 0;
            }
            poly_2.addNode(exp, coeff);
        }

        System.out.print("\nFirst Expression : ");
		poly_1.display();
		System.out.print("\nSecond Expression : ");
		poly_2.display();

		System.out.print("\nAddition Result : ");
		polinomialAddition(poly_1,poly_2);
    }
}
