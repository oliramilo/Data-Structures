import java.util.*;
import java.io.*;
class DSALinkedList<E> implements Iterable<E>, Serializable
{
    private static final long serialVersionUID = 1L;

    private Node<E> head;
    private Node<E> tail;

    public Iterator<E> iterator()
    {
        return new DSALinkedListIterator<E>(this);
    }

    private class DSALinkedListIterator<E> implements Iterator<E>
    {
        private Node<E> iterNext;
        public DSALinkedListIterator(DSALinkedList<E> list) {
            iterNext = list.head;
        }

        public boolean hasNext() {
            return iterNext != null;
        }

        public E next() {
            E curVal = null;
            if(iterNext == null) {
                curVal = null;
            }
            else {
                curVal = iterNext.getElement();
                iterNext = iterNext.getNext();
            }
            return curVal;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation not supported");
        }
    }

    DSALinkedList()
    {
        head = null;
    }

    void insertFirst(E e)
    {
        Node<E> newNd = new Node<E>(e);
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

    void insertLast(E e)
    {
        Node<E> newNd = new Node<E>(e);
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

    E removeFirst()
    {
        E firstElem = null;
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

    E removeLast()
    {
        E lastElem = null;
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

    E peekFirst()
    {
        E first = null;
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

    E peekLast()
    {
        E last = null;
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

    public void save(DSALinkedList<E> saveObj, String fileName)
    {
        FileOutputStream strm;
        ObjectOutputStream objStrm;
        try
        {
            strm = new FileOutputStream(fileName);
            objStrm = new ObjectOutputStream(strm);
            objStrm.writeObject(saveObj);

            objStrm.close();
            strm.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public DSALinkedList<E> load(String fileName)
    {
        FileInputStream strm;
        ObjectInputStream objStrm;
        DSALinkedList<E> inObj = null;

        try
        {
            strm = new FileInputStream(fileName);
            objStrm = new ObjectInputStream(strm);
            Object isLinkedList = objStrm.readObject();
            if((isLinkedList instanceof DSALinkedList))
            {
                inObj = (DSALinkedList<E>)isLinkedList;
            }
            else
            {
                throw new ClassNotFoundException("Not a linked list");
            }
            objStrm.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return inObj;
    }
}
