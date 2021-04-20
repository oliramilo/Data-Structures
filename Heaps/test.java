import java.util.*;

class test
{
    public static void main(String [] args)
    {
        try
        {
            Heap h = new Heap();
            System.out.println("Adding 9 numbers to heap");
            h.add(4,"Four");
            h.add(50,"fiddy");
            h.add(110,"eleven-O");
            h.add(6,"siks");
            h.add(1531, "highest");
            h.add(500, "idek");
            h.add(200, "id3");
            h.add(212312330, "new highest");
            h.add(1, "lowest");
            h.printPos(0);
            h.sortThis();
            h.testSorted();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            Heap newHeap = new Heap();
            heapReader.fileToHeap("RandomNames7000.csv", newHeap);
        
            newHeap.sortThis();
            //newHeap.print();
            newHeap.printPos(6999);
            newHeap.printPos(0);
            newHeap.testSorted();
            System.out.println("Test passed");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        
        }

        try
        {
            System.out.println("Testing remove");
            Heap h = new Heap();
            System.out.println("Adding 9 numbers to heap");
            h.add(4,"4");
            h.add(50,"50");
            h.add(110,"110");
            h.add(6,"6");
            h.add(1531, "highest");
            h.add(500, "500");
            h.add(200, "200");
            h.add(212312330, "new highest");
            h.add(1, "lowest-1");
            while(!h.isEmpty())
            {
                System.out.println(h.remove());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


