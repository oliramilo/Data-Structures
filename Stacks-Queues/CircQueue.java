public class CircQueue extends DSAQueue
{
    public static final int CAPACITY = 1000;
    private int front;
    private int rear;
    public CircQueue()
    {
        super();
        front = -1;
        rear = -1;
    }

    public CircQueue(int max)
    {
        super(max);
        front = -1;
        rear = -1;
    }

    @Override
    public void enQueue(Object obj)
    {
        //Check if Queue is full
        if(isFull())
        {
            throw new QueueFullException("Queue is full");
        }
        else
        {
            rear =(rear+1)%queueArr.length;
            queueArr[rear] = obj;
            count++;
            if(front == -1)
            {
                front = rear;
            }
        }
    }

    @Override
    public Object deQueue()
    {
        Object element = null;
        if(isEmpty())
        {
            throw new QueueEmptyException("Queue is Empty");
        }

        else
        {
            element = queueArr[front];
            front =(front+1)%queueArr.length;
            count--;
        }
        return element;
    }

    @Override
    public Object peek()
    {
        Object top = null;;
        if(isEmpty())
        {
            throw new QueueEmptyException("Queue is Empty");
        }
        else
        {
            top = queueArr[front];
        }
        return top;
    }
}
