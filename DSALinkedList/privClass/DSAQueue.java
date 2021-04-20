import java.io.*;
import java.lang.Iterable;
public abstract class DSAQueue implements Iterable, Serializable
{
    protected DSALinkedList queueList;

    public DSAQueue()
    {
        queueList = new DSALinkedList();
    }

    public abstract void enQueue(Object obj);
    public abstract Object deQueue() throws QueueEmptyException;
    public abstract Object peek() throws QueueEmptyException;
    
    public boolean isEmpty()
    {
        return queueList.isEmpty();
    }

    public void saveQueue(String file)
    {
        queueList.save(queueList,file);
    }

    public void loadQueue(String file)
    {
        queueList = queueList.load(file);
    }
}
