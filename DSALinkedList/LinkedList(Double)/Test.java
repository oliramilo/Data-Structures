class Test
{
    public static void main(String[] args)
    {
        DSALinkedList list = new DSALinkedList();
        list.insertLast("abc"); 
        list.insertLast("jkl");
        list.insertLast("xyz");

        System.out.println("Last element is: "+list.peekLast());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
    }
}
