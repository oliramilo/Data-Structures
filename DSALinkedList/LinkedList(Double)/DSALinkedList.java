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
        Node newNode = new Node(e);
        if(isEmpty())
        {
            head = newNode;
            tail = head;
        }
        else
        {
            newNode.setNext(head);
            head = newNode;
        }
    }

    void insertLast(Object e)
    {
        Node newNode = new Node(e);
        if(isEmpty())
        {
            head = newNode;
        }

        else if(head.getNext() == null)
        {
            tail = newNode; 
            head.setNext(tail);
        }

        else
        {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    Object removeFirst()
    {
        Object firstElem = head.getElement();
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }

        else
        {
            firstElem = head.getElement();
            head = head.getNext();
        }
        return firstElem;
    }

    Object removeLast()
    {
        Node iter = head;
        int i = 0;
        int ii = i;
        Object lastElem = null;
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }

        else if(iter.getNext() == null)
        {
            lastElem = head.getElement();
            head = null;
        }

        else
        {
            while(iter.getNext().getNext() != null)
            {
                if(iter.getNext().getNext() == null)
                {
                    lastElem = iter.getNext().getElement();
                    tail = iter;
                    tail.setNext(null);
                }

                iter=iter.getNext();
            }
        }
        return lastElem;
    }

    Object peekFirst()
    {
        Object first = null;
        if(isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }
        else
        {
            first = head.getElement();
        }
        return first;
    }

    Object peekLast()
    {
        Node curNode = head;
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
