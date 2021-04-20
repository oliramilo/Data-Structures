import java.util.*;
class test
{
    public static void main(String [] args)
    {
        //String a = "1";
        //String b = "2";
        //System.out.println(a.compareTo(b));
        //System.out.println(String.valueOf(a));
        int i = 0;
        String a = "0123456789";
        String str = String.valueOf(a.charAt(i));
        try
        {
            BinarySearchTree tree = new BinarySearchTree();
            System.out.println("Binary search tree of keys inserted values of");
            System.out.println("VBCAZ");
            tree.insert("V","Hello");
            tree.insert("B","There");
            tree.insert("C","?");
            tree.insert("A", "Jessie");
            tree.insert("Z","Last");
            tree.insert("Y","Last");
            try
            {
                if(tree.height() == 3)
                {
                    System.out.println("Test pass for height method");
                }
                else
                {
                    throw new IllegalArgumentException("Test failed for height method");
                }
            }
            catch(Exception e)
            {
                System.out.println("Test failed"); e.printStackTrace();
            }
            try 
            {
                System.out.println("Testing delete method for root");
                tree.delete("V");
                tree.find("V");
            }
            catch(NullPointerException e)
            {
                System.out.println("Test passed for deleting root");
                tree.printRoot();
            }
                try
                {
                    System.out.println("\n\nTesting delete for node B");
                    tree.delete("B");
                    tree.find("B");
                    System.out.println("Test failed for deleting node");
                }
                catch(NullPointerException f)
                {
                    System.out.println("Test passed for deleting B");
                }

            DSAQueue tQ = new Queue();
            tQ = tree.inOrder();
            Iterator it = tQ.iterator();
            System.out.println("In order traversal");
            for(Object e:tQ)
            {
                System.out.println(it.next());
            }
            System.out.println("\nHeight tree: " +tree.height());
            System.out.println("Min key is: "+tree.min());
            tree.save("TreeSave.txt");
            BinarySearchTree t = new BinarySearchTree();
            t = t.load("TreeSave.txt");
            DSAQueue q = new Queue();
            q = t.preOrder();
            Iterator itQ = q.iterator();
            System.out.println("pre order traversal");
            for(Object x:q)
            {
                System.out.println(itQ.next());
            }
            q = t.postOrder();
            Iterator newIt = q.iterator();
            System.out.println("\n");
            System.out.println("The tree is " + t.balance() + "% balanced");
            System.out.println("pre order traversal");
            for(Object e:q)
            {
                System.out.println(newIt.next());
            }
            System.out.println("Tree balance: " + tree.balance() + "%");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
