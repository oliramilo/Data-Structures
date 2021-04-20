import java.util.*;
import java.io.*;
class Test
{
    public static void main(String[] args)
    {
        int i=0;
        try
        {
            System.out.println("Testing DSALinkedList, insert last and remove first");
            DSALinkedList list = new DSALinkedList();
            list.insertLast("abc"); 
            list.insertLast("jkl");
            list.insertLast("xyz");
        
            System.out.println("Last element is: "+list.peekLast());
            System.out.println(list.removeFirst());
            System.out.println(list.removeFirst());
            System.out.println(list.removeFirst());
            System.out.println("\nTest passed");
            i++;
        }
        catch(Exception e)
        { 
            System.out.println("Test failed for insert last and remove first.");
        }
        DSAStack Slist = new Stack();
        try
        {
            Slist.push("Hello world!");
            Slist.push("String second added");
            Slist.push("third added");
            Slist.push("4th added");
            Slist.push(555555);
            Slist.push(6.66666);
            Slist.push("Seven");
            Slist.push("Eight");
            System.out.println("\nTesting passed for pushing to stack");
            i++;
        }
        catch(Exception e)
        {
            System.out.println("\nTest failed for pushing stach");
        }
        try
        {
            Slist.saveStack("stackSave.txt");
            System.out.println("\nTest passed for saving stack");
            i++;
        }
        catch(Exception e)
        {   
            System.out.println("\nTest failed for saving stack");
        }
        try
        {
            while(!Slist.isEmpty())
            {
                System.out.println(Slist.pop() + " Popped from stack linked list\n");
            }
            i++;
        }
        catch(Exception e)
        {
            System.out.println("Test failed");
        }
        try
        {
            System.out.println("\nTesting  load");
            DSAStack newList = new Stack();
            newList.loadStack("stackSave.txt");

            System.out.println("Testing iterator");
            Iterator it = newList.iterator();
            System.out.println("Iterator detects next item: " + it.hasNext());
            System.out.println("\nTesting iterator next method");
            i++;
            try
            {
                for(Object e:newList)
                {
                    System.out.println(it.next());
                }
                System.out.println("Test passed");
                i++;
            }
            catch(Exception ex)
            {
                System.out.println("Test failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Test failed for iterator");
            e.printStackTrace();
        }
        System.out.println(i + "/" + 6 + " Tests passed.");
    }
}
