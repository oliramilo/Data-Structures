class testHarness
{
    public static void main(String [] args)
    {
        BinarySearchTree t = new BinarySearchTree();
        try
        {
            System.out.println("25".compareTo("100"));
            t.insert("100",23123);
            t.insert("25",1);
            t.insert("75",1231231);
            t.insert("75",1231231);
            t.insert("75",1231231);
            t.delete("75");
            t.delete("75");
            t.delete("100");
            t.find("25");
            System.out.println("Tree balance is: "+t.balance());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //System.out.println("Test failed");
        }
    }
}
