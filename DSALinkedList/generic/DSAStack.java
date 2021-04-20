import java.util.*;
import java.io.*;

public abstract class DSAStack<E> implements Iterable<E>, Serializable
{
    private static final long serialVersionUID = 1L;
    protected DSALinkedList<E> stackList;
    
    public Iterator<E> iterator()
    {
        return stackList.iterator();
    }
    public DSAStack()
    {
        stackList = new DSALinkedList<E>();
    }

    public abstract void push(E obj) throws StackEmptyException;
    public abstract E pop() throws StackEmptyException;
    public abstract E peek() throws StackEmptyException;

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
