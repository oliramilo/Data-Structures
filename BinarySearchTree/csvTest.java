class csvTest
{
    public static void main(String args[]){
        
        BinarySearchTree t = new BinarySearchTree();
        System.out.println("Reading RandomNames7000.csv");
        
        fileReader.read("RandomNames7000.csv",t);
        System.out.println("Tree balance is %" + t.balance());
        System.out.println("Tree height is " + t.height());
        System.out.println("Right most node fo the subtree level " + t.maxlv());
        System.out.println("Left most node of the subtree level " + t.minlv());
        DSAQueue q = t.postOrder();
        System.out.println("Exported in a file called outcome.csv in post order");
        fileReader.toCsv("outcome.csv", q);
    }
}
