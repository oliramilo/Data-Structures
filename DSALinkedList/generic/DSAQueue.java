import java.io.*;

public abstract class DSAQueue<E> implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected DSALinkedList<E> queueList;

    public DSAQueue()
    {
        queueList = new DSALinkedList<E>();
    }

    public abstract void enQueue(E obj);
    public abstract E deQueue() throws QueueEmptyException;
    public abstract E peek() throws QueueEmptyException;
    
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
