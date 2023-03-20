import java.util.*;

class Stack{ public int max;
             public int top;
             public int arr[];

             public Stack(int s)
             {
                max=s;
                arr= new int[max];
                top=-1;
             }

             public boolean isEmpty()
             {
                return(top==-1);
             }

             public boolean isFull()
             {
                return(top==max-1);
             }

             public void push(int d)
             {
                if(!isFull())
                {
                    top++;
                    arr[top]=d;
                }
             }

             public int peek(int key)
             {
                int j;
                j=arr[key];
                return j;
             }

             public int pop()
             {
                int j;
                j=arr[top];
                top--;
                return j;
             }

           }

class Link{
            public int data;
            public int freq;
            public Link next;
            public Link(int d,int f)
            {
                data=d;
                freq=f;
            }
          }
class LinkList{
                public Link first;
                public Link last;

                public LinkList()
                {
                    first=null;
                    last=null;
                }

                public void addNode(int d, int f)
                {
                    System.out.println("test1");
                    Link nl= new Link(d,f);

                    if(first==null)
                    {
                        first=nl;
                        last=nl;
                    }
                    else
                      {
                        last.next=nl;
                        last=nl;
                      }
                }

                public void display()
                {
                    Link current=first;
                    while(current!=null)
                    {
                        System.out.println(current.data+" "+current.freq);

                        current=current.next;
                    }
                }

                public void largestFrequency()
                { System.out.println("test2");
                  display();
                    Link current = first;
                    int mf=current.freq;

                    while(current!=null)
                    {
                        if(current.freq>mf)
                        {
                            mf=current.freq;
                        }
                        
                        current=current.next;
                    }
                    current=first;
                    while(current!=null)
                    {
                        if(current.freq==mf)
                        {
                            System.out.println("the element with highest frequency is"+current.data);
                            System.out.println("it has a frequency of"+current.freq);
                            break;
                        }
                        else
                          current=current.next;

                    }

                    /*if(current.freq==mf)
                    {
                        System.out.println("the element with highest frequency is"+current.data);
                        System.out.println("it has a frequency of"+current.freq);
                    }*/
                }

                
              }

public class Frequency {
    public static void mostFrequentElement(Stack ob)
    { System.out.println("test");
        LinkList list= new LinkList();
      
      while(!ob.isEmpty())
      { int freq=0;
        int d=ob.pop();
        freq=1;
        int current=ob.top;
        while(current!=-1)
        { 
            int q=ob.peek(current);

            if(d==q)
             {
                freq++;
             }

            current--;
        }
        list.addNode(d,freq);
     }
     list.display();
     list.largestFrequency();

    }

    public static void main(String st[])
    {   Stack ob=new Stack(20);
        Scanner scn=new Scanner(System.in);
        
        System.out.println("enter number of elemnts to eter in stack");
        int n=scn.nextInt();

        for(int i=0;i<n;i++)
        {
            System.out.println("enter element;");
            int p=scn.nextInt();
            ob.push(p);
        }
        
        mostFrequentElement(ob);
    }
    
}
