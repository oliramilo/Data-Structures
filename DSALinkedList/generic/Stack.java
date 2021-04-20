import java.io.*;
import java.util.*;
public class Stack<E> extends DSAStack<E> implements Iterable<E>, Serializable
{
    private static final long serialVersionUID = 1L;
    public Iterator<E> iterator()
    {
        return stackList.iterator();
    }

    public Stack()
    {
        super();
    }

    @Override
    public void push(E obj)
    {
        stackList.insertLast(obj);
    }
    
    @Override
    public E pop()                                                         
    {
        E top = null;
        if(isEmpty())
        {
            throw new StackEmptyException("Stack Empty");
        }
        else
        {
            top = stackList.removeLast();
        }
        return top;
    }

    @Override
    public E peek()                                                        
    {
        E top = null;
        if(isEmpty())
        {
            throw new StackEmptyException("Stack empty");
        }
        else
        {
            top = stackList.peekLast();
        }
        return top;
    }
}
