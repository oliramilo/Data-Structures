import java.util.*;
import java.io.*;

public abstract class DSAStack implements Iterable, Serializable
{
    public static final int CAPACITY = 1000;
    protected DSALinkedList stackList;
    
    public Iterator iterator()
    {
        return stackList.iterator();
    }
    public DSAStack()
    {
        stackList = new DSALinkedList();
    }

    public abstract void push(Object obj) throws StackEmptyException;
    public abstract Object pop() throws StackEmptyException;
    public abstract Object peek() throws StackEmptyException;

    public boolean isEmpty()
    {
        return stackList.isEmpty();
    }

    public void saveStack(String file)
    {
        stackList.save(stackList,file);
    }

    public void loadStack(String file)
    {
        stackList = stackList.load(file);
    }
}
