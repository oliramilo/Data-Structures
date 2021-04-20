import java.util.*;
import java.io.*;
public class Queue<E> extends DSAQueue<E> implements Iterable<E>, Serializable
{
    private static final long serialVersionUID = 1L;
    @Override
    public Iterator<E> iterator()
    {
        return queueList.iterator();
    }

    public Queue()
    {
        super();
    }

    @Override
    public void enQueue(E obj)
    {
        queueList.insertLast(obj);
    }

    @Override
    public E deQueue()
    {
        E firstElem = null;
        if(isEmpty())
        {
            throw new QueueEmptyException("Queue is Empty");
        }

        else
        {
            firstElem = queueList.removeFirst();
        }
        return firstElem;
    }

    @Override
    public E peek()
    {
        E top = null;;
        if(isEmpty())
        {
            throw new QueueEmptyException("Queue is Empty");
        }
        else
        {
            top = queueList.peekFirst();
        }
        return top;
    }
}
