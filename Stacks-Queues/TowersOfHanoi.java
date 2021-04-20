public class TowersOfHanoi
{
    public static void main(String[] args)
    {
        int n =3;
        DSAStack src = new Stack(3);
        DSAStack dest = new Stack(3);
        
        System.out.println("Current stack count in dest: " +dest.getCount());
        for(int i=1;i<=n;i++)
        {
            src.push(i);
        }
        System.out.println("Current stack count on src: " +src.getCount());
        System.out.println("Using the recursive call for towers of hanoi,");
        towers(3,src,dest);

        System.out.println("The Stack count on dest is now: " + dest.getCount());
        for(int i=0;i<dest.size();i++)
        {
            System.out.println("Popping " + dest.pop() +" from  dest stack");
        } 
        System.out.println("dest stack count is now: " +dest.getCount());
    }

    public static void towers(int n, DSAStack src, DSAStack dest)
    {
        
        if(n==1)
        {
            moveDisk(src,dest);
        }
        else
        {
            DSAStack peg = new Stack(6-src.getCount()-dest.getCount());
            towers(n-1,src,peg);
            moveDisk(src,dest);
            towers(n-1,peg,dest);
        }
    }
    public static void moveDisk(DSAStack src, DSAStack dest)
    {
        dest.push(src.pop());
    }
}
