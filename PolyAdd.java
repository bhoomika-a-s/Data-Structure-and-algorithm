import java.util.*;

class Link{ public int exp;
            public int coeff;
            public Link next;

            public Link(int c, int e)
            {
              exp=e;
              coeff=c;
            }

          }

class LinkList{ public Link first;
                public Link last;

                public LinkList()
                {
                    first=last=null;
                }

                public void AddNode(int c, int e)
                { Link nl= new Link(c,e);
                  if(first==null)
                  {
                    first=nl;
                    last=nl;
                  }
                  else
                     { 

                        last.next=nl;
                        nl.next=null;
                        last = nl;
                     }
                }

                public void display()
                {
                   Link current=first;
                   while(current!=null)
                   {
                    System.out.println(current.coeff+","+current.exp+" ");
                    current= current.next;
                   }

                }
                public int lenght()
                {
                    Link current=first;
                    int count=0;
                    while(current!=null)
                    {
                        count++;
                        current=current.next;
                    }

                    return count;
                }

              }
public class PolyAdd {
        public static void polynomialAdd(LinkList p, LinkList q)
            {
              LinkList r = new LinkList();
              int rcoeff=0,rexp=0;
              int l1,l2,m;

              Link temp1=p.first;
              Link temp2=q.first;

              l1=p.lenght();
              l2=q.lenght();
              if(l1>l2)
              {
                m=l1;
              }
              else
                m=l2;
            
             for(int i=0;i<m;i++)
             {
              if(temp1.exp==temp2.exp)
              {
                rcoeff=temp1.coeff+ temp2.coeff;
                rexp=temp1.exp;
                r.AddNode(rcoeff,rexp);
                temp1=temp1.next;
                temp2=temp2.next;

              }
              else
                if(temp1.exp>temp2.exp)
                {
                    rcoeff=temp1.coeff;
                    rexp=temp1.exp;
                    r.AddNode(rcoeff, rexp);
                    temp1=temp1.next;

                }
                else 
                  {
                    rcoeff=temp2.coeff;
                    rexp=temp2.exp;
                    r.AddNode(rcoeff, rexp);
                    temp2=temp2.next;
                  }

             }

             while(temp1!=null)
             {
                rcoeff=temp1.coeff;
                    rexp=temp1.exp;
                    r.AddNode(rcoeff, rexp);
                    temp1=temp1.next;
             }
             while(temp2!=null)
             {
                rcoeff=temp2.coeff; 
                    rexp=temp2.exp;
                    r.AddNode(rcoeff, rexp);
                    temp2=temp2.next;
             }

                System.out.println("r=");
                r.display();
            }

            public static void main(String St[])
            {
               LinkList p=new LinkList();
               LinkList q=new LinkList();
               Scanner scn = new Scanner(System.in);
               int n,m,c,e;

               System.out.println("enter the elements is p and q");
               n=scn.nextInt();
               m=scn.nextInt();

               for(int i =0; i<n;i++)
               {
                System.out.println("enter elements of p\n");
                c=scn.nextInt();
                e=scn.nextInt();
                p.AddNode(c, e);
               }

               for(int i =0; i<m;i++)
               {
                System.out.println("enter elements of q\n");
                c=scn.nextInt();
                e=scn.nextInt();
                q.AddNode(c, e);
               }
               
               System.out.println("p=");
               p.display();
               System.out.println("q=");
               q.display();

               polynomialAdd(p,q);
            }
    
}
