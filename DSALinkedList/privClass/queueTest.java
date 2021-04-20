import java.util.*;
class queueTest
{
    public static void main(String[] args)
    {
        int points=0;
        try
        {
            System.out.println("Testing DSALinkedList as a Queue");
            DSAQueue ql = new Queue();  
            ql.enQueue(1);
            ql.enQueue(2);
            ql.enQueue(3);
            ql.enQueue(4);
            ql.enQueue(5);
            points++;
            System.out.println("enQueue method: passed");
            try
            {
                System.out.println("Testing peek method");
                int first = 0;
                if(ql.peek() instanceof Integer)
                {
                    first = Integer.parseInt(String.valueOf(ql.peek()));
                    points++;
                }
                else
                {
                    System.out.println("Test failed");
                }
                if (first == 1)
                {
                    System.out.println("peek method: passed");
                    points++;
                }
                else
                {
                    System.out.println("Test failed");
                }
            }
            catch(Exception ex)
            {
                System.out.println("Test failed");
            }

            try
            {
                boolean pass =false;
                while(!ql.isEmpty())
                {
                    if(ql.peek() != ql.deQueue())
                    {
                        System.out.println("Test failed");
                    }
                    else
                    {
                        pass = true;
                    }
                }
                if(pass)
                {
                    points++;
                }
                System.out.println("Test passed for queueing all elements "+pass);
            }
            catch(Exception t)
            {
                System.out.println("Test failed"); 
            }
        }
        catch(Exception e)
        {
            System.out.println("Test failed");
        }
        
        try
        {
            System.out.println("Test methods: save/load");
            DSAQueue nl = new Queue();
            nl.enQueue("First elem");
            nl.enQueue("second elem");
            nl.enQueue("third elem");
            nl.enQueue("last elem");
            try
            {
                nl.saveQueue("QueueFile.txt");
                System.out.println("Save method: passed");
                points++;
            }
            catch(Exception ex)
            {
                System.out.println("Save method: failed");
            }

            try
            {
                DSAQueue ol = new Queue();
                ol.loadQueue("QueueFile.txt");
                Iterator it = ol.iterator();
                System.out.println("Loading previous queue, values are:\n");
                for(Object e: ol)
                {
                    System.out.println(it.next());
                }
                points++;
                points++;
                System.out.println("Load method: passed");
                System.out.println("Iterator method: passed");
            }
            catch(Exception t)
            {
                System.out.println("Load method: failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Test failed.");
        }
        System.out.println(points + "/" + 7 + " Tests passed.");
    }
}
