//Shuffle Queue class
public class Queue extends DSAQueue
{
    public Queue()
    {
        super();
    }

    public Queue(int max)
    {
        super(max);
    }

    @Override
    public void enQueue(Object obj)
    {
       if(isFull())
       {
            throw new QueueFullException("Queue is full");
       }
       else
       {
            queueArr[count] = obj;
            count++;
       }
    }

    @Override
    public Object deQueue()
    {
        Object spam;
        if(isEmpty())
        {
            throw new QueueEmptyException("Queue is Empty");
        }
        else
        {
            spam = queueArr[0];
            for(int eggs=0;eggs<count-1;eggs++)
            {
                queueArr[eggs] = queueArr[eggs+1];
            }
            count--;
        }
        return spam;
    }
    
    @Override
    public Object peek()
    {
        Object top = null;
        if(isEmpty())
        {
            throw new QueueEmptyException("Queue is Empty");
        }
        else
        {
            top = queueArr[0];
        }
        return top;
    }
}
