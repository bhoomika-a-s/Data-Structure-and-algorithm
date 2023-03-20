import java.util.*;
import java.io.*;

class Link {
    public Link next;
    public int data;

    public Link(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.println(data);
    }
}

class List {
    Link first;

    public List() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
        } else {
            Link current = first;
            Link previous = first;
            while (current != null && current.data < data) {
                previous = current;
                current = current.next;
            }
            if (current == first) {
                newLink.next = first;
                first = newLink;
            } else {
                previous.next = newLink;
                newLink.next = current;
            }

        }
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void deleteKey(int data) {
        Link current = first;
        Link previous = first;
        while (current != null) {
            if (current.data == data) {
                previous.next = current.next;
                System.out.println("Key deleted");
                break;
            } else {
                previous = current;
                current = current.next;
            }
        }
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}

class PriorityQueue {
    public static void main(String[] args) {
        System.out.println(
                "........................PRIORITY QUEUE USING LINKED LIST IMPLEMENTATION.....................");
        Scanner scn = new Scanner(System.in);
        List l = new List();
        int n;
        System.out.println("Enter the number of elements in the list : ");
        n = scn.nextInt();
        System.out.println("Enter the elements: ");
        int data;
        for (int i = 0; i < n; i++) {
            data = scn.nextInt();
            l.insert(data);
        }

        System.out.println("Elements are ");
        l.displayList();
        System.out.println("Enter a key to delete : ");
        int key = scn.nextInt();
        l.deleteKey(key);
        l.displayList();

    }
}