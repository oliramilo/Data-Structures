class test
{
    public static void main(String[]args)
    {
        try
        {
            HashTable t = new HashTable();
            int i =0;
            System.out.println("Adding 503 items in the table");

            while(i<503)
            {
                t.add("James",1);
                i++;
            }
            System.out.println("Array filled up to 503");
            System.out.println(t.getSize());
            int ii=0;
            while(ii<100)
            {
                t.remove("James");
                ii++;
            }
            System.out.println("Size is now " + t.getSize());
            System.out.println("Items in the array " + t.getCount());
            t.add("Bob" , 1231);
            System.out.println(t.get("Bob"));
            System.out.println("Space at 275 is occupied: " + t.checkNull(275));
            System.out.println("Space at 496 should have james " + t.checkNull(496));
            System.out.println("Test passed");
            //t.check();
        }
        catch(Exception e)
        {
            System.out.println("Test failed.");
        }
    }
}
