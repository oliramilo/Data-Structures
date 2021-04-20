class Test
{
    public static void main(String[] args)
    {
        DSALinkedList<Integer> list = new DSALinkedList<Integer>();
        System.out.println("Current data");
        list.insertLast(123); 
        list.insertLast(321);
        list.insertLast(10321);
        System.out.println("Last element is: "+list.peekLast());
        list.save(list,"fileName.txt");
        System.out.println("");
        System.out.println("Removing first elements from list");
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());

        DSALinkedList<Integer> oldData = list.load("fileName.txt");
        if (oldData instanceof DSALinkedList)
        {
            System.out.println("Test pass");
        }
        System.out.println("Saved data from old");
        System.out.println(oldData.removeFirst());
        System.out.println(oldData.removeFirst());
        System.out.println(oldData.removeFirst());

    }
}
