class DSALinkedList
{
    private Object element;
    private Node head;
    private Node tail;

    DSALinkedList()
    {
        head = null;
    }

    void insertFirst(Object e)
    {
        Node newNd = new Node(e);
        if(isEmpty())
        {
            head = newNd;
            tail = head;
        }

        else
        {
            head.setPrev(newNd);
            newNd.setNext(head);
            head = newNd;
        }
    }

    void insertLast(Object e)
    {
        Node newNd = new Node(e);
        if(isEmpty())
        {
            head = newNd;
            tail = head;
        }

        else if(head.getNext() == null)
        { 
            tail = newNd;
            tail.setPrev(head);
            head.setNext(tail);
        }
        
        else
        {
            tail.setNext(newNd);
            newNd.setPrev(tail);
            tail = newNd;
        }
    }

    Object removeFirst()
    {
        Object firstElem = null;
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }
        else if (head.getNext() == null)
        {
            firstElem = head.getElement();
            head = null;
        }
        else
        {
            firstElem = head.getElement();
            head = head.getNext();
            head.setPrev(null);
        }
        return firstElem;
    }

    Object removeLast()
    {
        Object lastElem = null;
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }

        else if(head.getNext() == null)
        {
            lastElem = tail.getElement();
            tail = null;
            head = null;
        }
        else
        {
            lastElem = tail.getElement();
            tail = tail.getPrev();
            tail.setNext(null);
        }
        return lastElem;
    }

    Object peekFirst()
    {
        Object first = null;
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        else
        {
            first = head.getElement();
        }
        return first;
    }

    Object peekLast()
    {
        Object last = null;
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }
        else
        {
            last = tail.getElement();
        }
        return last;
    }

    boolean isEmpty()
    {
        return head == null;
    }
}
