public abstract class DSAQueue
{
    public static final int CAPACITY = 1000;
    protected Object[] queueArr;
    protected int count;

    public DSAQueue()
    {
        queueArr = new Object[CAPACITY];
        count = 0;
    }

    public DSAQueue(int max)
    {
        queueArr = new Object[max];
        count = 0;
    }

    public abstract void enQueue(Object obj);
    public abstract Object deQueue();
    public abstract Object peek();
    
    public int size()
    {
        return queueArr.length;
    }

    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean isFull()
    {
        return count == queueArr.length;
    }
}
