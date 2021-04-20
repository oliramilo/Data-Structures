public abstract class DSAStack
{
    public static final int CAPACITY = 1000;
    protected Object[] stackArray;
    protected int count;

    public DSAStack()
    {
        stackArray = new Object[CAPACITY];
        count = 0;
    }

    public DSAStack(int capacity)
    {
        stackArray = new Object[capacity];
        count = 0;
    }

    public abstract void push(Object obj) throws StackFullException;
    public abstract Object pop() throws StackEmptyException;
    public abstract Object peek() throws StackEmptyException;

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean isFull()
    {
        return count == stackArray.length;
    }

    public int getCount()
    {
        return count;
    }

    public int size()
    {
        return stackArray.length;
    }
}
