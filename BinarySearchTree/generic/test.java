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
            tree.insert(50,"Hello");
            tree.insert(40,"There");
            tree.insert(80,"?");
            tree.insert(20, "Jessie");
            tree.insert(100,"Last");
            tree.insert(4,"Last");
            try 
            {
                System.out.println("Testing delete method for root");
                tree.delete(50);
                tree.find(50);
            }
            catch(NullPointerException e)
            {
                System.out.println("Test passed for deleting root");
            }
                try
                {
                    System.out.println("\n\nTesting delete for node B");
                    tree.delete(100);
                    tree.find(100);
                    System.out.println("Test failed for deleting node");
                }
                catch(NullPointerException f)
                {
                    System.out.println("Test passed for deleting B");
                }

            DSAQueue<BinarySearchTree.TreeNode> tQ = new Queue<BinarySearchTree.TreeNode>();
            tQ = tree.inOrder();
            Iterator<BinarySearchTree.TreeNode> it = tQ.iterator();
            System.out.println("In order traversal");
            while(it.hasNext())
            {
                System.out.println(it.next());
            }
            System.out.println("\nHeight tree: " +tree.height());
            System.out.println("Min key is: "+tree.min());
            tree.save("TreeSave.txt");
            BinarySearchTree t = new BinarySearchTree();
            t = t.load("TreeSave.txt");
            DSAQueue<BinarySearchTree.TreeNode> q = new Queue<BinarySearchTree.TreeNode>();
            q = t.preOrder();
            Iterator<BinarySearchTree.TreeNode> itQ = q.iterator();
            System.out.println("pre order traversal");
            while(itQ.hasNext())
            {
                System.out.println(itQ.next());
            }
            q = t.postOrder();
            Iterator<BinarySearchTree.TreeNode> newIt = q.iterator();
            System.out.println("\n");
            System.out.println("The tree is " + t.balance() + "% balanced");
            System.out.println("pre order traversal");
            while(newIt.hasNext())
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
