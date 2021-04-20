class test
{
    public static void main(String[] args)
    {
        
        BinarySearchTree t = new BinarySearchTree();
        t.read("RandomNames7000.csv", t);
        DSAQueue<BinarySearchTree.TreeNode> nd = t.postOrder();
        t.toCsv("outcome.csv", nd);
    }
}
